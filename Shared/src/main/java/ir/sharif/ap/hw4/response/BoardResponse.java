package ir.sharif.ap.hw4.response;

import ir.sharif.ap.hw4.model.Board;

public class BoardResponse extends Response{

    private final Board board1;
    private final Board board2;
    private final int userTurn;
    private final boolean isSpectator;
    private final int timeLeft;

    public BoardResponse(Board board1, Board board2, int currentTurn, boolean isSpectator, int timeLeft) {
        this.board1 = board1;
        this.board2 = board2;
        this.userTurn = currentTurn;
        this.isSpectator = isSpectator;
        this.timeLeft = timeLeft;
    }

    @Override
    public void visit(ResponseVisitor visitor) {
        visitor.visitBoard(board1, board2, userTurn, isSpectator, timeLeft);
    }
}