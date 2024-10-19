package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.example.dbconnnection.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static final String DB_URL = "jdbc:sqlite:university.db";
    @Override
    public void start(Stage primaryStage) throws Exception {

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                System.out.println("Connected to the database.");
                DBConnection.createTable(conn, "CREATE TABLE IF NOT EXISTS car (id INTEGER PRIMARY KEY, floor INTEGER NOT NULL," +
                        "" +
                        "                + \"id INTEGER PRIMARY KEY, \"\n" +
                        "                + \"name TEXT NOT NULL, \"\n" +
                        "                + \"age INTEGER, phone INTEGER);\";");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ParkingSpotApp parkingSpotApp = new ParkingSpotApp();
        parkingSpotApp.start(primaryStage);

    }

}