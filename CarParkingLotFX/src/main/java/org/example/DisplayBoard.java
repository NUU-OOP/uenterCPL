package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;

public class DisplayBoard extends GridPane {

    private ProgressBar evSpotsProgress;
    private ProgressBar handicappedSpotsProgress;
    private ProgressBar compactSpotsProgress;
    private ProgressBar largeSpotsProgress;
    private ProgressBar motorcycleSpotsProgress;

    // Constructor to initialize the display with filled and total values
    public DisplayBoard(
            int evFilled, int evTotal,
            int handicappedFilled, int handicappedTotal,
            int compactFilled, int compactTotal,
            int largeFilled, int largeTotal,
            int motorcycleFilled, int motorcycleTotal) {

        // Configure the GridPane layout
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);  // Horizontal gap between columns
        this.setVgap(15);  // Vertical gap between rows
        this.setPadding(new Insets(20));  // Padding around the grid

        // Row 0: Total Spots
        Label totalSpotsLabel = new Label("Total Spots:");
        Label totalSpotsValue = new Label(evTotal+handicappedTotal+compactTotal+largeTotal+motorcycleTotal+""); // Example total spots

        // Row 1: EV Spots
        Label evSpotsLabel = new Label("EV Spots:");
        evSpotsProgress = new ProgressBar(calculatePercentage(evFilled, evTotal));
        Label evFractionLabel = new Label(evFilled + "/" + evTotal);

        // Row 2: Handicapped Spots
        Label handicappedSpotsLabel = new Label("Handicapped Spots:");
        handicappedSpotsProgress = new ProgressBar(calculatePercentage(handicappedFilled, handicappedTotal));
        Label handicappedFractionLabel = new Label(handicappedFilled + "/" + handicappedTotal);

        // Row 3: Compact Spots
        Label compactSpotsLabel = new Label("Compact Spots:");
        compactSpotsProgress = new ProgressBar(calculatePercentage(compactFilled, compactTotal));
        Label compactFractionLabel = new Label(compactFilled + "/" + compactTotal);

        // Row 4: Large Spots
        Label largeSpotsLabel = new Label("Large Spots:");
        largeSpotsProgress = new ProgressBar(calculatePercentage(largeFilled, largeTotal));
        Label largeFractionLabel = new Label(largeFilled + "/" + largeTotal);

        // Row 5: Motorcycle Spots
        Label motorcycleSpotsLabel = new Label("Motorcycle Spots:");
        motorcycleSpotsProgress = new ProgressBar(calculatePercentage(motorcycleFilled, motorcycleTotal));
        Label motorcycleFractionLabel = new Label(motorcycleFilled + "/" + motorcycleTotal);

        // Add components to the GridPane
        this.add(totalSpotsLabel, 0, 0);
        this.add(totalSpotsValue, 1, 0);

        this.add(evSpotsLabel, 0, 1);
        this.add(evSpotsProgress, 1, 1);
        this.add(evFractionLabel, 2, 1);

        this.add(handicappedSpotsLabel, 0, 2);
        this.add(handicappedSpotsProgress, 1, 2);
        this.add(handicappedFractionLabel, 2, 2);

        this.add(compactSpotsLabel, 0, 3);
        this.add(compactSpotsProgress, 1, 3);
        this.add(compactFractionLabel, 2, 3);

        this.add(largeSpotsLabel, 0, 4);
        this.add(largeSpotsProgress, 1, 4);
        this.add(largeFractionLabel, 2, 4);

        this.add(motorcycleSpotsLabel, 0, 5);
        this.add(motorcycleSpotsProgress, 1, 5);
        this.add(motorcycleFractionLabel, 2, 5);
    }

    // Helper method to calculate the percentage as a value between 0.0 and 1.0
    private double calculatePercentage(int filled, int total) {
        if (total == 0) return 0.0;  // Avoid division by zero
        return (double) filled / total;
    }
}
