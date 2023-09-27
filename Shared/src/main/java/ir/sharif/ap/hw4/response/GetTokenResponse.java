package ir.sharif.ap.hw4.response;

public class GetTokenResponse extends Response{

    private final int token;

    public GetTokenResponse(int token) {
        this.token = token;
    }

    @Override
    public void visit(ResponseVisitor visitor) {
        visitor.visitToken(token);
    }
}
