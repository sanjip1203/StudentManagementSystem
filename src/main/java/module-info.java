module com.example.college_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires opencsv;

    exports com.example.college_project;
    exports com.example.college_project.IdPassword;
    opens com.example.college_project to javafx.fxml;
    opens com.example.college_project.IdPassword to javafx.fxml;
    opens com.example.college_project.Admin to javafx.fxml;

    exports com.example.college_project.Admin;
}