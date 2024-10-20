package org.example;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import org.example.floor.Spots;

public class BikeSpot extends Spots {

    public BikeSpot() {
        createRectangle();
    }
    @Override
    protected void createRectangle() {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(20);   // Smaller width for a bike spot
        rectangle.setHeight(40);  // Smaller height for a bike spot
        rectangle.setArcWidth(10); // Rounded corners
        rectangle.setArcHeight(10);
        rectangle.setFill(Color.WHITE); // Fill color is white
        rectangle.setStroke(Color.GREEN); // Stroke is green to differentiate from CarSpot
        rectangle.setStrokeWidth(3);

        // Use a StackPane to place the rectangle
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle);

        // Add the StackPane to the BikeSpot pane
        this.getChildren().add(stackPane);
    }
}
