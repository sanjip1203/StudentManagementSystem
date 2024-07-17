package com.example.college_project.IdPassword;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.*;
import java.io.FileReader;
import java.util.Scanner;

public class Login {
    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtpassword;

    @FXML
    public void logindata(ActionEvent evt) {
        String email = txtemail.getText();
        String password = txtpassword.getText();

        try (FileReader fr = new FileReader("login.txt")) {
            Scanner sc = new Scanner(fr);
            sc.useDelimiter("[,\n]");

            while (sc.hasNext()) {
                String em = sc.next();
                String pw = sc.next();
                if (email.equals(em.trim()) && password.equals(pw.trim())) {
                    sc.close();
                    JOptionPane.showMessageDialog(null, "Login successful");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Invalid login details");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
    }

    @FXML
    public void openSignup(ActionEvent evt) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Sign Up");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
