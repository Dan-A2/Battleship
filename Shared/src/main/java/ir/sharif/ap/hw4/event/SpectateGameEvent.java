package ir.sharif.ap.hw4.event;

import ir.sharif.ap.hw4.response.Response;

public class SpectateGameEvent extends Event{

    private final int index;

    public SpectateGameEvent(int index) {
        this.index = index;
    }

    @Override
    public Response visit(EventVisitor visitor) {
        return visitor.spectateGame(this);
    }

    public int getIndex() {
        return index;
    }
}