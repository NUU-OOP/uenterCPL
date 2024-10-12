package org.example;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CarSpot extends Pane {

    public CarSpot() {
        createRectangle();
    }

    private void createRectangle() {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(30);   // Width set to 30 for CarSpot
        rectangle.setHeight(50);  // Height set to 50 for CarSpot
        rectangle.setArcWidth(10); // Rounded corners
        rectangle.setArcHeight(10);
        rectangle.setFill(Color.WHITE); // Fill color is white
        rectangle.setStroke(Color.BLUE); // Stroke is blue
        rectangle.setStrokeWidth(3);

        this.getChildren().add(rectangle);
    }
}
