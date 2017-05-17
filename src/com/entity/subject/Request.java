package com.entity.subject;

import java.util.Calendar;

import com.entity.car.Car;
import com.entity.users.User;

/**
 * ÑÓøüíîñòü ğåàëèçóşøåå ïîâåäíèå Çàÿâêè.
 *
 * @author qny4ix
 *
 */
public class Request {
    /**
     * íîìåğ çàÿâêè. óíèêàëüíûé îí æå è ID äëÿ áàçû äàííûõ.
     */
    private Integer namberRequest;

    /**
     * Âëàäåëåö çàÿêè.
     */
    private User ownerRequest;

    /**
     * Äàòà ïîäà÷è çàÿâêè.
     */
    private Calendar dataRequest;

    /**
     * Äàòà ïğåäïîëîãàåìîãî âûåçäà.
     */
    private Calendar dataDeparture;

    /**
     * Õàğàêòåğèñòèêè ïğåäïîëàãàåìîé ìàøûíû.
     */
    private Car characteristicsÑak;

    /**
     * Ñòàòóñ
     */
    private Status status;

    /**
     * ïğèìå÷àíèå.
     */
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Car getCharacteristicsÑak() {
        return characteristicsÑak;
    }

    public void setCharacteristicsÑak(Car characteristicsÑak) {
        this.characteristicsÑak = characteristicsÑak;
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

    public Request(User ownerRequest, Calendar dataRequest, Calendar dataDeparture, Car characteristicsÑak,
            Status status, String note) {
        super();
        this.ownerRequest = ownerRequest;
        this.dataRequest = dataRequest;
        this.dataDeparture = dataDeparture;
        this.characteristicsÑak = characteristicsÑak;
        this.status = status;
        this.note = note;
    }

    public Request() {
        super();
    }

    @Override
    public String toString() {
        return "Request [namberRequest=" + namberRequest + ", ownerRequest=" + ownerRequest + ", dataRequest="
                + dataRequest + ", dataDeparture=" + dataDeparture + ", characteristicsÑak=" + characteristicsÑak
                + ", status=" + status + ", note=" + note + "]";
    }

}
