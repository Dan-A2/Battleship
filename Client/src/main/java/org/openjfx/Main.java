package org.openjfx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.openjfx.listener.MainController;
import org.openjfx.listener.network.SocketEventSender;

import javax.swing.*;
import java.net.Socket;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Socket socket = new Socket("localhost", 8000);
            primaryStage.setResizable(false);
            MainController controller = new MainController(new SocketEventSender(socket), primaryStage);
            controller.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "server is not online");
            System.exit(-10);
        }
    }
}