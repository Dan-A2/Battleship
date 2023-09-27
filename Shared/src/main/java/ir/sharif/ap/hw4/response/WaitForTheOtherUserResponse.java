package ir.sharif.ap.hw4.response;

public class WaitForTheOtherUserResponse extends Response{
    @Override
    public void visit(ResponseVisitor visitor) {
        visitor.waitForOtherUser();
    }
}
