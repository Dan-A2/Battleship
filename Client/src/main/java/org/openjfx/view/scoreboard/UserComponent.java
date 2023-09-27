package org.openjfx.view.scoreboard;

import ir.sharif.ap.hw4.model.User;
import ir.sharif.ap.hw4.util.Config;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import org.openjfx.Tabah;

import java.io.IOException;

public class UserComponent {

    private Parent root;
    private UserComponentView view;

    public void generate(User user) {

        FXMLLoader loader = new FXMLLoader(Tabah.class.getResource(Config.getConfig("addresses").getProperty(String.class,"userComp")));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        view = loader.getController();
        update(user);

    }

    public void update(User user) {

        view.getUsernameLabel().setText(user.getUsername());
        if (user.isOnline()) {
            view.getOnlineStatusRec().setFill(Color.GREEN);
        } else {
            view.getOnlineStatusRec().setFill(Color.RED);
        }
        view.getScoreLabel().setText(Integer.toString(user.getScore()));

    }

    public Parent getRoot() {
        return root;
    }
}