package org.openjfx.view;

import ir.sharif.ap.hw4.event.GetGameStatus;
import ir.sharif.ap.hw4.event.ShowGamesToSpectateEvent;
import ir.sharif.ap.hw4.event.ShowScoreboardEvent;
import ir.sharif.ap.hw4.model.Board;
import ir.sharif.ap.hw4.model.User;
import ir.sharif.ap.hw4.util.Loop;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.openjfx.listener.EventListener;
import org.openjfx.view.boardVerification.BoardCheckScene;
import org.openjfx.view.gameScene.page.GamePage;
import org.openjfx.view.login.LoginPanel;
import org.openjfx.view.mainmenu.MainMenu;
import org.openjfx.view.personalPage.PersonalPage;
import org.openjfx.view.scoreboard.Scoreboard;
import org.openjfx.view.spectateList.SpectateList;
import org.openjfx.view.waitingRoom.WaitingRoom;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class GraphicalAgent {

    private final Stage stage;
    private final EventListener listener;
    private Loop loop;
    private int playerId;
    private GamePage page;
    private BoardCheckScene boardCheckScene;
    private Scoreboard scoreboard;
    private SpectateList spectateList;
    private boolean isOnScoreboard;

    public GraphicalAgent(EventListener listener, Stage stage) {
        this.listener = listener;
        this.stage = stage;
    }

    public void initialize() {
        Platform.runLater(stage::show);
    }

    public void showLogin() {
        LoginPanel panel = new LoginPanel(listener);
        try {
            panel.initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Platform.runLater(() -> {
            stage.setScene(new Scene(panel.getRoot()));
        });
        initialize();
    }

    public void goToMainMenu() {
        if (isOnScoreboard) {
            isOnScoreboard = false;
        }
        if (loop != null) {
            loop.stop();
        }
        page = null;
        scoreboard = null;
        spectateList = null;
        MainMenu mainMenu = new MainMenu(listener);
        try {
            mainMenu.create();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Platform.runLater(() -> {
            stage.setScene(new Scene(mainMenu.getRoot()));
        });
    }

    public void startGame(Board board1, Board board2, int turnId, boolean isSpectator, int timeLeft) {

        if (loop != null) {
            loop.stop();
        }
        loop = new Loop(1, this::sendUpdateRequest);
        loop.start();
        boardCheckScene = null;
        page = new GamePage(listener, playerId, isSpectator);
        try {
            page.generate(board1, board2, turnId, timeLeft);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Platform.runLater(() -> {
            stage.setScene(new Scene(page.getRoot()));
        });

    }

    public void showInputError(String error) {
        JOptionPane.showMessageDialog(null, error);
    }

    public void updateBoard(Board board1, Board board2, int turnId, int timeLeft) {
        Platform.runLater(() -> page.update(board1, board2, turnId, timeLeft));
    }

    public void sendUpdateRequest() {
        listener.listen(new GetGameStatus());
    }

    public void goToWait() {
        WaitingRoom waitingRoom = new WaitingRoom();
        try {
            waitingRoom.generate();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Platform.runLater(() -> stage.setScene(new Scene(waitingRoom.getRoot())));
    }

    public void goToBoardCheck(Board board, int i, int timeLeft) {
        loop = new Loop(1, this::sendUpdateRequest);
        loop.start();
        boardCheckScene = new BoardCheckScene(listener, i);
        try {
            boardCheckScene.generate(board, timeLeft);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Platform.runLater(() -> stage.setScene(new Scene(boardCheckScene.getRoot())));
    }

    public void updateCheckBoard(Board board, int i, int timeLeft) {
        boardCheckScene.update(board, i, timeLeft);
    }

    public void finishGame(boolean won) {
        if (loop != null) {
            loop.stop();
        }
        if (won) {
            JOptionPane.showMessageDialog(null, "you won!");
        } else {
            JOptionPane.showMessageDialog(null, "you lost :(");
        }
        page = null;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void showScoreBoard(LinkedList<User> users) {
        isOnScoreboard = true;
        scoreboard = new Scoreboard(listener);
        scoreboard.generate(users);
        Platform.runLater(() -> stage.setScene(new Scene(scoreboard.getRoot())));
        if (loop != null) {
            loop.stop();
        }
        loop = new Loop(1, () -> listener.listen(new ShowScoreboardEvent()));
        loop.start();
    }

    public void updateScoreBoard(LinkedList<User> users) {
        Platform.runLater(() -> scoreboard.update(users));
    }

    public void showPersonalPage(User user) {
        PersonalPage page = new PersonalPage(listener);
        page.generate(user);
        Platform.runLater(() -> stage.setScene(new Scene(page.getRoot())));
    }

    public void showGamesToSpectate(HashMap<Integer, int[]> hashMap) {
        spectateList = new SpectateList(listener);
        spectateList.generate(hashMap);
        Platform.runLater(() -> stage.setScene(new Scene(spectateList.getRoot())));
        if (loop != null) { loop.stop(); }
        loop = new Loop(1, () -> listener.listen(new ShowGamesToSpectateEvent()));
        loop.start();
    }

    public void updateSpectateList(HashMap<Integer, int[]> hashMap) {
        Platform.runLater(() -> spectateList.update(hashMap));
    }

    public boolean isOnScoreboard() {
        return isOnScoreboard;
    }
}