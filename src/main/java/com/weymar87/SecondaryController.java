package com.weymar87;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class SecondaryController {

    Stage materialWindow;
    boolean okClicked = false;

    public void setMaterialWindow(Stage materialWindow) {
        this.materialWindow = materialWindow;
    }

    public boolean isOkClicked() {
        return okClicked;
    }
    @FXML
private void handleOk(){


        okClicked = true;
        materialWindow.close();
    }

    @FXML
    private void handleCancel() {
        materialWindow.close();
    }
}