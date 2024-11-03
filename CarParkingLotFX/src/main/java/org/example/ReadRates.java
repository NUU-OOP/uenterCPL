package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadRates {



    public String readRates() throws FileNotFoundException {
        File file = new File(getClass().getResource("/rates.ini").getPath());
            Scanner scanner = new Scanner(file);
            String rates = scanner.nextLine();

            return rates;
    }

}
