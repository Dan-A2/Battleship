package logic;

import ir.sharif.ap.hw4.model.Board;
import ir.sharif.ap.hw4.model.Cell;
import ir.sharif.ap.hw4.model.Ship;

import java.util.LinkedList;
import java.util.Random;

public class BoardController {

    public LinkedList<Cell> getAdjacentCells(Board board, Cell cell) {
        LinkedList<Cell> adjacentCells = new LinkedList<>();
        if (getCell(board, cell.getX()+1, cell.getY()) != null) {
            adjacentCells.add(getCell(board, cell.getX()+1, cell.getY()));
        }
        if (getCell(board, cell.getX()-1, cell.getY()) != null) {
            adjacentCells.add(getCell(board, cell.getX()-1, cell.getY()));
        }
        if (getCell(board, cell.getX(), cell.getY()+1) != null) {
            adjacentCells.add(getCell(board, cell.getX(), cell.getY()+1));
        }
        if (getCell(board, cell.getX(), cell.getY()-1) != null) {
            adjacentCells.add(getCell(board, cell.getX(), cell.getY()-1));
        }
        if (getCell(board, cell.getX()-1, cell.getY()-1) != null) {
            adjacentCells.add(getCell(board, cell.getX()-1, cell.getY()-1));
        }
        if (getCell(board, cell.getX()-1, cell.getY()+1) != null) {
            adjacentCells.add(getCell(board, cell.getX()-1, cell.getY()+1));
        }
        if (getCell(board, cell.getX()+1, cell.getY()-1) != null) {
            adjacentCells.add(getCell(board, cell.getX()+1, cell.getY()-1));
        }
        if (getCell(board, cell.getX()+1, cell.getY()+1) != null) {
            adjacentCells.add(getCell(board, cell.getX()+1, cell.getY()+1));
        }
        return adjacentCells;
    }

    public Cell getCell(Board board, int x, int y) {
        try {
            return board.getCells()[x][y];
        } catch (Exception e) { // if the cell was out of bounds
            return null;
        }
    }

    public void shoot(Board board, Cell cell) {
        cell.setShot(true);
        if (cell.hasShip()) {
            loop: for (Ship s : board.getShips()) {
                for (Cell c : s.getCells()) {
                    if (c.getX() == cell.getX() && c.getY() == cell.getY()) {
                        System.out.println("shooting the ship");
                        System.out.println("ship HP before shot : " + s.getHp());
                        s.setHp(s.getHp()-1);
                        System.out.println("ship HP after shot : " + s.getHp());
                        if (s.getHp() <= 0) {
                            System.out.println("sinking");
                            sink(board, s);
                        }
                        break loop;
                    }
                }
            }
        }
    }

    private void sink(Board board, Ship ship) {
        System.out.println("sinking the ship");
        LinkedList<Cell> shipCells = ship.getCells();
        System.out.println(shipCells);
        for (Cell c : shipCells) {
            System.out.println(getAdjacentCells(board, c));
            for (Cell c2 : getAdjacentCells(board, c)) {
                if (!c2.isShot()) {
                    System.out.println("shooting cell " + c2.getX() + " : " + c2.getY());
                    shoot(board, c2);
                }
            }
        }
    }

//    private boolean canPlaceShip(int shipLength, boolean isVertical, int beginX, int beginY) {
//        /*
//        here we presume that the ship has to be placed either to the right hand side
//        or to the down side of the beginning cell
//        */
//        int flag = 0;
//        if (isVertical) {
//            for (int i = 0; i < shipLength; i++) {
//                if (getCell(beginX+i, beginY) != null) {
//                    CellController controller = new CellController();
//                    if (controller.canPlaceShip(getCell(beginX+i, beginY))) {
//                        flag++;
//                    }
//                }
//            }
//        } else {
//            for (int i = 0; i < shipLength; i++) {
//                if (getCell(beginX, beginY+i) != null) {
//                    CellController controller = new CellController();
//                    if (controller.canPlaceShip(getCell(beginX, beginY+i))) {
//                        flag++;
//                    }
//                }
//            }
//        }
//        return  flag == shipLength;
//    }
//
//    public void placeShip(Ship ship, int beginX, int beginY) {
//
//        int length = ship.getLength();
//        if (ship.isVertical()) {
//            for (int i = 0; i < length; i++) {
//                new CellController().putShip(getCell(beginX + i, beginY), ship);
//            }
//        } else {
//            for (int i = 0; i < length; i++) {
//                new CellController().putShip(getCell(beginX, beginY + i), ship);
//            }
//        }
//    }
}