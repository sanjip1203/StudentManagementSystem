module com.example.college_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop; // For using JOptionPane

    opens com.example.college_project to javafx.fxml;

    exports com.example.college_project;
    exports com.example.college_project.mainControler;
    opens com.example.college_project.mainControler to javafx.fxml;
    exports com.example.college_project.IdPassword;
    opens com.example.college_project.IdPassword to javafx.fxml;
}