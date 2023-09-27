package ir.sharif.ap.hw4.model;

public class Cell {

    private boolean isShot;
    private boolean hasShip;
    private final int x,y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isShot() {
        return isShot;
    }

    public void setShot(boolean shot) {
        isShot = shot;
    }

    public boolean hasShip() {
        return hasShip;
    }

    public void setHasShip(boolean hasShip) {
        this.hasShip = hasShip;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}