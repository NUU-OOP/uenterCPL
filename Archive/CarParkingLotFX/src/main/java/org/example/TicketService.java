package org.example;

import java.sql.SQLException;
import java.time.LocalDateTime;

public interface TicketService {
    void createTicket(int spotID, String carNumber, String carType, LocalDateTime enterTime, LocalDateTime exitTime, double extraFee) throws SQLException;
}
