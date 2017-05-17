package com.entity.subject;

import java.util.Calendar;

import com.entity.car.Car;
import com.entity.users.User;

/**
 * Сушьность реализуюшая поведение рейса.
 *
 * @author qny4ix
 *
 */
public class Flight {
    /**
     * Номер рейса. Он же и ID.
     */
    private Integer namberFlight;

    /**
     * Дате создания рейса.
     */
    private Calendar date;

    /**
     * Статус рейса.
     */
    private Status status;

    /**
     * Кто находится в данном рейсе.
     */
    private User driver;

    /**
     * Кто расматривал данный рейс.
     */
    private User dispatcher;

    /**
     * Cылка на машину в рейсе.
     */
    private Car car;

    /**
     * примечание.
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
