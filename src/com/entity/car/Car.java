package com.entity.car;
/**
 * Класс реализуюший описание поведение машины.
 * @author qny4ix
 *
 */
public class Car {
    /**
     * ID машины для хранения в базе.
     */
    private Integer id;
    /**
     * Номер машины.
     */
    private String namber;

    /**
     * Тип машыны.
     */
    private TYPE type;

    /**
     * Грузоподьемность машыны.
     */
    private Double carryingCar;

    /**
     * Обьем машыны.
     */
    private Double amountCar;

    /**
     * Мошьность двигателся
     */
    private Double enginePower;

    /**
     * Исправность машины.
     */
    private boolean defective;

    /**
     * Коментарии.
     */

    private String comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamber() {
        return namber;
    }

    public void setNamber(String namber) {
        this.namber = namber;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public Double getCarryingCar() {
        return carryingCar;
    }

    public void setCarryingCar(Double carryingCar) {
        this.carryingCar = carryingCar;
    }

    public Double getAmountCar() {
        return amountCar;
    }

    public void setAmountCar(Double amountCar) {
        this.amountCar = amountCar;
    }

    public boolean isDefective() {
        return defective;
    }

    public void setDefective(boolean defective) {
        this.defective = defective;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }



    public Double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Double enginePower) {
        this.enginePower = enginePower;
    }

    public Car() {

    }

    public Car(String namber, TYPE type, Double carryingCar, Double amountCar, Double enginePower, boolean defective,
            String comments) {
        super();
        this.namber = namber;
        this.type = type;
        this.carryingCar = carryingCar;
        this.amountCar = amountCar;
        this.enginePower = enginePower;
        this.defective = defective;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Car [id=" + id + ", namber=" + namber + ", type=" + type + ", carryingCar=" + carryingCar
                + ", amountCar=" + amountCar + ", enginePower=" + enginePower + ", defective=" + defective
                + ", comments=" + comments + "]";
    }








}
