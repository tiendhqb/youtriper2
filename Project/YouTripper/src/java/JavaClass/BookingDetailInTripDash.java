/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

/**
 *
 * @author DINH KHANG
 */
public class BookingDetailInTripDash {
    private int packageID;
    private int durationDay;
    private int durationHour;
    private int durationMinute;
    private int maxQuota;
    private boolean isFreeBooking;
    private int freeInterval;
    private String startOperationTime;
    private String endOperationTime;

    public BookingDetailInTripDash() {
    }

    public BookingDetailInTripDash(int packageID, int durationDay, int durationHour, int durationMinute, int maxQuota, boolean isFreeBooking, int freeInterval, String startOperationTime, String endOperationTime) {
        this.packageID = packageID;
        this.durationDay = durationDay;
        this.durationHour = durationHour;
        this.durationMinute = durationMinute;
        this.maxQuota = maxQuota;
        this.isFreeBooking = isFreeBooking;
        this.freeInterval = freeInterval;
        this.startOperationTime = startOperationTime;
        this.endOperationTime = endOperationTime;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public int getDurationDay() {
        return durationDay;
    }

    public void setDurationDay(int durationDay) {
        this.durationDay = durationDay;
    }

    public int getDurationHour() {
        return durationHour;
    }

    public void setDurationHour(int durationHour) {
        this.durationHour = durationHour;
    }

    public int getDurationMinute() {
        return durationMinute;
    }

    public void setDurationMinute(int durationMinute) {
        this.durationMinute = durationMinute;
    }

    public int getMaxQuota() {
        return maxQuota;
    }

    public void setMaxQuota(int maxQuota) {
        this.maxQuota = maxQuota;
    }

    public boolean isIsFreeBooking() {
        return isFreeBooking;
    }

    public void setIsFreeBooking(boolean isFreeBooking) {
        this.isFreeBooking = isFreeBooking;
    }

    public int getFreeInterval() {
        return freeInterval;
    }

    public void setFreeInterval(int freeInterval) {
        this.freeInterval = freeInterval;
    }

    public String getStartOperationTime() {
        return startOperationTime;
    }

    public void setStartOperationTime(String startOperationTime) {
        this.startOperationTime = startOperationTime;
    }

    public String getEndOperationTime() {
        return endOperationTime;
    }

    public void setEndOperationTime(String endOperationTime) {
        this.endOperationTime = endOperationTime;
    }    
}
