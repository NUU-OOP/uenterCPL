package org.example;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;

public class LoginPage extends Pane {
    private TextField loginField;
    private PasswordField passwordField;

    LoginPage(){
        LoginForm();
    }

    private void LoginForm(){
        // Create the labels
        Label loginLabel = new Label("Login:");
        Label passwordLabel = new Label("Password:");
        ComboBox<String> role = new ComboBox<>();
        role.getItems().add("Admin");
        role.getItems().add("Attendant");
        role.setPromptText("Select role for login");


        // Initialize the instance variables
        loginField = new TextField();
        passwordField = new PasswordField();

        // Create the submit button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> submit("admin"));

        // Create a grid pane and add the components
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.add(loginLabel, 0, 0);
        gridPane.add(loginField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(role, 1, 2);
        gridPane.add(submitButton, 2, 2);
        this.getChildren().add(gridPane);

    }

    // Check if fields are empty and show alert
    private void submit(String role) {
        if (role.equals("Admin")) {
            if (loginField.getText().isEmpty() || passwordField.getText().isEmpty()) {
                showAlert("Missing Information", "Please enter login and password.");
            } else if (loginField.getText().equals("admin") && passwordField.getText().equals("adminpass")) {
                showAlert("Login Successful", "Welcome Admin!");
            } else {
                showAlert("Login Failed", "Invalid username or password.");
            }
        }
        if (role.equals("Attendant")){
            //TODO Write code to connect database then check if user exist or not


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