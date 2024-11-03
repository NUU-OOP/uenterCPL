package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.example.dbconnnection.DBConnection;
import org.example.form.DisplayBoard;
import org.example.spots.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FirstFloor extends BorderPane {

    private final DBConnection dbcon = new DBConnection();

    public FirstFloor() throws SQLException {
        setupFirstFloorScene();
    }

    private void setupFirstFloorScene() throws SQLException {
        // Load parking spot data and display board
        DisplayBoard displayBoard = loadDisplayBoardData();

        // Create layout components
        TilePane carTilePane = createCarTilePane();
        VBox bikeBox = createBikeBox();
        HBox truckBox = createTruckBox();
        VBox entranceBox = createEntranceBox();
        HBox exitBox = createExitBox();

        // Arrange layout components
        HBox bottomContainer = new HBox(50, truckBox, exitBox);
        bottomContainer.setPadding(new Insets(10));

        // Set layout in the BorderPane
        this.setPadding(new Insets(10, 30, 50, 10));
        this.setTop(new VBox(10, carTilePane));
        this.setRight(bikeBox);
        this.setLeft(entranceBox);
        this.setBottom(bottomContainer);
        this.setCenter(displayBoard);
    }

    private DisplayBoard loadDisplayBoardData() throws SQLException {
        String query = "SELECT SpotType, COUNT(*) AS TotalSpots, " +
                       "SUM(CASE WHEN isOccupied = 1 THEN 1 ELSE 0 END) AS OccupiedSpots " +
                       "FROM Spot GROUP BY SpotType";

        // Initialize counters
        int evFilled = 0, evTotal = 0;
        int handicappedFilled = 0, handicappedTotal = 0;
        int compactFilled = 0, compactTotal = 0;
        int largeFilled = 0, largeTotal = 0;
        int motorcycleFilled = 0, motorcycleTotal = 0;

        // Execute the query and process results
        try (Statement stmt = dbcon.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String spotTypeStr = rs.getString("SpotType");
                SpotType spotType = SpotType.valueOf(spotTypeStr);
                int totalSpots = rs.getInt("TotalSpots");
                int occupiedSpots = rs.getInt("OccupiedSpots");

                switch (spotType) {
                    case ELECTRIC -> {
                        evTotal = totalSpots;
                        evFilled = occupiedSpots;
                    }
                    case HANDICAPPED -> {
                        handicappedTotal = totalSpots;
                        handicappedFilled = occupiedSpots;
                    }
                    case COMPACT -> {
                        compactTotal = totalSpots;
                        compactFilled = occupiedSpots;
                    }
                    case LARGE -> {
                        largeTotal = totalSpots;
                        largeFilled = occupiedSpots;
                    }
                    case MOTORCYCLE -> {
                        motorcycleTotal = totalSpots;
                        motorcycleFilled = occupiedSpots;
                    }
                }
            }
        }

        return new DisplayBoard(
            evFilled, evTotal,
            handicappedFilled, handicappedTotal,
            compactFilled, compactTotal,
            largeFilled, largeTotal,
            motorcycleFilled, motorcycleTotal
        );
    }

    private TilePane createCarTilePane() throws SQLException {
        String query = "SELECT * FROM Spot WHERE SpotType IN ('COMPACT', 'ELECTRIC', 'HANDICAPPED') ORDER BY SpotNumber";
        List<Spots> carSpots = loadSpots(query);
        TilePane tilePane = new TilePane(10, 10);  // Hgap, Vgap
        tilePane.getChildren().addAll(carSpots);
        return tilePane;
    }

    private VBox createBikeBox() throws SQLException {
        String query = "SELECT * FROM Spot WHERE SpotType = 'MOTORCYCLE' ORDER BY SpotNumber";
        List<Spots> bikeSpots = loadSpots(query);
        VBox bikeBox = new VBox(10);
        bikeBox.getChildren().addAll(bikeSpots);
        return bikeBox;
    }

    private HBox createTruckBox() throws SQLException {
        String query = "SELECT * FROM Spot WHERE SpotType = 'LARGE' ORDER BY SpotNumber";
        List<Spots> truckSpots = loadSpots(query);
        HBox truckBox = new HBox(5);
        truckBox.getChildren().addAll(truckSpots);
        return truckBox;
    }

    private VBox createEntranceBox() {
        VBox entranceBox = new VBox(30);
        entranceBox.setAlignment(Pos.CENTER);
        entranceBox.getChildren().addAll(
            new EntranceExit("Entrance"), new EntranceExit("Entrance")
        );
        return entranceBox;
    }

    private HBox createExitBox() {
        HBox exitBox = new HBox(90);
        exitBox.setAlignment(Pos.CENTER);
        EntranceExit exit1 = new EntranceExit("Exit");
        EntranceExit exit2 = new EntranceExit("Exit");
        exit1.setRotate(90);
        exit2.setRotate(90);
        exitBox.getChildren().addAll(exit1, exit2);
        return exitBox;
    }

    private List<Spots> loadSpots(String query) throws SQLException {
        List<Spots> spots = new ArrayList<>();

        try (ResultSet rs = dbcon.executeQuery(query)) {
            while (rs.next()) {
                SpotType type = SpotType.valueOf(rs.getString("SpotType"));
                boolean isOccupied = rs.getString("isOccupied").equals("1");
                Spots spot = createSpot(type, isOccupied);
                spots.add(spot);
            }
        }

        return spots;
    }

    private Spots createSpot(SpotType type, boolean isOccupied) {
        Spots spot;
        switch (type) {
            case HANDICAPPED -> spot = new HandicappedSpot("HC");
            case ELECTRIC -> spot = new EvCarSpot("1");
            case COMPACT -> spot = new CarSpot("ID");
            case MOTORCYCLE -> spot = new BikeSpot("a");
            case LARGE -> {
                spot = new TruckSpot(80, 30, "TR");
                spot.setRotate(90);
            }
            default -> throw new IllegalArgumentException("Unknown SpotType: " + type);
        }
        if (isOccupied) {
            spot.setColor(Color.RED);
        }
        return spot;
    }
}
