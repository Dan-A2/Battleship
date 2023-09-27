package ir.sharif.ap.hw4.response;

import ir.sharif.ap.hw4.model.Board;
import ir.sharif.ap.hw4.model.User;

import java.util.HashMap;
import java.util.LinkedList;

public interface ResponseVisitor {
    void visitUserSignIn_Up(User user, String error);

    void visitBoard(Board board1, Board board2, int turn, boolean isSpectator, int timeLeft);

    void showMainMenu();

    void showSpectateList(HashMap<Integer, int[]> games);

    void goCheckBoard(Board board, int leftAttempts, int timeLeft);

    void updateCheckBoard(Board board, int leftAttempts, int timeLeft);

    void waitForOtherUser();

    void visitFinishGame(boolean hasWon);

    void visitToken(int token);

    void showScoreboard(LinkedList<User> users);

    void showPersonal(User player);

    void stopSpectate();

    void timeFinishedBoard();
}