package com.example.college_project;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.swing.*;
import java.io.FileWriter;

public class signup {

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtphone;

    @FXML
    private TextField txtpassword;

    public signup() {
        // No need for initComponents, JavaFX handles FXML binding
    }

    @FXML
    public void logindata(javafx.event.ActionEvent evt) {
        String name = txtname.getText();
        String email = txtemail.getText();
        String phone = txtphone.getText();
        String password = txtpassword.getText();

        try (FileWriter wr = new FileWriter("login.txt", true)) {
            wr.write(name + "," + email + "," + phone + "," + password);
            wr.write(System.getProperty("line.separator"));
            JOptionPane.showMessageDialog(null, "Success");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
    }
}
