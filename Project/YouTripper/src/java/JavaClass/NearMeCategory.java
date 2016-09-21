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
public class NearMeCategory {
    private int categoryID;
    private String categoryName;
    private int totalPackages;

    public NearMeCategory() {
    }

    public NearMeCategory(int categoryID, String categoryName, int totalPackages) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.totalPackages = totalPackages;
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

    public int getTotalPackages() {
        return totalPackages;
    }

    public void setTotalPackages(int totalPackages) {
        this.totalPackages = totalPackages;
    }
    
    
}
