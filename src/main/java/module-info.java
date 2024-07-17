module com.example.college_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.college_project to javafx.fxml;
    exports com.example.college_project;
}