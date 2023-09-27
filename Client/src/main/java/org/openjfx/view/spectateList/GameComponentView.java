package org.openjfx.view.spectateList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.openjfx.util.Command;
import org.openjfx.util.CommandListener;

public class GameComponentView {

    @FXML
    private Button spectateBtn;

    @FXML
    private Label user1ShipCountLabel;

    @FXML
    private Label user2ShipCountLabel;

    @FXML
    private Label gameNumLabel;

    @FXML
    void spectate(ActionEvent event) {
        listener.listenCommand(Command.Spectate);
    }

    private CommandListener listener;

    public void setListener(CommandListener listener) {
        this.listener = listener;
    }

    public Label getUser1ShipCountLabel() {
        return user1ShipCountLabel;
    }

    public Label getUser2ShipCountLabel() {
        return user2ShipCountLabel;
    }

    public Label getGameNumLabel() {
        return gameNumLabel;
    }
}