package ir.sharif.ap.hw4.event;

import ir.sharif.ap.hw4.response.Response;

public class RegenerateBoardEvent extends Event{
    @Override
    public Response visit(ir.sharif.ap.hw4.event.EventVisitor visitor) {
        return visitor.regenerateBoard();
    }
}
