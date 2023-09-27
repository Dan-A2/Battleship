package org.openjfx.view.spectateList;

import ir.sharif.ap.hw4.event.SpectateGameEvent;
import ir.sharif.ap.hw4.util.Config;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.openjfx.Tabah;
import org.openjfx.listener.EventListener;
import org.openjfx.util.Command;
import org.openjfx.util.CommandListener;

import java.io.IOException;

public class GameComponent {

    private final EventListener listener;
    private Parent root;

    public GameComponent(EventListener listener) {
        this.listener = listener;
    }

    public void generate(int index, int user1Ships, int user2Ships) {

        FXMLLoader loader = new FXMLLoader(Tabah.class.getResource(Config.getConfig("addresses").getProperty(String.class,"gameComp")));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GameComponentView view = loader.getController();
        view.getGameNumLabel().setText("Game " + index);
        view.getUser1ShipCountLabel().setText(Integer.toString(user1Ships));
        view.getUser2ShipCountLabel().setText(Integer.toString(user2Ships));
        view.setListener(command -> {
            if (command == Command.Spectate) {
                listener.listen(new SpectateGameEvent(index));
            }
        });

    }

    public Parent getRoot() {
        return root;
    }
}