package com.weymar87;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class PrimaryController {
    App app;

    @FXML
    private ComboBox<Integer> pileDiameter;

    public void setApp(App app) {
        this.app = app;
        this.pileDiameter.getItems().addAll(app.getListPile());
    }

    @FXML
    private void initialize() {
    }

    @FXML
    private void showBaseMaterial() {
        app.getListMaterialsCopy().clear();
        app.getListMaterialsCopy().addAll(app.getListMaterials());
        app.showBaseMaterial();
    }

    @FXML
    private void closeApp() {
        app.getPrimaryStage().close();
    }
}
