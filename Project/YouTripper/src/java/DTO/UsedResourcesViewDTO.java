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
public class UsedResourcesViewDTO {
    private int resourceID;
    private String tripDate;
    private String tripTime;
    private int noUsedResources;
    private int providerID;

    public UsedResourcesViewDTO() {
    }

    public UsedResourcesViewDTO(int resourceID, String tripDate, String tripTime, int noUsedResources) {
        this.resourceID = resourceID;
        this.tripDate = tripDate;
        this.tripTime = tripTime;
        this.noUsedResources = noUsedResources;
    }

    public UsedResourcesViewDTO(String tripDate, String tripTime, int noUsedResources) {
        this.tripDate = tripDate;
        this.tripTime = tripTime;
        this.noUsedResources = noUsedResources;
    }

    public UsedResourcesViewDTO(String tripTime, int noUsedResources) {
        this.tripTime = tripTime;
        this.noUsedResources = noUsedResources;
    }
    
    public UsedResourcesViewDTO(int resourceID, String tripDate, String tripTime, int noUsedResources, int providerID) {
        this.resourceID = resourceID;
        this.tripDate = tripDate;
        this.tripTime = tripTime;
        this.noUsedResources = noUsedResources;
        this.providerID = providerID;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    public String getTripTime() {
        return tripTime;
    }

    public void setTripTime(String tripTime) {
        this.tripTime = tripTime;
    }

    public int getNoUsedResources() {
        return noUsedResources;
    }

    public void setNoUsedResources(int noUsedResources) {
        this.noUsedResources = noUsedResources;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }
    
    
}
