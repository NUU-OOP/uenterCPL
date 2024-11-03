package org.example.spots;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Menu
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem menuItemOpen = new MenuItem("Open Modal");

        // Add menu items to menu
        menuFile.getItems().add(menuItemOpen);
        menuBar.getMenus().add(menuFile);

        // Layout
        VBox root = new VBox(menuBar);

        // Set action on menu item to open a modal window
        menuItemOpen.setOnAction(event -> openModalWindow(primaryStage));

        // Scene
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Main Window");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openModalWindow(Stage owner) {
        // Create a new stage for the modal window
        Stage modalStage = new Stage();
        modalStage.setTitle("Modal Window");
        modalStage.initModality(Modality.WINDOW_MODAL);
        modalStage.initOwner(owner);

        // Create a simple scene for the modal stage
        VBox modalRoot = new VBox(new Label("Modal Window"));
        Scene modalScene = new Scene(modalRoot, 200, 100);
        modalStage.setScene(modalScene);

        // Show and wait for the modal stage to close
        modalStage.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
