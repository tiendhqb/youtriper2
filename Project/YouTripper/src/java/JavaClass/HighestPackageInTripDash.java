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
public class HighestPackageInTripDash {
    private int packageID;
    private String packageTitle;
    private String coverImage;
    private float filterPrice;

    public HighestPackageInTripDash() {
    }

    
    
    public HighestPackageInTripDash(int packageID, String packageTitle, String coverImage, float filterPrice) {
        this.packageID = packageID;
        this.packageTitle = packageTitle;
        this.coverImage = coverImage;
        this.filterPrice = filterPrice;
    }
    
    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getPackageTitle() {
        return packageTitle;
    }

    public void setPackageTitle(String packageTitle) {
        this.packageTitle = packageTitle;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public float getFilterPrice() {
        return filterPrice;
    }

    public void setFilterPrice(float filterPrice) {
        this.filterPrice = filterPrice;
    }
    
    
}
