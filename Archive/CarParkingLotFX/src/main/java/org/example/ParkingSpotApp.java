package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.dbconnnection.DBConnection;
import org.example.spots.*;
import org.example.form.CustomMenuBar;
import org.example.form.DisplayBoard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ParkingSpotApp extends Application {
    private BorderPane borderPane;

    @Override
    public void start(Stage primaryStage) throws SQLException {
        CustomMenuBar customMenuBar = new CustomMenuBar();
        BorderPane root = new BorderPane();
        //root.setPadding(new Insets(10,10,10,10));
        root.setTop(customMenuBar.createMenuBar(root));
        root.setCenter(new FirstFloor());
        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(root, 900, 600);
        primaryStage.setTitle("Welcome to Car Parking Lot");
        primaryStage.setScene(scene);

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the application
    }

}
