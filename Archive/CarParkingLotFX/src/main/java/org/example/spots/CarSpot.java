package org.example.spots;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

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
