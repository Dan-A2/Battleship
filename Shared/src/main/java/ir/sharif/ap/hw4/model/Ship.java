package ir.sharif.ap.hw4.model;

import java.util.LinkedList;

public class Ship {

    private final Ships type;
    private final LinkedList<Cell> cells;
    private int length;
    private int hp;

    public Ship(Ships type, LinkedList<Cell> cellsTaken) {
        this.type = type;
        this.cells = cellsTaken;
        switch (type) {
            case Battleship -> length = 4;
            case Cruiser -> length = 3;
            case Destroyer -> length = 2;
            case Frigate -> length = 1;
        }
        hp = length;
    }

    public Ships getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isSunk() {
        return hp <= 0;
    }

    public LinkedList<Cell> getCells() {
        return cells;
    }

    public int getLength() {
        return length;
    }
}