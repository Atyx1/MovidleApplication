module com.example.movidleapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.movidleapplication to javafx.fxml;
    exports com.example.movidleapplication;

}