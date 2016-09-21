/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

/**
 *
 * @author Nick
 */
public class CategoryRelation {
    private int categoryID;
    private String categoryName;
    private String categoryIcon;
    private int subCategoryID;
    private String subCategoryName;
    private int activityID;
    private String activityName;

    public CategoryRelation() {
    }

    public CategoryRelation(int categoryID, String categoryName, String categoryIcon, int subCategoryID, String subCategoryName, int activityID, String activityName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryIcon = categoryIcon;
        this.subCategoryID = subCategoryID;
        this.subCategoryName = subCategoryName;
        this.activityID = activityID;
        this.activityName = activityName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    public int getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(int subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
    
    
}
