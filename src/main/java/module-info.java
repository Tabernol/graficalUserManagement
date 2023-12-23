module com.krasnopolskyi.graficalusermanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.zaxxer.hikari;
    requires java.sql;


    opens com.krasnopolskyi.graficalusermanagement.controller to javafx.fxml;
    exports com.krasnopolskyi.graficalusermanagement;
}