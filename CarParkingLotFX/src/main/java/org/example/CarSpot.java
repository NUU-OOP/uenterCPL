package org.example;

import javafx.scene.layout.StackPane;

public class CarSpot extends Spots  {

    public CarSpot(String ID) {
        super(ID);
        createSpot();
    }

    @Override
    public void createSpot() {

        StackPane stackPane = new StackPane(rectangle);
        this.getChildren().add(stackPane);
    }

}
