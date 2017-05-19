package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.WrapperConnector;
import com.entity.car.Car;
import com.entity.subject.Flight;
import com.entity.subject.Status;
import com.entity.users.User;

public class FlightDAO  {

    private static final String SQL_SELECT_All_FLIGHT = "SELECT * FROM flight";
    private static final String SQL_SELECT_FLIGHT_BY_ID = "SELECT * FROM flight where id=?";
    private static final String SQL_INSERT_FLIGHT = "INSERT INTO flight (date, status, driver, car, dispatcher, note) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_FLIGHT = "DELETE FROM flight WHERE id=?";
    private static final String SQL_UPDARE_FLIGHT= "UPDATE flight SET date=?, status=?, driver=?, car=?, dispatcher=?, note=? WHERE id=?";

    private WrapperConnector connector;

    public FlightDAO() {
        connector = WrapperConnector.getInstance();
    }

    public void close() {
        connector.closeConnection();
    }


    public List<Flight> findAll() {

        List<Flight> flights = new ArrayList<Flight>();

        Statement st = null;
        try {
            st = connector.getConnection(true).createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_All_FLIGHT);

            while (resultSet.next()) {
                Flight flight = createFlight(resultSet);
                flights.add(flight);
            }
        } catch (SQLException e) {
            // TODO Сюда систему логирования
            System.err.println("Error createStatement: " + e);
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                // TODO Сюда систему логированияs
                e.printStackTrace();
            }
        }

        return flights;
    }

    private Flight createFlight(ResultSet resultSet) throws SQLException {
        Flight flight = new Flight();

        flight.setNamberFlight(resultSet.getInt("id"));
        flight.setDate(Flight.fromValueData(resultSet.getString("date")));
        flight.setStatus(Status.fromValue(resultSet.getInt("status")));

        // получение драйвера по id
        User driver = new UserDAO().findEntityById(resultSet.getInt("driver"));
        flight.setDriver(driver);

        // получение диспечера по id
        User dispatcher = new UserDAO().findEntityById(resultSet.getInt("dispatcher"));
        flight.setDispatcher(dispatcher);

        // полученеи выбраной машыны
        Car car = new CarDAO().findEntityById(resultSet.getInt("car"));
        flight.setCar(car);

        flight.setNote(resultSet.getString("note"));
        return flight;
    }


    public Flight findEntityById(int id) {

        Flight flight = null;
        PreparedStatement ps = null;
        try {
            ps = connector.getConnection(true).prepareStatement(SQL_SELECT_FLIGHT_BY_ID);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                flight = createFlight(resultSet);

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
        return flight;

    }


    public boolean delete(int id) {
        // Пока не нежен мне
        throw new IllegalArgumentException();
    }


    public boolean delete(Flight entity) {

        PreparedStatement ps = null;

        try {
            ps = connector.getConnection(true).prepareStatement(SQL_DELETE_FLIGHT);
            ps.setInt(1, entity.getNamberFlight());
            ps.execute();

        } catch (SQLException e) {
            // TODО логирование
            System.err.println("SQL exception: " + e);
            return false;
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODО логирование
                e.printStackTrace();
            }
        }

        return true;
    }


    public boolean create(Flight entity) {

        PreparedStatement ps = null;

        try {

            ps = connector.getConnection(true).prepareStatement(SQL_INSERT_FLIGHT);
            ps.setString(1, entity.toStringDate());
            ps.setInt(2, entity.getStatus().value());
            ps.setInt(3, entity.getDriver().getId());
            ps.setInt(4, entity.getCar().getId());
            ps.setInt(5, entity.getDispatcher().getId());
            ps.setString(6, entity.getNote());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            // TODО логирование
            System.err.println("SQL exception: " + e);
            return false;
        }
        try {
            ps.close();
        } catch (SQLException e) {
            // TODО логирование
            e.printStackTrace();
        }
        return true;
    }


    public Flight update(Flight entity) {
        PreparedStatement ps = null;

        try {
            ps = connector.getConnection(true).prepareStatement(SQL_UPDARE_FLIGHT);
            ps.setString(1, entity.toStringDate());
            ps.setInt(2, entity.getStatus().value());
            ps.setDouble(3, entity.getDriver().getId());
            ps.setDouble(4, entity.getCar().getId());
            ps.setDouble(5, entity.getDispatcher().getId());
            ps.setString(6, entity.getNote());
            ps.setInt(7, entity.getNamberFlight());

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
}
