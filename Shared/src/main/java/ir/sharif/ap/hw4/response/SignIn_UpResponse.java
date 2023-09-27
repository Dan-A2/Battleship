package ir.sharif.ap.hw4.response;

import ir.sharif.ap.hw4.model.User;

public class SignIn_UpResponse extends Response{

    private final User user;
    private String error;

    public SignIn_UpResponse(User user, String error) {
        this.user = user;
        this.error = error;
    }

    @Override
    public void visit(ResponseVisitor visitor) {
        visitor.visitUserSignIn_Up(user, error);
    }
}