package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.dbconnnection.DBConnection;
import org.sqlite.core.DB;

import java.sql.Connection;
import java.sql.SQLException;

public class AttendantForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Attendant Form");



        // Create GridPane layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
        // Labels and text fields
        Label idLabel = new Label("ID:");
        TextField idField = new TextField();

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label phoneLabel = new Label("Phone:");
        TextField phoneField = new TextField();

        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();

        Label loginLabel = new Label("Login:");
        TextField loginField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Label gateLabel = new Label("Gate:");
        TextField gateField = new TextField();

        // Create a submit button
        Button submitButton = new Button("Submit");

        // Place elements in the grid

        grid.add(idLabel, 0, 0);
        grid.add(idField, 1, 0);
        grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);

        grid.add(phoneLabel, 0, 2);
        grid.add(phoneField, 1, 2);

        grid.add(ageLabel, 0, 3);
        grid.add(ageField, 1, 3);

        grid.add(loginLabel, 0, 4);
        grid.add(loginField, 1, 4);

        grid.add(passwordLabel, 0, 5);
        grid.add(passwordField, 1, 5);

        grid.add(gateLabel, 0, 6);
        grid.add(gateField, 1, 6);

        grid.add(submitButton, 1, 7);
        submitButton.setOnAction(event -> {
            try {
                // Collect data from fields

                String name = nameField.getText();
                int phone = Integer.parseInt(phoneField.getText());
                int age = Integer.parseInt(ageField.getText());
                String login = loginField.getText();
                String password = passwordField.getText();
                int gate = Integer.parseInt(gateField.getText());

                // Generate the INSERT SQL command
                String sql = String.format(
                        "INSERT INTO Attendant (name, phone, age, login, password, gate) " +
                                "VALUES ('%s', %d, %d, '%s', '%s', %d);",
                         name, phone, age, login, password, gate
                );
                DBConnection.insertData(sql);
                System.out.println(sql);

            } catch (NumberFormatException ex) {
                System.out.println("Invalid input: " + ex.getMessage());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        // Set the scene and display the stage
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
