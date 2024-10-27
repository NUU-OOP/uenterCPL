package org.example.form;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.SpotType;
import org.example.dbconnnection.DBConnection;

import java.sql.*;

public class AddSpot extends Application {
    DBConnection dbcon=new DBConnection();
    private Connection conn= dbcon.getConnection();

    public AddSpot() throws SQLException {
    }
    private ComboBox<SpotType> spotTypeField;
    private TextField spotNumberField;
    private TextField floorNumberField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Add a spot to Parking Lot");

        // Initialize fields
        spotTypeField = new ComboBox<>();
        spotTypeField.getItems().addAll(SpotType.values());
        spotNumberField = new TextField();
        floorNumberField = new TextField();

        Label spotTypeLabel = new Label("Spot Type (Electric, Motorcycle, Handicapped, Normal, Large):");
        Label spotNumberLabel = new Label("Spot Number:");
        Label floorNumberLabel = new Label("Floor Number:");

        Button saveButton = new Button("Add Spot");
        saveButton.setOnAction(e -> {if (spotTypeField.getValue()==null || spotNumberField.getText().isEmpty() || floorNumberField.getText().isEmpty()) {
            showAlert("Missing Information", "Please enter name,login,password and phone.");
        }else{
            try {
                insertSpot(spotTypeField.getValue().toString(),Integer.valueOf( spotNumberField.getText()), Integer.valueOf(floorNumberField.getText()));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            spotTypeField = null;
            spotNumberField.clear();
            floorNumberField.clear();
        }
        });

        // Layout setup
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(spotTypeLabel, 0, 0);
        grid.add(spotTypeField, 1, 0);
        grid.add(spotNumberLabel, 0, 1);
        grid.add(spotNumberField, 1, 1);
        grid.add(floorNumberLabel, 0, 2);
        grid.add(floorNumberField, 1, 2);
        grid.add(saveButton, 1, 3);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addSpot() {
        SpotType spotType = spotTypeField.getValue();
        String spotNumber = spotNumberField.getText();
        String floorNumber = floorNumberField.getText();

        // Validation
        if (spotType == null || spotNumber.isEmpty() || floorNumber.isEmpty()) {
            showAlert("Error","Please fill in all fields");
            return;
        }






//        String url = "jdbc:your_database_url";
//        String user = "your_database_user";
//        String password = "your_database_password";
//
//        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//            String sql = "INSERT INTO ParkingSpots (SpotType, SpotNumber, FloorNumber) VALUES (?, ?, ?)";
//            PreparedStatement statement = conn.prepareStatement(sql);
////            statement.setString(1, spotType);
//            statement.setString(2, spotNumber);
//            statement.setString(3, floorNumber);
//
//            statement.executeUpdate();
//            showAlert("Spot added successfully");

//            // Clear the fields after saving
//            spotTypeField.setValue(null);
//            spotNumberField.clear();
//            floorNumberField.clear();
//
//        } catch (SQLException e) {
//            showAlert("Error: " + e.getMessage());
//        }
    }

    private void insertSpot(String spotType,int spotNumber, int floorNumber) throws SQLException {
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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
