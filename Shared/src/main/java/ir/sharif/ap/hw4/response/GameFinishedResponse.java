package ir.sharif.ap.hw4.response;

public class GameFinishedResponse extends Response{

    private final boolean hasWon;

    public GameFinishedResponse(boolean hasWon) {
        this.hasWon = hasWon;
    }

    @Override
    public void visit(ResponseVisitor visitor) {
        visitor.visitFinishGame(hasWon);
    }
}