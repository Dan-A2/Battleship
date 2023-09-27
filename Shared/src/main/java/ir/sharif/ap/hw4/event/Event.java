package ir.sharif.ap.hw4.event;

import ir.sharif.ap.hw4.response.Response;

public abstract class Event {
    public abstract Response visit(EventVisitor visitor);
}