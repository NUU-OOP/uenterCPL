package org.example;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class Vais {

    public GridPane createEntranceForm() {
        // Create labels and inputs
        Label carNumberLabel = new Label("Car Number:");
        TextField carNumberInput = new TextField();

        Label carTypeLabel = new Label("Car Type:");
        ComboBox<String> carTypeComboBox = new ComboBox<>();
        carTypeComboBox.getItems().addAll("Sedan", "SUV", "Truck", "Motorcycle");

        Label ticketNumberLabel = new Label("Ticket Number:");
        TextField ticketNumberInput = new TextField();
        ticketNumberInput.setEditable(false);

        Button generateTicketButton = new Button("Generate Ticket");

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

        // Generate ticket number on button click
        generateTicketButton.setOnAction(e -> {
            String ticketNumber = "T" + (int) (Math.random() * 10000);
            ticketNumberInput.setText(ticketNumber);
        });

        return gridPane;
    }
}
