package ir.sharif.ap.hw4.event;

import ir.sharif.ap.hw4.response.Response;

public class RequestToken extends Event{

    @Override
    public Response visit(EventVisitor visitor) {
        return visitor.getToken();
    }
}
