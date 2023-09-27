package org.openjfx.view.gameScene.cell;

import ir.sharif.ap.hw4.event.ClickEvent;
import ir.sharif.ap.hw4.model.Cell;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.openjfx.listener.EventListener;
import org.openjfx.util.RelationToBoard;

public class CellPane extends Rectangle {

    private final Cell cell;

    public CellPane(Cell cell, RelationToBoard relation, EventListener listener) {
        super(30, 30);
        this.cell = cell;
        this.setStroke(Color.BLACK);
        if (cell.isShot() && cell.hasShip()) {
            this.setFill(Color.RED);
        } else if (cell.isShot() && !cell.hasShip()) {
            this.setFill(Color.BLACK);
        } else if (cell.hasShip() && (relation == RelationToBoard.Mine || relation == RelationToBoard.Spectator)) {
            this.setFill(Color.GREEN);
        } else {
            this.setFill(Color.LIGHTBLUE);
        }
        if (relation == RelationToBoard.Enemy)
            this.setOnMouseClicked(event -> listener.listen(new ClickEvent(cell.getX(), cell.getY())));
    }

    public Cell getCell() {
        return cell;
    }
}