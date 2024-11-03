package org.example.form;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.spots.CarSpot;

public class SecondFloor extends BorderPane {
    public SecondFloor(){
        creatFloorWithData();
    }
    private void creatFloorWithData(){
        VBox vBox = new VBox();
        //CustomMenuBar customMenuBar = new CustomMenuBar();
        Button button = new Button("OK");
        ///this.getChildren().addAll( button, customMenuBar);
    }
}
