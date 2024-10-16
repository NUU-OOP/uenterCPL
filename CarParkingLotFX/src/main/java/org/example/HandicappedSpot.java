package org.example;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;

public class HandicappedSpot extends Pane {

    public HandicappedSpot() {
        createHandicappedSpot();
    }

    private void createHandicappedSpot() {
        // Create the rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(30);   // Width set to 30
        rectangle.setHeight(50);  // Height set to 50
        rectangle.setArcWidth(10); // Rounded corners
        rectangle.setArcHeight(10);
        rectangle.setFill(Color.WHITE); // Fill color is white
        rectangle.setStroke(Color.BLUE); // Stroke is blue
        rectangle.setStrokeWidth(3);

        // Create an ImageView to display the handicapped icon
        Image image = new Image(getClass().getResource("/img.png").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(25); // Resize the image to fit inside the rectangle
        imageView.setFitHeight(45);
        imageView.setPreserveRatio(true); // Keep the aspect ratio

        // Use a StackPane to layer the rectangle and image
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, imageView);

        // Add the StackPane to the HandicappedSpot pane
        this.getChildren().add(stackPane);
    }
}
