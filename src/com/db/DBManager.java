package com.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.db.util.ConnectorDB;

public class DBManager {
    private static DBManager instance;
    private Connection connection;

    private DBManager() {
    }

    /**
     * Реализация синглтона.
     *
     * @return
     */
    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
            instance.getConnection(true);
        }
        return instance;
    }

    private Connection getConnection(boolean autoCommit) {
        try {
            connection = ConnectorDB.getConnections("database");
            connection.setAutoCommit(autoCommit);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage() + "SQLState: " + e.getSQLState());
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(" wrong connection" + e);
            }
        }
    }
}
