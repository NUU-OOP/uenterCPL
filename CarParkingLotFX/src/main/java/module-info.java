module CarParkingLotFX {
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens org.example.form;
    opens org.example.spots;
    opens org.example;
    opens org.example.rate;

}