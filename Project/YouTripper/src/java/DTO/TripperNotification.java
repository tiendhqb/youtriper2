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
public class TripperNotification {
    private int tripperNotificationID;
    private String name;

    public TripperNotification(int tripperNotificationID, String name) {
        this.tripperNotificationID = tripperNotificationID;
        this.name = name;
    }

    public int getTripperNotificationID() {
        return tripperNotificationID;
    }

    public String getName() {
        return name;
    }

    public void setTripperNotificationID(int tripperNotificationID) {
        this.tripperNotificationID = tripperNotificationID;
    }

    public void setName(String name) {
        this.name = name;
    }


 
    
}
