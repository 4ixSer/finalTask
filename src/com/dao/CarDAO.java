package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.WrapperConnector;
import com.entity.car.Car;
import com.entity.car.TYPE;

public class CarDAO extends AbstractDAO<Car> {
    private static final String SQL_SELECT_ALL_CAR = "SELECT * FROM car";
    private static final String SQL_INSERT_CAR = "INSERT INTO car (namber, type, carryingCar, amountCar, enginePower, defective, comments) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_CAR = "DELETE FROM car WHERE id=?";
    private static final String SQL_SELECT_CAR_BY_ID = "SELECT * FROM car WHERE id=?";
    private static final String SQL_SELECT_CAR_BY_NAMBER = "SELECT * FROM car WHERE namber=?";
    private static final String SQL_UPDETE_CAR ="UPDATE car SET namber=?, type=?, carryingCar=?, amountCar=?, enginePower=?, defective=?, comments=? WHERE id=?";

    private WrapperConnector connector;

    public CarDAO() {
        connector = WrapperConnector.getInstance();
    }

    public void close() {
        connector.closeConnection();
    }

    @Override
    public List<Car> findAll() {

        List<Car> cars = new ArrayList<Car>();
        Statement statement = null;

        try {
            statement = connector.getConnection(true).createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_CAR);
            while(resultSet.next()) {
                Car car =createCar(resultSet);
                cars.add(car);
            }
        } catch (SQLException e) {
         // TODО логирование
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                // TODО логирование
                e.printStackTrace();
            }
        }
        return cars;
    }

    @Override
    public Car findEntityById(int id) {

        Car car = null;
        PreparedStatement ps = null;

        try {

            ps = connector.getConnection(true).prepareStatement(SQL_SELECT_CAR_BY_ID);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                car = createCar(resultSet);
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
        return car;
    }

    @Override
    public boolean delete(int id) {
     // Данный метод мне пока не нужен.
        throw new IllegalArgumentException();
    }

    /**
     * Метод для удаления машины с БД.
     */
    @Override
    public boolean delete(Car entity) {
        PreparedStatement ps = null;
        try {
            ps = connector.getConnection(true).prepareStatement(SQL_DELETE_CAR);
            ps.setInt(1, entity.getId());
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

    /**
     * Метод создает машину.
     */
    @Override
    public boolean create(Car entity) {

        PreparedStatement ps = null;

        try {
            ps = connector.getConnection(true).prepareStatement(SQL_INSERT_CAR);

            ps.setString(1, entity.getNamber());
            ps.setInt(2, entity.getType().value());
            ps.setDouble(3, entity.getCarryingCar());
            ps.setDouble(4, entity.getAmountCar());
            ps.setDouble(5, entity.getEnginePower());
            ps.setBoolean(6, entity.isDefective());
            ps.setString(7, entity.getComments());
            ps.execute();

        } catch (SQLException e) {
            // TODО логирование
            e.printStackTrace();
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

    private Car createCar(ResultSet resultSet) throws SQLException {
        Car car = new Car();

        car.setId(resultSet.getInt("id"));
        car.setNamber(resultSet.getString("namber"));
        car.setType(TYPE.fromValue(resultSet.getInt("type")));
        car.setCarryingCar(resultSet.getDouble("carryingCar"));
        car.setAmountCar(resultSet.getDouble("amountCar"));
        car.setEnginePower(resultSet.getDouble("enginePower"));
        car.setDefective(resultSet.getBoolean("defective"));
        car.setComments(resultSet.getString("comments"));

        return car;
    }

    @Override
    public Car update(Car entity) {
        PreparedStatement ps = null;

        try {
            ps = connector.getConnection(true).prepareStatement(SQL_UPDETE_CAR);
            ps.setString(1, entity.getNamber());
            ps.setInt(2, entity.getType().value());
            ps.setDouble(3, entity.getCarryingCar());
            ps.setDouble(4, entity.getAmountCar());
            ps.setDouble(5, entity.getEnginePower());
            ps.setString(6, String.valueOf(entity.isDefective()));
            ps.setString(7, entity.getComments());

            ps.setInt(8, entity.getId());
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

    public Car findEntityByNamber(String namber) {

        Car car = null;
        PreparedStatement ps = null;

        try {
            ps = connector.getConnection(true).prepareStatement(SQL_SELECT_CAR_BY_NAMBER);
            ps.setString(1, namber);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                car = createCar(resultSet);
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
        return car;
    }

}
