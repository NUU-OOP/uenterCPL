package org.example.spots;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import org.example.dbconnnection.DBConnection;

import java.util.ArrayList;
import java.util.List;

public abstract class Spots extends Pane{
    protected Rectangle rectangle = new Rectangle();
    private  String ID;
    public Spots(int width, int height, String ID){
        rectangle.setStroke(Color.BLUE);
        rectangle.setFill(Color.WHITE);
        rectangle.setArcWidth(10);
        rectangle.setArcHeight(10);
        rectangle.setStrokeWidth(3);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        rectangle.setOnMouseClicked(event -> {
            rectangle.setStroke(Color.RED);
        });
        this.ID = ID;
    }
    public void setColor(Color color){
        this.rectangle.setStroke(color);
    }
    protected abstract void createRectangle();

}
