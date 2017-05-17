package com.entity.subject;

import java.util.Calendar;

import com.entity.car.Car;
import com.entity.users.User;

/**
 * ��������� ����������� ��������� �����.
 *
 * @author qny4ix
 *
 */
public class Flight {
    /**
     * ����� �����. �� �� � ID.
     */
    private Integer namberFlight;

    /**
     * ���� �������� �����.
     */
    private Calendar date;

    /**
     * ������ �����.
     */
    private Status status;

    /**
     * ��� ��������� � ������ �����.
     */
    private User driver;

    /**
     * ��� ����������� ������ ����.
     */
    private User dispatcher;

    /**
     * C���� �� ������ � �����.
     */
    private Car car;

    /**
     * ����������.
     */
    private String note;

    public Flight(Calendar date, Status status, User driver, User dispatcher, Car car, String note) {
        super();
        this.date = date;
        this.status = status;
        this.driver = driver;
        this.dispatcher = dispatcher;
        this.car = car;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Flight [namberFlight=" + namberFlight + ", date=" + date + ", status=" + status + ", driver=" + driver
                + ", dispatcher=" + dispatcher + ", car=" + car + ", note=" + note + "]";
    }



}
