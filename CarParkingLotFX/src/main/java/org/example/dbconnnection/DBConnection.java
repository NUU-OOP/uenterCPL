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
    private static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS students ("
                + "id INTEGER PRIMARY KEY, "
                + "name TEXT NOT NULL, "
                + "age INTEGER);";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created.");
        } }
    private static void insertData(Connection conn, int id, String name, int
            age)
            throws SQLException {
        String sql = "INSERT INTO students(id, name, age) VALUES(?, ?, ?);";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.executeUpdate();
        } }
    private static void readData(Connection conn) throws SQLException {
        String sql = "SELECT id, name, age FROM students";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            System.out.println("ID | Name | Age");
            System.out.println("----------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.printf("%d | %-5s | %d%n", id, name, age);
            } }
    }
    private static void updateData(Connection conn) throws SQLException {
        String sql = "UPDATE students SET age = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 23); // New age for Alice
            pstmt.setInt(2, 1); // Update record with id = 1
            pstmt.executeUpdate();
            System.out.println("Updated age");
        } }
    private static void deleteData(Connection conn) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 2); // Delete record where id = 2
            pstmt.executeUpdate();
            System.out.println("Deleted student with id = 2.");
        } }
}
