module com.emma.weatherhome {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;
    requires json.simple;

    opens com.emma.weatherhome to javafx.fxml;
    exports com.emma.weatherhome;
}