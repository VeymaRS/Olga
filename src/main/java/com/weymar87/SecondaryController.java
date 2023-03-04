package com.weymar87;

import com.weymar87.base.Materials;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class SecondaryController {

    Stage materialWindow;
    boolean okClicked = false;
    App app;
    @FXML
    private TableView<Materials> baseMaterials;
    @FXML
    private TableColumn<Materials, String> nameMaterial;
    @FXML
    private TableColumn<Materials, Double> Cf;
    @FXML
    private TableColumn<Materials, Double> lamdaF;
    @FXML
    private TableColumn<Materials, Double> Tbf;
    @FXML
    private TableColumn<Materials, Double> il;

    @FXML
    private void initialize() {
        nameMaterial.setCellValueFactory(cellData -> cellData.getValue().nameMaterialProperty());
        Cf.setCellValueFactory(cellData -> cellData.getValue().cfProperty().asObject());
        lamdaF.setCellValueFactory(cellData -> cellData.getValue().lamdaFProperty().asObject());
        Tbf.setCellValueFactory(cellData -> cellData.getValue().tbfProperty().asObject());
        il.setCellValueFactory(cellData -> cellData.getValue().ilProperty().asObject());

        nameMaterial.setCellFactory(TextFieldTableCell.forTableColumn());
        nameMaterial.setOnEditCommit(
                t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNameMaterial(t.getNewValue())
        );
    }

    public void setApp(App app) {
        this.app = app;
        baseMaterials.setItems(app.getListMaterials());
    }

    public void setMaterialWindow(Stage materialWindow) {
        this.materialWindow = materialWindow;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleSave() {
        okClicked = true;
        materialWindow.close();
    }

    @FXML
    private void handleCancel() {
        app.getListMaterials().clear();
        app.getListMaterials().addAll(app.getListMaterialsCopy());
        materialWindow.close();
    }

    @FXML
    private void addMaterial() {
        app.getListMaterials().add(new Materials("New Soil", 00000.00, 0.00, 0.0, 0.0));
    }
}