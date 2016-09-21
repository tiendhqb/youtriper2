/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DINH KHANG
 */
public class BookingDTO {

    private String code;
    private String bookingDate;
    private String selectedDate;
    private int numberOfAdults;
    private int numberOfChilds;
    private double adultPrice;
    private double childPrice;
    private int tripperID;
    private String tripperName;
    private int packageID;
    private double packageRate;
    private int numberOfRates;
    private int providerID;
    private String providerName;
    private String packageName;
    private String packageImage;
    private String packageCountry;
    private String packageCity;
    private String packageState;
    private String packageDepartureTime;
    private double ordinaryPriceForAdult;
    private int maxQuota;
    private String paid;
    private int youTripperPercentage;
    private String packageDescription;
    private String providerImage;
    private String tripperImage;
    private String latestTime;
    private int numUnreadMessage;
    private String tripperLastName;
    private String tripperFirstName;
    private int profitPercentage;
    private int noOfPackages;

    public BookingDTO() {
    }

    public BookingDTO(String code, String bookingDate, String selectedDate, int numberOfAdults, int numberOfChilds,int noOfPackages, double adultPrice, double childPrice, int tripperID, int packageID, int providerID) {
        this.code = code;
        this.bookingDate = bookingDate;
        this.selectedDate = selectedDate;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChilds = numberOfChilds;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.tripperID = tripperID;
        this.packageID = packageID;
        this.providerID = providerID;
        this.noOfPackages = noOfPackages;
    }
//this map for booking
    public BookingDTO(String code, String bookingDate,int numberOfAdults,
            double adultPrice, String selectedDate, int noOfPackages, int tripperID, int packageID, int providerID, String packageName,
            String packageImage, String packageCountry, String packageCity, double ordinaryPriceForAdult, double packageRate,
            int numberOfRates, String providerName, String providerImage) {
        this.code = code;
        this.bookingDate = bookingDate;
        this.numberOfAdults = numberOfAdults;
        this.adultPrice = adultPrice;
        this.tripperID = tripperID;
        this.packageID = packageID;
        this.providerID = providerID;
        this.packageName = packageName;
        this.packageImage = packageImage;
        this.packageCountry = packageCountry;
        this.packageCity = packageCity;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.packageRate = packageRate;
        this.numberOfRates = numberOfRates;
        this.providerName = providerName;
        this.providerImage = providerImage;
        this.selectedDate = selectedDate;
        this.noOfPackages = noOfPackages;
    }

    public BookingDTO(String code, String bookingDate, String selectedDate, int numberOfAdults, int numberOfChilds, double adultPrice, double childPrice, int tripperID, int packageID, int providerID, String paid, int youTripperPercentage) {
        this.code = code;
        this.bookingDate = bookingDate;
        this.selectedDate = selectedDate;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChilds = numberOfChilds;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.tripperID = tripperID;
        this.packageID = packageID;
        this.providerID = providerID;
        this.paid = paid;
        this.youTripperPercentage = youTripperPercentage;
    }

    public BookingDTO(String code, String bookingDate, String selectedDate, int numberOfAdults, int numberOfChilds, double adultPrice, double childPrice, int tripperID, int packageID, int providerID, int maxQuota) {
        this.code = code;
        this.bookingDate = bookingDate;
        this.selectedDate = selectedDate;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChilds = numberOfChilds;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.tripperID = tripperID;
        this.packageID = packageID;
        this.providerID = providerID;
        this.maxQuota = maxQuota;
    }

    public BookingDTO(String code, String bookingDate, String selectedDate, int numberOfAdults, int numberOfChilds, double adultPrice, double childPrice, int tripperID, String tripperName, int packageID, int providerID, String providerName) {
        this.code = code;
        this.bookingDate = bookingDate;
        this.selectedDate = selectedDate;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChilds = numberOfChilds;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.tripperID = tripperID;
        this.tripperName = tripperName;
        this.packageID = packageID;
        this.providerID = providerID;
        this.providerName = providerName;
    }

    public BookingDTO(String code, String bookingDate, String providerName, String tripperName, String packageName, String packageImage, String providerImage, String tripperImage) {
        this.code = code;
        this.bookingDate = bookingDate;
        this.tripperName = tripperName;
        this.providerName = providerName;
        this.packageName = packageName;
        this.packageImage = packageImage;
        this.providerImage = providerImage;
        this.tripperImage = tripperImage;
    }

    public BookingDTO(String code, String bookingDate, String providerName, String tripperName, String packageName, String packageImage, String providerImage, String tripperImage, String latestTime, int numUnreadMessage) {
        this.code = code;
        this.bookingDate = bookingDate;
        this.tripperName = tripperName;
        this.providerName = providerName;
        this.packageName = packageName;
        this.packageImage = packageImage;
        this.providerImage = providerImage;
        this.tripperImage = tripperImage;
        this.latestTime = latestTime;
        this.numUnreadMessage = numUnreadMessage;
    }

    public BookingDTO(String code, String bookingDate, String providerName, String tripperName, String packageName) {
        this.code = code;
        this.bookingDate = bookingDate;
        this.tripperName = tripperName;
        this.providerName = providerName;
        this.packageName = packageName;
    }

    public BookingDTO(String bookingDate, int numberOfAdults, int numberOfChilds, double adultPrice, double childPrice, int tripperID, int packageID, String packageName, String paid, int youTripperPercentage, String tripperLastName, String tripperFirstName,int profitPercentage) {
        this.bookingDate = bookingDate;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChilds = numberOfChilds;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.tripperID = tripperID;
        this.packageID = packageID;
        this.packageName = packageName;
        this.paid = paid;
        this.youTripperPercentage = youTripperPercentage;
        this.tripperLastName = tripperLastName;
        this.tripperFirstName = tripperFirstName;
        this.profitPercentage = profitPercentage;
    }

    public BookingDTO(String selectedDate, int numberOfAdults, int numberOfChilds) {
        this.selectedDate = selectedDate;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChilds = numberOfChilds;
    }

    public BookingDTO(String code, String selectedDate, int numberOfAdults, int numberOfChilds, 
            int tripperID, String packageCountry, String packageCity, String packageState, String packageDepartureTime, 
            String tripperImage, String tripperLastName, String tripperFirstName) {
        this.code = code;
        this.selectedDate = selectedDate;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChilds = numberOfChilds;
        this.tripperID = tripperID;
        this.packageCountry = packageCountry;
        this.packageCity = packageCity;
        this.packageDepartureTime = packageDepartureTime;
        this.tripperImage = tripperImage;
        this.tripperLastName = tripperLastName;
        this.tripperFirstName = tripperFirstName;
        this.packageState = packageState;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfChilds() {
        return numberOfChilds;
    }

    public void setNumberOfChilds(int numberOfChilds) {
        this.numberOfChilds = numberOfChilds;
    }

    public double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(double adultPrice) {
        this.adultPrice = adultPrice;
    }

    public double getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(double childPrice) {
        this.childPrice = childPrice;
    }

    public int getTripperID() {
        return tripperID;
    }

    public void setTripperID(int tripperID) {
        this.tripperID = tripperID;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getTripperName() {
        return tripperName;
    }

    public void setTripperName(String tripperName) {
        this.tripperName = tripperName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getMaxQuota() {
        return maxQuota;
    }

    public void setMaxQuota(int maxQuota) {
        this.maxQuota = maxQuota;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public int getYouTripperPercentage() {
        return youTripperPercentage;
    }

    public void setYouTripperPercentage(int youTripperPercentage) {
        this.youTripperPercentage = youTripperPercentage;
    }

    public String getPackageDescription() {
        return packageDescription;
    }

    public String getPackageImage() {
        return packageImage;
    }

    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }

    public void setPackageImage(String packageImage) {
        this.packageImage = packageImage;
    }

    public double getPackageRate() {
        return packageRate;
    }

    public void setPackageRate(double packageRate) {
        this.packageRate = packageRate;
    }

    public int getNumberOfRates() {
        return numberOfRates;
    }

    public void setNumberOfRates(int numberOfRates) {
        this.numberOfRates = numberOfRates;
    }

    public String getProviderImage() {
        return providerImage;
    }

    public void setProviderImage(String providerImage) {
        this.providerImage = providerImage;
    }

    public String getPackageCountry() {
        return packageCountry;
    }

    public void setPackageCountry(String packageCountry) {
        this.packageCountry = packageCountry;
    }

    public String getPackageCity() {
        return packageCity;
    }

    public void setPackageCity(String packageCity) {
        this.packageCity = packageCity;
    }

    public double getOrdinaryPriceForAdult() {
        return ordinaryPriceForAdult;
    }

    public void setOrdinaryPriceForAdult(double ordinaryPriceForAdult) {
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
    }

    public String getTripperImage() {
        return tripperImage;
    }

    public void setTripperImage(String tripperImage) {
        this.tripperImage = tripperImage;
    }

    public String getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }

    public int getNumUnreadMessage() {
        return numUnreadMessage;
    }

    public void setNumUnreadMessage(int numUnreadMessage) {
        this.numUnreadMessage = numUnreadMessage;
    }

    public String getTripperLastName() {
        return tripperLastName;
    }

    public void setTripperLastName(String tripperLastName) {
        this.tripperLastName = tripperLastName;
    }

    public String getTripperFirstName() {
        return tripperFirstName;
    }

    public void setTripperFirstName(String tripperFirstName) {
        this.tripperFirstName = tripperFirstName;
    }

    public String getPackageDepartureTime() {
        return packageDepartureTime;
    }

    public void setPackageDepartureTime(String packageDepartureTime) {
        this.packageDepartureTime = packageDepartureTime;
    }

    public String getPackageState() {
        return packageState;
    }

    public void setPackageState(String packageState) {
        this.packageState = packageState;
    }

    public int getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(int profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

    public int getNoOfPackages() {
        return noOfPackages;
    }

    public void setNoOfPackages(int noOfPackages) {
        this.noOfPackages = noOfPackages;
    }
    
}
