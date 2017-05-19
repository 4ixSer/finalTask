package com.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.db.util.ConnectorDB;

/**
 * ����� ������ ��� �������� ���� ����������.
 * @author qny4ix
 *
 */

public class WrapperConnector {

    private static WrapperConnector instance;
    private Connection connection;

    private WrapperConnector() {
    }

    /**
     * ���������� ���������. ��� ��������� ������� WrapperCinnector
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
     * ����� ��� ��������� Connection.
     *
     * @param autoCommit �������� ���� ������
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
     * ����� ��� �������� ��������� � ����� ������ �� ���� ���� � ����������
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