package org.example;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class Khusan extends Pane {
    protected TextField loginField;
    protected PasswordField passwordField;

    Khusan(){
        LoginForm();
    }

    private void LoginForm(){
        // Create the labels
        Label loginLabel = new Label("Login:");
        Label passwordLabel = new Label("Password:");

        // Initialize the instance variables
        loginField = new TextField();
        passwordField = new PasswordField();

        // Create the submit button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> submit());

        // Create a grid pane and add the components
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.add(loginLabel, 0, 0);
        gridPane.add(loginField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(submitButton, 1, 2);

        // Create the scene and set the stage
        Scene scene = new Scene(gridPane, 250, 120);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Login Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Check if fields are empty and show alert
    private void submit() {
        if (loginField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            showAlert("Missing Information", "Please enter login and password.");
        } else if (loginField.getText().equals("admin") && passwordField.getText().equals("adminpass")) {
            showAlert("Login Successful", "Welcome Admin!");
        } else {
            showAlert("Login Failed", "Invalid username or password.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}