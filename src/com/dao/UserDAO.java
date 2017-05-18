package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.WrapperConnector;
import com.entity.users.Admin;
import com.entity.users.Dispatcher;
import com.entity.users.Driver;
import com.entity.users.User;

public class UserDAO extends AbstractDAO<User> {
    private static final Integer ADMIN = 1;
    private static final Integer DISPATCHER = 2;
    private static final Integer DRIVER = 3;
    private static final String SQL_SELECT_All_USER = "SELECT * FROM user";
    private static final String SQL_SELECT_USER_BY_id = "SELECT * FROM user WHERE id=?";
    private static final String SQL_SELECT_USER_BY_LOGIN = "SELECT * FROM user WHERE login=?";
    private static final String SQL_INSERT_USER = "INSERT INTO user (login, password, name, email, role) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_USER = "DELETE FROM user WHERE id=?";
    private static final String SQL_UPDETE_USER ="UPDATE user SET login=?, password=?, name=?, email=?, role=? WHERE id=?";


    private WrapperConnector connector;

    public UserDAO() {
        connector = WrapperConnector.getInstance();
    }

    public void close() {
        connector.closeConnection();
    }

    /**
     * Метод для получения списка всех пользователй.
     */
    @Override
    public List<User> findAll() {

        List<User> users = new ArrayList<User>();
        Statement st = null;

        try {
            st = connector.getConnection(true).createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_All_USER);

            while (resultSet.next()) {

                User user = createUser(resultSet);
                users.add(user);

            }

        } catch (SQLException e) {
            System.err.println("Error createStatement: " + e);
            // TODO Сюда систему логирования
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                // TODO Сюда систему логирования
                e.printStackTrace();
            }
        }
        return users;
    }

    /**
     * Метод создает сушьность юзер из параметров которые приходят в resultSetе.
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    // TODO Подумать как правильно вытягивать людей по ролям.
    private User createUser(ResultSet resultSet) throws SQLException {

        User user = null;
        Integer role = resultSet.getInt("role");
        if (role == ADMIN)
            user = new Admin();
        else if (role == DISPATCHER)
            user = new Dispatcher();
        else if (role == DRIVER)
            user = new Driver();

        user.setId(resultSet.getInt("id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setName(resultSet.getString("name"));

        return user;
    }

    /**
     * Метод для получения юзера по его ID
     */
    @Override
    public User findEntityById(int id) {

        User user = null;
        PreparedStatement ps = null;

        try {

            ps = connector.getConnection(true).prepareStatement(SQL_SELECT_USER_BY_id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                user = createUser(resultSet);
            }
        } catch (SQLException e) {
            System.err.println("Error createStatement: " + e);
            // TODO Сюда систему логирования
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Сюда систему логированияs
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public boolean delete(int id) {
        // Данный метод мне пока не нужен.
        throw new IllegalArgumentException();
    }

    /**
     * Метод удаляет юзера с базы данных.
     */
    @Override
    public boolean delete(User entity) {

        PreparedStatement ps = null;
        try {
            ps = connector.getConnection(true).prepareStatement(SQL_DELETE_USER);
            ps.setInt(1, entity.getId());
            ps.execute();

        } catch (SQLException e) {
            // TODO Сюда систему логирования
            System.err.println("SQL exception: " + e);
            return false;
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Сюда систему логирования
                e.printStackTrace();
            }
        }

        return true;
    }

    /**
     * Метод создает сушьность User в базе данных.
     */
    @Override
    public boolean create(User entity) {

        PreparedStatement ps = null;

        try {
            ps = connector.getConnection(true).prepareStatement(SQL_INSERT_USER);
            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getName());
            ps.setString(4, entity.getEmail());
            // TODO тут заплатка удалить
            ps.setInt(5, 2);
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            // TODO Сюда систему логирования
            return false;
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Сюда систему логирования
                e.printStackTrace();
            }
        }
        return true;
    }
    //"UPDATE user SET login=?, password=?, name=?, email=?, role=? WHERE id=?"
    @Override
    public User update(User entity) {
        PreparedStatement ps = null;

        try {
            ps = connector.getConnection(true).prepareStatement(SQL_UPDETE_USER);
            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getName());
            ps.setString(4, entity.getEmail());
            // TODO тут заплатка удалить
            ps.setInt(5, 3);
            ps.setInt(6, entity.getId());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            // TODO Сюда систему логирования
            return null;
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Сюда систему логирования
                e.printStackTrace();
            }
        }
        return entity;
    }

    /**
     * Метод вызывает с базы данных нужного человека по его логину.
     *
     * @param login
     * @return
     */
    public User findEntityByLogin(String login) {

        User user = null;
        PreparedStatement ps = null;

        try {
            ps = connector.getConnection(true).prepareStatement(SQL_SELECT_USER_BY_LOGIN);
            ps.setString(1, login);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                user = createUser(resultSet);
            }
        } catch (SQLException e) {
            System.err.println("Error createStatement: " + e);
            // TODO Сюда систему логирования
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Сюда систему логирования
                e.printStackTrace();
            }

        }
        return user;

    }

}
