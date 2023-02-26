package com.weymar87;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PrimaryController {
    App app;

    @FXML
    private ComboBox<String> pileDiameter;
    public void setApp(App app) {
        this.app = app;
        this.pileDiameter = new ComboBox<>(app.getListPile());
    }

    @FXML
    private void initialize() {

    }


//    @FXML
//    private void switchToSecondary() throws IOException {
//        App.setRoot("secondary");
//    }
}
