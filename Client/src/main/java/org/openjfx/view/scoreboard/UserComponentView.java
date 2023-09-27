package org.openjfx.view.scoreboard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class UserComponentView {

    @FXML
    private Label usernameLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    private Rectangle onlineStatusRec;

    public Label getUsernameLabel() {
        return usernameLabel;
    }

    public Label getScoreLabel() {
        return scoreLabel;
    }

    public Rectangle getOnlineStatusRec() {
        return onlineStatusRec;
    }
}