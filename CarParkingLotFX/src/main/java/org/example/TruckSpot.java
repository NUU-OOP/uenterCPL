package org.example;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;

public class TruckSpot extends Spots implements TextContent{
    private Text text;

    public TruckSpot(int width, int height, String ID) {
        super(width, height, ID);
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
        setText("TRUCK");
    }

    @Override
    public void setText(String content) {
        text = new Text(content);

        text.setFont(Font.font("Arial", 14));
    }
}
