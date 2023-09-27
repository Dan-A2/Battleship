package org.openjfx.view.login;

import ir.sharif.ap.hw4.event.SignInEvent;
import ir.sharif.ap.hw4.event.SignUpEvent;
import ir.sharif.ap.hw4.util.Config;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.openjfx.Tabah;
import org.openjfx.listener.EventListener;
import org.openjfx.util.Command;

import java.io.IOException;

public class LoginPanel {

    private Parent root;
    private EventListener listener;

    public LoginPanel(EventListener listener) {
        this.listener = listener;
    }

    public void initialize() throws IOException {

        FXMLLoader loader = new FXMLLoader(Tabah.class.getResource(Config.getConfig("addresses").getProperty(String.class,"loginPanel")));
        root = loader.load();
        LoginView view = loader.getController();
        view.setListener(command -> {
            String username, password;
            if (!(username = view.getUsername()).equals("") && !(password = view.getPassword()).equals("")) {
                if (command == Command.SignIn) {
                    SignInEvent event = new SignInEvent(username, password);
                    listener.listen(event);
                } else if (command == Command.SignUp) {
                    SignUpEvent event = new SignUpEvent(username, password);
                    listener.listen(event);
                }
            }
        });

    }

    public Parent getRoot() {
        return root;
    }
}