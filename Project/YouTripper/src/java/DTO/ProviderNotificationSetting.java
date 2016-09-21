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
public class ProviderNotificationSetting {

    private int providerNotificationID;
    private int providerID;

    public ProviderNotificationSetting(int providerNotificationID) {
        this.providerNotificationID = providerNotificationID;
    }

    public ProviderNotificationSetting(int providerNotificationID, int providerID) {
        this.providerNotificationID = providerNotificationID;
        this.providerID = providerID;
    }

    public int getProviderNotificationID() {
        return providerNotificationID;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderNotificationID(int providerNotificationID) {
        this.providerNotificationID = providerNotificationID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

}
