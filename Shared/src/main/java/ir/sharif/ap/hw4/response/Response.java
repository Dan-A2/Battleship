package ir.sharif.ap.hw4.response;

public abstract class Response {
    public abstract void visit(ResponseVisitor visitor);
}