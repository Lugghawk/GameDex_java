package com.gamedex.controller;

import com.gamedex.persist.dao.GameDao;
import com.gamedex.persist.model.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameDexController {

    public ListView<Game> gameListView;


    @FXML
    protected void initialize(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        GameDao gameDao = (GameDao) context.getBean("gameDao");
        List<Game> gameList = gameDao.getAllGames();
        ObservableList<Game> gameObservableList = FXCollections.observableList(gameList);
        gameListView.setItems(gameObservableList);
    }
    @FXML
    public void handleButton(ActionEvent event){

    }
}
