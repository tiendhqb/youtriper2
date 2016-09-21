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
public class TempSpecificDateSlotsDTO {
    private int id;
    private String dateStr;
    private long dateInMilliSeconds;
    private int maxQuota;
    private int tempPackageID;

    public TempSpecificDateSlotsDTO() {
    }

    public TempSpecificDateSlotsDTO(int id, String dateStr, long dateInMilliSeconds, int maxQuota, int tempPackageID) {
        this.id = id;
        this.dateStr = dateStr;
        this.dateInMilliSeconds = dateInMilliSeconds;
        this.maxQuota = maxQuota;
        this.tempPackageID = tempPackageID;
    }

    public TempSpecificDateSlotsDTO(int id, String dateStr, long dateInMilliSeconds, int maxQuota) {
        this.id = id;
        this.dateStr = dateStr;
        this.dateInMilliSeconds = dateInMilliSeconds;
        this.maxQuota = maxQuota;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public long getDateInMilliSeconds() {
        return dateInMilliSeconds;
    }

    public void setDateInMilliSeconds(long dateInMilliSeconds) {
        this.dateInMilliSeconds = dateInMilliSeconds;
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
