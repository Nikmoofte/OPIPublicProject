package com.project.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


/**
 * Starts up the program
 */
public class StartUp extends Application {
    public static final String ProgramName = "P.R.O.J.E.C.T Casino";


    /**
     * Creates new window
     * @param window Loaded fxml file
     * @param w width of window
     * @param h height of window
     */
    static public void CreateNewWindow(Parent window, int w, int h)
    {
        Scene scene = new Scene(window, w, h);
        Stage stage = new Stage();
        stage.setTitle(ProgramName);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * opens SingIn window
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException
    {
        CreateNewWindow(FXMLLoader.load(Objects.requireNonNull(StartUp.class.getResource("SingIn.fxml"))), 700, 400);
    }

    /**
     * Starts program
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}