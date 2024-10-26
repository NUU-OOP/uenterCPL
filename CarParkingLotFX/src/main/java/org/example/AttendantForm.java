package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.example.dbconnnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttendantForm extends Application {
    DBConnection dbcon=new DBConnection();
    private Connection conn= dbcon.getConnection();
    public AttendantForm() throws SQLException {
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Attendant");
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(20));

        // Define the font for all labels and text fields
        Font font = Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 18);

        // Name Label and TextField
        Label nameLabel = new Label("NAME:");
        nameLabel.setFont(font);
        TextField nameField = new TextField();
        nameField.setFont(font);

        // Login Label and TextField
        Label loginLabel = new Label("LOGIN:");
        loginLabel.setFont(font);
        TextField loginField = new TextField();
        loginField.setFont(font);

        // Password Label and PasswordField
        Label passwordLabel = new Label("PASSWORD:");
        passwordLabel.setFont(font);
        PasswordField passwordField = new PasswordField();
        passwordField.setFont(font);

        // Phone Label and TextField (numeric only)
        Label phoneLabel = new Label("PHONE:");
        phoneLabel.setFont(font);
        TextField phoneField = new TextField();
        phoneField.setFont(font);
        addNumericValidation(phoneField);

        // Age Label and TextField (numeric only)
        Label ageLabel = new Label("AGE:");
        ageLabel.setFont(font);
        TextField ageField = new TextField();
        ageField.setFont(font);
        addNumericValidation(ageField);

        // Save and Cancel Buttons
        Button saveButton = new Button("SAVE");
        saveButton.setFont(font);
        saveButton.setPrefSize(180, 50);
        saveButton.setOnAction(e->{
            if (nameField.getText().isEmpty() || loginField.getText().isEmpty() || passwordField.getText().isEmpty() || phoneField.getText().isEmpty()) {
                showAlert("Missing Information", "Please enter name,login,password and phone.");
            }else {
                insetTable(nameField.getText(), loginField.getText(), passwordField.getText(), phoneField.getText(), ageField.getText());
                nameField.setText(null);
                loginField.setText(null);
                passwordField.setText(null);
                phoneField.setText(null);
                ageField.setText(null);
            }

        });
        Button cancelButton = new Button("CANCEL");
        cancelButton.setFont(font);
        cancelButton.setPrefSize(180, 50);
        cancelButton.setOnAction(e->{
            System.exit(0);
        });
        // Add components to the GridPane (row, column)
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);

        gridPane.add(loginLabel, 0, 1);
        gridPane.add(loginField, 1, 1);

        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);

        gridPane.add(phoneLabel, 0, 3);
        gridPane.add(phoneField, 1, 3);

        gridPane.add(ageLabel, 0, 4);
        gridPane.add(ageField, 1, 4);

        // Create a sub-GridPane for the buttons to align them horizontally
        GridPane buttonPane = new GridPane();
        buttonPane.setHgap(20);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.add(saveButton, 0, 0);
        buttonPane.add(cancelButton, 1, 0);

        // Add the button pane to the main grid
        gridPane.add(buttonPane, 0, 5, 2, 1);
        Scene scene=new Scene(gridPane,430,400);
        stage.setScene(scene);
        stage.show();
    }


    // Method to add numeric input validation
    private void addNumericValidation(TextField textField) {
        textField.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String input = event.getCharacter();
            // Allow only digits
            if (!input.matches("\\d")) {
                event.consume(); // Ignore non-digit input
            }
        });
    }
    private void insetTable(String name,String login,String password,String phone,String age){
        String sql="INSERT INTO Attendant(name,phone,age,login,password,gate) VALUES(?,?,?,?,?,?);";
        try(PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,name);
            pstmt.setInt(2,Integer.parseInt(phone));
            pstmt.setInt(3,Integer.parseInt(age));
            pstmt.setString(4,login);
            pstmt.setString(5,password);
            pstmt.setInt(6,1);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
