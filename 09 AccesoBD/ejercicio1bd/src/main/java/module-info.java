module com.iescelia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens com.iescelia to javafx.fxml;
    exports com.iescelia;
}
