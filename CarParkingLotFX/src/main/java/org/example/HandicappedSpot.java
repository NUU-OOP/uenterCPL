package org.example;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import org.example.floor.Spots;

public class HandicappedSpot extends Spots {

    public HandicappedSpot() {
        super(30, 50, 1);
        createRectangle();
    }


    @Override
    protected void createRectangle() {

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
