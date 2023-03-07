package com.weymar87;

import com.weymar87.base.Soils;
import com.weymar87.base.SoilTypes;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;

public class SecondaryController {

    Stage materialWindow;
    App app;
    boolean okClicked = false;

    @FXML
    private TableView<Soils> baseMaterials;
    @FXML
    private TableColumn<Soils, String> nameMaterial;
    @FXML
    private TableColumn<Soils, Double> Cf;
    @FXML
    private TableColumn<Soils, Double> lamdaF;
    @FXML
    private TableColumn<Soils, Double> Tbf;
    @FXML
    private TableColumn<Soils, Double> il;
    @FXML
    private TableColumn<Soils, SoilTypes> typeSoil;
    @FXML
    private TableColumn<Soils, Boolean> useDsal;

    @FXML
    private TableColumn<Soils, Double> Dsal;

    @FXML
    private void initialize() {
        nameMaterial.setCellValueFactory(cellData -> cellData.getValue().nameMaterialProperty());
        Cf.setCellValueFactory(cellData -> cellData.getValue().cfProperty().asObject());
        lamdaF.setCellValueFactory(cellData -> cellData.getValue().lamdaFProperty().asObject());
        Tbf.setCellValueFactory(cellData -> cellData.getValue().tbfProperty().asObject());
        il.setCellValueFactory(cellData -> cellData.getValue().ilProperty().asObject());
        useDsal.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Soils, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Soils, Boolean> soilsBooleanCell) {
                Soils soils = soilsBooleanCell.getValue();
                SimpleBooleanProperty booleanProperty = new SimpleBooleanProperty(soils.isUseDsal());
                booleanProperty.addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                        soils.setUseDsal(t1);
                        if (t1) {
                            Dsal.setEditable(true);
                        } else if (t1 != true) {
                            Dsal.setEditable(false);
                        }
                    }
                });
                return booleanProperty;
            }
        });
        useDsal.setCellFactory(new Callback<TableColumn<Soils, Boolean>, TableCell<Soils, Boolean>>() {
            @Override
            public TableCell<Soils, Boolean> call(TableColumn<Soils, Boolean> soilsBooleanTableColumn) {
                CheckBoxTableCell<Soils, Boolean> cell = new CheckBoxTableCell<>();
                return cell;
            }
        });
        Dsal.setCellValueFactory(cellData -> cellData.getValue().dsalProperty().asObject());
        typeSoil.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Soils, SoilTypes>, ObservableValue<SoilTypes>>() {
            @Override
            public ObservableValue<SoilTypes> call(TableColumn.CellDataFeatures<Soils, SoilTypes> materialsStringCellDataFeatures) {
                Soils soils = materialsStringCellDataFeatures.getValue();
                String code = soils.getSoilTypes();
                SoilTypes soilTypes = SoilTypes.getByCode(code);
                return new SimpleObjectProperty<>(soilTypes);
            }
        });
        typeSoil.setOnEditCommit((TableColumn.CellEditEvent<Soils, SoilTypes> event) -> {
            TablePosition<Soils, SoilTypes> position = event.getTablePosition();
            SoilTypes newSoilTypes = event.getNewValue();

            int row = position.getRow();
            Soils soils = event.getTableView().getItems().get(row);

            soils.setSoilTypes(newSoilTypes.getCode());
        });

        nameMaterial.setCellFactory(TextFieldTableCell.forTableColumn());
        nameMaterial.setOnEditCommit(
                t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setNameMaterial(t.getNewValue())
        );

        Cf.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        Cf.setOnEditCommit(
                t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setDsal(t.getNewValue())
        );

        lamdaF.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        lamdaF.setOnEditCommit(
                t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setLamdaF(t.getNewValue())
        );

        Tbf.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        Tbf.setOnEditCommit(
                t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setTbf(t.getNewValue())
        );

        il.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        il.setOnEditCommit(
                t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setIl(t.getNewValue())
        );

        Dsal.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        Dsal.setOnEditCommit(
                t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setDsal(t.getNewValue())
        );
        Dsal.setEditable(false);
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
    private void addSoil() {
        app.getListMaterials().add(new Soils("ИГЭ", SoilTypes.SAND.getCode(),
                00000.00, 0.00, 0.0, 0.0, 0.0, false));
    }
}