package org.example.spots;

import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class BikeSpot extends Spots {

    public BikeSpot(String ID) {
        super(20, 40, ID);
        createRectangle();

    }
    @Override
    protected void createRectangle() {
        // Create the text to display inside the rectangle
        Text text = new Text("BIKE");
        text.setFont(Font.font("Verdana", FontPosture.ITALIC, 12)); // Set font to Italic and size 20
        text.setFill(Color.GREEN);  // Set the text color to green
        text.setRotate(90);
        // Create the rectangle for the bike spot

        rectangle.setArcWidth(10); // Rounded corners
        rectangle.setArcHeight(10);
        rectangle.setFill(Color.WHITE); // Fill color is white

        rectangle.setStrokeWidth(3);

        // Use a StackPane to place the rectangle
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, text);

        // Add the StackPane to the BikeSpot pane
        this.getChildren().add(stackPane);
    }
}
