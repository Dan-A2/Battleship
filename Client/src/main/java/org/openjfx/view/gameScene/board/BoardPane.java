package org.openjfx.view.gameScene.board;

import ir.sharif.ap.hw4.model.Board;
import ir.sharif.ap.hw4.model.Cell;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.openjfx.listener.EventListener;
import org.openjfx.view.gameScene.cell.CellPane;
import org.openjfx.util.RelationToBoard;

public class BoardPane extends Parent {

    private final Board board;
    private final VBox vRows;
    private final RelationToBoard relation;
    private final EventListener eventListener;

    public BoardPane(Board board, RelationToBoard relationToBoard, EventListener listener) {
        this.board = board;
        this.vRows = new VBox();
        this.relation = relationToBoard;
        this.eventListener = listener;
        createBoard();
    }

    private void createBoard() {

        for (int i = 0; i <= 9; i++) {
            HBox box = new HBox();
            for (int j = 0; j <= 9; j++) {
                Cell cell = board.getCells()[i][j];
                box.getChildren().add(new CellPane(cell, relation, eventListener));
            }
            vRows.getChildren().add(box);
        }
        generate();

    }

    private void generate() {
        getChildren().add(vRows);
    }
}