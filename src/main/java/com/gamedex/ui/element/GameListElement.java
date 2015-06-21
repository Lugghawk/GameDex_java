package com.gamedex.ui.element;

import com.gamedex.persist.model.Game;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * Created by Dave on 6/21/2015.
 */
public class GameListElement extends HBox {
    Label gameNameLabel = new Label();

    public GameListElement(Game game){
        super();
        gameNameLabel.setText(game.getName());
        gameNameLabel.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(gameNameLabel, Priority.ALWAYS);
        this.getChildren().addAll(gameNameLabel);
    }
}
