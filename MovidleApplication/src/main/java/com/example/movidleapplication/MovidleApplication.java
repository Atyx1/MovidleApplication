package com.example.movidleapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MovidleApplication extends Application {



    @Override
    public void init() throws IOException {
        MovieManager manager=new MovieManager();
        ArrayList<Movie> movies=manager.getAllFilms();

        System.out.println(movies.get(1));
        System.out.println(movies.size());

    }

    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg=stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(MovidleApplication.class.getResource("movidle.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Movidle");
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml) throws IOException, InterruptedException {
        Parent pane=FXMLLoader.load(getClass().getResource(fxml));

        if(fxml.equals("winScene.fxml")){
            stg.setTitle("You Win!");
            stg.setWidth(470);
            stg.setHeight(270);
        }
        else if (fxml.equals("movidle.fxml")){
            stg.setTitle("Movidle");
            stg.setWidth(600);
            stg.setHeight(450);
        }
        else{
            stg.setTitle("Game Over!");
            stg.setWidth(470);
            stg.setHeight(270);
        }
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}
