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
import org.example.dbconnnection.DBConnection;
import org.example.floor.Spots;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingSpotApp extends Application {

    @Override
    public void start(Stage primaryStage) throws SQLException {
        DBConnection dbcon = new DBConnection();
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
        List<Spots> carCollections = new ArrayList<>();

        ResultSet rs = dbcon.executeQuery("SELECT * FROM Spot WHERE SpotType IN ('CAR', 'EVCAR', 'HANDICAPPED') ORDER BY SpotNumber;");


        while (rs.next()){

            if (rs.getString(2).equals(CarType.HANDICAPPED.toString())){
                carCollections.add(new HandicappedSpot());
            }
            if (rs.getString(2).equals(CarType.EVCAR.toString())){
                carCollections.add(new EvCarSpot());
            }
            if (rs.getString(2).equals(CarType.CAR.toString())){
                carCollections.add(new CarSpot());
            }

        }
        tilePane.getChildren().addAll(carCollections);

        // Create an HBox for TruckSpot objects
        HBox hbox = new HBox(10); // 10 is the spacing between each spot


        // Create a VBox for 10 BikeSpot objects and 10 TruckSpot objects
        VBox bikeBox = new VBox(10); // 10 is the vertical spacing between each spot

        // Create and add BikeSpot instances to VBox
        List<Spots> bikeCollections = new ArrayList<>();

        ResultSet rsBike = dbcon.executeQuery("SELECT * FROM Spot WHERE SpotType IN ('BIKE') ORDER BY SpotNumber;");
        while (rsBike.next()) {

            if (rsBike.getString(2).equals(CarType.BIKE.toString())) {
                bikeCollections.add(new BikeSpot());
            }
        }
        // Add BikeSpots to the VBox
        bikeBox.getChildren().addAll(bikeCollections);

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
