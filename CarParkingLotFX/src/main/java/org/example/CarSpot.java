package org.example;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.example.floor.Spots;

public class CarSpot extends Spots {

    public CarSpot() {
        super(30, 50);
        createRectangle();
    }

    @Override
    protected void createRectangle() {
        rectangle.setWidth(30);   // Width set to 30 for CarSpot
        rectangle.setHeight(50);  // Height set to 50 for CarSpot
        this.getChildren().add(rectangle);
    }

//    @Override
//    void createRectangle() {

//    }
}
