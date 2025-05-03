module com.bugeverywhere.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires static lombok;
    requires java.sql;

    opens com.bugeverywhere.app to javafx.fxml;
    exports com.bugeverywhere.app;
    exports com.bugeverywhere.app.viewmodel;
    opens com.bugeverywhere.app.viewmodel to javafx.fxml;
}