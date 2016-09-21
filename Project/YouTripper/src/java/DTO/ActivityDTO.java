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
public class ActivityDTO {
    private int activityID;
    private String name;
    private int subCategoryID;
    private String image;
    private int totalRecords;

    public ActivityDTO() {
    }

    public ActivityDTO(int activityID, String name) {
        this.activityID = activityID;
        this.name = name;
    }
    
    public ActivityDTO(int activityID, String name, int subCategoryID) {
        this.activityID = activityID;
        this.name = name;
        this.subCategoryID = subCategoryID;
    }

    public ActivityDTO(int activityID, String name, String image, int totalRecords) {
        this.activityID = activityID;
        this.name = name;
        this.image = image;
        this.totalRecords = totalRecords;
    }
    
    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(int subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
}
