package org.openjfx.view.spectateList;

import ir.sharif.ap.hw4.event.GoToMainMenuEvent;
import ir.sharif.ap.hw4.util.Config;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.openjfx.Tabah;
import org.openjfx.listener.EventListener;
import org.openjfx.util.Command;

import java.io.IOException;
import java.util.HashMap;

public class SpectateList {

    private final EventListener listener;
    private Parent root;
    private SpectateListView view;

    public SpectateList(EventListener listener) {
        this.listener = listener;
    }

    public void generate(HashMap<Integer, int[]> hashMap) {
        FXMLLoader loader = new FXMLLoader(Tabah.class.getResource(Config.getConfig("addresses").getProperty(String.class,"spectateList")));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        view = loader.getController();
        view.getGamesBox().setSpacing(25);
        view.setListener(command -> {
            if (command == Command.Back) {
                listener.listen(new GoToMainMenuEvent());
            }
        });
        update(hashMap);
    }

    public void update(HashMap<Integer, int[]> hashMap) {

        view.getGamesBox().getChildren().clear();
        for (Integer gameIndex : hashMap.keySet()) {
            GameComponent component = new GameComponent(listener);
            component.generate(gameIndex, hashMap.get(gameIndex)[0], hashMap.get(gameIndex)[1]);
            view.getGamesBox().getChildren().add(component.getRoot());
        }

    }

    public Parent getRoot() {
        return root;
    }
}