package com.example.college_project.Admin;

import com.example.college_project.basecontroller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class TeacherManagement extends basecontroller {
    @FXML
    public void adminlogout(ActionEvent event) throws IOException {
        switchScene(event, "/com/example/college_project/Admin/AdminLogout.fxml");
    }

    @FXML
    public void admindashboard(ActionEvent event) throws IOException {
        switchScene(event, "/com/example/college_project/Admin/AdminDashboard.fxml");
    }

    @FXML
    public void counselingdata(ActionEvent event) throws IOException {
        switchScene(event, "/com/example/college_project/Admin/CounselingData.fxml");
    }

    @FXML
    public void staffmanagement(ActionEvent event) throws IOException {
        switchScene(event, "/com/example/college_project/Admin/StaffManagement.fxml");
    }

    @FXML
    public void studentmanagement (ActionEvent event) throws IOException {
        switchScene(event, "/com/example/college_project/Admin/StudentManagement.fxml");
    }

    @FXML
    public void teachermanagement(ActionEvent event) throws IOException {
        switchScene(event, "/com/example/college_project/Admin/TeacherManagement.fxml");
    }

}
