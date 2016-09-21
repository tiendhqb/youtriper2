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
public class TemporaryPackageDTOv2 {

    private int id;
    private int providerID;
    private String providerName;
    private String name;
    private String durationType;
    private int duration;
    private Integer minTripper;
    private Integer maxTripper;
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
    private boolean isFinshed;
    private String promotionJson;
    private List<AmenitiesDTO> listAmenities;
    private List<ActivityDTO> activites;
    private List<TransportationDTO> transporations;
    private String profitPercentage;
    private boolean isPrivateTour;
    private double coverPosition;
    private List<LanguageDTO> languageList;

    // new AmenitiesClassifier
    private List<TemporaryAmenitiesClassifierDTO> amenitiesClassifiers;

    private int groupID;
    private int tripID;

    private String packageAddress;

    private String additionalAddress;

    private List<TemporaryClassifierDTO> temporaryClassifiers;

    private List<TemporarySuitabilityClassifierDTO> temporarySuitabiltyClassifiers;

    private List<TemporaryTransoprtationWayDTO> temporaryTransportations;

    private double vat;
    private double ytComission;
    private double ytComissionVAT;

    private int certificateID;

    private String advancedPriceChild;
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
    private String nonEnglishDescription;
    private String packageColor;

    public TemporaryPackageDTOv2(int id, int providerID, String name, String durationType, int duration, int minTripper, int maxTripper,
            String language, String coverImage, String images, String startDate, String endDate, String unavailableDays, String country,
            String city, String state, String coordinates, String included, String excluded, double ordinaryPriceForChild,
            double ordinaryPriceForAdult, int youtripperPercentage, String keywords, String departureLocation, String departureTime,
            String googleDescription, String mainDescription, List<AdditionalDescriptionDTO> additionalDescription, boolean isFinshed, String promotionJson, String profitPercentage,
            String packageType, int groupID, int tripID, String packageAddress, String additionalAddress, double coverPosition,
            double VAT, double ytComission, double ytComissionVAT, int certificateID, String advancedPriceChild, String cancellation, int sequentialOperation,
            int resourceID,int minimumResources,String startOperationTime,String endOperationTime,boolean isFreeBooking,int freeInterval,int fixedHour,int fixedMinute,String nonEnglishDescription,
            String packageColor) {
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
        this.additionalDescription = additionalDescription;
        this.isFinshed = isFinshed;
        this.promotionJson = promotionJson;
        this.profitPercentage = profitPercentage;
        this.packageType = packageType;
        this.groupID = groupID;
        this.tripID = tripID;
        this.packageAddress = packageAddress;
        this.additionalAddress = additionalAddress;
        this.coverPosition = coverPosition;
        this.vat = VAT;
        this.ytComission = ytComission;
        this.ytComissionVAT = ytComissionVAT;
        this.certificateID = certificateID;
        this.advancedPriceChild = advancedPriceChild;
        this.cancellation = cancellation;
        this.sequentialOperation = sequentialOperation;
        this.resourceID = resourceID;
        this.minimumResources = minimumResources;
        this.startOperationTime = startOperationTime;
        this.endOperationTime = endOperationTime;
        this.isFreeBooking = isFreeBooking;
        this.freeInterval = freeInterval;
        this.fixedHour = fixedHour;
        this.fixedMinute = fixedMinute;
        this.nonEnglishDescription = nonEnglishDescription;
        this.packageColor = packageColor;
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

    public Integer getMinTripper() {
        return minTripper;
    }

    public void setMinTripper(Integer minTripper) {
        this.minTripper = minTripper;
    }

    public Integer getMaxTripper() {
        return maxTripper;
    }

    public void setMaxTripper(Integer maxTripper) {
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

    public String getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(String profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

    public boolean isIsPrivateTour() {
        return isPrivateTour;
    }

    public void setIsPrivateTour(boolean isPrivateTour) {
        this.isPrivateTour = isPrivateTour;
    }

    public double getCoverPosition() {
        return coverPosition;
    }

    public void setCoverPosition(double coverPosition) {
        this.coverPosition = coverPosition;
    }

    public List<LanguageDTO> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<LanguageDTO> languageList) {
        this.languageList = languageList;
    }

    public List<TemporaryAmenitiesClassifierDTO> getAmenitiesClassifiers() {
        return amenitiesClassifiers;
    }

    public void setAmenitiesClassifiers(List<TemporaryAmenitiesClassifierDTO> amenitiesClassifiers) {
        this.amenitiesClassifiers = amenitiesClassifiers;
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

    public String getPackageAddress() {
        return packageAddress;
    }

    public void setPackageAddress(String packageAddress) {
        this.packageAddress = packageAddress;
    }

    public String getAdditionalAddress() {
        return additionalAddress;
    }

    public void setAdditionalAddress(String additionalAddress) {
        this.additionalAddress = additionalAddress;
    }

    public List<TemporaryClassifierDTO> getTemporaryClassifiers() {
        return temporaryClassifiers;
    }

    public void setTemporaryClassifiers(List<TemporaryClassifierDTO> temporaryClassifiers) {
        this.temporaryClassifiers = temporaryClassifiers;
    }

    public List<TemporarySuitabilityClassifierDTO> getTemporarySuitabiltyClassifiers() {
        return temporarySuitabiltyClassifiers;
    }

    public void setTemporarySuitabiltyClassifiers(List<TemporarySuitabilityClassifierDTO> temporarySuitabiltyClassifiers) {
        this.temporarySuitabiltyClassifiers = temporarySuitabiltyClassifiers;
    }

    public List<TemporaryTransoprtationWayDTO> getTemporaryTransportations() {
        return temporaryTransportations;
    }

    public void setTemporaryTransportations(List<TemporaryTransoprtationWayDTO> temporaryTransportations) {
        this.temporaryTransportations = temporaryTransportations;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getYtComission() {
        return ytComission;
    }

    public void setYtComission(double ytComission) {
        this.ytComission = ytComission;
    }

    public double getYtComissionVAT() {
        return ytComissionVAT;
    }

    public void setYtComissionVAT(double ytComissionVAT) {
        this.ytComissionVAT = ytComissionVAT;
    }

    public int getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(int certificateID) {
        this.certificateID = certificateID;
    }

    public String getAdvancedPriceChild() {
        return advancedPriceChild;
    }

    public void setAdvancedPriceChild(String advancedPriceChild) {
        this.advancedPriceChild = advancedPriceChild;
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

    public boolean isIsFreeBooking() {
        return isFreeBooking;
    }

    public void setIsFreeBooking(boolean isFreeBooking) {
        this.isFreeBooking = isFreeBooking;
    }

    public String getNonEnglishDescription() {
        return nonEnglishDescription;
    }

    public void setNonEnglishDescription(String nonEnglishDescription) {
        this.nonEnglishDescription = nonEnglishDescription;
    }

    public String getPackageColor() {
        return packageColor;
    }

    public void setPackageColor(String packageColor) {
        this.packageColor = packageColor;
    }


}
