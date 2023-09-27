package org.openjfx.view.personalPage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.openjfx.util.Command;
import org.openjfx.util.CommandListener;

public class PersonalPageView {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField scoreField;

    @FXML
    private TextField winField;

    @FXML
    private TextField loseField;

    @FXML
    private Button backBtn;

    private CommandListener listener;

    public void setListener(CommandListener listener) {
        this.listener = listener;
    }

    @FXML
    void getBack(ActionEvent event) {
        listener.listenCommand(Command.Back);
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public TextField getScoreField() {
        return scoreField;
    }

    public TextField getWinField() {
        return winField;
    }

    public TextField getLoseField() {
        return loseField;
    }
}