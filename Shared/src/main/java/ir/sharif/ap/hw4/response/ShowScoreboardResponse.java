package ir.sharif.ap.hw4.response;

import ir.sharif.ap.hw4.model.User;

import java.util.LinkedList;

public class ShowScoreboardResponse extends Response{

    private final LinkedList<User> users;

    public ShowScoreboardResponse(LinkedList<User> users) {
        this.users = users;
    }

    @Override
    public void visit(ResponseVisitor visitor) {
        visitor.showScoreboard(users);
    }
}