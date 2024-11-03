package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.util.List;
import java.util.Scanner;

public class ParkingRateConfigurator extends Application {

   private TextField rateField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Parking Rate Configurator");
        GridPane gridPane = new GridPane();
        gridPane.setVgap(20);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10,10,10,10));
        Label rates = new Label("Enter rates:");
        rateField = new TextField();
        rateField.setPromptText("4, 3.5, 2.5 etc...");
        rateField.setMinWidth(170);
        Button saveRate = new Button("Save");
        Button cancel = new Button("Cancel");
        gridPane.add(rates,0,0);
        gridPane.add(rateField, 1, 0);
        gridPane.add(saveRate, 0, 1);
        gridPane.add(cancel, 1,1 );
        saveRate.setOnAction(event -> {

        });

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void saveRates() throws FileNotFoundException {
        File file = new File("rates.ini");
        Scanner scanner = new Scanner(file);
        String rates[] = rateField.getText().split(",");
        for (int i = 0; i <rates.length; i++) {
            System.out.println(rates[i].trim());
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
