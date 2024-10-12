package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PaymentForm extends Pane {
   PaymentForm(){
       creatForm();
   }
   private void creatForm(){
       // Create labels and text fields
       Label cashLabel = new Label("Cash:");
       cashLabel.setPadding(new Insets(5));
       Label cashAmountLabel = new Label("Amount");
       TextField cashAmount = new TextField();
       Label cardLabel = new Label("Card:");
       cardLabel.setPadding(new Insets(5));
       Label cardNumberLabel = new Label("Card Number:");
       TextField cardNumber = new TextField();
       Label cardAmountLabel = new Label("Amount:");
       TextField cardAmount = new TextField();
       Label accountLabel = new Label("Account:");
       accountLabel.setPadding(new Insets(5));
       Label accountNumberLabel = new Label("Account Number:");
       TextField accountNumber = new TextField();
       // Create buttons
       Button payButton = new Button("Pay");
       payButton.setAlignment(Pos.BOTTOM_CENTER);


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
   }
}
