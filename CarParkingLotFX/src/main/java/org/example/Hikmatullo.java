package org.example;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Hikmatullo extends Pane {
    Hikmatullo(){
        create();
    }

    protected void create(){
        getChildren().clear();
        Label label=new Label();
        label.setText("Name:");
        label.setLayoutX(10);
        TextField textField=new TextField();
        textField.setLayoutX(65);

        Label label1=new Label();
        label1.setText("Login:");
        label1.setLayoutX(10);
        label1.setLayoutY(35);
        TextField textField1=new TextField();
        textField1.setLayoutX(65);
        textField1.setLayoutY(35);

        Label label2=new Label();
        label2.setText("Pass:");
        label2.setLayoutX(10);
        label2.setLayoutY(70);
        TextField textField2=new TextField();
        textField2.setLayoutX(65);
        textField2.setLayoutY(70);

        Label label3=new Label();
        label3.setText("Phone:");
        label3.setLayoutX(10);
        label3.setLayoutY(105);
        TextField textField3=new TextField();
        textField3.setLayoutX(65);
        textField3.setLayoutY(105);

        Button button=new Button("Scane");
        button.setLayoutX(40);
        button.setLayoutY(140);

        Button button1=new Button("Cancel");
        button1.setLayoutX(120);
        button1.setLayoutY(140);

        getChildren().add(label);
        getChildren().add(textField);
        getChildren().add(label1);
        getChildren().add(textField1);
        getChildren().add(label2);
        getChildren().add(textField2);
        getChildren().add(label3);
        getChildren().add(textField3);
        getChildren().add(button);
        getChildren().add(button1);
    }
}
