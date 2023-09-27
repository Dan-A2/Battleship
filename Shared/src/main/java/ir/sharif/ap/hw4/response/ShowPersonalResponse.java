package ir.sharif.ap.hw4.response;

import ir.sharif.ap.hw4.model.User;

public class ShowPersonalResponse extends Response{

    private final User user;

    public ShowPersonalResponse(User user) {
        this.user = user;
    }

    @Override
    public void visit(ResponseVisitor visitor) {
        visitor.showPersonal(user);
    }
}
