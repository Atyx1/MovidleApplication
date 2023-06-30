package com.example.movidleapplication;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class WinSceneController {

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
