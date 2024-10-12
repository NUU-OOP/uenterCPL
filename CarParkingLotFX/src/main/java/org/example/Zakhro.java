package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Zakhro  extends Pane {
    // Declare fields
    private TextField scanTextField;
    private Button scanButton;
    private Label entranceTimeLabel;
    private Label entranceTimeValue;
    private Label exitTimeLabel;
    private Label exitTimeValue;
    private Label amountLabel;
    private Label amountValue;
    private Label extraFeeLabel;
    private Label extraFeeValue;
    private Button payButton;
    Zakhro(){
        CreateAttendentMenu();
    }

    protected void CreateAttendentMenu(){
        // Create the main layout
        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(20));
        //mainLayout.setAlignment(Pos.CENTER);


        // Scan button and text field
        HBox scanBox = new HBox(10);
        //scanBox.setAlignment(Pos.CENTER);
        scanButton = new Button("scan");
        scanTextField = new TextField();
        scanBox.getChildren().addAll(scanButton, scanTextField);

        // Grid for labels and values
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);


        entranceTimeLabel = new Label("Entrance time:");
        entranceTimeValue = new Label();
        exitTimeLabel = new Label("Exit time:");
        exitTimeValue = new Label();
        amountLabel = new Label("Amount:");
        amountValue = new Label();
        extraFeeLabel = new Label("Extra Fee:");
        extraFeeValue = new Label();

        grid.add(entranceTimeLabel, 0, 0);
        grid.add(entranceTimeValue, 1, 0);
        grid.add(exitTimeLabel, 0, 1);
        grid.add(exitTimeValue, 1, 1);
        grid.add(amountLabel, 0, 2);
        grid.add(amountValue, 1, 2);
        grid.add(extraFeeLabel, 0, 3);
        grid.add(extraFeeValue, 1, 3);

        // Pay and Cancel buttons
        HBox buttonBox = new HBox(20);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        payButton = new Button("Pay");
        payButton.setDisable(true);
        Button cancelButton = new Button("Cancel");
        buttonBox.getChildren().addAll(payButton, cancelButton);

        //  Scan button action
        scanButton.setOnAction(e -> scan());


        //  Cancel button action
        cancelButton.setOnAction(e -> resetForm());

        //  Pay button action
        payButton.setOnAction(e -> PaymentForm());


        // Add all elements to the main layout
        mainLayout.getChildren().addAll(scanBox, grid, buttonBox);
        this.getChildren().add(mainLayout);

//        // Set the scene and show the stage
//        Scene scene = new Scene(mainLayout, 260, 230);
//        Stage primaryStage = new Stage();
//        primaryStage.setTitle("Attendant Menu");
//        primaryStage.setScene(scene);
//        primaryStage.setResizable(false);
//        primaryStage.show();
    }
    private void scan() {
        if (scanTextField.getText().isEmpty()){
           showAlert("Missing Information", "Please, enter Ticket Number.");
        }
        else {
            if (scanTextField.getText().startsWith("T")){
                showAlert("Information", "Found");
                payButton.setDisable(false);
            }
            else {
                showAlert("Wrong Information", "Please, enter Ticket Number correctly.");

            }
        }

    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void resetForm() {

    }
    private void PaymentForm(){
        // Create labels and text fields
        Label cashLabel = new Label("Cash:");
        cashLabel.setPadding(new Insets(5));
        Label cashAmountLabel = new Label("Amount");
        TextField cashAmount = new TextField();
        Label cardLabel = new Label("Card:");
        cardLabel.setPadding(new Insets(5));
        Label cardNumberLabel = new Label("Card Number:");
        TextField cardNumber = new TextField();
        Label cardAmountLabel = new Label("Amount:");
        TextField cardAmount = new TextField();
        Label accountLabel = new Label("Account:");
        accountLabel.setPadding(new Insets(5));
        Label accountNumberLabel = new Label("Account Number:");
        TextField accountNumber = new TextField();

        // Create buttons
        Button payButton = new Button("Pay");
        payButton.setAlignment(Pos.BOTTOM_CENTER);


        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 0, 0, 0));
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(25);
        grid.setHgap(20);

        // Add components to the grid
        grid.add(cashLabel, 0, 0);
        VBox cashAmountBox = new VBox(0, cashAmountLabel, cashAmount);
        cashAmountBox.setPadding(new Insets(-8, 0,30,0));
        grid.add(cashAmountBox, 1, 0,1,2);

        grid.add(cardLabel, 0, 1);
        VBox cardNumberBox = new VBox(0, cardNumberLabel, cardNumber); // VBox with zero spacing
        grid.add(cardNumberBox, 1, 1, 1, 2);

        VBox cardAmountBox = new VBox(0, cardAmountLabel, cardAmount);
        grid.add(cardAmountBox, 2, 1,1,2);



        grid.add(accountLabel, 0, 3);
        VBox accountBox = new VBox(0, accountNumberLabel, accountNumber);
        accountBox.setPadding(new Insets(20, 0,0,0));
        grid.add(accountBox, 1, 2, 1, 3);




        grid.add(payButton, 2, 5);


        // Set the scene
        Scene scene = new Scene(grid, 430, 250);
        Stage primStage = new Stage();
        primStage.setTitle("Payment Form");
        primStage.setScene(scene);
        primStage.show();


    }
}
