package com.weymar87;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField


    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
