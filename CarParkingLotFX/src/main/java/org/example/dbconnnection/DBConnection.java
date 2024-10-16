package org.example.dbconnnection;

import java.sql.*;

public class DBConnection {
    private static final String DB_URL = "jdbc:sqlite:university.db";
    private void connectDB(){
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                System.out.println("Connected to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void createTable(Connection conn, String sqlCommand) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCommand);
            System.out.println("Table created.");
        } }
    private static void insertData(Connection conn, String sqlCommand) throws SQLException
    {
        try (PreparedStatement pstmt = conn.prepareStatement(sqlCommand))
        {
            pstmt.executeUpdate();
        }
    }
    private static void readData(Connection conn, String sqlCommand) throws SQLException {

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
    private static void updateData(Connection conn, String sqlCommand) throws SQLException {

        try (PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {
            pstmt.executeUpdate();
            System.out.println("Updated!");
        } }
    private static void deleteData(Connection conn, String sqlCommand) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {
            pstmt.executeUpdate();
            System.out.println("Data deleted successfully !");
        } }
}
