package com.project.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class StartUp extends Application {
    public static final String ProgramName = "P.R.O.J.E.C.T Casino";


    static public void CreateNewWindow(Parent window, int w, int h)
    {
        Scene scene = new Scene(window, w, h);
        Stage stage = new Stage();
        stage.setTitle(ProgramName);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        CreateNewWindow(FXMLLoader.load(Objects.requireNonNull(StartUp.class.getResource("SingIn.fxml"))), 700, 400);
    }

    public static void main(String[] args) {
        launch();
    }
}