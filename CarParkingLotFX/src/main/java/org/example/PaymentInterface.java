package org.example;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class PaymentInterface extends GridPane {

    // UI components
    private Label dynamicLabel;  // Label that changes text dynamically
    private TextField inputField;  // Input field for card, amount, or account number
    private TextField amountField;

    public PaymentInterface(double total, Stage primaryStage, Scene previousScene) {
        // Configure the GridPane layout
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);  // Horizontal gap between columns
        this.setVgap(15);  // Vertical gap between rows
        this.setPadding(new Insets(20));  // Padding around the grid

        // Add the payment method label and ComboBox
        Label paymentMethodLabel = new Label("Select Payment Method:");
        ComboBox<String> paymentMethodComboBox = new ComboBox<>();
        paymentMethodComboBox.getItems().addAll("CARD", "CASH", "ACCOUNT");
        paymentMethodComboBox.setPromptText("Choose a payment method");

        // Add the dynamic label and input field
        dynamicLabel = new Label("Card Number:");  // Default text
        inputField = new TextField();
        inputField.setPromptText("Enter value");

        // Create HBox for Amount label and TextField
        HBox amountBox = new HBox(10); // 10px spacing between elements
        Label amountLabel = new Label("Amount:");
        amountField = new TextField();
        amountField.setEditable(false);
        amountField.setText(String.valueOf(total));
        amountBox.getChildren().addAll(amountLabel, amountField);


        // Create an HBox for the PAY and CANCEL buttons
        HBox buttonBox = new HBox(10);  // 10px spacing between buttons
        buttonBox.setAlignment(Pos.CENTER);
        Button payButton = new Button("PAY");
        payButton.setDisable(true);
        inputField.textProperty().addListener((observable, oldValue, newValue) -> {
            payButton.setDisable(newValue.trim().isEmpty());
        });
        Button cancelButton = new Button("CANCEL");
        buttonBox.getChildren().addAll(payButton, cancelButton);


        // Add components to the GridPane
        this.add(paymentMethodLabel, 0, 0);  // Column 0, Row 0
        this.add(paymentMethodComboBox, 1, 0);  // Column 1, Row 0
        this.add(dynamicLabel, 0, 1);  // Column 0, Row 1
        this.add(inputField, 1, 1);  // Column 1, Row 1
        this.add(amountLabel, 0, 2);  // Column 0, Row 2
        this.add(amountField, 1, 2);  // Column 1, Row 2
        this.add(buttonBox, 0, 3, 2, 1);  // Span across 2 columns in Row 3

        // Add a listener to update the label based on selected payment method
        paymentMethodComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "CARD":
                    dynamicLabel.setText("Card Number:");
                    inputField.setPromptText("Enter card number");
                    break;
                case "CASH":
                    dynamicLabel.setText("Amount:");
                    inputField.setPromptText("Enter amount");
                    break;
                case "ACCOUNT":
                    dynamicLabel.setText("Account Number:");
                    inputField.setPromptText("Enter account number");
                    break;
                default:
                    dynamicLabel.setText("Select Payment Method");
                    inputField.setPromptText("Enter value");
                    break;
            }
        });
        cancelButton.setOnAction((event) -> {
            paymentMethodComboBox.getSelectionModel().clearSelection();
            dynamicLabel.setText("Select Payment Method");
            inputField.clear();
            // Go back to the InteractiveDisplay scene
            primaryStage.setScene(previousScene); // Set to the previous scene
            primaryStage.show();
        });
        payButton.setOnAction((event -> {

        }));

    }
}
