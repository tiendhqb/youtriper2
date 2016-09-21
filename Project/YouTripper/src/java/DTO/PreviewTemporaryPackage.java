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
public class PreviewTemporaryPackage {
    private int id;
    private int providerID;
    private String name;
    private int durationType;
    private int duration;
    private int minTripper;
    private int maxTripper;
    private String language;
    private String coverImage;
    private String images;
    private String startDate;
    private String endDate;
    private String unavailableDays;
    private String country;
    private String city;
    private String state;
    private String coordinates;
    private String included;
    private String excluded;
    private double ordinaryPriceForChild;
    private double ordinaryPriceForAdult;
    private int youtripperPercentage;
    private String keywords;
    private String departureLocation;
    private String departureTime;
    private String googleDescription;
    private String mainDescription;
    private boolean isFinshed;
    private String promotionJson;
    private String[] listAmenities;
    private List<TransportationDTO> transporations;
    private String[] categories;

    public PreviewTemporaryPackage() {
    }

    public PreviewTemporaryPackage(int id, int providerID, String name, int durationType, int duration, int minTripper, int maxTripper, String language, String coverImage, String images, String startDate, String endDate, String unavailableDays, String country, String city, String state, String coordinates, String included, String excluded, double ordinaryPriceForChild, double ordinaryPriceForAdult, int youtripperPercentage, String keywords, String departureLocation, String departureTime, String googleDescription, String mainDescription, boolean isFinshed, String promotionJson, String[] listAmenities, List<TransportationDTO> transporations, String[] categories) {
        this.id = id;
        this.providerID = providerID;
        this.name = name;
        this.durationType = durationType;
        this.duration = duration;
        this.minTripper = minTripper;
        this.maxTripper = maxTripper;
        this.language = language;
        this.coverImage = coverImage;
        this.images = images;
        this.startDate = startDate;
        this.endDate = endDate;
        this.unavailableDays = unavailableDays;
        this.country = country;
        this.city = city;
        this.state = state;
        this.coordinates = coordinates;
        this.included = included;
        this.excluded = excluded;
        this.ordinaryPriceForChild = ordinaryPriceForChild;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.youtripperPercentage = youtripperPercentage;
        this.keywords = keywords;
        this.departureLocation = departureLocation;
        this.departureTime = departureTime;
        this.googleDescription = googleDescription;
        this.mainDescription = mainDescription;
        this.isFinshed = isFinshed;
        this.promotionJson = promotionJson;
        this.listAmenities = listAmenities;
        this.transporations = transporations;
        this.categories = categories;
    }

    public PreviewTemporaryPackage(int id, int providerID, String name, int durationType, int duration, int minTripper, int maxTripper, String language, String coverImage, String images, String startDate, String endDate, String unavailableDays, String country, String city, String state, String coordinates, String included, String excluded, double ordinaryPriceForChild, double ordinaryPriceForAdult, int youtripperPercentage, String keywords, String departureLocation, String departureTime, String googleDescription, String mainDescription, boolean isFinshed, String promotionJson) {
        this.id = id;
        this.providerID = providerID;
        this.name = name;
        this.durationType = durationType;
        this.duration = duration;
        this.minTripper = minTripper;
        this.maxTripper = maxTripper;
        this.language = language;
        this.coverImage = coverImage;
        this.images = images;
        this.startDate = startDate;
        this.endDate = endDate;
        this.unavailableDays = unavailableDays;
        this.country = country;
        this.city = city;
        this.state = state;
        this.coordinates = coordinates;
        this.included = included;
        this.excluded = excluded;
        this.ordinaryPriceForChild = ordinaryPriceForChild;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.youtripperPercentage = youtripperPercentage;
        this.keywords = keywords;
        this.departureLocation = departureLocation;
        this.departureTime = departureTime;
        this.googleDescription = googleDescription;
        this.mainDescription = mainDescription;
        this.isFinshed = isFinshed;
        this.promotionJson = promotionJson;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
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

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUnavailableDays() {
        return unavailableDays;
    }

    public void setUnavailableDays(String unavailableDays) {
        this.unavailableDays = unavailableDays;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getIncluded() {
        return included;
    }

    public void setIncluded(String included) {
        this.included = included;
    }

    public String getExcluded() {
        return excluded;
    }

    public void setExcluded(String excluded) {
        this.excluded = excluded;
    }

    public double getOrdinaryPriceForChild() {
        return ordinaryPriceForChild;
    }

    public void setOrdinaryPriceForChild(double ordinaryPriceForChild) {
        this.ordinaryPriceForChild = ordinaryPriceForChild;
    }

    public double getOrdinaryPriceForAdult() {
        return ordinaryPriceForAdult;
    }

    public void setOrdinaryPriceForAdult(double ordinaryPriceForAdult) {
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
    }

    public int getYoutripperPercentage() {
        return youtripperPercentage;
    }

    public void setYoutripperPercentage(int youtripperPercentage) {
        this.youtripperPercentage = youtripperPercentage;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
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

    public boolean isIsFinshed() {
        return isFinshed;
    }

    public void setIsFinshed(boolean isFinshed) {
        this.isFinshed = isFinshed;
    }

    public String getPromotionJson() {
        return promotionJson;
    }

    public void setPromotionJson(String promotionJson) {
        this.promotionJson = promotionJson;
    }

    public String[] getListAmenities() {
        return listAmenities;
    }

    public void setListAmenities(String[] listAmenities) {
        this.listAmenities = listAmenities;
    }

    public List<TransportationDTO> getTransporations() {
        return transporations;
    }

    public void setTransporations(List<TransportationDTO> transporations) {
        this.transporations = transporations;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }
    
    
}
