package org.example.form;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.example.SpotType;
import org.example.spots.CarSpot;

public class UserInputForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Add Member Form");

        // Main layout (VBox) to hold all components vertically
        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.TOP_CENTER);

        // Title Label
        Label titleLabel = new Label("Add New Member");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        // GridPane to align input fields
        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(15);
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setPadding(new Insets(10));

        // Name Label and TextField
        Label nameLabel = new Label("Name:");
        TextField nameInput = new TextField();
        nameInput.setPromptText("Enter member's name");

        // Phone Number Label and TextField
        Label phoneLabel = new Label("Phone Number:");
        TextField phoneInput = new TextField();
        phoneInput.setPromptText("Enter phone number");

        // Car Number Label and TextField
        Label carNumberLabel = new Label("Car Number:");
        TextField carNumberInput = new TextField();
        carNumberInput.setPromptText("Enter car number");

        // Car Type Label and ComboBox
        Label carTypeLabel = new Label("Car Type:");
        ComboBox<SpotType> carTypeComboBox = new ComboBox<>();
        carTypeComboBox.getItems().setAll(SpotType.values());
        carTypeComboBox.setPromptText("Select car type");

        // Add input fields to GridPane
        formGrid.add(nameLabel, 0, 0);
        formGrid.add(nameInput, 1, 0);

        formGrid.add(phoneLabel, 0, 1);
        formGrid.add(phoneInput, 1, 1);

        formGrid.add(carNumberLabel, 0, 2);
        formGrid.add(carNumberInput, 1, 2);

        formGrid.add(carTypeLabel, 0, 3);
        formGrid.add(carTypeComboBox, 1, 3);

        // HBox for Save and Cancel buttons
        HBox buttonBox = new HBox(15);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));

        // Save and Cancel Buttons
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        // Set both buttons to have equal width
        saveButton.setMinWidth(100);
        cancelButton.setMinWidth(100);

        // Add buttons to HBox
        buttonBox.getChildren().addAll(saveButton, cancelButton);

        // Add all components to main layout
        mainLayout.getChildren().addAll(titleLabel, formGrid, buttonBox);

        // Set the scene and display the form
        Scene scene = new Scene(mainLayout, 400, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
