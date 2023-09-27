package org.openjfx.view.gameScene.page;

import ir.sharif.ap.hw4.event.GoToMainMenuEvent;
import ir.sharif.ap.hw4.model.Board;
import ir.sharif.ap.hw4.util.Config;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import org.openjfx.Tabah;
import org.openjfx.listener.EventListener;
import org.openjfx.util.Command;
import org.openjfx.util.RelationToBoard;
import org.openjfx.view.gameScene.board.BoardPane;

import java.io.IOException;

public class GamePage {

    private final EventListener listener;
    private Parent root;
    private final int myId;
    private GamePageView view;
    private final boolean isSpectator;

    public GamePage(EventListener listener, int myId, boolean isSpectator) {
        this.listener = listener;
        this.myId = myId;
        this.isSpectator = isSpectator;
    }

    public void generate(Board board1, Board board2, int turnId, int timeLeft) throws IOException {

        FXMLLoader loader = new FXMLLoader(Tabah.class.getResource(Config.getConfig("addresses").getProperty(String.class,"gamePage")));
        root = loader.load();
        view = loader.getController();
        if (isSpectator) {
            view.getBackBtn().setVisible(true);
            view.setListener(command -> {
                if (command == Command.Back) {
                    listener.listen(new GoToMainMenuEvent());
                }
            });
        } else {
            view.getBackBtn().setVisible(false);
        }
        update(board1, board2, turnId, timeLeft);

    }

    public void update(Board board1, Board board2, int turnId, int timeLeft) {
        BoardPane myBoard, enemyBoard;
        view.getTimeLabel().setText(Integer.toString(timeLeft));
        if (myId == board1.getOwnerId()) {
            myBoard = new BoardPane(board1, RelationToBoard.Mine, listener);
            enemyBoard = new BoardPane(board2, RelationToBoard.Enemy, listener);
        } else if (myId == board2.getOwnerId()) {
            myBoard = new BoardPane(board2, RelationToBoard.Mine, listener);
            enemyBoard = new BoardPane(board1, RelationToBoard.Enemy, listener);
        } else {
            myBoard = new BoardPane(board1, RelationToBoard.Spectator, listener);
            enemyBoard = new BoardPane(board2, RelationToBoard.Spectator, listener);
            view.getTimeLabel().setText("3");
        }
        if (myId == turnId) {
            view.getTurnRec().setFill(Color.GREEN);
        } else {
            view.getTurnRec().setFill(Color.RED);
        }
        view.getMyBoardPane().getChildren().add(myBoard);
        view.getEnemyBoardPane().getChildren().add(enemyBoard);
    }

    public Parent getRoot() {
        return root;
    }
}