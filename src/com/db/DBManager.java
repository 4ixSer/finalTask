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
import com.entity.car.TYPE;
import com.entity.subject.Flight;
import com.entity.subject.Request;
import com.entity.subject.Status;
import com.entity.users.Admin;
import com.entity.users.Dispatcher;
import com.entity.users.Driver;
import com.entity.users.User;

public class DBManager {

    private static final Integer ADMIN = 1;
    private static final Integer DISPATCHER = 2;
    private static final Integer DRIVER = 3;
    private static final String SQL_SELECT_All_USER = "SELECT * FROM user";
    private static final String SQL_SELECT_USER_BY_id = "SELECT * FROM user WHERE id=?";
    private static final String SQL_SELECT_USER_BY_LOGIN = "SELECT * FROM user WHERE login=?";
    private static final String SQL_INSERT_USER = "INSERT INTO user (login, password, name, email, role) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_USER = "DELETE FROM user WHERE id=?";
    private static final String SQL_INSERT_CAR = "INSERT INTO car (namber, type, carryingCar, amountCar, enginePower, defective, comments) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_CAR = "DELETE FROM car WHERE id=?";
    private static final String SQL_INSERT_REQUEST = "INSERT INTO request (ownerRequest, dataRequest, dataDeparture, car_type, carrying_car, amount_car, enginePower, status, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_All_REQUEST = "SELECT * FROM request";
    private static final String SQL_SELECT_REQUEST_BY_ID = "SELECT * FROM request where id=?";

    private static final String SQL_DELETE_REQUEST = "DELETE FROM car WHERE id=?";

    private static final String SQL_SELECT_All_FLIGHT = "SELECT * FROM flight";
    private static final String SQL_SELECT_FLIGHT_BY_ID = "SELECT * FROM flight where id=?";


    private static final String SQL_INSERT_FLIGHT = "INSERT INTO flight (date, status, driver, car, dispatcher, note) VALUES (?, ?, ?, ?, ?, ?)";


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

    /**
     * Метод для получения конекшена
     *
     * @param autoCommit
     * @return
     */
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

    // TODO Создать метод для создания Обьекта USER
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
            while (resultSet.next()) {
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
            }
        } catch (SQLException e) {
            System.err.println("Error createStatement: " + e);
        }
        return user;

    }

    /**
     * Метод вызывает с базы данных нужного человека по его ID.
     *
     * @param login
     * @return
     */
    // TODO это передалать бред пока он только для тестировки
    public User findEntityById(Integer id) {

        User user = null;

        PreparedStatement ps = null;
        try {

            ps = connection.prepareStatement(SQL_SELECT_USER_BY_id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
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
            }
        } catch (SQLException e) {
            System.err.println("Error createStatement: " + e);
        }
        return user;

    }

    /**
     * Метод создания юзера
     *
     * @param entity
     * @return
     */
    // TODO реализовать правильный выбор ролей
    public boolean create(User entity) {

        PreparedStatement ps = null;

        try {

            ps = connection.prepareStatement(SQL_INSERT_USER);
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
            return false;
        }
        return true;
    }

    /**
     * Метод изминения юзера
     *
     */


    /**
     * Метод для удаления юзера
     *
     * @param user
     * @return
     */
    public boolean deleteUser(User user) {

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
     * Добавление машины в базу.
     *
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

    /**
     * Метод для удаления машыны
     *
     * @param car
     * @return
     */
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

    /**
     * Метод для изминений характеристик Car
     *
     * @param car
     * @return
     */
    public Car updateCar(Car car) {
        PreparedStatement ps = null;

        try {

            ps = connection.prepareStatement(SQL_DELETE_CAR);
        } catch (SQLException e) {
            System.err.println("SQL exception: " + e);
            return car;
        }
        return car;
    }

    /**
     * Метод для создания заявк
     */
    public boolean createRequest(Request request) {

        PreparedStatement ps = null;
        try {

            ps = connection.prepareStatement(SQL_INSERT_REQUEST);

            ps.setInt(1, request.getOwnerRequest().getId());

            ps.setString(2, request.toStringDataDeparture());
            ps.setString(3, request.toStringDataRequest());

            // тут мы вытягиевам предпологаемые данные для машины
            ps.setInt(4, request.getCharacteristicsСak().getType().value());
            ps.setDouble(5, request.getCharacteristicsСak().getCarryingCar());
            ps.setDouble(6, request.getCharacteristicsСak().getAmountCar());
            ps.setDouble(7, request.getCharacteristicsСak().getEnginePower());

            ps.setInt(8, request.getStatus().value());
            ps.setString(9, request.getNote());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.err.println("SQL exception: " + e);
            return false;
        }
        return true;
    }

    /**
     * Метод для всех заявок получения заявок
     */
    public List<Request> findAllRequest() {

        List<Request> requests = new ArrayList<Request>();

        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_All_REQUEST);

            while (resultSet.next()) {
                Request request = new Request();
                request.setNamberRequest(resultSet.getInt("id"));
                request.setStatus(Status.fromValue(resultSet.getInt("status")));
                request.setNote(resultSet.getString("note"));

                // Временная машина взятая с заявки
                Car characteristicsCar = new Car();
                characteristicsCar.setType(TYPE.fromValue(resultSet.getInt("car_type")));
                characteristicsCar.setCarryingCar(resultSet.getDouble("carrying_car"));
                characteristicsCar.setAmountCar(resultSet.getDouble("amount_car"));
                characteristicsCar.setEnginePower(resultSet.getDouble("enginePower"));
                request.setCharacteristicsСar(characteristicsCar);

                // TODO реализовать метод получения юзера по его id

                // Преобразлование и запись времени в запрос
                request.setDataRequest(Request.fromValueDataRequest(resultSet.getString("dataRequest")));
                request.setDataDeparture(Request.fromValueDataDeparture(resultSet.getString("dataDeparture")));

                requests.add(request);

            }

        } catch (SQLException e) {
            System.err.println("Error createStatement: " + e);
        }

        return requests;
    }

    /**
     * Метод для поиска заявок по ID
     *
     * @param id
     * @return
     */
    public Request findRequestByd(Integer id) {

        Request request = null;
        PreparedStatement ps = null;
        try {

            ps = connection.prepareStatement(SQL_SELECT_REQUEST_BY_ID);
            ps.setInt(1, id);
            // TODO написать оттделный метод для получения Request
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                request = new Request();
                request.setNamberRequest(resultSet.getInt("id"));
                request.setStatus(Status.fromValue(resultSet.getInt("status")));
                request.setNote(resultSet.getString("note"));

                // Временная машина взятая с заявки
                Car characteristicsCar = new Car();
                characteristicsCar.setType(TYPE.fromValue(resultSet.getInt("car_type")));
                characteristicsCar.setCarryingCar(resultSet.getDouble("carrying_car"));
                characteristicsCar.setAmountCar(resultSet.getDouble("amount_car"));
                characteristicsCar.setEnginePower(resultSet.getDouble("enginePower"));

                request.setCharacteristicsСar(characteristicsCar);

                // TODO реализовать метод получения юзера по его id

                // TODO реализовать правильное преобразование
                request.setDataRequest(Request.fromValueDataRequest(resultSet.getString("dataRequest")));
                request.setDataDeparture(Request.fromValueDataDeparture(resultSet.getString("dataDeparture")));
            }
        } catch (SQLException e) {
            System.err.println("Error createStatement: " + e);
        }
        return request;

    }

    // TODO Менять в запросе статус
    public Request updateRequest(Request request) {
        PreparedStatement ps = null;

        try {
            // TODO доделать изминение автомабиля
            ps = connection.prepareStatement(SQL_DELETE_CAR);
        } catch (SQLException e) {
            System.err.println("SQL exception: " + e);
            return request;
        }
        return request;
    }

    // TODO delete(Request entity) ;
    public boolean delete(Request entity) {
        throw new IllegalArgumentException();
    }

    // TODO подумать как реалезовать сортировку элементов по времени, номеру
    // рейса и статусу
    public List<Flight> findAllFlight() {

        List<Flight> flights = new ArrayList<Flight>();

        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_All_FLIGHT);

            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setNamberFlight(resultSet.getInt("id"));
                flight.setDate(Flight.fromValueData(resultSet.getString("data")));
                flight.setStatus(Status.fromValue(resultSet.getInt("status")));

                // TODO реализовать метод получения диспечера по его id

                // TODO реализовать метод получения водителя по его id
                Car car = new Car();

                // TODO реализовать метод получения машины из базы данных по id
                // получили машыну
                flight.setCar(car);

                flight.setNote(resultSet.getString("node"));

                flights.add(flight);

            }

        } catch (SQLException e) {
            System.err.println("Error createStatement: " + e);
        }

        return flights;
    }

    /**
     * Метод возврашения рейса по его ID
     *
     * @param id
     * @return
     */
    public Flight findCarById(int id) {

        Flight flight = null;
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_FLIGHT_BY_ID);

            while (resultSet.next()) {
                flight = new Flight();
                // TODO написать отделный метод который создает РЕЙС
                flight.setNamberFlight(resultSet.getInt("id"));
                flight.setDate(Flight.fromValueData(resultSet.getString("data")));
                flight.setStatus(Status.fromValue(resultSet.getInt("status")));

                // TODO реализовать метод получения диспечера по его id

                // TODO реализовать метод получения водителя по его id
                Car car = new Car();

                // TODO реализовать метод получения машины из базы данных по id
                // получили машыну
                flight.setCar(car);

                flight.setNote(resultSet.getString("node"));

            }

        } catch (SQLException e) {
            System.err.println("Error createStatement: " + e);
            return null;
        }

        return flight;
    }

    // TODO delete(Flight entity);
    public boolean delete(Flight entity) {
        throw new IllegalArgumentException();
    }

    //INSERT INTO flight (date, status, driver, car, dispatcher, note) VALUES (2017-05-18 10:53:15, 1, 2, 1, 1, Дебил за рулем);
    public boolean create(Flight entity) {

        PreparedStatement ps = null;
        try {

            ps = connection.prepareStatement(SQL_INSERT_FLIGHT);

            ps.setString(1, entity.toStringDate());
            ps.setInt(2, entity.getStatus().value());
            ps.setInt(3, entity.getDriver().getId());
            ps.setInt(4, entity.getCar().getId());
            ps.setInt(5, entity.getDispatcher().getId());
            ps.setString(6, entity.getNote());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.err.println("SQL exception: " + e);
            return false;
        }
        return true;

    }


    /**
     * Метод для изминений характеристик Car
     *
     * @param car
     * @return
     */
    public Flight updateCar(Flight entity) {
        PreparedStatement ps = null;

        try {
            // TODO доделать изминение автомабиля
            ps = connection.prepareStatement(SQL_DELETE_CAR);
        } catch (SQLException e) {
            System.err.println("SQL exception: " + e);
            return entity;
        }
        return entity;
    }


}
