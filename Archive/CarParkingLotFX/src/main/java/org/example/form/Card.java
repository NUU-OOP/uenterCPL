package org.example.form;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Card extends Pane {

    public Card() {
        // Step 1: Create a GridPane for layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);  // Horizontal gap between columns
        grid.setVgap(15);  // Vertical gap between rows
        grid.setPadding(new Insets(20));  // Padding around the pane

        // Step 2: Add the "Card Number" label and TextField
        Label cardNumberLabel = new Label("Card Number:");
        TextField cardNumberField = new TextField();
        cardNumberField.setPromptText("Enter card number");

        // Restrict input to numbers only
        cardNumberField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                cardNumberField.setText(oldValue);  // Revert to old value if non-numeric
            }
        });

        // Add to GridPane at row 0
        grid.add(cardNumberLabel, 0, 0);
        grid.add(cardNumberField, 1, 0);

        // Step 3: Add the "Amount to Pay" label and TextField
        Label amountToPayLabel = new Label("Amount to Pay:");
        TextField amountToPayField = new TextField();
        amountToPayField.setPromptText("Amount to be paid");
        amountToPayField.setEditable(false);  // Make the TextField uneditable

        // Add to GridPane at row 1
        grid.add(amountToPayLabel, 0, 1);
        grid.add(amountToPayField, 1, 1);

        // Step 4: Add the GridPane to the Card Pane
        getChildren().add(grid);
    }
}
