package org.example;

import javafx.application.Application;


import javafx.stage.Stage;


/**
 * Main class to launch and manage the primary stage of the SOS Game application.
 * This class is the entry point of the application and sets up the initial scene.
 */
public class Main extends Application {
    @Override
    public void start(Stage stage){
        stage.setTitle("SOS Game");
        stage.setScene(new Game());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}