package com.example.college_project.IdPassword;

import com.opencsv.CSVReader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Login {

    @FXML
    TextField loginemail;

    @FXML
    PasswordField loginpassword;

    @FXML
    public void systemlogin(ActionEvent actionEvent) {
        String email = loginemail.getText();
        String password = loginpassword.getText();

        try (CSVReader reader = new CSVReader(new FileReader("database/userdata.csv"))) {
            List<String[]> allUsers = reader.readAll();
            for (String[] user : allUsers) {
                if (user.length < 6) {
                    // Skip rows with insufficient data
                    continue;
                }

                String userEmail = user[1];
                String userPassword = user[2];
                String userRole = user[5];

                if (email.equals(userEmail) && password.equals(userPassword)) {
                    switch (userRole) {
                        case "Teacher":
                            loadFXML(actionEvent, "/com/example/college_project/teacher/teacherDashboard.fxml");
                            break;
                        case "Student":
                            loadFXML(actionEvent, "/com/example/college_project/students/StudentDashboard.fxml");
                            break;
                        case "Counseling":
                            loadFXML(actionEvent, "/com/example/college_project/Counseling/Counseling Dashboard.fxml");
                            break;
                        case "library":
                            loadFXML(actionEvent, "/com/example/college_project/LIbrary/LIbraryDashboard.fxml");
                            break;
                        case "Admin":
                            loadFXML(actionEvent, "/com/example/college_project/Admin/AdminDashboard.fxml");
                            break;
                        default:
                            showAlert("Error", "Invalid role specified for the user.");
                            break;
                    }
                    return;
                }
            }
            showAlert("Error", "Invalid email or password");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while reading the user data.");
        }
    }

    private void loadFXML(ActionEvent actionEvent, String fxmlFile) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while loading the page.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    public void systemsignup(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/college_project/PassrwordVerification/Signup.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while loading the signup page.");
        }
    }
}
