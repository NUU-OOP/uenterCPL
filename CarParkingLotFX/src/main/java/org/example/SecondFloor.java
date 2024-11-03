package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SecondFloor extends BorderPane {
    private final DBConnection dbcon = new DBConnection();

    public SecondFloor() throws SQLException {
        createFloorWithData();
    }

    private void createFloorWithData() throws SQLException {
        // Load parking spot data and display board for the second floor
        DisplayBoard displayBoard = loadDisplayBoardData();

        // Create layout components for parking spots
        TilePane carTilePane = createCarTilePane();
        VBox entranceBox = createEntranceBox();
        HBox exitBox = createExitBox();

        // Initialize bottom container for layout consistency
        HBox bottomContainer = new HBox(50, exitBox);  // Add exitBox to bottomContainer
        bottomContainer.setAlignment(Pos.CENTER);
        bottomContainer.setPadding(new Insets(10));

        // Set layout in the BorderPane
        this.setPadding(new Insets(10, 30, 50, 10));
        this.setTop(carTilePane);
        this.setLeft(entranceBox);
        this.setBottom(bottomContainer);
        this.setCenter(displayBoard);
    }

    private DisplayBoard loadDisplayBoardData() throws SQLException {
        // Query to fetch data for the second floor
        String query = "SELECT SpotType, COUNT(*) AS TotalSpots, " +
                "SUM(CASE WHEN isOccupied = 1 THEN 1 ELSE 0 END) AS OccupiedSpots " +
                "FROM Spot GROUP BY SpotType";

        int evFilled = 0, evTotal = 0;
        int handicappedFilled = 0, handicappedTotal = 0;
        int compactFilled = 0, compactTotal = 0;

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
                }
            }
        }

        return new DisplayBoard(
                evFilled, evTotal,
                handicappedFilled, handicappedTotal,
                compactFilled, compactTotal
        );
    }

    private TilePane createCarTilePane() throws SQLException {
        String query = "SELECT * FROM Spot WHERE SpotType IN ('COMPACT', 'ELECTRIC', 'HANDICAPPED') AND FloorNumber = 2 ORDER BY SpotNumber";
        List<Spots> carSpots = loadSpots(query);
        TilePane tilePane = new TilePane(10, 10);  // Hgap, Vgap
        tilePane.getChildren().addAll(carSpots);
        return tilePane;
    }

    private VBox createEntranceBox() {
        VBox entranceBox = new VBox(30);
        entranceBox.setAlignment(Pos.CENTER);
        entranceBox.getChildren().addAll(new EntranceExit("Entrance"), new EntranceExit("Entrance"));
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
                String spotID = rs.getString("SpotID");
                Spots spot = createSpot(type, isOccupied, spotID);
                spots.add(spot);
            }
        }

        return spots;
    }

    private Spots createSpot(SpotType type, boolean isOccupied, String spotID) {
        Spots spot;
        switch (type) {
            case HANDICAPPED -> spot = new HandicappedSpot(spotID);
            case ELECTRIC -> spot = new EvCarSpot(spotID);
            case COMPACT -> spot = new CarSpot(spotID);
            default -> throw new IllegalArgumentException("Unknown SpotType: " + type);
        }
        if (isOccupied) {
            spot.setColor(Color.RED);
        }
        return spot;
    }
}
