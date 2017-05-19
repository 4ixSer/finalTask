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
import com.entity.subject.Request;
import com.entity.subject.Status;
import com.entity.users.User;

public class RequestDAO  {
    private static final String SQL_INSERT_REQUEST = "INSERT INTO request (ownerRequest, dataRequest, dataDeparture, car_type, carrying_car, amount_car, enginePower, status, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_All_REQUEST = "SELECT * FROM request";
    private static final String SQL_SELECT_REQUEST_BY_ID = "SELECT * FROM request where id=?";
    private static final String SQL_DELETE_REQUEST = "DELETE FROM request WHERE id=?";
    private static final String SQL_UPDETE_REQUEST ="UPDATE request SET ownerRequest=?, dataRequest=?, dataDeparture=?, car_type=?, carrying_car=?, amount_car=?, enginePower=?, status=?, note=? WHERE id=?";


    private WrapperConnector connector;

    public RequestDAO() {
        connector = WrapperConnector.getInstance();
    }

    public void close() {
        connector.closeConnection();
    }


    public List<Request> findAll() {
        List<Request> requests = new ArrayList<Request>();

        Statement st = null;
        try {
            st = connector.getConnection(true).createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_All_REQUEST);

            while (resultSet.next()) {
                Request request = createRequest(resultSet);

                requests.add(request);

            }

        } catch (SQLException e) {
            System.err.println("Error createStatement: " + e);
            // TODO ���� ������� �����������

        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                // TODO ���� ������� �����������
                e.printStackTrace();
            }
        }

        return requests;
    }

    private Request createRequest(ResultSet resultSet) throws SQLException {
        Request request = new Request();

        request.setNamberRequest(resultSet.getInt("id"));
        request.setStatus(Status.fromValue(resultSet.getInt("status")));
        request.setNote(resultSet.getString("note"));

        // C�������� ��������� ������ ������ � ������ ������ ������������ ��
        // ��������������
        Car charCar = new Car();
        charCar.setType(TYPE.fromValue(resultSet.getInt("car_type")));
        charCar.setCarryingCar(resultSet.getDouble("carrying_car"));
        charCar.setAmountCar(resultSet.getDouble("amount_car"));
        charCar.setEnginePower(resultSet.getDouble("enginePower"));
        request.setCharacteristics�ar(charCar);

        // ��������� ����� ���������� ������
        User driver = new UserDAO().findEntityById(resultSet.getInt("ownerRequest"));
        request.setOwnerRequest(driver);

        // ��������������� � ������ ������� � ������
        request.setDataRequest(Request.fromValueDataRequest(resultSet.getString("dataRequest")));
        request.setDataDeparture(Request.fromValueDataDeparture(resultSet.getString("dataDeparture")));
        return request;
    }


    public Request findEntityById(int id) {

        Request request = null;
        PreparedStatement ps = null;

        try {

            ps = connector.getConnection(true).prepareStatement(SQL_SELECT_REQUEST_BY_ID);
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {

                request = createRequest(resultSet);
            }
        } catch (SQLException e) {
            System.err.println("Error createStatement: " + e);
            // TODO ���� ������� �����������
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO ���� ������� �����������
                e.printStackTrace();
            }

        }

        return request;

    }


    public boolean delete(int id) {
        // ������ ����� ��� ���� �� �����.
        throw new IllegalArgumentException();
    }


    public boolean delete(Request entity) {
        PreparedStatement ps = null;
        try {
            ps = connector.getConnection(true).prepareStatement(SQL_DELETE_REQUEST);
            ps.setInt(1, entity.getNamberRequest());
            ps.execute();

        } catch (SQLException e) {
            // TODO ���� ������� �����������
            System.err.println("SQL exception: " + e);
            return false;
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO ���� ������� �����������
                e.printStackTrace();
            }
        }

        return true;
    }


    public boolean create(Request entity) {

        PreparedStatement ps = null;
        try {

            ps = connector.getConnection(true).prepareStatement(SQL_INSERT_REQUEST);

            ps.setInt(1, entity.getOwnerRequest().getId());

            ps.setString(2, entity.toStringDataDeparture());
            ps.setString(3, entity.toStringDataRequest());

            // ��� �� ���������� �������������� ������ ��� ������
            ps.setInt(4, entity.getCharacteristics�ak().getType().value());
            ps.setDouble(5, entity.getCharacteristics�ak().getCarryingCar());
            ps.setDouble(6, entity.getCharacteristics�ak().getAmountCar());
            ps.setDouble(7, entity.getCharacteristics�ak().getEnginePower());
            ps.setInt(8, entity.getStatus().value());
            ps.setString(9, entity.getNote());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.err.println("SQL exception: " + e);
            return false;// TODO ���� ������� �����������
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO ���� ������� �����������
                e.printStackTrace();
            }
        }
        return true;
    }


    public Request update(Request entity) {
        PreparedStatement ps = null;


        try {
            ps = connector.getConnection(true).prepareStatement(SQL_UPDETE_REQUEST);



            ps.setInt(1, entity.getOwnerRequest().getId());
            ps.setString(2, entity.toStringDataRequest());
            ps.setString(3, entity.toStringDataDeparture());
            ps.setInt(4, entity.getCharacteristics�ak().getType().value());

            //��������� ������������� ���� �����
            ps.setDouble(5, entity.getCharacteristics�ak().getCarryingCar());
            ps.setDouble(6, entity.getCharacteristics�ak().getAmountCar());

            ps.setDouble(7, entity.getCharacteristics�ak().getEnginePower());
            ps.setInt(8, entity.getStatus().value());
            ps.setString(9, entity.getNote());

            ps.setInt(10, entity.getNamberRequest());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            // TODO ���� ������� �����������
            return null;
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO ���� ������� �����������
                e.printStackTrace();
            }
        }
        return entity;
    }

}
