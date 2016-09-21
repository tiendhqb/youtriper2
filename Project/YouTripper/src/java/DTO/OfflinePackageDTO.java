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
public class OfflinePackageDTO {

    private int packageID;
    private String packageName;
    private int resourceID;
    private int minimumNoResources;
    private int duration;
    private String durationType;
    private String color;

    public OfflinePackageDTO() {
    }

    public OfflinePackageDTO(int packageID, String packageName, int resourceID, int minimumNoResources, int duration, String durationType, String color) {
        this.packageID = packageID;
        this.packageName = packageName;
        this.resourceID = resourceID;
        this.minimumNoResources = minimumNoResources;
        this.duration = duration;
        this.durationType = durationType;
        this.color = color;
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
