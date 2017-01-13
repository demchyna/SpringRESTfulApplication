package com.softserve.academy.factories.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSimpleConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/springrestful";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "1111";

    private Connection connection = null;

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null || connection.isClosed() ) {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        }
        return connection;
    }
}
