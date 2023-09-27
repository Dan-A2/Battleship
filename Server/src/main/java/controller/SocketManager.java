package controller;

import controller.game.GameLobby;
import controller.game.WaitingRoom;
import controller.game.battleship.BattleShipGame;
import controller.network.SocketResponseSender;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.LinkedList;

public class SocketManager extends Thread{

    @Override
    public void run() {

        System.out.println("socket manager started");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-10);
        }
        GameLobby lobby = new GameLobby();
        WaitingRoom room = new WaitingRoom();
        SecureRandom secureRandom = new SecureRandom();
        while (true) {
            ClientHandler clientHandler = null;
            try {
                Socket socket = serverSocket.accept();
                System.out.println("a new user came");
                clientHandler = new ClientHandler(new SocketResponseSender(socket), lobby, room, secureRandom.nextInt());
                clientHandler.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}