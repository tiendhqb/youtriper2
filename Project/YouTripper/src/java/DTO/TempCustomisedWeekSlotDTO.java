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
public class TempCustomisedWeekSlotDTO {
    private int id;
    private int week;
    private int day;
    private int maxQuota;
    private int tempPackageID;

    public TempCustomisedWeekSlotDTO() {
    }

    public TempCustomisedWeekSlotDTO(int id, int week, int day, int maxQuota) {
        this.id = id;
        this.week = week;
        this.day = day;
        this.maxQuota = maxQuota;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTempPackageID() {
        return tempPackageID;
    }

    public void setTempPackageID(int tempPackageID) {
        this.tempPackageID = tempPackageID;
    }

    public int getMaxQuota() {
        return maxQuota;
    }

    public void setMaxQuota(int maxQuota) {
        this.maxQuota = maxQuota;
    }
    
}
