package com.db.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *  ласс дл€ установени€ соединени€ с базой данных.
 *
 * @author qny4i
 *
 */
public class ConnectorDB {
    /**
     * ћетод дл€ получени€ соеденинени€с с базой данной. ƒл€ соеденени€
     * использует DriverManager.getConnection( url, user, pass). url, user, pass
     * лежат в файле database.properties.
     *
     * @return Connection
     * @throws SQLException
     *             ошибка соединени€.
     */
    public static Connection getConnections(String namePropertis) throws SQLException {
        // создать ресурс банг
        ResourceBundle resource = ResourceBundle.getBundle(namePropertis);
        // получить значение db.url
        String url = resource.getString("db.url");
        // получить значение db.user
        String user = resource.getString("db.user");
        // получить значение db.password
        String pass = resource.getString("db.password");
        return DriverManager.getConnection(url, user, pass);
    }
}