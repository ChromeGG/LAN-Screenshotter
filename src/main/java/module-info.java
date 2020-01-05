module ssmaker {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.media;
    requires javafx.fxml;
    requires org.apache.commons.io;
    requires java.desktop;
//    requires lombok;

    exports com.lanssmaker.main to javafx.graphics;
    opens com.lanssmaker.controller to javafx.fxml;
    opens com.lanssmaker.logger.log to javafx.base;
    opens com.lanssmaker.connector.client to javafx.base;

    opens com.lanssmaker.main;
}
