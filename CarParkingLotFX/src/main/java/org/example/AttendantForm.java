package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class AttendantForm extends Pane {

    public AttendantForm() {
        create();
    }

    protected void create() {
        getChildren().clear();

        // Create a GridPane for layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(20));

        // Define the font for all labels and text fields
        Font font = Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 18);

        // Name Label and TextField
        Label nameLabel = new Label("NAME:");
        nameLabel.setFont(font);
        TextField nameField = new TextField();
        nameField.setFont(font);

        // Login Label and TextField
        Label loginLabel = new Label("LOGIN:");
        loginLabel.setFont(font);
        TextField loginField = new TextField();
        loginField.setFont(font);

        // Password Label and PasswordField
        Label passwordLabel = new Label("PASSWORD:");
        passwordLabel.setFont(font);
        PasswordField passwordField = new PasswordField();
        passwordField.setFont(font);

        // Phone Label and TextField (numeric only)
        Label phoneLabel = new Label("PHONE:");
        phoneLabel.setFont(font);
        TextField phoneField = new TextField();
        phoneField.setFont(font);
        addNumericValidation(phoneField);

        // Age Label and TextField (numeric only)
        Label ageLabel = new Label("AGE:");
        ageLabel.setFont(font);
        TextField ageField = new TextField();
        ageField.setFont(font);
        addNumericValidation(ageField);

        // Save and Cancel Buttons
        Button saveButton = new Button("SAVE");
        saveButton.setFont(font);
        saveButton.setPrefSize(180, 50);

        Button cancelButton = new Button("CANCEL");
        cancelButton.setFont(font);
        cancelButton.setPrefSize(180, 50);

        // Add components to the GridPane (row, column)
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);

        gridPane.add(loginLabel, 0, 1);
        gridPane.add(loginField, 1, 1);

        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);

        gridPane.add(phoneLabel, 0, 3);
        gridPane.add(phoneField, 1, 3);

        gridPane.add(ageLabel, 0, 4);
        gridPane.add(ageField, 1, 4);

        // Create a sub-GridPane for the buttons to align them horizontally
        GridPane buttonPane = new GridPane();
        buttonPane.setHgap(20);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.add(saveButton, 0, 0);
        buttonPane.add(cancelButton, 1, 0);

        // Add the button pane to the main grid
        gridPane.add(buttonPane, 0, 5, 2, 1);

        // Add the GridPane to the root Pane
        getChildren().add(gridPane);
    }

    // Method to add numeric input validation
    private void addNumericValidation(TextField textField) {
        textField.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String input = event.getCharacter();
            // Allow only digits
            if (!input.matches("\\d")) {
                event.consume(); // Ignore non-digit input
            }
        });
    }
}
