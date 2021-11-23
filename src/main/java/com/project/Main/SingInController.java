package com.project.Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



public class SingInController {
    public Label IOErrorMessage;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    public static final int SizeOfAccountInfo = 14;
    public static boolean Login(String login, String password) throws IOException {
        FileReader accounts = new FileReader("Accounts.txt");
        BufferedReader reader = new BufferedReader(accounts);
        boolean exit_flag = false;
        while(!exit_flag)
        {
            String line = reader.readLine();
            if (line == null)
                exit_flag = true;
            else
            {
                String[] AccountInfo = line.split(" ");
                System.out.println(AccountInfo[0] + " " + login);
                System.out.println(AccountInfo[1] + " " + password);
                if (AccountInfo[0].equals(login) && AccountInfo[1].equals(password))
                {
                    for (int i = 2; i < SizeOfAccountInfo; i++)
                        MainMenuController.Stats[i - 2] = Integer.parseInt(AccountInfo[i]);
                    reader.close();
                    accounts.close();
                    return true;
                }
            }
        }
            return false;
    }
    @FXML
    void initialize() {
        signUpButton.setOnAction(actionEvent -> {
            signUpButton.getScene().getWindow().hide();
            try {
                StartUp.CreateNewWindow(FXMLLoader.load(Objects.requireNonNull(SingInController.class.getResource("Registration.fxml"))), 700, 400);
            } catch (IOException e) {
            }


        });
        signInButton.setOnAction(actionEvent -> {
           String login = login_field.getText(), password = password_field.getText();
            try {
                if(Login(login, password))
                {
                    signInButton.getScene().getWindow().hide();
                    StartUp.CreateNewWindow(FXMLLoader.load(Objects.requireNonNull(StartUp.class.getResource("main-menu.fxml"))), 700, 500);
                }
                else
                {
                    IOErrorMessage.setText("Invalid login or password");
                }
            } catch (IOException e) {
            }

        });

    }


}
