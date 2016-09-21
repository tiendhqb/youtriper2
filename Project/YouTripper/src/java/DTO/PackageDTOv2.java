/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.List;

/**
 *
 * @author DINH KHANG
 */
public class PackageDTOv2 {

    private int id;
    private int providerID;
    private String providerName;
    private String providerInformation;
    private String name;
    private String durationType;
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
    private List<AdditionalDescriptionDTO> additionalDescription;
    private String promotionJson;
    private double rate;
    private int numberOfRates;
    private List<AmenitiesDTO> listAmenities;
    private List<ActivityDTO> activites;
    private List<TransportationDTO> transporations;
    private List<CategoryDTO> categories;
    private List<ReviewDTO> reviews;
    private List<BookingDTO> listBooking;
    private int totalRecords;
    private String providerImage;

    private int professionlism;
    private int staffAttitude;
    private int convenient;
    private int satisfaction;
    private int amenityQuality;
    private int cleanliness;
    private String categoryName;
    private int noOfClicks;

    private int profitPercentage;

    private boolean isPrivateTour;

    private int groupID;
    private int tripID;

    private List<AmenitiesClassifierDTO> amenitiesClassifiers;

    private String additionalDescriptionStr;

    private double coverPosition;
    private String packageType;
    private String cancellation;
    private int sequentialOperation;
    private int resourceID;
    private int minimumResources;
    private String startOperationTime;
    private String endOperationTime;
    private boolean isFreeBooking;
    private int freeInterval;
    private int fixedHour;
    private int fixedMinute;

    private String activityName;
    private String subCategoryName;

    public PackageDTOv2(int id, int providerID, String providerName, String name, String coverImage, String country, String city, double ordinaryPriceForAdult, String keywords, double rate, int numberOfRates, String providerImage) {
        this.id = id;
        this.providerID = providerID;
        this.providerName = providerName;
        this.name = name;
        this.coverImage = coverImage;
        this.country = country;
        this.city = city;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.keywords = keywords;
        this.rate = rate;
        this.numberOfRates = numberOfRates;
        this.providerImage = providerImage;
    }    
    
    public PackageDTOv2(int id, int providerID, String providerName, String providerInformation, String name, String durationType,
            int duration, int minTripper, int maxTripper, String language, String coverImage, String images,
            String startDate, String endDate, String unavailableDays, String country, String city, String state,
            String coordinates, String included, String excluded, double ordinaryPriceForChild, double ordinaryPriceForAdult,
            String keywords, String departureLocation, String departureTime, String googleDescription, String mainDescription,
            String promotionJson, double rate, int numberOfRates, String providerImage, int youtripperPercentage,String packageType, double coverPosition) {
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
        this.packageType = packageType;
        this.youtripperPercentage = youtripperPercentage;
        this.coverPosition = coverPosition;       
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

    public String getDurationType() {
        return durationType;
    }

    public void setDurationType(String durationType) {
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

    public List<AdditionalDescriptionDTO> getAdditionalDescription() {
        return additionalDescription;
    }

    public void setAdditionalDescription(List<AdditionalDescriptionDTO> additionalDescription) {
        this.additionalDescription = additionalDescription;
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

    public int getProfessionlism() {
        return professionlism;
    }

    public void setProfessionlism(int professionlism) {
        this.professionlism = professionlism;
    }

    public int getStaffAttitude() {
        return staffAttitude;
    }

    public void setStaffAttitude(int staffAttitude) {
        this.staffAttitude = staffAttitude;
    }

    public int getConvenient() {
        return convenient;
    }

    public void setConvenient(int convenient) {
        this.convenient = convenient;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public int getAmenityQuality() {
        return amenityQuality;
    }

    public void setAmenityQuality(int amenityQuality) {
        this.amenityQuality = amenityQuality;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getNoOfClicks() {
        return noOfClicks;
    }

    public void setNoOfClicks(int noOfClicks) {
        this.noOfClicks = noOfClicks;
    }

    public int getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(int profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

    public boolean isIsPrivateTour() {
        return isPrivateTour;
    }

    public void setIsPrivateTour(boolean isPrivateTour) {
        this.isPrivateTour = isPrivateTour;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public List<AmenitiesClassifierDTO> getAmenitiesClassifiers() {
        return amenitiesClassifiers;
    }

    public void setAmenitiesClassifiers(List<AmenitiesClassifierDTO> amenitiesClassifiers) {
        this.amenitiesClassifiers = amenitiesClassifiers;
    }

    public String getAdditionalDescriptionStr() {
        return additionalDescriptionStr;
    }

    public void setAdditionalDescriptionStr(String additionalDescriptionStr) {
        this.additionalDescriptionStr = additionalDescriptionStr;
    }

    public double getCoverPosition() {
        return coverPosition;
    }

    public void setCoverPosition(double coverPosition) {
        this.coverPosition = coverPosition;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getCancellation() {
        return cancellation;
    }

    public void setCancellation(String cancellation) {
        this.cancellation = cancellation;
    }

    public int getSequentialOperation() {
        return sequentialOperation;
    }

    public void setSequentialOperation(int sequentialOperation) {
        this.sequentialOperation = sequentialOperation;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public int getMinimumResources() {
        return minimumResources;
    }

    public void setMinimumResources(int minimumResources) {
        this.minimumResources = minimumResources;
    }

    public String getStartOperationTime() {
        return startOperationTime;
    }

    public void setStartOperationTime(String startOperationTime) {
        this.startOperationTime = startOperationTime;
    }

    public String getEndOperationTime() {
        return endOperationTime;
    }

    public void setEndOperationTime(String endOperationTime) {
        this.endOperationTime = endOperationTime;
    }

    public boolean isIsFreeBooking() {
        return isFreeBooking;
    }

    public void setIsFreeBooking(boolean isFreeBooking) {
        this.isFreeBooking = isFreeBooking;
    }

    public int getFreeInterval() {
        return freeInterval;
    }

    public void setFreeInterval(int freeInterval) {
        this.freeInterval = freeInterval;
    }

    public int getFixedHour() {
        return fixedHour;
    }

    public void setFixedHour(int fixedHour) {
        this.fixedHour = fixedHour;
    }

    public int getFixedMinute() {
        return fixedMinute;
    }

    public void setFixedMinute(int fixedMinute) {
        this.fixedMinute = fixedMinute;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

}
