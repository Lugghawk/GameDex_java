package com.gamedex.ui.controller;

import com.gamedex.persist.dao.GameDao;
import com.gamedex.persist.model.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextInputDialog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by Dave on 6/21/2015.
 */
@Component
public class MenuBarController {

    @Autowired
    private GameDao gameDao;

    @FXML
    public void exit(ActionEvent actionEvent) {

    }

    public void openAddGamePrompt(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Game");
        dialog.setHeaderText(null);
        dialog.setContentText("Game Name:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> {
            Game game = new Game();
            game.setName(name);
            gameDao.persist(game);
        });
    }
}
