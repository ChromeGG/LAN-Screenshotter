module ssmaker {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.media;
    requires javafx.fxml;

    exports com.lanssmaker.main to javafx.graphics;
    opens com.lanssmaker.controller to javafx.fxml;
}