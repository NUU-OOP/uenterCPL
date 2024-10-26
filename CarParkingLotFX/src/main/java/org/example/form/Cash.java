package org.example.form;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Cash extends Pane {

    public Cash() {
        // Step 1: Create a GridPane for layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);  // Horizontal gap between columns
        grid.setVgap(15);  // Vertical gap between rows
        grid.setPadding(new Insets(20));  // Padding around the pane

        // Step 2: Add the first Label and TextField for cash amount
        Label cashAmountLabel = new Label("Cash Amount:");
        TextField cashAmountField = new TextField();
        cashAmountField.setPromptText("Enter amount");
        // Restrict input to numbers only
        cashAmountField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                cashAmountField.setText(oldValue);  // Revert to old value if non-numeric
            }
        });

        // Add to GridPane at row 0, column 0 and 1
        grid.add(cashAmountLabel, 0, 0);
        grid.add(cashAmountField, 1, 0);

        // Step 3: Add the second Label and TextField for amount to pay
        Label amountToPayLabel = new Label("Amount to Pay:");
        TextField amountToPayField = new TextField();
        amountToPayField.setPromptText("Enter amount to pay");


        // Add to GridPane at row 1, column 0 and 1
        grid.add(amountToPayLabel, 0, 1);
        grid.add(amountToPayField, 1, 1);

        // Step 4: Add the GridPane to the Cash Pane
        getChildren().add(grid);
    }
}
