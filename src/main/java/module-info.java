module com.weymar87 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.weymar87 to javafx.fxml;
    exports com.weymar87;
}
