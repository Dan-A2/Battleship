package ir.sharif.ap.hw4.response;

public class FinishSpectateResponse extends Response{
    @Override
    public void visit(ResponseVisitor visitor) {
        visitor.stopSpectate();
    }
}
