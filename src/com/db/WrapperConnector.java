package com.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.MissingResourceException;

import com.db.util.ConnectorDB;
/**
 * Класс врапер для будушего пула соединений.
 * @author qny4ix
 *
 */

public class WrapperConnector {
    private Connection connection;

    public WrapperConnector() {
        try {
            connection = ConnectorDB.getConnections("database");
            //TODO релизовать тут пул конекторов
        } catch (MissingResourceException e) {
            System.err.println("properties file is missing " + e);
        } catch (SQLException e) {
            System.err.println("not obtained connection " + e);
        }
    }

    public Statement getStatement() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            if (statement != null) {
                return statement;
            }
        }
        throw new SQLException("connection or statement is null");
    }

    public void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println("statement is null " + e);
            }
        }
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
    // другие необходимые делегированные методы интерфейса Connection
}