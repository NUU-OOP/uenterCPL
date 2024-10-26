package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EntranceForm extends Pane {

    public EntranceForm(Stage stage) {
        // Create a GridPane for layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);  // Horizontal gap between columns
        gridPane.setVgap(15);  // Vertical gap between rows
        gridPane.setPadding(new Insets(20));  // Padding around the grid

        // Row 0: Car Number Label and TextField
        Label carNumberLabel = new Label("CAR NUMBER:");
        TextField carNumberField = new TextField();
        carNumberField.setPromptText("Enter car number");
        carNumberField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z0-9]*")) {
                carNumberField.setText(oldValue);  // Restore old value if invalid input
            } else {
                carNumberField.setText(newValue.toUpperCase());  // Convert to uppercase
            }
        });


        // Row 1: Car Type Label and ComboBox
        Label carTypeLabel = new Label("CAR TYPE:");
        ComboBox<SpotType> carTypeComboBox = new ComboBox<>();
        carTypeComboBox.getItems().addAll(
               SpotType.values()
        );


        carTypeComboBox.setPromptText("Select car type");

        // Row 2: Extra Service Label and CheckBox
        Label extraServiceLabel = new Label("Extra Service:");
        CheckBox extraServiceCheckBox = new CheckBox("Charge while parking");
        extraServiceCheckBox.setDisable(true);
        carTypeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == SpotType.ELECTRIC) {
                extraServiceCheckBox.setDisable(false);  // Enable checkbox
            } else {
                extraServiceCheckBox.setDisable(true);  // Disable checkbox
                extraServiceCheckBox.setSelected(false);  // Reset to unchecked
            }
        });


        // Row 3: PARK and CANCEL Buttons
        Button parkButton = new Button("PARK");
        Button cancelButton = new Button("CANCEL");
        HBox buttonBox = new HBox(10, parkButton, cancelButton); // 10px spacing between buttons
        buttonBox.setAlignment(Pos.CENTER);

        // Add components to the GridPane
        gridPane.add(carNumberLabel, 0, 0);
        gridPane.add(carNumberField, 1, 0);

        gridPane.add(carTypeLabel, 0, 1);
        gridPane.add(carTypeComboBox, 1, 1);

        gridPane.add(extraServiceLabel, 0, 2);
        gridPane.add(extraServiceCheckBox, 1, 2);

        gridPane.add(buttonBox, 0, 3, 2, 1); // Span across 2 columns

        // Add the GridPane to this Pane
        this.getChildren().add(gridPane);
    }
}
