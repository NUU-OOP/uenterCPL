package org.example;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

public class TruckSpot extends Pane {

    public TruckSpot() {
        createRectangleWithText();
    }

    private void createRectangleWithText() {
        // Create a StackPane to hold both the rectangle and the text
        StackPane stackPane = new StackPane();

        // Create the rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(35);
        rectangle.setHeight(100);
        rectangle.setArcWidth(10);
        rectangle.setArcHeight(10);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLUE);
        rectangle.setStrokeWidth(3);

        // Create the text
        Text text = new Text("Truck");
        text.setFill(Color.BLACK); // Text color is black
        text.setRotate(90);
        text.setFont(Font.font("Times New Roman",FontPosture.ITALIC, 18));

        // Add the rectangle and text to the StackPane
        stackPane.getChildren().addAll(rectangle, text);
        stackPane.setAlignment(Pos.CENTER); // Center the text inside the rectangle

        // Add the StackPane to the Pane (TruckSpot)
        this.getChildren().add(stackPane);
    }
}
