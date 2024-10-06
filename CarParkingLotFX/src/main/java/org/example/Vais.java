package org.example;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Vais {

    // Declare fields for ticket information
    private TextField carNumberInput;
    private ComboBox<String> carTypeComboBox;
    private TextField ticketNumberInput;

    public GridPane createEntranceForm() {
        // Create labels and inputs
        Label carNumberLabel = new Label("Car Number:");
        carNumberInput = new TextField();

        Label carTypeLabel = new Label("Car Type:");
        carTypeComboBox = new ComboBox<>();
        carTypeComboBox.getItems().addAll("Sedan", "SUV", "Truck", "Motorcycle");

        Label ticketNumberLabel = new Label("Ticket Number:");
        ticketNumberInput = new TextField();
        ticketNumberInput.setEditable(false); // Ticket number is auto-generated, so not editable.

        Button generateTicketButton = new Button("Generate Ticket");
        Button resetButton = new Button("Reset"); // Button to reset the form

        // Layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Add to layout
        gridPane.add(carNumberLabel, 0, 0);
        gridPane.add(carNumberInput, 1, 0);
        gridPane.add(carTypeLabel, 0, 1);
        gridPane.add(carTypeComboBox, 1, 1);
        gridPane.add(ticketNumberLabel, 0, 2);
        gridPane.add(ticketNumberInput, 1, 2);
        gridPane.add(generateTicketButton, 1, 3);
        gridPane.add(resetButton, 0, 3); // Add reset button to layout

        // Generate ticket number and show details in a new window
        generateTicketButton.setOnAction(e -> {
            // Check if car number and car type are entered
            if (carNumberInput.getText().isEmpty() || carTypeComboBox.getValue() == null) {
                showAlert("Missing Information", "Please enter car number and select car type.");
                return;
            }

            // Get entered information and convert car number to uppercase
            String carNumber = carNumberInput.getText().toUpperCase();
            String carType = carTypeComboBox.getValue();
            // Generate ticket number
            String ticketNumber = "T" + (int) (Math.random() * 10000);
            ticketNumberInput.setText(ticketNumber); // Update the ticket number in the main window.

            // Show the information in the next window
            showTicketDetailsWindow(carNumber, carType, ticketNumber);

            // Automatically reset the form after ticket generation
            resetForm();
        });

        // Reset button action
        resetButton.setOnAction(e -> resetForm());

        return gridPane;
    }

    // Method to show the ticket details in a new window
    private void showTicketDetailsWindow(String carNumber, String carType, String ticketNumber) {
        Stage detailsStage = new Stage();
        detailsStage.setTitle("Ticket Details");

        // Create labels for the details
        Label carNumberLabel = new Label("Car Number: " + carNumber);
        Label carTypeLabel = new Label("Car Type: " + carType);
        Label ticketNumberLabel = new Label("Ticket Number: " + ticketNumber);

        // Layout for the details window
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(carNumberLabel, carTypeLabel, ticketNumberLabel);

        // Set the scene and show the details window
        Scene scene = new Scene(vbox, 300, 150);
        detailsStage.setScene(scene);
        detailsStage.show();
    }

    // Method to show an alert in case of missing information
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Method to reset the form
    private void resetForm() {
        carNumberInput.clear();
        carTypeComboBox.getSelectionModel().clearSelection();
        ticketNumberInput.clear();
    }
}
