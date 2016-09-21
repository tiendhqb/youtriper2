/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.List;

/**
 *
 * @author Nick
 */
public class ActivityForm {

    private int packageID;
    private String activities;
    private int groupID;
    private int tripID;

    public ActivityForm() {
    }

    public ActivityForm(int packageID, String activities, int groupID, int tripID) {
        this.packageID = packageID;
        this.activities = activities;
        this.groupID = groupID;
        this.tripID = tripID;
    }
    
    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

   
    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }


}
