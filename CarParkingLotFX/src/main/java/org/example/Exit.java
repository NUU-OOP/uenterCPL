package org.example;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Exit extends StackPane {

    public Exit() {
        createRectangleWithText();
    }

    private void createRectangleWithText() {
        // Create rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(20);   // Width set to 20 for Enterance
        rectangle.setHeight(70);  // Height set to 70 for Enterance
        rectangle.setArcWidth(15); // Rounded corners
        rectangle.setArcHeight(15);
        rectangle.setFill(Color.LIGHTGRAY); // Fill color is light gray
        rectangle.setStroke(Color.DARKGREEN); // Stroke is dark green
        rectangle.setStrokeWidth(1);

        // Create text
        Text text = new Text("Exit");
        text.setRotate(90); // Rotate the text 90 degrees
        text.setFont(new Font(15));  // Font size set to 15
        text.setFill(Color.BLACK);   // Text color is black
        text.setTextAlignment(TextAlignment.CENTER);

        // Position the text in the center of the rectangle after rotation
        text.setX(rectangle.getX() + (rectangle.getHeight() / 2) - (text.getLayoutBounds().getHeight() / 2));
        text.setY(rectangle.getY() + (rectangle.getWidth() / 2) + (text.getLayoutBounds().getWidth() / 2));
        // Add rectangle and text to the pane
        this.getChildren().addAll(rectangle, text);
    }
}