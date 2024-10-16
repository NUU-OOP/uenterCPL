package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ParkingSpotApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("First floor");
        Button left = new Button("Left");
        Button right = new Button("Right");
        Button center = new Button("Center");
        Button bottom = new Button("Bottom");
        Button top = new Button("Top");

        // Create a BorderPane as the root layout
        BorderPane borderPane = new BorderPane();

        // Create a TilePane for CarSpot, EvCarSpot, and HandicappedSpot
        TilePane tilePane = new TilePane();
        tilePane.setHgap(10); // Horizontal gap between tiles
        tilePane.setVgap(10); // Vertical gap between tiles

        // Create and add CarSpot instances
        org.example.CarSpot carSpot1 = new org.example.CarSpot();
        org.example.CarSpot carSpot2 = new org.example.CarSpot();
        org.example.CarSpot carSpot3 = new org.example.CarSpot();
        org.example.CarSpot carSpot4 = new org.example.CarSpot();
        org.example.CarSpot carSpot5 = new org.example.CarSpot();
        org.example.CarSpot carSpot6 = new org.example.CarSpot();
        org.example.CarSpot carSpot7 = new org.example.CarSpot();
        org.example.CarSpot carSpot8 = new org.example.CarSpot();
        org.example.CarSpot carSpot9 = new org.example.CarSpot();
        org.example.CarSpot carSpot10 = new org.example.CarSpot();
        org.example.CarSpot carSpot11 = new org.example.CarSpot();
        org.example.CarSpot carSpot12 = new org.example.CarSpot();
        org.example.CarSpot carSpot13 = new org.example.CarSpot();
        org.example.CarSpot carSpot14 = new org.example.CarSpot();
        org.example.CarSpot carSpot15 = new org.example.CarSpot();
        org.example.CarSpot carSpot16 = new org.example.CarSpot();
        org.example.CarSpot carSpot17 = new org.example.CarSpot();
        org.example.CarSpot carSpot18 = new org.example.CarSpot();
        org.example.CarSpot carSpot19 = new org.example.CarSpot();
        org.example.CarSpot carSpot20 = new CarSpot();

        // Add all CarSpots to TilePane
        tilePane.getChildren().addAll(carSpot1, carSpot2, carSpot3, carSpot4, carSpot5,
                                      carSpot6, carSpot7, carSpot8, carSpot9, carSpot10,
                                      carSpot11, carSpot12, carSpot13, carSpot14, carSpot15,
                                      carSpot16, carSpot17, carSpot18, carSpot19, carSpot20);

        // Create and add EvCarSpot instances
        EvCarSpot evCarSpot1 = new EvCarSpot();
        EvCarSpot evCarSpot2 = new EvCarSpot();
        EvCarSpot evCarSpot3 = new EvCarSpot();
        EvCarSpot evCarSpot4 = new EvCarSpot();
        EvCarSpot evCarSpot5 = new EvCarSpot();
        EvCarSpot evCarSpot6 = new EvCarSpot();
        EvCarSpot evCarSpot7 = new EvCarSpot();
        EvCarSpot evCarSpot8 = new EvCarSpot();
        EvCarSpot evCarSpot9 = new EvCarSpot();
        EvCarSpot evCarSpot10 = new EvCarSpot();

        // Add all EvCarSpots to TilePane
        tilePane.getChildren().addAll(evCarSpot1, evCarSpot2, evCarSpot3, evCarSpot4, evCarSpot5,
                                      evCarSpot6, evCarSpot7, evCarSpot8, evCarSpot9, evCarSpot10);

        // Create and add HandicappedSpot instances
        HandicappedSpot handicappedSpot1 = new HandicappedSpot();
        HandicappedSpot handicappedSpot2 = new HandicappedSpot();
        HandicappedSpot handicappedSpot3 = new HandicappedSpot();
        HandicappedSpot handicappedSpot4 = new HandicappedSpot();
        HandicappedSpot handicappedSpot5 = new HandicappedSpot();

        // Add all HandicappedSpots to TilePane
        tilePane.getChildren().addAll(handicappedSpot1, handicappedSpot2, handicappedSpot3,
                                      handicappedSpot4, handicappedSpot5);



        // Create an HBox for TruckSpot objects
        HBox hbox = new HBox(10); // 10 is the spacing between each spot


        // Create a VBox for 10 BikeSpot objects and 10 TruckSpot objects
        VBox bikeBox = new VBox(10); // 10 is the vertical spacing between each spot

        // Create and add BikeSpot instances to VBox
        BikeSpot bikeSpot1 = new BikeSpot();
        BikeSpot bikeSpot2 = new BikeSpot();
        BikeSpot bikeSpot3 = new BikeSpot();
        BikeSpot bikeSpot4 = new BikeSpot();
        BikeSpot bikeSpot5 = new BikeSpot();
        BikeSpot bikeSpot6 = new BikeSpot();
        BikeSpot bikeSpot7 = new BikeSpot();
        BikeSpot bikeSpot8 = new BikeSpot();
        BikeSpot bikeSpot9 = new BikeSpot();
        BikeSpot bikeSpot10 = new BikeSpot();
        bikeSpot1.setRotate(90);
        bikeSpot2.setRotate(90);
        bikeSpot3.setRotate(90);
        bikeSpot4.setRotate(90);
        bikeSpot5.setRotate(90);
        bikeSpot6.setRotate(90);
        bikeSpot7.setRotate(90);
        bikeSpot8.setRotate(90);
        bikeSpot9.setRotate(90);
        bikeSpot10.setRotate(90);

        // Add BikeSpots to the VBox
        bikeBox.getChildren().addAll(bikeSpot1, bikeSpot2, bikeSpot3, bikeSpot4, bikeSpot5,
                                  bikeSpot6, bikeSpot7, bikeSpot8, bikeSpot9, bikeSpot10);

        HBox truckBox = new HBox(10);
        // Create and add TruckSpot instances to the VBox
        TruckSpot truckSpot1 = new TruckSpot();
        TruckSpot truckSpot2 = new TruckSpot();
        TruckSpot truckSpot3 = new TruckSpot();
        TruckSpot truckSpot4 = new TruckSpot();
        TruckSpot truckSpot5 = new TruckSpot();
        TruckSpot truckSpot6 = new TruckSpot();
        TruckSpot truckSpot7 = new TruckSpot();
        TruckSpot truckSpot8 = new TruckSpot();
        TruckSpot truckSpot9 = new TruckSpot();
        TruckSpot truckSpot10 = new TruckSpot();
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
        // Add TruckSpots to the VBox
        truckBox.getChildren().addAll(truckSpot1, truckSpot2, truckSpot3, truckSpot4, truckSpot5,
                truckSpot6, truckSpot7, truckSpot8, truckSpot9, truckSpot10);
        HBox bottomContainer = new HBox(50);
        bottomContainer.getChildren().addAll(truckBox, exitBox);
        borderPane.setPadding(new Insets(10,10,10,10));
        // Set the VBox at the bottom of the BorderPane
        borderPane.setBottom(bottomContainer);
        borderPane.setRight(bikeBox);
        borderPane.setLeft(entranceBox);
        // Set the TilePane at the top of the BorderPane
        borderPane.setTop(tilePane);
        borderPane.setCenter(center);


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
