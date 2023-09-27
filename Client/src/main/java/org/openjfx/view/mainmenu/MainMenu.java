package org.openjfx.view.mainmenu;

import ir.sharif.ap.hw4.event.*;
import ir.sharif.ap.hw4.util.Config;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.openjfx.Tabah;
import org.openjfx.listener.EventListener;
import org.openjfx.util.Command;

import java.io.IOException;

public class MainMenu {

    private Parent root;
    private final EventListener listener;

    public MainMenu(EventListener listener) {
        this.listener = listener;
    }

    public void create() throws IOException {

        FXMLLoader loader = new FXMLLoader(Tabah.class.getResource(Config.getConfig("addresses").getProperty(String.class,"mainmenu")));
        root = loader.load();
        MainMenuView view = loader.getController();
        view.setListener(command -> {
            if (command == Command.Start) {
                listener.listen(new GoCheckBoardEvent());
            } else if (command == Command.Spectate) {
                listener.listen(new ShowGamesToSpectateEvent());
            } else if (command == Command.Info) {
                listener.listen(new GoToPGEvent());
            } else if (command == Command.Scoreboard) {
                listener.listen(new ShowScoreboardEvent());
            }
        });

    }

    public Parent getRoot() {
        return root;
    }
}