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
public class TemporaryClassifierDTO {

    private int temporaryPackageID;
    private int activityID;
    private String activityName;
    private int subCategoryID;
    private String content;

    public TemporaryClassifierDTO() {
    }

    public TemporaryClassifierDTO(int temporaryPackageID, int activityID, String activityName, int subCategoryID, String content) {
        this.temporaryPackageID = temporaryPackageID;
        this.activityID = activityID;
        this.activityName = activityName;
        this.subCategoryID = subCategoryID;
        this.content = content;
    }

    
    public int getTemporaryPackageiD() {
        return temporaryPackageID;
    }

    public void setTemporaryPackageiD(int temporaryPackageID) {
        this.temporaryPackageID = temporaryPackageID;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(int subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    
}
