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
public class TempSpecificTimeSlotsDTO {
    private int id;
    private String timeStr;
    private int timeInMinutes;
    private String minute;
    private String hour;
    private int numberOfMinutes;
    private int numberOfHours;
    private int maxQuota;
    private int tempPackageID;

    public TempSpecificTimeSlotsDTO() {
    }

    public TempSpecificTimeSlotsDTO(int id, String timeStr, int timeInMinutes, String minute, String hour, int numberOfMinutes, int numberOfHours, int maxQuota, int tempPackageID) {
        this.id = id;
        this.timeStr = timeStr;
        this.timeInMinutes = timeInMinutes;
        this.minute = minute;
        this.hour = hour;
        this.numberOfMinutes = numberOfMinutes;
        this.numberOfHours = numberOfHours;
        this.maxQuota = maxQuota;
        this.tempPackageID = tempPackageID;
    }

    public TempSpecificTimeSlotsDTO(String timeStr, int timeInMinutes, String minute, String hour, int numberOfMinutes, int numberOfHours, int maxQuota) {
        this.timeStr = timeStr;
        this.timeInMinutes = timeInMinutes;
        this.minute = minute;
        this.hour = hour;
        this.numberOfMinutes = numberOfMinutes;
        this.numberOfHours = numberOfHours;
        this.maxQuota = maxQuota;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setTimeInMinutes(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getNumberOfMinutes() {
        return numberOfMinutes;
    }

    public void setNumberOfMinutes(int numberOfMinutes) {
        this.numberOfMinutes = numberOfMinutes;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public int getMaxQuota() {
        return maxQuota;
    }

    public void setMaxQuota(int maxQuota) {
        this.maxQuota = maxQuota;
    }

    public int getTempPackageID() {
        return tempPackageID;
    }

    public void setTempPackageID(int tempPackageID) {
        this.tempPackageID = tempPackageID;
    }
    
    
}
