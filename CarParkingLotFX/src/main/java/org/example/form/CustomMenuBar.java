package org.example.form;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import org.example.EntranceForm;

public class CustomMenuBar {
    private Stage stage;
    public CustomMenuBar(Stage stage){
        this.stage = stage;
    }


    public MenuBar createMenuBar() {
        // Create the MenuBar
        MenuBar menuBar = new MenuBar();

        // First Menu: Car Management
        Menu carMenu = new Menu("Car Management");
        MenuItem enterNewCar = new MenuItem("Enter New Car");
        MenuItem exitCar = new MenuItem("Exit Car");

        // Add actions for Car Management items
        enterNewCar.setOnAction(
                event -> {
                    EntranceForm entranceForm = new EntranceForm(this.stage);

                }
        );
        exitCar.setOnAction(e -> System.out.println("Exit Car selected"));

        carMenu.getItems().addAll(enterNewCar, exitCar);

        // Second Menu: Spot Management
        Menu spotMenu = new Menu("Spot Management");
        MenuItem changeRate = new MenuItem("Change Rate");
        MenuItem addSpot = new MenuItem("Add Spot");
        MenuItem changeSpotType = new MenuItem("Change Spot Type");
        Menu selectFloor = new Menu("Select Floor");
        MenuItem firstFloor = new MenuItem("First Floor");
        MenuItem secondFloor = new MenuItem("Second Floor");
        selectFloor.getItems().addAll(firstFloor, secondFloor);
        // Add actions for Spot Management items
        changeRate.setOnAction(
                event -> {
                    ParkingRateConfigurator parkingRateConfigurator = new ParkingRateConfigurator();
                    parkingRateConfigurator.start(new Stage());

                }
        );
        addSpot.setOnAction(e -> System.out.println("Add Spot selected"));
        changeSpotType.setOnAction(e -> System.out.println("Change Spot Type selected"));

        spotMenu.getItems().addAll(changeRate, addSpot, changeSpotType);

        // Third Menu: Personnel Management
        Menu personnelMenu = new Menu("Personnel Management");
        MenuItem addMember = new MenuItem("Add Member");
        MenuItem addAttendant = new MenuItem("Add Attendant");

        // Add actions for Personnel Management items
        addMember.setOnAction(e -> System.out.println("Add Member selected"));
        addAttendant.setOnAction(e -> System.out.println("Add Attendant selected"));

        personnelMenu.getItems().addAll(addMember, addAttendant);

        // Add all menus to the MenuBar
        menuBar.getMenus().addAll(carMenu, spotMenu, personnelMenu, selectFloor);

        return menuBar;
    }
}
