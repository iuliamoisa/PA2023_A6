package org.example.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {
    private static ComboPooledDataSource cpds;
    static {
        cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/albums");
        cpds.setUser("root");
        cpds.setPassword("root");
    }

    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }

}