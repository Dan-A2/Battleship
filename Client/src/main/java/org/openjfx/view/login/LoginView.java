package org.openjfx.view.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.openjfx.util.Command;
import org.openjfx.util.CommandListener;

public class LoginView {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button signUpBtn;

    @FXML
    private Button signInBtn;

    private CommandListener listener;

    public void setListener(CommandListener listener) {
        this.listener = listener;
    }

    @FXML
    void logIn(ActionEvent event) { // sign up
        listener.listenCommand(Command.SignUp);
    }

    @FXML
    void signIn(ActionEvent event) {
        listener.listenCommand(Command.SignIn);
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public String getUsername() {
        return usernameField.getText();
    }
}