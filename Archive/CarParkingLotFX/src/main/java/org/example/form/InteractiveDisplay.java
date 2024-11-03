package org.example.form;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class InteractiveDisplay extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Interactive Display");

        // Main layout (VBox) to hold all components vertically
        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.TOP_CENTER);



        // Grid for the car search section
        GridPane searchGrid = new GridPane();
        searchGrid.setHgap(10);
        searchGrid.setVgap(10);
        searchGrid.setAlignment(Pos.CENTER);

        // Car Number label and TextField
        Label carNumberLabel = new Label("Car Number:");
        TextField carNumberInput = new TextField();
        carNumberInput.setPromptText("Enter car number");

        // Search button
        Button searchButton = new Button("Search");

        // Add car number label, TextField, and Search button to the grid
        searchGrid.add(carNumberLabel, 0, 0);
        searchGrid.add(carNumberInput, 1, 0);
        searchGrid.add(searchButton, 2, 0);

        // "RECEIPT" label before the details box
        Label receiptLabel = new Label("RECEIPT:");
        receiptLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        receiptLabel.setTextFill(Color.DARKBLUE);
        receiptLabel.setAlignment(Pos.CENTER_LEFT);

        // VBox for the details (Car Number, Entering Time, Charging Fee, Total Payment)
        VBox detailsBox = new VBox(10);
        detailsBox.setPadding(new Insets(20));
        detailsBox.setAlignment(Pos.CENTER_LEFT);

        // Add border to the details box
        detailsBox.setBorder(new Border(new BorderStroke(
                Color.WHITE,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(2)
        )));

        // Detail labels
        Label detailCarNumberLabel = new Label("Car Number:");
        Label enteringTimeLabel = new Label("Entering time:");
        Label chargingFeeLabel = new Label("Charging fee:");
        Label totalPaymentLabel = new Label("Total payment:");

        // Add detail labels to the details box
        detailsBox.getChildren().addAll(
            detailCarNumberLabel,  // Add Car Number label
            enteringTimeLabel, 
            chargingFeeLabel, 
            totalPaymentLabel
        );

        // HBox for Cancel and Pay buttons
        HBox buttonBox = new HBox(20);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));

        // Create Cancel and Pay buttons with equal size
        Button cancelButton = new Button("Cancel");
        Button payButton = new Button("Pay");

        // Set both buttons to have the same width
        cancelButton.setMinWidth(100);
        payButton.setMinWidth(100);

        // Add buttons to the button box
        buttonBox.getChildren().addAll(cancelButton, payButton);

        // Add all components to the main layout
        mainLayout.getChildren().addAll(
            searchGrid, 
            receiptLabel,  // Add the "RECEIPT" label before the details box
            detailsBox, 
            buttonBox
        );

        // Set the scene and display the form
        Scene scene = new Scene(mainLayout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
