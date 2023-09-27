package org.openjfx.listener;

import ir.sharif.ap.hw4.event.EvenToken;
import ir.sharif.ap.hw4.event.Event;
import ir.sharif.ap.hw4.event.RequestToken;
import ir.sharif.ap.hw4.event.SetReadyEvent;
import ir.sharif.ap.hw4.model.Board;
import ir.sharif.ap.hw4.model.User;
import ir.sharif.ap.hw4.response.Response;
import ir.sharif.ap.hw4.response.ResponseVisitor;
import ir.sharif.ap.hw4.util.Loop;
import ir.sharif.ap.hw4.util.Status;
import javafx.stage.Stage;
import org.openjfx.view.GraphicalAgent;
import org.openjfx.view.waitingRoom.WaitingRoom;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MainController implements ResponseVisitor {

    private final EventSender sender;
    private final List<Event> events;
    private final Loop loop;
    private final GraphicalAgent graphicalAgent;
    private Status status;
    private Integer token;

    public MainController(EventSender sender, Stage primaryStage) {
        this.sender = sender;
        this.events = new LinkedList<>();
        this.loop = new Loop(2, this::sendEvents);
        this.graphicalAgent = new GraphicalAgent(this::addEvent, primaryStage);
    }

    public void start() {
        addEvent(new RequestToken());
        loop.start();
        graphicalAgent.showLogin();
    }

    public void addEvent(Event event) {
        synchronized (events) {
            events.add(event);
        }
    }

    public void sendEvents() {
        List<Event> tmp;
        synchronized (events) {
            tmp = new LinkedList<>(events);
            events.clear();
        }
        for (Event event : tmp) {
            try {
                Response response = sender.send(new EvenToken(event, token));
                response.visit(this);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

    @Override
    public void visitUserSignIn_Up(User user, String error) {
        if (user != null) {
            graphicalAgent.setPlayerId(user.getId());
            graphicalAgent.goToMainMenu();
        } else {
            graphicalAgent.showInputError(error);
        }
    }

    @Override
    public void visitBoard(Board board1, Board board2, int turnId, boolean isSpectator, int timeLeft) {
        if (isSpectator) {
            if (status == Status.Spectating) {
                graphicalAgent.updateBoard(board1, board2, turnId, timeLeft);
            } else if (status == Status.SpectateList){
                System.out.println("changing status to spectating");
                status = Status.Spectating;
                graphicalAgent.startGame(board1, board2, turnId, true, timeLeft);
            }
        } else {
            if (status != Status.Playing) {
                graphicalAgent.startGame(board1, board2, turnId, false, timeLeft);
                status = Status.Playing;
            } else {
                graphicalAgent.updateBoard(board1, board2, turnId, timeLeft);
            }
        }
    }

    @Override
    public void showMainMenu() {
        status = null;
        graphicalAgent.goToMainMenu();
    }

    @Override
    public void showSpectateList(HashMap<Integer, int[]> hashMap) {
        if (status != Status.SpectateList) {
            status = Status.SpectateList;
            graphicalAgent.showGamesToSpectate(hashMap);
        } else { // updating list
            graphicalAgent.updateSpectateList(hashMap);
        }
    }

    @Override
    public void goCheckBoard(Board board, int i, int timeLeft) {
        if (status == null) {
            graphicalAgent.goToBoardCheck(board, i, timeLeft);
            status = Status.BoardEdit;
        } else if (status == Status.BoardEdit) {
            graphicalAgent.updateCheckBoard(board, i, timeLeft);
        }
    }

    @Override
    public void updateCheckBoard(Board board, int i, int timeLeft) {
        status = Status.RegenerateBoard;
        graphicalAgent.updateCheckBoard(board, i, timeLeft);
    }

    @Override
    public void waitForOtherUser() {
        if (status != Status.Waiting) {
            status = Status.Waiting;
            graphicalAgent.goToWait();
        }
    }

    @Override
    public void visitFinishGame(boolean b) {
        status = null;
        graphicalAgent.finishGame(b);
        graphicalAgent.goToMainMenu();
    }

    @Override
    public void visitToken(int token) {
        this.token = token;
    }

    @Override
    public void showScoreboard(LinkedList<User> users) {
        if (graphicalAgent.isOnScoreboard()) {
            graphicalAgent.updateScoreBoard(users);
        } else {
            graphicalAgent.showScoreBoard(users);
        }
    }

    @Override
    public void showPersonal(User user) {
        graphicalAgent.showPersonalPage(user);
    }

    @Override
    public void stopSpectate() {
        status = null;
        graphicalAgent.goToMainMenu();
    }

    @Override
    public void timeFinishedBoard() {
        addEvent(new SetReadyEvent());
    }
}