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
public class AmenitiesClassifierDTO {

    private int packageID;
    private int amenitiesID;
    private String amenitiesName;
    private String amenitiesIcon;
    private String description;
    private int languageID;
    private String languageName;

    public AmenitiesClassifierDTO() {
    }

    public AmenitiesClassifierDTO(int packageID, int amenitiesID, String amenitiesName, String amenitiesIcon, String description, int languageID) {
        this.packageID = packageID;
        this.amenitiesID = amenitiesID;
        this.amenitiesName = amenitiesName;
        this.amenitiesIcon = amenitiesIcon;
        this.description = description;
        this.languageID = languageID;
    }

    public AmenitiesClassifierDTO(int packageID, int amenitiesID, String amenitiesName, String amenitiesIcon, String description) {
        this.packageID = packageID;
        this.amenitiesID = amenitiesID;
        this.amenitiesName = amenitiesName;
        this.amenitiesIcon = amenitiesIcon;
        this.description = description;
    }

    public AmenitiesClassifierDTO(String amenitiesName, String amenitiesIcon, String description, int languageID, String languageName) {
        this.amenitiesName = amenitiesName;
        this.amenitiesIcon = amenitiesIcon;
        this.description = description;
        this.languageID = languageID;
        this.languageName = languageName;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public int getAmenitiesID() {
        return amenitiesID;
    }

    public void setAmenitiesID(int amenitiesID) {
        this.amenitiesID = amenitiesID;
    }

    public String getAmenitiesName() {
        return amenitiesName;
    }

    public void setAmenitiesName(String amenitiesName) {
        this.amenitiesName = amenitiesName;
    }

    public String getAmenitiesIcon() {
        return amenitiesIcon;
    }

    public void setAmenitiesIcon(String amenitiesIcon) {
        this.amenitiesIcon = amenitiesIcon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLanguageID() {
        return languageID;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

}
