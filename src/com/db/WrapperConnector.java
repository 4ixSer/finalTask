package com.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.db.util.ConnectorDB;

/**
 * Класс врапер для будушего пула соединений.
 * @author qny4ix
 *
 */

public class WrapperConnector {

    private static WrapperConnector instance;
    private Connection connection;

    private WrapperConnector() {
    }

    /**
     * Реализация синглтона. Дял получения обьекта WrapperCinnector
     *
     * @return
     */
    public static synchronized WrapperConnector getInstance() {
        if (instance == null) {
            instance = new WrapperConnector();
            instance.getConnection(true);
        }
        return instance;
    }

    /**
     * Метод для получения Connection.
     *
     * @param autoCommit парамерт авто комита
     * @return
     */
    public Connection getConnection(boolean autoCommit) {
        try {
            connection = ConnectorDB.getConnections("database");
            connection.setAutoCommit(autoCommit);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage() + "SQLState: " + e.getSQLState());
        }
        return connection;
    }

    /**
     * Метод для закрытия конекшена с базой данных ХЗ пока куда её припихнуть
     */
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