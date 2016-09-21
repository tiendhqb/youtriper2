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
public class VersionPackageDTO {

    private int id;
    private int providerID;
    private String providerName;
    private String providerInformation;
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
    private String promotionJson;
    private double rate;
    private int numberOfRates;
    private List<AmenitiesDTO> listAmenities;
    private List<ActivityDTO> activites;
    private List<TransportationDTO> transporations;
    private List<CategoryDTO> categories;
    private List<GroupTypeDTO> groupTypes;
    private List<TripTypeDTO> tripTypes;
    private List<ReviewDTO> reviews;
    private List<BookingDTO> listBooking;
    private int totalRecords;
    private String providerImage;
    private int temporaryPackageID;

    public VersionPackageDTO() {
    }

    public VersionPackageDTO(int id, int providerID, String providerName, String name, int durationType, int duration, int minTripper, int maxTripper, String language, String coverImage, String images, String startDate, String endDate, String unavailableDays, String country, String city, String state, String coordinates, String included, String excluded, double ordinaryPriceForChild, double ordinaryPriceForAdult, int youtripperPercentage, String keywords, String departureLocation, String departureTime, String googleDescription, String mainDescription, String promotionJson, double rate, int numberOfRates, List<AmenitiesDTO> listAmenities, List<ActivityDTO> activites, List<TransportationDTO> transporations, List<GroupTypeDTO> groupTypes, List<TripTypeDTO> tripTypes) {
        this.id = id;
        this.providerID = providerID;
        this.providerName = providerName;
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
        this.promotionJson = promotionJson;
        this.rate = rate;
        this.numberOfRates = numberOfRates;
        this.listAmenities = listAmenities;
        this.activites = activites;
        this.transporations = transporations;
        this.groupTypes = groupTypes;
        this.tripTypes = tripTypes;
    }

    public VersionPackageDTO(int id, int providerID, String providerName, String name, String coverImage, double ordinaryPriceForAdult, double rate, int numberOfRates) {
        this.id = id;
        this.providerID = providerID;
        this.providerName = providerName;
        this.name = name;
        this.coverImage = coverImage;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.rate = rate;
        this.numberOfRates = numberOfRates;
    }

    public VersionPackageDTO(int id, int providerID, String providerName, String providerInformation, String name, int durationType, int duration, int minTripper, int maxTripper, String language, String coverImage, String images, String startDate, String endDate, String unavailableDays, String country, String city, String state, String coordinates, String included, String excluded, double ordinaryPriceForChild, double ordinaryPriceForAdult, String keywords, String departureLocation, String departureTime, String googleDescription, String mainDescription, String promotionJson, double rate, int numberOfRates, List<AmenitiesDTO> listAmenities, List<TransportationDTO> transporations, List<CategoryDTO> categories) {
        this.id = id;
        this.providerID = providerID;
        this.providerName = providerName;
        this.providerInformation = providerInformation;
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
        this.keywords = keywords;
        this.departureLocation = departureLocation;
        this.departureTime = departureTime;
        this.googleDescription = googleDescription;
        this.mainDescription = mainDescription;
        this.promotionJson = promotionJson;
        this.rate = rate;
        this.numberOfRates = numberOfRates;
        this.listAmenities = listAmenities;
        this.transporations = transporations;
        this.categories = categories;
    }

    public VersionPackageDTO(int id, int providerID, String providerName, String providerInformation, String name, int durationType,
            int duration, int minTripper, int maxTripper, String language, String coverImage, String images,
            String startDate, String endDate, String unavailableDays, String country, String city, String state,
            String coordinates, String included, String excluded, double ordinaryPriceForChild, double ordinaryPriceForAdult,
            String keywords, String departureLocation, String departureTime, String googleDescription, String mainDescription,
            String promotionJson, double rate, int numberOfRates, String providerImage, int temporaryPackageID) {
        this.id = id;
        this.providerID = providerID;
        this.providerName = providerName;
        this.providerInformation = providerInformation;
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
        this.keywords = keywords;
        this.departureLocation = departureLocation;
        this.departureTime = departureTime;
        this.googleDescription = googleDescription;
        this.mainDescription = mainDescription;
        this.promotionJson = promotionJson;
        this.rate = rate;
        this.numberOfRates = numberOfRates;
        this.providerImage = providerImage;
        this.temporaryPackageID = temporaryPackageID;
    }

    public VersionPackageDTO(int id, int providerID, String providerName, String providerInformation, String name, int durationType, int duration, int minTripper, int maxTripper, String language, String coverImage, String images, String startDate, String endDate, String unavailableDays, String country, String city, String state, String coordinates, String included, String excluded, double ordinaryPriceForChild, double ordinaryPriceForAdult, String keywords, String departureLocation, String departureTime, String googleDescription, String mainDescription, String promotionJson, double rate, int numberOfRates, int totalRecords) {
        this.id = id;
        this.providerID = providerID;
        this.providerName = providerName;
        this.providerInformation = providerInformation;
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
        this.keywords = keywords;
        this.departureLocation = departureLocation;
        this.departureTime = departureTime;
        this.googleDescription = googleDescription;
        this.mainDescription = mainDescription;
        this.promotionJson = promotionJson;
        this.rate = rate;
        this.numberOfRates = numberOfRates;
        this.totalRecords = totalRecords;
    }

    public VersionPackageDTO(int id, String name, int minTripper, int maxTripper, String coverImage, String startDate, String endDate, String unavailableDays, String country, String city, String state, double ordinaryPriceForChild, double ordinaryPriceForAdult, String departureLocation, String departureTime, String promotionJson, int providerID) {
        this.id = id;
        this.name = name;
        this.minTripper = minTripper;
        this.maxTripper = maxTripper;
        this.coverImage = coverImage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.unavailableDays = unavailableDays;
        this.country = country;
        this.city = city;
        this.state = state;
        this.ordinaryPriceForChild = ordinaryPriceForChild;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.departureLocation = departureLocation;
        this.departureTime = departureTime;
        this.promotionJson = promotionJson;
        this.providerID = providerID;
    }

    public VersionPackageDTO(int id, int providerID, String name, int durationType, int duration, int minTripper, int maxTripper, String language, String coverImage, String images, String startDate, String endDate, String unavailableDays, String country, String city, String state, String coordinates, String included, String excluded, double ordinaryPriceForChild, double ordinaryPriceForAdult, String keywords, String departureLocation, String departureTime, String googleDescription, String mainDescription, String promotionJson, double rate, int numberOfRates) {
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
        this.keywords = keywords;
        this.departureLocation = departureLocation;
        this.departureTime = departureTime;
        this.googleDescription = googleDescription;
        this.mainDescription = mainDescription;
        this.promotionJson = promotionJson;
        this.rate = rate;
        this.numberOfRates = numberOfRates;
    }

    public VersionPackageDTO(int durationType, int duration, int minTripper, int maxTripper, String country, String city, String state, String included, String excluded, String googleDescription) {
        this.durationType = durationType;
        this.duration = duration;
        this.minTripper = minTripper;
        this.maxTripper = maxTripper;
        this.country = country;
        this.city = city;
        this.state = state;
        this.included = included;
        this.excluded = excluded;
        this.googleDescription = googleDescription;
    }

    public VersionPackageDTO(int id, String name, int maxTripper, List<BookingDTO> listBooking) {
        this.id = id;
        this.name = name;
        this.maxTripper = maxTripper;
        this.listBooking = listBooking;
    }

    public VersionPackageDTO(int id, int providerID, String providerName, String name, String coverImage, double ordinaryPriceForAdult, int numberOfRates, String providerImage) {
        this.id = id;
        this.providerID = providerID;
        this.providerName = providerName;
        this.name = name;
        this.coverImage = coverImage;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.numberOfRates = numberOfRates;
        this.providerImage = providerImage;
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

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderInformation() {
        return providerInformation;
    }

    public void setProviderInformation(String providerInformation) {
        this.providerInformation = providerInformation;
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

    public String getPromotionJson() {
        return promotionJson;
    }

    public void setPromotionJson(String promotionJson) {
        this.promotionJson = promotionJson;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getNumberOfRates() {
        return numberOfRates;
    }

    public void setNumberOfRates(int numberOfRates) {
        this.numberOfRates = numberOfRates;
    }

    public List<AmenitiesDTO> getListAmenities() {
        return listAmenities;
    }

    public void setListAmenities(List<AmenitiesDTO> listAmenities) {
        this.listAmenities = listAmenities;
    }

    public List<ActivityDTO> getActivites() {
        return activites;
    }

    public void setActivites(List<ActivityDTO> activites) {
        this.activites = activites;
    }

    public List<TransportationDTO> getTransporations() {
        return transporations;
    }

    public void setTransporations(List<TransportationDTO> transporations) {
        this.transporations = transporations;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    public List<GroupTypeDTO> getGroupTypes() {
        return groupTypes;
    }

    public void setGroupTypes(List<GroupTypeDTO> groupTypes) {
        this.groupTypes = groupTypes;
    }

    public List<TripTypeDTO> getTripTypes() {
        return tripTypes;
    }

    public void setTripTypes(List<TripTypeDTO> tripTypes) {
        this.tripTypes = tripTypes;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewDTO> reviews) {
        this.reviews = reviews;
    }

    public List<BookingDTO> getListBooking() {
        return listBooking;
    }

    public void setListBooking(List<BookingDTO> listBooking) {
        this.listBooking = listBooking;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public String getProviderImage() {
        return providerImage;
    }

    public void setProviderImage(String providerImage) {
        this.providerImage = providerImage;
    }

    public int getTemporaryPackageID() {
        return temporaryPackageID;
    }

    public void setTemporaryPackageID(int temporaryPackageID) {
        this.temporaryPackageID = temporaryPackageID;
    }
    
}
