package org.example;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class TicketServiceImpl implements TicketService {

    private final DBConnection dbcon;

    public TicketServiceImpl(DBConnection dbcon) {
        this.dbcon = dbcon;
    }

    @Override
    public void createTicket(int spotID, String carNumber, String carType, LocalDateTime enterTime, LocalDateTime exitTime, double extraFee) throws SQLException {
        String query = String.format(
            "INSERT INTO Ticket (SpotID, CarNumber, CarType, EnterTime, ExitTime, ExtraFee) " +
            "VALUES (%d, '%s', '%s', '%s', %s, %.2f);",
            spotID, carNumber, carType, enterTime.toString(), 
            exitTime != null ? "'" + exitTime.toString() + "'" : "NULL", 
            extraFee
        );
        dbcon.executeCommand(query);
    }
}
