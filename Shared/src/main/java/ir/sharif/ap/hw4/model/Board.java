package ir.sharif.ap.hw4.model;

import java.util.LinkedList;

public class Board {

    private final Cell[][] cells;
    private int ownerId;
    private final LinkedList<Ship> ships;

    public Board() {
        this.cells = new Cell[10][10];
        this.ships = new LinkedList<>();
        generateCells();
    }

    private void generateCells() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public LinkedList<Ship> getShips() {
        return ships;
    }
}