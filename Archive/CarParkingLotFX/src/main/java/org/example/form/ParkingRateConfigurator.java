package org.example.form;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ParkingRateConfigurator extends Application {

    private TextField firstHourRateField;
    private TextField secondThirdHourRateField;
    private TextField remainingHoursRateField;
    private ListView<String> rateListView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Parking Rate Configurator");

        // Initialize fields
        firstHourRateField = new TextField();
        secondThirdHourRateField = new TextField();
        remainingHoursRateField = new TextField();
        rateListView = new ListView<>();

        Label firstHourLabel = new Label("Rate for the 1st hour:");
        Label secondThirdHourLabel = new Label("Rate for the 2 hour");
        Label remainingHoursLabel = new Label("Rate for remaining hours:");
        Button saveButton = new Button("Save Rates");
        saveButton.setOnAction(e -> saveRates());

        // Layout setup
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(firstHourLabel, 0, 0);
        grid.add(firstHourRateField, 1, 0);
        grid.add(secondThirdHourLabel, 0, 1);
        grid.add(secondThirdHourRateField, 1, 1);
        grid.add(remainingHoursLabel, 0, 2);
        grid.add(remainingHoursRateField, 1, 2);
        grid.add(saveButton, 1, 3);
        grid.add(rateListView, 0, 4, 2, 1);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void saveRates() {
        String firstHourRate = firstHourRateField.getText();
        String secondThirdHourRate = secondThirdHourRateField.getText();
        String remainingHoursRate = remainingHoursRateField.getText();

        // Validation (You can add more comprehensive validation)
        if (firstHourRate.isEmpty() || secondThirdHourRate.isEmpty() || remainingHoursRate.isEmpty()) {
            showAlert("Please fill in all fields");
            return;
        }

        // Updating the ListView with the new rates
        rateListView.getItems().clear();
        rateListView.getItems().add("1st Hour Rate: $" + firstHourRate);
        rateListView.getItems().add("2nd & 3rd Hour Rate: $" + secondThirdHourRate);
        rateListView.getItems().add("Remaining Hours Rate: $" + remainingHoursRate);

        // Here you would save to a database or configuration file
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
