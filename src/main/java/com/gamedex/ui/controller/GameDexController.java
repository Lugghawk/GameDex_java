package com.gamedex.ui.controller;

import com.gamedex.persist.dao.GameDao;
import com.gamedex.persist.model.Game;
import com.gamedex.ui.element.GameListElement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameDexController {

    public ListView<GameListElement> gameListView;


    @FXML
    protected void initialize(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        GameDao gameDao = (GameDao) context.getBean("gameDao");
        List<Game> gameList = gameDao.getAllGames();
        List<GameListElement> gameListElements = gameList.stream().map(GameListElement::new).collect(Collectors.toList());
        ObservableList<GameListElement> gameObservableList = FXCollections.observableList(gameListElements);
        gameListView.setItems(gameObservableList);
    }
    @FXML
    public void handleButton(ActionEvent event){

    }
}
