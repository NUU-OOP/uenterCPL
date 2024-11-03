package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadRates {



    public String readRates() throws FileNotFoundException {
        File file = new File("C:\\Users\\USER\\Desktop\\CarParkingLot\\CarParkingLotFX\\src\\main\\resources\\rates.ini\\");
            Scanner scanner = new Scanner(file);
            String rates = scanner.nextLine();

            return rates;
    }

}
