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
public class ProviderNotification {
    private int providerNotificationID;
    private String name;

    public ProviderNotification(int providerNotificationID, String name) {
        this.providerNotificationID = providerNotificationID;
        this.name = name;
    }

    public int getProviderNotificationID() {
        return providerNotificationID;
    }

    public String getName() {
        return name;
    }

    public void setProviderNotificationID(int providerNotificationID) {
        this.providerNotificationID = providerNotificationID;
    }

    public void setName(String name) {
        this.name = name;
    }

}

