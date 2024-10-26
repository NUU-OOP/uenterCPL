package org.example.spots;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import org.example.spots.Spots;

public class HandicappedSpot extends Spots {

    public HandicappedSpot() {
        super(30, 50, "1");
        createRectangle();
    }


    @Override
    protected void createRectangle() {

        // Create an ImageView to display the handicapped icon
//        Image image = new Image(getClass().getResource("/img.png").toExternalForm());
//        ImageView imageView = new ImageView(image);
//        imageView.setFitWidth(25); // Resize the image to fit inside the rectangle
//        imageView.setFitHeight(45);
//        imageView.setPreserveRatio(true); // Keep the aspect ratio
        // Create the text to display inside the rectangle
        Text text = new Text("H");
        text.setFont(Font.font("Verdana", FontPosture.REGULAR, 18)); // Set font to Italic and size 20
        text.setFill(Color.BLUE);  // Set the text color to green
        // Use a StackPane to position the text in the center of the rectangle

        // Use a StackPane to layer the rectangle and image
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle,text);

        // Add the StackPane to the HandicappedSpot pane
        this.getChildren().add(stackPane);
    }
}
