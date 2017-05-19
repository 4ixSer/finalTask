package com.dao.factory;

import com.dao.CarDAO;
import com.dao.FlightDAO;
import com.dao.RequestDAO;
import com.dao.UserDAO;

public class Factoty {

    private static UserDAO userDAO = null;
    private static CarDAO carDAO = null;
    private static FlightDAO flightDAO  = null;
    private static RequestDAO requestDAO  = null;

    private static Factoty instance = null;

    public static synchronized Factoty getInstance() {
        if (instance == null) {
            instance = new Factoty();
        }
        return instance;
    }

    public UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    public CarDAO getCarDAO() {
        if (carDAO == null) {
            carDAO = new CarDAO();
        }
        return carDAO;
    }

    public FlightDAO getFlightDAO() {
        if (flightDAO == null) {
            flightDAO = new FlightDAO();
        }
        return flightDAO;
    }

    public RequestDAO getRequestDAO() {
        if (requestDAO == null) {
            requestDAO = new RequestDAO();
        }
        return requestDAO;
    }
}
