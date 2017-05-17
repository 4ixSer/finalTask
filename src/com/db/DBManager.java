package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.util.ConnectorDB;
import com.entity.car.Car;
import com.entity.users.Admin;
import com.entity.users.Dispatcher;
import com.entity.users.Driver;
import com.entity.users.User;


public class DBManager {

    private static final Integer ADMIN = 1;
    private static final Integer DISPATCHER = 2;
    private static final Integer DRIVER = 3;
    private static final String SQL_SELECT_All_USER = "SELECT * FROM user";
    private static final String SQL_SELECT_USER_BY_LOGIN = "SELECT * FROM user WHERE login=?";
    private static final String SQL_INSERT_USER = "INSERT INTO user (login, password, name, email, role) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_USER = "DELETE FROM user WHERE id=?";
    private static final String SQL_INSERT_CAR = "INSERT INTO car (namber, type, carryingCar, amountCar, enginePower, defective, comments) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_CAR = "DELETE FROM car WHERE id=?";

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

    /**
     * Метод для получения всех узеров .
     *
     * @return
     */
    public List<User> findAll() {
        List<User> users = new ArrayList<User>();

        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_All_USER);

            while (resultSet.next()) {
                // TODO вытягивать правильных людей

                User user = null;
                Integer role = resultSet.getInt("role");
                if (role == ADMIN)
                    user = new Admin();
                else if (role == DISPATCHER)
                    user = new Dispatcher();
                else
                    user = new Driver();

                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setName(resultSet.getString("name"));
                users.add(user);

            }

        } catch (SQLException e) {
            System.err.println("Error createStatement: " + e);
        }

        return users;
    }

    /**
     * Метод вызывает с базы данных нужного человека по его логину.
     *
     * @param login
     * @return
     */
    // TODO это передалать бред пока он только для тестировки
    public User findEntityByLogin(String login) {

        User user = null;

        PreparedStatement ps = null;
        try {

            ps = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN);
            ps.setString(1, login);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            Integer role = resultSet.getInt("role");
            if (role == ADMIN)
                user = new Admin();
            else if (role == DISPATCHER)
                user = new Dispatcher();
            else
                user = new Driver();

            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setName(resultSet.getString("name"));

        } catch (SQLException e) {
            System.err.println("Error createStatement: " + e);
        }
        return user;

    }

    /**
     * Метод создания юзера
     * @param entity
     * @return
     */
    //TODO реализовать правильный выбор ролей
    public boolean create(User entity) {

        PreparedStatement ps = null;

        try {

            ps = connection.prepareStatement(SQL_INSERT_USER);
            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getName());
            ps.setString(4, entity.getEmail());
            //TODO тут заплатка удалить
            ps.setInt(5, 2);
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Метод для удаления юзера
     * @param user
     * @return
     */
    public boolean deleteUser(User user){

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_DELETE_USER);
            ps.setInt(1, user.getId());
            ps.execute();

        } catch (SQLException e) {
            System.err.println("SQL exception: " + e);
            return false;
        }

        return true;
    }

    /**
     * Добавление машины.
     * @param car
     * @return
     */
    public boolean createCar(Car car) {

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_INSERT_CAR);
            ps.setString(1, car.getNamber());
            ps.setInt(2, car.getType().value());
            ps.setDouble(3, car.getCarryingCar());
            ps.setDouble(4, car.getAmountCar());
            ps.setDouble(5, car.getEnginePower());
            ps.setBoolean(6, car.isDefective());
            ps.setString(7, car.getComments());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteCar(Car car) {

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_DELETE_CAR);
            ps.setInt(1, car.getId());
            ps.execute();

        } catch (SQLException e) {
            System.err.println("SQL exception: " + e);
            return false;
        }

        return true;
    }

    public Car updateCar(Car car) {
        PreparedStatement ps = null;

        try {
            //TODO доделать изминение  автомабиля
            ps =connection.prepareStatement(SQL_DELETE_CAR);
        } catch (SQLException e) {
            System.err.println("SQL exception: " + e);
            return car;
        }
        return car;
    }



}
