package com.gamedex.spring;

import com.gamedex.main.ApplicationConfiguration;
import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class SpringFxmlLoader {

    private static final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

    public Object load(String url) {
        try (InputStream fxmlStream = SpringFxmlLoader.class.getResourceAsStream(url)) {
            System.err.println(SpringFxmlLoader.class.getResourceAsStream(url));
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(url));
            loader.setControllerFactory(applicationContext::getBean);
            return loader.load(fxmlStream);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }
}