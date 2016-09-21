/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.List;

/**
 *
 * @author Nick
 */
public class ProviderDTO {

    private int providerID;
    private String email;
    private String name;
    private String firstName;
    private String image;
    private String phoneCode;
    private String phoneNumber;
    private boolean phoneActive;
    private String information;
    private String interests;
    private String taxnumber;
    private String job;
    private String language;
    private String gender;
    private String bank;
    private String bankHolder;
    private String city;
    private String address;
    private String businessName;
    private int countryID;
    private String countryCode;
    private String countryName;
    private List<ReviewDTO> reviewList;
    private List<PackageDTO> packageList;
    private boolean emailActive;
    private String activeDate;
    private boolean notification;
    private int activatePackage;
    private String registerDate;
    private int pendingPackage;
    private String providerOfficialId;
    private String imagePassport;
    private boolean passportStatus;
    private String passportUploadTime;
    private String businessType;
    private String displayName;
    private String usernameURL;
    private String officialID;

    public ProviderDTO(String countryCode, String phoneNumber) {
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
    }
    
    public ProviderDTO(int providerID) {
        this.providerID = providerID;
    }
    
    public ProviderDTO(int providerID, String email, int activePackage) {
        this.providerID = providerID;
        this.email = email;
        this.activatePackage = activePackage;
    }

    public ProviderDTO(int providerID, String email, String name, String firstName, String phoneNumber, String address, String activeDate, int activatePackage, String registerDate, int pendingPackage, String providerOfficialId) {
        this.providerID = providerID;
        this.email = email;
        this.name = name;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.activeDate = activeDate;
        this.activatePackage = activatePackage;
        this.registerDate = registerDate;
        this.pendingPackage = pendingPackage;
        this.providerOfficialId = providerOfficialId;
    }

    public ProviderDTO(int providerID, String email, String name, String firstName, String image, String phoneCode, String phoneNumber,
            String information, String job, String language, String gender, String bank, String bankHolder, String city, String address,
            String businessName, String countryName, boolean phoneActive, String interests, String taxnumber, boolean notification) {
        this.providerID = providerID;
        this.email = email;
        this.name = name;
        this.firstName = firstName;
        this.image = image;
        this.phoneCode = phoneCode;
        this.phoneNumber = phoneNumber;
        this.information = information;
        this.job = job;
        this.language = language;
        this.gender = gender;
        this.bank = bank;
        this.bankHolder = bankHolder;
        this.city = city;
        this.address = address;
        this.businessName = businessName;
        this.countryName = countryName;
        this.phoneActive = phoneActive;
        this.interests = interests;
        this.taxnumber = taxnumber;
        this.notification = notification;
        
    }

    public ProviderDTO(int providerID, String email, String name, String firstName, String image, String phoneCode, String phoneNumber,
            String information, String job, String language, String gender, String bank, String bankHolder, String city, String address,
            String businessName, String countryName, boolean phoneActive, String interests, String taxnumber, boolean notification, 
            String imagePassport, boolean passportStatus, String displayName, String usernameURL, String officialID) {
        this.providerID = providerID;
        this.email = email;
        this.name = name;
        this.firstName = firstName;
        this.image = image;
        this.phoneCode = phoneCode;
        this.phoneNumber = phoneNumber;
        this.information = information;
        this.job = job;
        this.language = language;
        this.gender = gender;
        this.bank = bank;
        this.bankHolder = bankHolder;
        this.city = city;
        this.address = address;
        this.businessName = businessName;
        this.countryName = countryName;
        this.phoneActive = phoneActive;
        this.interests = interests;
        this.taxnumber = taxnumber;
        this.notification = notification;
        this.imagePassport = imagePassport;
        this.passportStatus = passportStatus;
        this.displayName = displayName;
        this.usernameURL = usernameURL;
        this.officialID = officialID;
    }

    public ProviderDTO(int providerID, boolean emailActive, String name, String firstName, String image, String phoneCode,
            String phoneNumber, boolean phoneActive, String information, String language, String city, String address, String countryName, String activeDate, String businessName, String businessType, boolean passportStatus) {
        this.providerID = providerID;
        this.emailActive = emailActive;
        this.name = name;
        this.firstName = firstName;
        this.image = image;
        this.phoneCode = phoneCode;
        this.phoneNumber = phoneNumber;
        this.phoneActive = phoneActive;
        this.information = information;
        this.language = language;
        this.city = city;
        this.address = address;
        this.countryName = countryName;
        this.activeDate = activeDate;
        this.businessName = businessName;
        this.businessType = businessType;
        this.passportStatus = passportStatus;
    }

    public ProviderDTO(int providerID, boolean emailActive, String name, String firstName, String image, String phoneCode,
            String phoneNumber, boolean phoneActive, String information, String language, String city, String address, String countryName, String activeDate, String imagePassport, boolean passportStatus) {
        this.providerID = providerID;
        this.emailActive = emailActive;
        this.name = name;
        this.firstName = firstName;
        this.image = image;
        this.phoneCode = phoneCode;
        this.phoneNumber = phoneNumber;
        this.phoneActive = phoneActive;
        this.information = information;
        this.language = language;
        this.city = city;
        this.address = address;
        this.countryName = countryName;
        this.activeDate = activeDate;
        this.imagePassport = imagePassport;
        this.passportStatus = passportStatus;
    }

    public ProviderDTO(int providerID, String email, String name, String firstName, int activatePackage) {
        this.providerID = providerID;
        this.email = email;
        this.name = name;
        this.firstName = firstName;
        this.activatePackage = activatePackage;
    }

    public ProviderDTO(int providerID, String firstName, String image, String imagePassport, boolean passportStatus, String businessName, String Email, String passportUploadTime) {
        this.providerID = providerID;
        this.firstName = firstName;
        this.image = image;
        this.imagePassport = imagePassport;
        this.passportStatus = passportStatus;
        this.businessName = businessName;
        this.email = Email;
        this.passportUploadTime = passportUploadTime;
    }

    public int getProviderID() {
        return providerID;
    }

    public String getName() {
        return name;
    }

    public int getCountryID() {
        return countryID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankHolder() {
        return bankHolder;
    }

    public void setBankHolder(String bankHolder) {
        this.bankHolder = bankHolder;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public boolean isPhoneActive() {
        return phoneActive;
    }

    public void setPhoneActive(boolean phoneActive) {
        this.phoneActive = phoneActive;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getTaxNumber() {
        return getTaxnumber();
    }

    public void setTaxNumber(String taxnumber) {
        this.setTaxnumber(taxnumber);
    }

    public List<ReviewDTO> getReviewList() {
        return reviewList;
    }

    public List<PackageDTO> getPackageList() {
        return packageList;
    }

    public void setReviewList(List<ReviewDTO> reviewList) {
        this.reviewList = reviewList;
    }

    public void setPackageList(List<PackageDTO> packageList) {
        this.packageList = packageList;
    }

    public boolean isEmailActive() {
        return emailActive;
    }

    public void setEmailActive(boolean emailActive) {
        this.emailActive = emailActive;
    }

    public String getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    /**
     * @return the notification
     */
    public boolean isNotification() {
        return notification;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @param notification the notification to set
     */
    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    /**
     * @return the activatePackage
     */
    public int getActivatePackage() {
        return activatePackage;
    }

    public String getUsernameURL() {
        return usernameURL;
    }

    public void setUsernameURL(String usernameURL) {
        this.usernameURL = usernameURL;
    }

    /**
     * @param activatePackage the activatePackage to set
     */
    public void setActivatePackage(int activatePackage) {
        this.activatePackage = activatePackage;
    }

    /**
     * @return the taxnumber
     */
    public String getTaxnumber() {
        return taxnumber;
    }

    /**
     * @param taxnumber the taxnumber to set
     */
    public void setTaxnumber(String taxnumber) {
        this.taxnumber = taxnumber;
    }

    /**
     * @return the registerDate
     */
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * @param registerDate the registerDate to set
     */
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * @return the pendingPackage
     */
    public int getPendingPackage() {
        return pendingPackage;
    }

    /**
     * @param pendingPackage the pendingPackage to set
     */
    public void setPendingPackage(int pendingPackage) {
        this.pendingPackage = pendingPackage;
    }

    /**
     * @return the providerOfficialId
     */
    public String getProviderOfficialId() {
        return providerOfficialId;
    }

    /**
     * @param providerOfficialId the providerOfficialId to set
     */
    public void setProviderOfficialId(String providerOfficialId) {
        this.providerOfficialId = providerOfficialId;
    }

    public String getImagePassport() {
        return imagePassport;
    }

    public void setImagePassport(String imagePassport) {
        this.imagePassport = imagePassport;
    }

    public boolean isPassportStatus() {
        return passportStatus;
    }

    public void setPassportStatus(boolean passportStatus) {
        this.passportStatus = passportStatus;
    }

    public String getPassportUploadTime() {
        return passportUploadTime;
    }

    public void setPassportUploadTime(String passportUploadTime) {
        this.passportUploadTime = passportUploadTime;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * @return the officialID
     */
    public String getOfficialID() {
        return officialID;
    }

    /**
     * @param officialID the officialID to set
     */
    public void setOfficialID(String officialID) {
        this.officialID = officialID;
    }

}
