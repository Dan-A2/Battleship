package controller.game.battleship;

import controller.ClientHandler;
import controller.game.Game;
import controller.game.GameLobby;
import ir.sharif.ap.hw4.model.Board;
import ir.sharif.ap.hw4.model.Ship;
import ir.sharif.ap.hw4.model.User;
import ir.sharif.ap.hw4.util.Loop;
import ir.sharif.ap.hw4.util.Status;
import logic.BoardController;
import logic.TimerClass;
import util.Side;

import java.util.LinkedList;

public class BattleShipGame implements Game {

    private final ClientHandler user1, user2;
    private final User player1, player2;
    private final Board board1, board2;
    private final LinkedList<ClientHandler> spectators = new LinkedList<>();
    private Loop loop;
    private TimerClass timer;
    private Side sideToTurn;
    private Integer winnerID;

    public BattleShipGame(ClientHandler user1, ClientHandler user2) {
        this.user1 = user1; this.player1 = user1.getPlayer();
        this.user2 = user2; this.player2 = user2.getPlayer();
        this.sideToTurn = Side.Player1;
        this.timer = new TimerClass(50);
        this.loop = new Loop(1, this::checkTimeFinish);
        board1 = player1.getBoard();
        board2 = player2.getBoard();
        timer.start();
        loop.start();
    }

    @Override
    public Board getBoard1() {
        return board1;
    }

    @Override
    public Board getBoard2() {
        return board2;
    }

    @Override
    public synchronized void click(int x, int y, Side side) {
        if (side != sideToTurn || winnerID != null) {
            System.out.println("not your turn :|");
            return;
        }
        if (side == Side.Player1) {
            if (board2.getCells()[x][y].isShot()) {
                System.out.println("this cell is shot before " + x + " : " + y);
                return;
            }
            boolean shouldChangeTurn = !board2.getCells()[x][y].hasShip();
            new BoardController().shoot(board2, board2.getCells()[x][y]);
            if (checkFinish(sideToTurn)) {
                winnerID = player1.getId();
                finishGame();
            } else if (shouldChangeTurn) {
                System.out.println("changing turn");
                changeTurn(side);
            }
        } else {
            if (board1.getCells()[x][y].isShot()) {
                System.out.println("this cell is shot before " + x + " : " + y);
                return;
            }
            boolean shouldChangeTurn = !board1.getCells()[x][y].hasShip();
            new BoardController().shoot(board1, board1.getCells()[x][y]);
            if (checkFinish(sideToTurn)) {
                winnerID = player2.getId();
                finishGame();
            } else if (shouldChangeTurn) {
                System.out.println("changing turn");
                changeTurn(side);
            }
        }
    }

    private void changeTurn(Side side) {
        sideToTurn = side.getOther();
        timer.setTime(50);
    }

    private void finishGame() {
        user1.setStatus(Status.GameFinished);
        user2.setStatus(Status.GameFinished);
        user1.setSide(null);
        user2.setSide(null);
        user1.setLeftAttempts(3);
        user2.setLeftAttempts(3);
        player1.setReady(false);
        player2.setReady(false);
        player1.setBoard(null);
        player2.setBoard(null);
        timer.stop();
    }

    private void checkTimeFinish() {
        if (timer.getTime() <= 0) {
            changeTurn(sideToTurn);
        }
    }

    @Override
    public Integer getWinnerId() {
        return winnerID;
    }

    @Override
    public int userInTurnId() {
        if (sideToTurn == Side.Player1) {
            return player1.getId();
        } else {
            return player2.getId();
        }
    }

    @Override
    public int timeLeft() {
        return timer.getTime();
    }

    public boolean checkFinish(Side side) {
        if (side == Side.Player1) {
            if (getUser2RemainingShips() != 0) {
                return false;
            }
            GameLobby.removeGame(this);
            spectators.clear();
            return true;
        } else {
            if (getUser1RemainingShips() != 0) {
                return false;
            }
            GameLobby.removeGame(this);
            spectators.clear();
            return true;
        }
    }

    public LinkedList<ClientHandler> getSpectators() {
        return spectators;
    }

    public int getUser1RemainingShips() {
        int ships = 0;
        for (Ship ship : board1.getShips()) {
            if (!ship.isSunk()) {
                ships++;
            }
        }
        return ships;
    }

    public int getUser2RemainingShips() {
        int ships = 0;
        for (Ship ship : board2.getShips()) {
            if (!ship.isSunk()) {
                ships++;
            }
        }
        return ships;
    }
}