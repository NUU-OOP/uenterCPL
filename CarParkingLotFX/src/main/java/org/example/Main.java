package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create BorderPane layout for the main window
        BorderPane borderPane = new BorderPane();

        // Bottom section with rectangles
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(5);
        hBox.getChildren().addAll(rectangle(10)); // Add 10 rectangles at the bottom
        borderPane.setBottom(hBox);

        // Left section with custom component (Sirojiddin)
        borderPane.setLeft(new Sirojiddin());

        // Set up the scene and primary stage
        Scene scene = new Scene(borderPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Window");
        primaryStage.show();

        // Open the second window (parking entrance form) in a separate stage
        openVaisWindow();
    }

    // Method to open the Vais form in a new window
    private void openVaisWindow() {
        // Create a new stage (new window) for the parking entrance form
        Stage vaisStage = new Stage();
        vaisStage.setTitle("Car Parking Entrance");

        // Get the parking form from Vais class
        Vais vais = new Vais();
        GridPane parkingForm = vais.createEntranceForm();

        // Set up the scene for the new window
        Scene vaisScene = new Scene(parkingForm, 300, 200);
        vaisStage.setScene(vaisScene);

        // Show the new window
        vaisStage.show(); // Show without blocking the main window
    }

    // Method to create a list of rectangles
    public List<Rectangle> rectangle(int number) {
        List<Rectangle> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Rectangle rectangle = new Rectangle();
            rectangle.setArcHeight(10);
            rectangle.setArcWidth(10);
            rectangle.setWidth(50);
            rectangle.setHeight(100);
            rectangle.setStrokeWidth(3);
            rectangle.setFill(Color.GREEN);
            rectangle.setStroke(Color.BLACK);
            list.add(rectangle);
        }
        return list;
    }

    public static void main(String[] args) {
        launch(args); // Launch JavaFX application
    }
}
