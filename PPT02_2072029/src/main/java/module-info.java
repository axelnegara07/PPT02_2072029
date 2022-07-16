module com.example.ppt02_2072029 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.ppt02_2072029 to javafx.fxml;
    exports com.example.ppt02_2072029;
    exports com.example.ppt02_2072029.Model;
}