package org.example.dbconnnection;

import java.sql.*;

public class DBConnection {
    public static final String DB_URL = "jdbc:sqlite:hello.db";

    private Connection conn;

    // Constructor initializes the database connection
    public DBConnection() throws SQLException {
        this.conn = DriverManager.getConnection(DB_URL);
        System.out.println("Connected to the database.");
    }

    // Reusable connection method (if needed elsewhere)
    public Connection getConnection() {
        return this.conn;
    }

    // Method to execute any SQL command that doesn't return results (CREATE, INSERT, UPDATE, DELETE)
    public void executeCommand(String sqlCommand) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCommand);
            System.out.println("SQL command executed successfully.");
        } catch (SQLException e) {
            System.err.println("Error executing SQL command: " + e.getMessage());
            throw e;
        }
    }

    // Method to execute and print results of SELECT queries
    public ResultSet executeQuery(String sqlCommand) throws SQLException {
        try  {
            PreparedStatement pstmt = conn.prepareStatement(sqlCommand);
            ResultSet rs = pstmt.executeQuery();

            return rs;
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            throw e;
        }

    }

    // Close the database connection when done
    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }


}
