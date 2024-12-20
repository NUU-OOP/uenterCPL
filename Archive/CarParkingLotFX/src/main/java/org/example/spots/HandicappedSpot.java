package org.example.spots;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Objects;

public class HandicappedSpot extends Spots implements ImageContent {
    private ImageView imageView;

    public HandicappedSpot( String ID) {
        super(ID);
        createSpot();
    }

    @Override
    public void createSpot() {
        createContent();
        StackPane stackPane = new StackPane(rectangle, imageView);
        this.getChildren().add(stackPane);
    }


    @Override
    public void createContent() {
        setImage("/img.png");
    }

    @Override
    public void setImage(String imagePath) {
        Image image = new Image(imagePath);
        imageView = new ImageView(image);
        imageView.setSmooth(true);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
    }
}
