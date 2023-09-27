package ir.sharif.ap.hw4.response;

import ir.sharif.ap.hw4.model.Board;

public class GoCheckBoardResponse extends Response{

    private final Board board;
    private final int what; // 1 if new; 2 if update
    private final int leftAttempts; // doesn't matter for the first time
    private final int timeLeft;

    public GoCheckBoardResponse(Board board, int wa, int leftAttempts, int timeLeft) {
        this.board = board;
        this.what = wa;
        this.leftAttempts = leftAttempts;
        this.timeLeft = timeLeft;
    }

    @Override
    public void visit(ResponseVisitor visitor) {
        if (what == 1) {
            visitor.goCheckBoard(board, leftAttempts, timeLeft);
        } else {
            visitor.updateCheckBoard(board, leftAttempts, timeLeft);
        }
    }
}
