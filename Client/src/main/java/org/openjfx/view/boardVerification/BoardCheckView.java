package org.openjfx.view.boardVerification;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.openjfx.util.Command;
import org.openjfx.util.CommandListener;

public class BoardCheckView {

    @FXML
    private Pane boardPane;

    @FXML
    private Label timeLabel;

    @FXML
    private Button regenerateBtn;

    @FXML
    private Button startGameBtn;

    @FXML
    private Label infoLabel;

    @FXML
    private Label leftAttemptsLabel;

    private CommandListener listener;

    public void setListener(CommandListener listener) {
        this.listener = listener;
    }

    @FXML
    void regenerate(ActionEvent event) {
        listener.listenCommand(Command.Regenerate);
    }

    @FXML
    void startGame(ActionEvent event) {
        listener.listenCommand(Command.Start);
    }

    public Pane getBoardPane() {
        return boardPane;
    }

    public Label getTimeLabel() {
        return timeLabel;
    }

    public Label getInfoLabel() {
        return infoLabel;
    }

    public Label getLeftAttemptsLabel() {
        return leftAttemptsLabel;
    }
}