import controller.SocketManager;
import database.UserDatabase;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            UserDatabase.loadUsers();
            SocketManager socketManager = new SocketManager();
            socketManager.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}