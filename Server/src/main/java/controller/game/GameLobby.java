package controller.game;

import controller.ClientHandler;
import controller.game.battleship.BattleShipGame;
import ir.sharif.ap.hw4.util.Status;
import util.Side;

import java.util.LinkedList;

public class GameLobby {

    private final static LinkedList<BattleShipGame> gamesOnline = new LinkedList<>();
    private ClientHandler waiting; // stage 3 and 4 in here

    public synchronized void startGame(ClientHandler handler) {

        if (waiting == null) {
            waiting = handler;
            waiting.setSide(Side.Player1);
            waiting.setStatus(Status.Waiting);
        } else {
            if (waiting.getPlayer().getId() != handler.getPlayer().getId() && waiting.getPlayer().isReady() && handler.getPlayer().isReady()) {
                Game game = new BattleShipGame(waiting, handler);
                handler.setSide(Side.Player2);
                waiting.setGame(game);
                handler.setGame(game);
                waiting.setStatus(Status.Playing);
                handler.setStatus(Status.Playing);
                waiting = null;
                gamesOnline.add((BattleShipGame) game);
            }
        }

    }

    public static LinkedList<BattleShipGame> getGamesOnline() {
        synchronized (gamesOnline) {
            return gamesOnline;
        }
    }

    public static void removeGame(BattleShipGame game) {
        synchronized (gamesOnline) {
            gamesOnline.remove(game);
        }
    }
}