package com.gamedex.main;

import com.gamedex.spring.SpringFxmlLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class GameDexMain extends Application {

    private static final SpringFxmlLoader loader = new SpringFxmlLoader();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*Parent root = FXMLLoader.load(getClass().getResource("/ui/MainUI.fxml"));*/
        Parent root = (Parent) loader.load("/ui/MainUI.fxml");

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
