package controller;

import controller.game.Game;
import controller.game.GameLobby;
import controller.game.WaitingRoom;
import controller.game.battleship.BattleShipGame;
import controller.game.boardChoose.BoardChooseRoom;
import database.BoardDataBase;
import database.UserDatabase;
import ir.sharif.ap.hw4.event.*;
import ir.sharif.ap.hw4.model.Board;
import ir.sharif.ap.hw4.model.User;
import ir.sharif.ap.hw4.response.*;
import ir.sharif.ap.hw4.util.Config;
import ir.sharif.ap.hw4.util.Status;
import logic.TimerClass;
import logic.UserController;
import util.Side;

import java.util.HashMap;
import java.util.LinkedList;

public class ClientHandler extends Thread implements EventVisitor {

    private final ResponseSender sender;
    private final GameLobby lobby;
    private final WaitingRoom room;
    private final int token;
    private Game game;
    private BoardChooseRoom boardRoom;
    private User player;
    private Side side;
    private Status status;
    private int leftAttempts = 3;

    public ClientHandler(ResponseSender sender, GameLobby lobby, WaitingRoom room, int token) {
        this.sender = sender;
        this.lobby = lobby;
        this.room = room;
        this.token = token;
    }

    @Override
    public void run() {
        try {
            while (true) {
                EvenToken evenToken = sender.getEvenToken();
                if (evenToken.getToken() == null) {
                    sender.sendResponse(new GetTokenResponse(token));
                } else if (evenToken.getToken() == token) {
                    sender.sendResponse(evenToken.getEvent().visit(this));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            player.setOnline(false);
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public Response visitSignIn(SignInEvent signInEvent) {
        String tmpUsername = signInEvent.getUsername();
        String tmpPass = signInEvent.getPassword();
        UserController controller = new UserController();
        System.out.println(controller.isUserValid(tmpUsername, tmpPass));
        if (controller.isUserValid(tmpUsername, tmpPass)) {
            player = controller.getUser(tmpUsername);
            controller.getUser(tmpUsername).setOnline(true);
            return new SignIn_UpResponse(controller.getUser(tmpUsername), null);
        } else {
            return new SignIn_UpResponse(null, Config.getConfig("massages").getProperty(String.class, "signIn"));
        }
    }

    @Override
    public Response visitSignUp(SignUpEvent signUpEvent) {
        String tmpUsername = signUpEvent.getUsername();
        UserController controller = new UserController();
        if (controller.isUsernameRepeated(tmpUsername)) {
            return new SignIn_UpResponse(null, Config.getConfig("massages").getProperty(String.class, "signUp1"));
        } else if (signUpEvent.getPassword().equals("")) {
            return new SignIn_UpResponse(null, Config.getConfig("massages").getProperty(String.class, "signUp2"));
        } else {
            player = controller.createUser(tmpUsername, signUpEvent.getPassword());
            player.setOnline(true);
            return new SignIn_UpResponse(player, null);
        }
    }

    @Override
    public Response showSpectate() {
        status = Status.SpectateList;
        return getStatus();
    }

    @Override
    public Response goToMainMenu() {
        status = null;
        return new ShowMainMenuResponse();
    }

    @Override
    public Response clickBoard(ClickEvent clickEvent) {
        game.click(clickEvent.getX(), clickEvent.getY(), side);
        return getStatus();
    }

    @Override
    public Response getStatus() {
        switch (status) {
            case Spectating:
                return new BoardResponse(game.getBoard1(), game.getBoard2(), game.userInTurnId(), true, game.timeLeft());
            case SpectateList:
                HashMap<Integer, int[]> games = new HashMap<>();
                for (int i = 0; i < GameLobby.getGamesOnline().size(); i++) {
                    BattleShipGame tmp = GameLobby.getGamesOnline().get(i);
                    games.put(i, new int[]{tmp.getUser1RemainingShips(), tmp.getUser2RemainingShips()});
                }
                return new ShowSpectateListResponse(games);
            case BoardEdit:
                return new GoCheckBoardResponse(boardRoom.getBoard(), 1, leftAttempts, boardRoom.getTimer().getTime()); // no matter
            case RegenerateBoard:
                return new GoCheckBoardResponse(boardRoom.getBoard(), 2, leftAttempts, boardRoom.getTimer().getTime());
            case TimeFinishedBoard:
                return new TimeFinishedBoardResponse();
            case Waiting:
                return new WaitForTheOtherUserResponse();
            case Playing:
                return new BoardResponse(game.getBoard1(), game.getBoard2(), game.userInTurnId(), false, game.timeLeft());
            case GameFinished:
                if (game.getWinnerId() == player.getId()) {
                    player.winGame();
                    UserDatabase.saveChanges();
                    game = null;
                    return new GameFinishedResponse(true);
                } else {
                    player.loseGame();
                    UserDatabase.saveChanges();
                    return new GameFinishedResponse(false);
                }
        }
        return null;
    }

    @Override
    public Response regenerateBoard() {
        leftAttempts--;
        if (leftAttempts == 0) {
            player.setReady(true);
            room.getQueue().remove(this);
            lobby.startGame(this);
            return getStatus();
        }
        boardRoom.Regenerate();
        status = Status.RegenerateBoard;
        return getStatus();
    }

    @Override
    public Response goToBoardCheck() {
        status = Status.BoardEdit;
        room.knockKnock(this);
        boardRoom = new BoardChooseRoom(this, player);
        return getStatus();
    }

    @Override
    public Response readyPressed() {
        if (status == Status.BoardEdit || status == Status.RegenerateBoard || status == Status.TimeFinishedBoard) {
            boardRoom.setReady();
            room.getQueue().remove(this);
            lobby.startGame(this);
        }
        return getStatus();
    }

    @Override
    public Response getToken() {
        System.out.println("returning token");
        return new GetTokenResponse(token);
    }

    @Override
    public Response showScoreboard() {
        return new ShowScoreboardResponse(UserDatabase.getUsers());
    }

    @Override
    public Response goToPersonal() {
        return new ShowPersonalResponse(player);
    }

    @Override
    public Response spectateGame(SpectateGameEvent spectateGameEvent) {
        status = Status.Spectating;
        try {
            game = GameLobby.getGamesOnline().get(spectateGameEvent.getIndex());
        } catch (Exception e) {
            e.printStackTrace();
            return goToMainMenu();
        }
        return getStatus();
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public User getPlayer() {
        return player;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setLeftAttempts(int leftAttempts) {
        this.leftAttempts = leftAttempts;
    }
}