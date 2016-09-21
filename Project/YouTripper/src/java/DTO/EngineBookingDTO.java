/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Nick
 */
public class EngineBookingDTO {

    private String bookingID;
    private String bookingDate;
    private String selectedDate;
    private String selectedTime;
    private int noPackages;
    private int packageID;
    private String packageName;
    private String durationType;
    private int duration;
    private String startOperationTime;
    private String endOperationTime;
    private boolean isFreeBooking;
    private int freeInterval;
    private int fixedHour;
    private int fixedMinute;
    private int resourceID;
    private int minimumResources;
    private String color;

    public EngineBookingDTO() {
    }

    public EngineBookingDTO(String bookingID, String bookingDate, String selectedDate, String selectedTime, int noPackages, int packageID,
            String packageName, String durationType, int duration, String startOperationTime, String endOperationTime, boolean isFreeBooking,
            int freeInterval, int fixedHour, int fixedMinute, int resourceID, int minimumResources, String color) {
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.selectedDate = selectedDate;
        this.selectedTime = selectedTime;
        this.noPackages = noPackages;
        this.packageID = packageID;
        this.packageName = packageName;
        this.durationType = durationType;
        this.duration = duration;
        this.startOperationTime = startOperationTime;
        this.endOperationTime = endOperationTime;
        this.isFreeBooking = isFreeBooking;
        this.freeInterval = freeInterval;
        this.fixedHour = fixedHour;
        this.fixedMinute = fixedMinute;
        this.resourceID = resourceID;
        this.minimumResources = minimumResources;
        this.color = color;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public String getSelectedTime() {
        return selectedTime;
    }

    public void setSelectedTime(String selectedTime) {
        this.selectedTime = selectedTime;
    }

    public int getNoPackages() {
        return noPackages;
    }

    public void setNoPackages(int noPackages) {
        this.noPackages = noPackages;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDurationType() {
        return durationType;
    }

    public void setDurationType(String durationType) {
        this.durationType = durationType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

    public int getFixedHour() {
        return fixedHour;
    }

    public void setFixedHour(int fixedHour) {
        this.fixedHour = fixedHour;
    }

    public int getFixedMinute() {
        return fixedMinute;
    }

    public void setFixedMinute(int fixedMinute) {
        this.fixedMinute = fixedMinute;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public int getMinimumResources() {
        return minimumResources;
    }

    public void setMinimumResources(int minimumResources) {
        this.minimumResources = minimumResources;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
