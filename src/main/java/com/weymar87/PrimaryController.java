package com.weymar87;

import com.weymar87.base.Hole;
import com.weymar87.base.Soils;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;

public class PrimaryController {
    App app;

    @FXML
    private ComboBox<Integer> pileDiameter;

    @FXML
    private TableView<Hole> holeSoils;

    @FXML
    private TableColumn<Hole, Double> soilWidth;

    @FXML
    private TableColumn<Hole, Soils> soil;

    public void setApp(App app) {
        this.app = app;
        this.pileDiameter.getItems().addAll(app.getListPile());
        holeSoils.setItems(app.getHole());
        soil.setCellFactory(ComboBoxTableCell.forTableColumn(app.getListMaterials()));
    }

    @FXML
    private void initialize() {
        soilWidth.setCellValueFactory(cellData -> cellData.getValue().soilWidthProperty().asObject());
        soilWidth.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        soilWidth.setOnEditCommit(
                t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setSoilWidth(t.getNewValue())
        );
        soil.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Hole, Soils>, ObservableValue<Soils>>() {
            @Override
            public ObservableValue<Soils> call(TableColumn.CellDataFeatures<Hole, Soils> soilBase) {
                Soils soils = soilBase.getValue().getSoil();
                return new SimpleObjectProperty<>(soils);
            }
        });
    }

    @FXML
    private void showBaseSoils() {
        app.getListMaterialsCopy().clear();
        app.getListMaterialsCopy().addAll(app.getListMaterials());
        app.showBaseSoils();
    }

    @FXML
    private void showSigmaBase() {
        app.showSigmaBase();
    }

    @FXML
    private void closeApp() {
        app.getPrimaryStage().close();
    }

    @FXML
    private void addSoilInHole() {
        app.getHole().add(new Hole(0.0, app.getListMaterials().get(0)));
    }
}
