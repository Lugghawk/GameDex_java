package com.gamedex.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by Dave on 6/20/2015.
 */
public class GameDexController {

    public Label helloLabel;

    @FXML
    public void handleButton(ActionEvent event){
        helloLabel.setText("Yay!");
    }
}
