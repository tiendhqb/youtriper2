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
public class ResourceDTOv2 {

    private int resourceID;
    private String resourceName;
    private int maximunCapacity;
    private int providerID;

    public ResourceDTOv2(int resourceID, String resourceName, int maximunCapacity, int providerID) {
        this.resourceID = resourceID;
        this.resourceName = resourceName;
        this.maximunCapacity = maximunCapacity;
        this.providerID = providerID;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public int getMaximunCapacity() {
        return maximunCapacity;
    }

    public void setMaximunCapacity(int maximunCapacity) {
        this.maximunCapacity = maximunCapacity;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

}
