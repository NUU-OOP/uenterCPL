package org.example.spots;

public class CarSpot extends Spots {

    public CarSpot() {
        super(30, 50,"1");
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
