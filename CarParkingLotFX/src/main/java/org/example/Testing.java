package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Testing extends Application {

    private static final int PADDING = 20;
    private static final int GAP = 10;
    private static final int BUTTON_SPACING = 10;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Entrance Form");

        GridPane gridPane = createGridPane();

        TextField carNumberField = createCarNumberField();
        ComboBox<SpotType> carTypeComboBox = createCarTypeComboBox();
        CheckBox extraServiceCheckBox = createExtraServiceCheckBox(carTypeComboBox);

        HBox buttonBox = createButtonBox(carNumberField, carTypeComboBox, extraServiceCheckBox);

        // Add components to the GridPane
        gridPane.add(new Label("CAR NUMBER:"), 0, 0);
        gridPane.add(carNumberField, 1, 0);
        gridPane.add(new Label("CAR TYPE:"), 0, 1);
        gridPane.add(carTypeComboBox, 1, 1);
        gridPane.add(new Label("Extra Service:"), 0, 2);
        gridPane.add(extraServiceCheckBox, 1, 2);
        gridPane.add(buttonBox, 0, 3, 2, 1);

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(GAP);
        gridPane.setVgap(GAP);
        gridPane.setPadding(new Insets(PADDING));
        return gridPane;
    }

    private TextField createCarNumberField() {
        TextField carNumberField = new TextField();
        carNumberField.setPromptText("Enter car number");
        carNumberField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z0-9]*")) {
                carNumberField.setText(oldValue);
            } else {
                carNumberField.setText(newValue.toUpperCase());
            }
        });
        return carNumberField;
    }

    private ComboBox<SpotType> createCarTypeComboBox() {
        ComboBox<SpotType> carTypeComboBox = new ComboBox<>();
        carTypeComboBox.getItems().addAll(SpotType.values());
        carTypeComboBox.setPromptText("Select car type");
        return carTypeComboBox;
    }

    private CheckBox createExtraServiceCheckBox(ComboBox<SpotType> carTypeComboBox) {
        CheckBox extraServiceCheckBox = new CheckBox("Charge while parking");
        extraServiceCheckBox.setDisable(true);
        carTypeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            extraServiceCheckBox.setDisable(newValue != SpotType.ELECTRIC);
            if (newValue != SpotType.ELECTRIC) {
                extraServiceCheckBox.setSelected(false);
            }
        });
        return extraServiceCheckBox;
    }

    private HBox createButtonBox(TextField carNumberField, ComboBox<SpotType> carTypeComboBox, CheckBox extraServiceCheckBox) {
        Button parkButton = new Button("PARK");
        parkButton.setOnAction(event -> handleParkAction(carNumberField, carTypeComboBox, extraServiceCheckBox));

        Button cancelButton = new Button("CANCEL");

        HBox buttonBox = new HBox(BUTTON_SPACING, parkButton, cancelButton);
        buttonBox.setAlignment(Pos.CENTER);
        return buttonBox;
    }

    private void handleParkAction(TextField carNumberField, ComboBox<SpotType> carTypeComboBox, CheckBox extraServiceCheckBox) {
        if (carNumberField.getText().isEmpty() || carTypeComboBox.getValue() == null) {
            // Display validation error (could be a tooltip, alert, etc.)
            System.out.println("Please enter all required fields.");
            return;
        }

        String carNumber = carNumberField.getText().toUpperCase();
        String carType = carTypeComboBox.getValue().toString();
        LocalDateTime enterTime = LocalDateTime.now();
        boolean extraFee = extraServiceCheckBox.isSelected();

        try {
            int spotID = findFreeSpotID(carType);
            if (spotID > 0) {
                try  {
                    DBConnection dbcon = new DBConnection();
                    dbcon.executeCommand("INSERT INTO Ticket (SpotID, CarNumber, CarType, EnterTime, ExitTime, ExtraFee) " +
                            "VALUES ('" + spotID + "', '" + carNumber + "', '" + carType + "', '" + enterTime + "', '', '" + extraFee + "');");
                } catch (Exception e){
                    showErrors(e.getMessage());
                    System.out.println(e);
                }
                System.out.println("Parking successful!");
            } else {
                System.out.println("No available spots found.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Log exception or show error message
        }
    }

    private static int findFreeSpotID(String carType) throws SQLException {
        String query = "SELECT * FROM Spot WHERE isOccupied = '0' AND SpotType = ? ORDER BY SpotID LIMIT 1;";

        try  {
            DBConnection dbcon = new DBConnection();
            Connection conn = dbcon.getConnection();
            var ps = conn.prepareStatement(query);
            ps.setString(1, carType);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int spotId = rs.getInt("SpotID");
                    System.out.println("Available Spot ID: " + spotId);
                    return spotId;
                }
            }
        } catch (Exception e){
            showErrors(e.getMessage());

            System.out.println(e);
        }
        return 0; // No available spots
    }
    private static void showErrors(String message){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(message);

        alert.show();
    }
}
