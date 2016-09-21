/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author QuangTran
 */
public class ClassifierDTO {
    private int packageID;
    private int activityID;
    private String activityName;
    private int subCategoryID;
    private String content;

    public ClassifierDTO() {
    }

    public ClassifierDTO(int packageID, int activityID, String activityName, int subCategoryID, String content) {
        this.packageID = packageID;
        this.activityID = activityID;
        this.activityName = activityName;
        this.subCategoryID = subCategoryID;
        this.content = content;
    }
    
    /**
     * @return the packageID
     */
    public int getPackageID() {
        return packageID;
    }

    /**
     * @param packageID the packageID to set
     */
    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    /**
     * @return the activityID
     */
    public int getActivityID() {
        return activityID;
    }

    /**
     * @param activityID the activityID to set
     */
    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    /**
     * @return the activityName
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * @param activityName the activityName to set
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    /**
     * @return the subCategoryID
     */
    public int getSubCategoryID() {
        return subCategoryID;
    }

    /**
     * @param subCategoryID the subCategoryID to set
     */
    public void setSubCategoryID(int subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    
}
