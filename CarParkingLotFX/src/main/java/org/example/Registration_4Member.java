package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Registration_4Member extends Pane {
    // Define fields
    private ComboBox carTypeComboBox;
    private TextField carNumberfield;
    private TextField accountNumberField;
    Registration_4Member() {
        create_regForm_4Member();
    }
    private void create_regForm_4Member() {
        getChildren().clear();
        VBox left = new VBox();
        Label carTypeLabel = new Label("Car Type");
        carTypeLabel.setLayoutX(20);
        carTypeLabel.setLayoutY(25);
        carTypeLabel.setFont(Font.font("Couier", FontWeight.BOLD, FontPosture.ITALIC,25));
        Label carNumberLabel = new Label("Car Number");
        carNumberLabel.setLayoutX(20);
        carNumberLabel.setLayoutY(100);
        carNumberLabel.setFont(Font.font("Couier", FontWeight.BOLD, FontPosture.ITALIC,25));
        Label accountNumberLabel = new Label("Account Number");
        accountNumberLabel.setLayoutX(175);
        accountNumberLabel.setLayoutY(95);
        accountNumberLabel.setFont(Font.font("Couier", FontWeight.BOLD, FontPosture.ITALIC,25));
        left.getChildren().addAll(carTypeLabel, carNumberLabel, accountNumberLabel);
        left.setSpacing(30);
        left.setPadding(new Insets(10, 10, 10, 10));


        carTypeComboBox = new ComboBox();
        carTypeComboBox.getItems().addAll(CarType.values());
        //carTypeComboBox.getSelectionModel().selectFirst();
        carTypeComboBox.setLayoutX(175);
        carTypeComboBox.setLayoutY(25);
        carTypeComboBox.setPrefWidth(330);
        carTypeComboBox.setStyle("-fx-font-family: 'Courier'; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 25;");

        carNumberfield = new TextField();
        carNumberfield.setLayoutX(175);
        carNumberfield.setLayoutY(25);
        carNumberfield.setFont(Font.font("Couier",FontWeight.BOLD,FontPosture.ITALIC,25));

        accountNumberField = new TextField();
        accountNumberField.setLayoutX(20);
        accountNumberField.setLayoutY(25);
        accountNumberField.setFont(Font.font("Couier",FontWeight.BOLD,FontPosture.ITALIC,25));

        VBox right = new VBox();
        right.getChildren().addAll(carTypeComboBox, carNumberfield, accountNumberField);
        right.setSpacing(10);
        right.setPadding(new Insets(10, 10, 10, 10));


        HBox hBox =  new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.getChildren().addAll(left, right);

        HBox hbox_buttons  =new HBox();
        hbox_buttons.setSpacing(30);
        hbox_buttons.setPadding(new Insets(10, 10, 10, 10));

        Button registerButton=new Button("REGISTER");
        registerButton.setLayoutX(50);
        registerButton.setLayoutY(325);
        registerButton.setMinSize(180,50);
        registerButton.setFont(Font.font("Couier",FontWeight.BOLD,FontPosture.ITALIC,25));
        registerButton.setOnAction(event -> {
            if (carTypeComboBox.getSelectionModel().isEmpty() || carNumberfield.getText().isEmpty() || accountNumberField.getText().isEmpty()) {
                showAlert("Missing Information", "Please, fill the fields");
            }
            else {
                showAlert("Successful", "Congratulations, your account has been registered");
            }
        });

        Button resetButton =new Button("RESET");
        resetButton.setLayoutX(290);
        resetButton.setLayoutY(325);
        resetButton.setMinSize(180,50);
        resetButton.setFont(Font.font("Couier",FontWeight.BOLD,FontPosture.ITALIC,25));
        resetButton.setOnAction(event -> {
            carTypeComboBox.getSelectionModel().clearSelection();
            carNumberfield.clear();
            accountNumberField.clear();
        });

        hbox_buttons.getChildren().addAll(registerButton, resetButton);
        hbox_buttons.setAlignment(Pos.BOTTOM_CENTER);

        Label title = new Label("REGISTRATION FORM FOR MEMBER");
        title.setFont(Font.font("Couier",FontWeight.BOLD,FontPosture.ITALIC,25));
        //title.setAlignment(Pos.TOP_CENTER);
        title.setPadding(new Insets(10,30,5,110));
        title.setStyle("-fx-text-fill: #090971; -fx-font-weight: bold;");

        VBox mainlayout = new VBox();
        mainlayout.getChildren().addAll(title, hBox, hbox_buttons);
        mainlayout.setSpacing(10);
        this.getChildren().add(mainlayout);

//        Scene scene =new Scene(mainlayout, 600,390);
//        Stage  primarystage = new Stage();
//        primarystage.setScene(scene);
//        primarystage.show();



    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
