package org.example.form;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.example.spots.CarSpot;

public class SecondFloor extends BorderPane {
    public SecondFloor(){
        creatFloorWithData();
    }
    private void creatFloorWithData(){
        VBox vBox = new VBox();
        CarSpot carSpot = new CarSpot();
        this.getChildren().addAll(carSpot);
    }
}
