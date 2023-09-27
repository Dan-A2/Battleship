package org.openjfx.view.personalPage;

import ir.sharif.ap.hw4.event.GoToMainMenuEvent;
import ir.sharif.ap.hw4.model.User;
import ir.sharif.ap.hw4.util.Config;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.openjfx.Tabah;
import org.openjfx.listener.EventListener;
import org.openjfx.util.Command;
import org.openjfx.util.CommandListener;

import java.io.IOException;

public class PersonalPage {

    private Parent root;
    private final EventListener listener;

    public PersonalPage(EventListener listener) {
        this.listener = listener;
    }

    public void generate(User player) {

        FXMLLoader loader = new FXMLLoader(Tabah.class.getResource(Config.getConfig("addresses").getProperty(String.class,"personal")));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PersonalPageView view = loader.getController();
        view.getUsernameField().setText(player.getUsername());
        view.getScoreField().setText(Integer.toString(player.getGamesWon()- player.getGamesLost()));
        view.getWinField().setText(Integer.toString(player.getGamesWon()));
        view.getLoseField().setText(Integer.toString(player.getGamesLost()));
        view.setListener(command -> { // back
            listener.listen(new GoToMainMenuEvent());
        });

    }

    public Parent getRoot() {
        return root;
    }
}