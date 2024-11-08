package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import org.example.DBConnection;
import org.example.Spots;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InteractiveDisplay extends Application {
    double total=0.0;

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
        payButton.setDisable(true);

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
        cancelButton.setOnAction(event -> {

            detailCarNumberLabel.setText("Car Number:");
            enteringTimeLabel.setText("Entering time:");
            chargingFeeLabel.setText("Charging fee:");
            totalPaymentLabel.setText("Total payment:");
            carNumberInput.setText("");
            primaryStage.close();

        });
        searchButton.setOnAction(e -> {
            detailCarNumberLabel.setText("Car Number:");
            enteringTimeLabel.setText("Entering time:");
            chargingFeeLabel.setText("Charging fee:");
            totalPaymentLabel.setText("Total payment:");

                    DBConnection dbcon = null;
                    try {
                        dbcon = new DBConnection();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    double chargingFee=0.0;
                    String exitTime = "";

                    String carNumber = carNumberInput.getText().trim();
                    if (!carNumber.isEmpty()) {
                        ResultSet rs = null;
                        try {
                            rs = dbcon.executeQuery("SELECT * FROM Ticket ORDER BY SpotID;");
                            while (rs.next()) {
                                if (rs.getString(3).equals(carNumber)) {
                                    detailCarNumberLabel.setText(detailCarNumberLabel.getText()+"     "+rs.getString(3));  // Add Car Number label
                                    enteringTimeLabel.setText(enteringTimeLabel.getText()+"   "+formatDateTime(rs.getString(5)));
                                    exitTime = getCurrentTime();
                                    long seconds = TimeDifference(rs.getString(5), exitTime);
                                    if (rs.getString(7).equals("1")){
                                            chargingFee = calculateChargingFee(seconds);
                                            total = calculateParkingFee(seconds, chargingFee);
                                            totalPaymentLabel.setText(totalPaymentLabel.getText()+"    "+total);
                                    }
                                    else    {
                                        total = calculateParkingFee(seconds);
                                        totalPaymentLabel.setText(totalPaymentLabel.getText()+"    "+total);
                                        }
                                    chargingFeeLabel.setText(chargingFeeLabel.getText()+"    "+chargingFee);
                                    payButton.setDisable(false);
                                }
                            }
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            dbcon.executeCommand("UPDATE Ticket SET ExitTime ='" + exitTime + "' WHERE CarNumber = '" + carNumber + "';");
                            dbcon.executeCommand("UPDATE Spot SET isOccupied = '0' WHERE CarNumber = '" + carNumber + "';");
                        } catch (SQLException ex) {
                            System.err.println("Error executing insert: " + ex.getMessage());
                        }
                    }
                    else showErrorDialog("Please, input car number");
                });

        payButton.setOnAction(e -> {
            Scene previousScene = primaryStage.getScene(); // Store the current scene
            PaymentInterface ShowPaymentInterface = new PaymentInterface(total, primaryStage, previousScene);
            try {
                Scene scene = new Scene(ShowPaymentInterface);
                primaryStage.setScene(scene);
                primaryStage.show();

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        // Set the scene and display the form
        Scene scene = new Scene(mainLayout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        return now.format(formatter);
    }

    public static String formatDateTime(String dateTime) {
            LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return localDateTime.format(formatter);
        }

    public static long TimeDifference(String enterTime, String exitTime) {
            LocalDateTime enter = LocalDateTime.parse(enterTime);
            LocalDateTime exit = LocalDateTime.parse(exitTime);

            Duration duration = Duration.between(enter, exit);
            long seconds = duration.getSeconds();

            return seconds;
        }

    public static double calculateChargingFee(long totalseconds) {
        double chargingFee = 0.0;
        chargingFee = totalseconds*1;
        return chargingFee;

    }

    public static double calculateParkingFee(long totalseconds) {

            double totalFee = 0.0;
            long remainingSeconds = totalseconds;

            // First 10 seconds rate
            if (remainingSeconds > 0) {
                long first10Seconds = Math.min(remainingSeconds, 10);
                totalFee += first10Seconds * 10.0; // Rate for first 10 seconds is $10 per second
                remainingSeconds -= first10Seconds;
            }

            // Second 10 seconds rate
            if (remainingSeconds > 0) {
                long second10Seconds = Math.min(remainingSeconds, 10);
                totalFee += second10Seconds * 5.0; // Rate for second 10 seconds is $5 per second
                remainingSeconds -= second10Seconds;
            }

            // Third 10 seconds rate
            if (remainingSeconds > 0) {
                long third10Seconds = Math.min(remainingSeconds, 10);
                totalFee += third10Seconds * 3.0; // Rate for third 10 seconds is $3 per second
                remainingSeconds -= third10Seconds;
            }

            // Remaining seconds rate
            if (remainingSeconds > 0) {
                totalFee += remainingSeconds * 2.0; // Rate for remaining seconds is $2 per second
            }

            return totalFee;
        }

    public static double calculateParkingFee(long totalseconds, double extraFee) {

        double totalFee = 0.0;
        long remainingSeconds = totalseconds;

        // First 10 seconds rate
        if (remainingSeconds > 0) {
            long first10Seconds = Math.min(remainingSeconds, 10);
            totalFee += first10Seconds * 10.0; // Rate for first 10 seconds is $10 per second
            remainingSeconds -= first10Seconds;
        }

        // Second 10 seconds rate
        if (remainingSeconds > 0) {
            long second10Seconds = Math.min(remainingSeconds, 10);
            totalFee += second10Seconds * 5.0; // Rate for second 10 seconds is $5 per second
            remainingSeconds -= second10Seconds;
        }

        // Third 10 seconds rate
        if (remainingSeconds > 0) {
            long third10Seconds = Math.min(remainingSeconds, 10);
            totalFee += third10Seconds * 3.0; // Rate for third 10 seconds is $3 per second
            remainingSeconds -= third10Seconds;
        }

        // Remaining seconds rate
        if (remainingSeconds > 0) {
            totalFee += remainingSeconds * 2.0; // Rate for remaining seconds is $2 per second
        }

        return totalFee+extraFee;
    }
    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
