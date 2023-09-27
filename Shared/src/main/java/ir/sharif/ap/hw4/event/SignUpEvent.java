package ir.sharif.ap.hw4.event;

import ir.sharif.ap.hw4.response.Response;

public class SignUpEvent extends Event{

    private String username;
    private String password;

    public SignUpEvent(String username, String password) {
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
        return visitor.visitSignUp(this);
    }
}