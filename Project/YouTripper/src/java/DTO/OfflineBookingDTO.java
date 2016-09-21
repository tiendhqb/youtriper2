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
public class OfflineBookingDTO {

    private int offlineBookingID;
    private int days;
    private int hours;
    private int minutes;
    private String dateStr;
    private String timeStr;

    public OfflineBookingDTO() {
    }

    public OfflineBookingDTO(int offlineBookingID, int days, int hours, int minutes, String dateStr, String timeStr) {
        this.offlineBookingID = offlineBookingID;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.dateStr = dateStr;
        this.timeStr = timeStr;
    }

    public int getOfflineBookingID() {
        return offlineBookingID;
    }

    public void setOfflineBookingID(int offlineBookingID) {
        this.offlineBookingID = offlineBookingID;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
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

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }
    
    
}
