package com.weymar87;

import com.weymar87.base.Materials;
import com.weymar87.base.SoilTypes;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;

public class SecondaryController {

    Stage materialWindow;
    App app;
    boolean okClicked = false;

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
    private TableColumn<Materials, SoilTypes> typeSoil;

    @FXML
    private void initialize() {
        nameMaterial.setCellValueFactory(cellData -> cellData.getValue().nameMaterialProperty());
        Cf.setCellValueFactory(cellData -> cellData.getValue().cfProperty().asObject());
        lamdaF.setCellValueFactory(cellData -> cellData.getValue().lamdaFProperty().asObject());
        Tbf.setCellValueFactory(cellData -> cellData.getValue().tbfProperty().asObject());
        il.setCellValueFactory(cellData -> cellData.getValue().ilProperty().asObject());
        typeSoil.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Materials, SoilTypes>, ObservableValue<SoilTypes>>() {
            @Override
            public ObservableValue<SoilTypes> call(TableColumn.CellDataFeatures<Materials, SoilTypes> materialsStringCellDataFeatures) {
                Materials materials = materialsStringCellDataFeatures.getValue();
                String code = materials.getSoilTypes();
                SoilTypes soilTypes = SoilTypes.getByCode(code);
                return new SimpleObjectProperty<>(soilTypes);
            }
        });
        typeSoil.setOnEditCommit((TableColumn.CellEditEvent<Materials, SoilTypes> event) -> {
            TablePosition<Materials, SoilTypes> position = event.getTablePosition();
            SoilTypes newSoilTypes = event.getNewValue();

            int row = position.getRow();
            Materials materials = event.getTableView().getItems().get(row);

            materials.setSoilTypes(newSoilTypes.getCode());
        });

        nameMaterial.setCellFactory(TextFieldTableCell.forTableColumn());
        nameMaterial.setOnEditCommit(
                t -> t.getTableView().

                        getItems().

                        get(
                                t.getTablePosition().

                                        getRow()).

                        setNameMaterial(t.getNewValue())
        );


    }

    public void setApp(App app) {
        this.app = app;
        baseMaterials.setItems(app.getListMaterials());
        typeSoil.setCellFactory(ComboBoxTableCell.forTableColumn(app.getTypeSoil()));
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
        app.getListMaterials().add(new Materials("ИГЭ",SoilTypes.SAND.getCode(), 00000.00, 0.00, 0.0, 0.0));
    }
}