package org.example.floor;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class Spot extends Pane {
    private List<Spot> spotsList= new ArrayList<>();
    public Spot() {
        createRectangle();
    }
    public Spot(String text, Font font, FontPosture posture, int fontSize, Shape shape, int shapeWidth, int shapeHeight, Color fillcolor, Color stroke, int strokeWidth){
        createRectangle();
    }


    private void createRectangle() {
        // Create the rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(30);   // Width set to 30 for EvCarSpot
        rectangle.setHeight(50);  // Height set to 50 for EvCarSpot
        rectangle.setArcWidth(10); // Rounded corners
        rectangle.setArcHeight(10);
        rectangle.setFill(Color.WHITE); // Fill color is white
        rectangle.setStroke(Color.GREEN); // Stroke is green (to distinguish from CarSpot)
        rectangle.setStrokeWidth(3);

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

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
