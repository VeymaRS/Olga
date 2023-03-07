package com.weymar87;

import com.weymar87.base.Hole;
import com.weymar87.base.Materials;
import com.weymar87.base.SoilTypes;
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
    private ObservableList<Integer> listPile = FXCollections.observableArrayList();
    private ObservableList<Materials> baseSoils = FXCollections.observableArrayList();
    private ObservableList<Materials> baseSoilsCopy = FXCollections.observableArrayList();
    private ObservableList<SoilTypes> typeSoil = FXCollections.observableArrayList(SoilTypes.values());
    private ObservableList<Hole> hole = FXCollections.observableArrayList();

    public App() {
        listPile.add(89);
        listPile.add(114);
        listPile.add(159);
        listPile.add(219);
        listPile.add(273);
        baseSoils.add(
                new Materials("ИГЭ", SoilTypes.SAND.getCode(),
                        00000.00, 0.00, 0.0, 0.0, 0.0));
    }

    public ObservableList<Integer> getListPile() {
        return listPile;
    }

    public ObservableList<Materials> getListMaterials() {
        return baseSoils;
    }

    public ObservableList<Materials> getListMaterialsCopy() {
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
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("secondary.fxml"));
            VBox baseMaterialWindow = (VBox) fxmlLoader.load();
            Stage materialWindow = new Stage();
            materialWindow.initModality(Modality.WINDOW_MODAL);
            materialWindow.initOwner(primaryStage);
            materialWindow.setScene(new Scene(baseMaterialWindow));
            SecondaryController secondaryController = fxmlLoader.getController();
            secondaryController.setMaterialWindow(materialWindow);
            secondaryController.setApp(this);
            materialWindow.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}