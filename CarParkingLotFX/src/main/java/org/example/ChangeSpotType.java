package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangeSpotType extends Application {
    DBConnection dbcon=new DBConnection();
    private Connection conn= dbcon.getConnection();
    public ChangeSpotType() throws SQLException {
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Change Spot Type Form");
        Label searchSpot = new Label("Search Spot:");
        ComboBox<String> floorComboBox = new ComboBox<>();
        floorComboBox.getItems().addAll("First Floor", "Second Floor");;
        floorComboBox.setPromptText("Select floor");

        TextField searchField = new TextField();

        Label foundLabel = new Label("Found:");
        ComboBox<SpotType> carTypeComboBox = new ComboBox<>();
        carTypeComboBox.getItems().setAll(SpotType.values());
       /// carTypeComboBox.setPromptText("Select car type");
        GridPane dialogLayout = new GridPane();
        dialogLayout.setVgap(15);
        dialogLayout.setHgap(10);
        dialogLayout.setPadding(new Insets(10));
        dialogLayout.add(searchSpot, 0, 0);
        dialogLayout.add(floorComboBox, 1, 0);
        dialogLayout.add(searchField, 2, 0);
        dialogLayout.add(foundLabel, 0, 1);
        dialogLayout.add(carTypeComboBox, 1, 1);

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e->{
            //carTypeComboBox.setItems(SpotType.values());
            //Hikmatillo Uchun
        });
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e->stage.close());
        dialogLayout.add(searchButton, 2, 1);
        dialogLayout.add(cancelButton, 3, 1);
        Scene dialogScene = new Scene(dialogLayout, 450, 100);
        stage.setScene(dialogScene);
        stage.show();
    }
    private String readTable(String id){
        String query = "SELECT * FROM Spot WHERE SpotID = ?";
        try(PreparedStatement pstmt=conn.prepareStatement(query)){
            pstmt.setInt(1,Integer.parseInt(id));
            ResultSet resultSet = pstmt.executeQuery();

            // O'qilgan ma'lumotlarni ko'rsatish
            while (resultSet.next()) {
                int id1 = resultSet.getInt(1);
                String spotType = resultSet.getString(2);
                System.out.println("ID: " + id1);
                System.out.println("spotType: " + spotType);
                return spotType;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
