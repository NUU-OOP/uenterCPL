package org.example;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


// Payment method
public class Fazliddin extends Pane {

    void createPaymentForm() {
        getChildren().clear();

        // Create buttons
        Button cashButton = new Button("Cash");
        Button cardButton = new Button("Card");
        Button noteButton = new Button("Pay");

        // Set button size
        cashButton.setPrefSize(200, 100);
        cardButton.setPrefSize(200, 100);
        noteButton.setPrefSize(50, 50);

        // Create label
        Label cashLabel = new Label("Amount - ");

        // Set button actions
        cashButton.setOnAction(e -> System.out.println("Cash payment selected"));
        cardButton.setOnAction(e -> System.out.println("Card payment selected"));
        noteButton.setOnAction(e -> System.out.println("Note button pressed"));

        // Layout
        VBox layout = new VBox(10); // 10 is the spacing between buttons
        layout.getChildren().addAll(cashButton, cardButton, cashLabel, noteButton);

        getChildren().add(layout);

    }
}

