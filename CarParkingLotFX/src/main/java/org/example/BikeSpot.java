package org.example;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BikeSpot extends Spots implements TextContent {
    private Text text;

    public BikeSpot(String ID) {
        super(30,20, ID);
        createSpot();
    }

    @Override
    public void createSpot() {
        createContent();
        StackPane stackPane = new StackPane(rectangle, text);
        this.getChildren().add(stackPane);
    }

    @Override
    public void createContent() {
        setText("BIKE");
    }

    @Override
    public void setText(String content) {
        text = new Text(content);
        text.setFont(Font.font("Arial", 10));
    }
}
