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
        LoginPage loginPage = new LoginPage();
        Scene scene = new Scene(loginPage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}