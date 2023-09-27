package controller.game;

import ir.sharif.ap.hw4.model.Board;
import ir.sharif.ap.hw4.model.User;
import util.Side;

import javax.print.attribute.standard.Sides;

public interface Game {
    Board getBoard1();
    Board getBoard2();
    void click(int x, int y, Side side);
    Integer getWinnerId();
    int userInTurnId();
    int timeLeft();
}