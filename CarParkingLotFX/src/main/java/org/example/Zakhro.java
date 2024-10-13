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
}
