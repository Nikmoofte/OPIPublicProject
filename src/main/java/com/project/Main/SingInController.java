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


/**
 * Control the Sting In window
 */
public class SingInController {
    public Label IOErrorMessage;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;
    public static String Name;
    public static final int SizeOfAccountInfo = 14;
    public static int lineCount;

    /**
     * Checking login and password and loading account statistic into Stats arr
     * @param login
     * @param password
     * @return True if login and password are valid and false else
     * @throws IOException If something wrong
     */
    public static boolean Login(String login, String password) throws IOException {
        FileReader accounts = new FileReader("Accounts.txt");
        BufferedReader reader = new BufferedReader(accounts);
        boolean exit_flag = false;
        while(!exit_flag)
        {
            String line = reader.readLine();
            lineCount++;
            if (line == null)
                exit_flag = true;
            else
            {
                String[] AccountInfo = line.split(" ");
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
        lineCount = 0;
        return false;
    }

    /**
     * Sets actions on buttons
     * Open Registration window
     * Open Main Menu window if password is valid
     */
    @FXML
    void initialize() {
        lineCount = 0;
        signUpButton.setOnAction(actionEvent -> {
            signUpButton.getScene().getWindow().hide();
            try {
                StartUp.CreateNewWindow(FXMLLoader.load(Objects.requireNonNull(SingInController.class.getResource("Registration.fxml"))), 700, 400);
            } catch (IOException e) {
                System.out.println("");
            }


        });
        signInButton.setOnAction(actionEvent -> {
           String login = login_field.getText(), password = password_field.getText();
            try {
                if(Login(login, password))
                {
                    Name = login;
                    signInButton.getScene().getWindow().hide();
                    StartUp.CreateNewWindow(FXMLLoader.load(Objects.requireNonNull(StartUp.class.getResource("main-menu.fxml"))), 700, 500);
                }
                else
                {
                    IOErrorMessage.setText("Invalid login or password");
                }
            } catch (IOException e) {
                System.out.println("Error occured in login part");
            }

        });

    }


}
