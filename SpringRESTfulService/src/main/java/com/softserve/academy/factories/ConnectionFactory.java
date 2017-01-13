package com.softserve.academy.factories;

import com.softserve.academy.factories.dbconnection.ConnectionType;
import com.softserve.academy.factories.dbconnection.DBConnectionPool;
import com.softserve.academy.factories.dbconnection.DBSimpleConnection;

import java.sql.Connection;

public class ConnectionFactory {

    public static Connection getDBConnection(ConnectionType connectionType) {
        Connection connection = null;

        switch (connectionType) {
            case SIMPLE_CONNECTION : {
                DBSimpleConnection dbSimpleConnection = new DBSimpleConnection();
                try {
                    connection = dbSimpleConnection.getConnection();
                } catch (Exception e) {
                    throw new RuntimeException("The connection wasn't created: " + e.getMessage());
                }
                break;
            }
            case  CONNECTION_POOL : {
                DBConnectionPool dbConnectionPool = new DBConnectionPool();
                try {
                    connection = dbConnectionPool.getConnection();
                } catch (Exception e) {
                    throw new RuntimeException("The connection wasn't created: " + e.getMessage());
                }
                break;
            }
        }
        return connection;
    }
}