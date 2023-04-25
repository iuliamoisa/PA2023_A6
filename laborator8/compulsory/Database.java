package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Singleton class
public class Database {
    private static final String URL =
            "jdbc:mysql://127.0.0.1:3306/albums";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;
    private Database() {}
    public static Connection getConnection() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Connected");
            try {
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }
    private static void createConnection() {

    }
    public static void closeConnection() {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void deleteAll(String tableName) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement()) {
            String query = "DELETE FROM " + tableName;
            ((Statement) stmt).executeUpdate(query);
            con.commit();
        }
    }
}
