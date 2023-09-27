package ir.sharif.ap.hw4.response;

public class ShowMainMenuResponse extends Response{

    @Override
    public void visit(ResponseVisitor visitor) {
        visitor.showMainMenu();
    }
}