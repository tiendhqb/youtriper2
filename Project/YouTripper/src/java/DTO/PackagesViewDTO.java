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
public class PackagesViewDTO {

    private int packageID;
    private String packageName;
    private String mainDescription;
    private String keywords;
    private String coverImage;
    private String location;
    private double rate;
    private int numberRates;
    private double ordinaryPrice;
    private int providerID;
    private String lastName;
    private String providerImage;
    private int totalRecords;
    private String packageStatus;
    private boolean isPending;
    private boolean isStopped;
    private boolean isDeleting;
    private boolean isEditing;
    private boolean isUsingMaxQuota;
    private int NoTrippSources;
    private long createdTime;
    private String priceCurrency;

    public PackagesViewDTO() {
    }

    public PackagesViewDTO(String priceCurrency, int packageID, String packageName, String mainDescription, String keywords, String coverImage, String location, double rate, int numberRates, double ordinaryPrice, int providerID, String lastName, String providerImage, int totalRecords) {
        this.priceCurrency = priceCurrency;
        this.packageID = packageID;
        this.packageName = packageName;
        this.mainDescription = mainDescription;
        this.keywords = keywords;
        this.coverImage = coverImage;
        this.location = location;
        this.rate = rate;
        this.numberRates = numberRates;
        this.ordinaryPrice = ordinaryPrice;
        this.providerID = providerID;
        this.lastName = lastName;
        this.providerImage = providerImage;
        this.totalRecords = totalRecords;
    }

    public PackagesViewDTO(int packageID, String packageName, String mainDescription, String keywords, String coverImage, String location, double rate, int numberRates, double ordinaryPrice, int providerID, String lastName, String providerImage, int totalRecords,String packageStatus) {
        this.packageID = packageID;
        this.packageName = packageName;
        this.mainDescription = mainDescription;
        this.keywords = keywords;
        this.coverImage = coverImage;
        this.location = location;
        this.rate = rate;
        this.numberRates = numberRates;
        this.ordinaryPrice = ordinaryPrice;
        this.providerID = providerID;
        this.lastName = lastName;
        this.providerImage = providerImage;
        this.totalRecords = totalRecords;
        this.packageStatus = packageStatus;
    }
    
    public PackagesViewDTO(int packageID, String packageName, String mainDescription, String keywords, String coverImage, String location, double rate, int numberRates, double ordinaryPrice, int providerID, String lastName, String providerImage, int totalRecords,boolean isPending, boolean isStopped, boolean isDeleting, boolean isEditing,  boolean isUsingMaxQuota, int NoTrippSources, long createdTime) {
        this.packageID = packageID;
        this.packageName = packageName;
        this.mainDescription = mainDescription;
        this.keywords = keywords;
        this.coverImage = coverImage;
        this.location = location;
        this.rate = rate;
        this.numberRates = numberRates;
        this.ordinaryPrice = ordinaryPrice;
        this.providerID = providerID;
        this.lastName = lastName;
        this.providerImage = providerImage;
        this.totalRecords = totalRecords;
        this.isPending = isPending;
        this.isStopped = isStopped;
        this.isDeleting = isDeleting;
        this.isEditing = isEditing;
        this.isUsingMaxQuota = isUsingMaxQuota;
        this.NoTrippSources = NoTrippSources;
        this.createdTime = createdTime;
    }

    public PackagesViewDTO(int packageID, String packageName, String coverImage) {
        this.packageID = packageID;
        this.packageName = packageName;
        this.coverImage = coverImage;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
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

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getNumberRates() {
        return numberRates;
    }

    public void setNumberRates(int numberRates) {
        this.numberRates = numberRates;
    }

    public double getOrdinaryPrice() {
        return ordinaryPrice;
    }

    public void setOrdinaryPrice(double ordinaryPrice) {
        this.ordinaryPrice = ordinaryPrice;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProviderImage() {
        return providerImage;
    }

    public void setProviderImage(String providerImage) {
        this.providerImage = providerImage;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public String getPackageStatus() {
        return packageStatus;
    }

    public void setPackageStatus(String packageStatus) {
        this.packageStatus = packageStatus;
    }

    public boolean isIsPending() {
        return isPending;
    }

    public void setIsPending(boolean isPending) {
        this.isPending = isPending;
    }

    public boolean isIsStopped() {
        return isStopped;
    }

    public void setIsStopped(boolean isStopped) {
        this.isStopped = isStopped;
    }

    public boolean isIsDeleting() {
        return isDeleting;
    }

    public void setIsDeleting(boolean isDeleting) {
        this.isDeleting = isDeleting;
    }

    public boolean isIsEditing() {
        return isEditing;
    }

    public void setIsEditing(boolean isEditing) {
        this.isEditing = isEditing;
    }

    

    public boolean isIsUsingMaxQuota() {
        return isUsingMaxQuota;
    }

    public void setIsUsingMaxQuota(boolean isUsingMaxQuota) {
        this.isUsingMaxQuota = isUsingMaxQuota;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public int getNoTrippSources() {
        return NoTrippSources;
    }

    public void setNoTrippSources(int NoTrippSources) {
        this.NoTrippSources = NoTrippSources;
    }

    /**
     * @return the createdTime
     */
    public long getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime the createdTime to set
     */
    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

}
