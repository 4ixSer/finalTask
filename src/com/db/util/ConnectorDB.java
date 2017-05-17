package com.db.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * ����� ��� ����������� ���������� � ����� ������.
 *
 * @author qny4i
 *
 */
public class ConnectorDB {
    /**
     * ����� ��� ��������� ������������� � ����� ������. ��� ����������
     * ���������� DriverManager.getConnection( url, user, pass). url, user, pass
     * ����� � ����� database.properties.
     *
     * @return Connection
     * @throws SQLException
     *             ������ ����������.
     */
    public static Connection getConnections(String namePropertis) throws SQLException {
        // ������� ������ ����
        ResourceBundle resource = ResourceBundle.getBundle(namePropertis);
        // �������� �������� db.url
        String url = resource.getString("db.url");
        // �������� �������� db.user
        String user = resource.getString("db.user");
        // �������� �������� db.password
        String pass = resource.getString("db.password");
        return DriverManager.getConnection(url, user, pass);
    }
}