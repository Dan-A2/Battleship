package util;

public enum Side {
    Player1 {
        @Override
        public Side getOther() {
            return Player2;
        }
    }
    , Player2 {
        @Override
        public Side getOther() {
            return Player1;
        }
    }, Spectator {
        @Override
        public Side getOther() {
            return null;
        }
    };

    public abstract Side getOther();
}