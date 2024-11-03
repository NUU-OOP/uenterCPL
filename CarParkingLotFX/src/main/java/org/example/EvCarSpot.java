package org.example;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;

public class EvCarSpot extends Spots implements TextContent{

    private Text text;

    public EvCarSpot(String ID) {
        super(ID);
        createSpot();
    }

    @Override
    public void createContent() {
        setText("EV");
    }

    @Override
    public void createSpot() {
        createContent();
        StackPane stackPane = new StackPane(rectangle, text);
        stackPane.setAlignment(Pos.CENTER);
        this.getChildren().add(stackPane);
    }

    @Override
    public void setText(String content) {
        text = new Text(content);
        text.setFont(Font.font("Times New Roman", FontWeight.BOLD,FontPosture.ITALIC,14));
        text.setFill(Color.GREEN);

    }
}
