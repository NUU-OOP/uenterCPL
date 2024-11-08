package org.example;

public class CarInputValidator {

    public static boolean isValidCarNumber(String carNumber) {
        return carNumber != null && carNumber.matches("[a-zA-Z0-9]*");
    }

    public static String formatCarNumber(String carNumber) {
        return carNumber != null ? carNumber.toUpperCase() : "";
    }
}
