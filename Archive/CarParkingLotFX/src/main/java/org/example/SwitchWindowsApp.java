package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SwitchWindowsApp extends Application {

    private BorderPane mainLayout;  // The main layout where views will be swapped

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Switch Windows Example");

        // ComboBox for selecting the window
        ComboBox<String> windowSelector = new ComboBox<>();
        windowSelector.getItems().addAll("Window 1", "Window 2");
        windowSelector.setValue("Window 1");

        // Main layout where the selected view will be displayed
        mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(15));

        // Set the initial view to "Window 1"
        showWindow1();

        // Change view when a different item is selected from the ComboBox
        windowSelector.setOnAction(e -> {
            String selectedWindow = windowSelector.getValue();
            if (selectedWindow.equals("Window 1")) {
                showWindow1();
            } else if (selectedWindow.equals("Window 2")) {
                showWindow2();
            }
        });

        // Layout with ComboBox at the top and main view area below
        VBox rootLayout = new VBox(10, windowSelector, mainLayout);
        rootLayout.setPadding(new Insets(20));

        Scene scene = new Scene(rootLayout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Display the first "window"
    private void showWindow1() {
        VBox window1 = new VBox();
        window1.setSpacing(10);
        window1.getChildren().add(new Label("This is Window 1"));
        mainLayout.setCenter(window1);  // Set window1 as the center of mainLayout
    }

    // Display the second "window"
    private void showWindow2() {
        VBox window2 = new VBox();
        window2.setSpacing(10);
        window2.getChildren().add(new Label("This is Window 2"));
        mainLayout.setCenter(window2);  // Set window2 as the center of mainLayout
    }

    public static void main(String[] args) {
        launch(args);
    }
}
