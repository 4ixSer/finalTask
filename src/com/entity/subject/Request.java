package com.entity.subject;

import java.util.Calendar;

import com.entity.car.Car;
import com.entity.users.User;

/**
 * ��������� ����������� �������� ������.
 *
 * @author qny4ix
 *
 */
public class Request {
    /**
     * ����� ������. ���������� �� �� � ID ��� ���� ������.
     */
    private Integer namberRequest;

    /**
     * �������� �����.
     */
    private User ownerRequest;

    /**
     * ���� ������ ������.
     */
    private Calendar dataRequest;

    /**
     * ���� ��������������� ������.
     */
    private Calendar dataDeparture;

    /**
     * �������������� �������������� ������.
     */
    private Car characteristics�ak;

    /**
     * ������
     */
    private Status status;

    /**
     * ����������.
     */
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Car getCharacteristics�ak() {
        return characteristics�ak;
    }

    public void setCharacteristics�ak(Car characteristics�ak) {
        this.characteristics�ak = characteristics�ak;
    }

    public Integer getNamberRequest() {
        return namberRequest;
    }

    public void setNamberRequest(Integer namberRequest) {
        this.namberRequest = namberRequest;
    }

    public User getOwnerRequest() {
        return ownerRequest;
    }

    public void setOwnerRequest(User ownerRequest) {
        this.ownerRequest = ownerRequest;
    }

    public Calendar getDataRequest() {
        return dataRequest;
    }

    public void setDataRequest(Calendar dataRequest) {
        this.dataRequest = dataRequest;
    }

    public Calendar getDataDeparture() {
        return dataDeparture;
    }

    public void setDataDeparture(Calendar dataDeparture) {
        this.dataDeparture = dataDeparture;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Request(User ownerRequest, Calendar dataRequest, Calendar dataDeparture, Car characteristics�ak,
            Status status, String note) {
        super();
        this.ownerRequest = ownerRequest;
        this.dataRequest = dataRequest;
        this.dataDeparture = dataDeparture;
        this.characteristics�ak = characteristics�ak;
        this.status = status;
        this.note = note;
    }

    public Request() {
        super();
    }

    @Override
    public String toString() {
        return "Request [namberRequest=" + namberRequest + ", ownerRequest=" + ownerRequest + ", dataRequest="
                + dataRequest + ", dataDeparture=" + dataDeparture + ", characteristics�ak=" + characteristics�ak
                + ", status=" + status + ", note=" + note + "]";
    }

}
