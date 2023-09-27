package org.openjfx.view.waitingRoom;

import ir.sharif.ap.hw4.util.Config;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.openjfx.Tabah;

import java.io.IOException;

public class WaitingRoom {

    private Parent root;

    public void generate() throws IOException {

        FXMLLoader loader = new FXMLLoader(Tabah.class.getResource(Config.getConfig("addresses").getProperty(String.class,"waitingRoom")));
        root = loader.load();

    }

    public Parent getRoot() {
        return root;
    }
}