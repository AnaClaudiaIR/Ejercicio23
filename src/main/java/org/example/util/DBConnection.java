package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "ANA";
    private static final String PASSWORD = "ana";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

