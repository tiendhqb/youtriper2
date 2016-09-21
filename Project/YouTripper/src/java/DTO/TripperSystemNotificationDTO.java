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
public class TripperSystemNotificationDTO {
    private int notificationID;
    private String content;
    private boolean seen;
    private String date;
    private int tripperID;

    public TripperSystemNotificationDTO(int NotificationID, String content, boolean seen, String date, int tripperID) {
        this.notificationID = NotificationID;
        this.content = content;
        this.seen = seen;
        this.date = date;
        this.tripperID = tripperID;
    }

   
    public int getNotificationID() {
        return notificationID;
    }

    public String getContent() {
        return content;
    }

    public boolean isSeen() {
        return seen;
    }

    public int getTripperID() {
        return tripperID;
    }

    public void setNotificationID(int NotificationID) {
        this.notificationID = NotificationID;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public void setTripperID(int tripperID) {
        this.tripperID = tripperID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
