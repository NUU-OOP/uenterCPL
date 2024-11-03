package org.example;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e->{
            System.exit(0);
        });
        submitButton.setOnAction(e -> {
            try {
                submit("Attendant");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

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
        gridPane.add(submitButton, 1, 3);
        gridPane.add(cancelButton,2,3);
        this.getChildren().add(gridPane);
    }

    // Check if fields are empty and show alert
    private void submit(String role) throws SQLException {
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

            DBConnection dbConnection = new DBConnection();
          ResultSet resultSet  = dbConnection.executeQuery("SELECT * FROM Attendant","1236","123123");
//          ResultSetMetaData metaData = resultSet.getMetaData();
//          int columnCount = metaData.getColumnCount();
//            System.out.println(columnCount);

          while (resultSet.next()){
              System.out.println("Checking");
              System.out.println(resultSet.getString(1));
//              if (resultSet.getString(1).equals("1236") && resultSet.getString(2).equals("123123")){
//                  System.out.println("FOUND");
//              }
          }
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