package org.openjfx.view.scoreboard;

import ir.sharif.ap.hw4.event.GoToMainMenuEvent;
import ir.sharif.ap.hw4.model.User;
import ir.sharif.ap.hw4.util.Config;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.openjfx.Tabah;
import org.openjfx.listener.EventListener;
import org.openjfx.util.Command;
import org.openjfx.util.CommandListener;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;

public class Scoreboard {

    private final EventListener listener;
    private Parent root;
    private ScoreboardView view;

    public Scoreboard(EventListener listener) {
        this.listener = listener;
    }

    public void generate(LinkedList<User> users) {

        users.sort(Comparator.comparingInt(User::getScore));
        FXMLLoader loader = new FXMLLoader(Tabah.class.getResource(Config.getConfig("addresses").getProperty(String.class,"scoreBoard")));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        view = loader.getController();
        view.getUsersBox().setSpacing(25);
        view.setListener(command -> {
            if (command == Command.Back) {
                listener.listen(new GoToMainMenuEvent());
            }
        });
        for (User user : users) {
            UserComponent component = new UserComponent();
            component.generate(user);
            view.getUsersBox().getChildren().add(component.getRoot());
        }

    }

    public void update(LinkedList<User> users) {

        users.sort(Comparator.comparingInt(User::getScore));
        view.getUsersBox().getChildren().clear();
        for (User user : users) {
            UserComponent component = new UserComponent();
            component.generate(user);
            view.getUsersBox().getChildren().add(component.getRoot());
        }

    }

    public Parent getRoot() {
        return root;
    }
}