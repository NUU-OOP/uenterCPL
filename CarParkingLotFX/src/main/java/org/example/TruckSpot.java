package org.example;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import org.example.floor.Spots;

public class TruckSpot extends Spots {

    public TruckSpot() {
        super(35, 100, 1);
        createRectangle();

    }

    @Override
    protected void createRectangle() {
        // Create a StackPane to hold both the rectangle and the text
        StackPane stackPane = new StackPane();
        // Create the rectangle
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
