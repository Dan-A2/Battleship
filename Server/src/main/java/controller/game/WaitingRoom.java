package controller.game;

import controller.ClientHandler;

import java.util.LinkedList;

public class WaitingRoom {

    private final LinkedList<ClientHandler> queue = new LinkedList<>(); // from stage 1 and 2 in hear

    public synchronized void knockKnock(ClientHandler handler) {
        queue.add(handler); // =))
    }

    public synchronized LinkedList<ClientHandler> getQueue() {
        return queue;
    }
}