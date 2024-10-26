package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.dbconnnection.DBConnection;
import org.example.spots.*;
import org.example.form.CustomMenuBar;
import org.example.form.DisplayBoard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingSpotApp extends Application {

    @Override
    public void start(Stage primaryStage) throws SQLException {
        DBConnection dbcon = new DBConnection();
        primaryStage.setTitle("First floor");
        Button center = new Button("Center");
        VBox topVboxwithMenu = new VBox(10);
        DisplayBoard displayBoard = new DisplayBoard(10,100,80,100,23,25,10,15,23,25);
        CustomMenuBar menuBars = new CustomMenuBar(primaryStage);
        MenuBar menuBar = menuBars.createMenuBar();
//
        // Create a BorderPane as the root layout
        BorderPane borderPane = new BorderPane();

        // Create a TilePane for CarSpot, EvCarSpot, and HandicappedSpot
        TilePane tilePane = new TilePane();
        tilePane.setHgap(10); // Horizontal gap between tiles
        tilePane.setVgap(10); // Vertical gap between tiles

        // Create and add CarSpot instances
        List<Spots> carCollections = new ArrayList<>();

        ResultSet rs = dbcon.executeQuery("SELECT * FROM Spot WHERE SpotType IN ('CAR', 'EVCAR', 'HANDICAPPED') ORDER BY SpotNumber;");


        while (rs.next()){

            if (rs.getString(2).equals(SpotType.HANDICAPPED.toString())){
                HandicappedSpot h = new HandicappedSpot();
                if (rs.getString(4).equals("1")){
                    h.setColor(Color.RED);
                }
                carCollections.add(h);
            }
            if (rs.getString(2).equals(SpotType.ELECTRIC.toString())){
                carCollections.add(new EvCarSpot());
            }
            if (rs.getString(2).equals(SpotType.COMPACT.toString())){
                carCollections.add(new CarSpot());
            }

        }
        tilePane.getChildren().addAll(carCollections);
        topVboxwithMenu.getChildren().addAll(menuBar,tilePane);

        // Create an HBox for TruckSpot objects
        HBox hbox = new HBox(10); // 10 is the spacing between each spot


        // Create a VBox for 10 BikeSpot objects and 10 TruckSpot objects
        VBox bikeBox = new VBox(10); // 10 is the vertical spacing between each spot

        // Create and add BikeSpot instances to VBox
        List<Spots> bikeCollections = new ArrayList<>();

        ResultSet rsBike = dbcon.executeQuery("SELECT * FROM Spot WHERE SpotType IN ('BIKE') ORDER BY SpotNumber;");
        while (rsBike.next()) {

            if (rsBike.getString(2).equals(SpotType.MOTORBIKE.toString())) {
//                BikeSpot bikeSpot = new BikeSpot();
//                bikeSpot.setRotate(90);
//                bikeCollections.add(bikeSpot);


            }
        }
        // Add BikeSpots to the VBox
        bikeBox.getChildren().addAll(bikeCollections);
        //Truck spot added
        HBox truckBox = new HBox(10);

        List<Spots> truckCollections = new ArrayList<>();
        ResultSet rsT = dbcon.executeQuery("SELECT * FROM Spot WHERE SpotType IN ('TRUCK') ORDER BY SpotNumber;");
        while (rsT.next()){
                truckCollections.add(new TruckSpot());
        }

        //Entrance gate
        Entrance entrance = new Entrance();
        Entrance entrance1 = new Entrance();
        VBox entranceBox = new VBox(30);
        entranceBox.setAlignment(Pos.CENTER);
        entranceBox.getChildren().addAll(entrance1, entrance);
        //Exit gate
        Exit exit1 = new Exit();
        Exit exit2 = new Exit();
        exit1.setRotate(90);
        exit2.setRotate(90);
        HBox exitBox = new HBox(90);
        exitBox.getChildren().addAll(exit1, exit2);
        truckBox.getChildren().addAll(truckCollections);
        HBox bottomContainer = new HBox(50);
        bottomContainer.getChildren().addAll(truckBox, exitBox);
        borderPane.setPadding(new Insets(10,10,10,10));
        // Set the VBox at the bottom of the BorderPane
        borderPane.setBottom(bottomContainer);
        borderPane.setRight(bikeBox);
        borderPane.setLeft(entranceBox);
        // Set the TilePane at the top of the BorderPane
        borderPane.setTop(topVboxwithMenu);
        borderPane.setCenter(displayBoard);


        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(borderPane, 900, 600);

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the application
    }
}
