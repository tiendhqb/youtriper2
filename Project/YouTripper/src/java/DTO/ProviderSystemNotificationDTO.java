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
public class ProviderSystemNotificationDTO {
    private int notificationID;
    private String content;
    private boolean seen;
    private String date;
    private int providerID;

    public ProviderSystemNotificationDTO(int notificationID, String content, boolean seen, String date, int providerID) {
        this.notificationID = notificationID;
        this.content = content;
        this.seen = seen;
        this.date = date;
        this.providerID = providerID;
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

    public int getProviderID() {
        return providerID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
            
}
