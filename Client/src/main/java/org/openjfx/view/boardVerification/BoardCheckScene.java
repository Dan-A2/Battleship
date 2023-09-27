package org.openjfx.view.boardVerification;

import ir.sharif.ap.hw4.event.RegenerateBoardEvent;
import ir.sharif.ap.hw4.event.SetReadyEvent;
import ir.sharif.ap.hw4.model.Board;
import ir.sharif.ap.hw4.model.Cell;
import ir.sharif.ap.hw4.util.Config;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.openjfx.Tabah;
import org.openjfx.listener.EventListener;
import org.openjfx.util.Command;
import org.openjfx.util.CommandListener;
import org.openjfx.util.RelationToBoard;
import org.openjfx.view.gameScene.cell.CellPane;

import java.io.IOException;

public class BoardCheckScene {

    private Parent root;
    private EventListener listener;
    private BoardCheckView view;
    private int leftAttempts;

    public BoardCheckScene(EventListener listener, int leftAttempts) {
        this.listener = listener;
        this.leftAttempts = leftAttempts;
    }

    public void generate(Board board, int timeLeft) throws IOException {

        FXMLLoader loader = new FXMLLoader(Tabah.class.getResource(Config.getConfig("addresses").getProperty(String.class,"boardCheckScene")));
        root = loader.load();
        view = loader.getController();
        view.getBoardPane().getChildren().add(createBoard(board));
        view.getLeftAttemptsLabel().setText(Integer.toString(leftAttempts));
        view.getTimeLabel().setText(Integer.toString(timeLeft));
        view.setListener(command -> {
            if (command == Command.Regenerate) {
                listener.listen(new RegenerateBoardEvent());
            } else if (command == Command.Start) {
                listener.listen(new SetReadyEvent()); // readyPressed
            }
        });

    }

    public void update(Board newBoard, int leftAttempts, int timeLeft) {
        String tmp = Integer.toString(leftAttempts);
        Platform.runLater(() -> {
            view.getBoardPane().getChildren().clear();
            view.getLeftAttemptsLabel().setText(tmp);
            view.getBoardPane().getChildren().add(createBoard(newBoard));
            view.getTimeLabel().setText(Integer.toString(timeLeft));
        });
    }

    private VBox createBoard(Board board) {
        VBox box2 = new VBox();
        for (int i = 0; i <= 9; i++) {
            HBox box = new HBox();
            for (int j = 0; j <= 9; j++) {
                Cell cell = board.getCells()[i][j];
                box.getChildren().add(new CellPane(cell, RelationToBoard.Spectator, listener));
            }
            box2.getChildren().add(box);
        }
        return box2;
    }

    public Parent getRoot() {
        return root;
    }
}