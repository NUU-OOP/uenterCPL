package org.example;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import org.example.floor.Spots;

public class EvCarSpot extends Spots{

    public EvCarSpot() {
        super(30, 50, 1);
        createRectangle();
    }

    @Override
    protected void createRectangle() {
        // Create the text to display inside the rectangle
        Text text = new Text("EV");
        text.setFont(Font.font("Verdana", FontPosture.ITALIC, 18)); // Set font to Italic and size 20
        text.setFill(Color.GREEN);  // Set the text color to green
        // Use a StackPane to position the text in the center of the rectangle
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, text);

        // Add the StackPane to the EvCarSpot pane
        this.getChildren().add(stackPane);
    }
}
