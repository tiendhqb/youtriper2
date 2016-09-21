/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Long Nguyen
 */
public class OfflineResourceDTO {

    private int offlineBookingID;
    private int providerResourceID;
    private int noUnits;
    private int hours;
    private int minutes;
    private int days;

    public OfflineResourceDTO() {
    }

    public OfflineResourceDTO(int offlineBookingID, int providerResourceID, int noUnits, int hours, int minutes, int days) {
        this.offlineBookingID = offlineBookingID;
        this.providerResourceID = providerResourceID;
        this.noUnits = noUnits;
        this.hours = hours;
        this.minutes = minutes;
        this.days = days;
    }

    public OfflineResourceDTO(int providerResourceID, int noUnits, int hours, int minutes, int days) {
        this.providerResourceID = providerResourceID;
        this.noUnits = noUnits;
        this.hours = hours;
        this.minutes = minutes;
        this.days = days;
    }

    public int getOfflineBookingID() {
        return offlineBookingID;
    }

    public void setOfflineBookingID(int offlineBookingID) {
        this.offlineBookingID = offlineBookingID;
    }

    public int getProviderResourceID() {
        return providerResourceID;
    }

    public void setProviderResourceID(int providerResourceID) {
        this.providerResourceID = providerResourceID;
    }

    public int getNoUnits() {
        return noUnits;
    }

    public void setNoUnits(int noUnits) {
        this.noUnits = noUnits;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    
}
