package org.example.dbconnnection;

import java.sql.*;

public class DBConnection {
    public static final String DB_URL = "jdbc:sqlite:hello.db";

    public DBConnection() throws SQLException {
    }

    public static Connection connectDB(){
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                System.out.println("Connected to the database.");
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void createTable(Connection conn, String sqlCommand) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCommand);
            System.out.println("Table created.");
        } }
    public static void insertData(String sqlCommand) throws SQLException {

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                System.out.println("Connected to the database.");
                try (PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void readData(Connection conn, String sqlCommand) throws SQLException {

        try (PreparedStatement pstmt = conn.prepareStatement(sqlCommand);
             ResultSet rs = pstmt.executeQuery()) {
            ResultSetMetaData metaData = rs.getMetaData();
            int col = metaData.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i)+" ");
                }
            }
        }
    }
    public static void updateData(Connection conn, String sqlCommand) throws SQLException {

        try (PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {
            pstmt.executeUpdate();
            System.out.println("Updated!");
        } }
    public static void deleteData(Connection conn, String sqlCommand) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {
            pstmt.executeUpdate();
            System.out.println("Data deleted successfully !");
        } }
}
