package org.openjfx.view.mainmenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.openjfx.util.Command;
import org.openjfx.util.CommandListener;

public class MainMenuView {
    @FXML
    private Button startBtn;

    @FXML
    private Button spectateBtn;

    @FXML
    private Button scoreBoardBtn;

    @FXML
    private Button infoBtn;

    private CommandListener listener;

    public void setListener(CommandListener listener) {
        this.listener = listener;
    }

    @FXML
    void spectate(ActionEvent event) {
        listener.listenCommand(Command.Spectate);
    }

    @FXML
    void startGame(ActionEvent event) {
        listener.listenCommand(Command.Start);
    }

    @FXML
    void showInfo(ActionEvent event) {
        listener.listenCommand(Command.Info);
    }

    @FXML
    void showScoreboard(ActionEvent event) {
        listener.listenCommand(Command.Scoreboard);
    }
}