package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
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
        Label instruction = new Label("Separate by commas if more than one numbers");
        Label rates = new Label("Enter rates:");
        rateField = new TextField();
        rateField.setPromptText("4, 3.5, 2.5 etc...");
        rateField.setMinWidth(170);

        Button saveRate = new Button("Save");
        Button cancel = new Button("Cancel");
        gridPane.add(saveRate, 0, 1);
        gridPane.add(rates,0,0);
        gridPane.add(rateField, 1, 0);
        gridPane.add(cancel, 1,1 );
        gridPane.add(instruction, 0,2,2,1);
        saveRate.setOnAction(event -> {
            if (rateField != null){
                try {
                    saveRates();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);

                }
            }
            else {
                showAlert("Please set the rates for hour with commas as follows: 1, 2, 3");
            }
        });

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void saveRates() throws FileNotFoundException {
        File file = new File("C:\\Users\\USER\\Desktop\\CarParkingLot\\CarParkingLotFX\\src\\main\\resources\\rates.ini");
        if (!file.exists()){
            try {
                file.createNewFile();
                System.out.println("File Created successfully");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("File already exists");
        }
         try {
             PrintWriter printWriter = new PrintWriter(new FileWriter(file));
             String rates[] = rateField.getText().split(",");
             for (String rate : rates) {
                 printWriter.println(rate.trim());

             }
             System.out.println("Saved to the file rates.ini");
             printWriter.close();
         } catch (IOException e) {
             showAlert("Error saving rates "+ e.getMessage());
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
