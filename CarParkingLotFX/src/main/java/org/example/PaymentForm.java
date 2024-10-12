package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PaymentForm extends Pane {
   Boolean is_paid = false;
   PaymentForm(){
       creatForm();
   }
   private void creatForm(){
       getChildren().clear();
       // Create labels and text fields
       ToggleGroup group = new ToggleGroup();
       RadioButton cashLabel = new RadioButton("Cash:");
       cashLabel.setPadding(new Insets(5));
       cashLabel.setToggleGroup(group);

       RadioButton accountLabel = new RadioButton("Account:");
       accountLabel.setToggleGroup(group);
       RadioButton cardLabel = new RadioButton("Card:");
       cardLabel.setPadding(new Insets(5));
       cardLabel.setToggleGroup(group);

       Label accountNumberLabel = new Label("Account Number:");
       TextField accountNumber = new TextField();



       Label cashAmountLabel = new Label("Amount");
       TextField cashAmount = new TextField();


       Label cardNumberLabel = new Label("Card Number:");
       TextField cardNumber = new TextField();
       Label cardAmountLabel = new Label("Amount:");
       TextField cardAmount = new TextField();

       Button payButton = new Button("Pay");

       cashLabel.setOnAction(event -> {
           cashLabel.setSelected(true);
           cardLabel.setSelected(false);
           accountLabel.setSelected(false);

           cashAmount.setEditable(true);

           accountNumber.clear();
           cardNumber.clear();
           cardAmount.clear();

           accountNumber.setEditable(false);
           cardNumber.setEditable(false);
           cardAmount.setEditable(false);
       });
       cardLabel.setOnAction(event -> {
           cardLabel.setSelected(true);
           accountLabel.setSelected(false);
           cashLabel.setSelected(false);

           accountNumber.clear();
           cashAmount.clear();

           cardAmount.setEditable(true);
           cardNumber.setEditable(true);
           cashAmount.setEditable(false);
           accountNumber.setEditable(false);
       });

       accountLabel.setOnAction(event ->{
           accountLabel.setSelected(true);
           cashLabel.setSelected(false);
           cardLabel.setSelected(false);

           cashAmount.clear();
           cardNumber.clear();
           cardAmount.clear();

           accountNumber.setEditable(true);
           cashAmount.setEditable(false);
           cardNumber.setEditable(false);
           cardAmount.setEditable(false);

       } );
       accountLabel.setPadding(new Insets(5));
       // Create buttons

       payButton.setAlignment(Pos.BOTTOM_CENTER);
       payButton.setPadding(new Insets(10,10,10,10));
       payButton.setPrefWidth(70);
       payButton.setOnAction(event -> {
           if (cashAmount.getText().isEmpty() && (cardNumber.getText().isEmpty() || cardAmount.getText().isEmpty()) && accountNumber.getText().isEmpty()) {
               System.out.println("You should pay");
               is_paid = false;
               System.out.println("is_paid = "+is_paid);
           }
           else {
               is_paid = true;
               System.out.println("is_paid = "+is_paid);
           }
       });

       // Layout
       GridPane grid = new GridPane();
       grid.setPadding(new Insets(20, 0, 0, 0));
       grid.setPadding(new Insets(10, 10, 10, 10));
       grid.setVgap(25);
       grid.setHgap(20);

       // Add components to the grid
       grid.add(cashLabel, 0, 0);
       VBox cashAmountBox = new VBox(0, cashAmountLabel, cashAmount);
       cashAmountBox.setPadding(new Insets(-8, 0,30,0));
       grid.add(cashAmountBox, 1, 0,1,2);

       grid.add(cardLabel, 0, 1);
       VBox cardNumberBox = new VBox(0, cardNumberLabel, cardNumber); // VBox with zero spacing
       grid.add(cardNumberBox, 1, 1, 1, 2);

       VBox cardAmountBox = new VBox(0, cardAmountLabel, cardAmount);
       grid.add(cardAmountBox, 2, 1,1,2);



       grid.add(accountLabel, 0, 3);
       VBox accountBox = new VBox(0, accountNumberLabel, accountNumber);
       accountBox.setPadding(new Insets(20, 0,0,0));
       grid.add(accountBox, 1, 2, 1, 3);

       grid.add(payButton, 2, 5);
       this.getChildren().add(grid);

//
//        Scene scene =new Scene(grid, 600,390);
//        Stage primarystage = new Stage();
//        primarystage.setScene(scene);
//        primarystage.show();


   }
}
