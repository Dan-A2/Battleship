package ir.sharif.ap.hw4.event;

import ir.sharif.ap.hw4.response.Response;

public class SignInEvent extends Event{

    private final String username;
    private final String password;

    public SignInEvent(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public Response visit(EventVisitor visitor) {
       return visitor.visitSignIn(this);
    }

}