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
public class PackageDescriptionDTO {
    private int packageID;
    private String name;
    private int durationType;
    private int duration;
    private int minTripper;
    private int maxTripper;
    private String language;
    private String googleDescription;
    private String mainDescription;
    private String keywords;

    public PackageDescriptionDTO() {
    }

    public PackageDescriptionDTO(int packageID, String name, int durationType, int duration, int minTripper, int maxTripper, String language, String googleDescription, String mainDescription, String keywords) {
        this.packageID = packageID;
        this.name = name;
        this.durationType = durationType;
        this.duration = duration;
        this.minTripper = minTripper;
        this.maxTripper = maxTripper;
        this.language = language;
        this.googleDescription = googleDescription;
        this.mainDescription = mainDescription;
        this.keywords = keywords;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationType() {
        return durationType;
    }

    public void setDurationType(int durationType) {
        this.durationType = durationType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMinTripper() {
        return minTripper;
    }

    public void setMinTripper(int minTripper) {
        this.minTripper = minTripper;
    }

    public int getMaxTripper() {
        return maxTripper;
    }

    public void setMaxTripper(int maxTripper) {
        this.maxTripper = maxTripper;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGoogleDescription() {
        return googleDescription;
    }

    public void setGoogleDescription(String googleDescription) {
        this.googleDescription = googleDescription;
    }

    public String getMainDescription() {
        return mainDescription;
    }

    public void setMainDescription(String mainDescription) {
        this.mainDescription = mainDescription;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    
    
}
