package com.weymar87;

import com.weymar87.base.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private Stage primaryStage;
    private BorderPane rootLayout;
    PrimaryController primaryController;

    private SigmaBase sigmaBase = new SigmaBase();
    private ObservableList<Integer> listPile = FXCollections.observableArrayList();
    private ObservableList<Soils> baseSoils = FXCollections.observableArrayList();
    private ObservableList<Soils> baseSoilsCopy = FXCollections.observableArrayList();
    private ObservableList<SoilTypes> typeSoil = FXCollections.observableArrayList(SoilTypes.values());
    private ObservableList<Hole> hole = FXCollections.observableArrayList();


    public App() {
        listPile.add(89);
        listPile.add(114);
        listPile.add(159);
        listPile.add(219);
        listPile.add(273);
        baseSoils.add(
                new Soils("ИГЭ", SoilTypes.SAND.getCode(),
                        00000.00, 0.00, 0.0, 0.0, 0.0, false));
    }

    public ObservableList<Integer> getListPile() {
        return listPile;
    }

    public ObservableList<Soils> getListMaterials() {
        return baseSoils;
    }

    public ObservableList<Soils> getListMaterialsCopy() {
        return baseSoilsCopy;
    }

    public ObservableList<SoilTypes> getTypeSoil() {
        return typeSoil;
    }

    public ObservableList<Hole> getHole() {
        return hole;
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("SunnyFroze");

        initRootLayout();
    }

    public void initRootLayout() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
            rootLayout = (BorderPane) fxmlLoader.load();
            scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryController = fxmlLoader.getController();
            primaryController.setApp(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showBaseMaterial() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("soilBaseWindow.fxml"));
            VBox baseMaterialWindow = (VBox) fxmlLoader.load();
            Stage materialWindow = new Stage();
            materialWindow.initModality(Modality.WINDOW_MODAL);
            materialWindow.initOwner(primaryStage);
            materialWindow.setScene(new Scene(baseMaterialWindow));
            SoilBaseController soilBaseController = fxmlLoader.getController();
            soilBaseController.setSoilBaseWindow(materialWindow);
            soilBaseController.setApp(this);
            materialWindow.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSigmaBase() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("sigmaBaseWindow.fxml"));
            VBox sigmaBaseWindow = (VBox) fxmlLoader.load();
            Stage sigmaBase = new Stage();
            sigmaBase.initModality(Modality.WINDOW_MODAL);
            sigmaBase.initOwner(primaryStage);
            sigmaBase.setScene(new Scene(sigmaBaseWindow));
            SigmaBaseController sigmaBaseController = fxmlLoader.getController();
            sigmaBaseController.setSigmaBaseWindow(sigmaBase);
            sigmaBaseController.setApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public SigmaBase getSigmaBase() {
        return sigmaBase;
    }
    public static void main(String[] args) {
        launch();
    }

}