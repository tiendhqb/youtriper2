/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DINH KHANG
 */
public class TripperNotificationSetting {
    private int tripperNotificationID;
    private int tripperID;

    public TripperNotificationSetting(int tripperNotificationID, int tripperID) {
        this.tripperNotificationID = tripperNotificationID;
        this.tripperID = tripperID;
    }

    public TripperNotificationSetting(int tripperNotificationID) {
        this.tripperNotificationID = tripperNotificationID;
    }

    public int getTripperNotificationID() {
        return tripperNotificationID;
    }

    public int getTripperID() {
        return tripperID;
    }

    public void setTripperNotificationID(int tripperNotificationID) {
        this.tripperNotificationID = tripperNotificationID;
    }

    public void setTripperID(int tripperID) {
        this.tripperID = tripperID;
    }
    
    
}
