package org.example.form;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.dbconnnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParkingRateConfigurator extends Application {

    DBConnection dbcon=new DBConnection();
    private Connection conn= dbcon.getConnection();
    public ParkingRateConfigurator() throws SQLException {
    }

    private TextField firstHourRateField;
    private TextField secondThirdHourRateField;
    private TextField remainingHoursRateField;
    private ListView<String> rateListView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Parking Rate Configurator");

        // Initialize fields
        firstHourRateField = new TextField();
        secondThirdHourRateField = new TextField();
        remainingHoursRateField = new TextField();
        rateListView = new ListView<>();

        Label firstHourLabel = new Label("Rate for the 1st hour:");
        Label secondThirdHourLabel = new Label("Rate for the 2 hour");
        Label remainingHoursLabel = new Label("Rate for remaining hours:");
        Button saveButton = new Button("Save Rates");
        saveButton.setOnAction(e -> saveRates());

        // Layout setup
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(firstHourLabel, 0, 0);
        grid.add(firstHourRateField, 1, 0);
        grid.add(secondThirdHourLabel, 0, 1);
        grid.add(secondThirdHourRateField, 1, 1);
        grid.add(remainingHoursLabel, 0, 2);
        grid.add(remainingHoursRateField, 1, 2);
        grid.add(saveButton, 1, 3);
        grid.add(rateListView, 0, 4, 2, 1);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void insertRate(String spotType,int spotNumber, int floorNumber) throws SQLException {
        String sql="INSERT INTO Spot(SpotType, SpotNumber, FloorNumber, isOccupied) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement pstmt=conn.prepareStatement(sql);

            pstmt.setString(1, spotType);
            pstmt.setInt(2,spotNumber);
            pstmt.setInt(3,floorNumber);
            pstmt.setBoolean(4, false);
            pstmt.execute();
            System.out.println("SQL command executed successfully.");
        } catch (SQLException e) {
            System.err.println("Error executing SQL command: " + e.getMessage());
            throw e;
        }
    }

    private void saveRates() {
        String firstHourRate = firstHourRateField.getText();
        String secondThirdHourRate = secondThirdHourRateField.getText();
        String remainingHoursRate = remainingHoursRateField.getText();

        // Validation (You can add more comprehensive validation)
        if (firstHourRate.isEmpty() || secondThirdHourRate.isEmpty() || remainingHoursRate.isEmpty()) {
            showAlert("Please fill in all fields");
            return;
        }

        // Updating the ListView with the new rates
        rateListView.getItems().clear();
        rateListView.getItems().add("1st Hour Rate: $" + firstHourRate);
        rateListView.getItems().add("2nd & 3rd Hour Rate: $" + secondThirdHourRate);
        rateListView.getItems().add("Remaining Hours Rate: $" + remainingHoursRate);

        // Here you would save to a database or configuration file
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
