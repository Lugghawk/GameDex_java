package com.gamedex.ui.controller;

import com.gamedex.persist.dao.GameDao;
import com.gamedex.persist.model.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Dave on 6/21/2015.
 */
@Component
public class AddGameController {

    @FXML
    private TextField gameName;

    @Autowired
    private GameDao gameDao;

    public void addGame(ActionEvent actionEvent) {
        Game game = new Game();
        game.setName(gameName.getText());
        gameDao.persist(game);
        close(actionEvent);
    }

    public void close(ActionEvent actionEvent) {

    }
}
