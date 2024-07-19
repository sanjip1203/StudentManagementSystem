package com.example.college_project.IdPassword;

import com.example.college_project.HelloApplication;
import com.opencsv.CSVWriter;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class signup {

@FXML
    private TextField signupname;
    @FXML
    private TextField signupemail;
    @FXML
    private PasswordField signuppassword;
    @FXML
    private PasswordField signuprpassword;
    @FXML
    private TextField signupphone;
    @FXML
    private RadioButton signupmale;
    @FXML
    private ChoiceBox<String>signupchoice;
    @FXML
    private Button signupbutton;




    public void initialize(URL location, ResourceBundle resources) {
        signupchoice.setItems(FXCollections.observableArrayList("Teacher", "Student", "Counseling","library","Admin"));
    }

    @FXML
    public void filewrite(){
        String username = signupname.getText();
        String useremail = signupemail.getText();
        String userpassword = signuppassword.getText();
        String userrpassword2 = signuprpassword.getText();
        String userphone = signupphone.getText();
        String user = signupchoice.getValue();
        String gender;
        if (signupmale.isSelected()){
             gender = "Male";
        }
        else {
             gender  = "Female";
        }
        File file = new File("database/userdata.csv");
        try {
            // Ensure the directory existsFile file;
            file.getParentFile().mkdirs();

            // Create the file if it does not exist
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            String[] data = {username, useremail, userpassword, userrpassword2, userphone, user, gender};
            csvWriter.writeNext(data);
            csvWriter.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            // Load the login FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/college_project/PassrwordVerification/login.fxml"));
            Parent loginPage = loader.load();

            // Get the current stage from the signup button
            Stage stage = (Stage) signupbutton.getScene().getWindow(); // Change: Get current stage

            // Set the scene to the login page
            Scene scene = new Scene(loginPage); // Change: Create a new scene with the login page
            stage.setScene(scene); // Change: Set the scene on the current stage
            stage.show(); // Change: Show the stage
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
