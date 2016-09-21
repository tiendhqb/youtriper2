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
public class OfflineBookingEngineDTO {

    private int bookingID;
    private String bookingDate;
    private String selectedDate;
    private String selectedTime;
    private int noPackages;
    private int offlinePackageID;
    private String packageName;
    private int resourceID;
    private int minimumNoResources;
    private int duration;
    private String durationType;
    private String color;

    public OfflineBookingEngineDTO() {
    }

    public OfflineBookingEngineDTO(int bookingID, String bookingDate, String selectedDate, String selectedTime, 
            int noPackages, int offlinePackageID, String packageName, int resourceID, int minimumNoResources, int duration,
            String durationType, String color) {
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.selectedDate = selectedDate;
        this.selectedTime = selectedTime;
        this.noPackages = noPackages;
        this.offlinePackageID = offlinePackageID;
        this.packageName = packageName;
        this.resourceID = resourceID;
        this.minimumNoResources = minimumNoResources;
        this.duration = duration;
        this.durationType = durationType;
        this.color = color;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
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

    public int getOfflinePackageID() {
        return offlinePackageID;
    }

    public void setOfflinePackageID(int offlinePackageID) {
        this.offlinePackageID = offlinePackageID;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public int getMinimumNoResources() {
        return minimumNoResources;
    }

    public void setMinimumNoResources(int minimumNoResources) {
        this.minimumNoResources = minimumNoResources;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDurationType() {
        return durationType;
    }

    public void setDurationType(String durationType) {
        this.durationType = durationType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    

}
