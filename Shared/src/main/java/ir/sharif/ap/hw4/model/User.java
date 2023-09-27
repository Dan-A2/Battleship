package ir.sharif.ap.hw4.model;

import com.google.gson.annotations.Expose;

public class User {

    private static int lastId = 0;
    @Expose(serialize = true, deserialize = true)
    private final String username;
    @Expose(serialize = true, deserialize = true)
    private final String password;
    @Expose(serialize = true, deserialize = true)
    private final int id;
    @Expose(serialize = true, deserialize = true)
    private int gamesWon = 0;
    @Expose(serialize = true, deserialize = true)
    private int gamesLost = 0;
    @Expose(serialize = false, deserialize = false)
    private boolean ready;
    @Expose(serialize = false, deserialize = false)
    private boolean isOnline;
    @Expose(serialize = false, deserialize = false)
    private Board board;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        lastId++;
        this.id = lastId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public static void setLastId(int lastId) {
        User.lastId = lastId;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void winGame() {
        gamesWon++;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void loseGame() {
        gamesLost++;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public int getScore() {
        return gamesWon-gamesLost;
    }
}