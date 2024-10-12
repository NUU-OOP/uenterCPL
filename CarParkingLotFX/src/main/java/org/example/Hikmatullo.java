package org.example;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Hikmatullo extends Pane {
    Hikmatullo(){
        create();
    }

    protected void create(){
        getChildren().clear();
        Label label1=new Label("NAME: ");
        label1.setLayoutX(20);
        label1.setLayoutY(25);
        label1.setFont(Font.font("Couier", FontWeight.BOLD, FontPosture.ITALIC,25));
        TextField textField1=new TextField();
        textField1.setLayoutX(175);
        textField1.setLayoutY(20);
        textField1.setFont(Font.font("Couier",FontWeight.BOLD,FontPosture.ITALIC,25));

        Label label2=new Label("LOGIN: ");
        label2.setLayoutX(20);
        label2.setLayoutY(100);
        label2.setFont(Font.font("Couier", FontWeight.BOLD, FontPosture.ITALIC,25));
        TextField textField2=new TextField();
        textField2.setLayoutX(175);
        textField2.setLayoutY(95);
        textField2.setFont(Font.font("Couier",FontWeight.BOLD,FontPosture.ITALIC,25));

        Label label3=new Label("PASSWORD: ");
        label3.setLayoutX(20);
        label3.setLayoutY(175);
        label3.setFont(Font.font("Couier", FontWeight.BOLD, FontPosture.ITALIC,25));
        PasswordField passwordField=new PasswordField();
        passwordField.setLayoutX(175);
        passwordField.setLayoutY(170);
        passwordField.setFont(Font.font("Couier",FontWeight.BOLD,FontPosture.ITALIC,25));

        Label label4=new Label("PHONE: ");
        label4.setLayoutX(20);
        label4.setLayoutY(250);
        label4.setFont(Font.font("Couier", FontWeight.BOLD, FontPosture.ITALIC,25));
        TextField textField3=new TextField();
        textField3.setLayoutX(175);
        textField3.setLayoutY(245);
        textField3.setFont(Font.font("Couier",FontWeight.BOLD,FontPosture.ITALIC,25));
        Button button=new Button("SCANE");
        button.setLayoutX(50);
        button.setLayoutY(325);
        button.setMinSize(180,50);
        button.setFont(Font.font("Couier",FontWeight.BOLD,FontPosture.ITALIC,25));

        Button button1=new Button("CANCEL");
        button1.setLayoutX(290);
        button1.setLayoutY(325);
        button1.setMinSize(180,50);
        button1.setFont(Font.font("Couier",FontWeight.BOLD,FontPosture.ITALIC,25));

        getChildren().add(label1);
        getChildren().add(textField1);
        getChildren().add(label2);
        getChildren().add(textField2);
        getChildren().add(label3);
        getChildren().add(passwordField);
        getChildren().add(label4);
        getChildren().add(textField3);
        getChildren().add(button);
        getChildren().add(button1);
    }
}
