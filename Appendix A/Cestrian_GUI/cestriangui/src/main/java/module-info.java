module com.appendixa {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.appendixa to javafx.fxml;
    exports com.appendixa;
}
