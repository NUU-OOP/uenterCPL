package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

//        Button button = new Button(" OK ");
//        button.setDisable(true);
//        button.setOnAction(event -> {
//            System.out.println("OK BUTTON CLICK");
//        });
//        TextField textField = new TextField();
//        textField.setOnAction(event -> {
//            System.out.println("Key pressed");
//            textField.selectAll();
//        });
//        PasswordField passwordField = new PasswordField();
//        passwordField.setOnAction(event -> {
//            System.out.println("Password entered");
//            passwordField.selectAll();
//        });
//        ComboBox<String> comboBox = new ComboBox<>();
//        comboBox.getItems().add("Truck");
//        comboBox.getItems().add("Car");
//        comboBox.getItems().add("Bike");
//        comboBox.setOnAction(ActionEvent -> {
//            int selectedIndex = comboBox.getSelectionModel().getSelectedIndex();
//            System.out.println(selectedIndex);
//        });
//        RadioButton radioButton = new RadioButton();
//        radioButton.setOnAction(event -> {
//            System.out.println(radioButton.isSelected());
//        });
//        CheckBox checkBox = new CheckBox("I am first answer");
//        checkBox.setOnAction(event -> {
//            if (checkBox.isSelected()){
//                button.setDisable(false);
//            }else {
//                button.setDisable(true);
//            }
//        });
//        Node node = new Button("NODE BUTTON");
//        node.setOnMouseReleased(event -> {
//            System.out.println("I released mouse");
//        });
//        node.setOnMouseEntered(e->{
//            System.out.println("Mouse entered territory of button");
//        });
//        node.setOnMouseExited(e->{
//            System.out.println("Mouse exit territory of button");
//        });
        VBox left = new VBox(30);
        left.setPadding(new Insets(20, 20,20,20));
        VBox right = new VBox(20);
        right.setPadding(new Insets(20, 20, 20, 20));
        Label itemID = new Label("Item ID");
        Label itemPrice = new Label("Item Price");
        Label installmentMonth = new Label("Instalment months");
        Label initialAmount = new Label("Initial amount");
        Label paymentEachMonth = new Label("Payment each month");
        Label totalPayment = new Label("Total payment");
        TextField textID = new TextField("1111");
        TextField textItemPrice = new TextField();
        TextField installmentM = new TextField();
        TextField initial = new TextField();
        TextField payment= new TextField();
        TextField total = new TextField();
        Button button = new Button("Calculate");
        button.setOnAction(event -> {
            if (!textItemPrice.getText().isEmpty() && !installmentM.getText().isEmpty()) {
                Double price = Double.valueOf(textItemPrice.getText());
                int month = Integer.parseInt(installmentM.getText());
                Double amount;
                if (initial.getText().isEmpty()){
                     amount = Double.valueOf("0");
                }else {
                    amount = Double.valueOf(initial.getText());
                }
                payment.setText(String.valueOf((price - amount) / month));
                total.setText(String.valueOf(price - amount));
            }
        });
        left.getChildren().addAll(itemID, itemPrice, installmentMonth, initialAmount, paymentEachMonth, totalPayment);
        right.getChildren().addAll(textID, textItemPrice, installmentM, initial, payment, total, button);
        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(left, right);
        Scene scene = new Scene(hBox, 530, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}