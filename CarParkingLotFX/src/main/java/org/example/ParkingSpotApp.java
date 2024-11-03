package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ParkingSpotApp extends Application implements Runnable{
    private BorderPane borderPane;

    @Override
    public void start(Stage primaryStage) throws SQLException {
        CustomMenuBar customMenuBar = new CustomMenuBar();
        BorderPane root = new BorderPane();
        //root.setPadding(new Insets(10,10,10,10));
        root.setTop(customMenuBar.createMenuBar(root));
        root.setCenter(new FirstFloor());
        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(root, 900, 600);
        primaryStage.setTitle("Welcome to Car Parking Lot");
        primaryStage.setScene(scene);

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args); // Launch the application
    }

    @Override
    public void run() {


    }
}
