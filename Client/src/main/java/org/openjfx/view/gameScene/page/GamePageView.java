package org.openjfx.view.gameScene.page;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import org.openjfx.util.Command;
import org.openjfx.util.CommandListener;

public class GamePageView {
    @FXML
    private Pane myBoardPane;

    @FXML
    private Pane enemyBoardPane;

    @FXML
    private Label timeLabel;

    @FXML
    private Rectangle turnRec;

    @FXML
    private Button backBtn;

    @FXML
    void getBack(ActionEvent event) {
        listener.listenCommand(Command.Back);
    }

    private CommandListener listener;

    public void setListener(CommandListener listener) {
        this.listener = listener;
    }

    public Pane getMyBoardPane() {
        return myBoardPane;
    }

    public Pane getEnemyBoardPane() {
        return enemyBoardPane;
    }

    public Label getTimeLabel() {
        return timeLabel;
    }

    public Rectangle getTurnRec() {
        return turnRec;
    }

    public Button getBackBtn() {
        return backBtn;
    }
}