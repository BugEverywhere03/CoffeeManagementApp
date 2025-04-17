module com.bugeverywhere.coffeemanagementapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires static lombok;
    requires java.sql;

    opens com.bugeverywhere.coffeemanagementapp to javafx.fxml;
    exports com.bugeverywhere.coffeemanagementapp;
    exports com.bugeverywhere.coffeemanagementapp.viewmodel;
    opens com.bugeverywhere.coffeemanagementapp.viewmodel to javafx.fxml;
}