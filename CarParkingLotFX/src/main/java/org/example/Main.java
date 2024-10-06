package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(5);

        hBox.getChildren().addAll(rectangle(10));
        borderPane.setBottom(hBox);
        borderPane.setLeft(new Sirojiddin());
        Scene scene = new Scene(borderPane, 600,400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public List<Rectangle> rectangle(int number){
        List<Rectangle> list = new ArrayList<>();
        for (int i = 0; i < number; i ++) {
            Rectangle rectangle = new Rectangle();
            rectangle.setArcHeight(10);
            rectangle.setArcWidth(10);
            rectangle.setWidth(50);
            rectangle.setHeight(100);
            rectangle.setStrokeWidth(3);
            rectangle.setFill(Color.GREEN);
            rectangle.setStroke(Color.BLACK);
            list.add(rectangle);
        }

        return list;
    }
}