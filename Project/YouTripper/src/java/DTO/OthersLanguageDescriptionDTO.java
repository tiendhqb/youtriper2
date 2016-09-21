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
public class OthersLanguageDescriptionDTO {

    private int packageID;
    private int languageID;
    private String languageName;
    private String packageName;
    private String googleDescription;
    private String description;
    private String advancedAddress;
    private String keywords;
    private String language;

    public OthersLanguageDescriptionDTO() {
    }
    
    public OthersLanguageDescriptionDTO(int languageID, String languageName, String packageName, String googleDescription, String description, String advancedAddress, String keywords, String language) {
        this.languageID = languageID;
        this.languageName = languageName;
        this.packageName = packageName;
        this.googleDescription = googleDescription;
        this.description = description;
        this.advancedAddress = advancedAddress;
        this.keywords = keywords;
        this.language = language;
    }
    
     public OthersLanguageDescriptionDTO(int languageID, String packageName, String googleDescription, String description, String advancedAddress, String keywords, String language) {
        this.languageID = languageID;
        this.packageName = packageName;
        this.googleDescription = googleDescription;
        this.description = description;
        this.advancedAddress = advancedAddress;
        this.keywords = keywords;
        this.language = language;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public int getLanguageID() {
        return languageID;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getGoogleDescription() {
        return googleDescription;
    }

    public void setGoogleDescription(String googleDescription) {
        this.googleDescription = googleDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdvancedAddress() {
        return advancedAddress;
    }

    public void setAdvancedAddress(String advancedAddress) {
        this.advancedAddress = advancedAddress;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

}
