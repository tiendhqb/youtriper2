/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

/**
 *
 * @author DINH KHANG
 */
public class OtherSubCategory {

    private int otherSubCategoryID;
    private int packageID;
    private int categoryID;
    private String name;

    public OtherSubCategory(int otherSubCategoryID, int packageID, int categoryID, String name) {
        this.otherSubCategoryID = otherSubCategoryID;
        this.packageID = packageID;
        this.categoryID = categoryID;
        this.name = name;
    }

    public int getOtherSubCategoryID() {
        return otherSubCategoryID;
    }

    public void setOtherSubCategoryID(int otherSubCategoryID) {
        this.otherSubCategoryID = otherSubCategoryID;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
