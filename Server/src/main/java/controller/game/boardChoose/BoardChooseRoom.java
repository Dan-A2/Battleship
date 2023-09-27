package controller.game.boardChoose;

import controller.ClientHandler;
import database.BoardDataBase;
import ir.sharif.ap.hw4.model.Board;
import ir.sharif.ap.hw4.model.User;
import ir.sharif.ap.hw4.util.Loop;
import ir.sharif.ap.hw4.util.Status;
import logic.TimerClass;

public class BoardChooseRoom {

    private final TimerClass timer;
    private final ClientHandler handler;
    private final User player;
    private Board board;
    private final Loop tmp;

    public BoardChooseRoom(ClientHandler handler, User player) {
        this.player = player;
        this.handler = handler;
        this.board = BoardDataBase.getDataBase().getRandomBoard();
        this.timer = new TimerClass(31);
        tmp = new Loop(2, this::checkTime);
        tmp.start();
        timer.start();
    }

    private void checkTime() {
        if (timer.getTime() <= 0) {
            handler.setStatus(Status.TimeFinishedBoard);
        }
    }

    public void setReady() {
        player.setReady(true);
        player.setBoard(board);
        board.setOwnerId(player.getId());
        timer.stop();
        tmp.stop();
    }

    public void Regenerate() {
        this.board = BoardDataBase.getDataBase().getRandomBoard();
        timer.setTime(timer.getTime()+10);
    }

    public TimerClass getTimer() {
        return timer;
    }

    public Board getBoard() {
        return board;
    }
}