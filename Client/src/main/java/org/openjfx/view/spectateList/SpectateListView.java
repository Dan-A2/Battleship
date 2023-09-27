package org.openjfx.view.spectateList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import org.openjfx.util.Command;
import org.openjfx.util.CommandListener;

public class SpectateListView {

    @FXML
    private VBox gamesBox;

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

    public VBox getGamesBox() {
        return gamesBox;
    }

    public Button getBackBtn() {
        return backBtn;
    }
}