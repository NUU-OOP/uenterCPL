package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
//import org.example.services.TicketService;
//import org.example.services.TicketServiceImpl;
//import org.example.utils.CarInputValidator;
//import org.example.spots.SpotType;
import org.example.dbconnnection.DBConnection;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class EntranceForm extends Application {

    private final TicketService ticketService;

    public EntranceForm() throws SQLException {
        this.ticketService = new TicketServiceImpl(new DBConnection());
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = createFormLayout();
        configureParkButton(gridPane, primaryStage);

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createFormLayout() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(15);
        gridPane.setPadding(new Insets(20));

        // Row 0: Car Number
        Label carNumberLabel = new Label("CAR NUMBER:");
        TextField carNumberField = new TextField();
        carNumberField.setPromptText("Enter car number");
        configureCarNumberField(carNumberField);

        // Row 1: Car Type
        Label carTypeLabel = new Label("CAR TYPE:");
        ComboBox<SpotType> carTypeComboBox = new ComboBox<>();
        carTypeComboBox.getItems().addAll(SpotType.values());
        carTypeComboBox.setPromptText("Select car type");

        // Row 2: Extra Service
        Label extraServiceLabel = new Label("Extra Service:");
        CheckBox extraServiceCheckBox = new CheckBox("Charge while parking");
        configureCarTypeComboBox(carTypeComboBox, extraServiceCheckBox);

        // Row 3: Buttons
        Button parkButton = new Button("PARK");
        Button cancelButton = new Button("CANCEL");
        HBox buttonBox = new HBox(10, parkButton, cancelButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Add components to GridPane
        gridPane.add(carNumberLabel, 0, 0);
        gridPane.add(carNumberField, 1, 0);
        gridPane.add(carTypeLabel, 0, 1);
        gridPane.add(carTypeComboBox, 1, 1);
        gridPane.add(extraServiceLabel, 0, 2);
        gridPane.add(extraServiceCheckBox, 1, 2);
        gridPane.add(buttonBox, 0, 3, 2, 1);

        return gridPane;
    }

    private void configureCarNumberField(TextField carNumberField) {
        carNumberField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!CarInputValidator.isValidCarNumber(newValue)) {
                carNumberField.setText(oldValue);
            } else {
                carNumberField.setText(CarInputValidator.formatCarNumber(newValue));
            }
        });
    }

    private void configureCarTypeComboBox(ComboBox<SpotType> comboBox, CheckBox extraServiceCheckBox) {
        comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            extraServiceCheckBox.setDisable(newValue != SpotType.ELECTRIC);
            if (newValue != SpotType.ELECTRIC) {
                extraServiceCheckBox.setSelected(false);
            }
        });
    }

    private void configureParkButton(GridPane gridPane, Stage stage) {
        TextField carNumberField = (TextField) gridPane.getChildren().get(1);
        ComboBox<SpotType> carTypeComboBox = (ComboBox<SpotType>) gridPane.getChildren().get(3);
        HBox buttonBox = (HBox) gridPane.getChildren().get(6);
        Button parkButton = (Button) ((HBox) gridPane.getChildren().get(6)).getChildren().get(0);
        Button cancelButton = (Button) buttonBox.getChildren().get(1);
        parkButton.setOnAction(event -> {
            try {
                handleParkAction(carNumberField, carTypeComboBox);
            } catch (SQLException e) {
                showErrorDialog(e.getMessage());
            }
        });
        // Close the window when Cancel button is clicked
        cancelButton.setOnAction(event -> stage.close());
    }

    private void handleParkAction(TextField carNumberField, ComboBox<SpotType> carTypeComboBox) throws SQLException {
        String carNumber = carNumberField.getText();
        SpotType carType = carTypeComboBox.getValue();
        LocalDateTime enterTime = LocalDateTime.now();
        ticketService.createTicket(1, carNumber, carType.toString(), enterTime, null, 5.00);
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
