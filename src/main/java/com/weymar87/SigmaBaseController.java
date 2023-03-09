package com.weymar87;

import com.weymar87.base.SigmaBaseRow;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

public class SigmaBaseController {
    App app;
    Stage sigmaBaseWindow;
    @FXML
    private TableView<SigmaBaseRow> sigmaBaseTableView;

    @FXML
    private TableColumn<SigmaBaseRow, String> meteostation;

    @FXML
    private TableColumn<SigmaBaseRow, Double> latitude;
    @FXML
    private TableColumn<SigmaBaseRow, Double> longtitude;
    @FXML
    private TableColumn<SigmaBaseRow, Double> sigma;

    public void setApp(App app) {
        this.app = app;
        sigmaBaseTableView.setItems(app.getSigmaBase().getSigmaBase());
    }

    @FXML
    private void initialize() {
        meteostation.setCellValueFactory(cellData -> cellData.getValue().meteostationProperty());
        latitude.setCellValueFactory(cellData -> cellData.getValue().latitudeProperty().asObject());
        longtitude.setCellValueFactory(cellData -> cellData.getValue().longtitudeProperty().asObject());
        sigma.setCellValueFactory(cellData -> cellData.getValue().sigmaProperty().asObject());
        meteostation.setCellFactory(TextFieldTableCell.forTableColumn());
        latitude.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        longtitude.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        sigma.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    }
    public void setSigmaBaseWindow(Stage sigmaBaseWindow) {
        this.sigmaBaseWindow = sigmaBaseWindow;
    }

    public void handleClose() {
        sigmaBaseWindow.close();
    }

}
