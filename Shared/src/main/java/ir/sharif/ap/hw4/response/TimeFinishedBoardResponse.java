package ir.sharif.ap.hw4.response;

public class TimeFinishedBoardResponse extends Response{
    @Override
    public void visit(ResponseVisitor visitor) {
        visitor.timeFinishedBoard();
    }
}