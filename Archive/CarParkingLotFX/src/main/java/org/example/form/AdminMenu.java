package org.example.form;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Scanner;

public class AdminMenu extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("OK");
        Scene scene = new Scene(button, 200,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
