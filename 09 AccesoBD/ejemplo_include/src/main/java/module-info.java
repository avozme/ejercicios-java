module com.iescelia {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens com.iescelia to javafx.fxml;
    exports com.iescelia;
}
