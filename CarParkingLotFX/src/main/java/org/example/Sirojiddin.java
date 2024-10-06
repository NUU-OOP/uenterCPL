package org.example;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sirojiddin extends Pane {
    Sirojiddin(){
        create();
    }

    protected void create(){
        getChildren().clear();
        Rectangle rectangle = new Rectangle();
        rectangle.setArcHeight(10);
        rectangle.setArcWidth(10);
        rectangle.setWidth(50);
        rectangle.setHeight(100);
        rectangle.setStrokeWidth(3);
        rectangle.setFill(Color.GREEN);
        rectangle.setStroke(Color.BLACK);
        getChildren().add(rectangle);
    }
}
