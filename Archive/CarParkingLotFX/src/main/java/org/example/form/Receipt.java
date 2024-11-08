package org.example.form;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Receipt extends GridPane {

    public Receipt() {
        // Configure the GridPane layout
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);  // Horizontal gap between columns
        this.setVgap(15);  // Vertical gap between rows
        this.setPadding(new Insets(20));  // Padding around the grid

        // Row 0: CAR NUMBER Label and Disabled TextField
        Label carNumberLabel = new Label("CAR NUMBER:");
        TextField carNumberField = new TextField();
        carNumberField.setDisable(true);  // Disable field to prevent any interaction

        // Row 1: ENTER TIME Label and Disabled TextField
        Label enterTimeLabel = new Label("ENTER TIME:");
        TextField enterTimeField = new TextField();
        enterTimeField.setDisable(true);  // Disable field to prevent any interaction

        // Row 2: EXIT TIME Label and Disabled TextField
        Label exitTimeLabel = new Label("EXIT TIME:");
        TextField exitTimeField = new TextField();
        exitTimeField.setDisable(true);  // Disable field to prevent any interaction

        // Row 3: PARKING FEE Label and Disabled TextField
        Label parkingFeeLabel = new Label("PARKING FEE:");
        TextField parkingFeeField = new TextField();
        parkingFeeField.setDisable(true);  // Disable field to prevent any interaction

        // Row 4: PAYMENT METHOD Label and Disabled TextField
        Label paymentMethodLabel = new Label("PAYMENT METHOD:");
        TextField paymentMethodField = new TextField();
        paymentMethodField.setDisable(true);  // Disable field to prevent any interaction

        // Add components to the GridPane
        this.add(carNumberLabel, 0, 0);  // Column 0, Row 0
        this.add(carNumberField, 1, 0);  // Column 1, Row 0

        this.add(enterTimeLabel, 0, 1);  // Column 0, Row 1
        this.add(enterTimeField, 1, 1);  // Column 1, Row 1

        this.add(exitTimeLabel, 0, 2);  // Column 0, Row 2
        this.add(exitTimeField, 1, 2);  // Column 1, Row 2

        this.add(parkingFeeLabel, 0, 3);  // Column 0, Row 3
        this.add(parkingFeeField, 1, 3);  // Column 1, Row 3

        this.add(paymentMethodLabel, 0, 4);  // Column 0, Row 4
        this.add(paymentMethodField, 1, 4);  // Column 1, Row 4
    }
}
