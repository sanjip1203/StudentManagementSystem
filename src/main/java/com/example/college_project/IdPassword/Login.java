package com.example.college_project.IdPassword;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Login {

    @FXML
    TextField loginemail;

    @FXML
    PasswordField loginpassword;

    private Stage stage ;
    private Scene scene;
    private Parent root;

    public void loginbutton (ActionEvent event) throws IOException{

        String email = loginemail.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signup.fxml"));
        root = loader.load();
        String password = loginpassword.getText();
      //  root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
