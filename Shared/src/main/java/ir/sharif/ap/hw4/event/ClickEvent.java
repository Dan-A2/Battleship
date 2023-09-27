package ir.sharif.ap.hw4.event;

import ir.sharif.ap.hw4.response.Response;

public class ClickEvent extends Event{

    private final int x;
    private final int y;

    public ClickEvent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public Response visit(EventVisitor visitor) {
        return visitor.clickBoard(this);
    }
}