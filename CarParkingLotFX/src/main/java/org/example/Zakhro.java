package org.example;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Zakhro  extends Pane {
    Zakhro(){
        CreateAttendentMenu();
    }
    protected void CreateAttendentMenu(){
        getChildren().clear();

        Text scan = new Text("Scan");
        TextField textField = new TextField();

        Text enter = new Text("Entrance time:");
        Text exit = new Text("Exit time:");
        Text amount = new Text("Amount:");
        Text extraFee = new Text("Extra fee:");
        Button pay =new Button("Pay");
        Button cancel =new Button("Cancel");
        HBox hbox_button = new HBox();
        hbox_button.getChildren().addAll(pay, cancel);
        hbox_button.setPadding(new Insets(0, 20, 10, 80));
        hbox_button.setSpacing(10);
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        hbox.getChildren().addAll(scan, textField);
        hbox.setSpacing(80);
        vbox.getChildren().addAll(hbox, enter, exit, amount, extraFee);
        vbox.setSpacing(15);
        vbox.setPadding(new Insets(20,20,20,20));
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(vbox);
        borderPane.setBottom(hbox_button);


        getChildren().add(borderPane);
//        Scene scene =new Scene(vbox);
//        Stage stage =new Stage();
//        stage.setScene(scene);
//        stage.show();




    }
}
