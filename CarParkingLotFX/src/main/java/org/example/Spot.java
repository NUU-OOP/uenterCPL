package org.example;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Spot extends Pane {
    @Override
    protected void setWidth(double width){
        super.setWidth(width);
    }


    private void paintSpot(){
        Rectangle rectangle = new Rectangle();
        rectangle.setStroke(Color.GREEN);
        rectangle.setFill(Color.BLUE);
        rectangle.setArcHeight(10);
        rectangle.setWidth(30);
        rectangle.setHeight(40);
        getChildren().add(rectangle);

    }

}
