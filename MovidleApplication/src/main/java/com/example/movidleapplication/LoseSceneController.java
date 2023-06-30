package com.example.movidleapplication;

import com.example.movidleapplication.MovidleApplication;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class LoseSceneController {

    @FXML
    Button btnRestart;

    @FXML
    Button btnExit;


    public void btnRestartOnAction(ActionEvent event) throws IOException, InterruptedException {
      MovidleApplication main=new MovidleApplication();
      main.changeScene("movidle.fxml");
    }

    public void btnExitOnAction(ActionEvent event) throws IOException, InterruptedException {
        Platform.exit();
    }
}
