package database;

import ir.sharif.ap.hw4.model.Board;
import ir.sharif.ap.hw4.model.Cell;
import ir.sharif.ap.hw4.model.Ship;
import ir.sharif.ap.hw4.model.Ships;

import java.util.LinkedList;
import java.util.Random;

public class BoardDataBase {

    private static BoardDataBase dataBase;

    private BoardDataBase() {
    }

    private Board getBoard0() {
        Board board1 = new Board();
        LinkedList<Cell> tmp = new LinkedList<>();
        // ****************************************
        tmp.add(board1.getCells()[0][0]);
        board1.getCells()[0][0].setHasShip(true);
        board1.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board1.getCells()[2][0]);
        board1.getCells()[2][0].setHasShip(true);
        board1.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board1.getCells()[3][9]);
        board1.getCells()[3][9].setHasShip(true);
        board1.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board1.getCells()[9][8]);
        board1.getCells()[9][8].setHasShip(true);
        board1.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board1.getCells()[4][0]);
        tmp.add(board1.getCells()[5][0]);
        board1.getCells()[4][0].setHasShip(true);
        board1.getCells()[5][0].setHasShip(true);
        board1.getShips().add(new Ship(Ships.Destroyer, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board1.getCells()[5][9]);
        tmp.add(board1.getCells()[6][9]);
        board1.getCells()[5][9].setHasShip(true);
        board1.getCells()[6][9].setHasShip(true);
        board1.getShips().add(new Ship(Ships.Destroyer, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board1.getCells()[8][1]);
        tmp.add(board1.getCells()[9][1]);
        board1.getCells()[8][1].setHasShip(true);
        board1.getCells()[9][1].setHasShip(true);
        board1.getShips().add(new Ship(Ships.Destroyer, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board1.getCells()[0][3]);
        tmp.add(board1.getCells()[1][3]);
        tmp.add(board1.getCells()[2][3]);
        board1.getCells()[0][3].setHasShip(true);
        board1.getCells()[1][3].setHasShip(true);
        board1.getCells()[2][3].setHasShip(true);
        board1.getShips().add(new Ship(Ships.Cruiser, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board1.getCells()[1][6]);
        tmp.add(board1.getCells()[2][6]);
        tmp.add(board1.getCells()[3][6]);
        board1.getCells()[0][3].setHasShip(true);
        board1.getCells()[1][3].setHasShip(true);
        board1.getCells()[2][3].setHasShip(true);
        board1.getShips().add(new Ship(Ships.Cruiser, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board1.getCells()[6][3]);
        tmp.add(board1.getCells()[7][3]);
        tmp.add(board1.getCells()[8][3]);
        tmp.add(board1.getCells()[9][3]);
        board1.getCells()[6][3].setHasShip(true);
        board1.getCells()[7][3].setHasShip(true);
        board1.getCells()[8][3].setHasShip(true);
        board1.getCells()[9][3].setHasShip(true);
        board1.getShips().add(new Ship(Ships.Battleship, (LinkedList<Cell>) tmp.clone()));
        return board1;
    }

    private Board getBoard1() {
        Board board2 = new Board();
        LinkedList<Cell> tmp = new LinkedList<>();
        // ****************************************
        tmp.add(board2.getCells()[3][1]);
        board2.getCells()[3][1].setHasShip(true);
        board2.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board2.getCells()[8][2]);
        board2.getCells()[8][2].setHasShip(true);
        board2.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board2.getCells()[8][4]);
        board2.getCells()[8][4].setHasShip(true);
        board2.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board2.getCells()[7][9]);
        board2.getCells()[7][9].setHasShip(true);
        board2.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board2.getCells()[0][1]);
        tmp.add(board2.getCells()[0][2]);
        board2.getCells()[0][1].setHasShip(true);
        board2.getCells()[0][2].setHasShip(true);
        board2.getShips().add(new Ship(Ships.Destroyer, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board2.getCells()[0][8]);
        tmp.add(board2.getCells()[0][9]);
        board2.getCells()[0][8].setHasShip(true);
        board2.getCells()[0][9].setHasShip(true);
        board2.getShips().add(new Ship(Ships.Destroyer, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board2.getCells()[6][2]);
        tmp.add(board2.getCells()[6][3]);
        board2.getCells()[6][2].setHasShip(true);
        board2.getCells()[6][3].setHasShip(true);
        board2.getShips().add(new Ship(Ships.Destroyer, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board2.getCells()[2][6]);
        tmp.add(board2.getCells()[3][6]);
        tmp.add(board2.getCells()[4][6]);
        board2.getCells()[2][6].setHasShip(true);
        board2.getCells()[3][6].setHasShip(true);
        board2.getCells()[4][6].setHasShip(true);
        board2.getShips().add(new Ship(Ships.Cruiser, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board2.getCells()[6][5]);
        tmp.add(board2.getCells()[6][6]);
        tmp.add(board2.getCells()[6][7]);
        board2.getCells()[6][5].setHasShip(true);
        board2.getCells()[6][6].setHasShip(true);
        board2.getCells()[6][7].setHasShip(true);
        board2.getShips().add(new Ship(Ships.Cruiser, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board2.getCells()[2][9]);
        tmp.add(board2.getCells()[3][9]);
        tmp.add(board2.getCells()[4][9]);
        tmp.add(board2.getCells()[5][9]);
        board2.getCells()[2][9].setHasShip(true);
        board2.getCells()[3][9].setHasShip(true);
        board2.getCells()[4][9].setHasShip(true);
        board2.getCells()[5][9].setHasShip(true);
        board2.getShips().add(new Ship(Ships.Battleship, (LinkedList<Cell>) tmp.clone()));
        return board2;
    }

    private Board getBoard2() {
        Board board3 = new Board();
        LinkedList<Cell> tmp = new LinkedList<>();
        // ****************************************
        tmp.add(board3.getCells()[5][5]);
        board3.getCells()[5][5].setHasShip(true);
        board3.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board3.getCells()[7][1]);
        board3.getCells()[7][1].setHasShip(true);
        board3.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board3.getCells()[9][0]);
        board3.getCells()[9][0].setHasShip(true);
        board3.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board3.getCells()[9][3]);
        board3.getCells()[9][3].setHasShip(true);
        board3.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board3.getCells()[1][2]);
        tmp.add(board3.getCells()[0][2]);
        board3.getCells()[1][2].setHasShip(true);
        board3.getCells()[0][2].setHasShip(true);
        board3.getShips().add(new Ship(Ships.Destroyer, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board3.getCells()[3][8]);
        tmp.add(board3.getCells()[4][8]);
        board3.getCells()[3][8].setHasShip(true);
        board3.getCells()[4][8].setHasShip(true);
        board3.getShips().add(new Ship(Ships.Destroyer, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board3.getCells()[5][2]);
        tmp.add(board3.getCells()[5][1]);
        board3.getCells()[5][2].setHasShip(true);
        board3.getCells()[5][1].setHasShip(true);
        board3.getShips().add(new Ship(Ships.Destroyer, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board3.getCells()[9][9]);
        tmp.add(board3.getCells()[9][8]);
        tmp.add(board3.getCells()[9][7]);
        board3.getCells()[9][9].setHasShip(true);
        board3.getCells()[9][8].setHasShip(true);
        board3.getCells()[9][7].setHasShip(true);
        board3.getShips().add(new Ship(Ships.Cruiser, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board3.getCells()[0][5]);
        tmp.add(board3.getCells()[1][5]);
        tmp.add(board3.getCells()[2][5]);
        board3.getCells()[0][5].setHasShip(true);
        board3.getCells()[1][5].setHasShip(true);
        board3.getCells()[2][5].setHasShip(true);
        board3.getShips().add(new Ship(Ships.Cruiser, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board3.getCells()[7][5]);
        tmp.add(board3.getCells()[7][6]);
        tmp.add(board3.getCells()[7][7]);
        tmp.add(board3.getCells()[7][8]);
        board3.getCells()[7][5].setHasShip(true);
        board3.getCells()[7][6].setHasShip(true);
        board3.getCells()[7][7].setHasShip(true);
        board3.getCells()[7][8].setHasShip(true);
        board3.getShips().add(new Ship(Ships.Battleship, (LinkedList<Cell>) tmp.clone()));
        return board3;
    }

    private Board getBoard3() {
        Board board4 = new Board();
        LinkedList<Cell> tmp = new LinkedList<>();
        // ****************************************
        tmp.add(board4.getCells()[0][7]);
        board4.getCells()[0][7].setHasShip(true);
        board4.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board4.getCells()[5][3]);
        board4.getCells()[5][3].setHasShip(true);
        board4.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board4.getCells()[5][5]);
        board4.getCells()[5][5].setHasShip(true);
        board4.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board4.getCells()[6][0]);
        board4.getCells()[6][0].setHasShip(true);
        board4.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board4.getCells()[0][3]);
        tmp.add(board4.getCells()[0][2]);
        board4.getCells()[0][3].setHasShip(true);
        board4.getCells()[0][2].setHasShip(true);
        board4.getShips().add(new Ship(Ships.Destroyer, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board4.getCells()[3][3]);
        tmp.add(board4.getCells()[3][2]);
        board4.getCells()[3][3].setHasShip(true);
        board4.getCells()[3][2].setHasShip(true);
        board4.getShips().add(new Ship(Ships.Destroyer, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board4.getCells()[5][8]);
        tmp.add(board4.getCells()[6][8]);
        board4.getCells()[5][8].setHasShip(true);
        board4.getCells()[6][8].setHasShip(true);
        board4.getShips().add(new Ship(Ships.Destroyer, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board4.getCells()[7][2]);
        tmp.add(board4.getCells()[7][3]);
        tmp.add(board4.getCells()[7][4]);
        board4.getCells()[7][2].setHasShip(true);
        board4.getCells()[7][3].setHasShip(true);
        board4.getCells()[7][4].setHasShip(true);
        board4.getShips().add(new Ship(Ships.Cruiser, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board4.getCells()[9][2]);
        tmp.add(board4.getCells()[9][3]);
        tmp.add(board4.getCells()[9][1]);
        board4.getCells()[9][2].setHasShip(true);
        board4.getCells()[9][3].setHasShip(true);
        board4.getCells()[9][1].setHasShip(true);
        board4.getShips().add(new Ship(Ships.Cruiser, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board4.getCells()[2][6]);
        tmp.add(board4.getCells()[2][7]);
        tmp.add(board4.getCells()[2][8]);
        tmp.add(board4.getCells()[2][9]);
        board4.getCells()[2][9].setHasShip(true);
        board4.getCells()[2][6].setHasShip(true);
        board4.getCells()[2][7].setHasShip(true);
        board4.getCells()[2][8].setHasShip(true);
        board4.getShips().add(new Ship(Ships.Battleship, (LinkedList<Cell>) tmp.clone()));
        return board4;
    }

    private Board getBoard4() {
        Board board5 = new Board();
        LinkedList<Cell> tmp = new LinkedList<>();
        // ****************************************
        tmp.add(board5.getCells()[2][7]);
        board5.getCells()[2][7].setHasShip(true);
        board5.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board5.getCells()[1][1]);
        board5.getCells()[1][1].setHasShip(true);
        board5.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board5.getCells()[3][5]);
        board5.getCells()[3][5].setHasShip(true);
        board5.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board5.getCells()[4][3]);
        board5.getCells()[4][3].setHasShip(true);
        board5.getShips().add(new Ship(Ships.Frigate, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board5.getCells()[4][8]);
        tmp.add(board5.getCells()[5][8]);
        board5.getCells()[4][8].setHasShip(true);
        board5.getCells()[5][8].setHasShip(true);
        board5.getShips().add(new Ship(Ships.Destroyer, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board5.getCells()[6][5]);
        tmp.add(board5.getCells()[6][4]);
        board5.getCells()[6][4].setHasShip(true);
        board5.getCells()[6][5].setHasShip(true);
        board5.getShips().add(new Ship(Ships.Destroyer, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board5.getCells()[9][8]);
        tmp.add(board5.getCells()[9][9]);
        board5.getCells()[9][8].setHasShip(true);
        board5.getCells()[9][9].setHasShip(true);
        board5.getShips().add(new Ship(Ships.Destroyer, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board5.getCells()[0][5]);
        tmp.add(board5.getCells()[0][6]);
        tmp.add(board5.getCells()[0][7]);
        board5.getCells()[0][5].setHasShip(true);
        board5.getCells()[0][6].setHasShip(true);
        board5.getCells()[0][7].setHasShip(true);
        board5.getShips().add(new Ship(Ships.Cruiser, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board5.getCells()[8][1]);
        tmp.add(board5.getCells()[8][2]);
        tmp.add(board5.getCells()[8][3]);
        board5.getCells()[8][1].setHasShip(true);
        board5.getCells()[8][2].setHasShip(true);
        board5.getCells()[8][3].setHasShip(true);
        board5.getShips().add(new Ship(Ships.Cruiser, (LinkedList<Cell>) tmp.clone()));
        // ****************************************
        tmp.clear();
        tmp.add(board5.getCells()[3][1]);
        tmp.add(board5.getCells()[4][1]);
        tmp.add(board5.getCells()[5][1]);
        tmp.add(board5.getCells()[6][1]);
        board5.getCells()[3][1].setHasShip(true);
        board5.getCells()[4][1].setHasShip(true);
        board5.getCells()[5][1].setHasShip(true);
        board5.getCells()[6][1].setHasShip(true);
        board5.getShips().add(new Ship(Ships.Battleship, (LinkedList<Cell>) tmp.clone()));
        return board5;
    }

    public static BoardDataBase getDataBase() {
        if (dataBase == null) {
            dataBase = new BoardDataBase();
        }
        return dataBase;
    }

    public Board getRandomBoard() {
        Random random = new Random();
        int rand = random.nextInt(5);
        System.out.println("Random index: " + rand);
        if (rand == 0) {
            return getBoard0();
        } else if (rand == 1) {
            return getBoard1();
        } else if (rand == 2) {
            return getBoard2();
        } else if (rand == 3) {
            return getBoard3();
        } else {
            return getBoard4();
        }
    }
}