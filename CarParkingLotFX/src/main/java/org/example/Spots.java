package org.example;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Spots extends Pane {
    private String ID;
    protected Rectangle rectangle;

    public Spots(int width, int height, String ID){
        this.rectangle = createRectangle(width, height);
        this.ID = ID;
        setupClickerHandler();
    }
    public Spots(String ID){
        this.rectangle = createRectangle();
        this.ID = ID;
        setupClickerHandler();
    }
    public void setColor(Color color){
        this.rectangle.setStroke(color);
    }
    protected Rectangle createRectangle(int width, int height){
        Rectangle rect = new Rectangle();
        rect.setHeight(height);
        rect.setWidth(width);
        rect.setStroke(Color.BLACK);
        rect.setFill(Color.WHITE);
        rect.setArcWidth(10);
        rect.setArcHeight(10);
        rect.setStrokeWidth(3);
        return rect;
    }
    protected Rectangle createRectangle(){
        Rectangle rect = new Rectangle();
        rect.setHeight(50);
        rect.setWidth(30);
        rect.setStroke(Color.BLACK);
        rect.setFill(Color.WHITE);
        rect.setArcWidth(10);
        rect.setArcHeight(10);
        rect.setStrokeWidth(3);
        return rect;
    }
    private void setupClickerHandler(){
        this.rectangle.setOnMouseClicked(event -> {
            if (this.rectangle.strokeProperty().get().equals(Color.RED)) {
                this.rectangle.setStroke(Color.BLACK);
            }else {
                this.rectangle.setStroke(Color.RED);
            }

        });
    }
    public abstract void createSpot();

}
