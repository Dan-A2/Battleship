package ir.sharif.ap.hw4.response;

import java.util.HashMap;

public class ShowSpectateListResponse extends Response{

    private final HashMap<Integer, int[]> games;

    public ShowSpectateListResponse(HashMap<Integer, int[]> games) {
        this.games = games;
    }

    @Override
    public void visit(ResponseVisitor visitor) {
        visitor.showSpectateList(games);
    }
}
