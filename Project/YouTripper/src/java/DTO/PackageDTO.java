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
public class PackageDTO {

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

    private int coverPosition;
    private double lat;
    private double lng;
    private String packageType;
    private String advancedChildPrice;
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
    private String PackageColor;

    private String activityName;
    private String subCategoryName;
    private int popularity;
    private int noOfSelling;
    private String categoryIcon;

    private List<UsedResourcesViewDTO> usedResources;
    private int ytCommission;
    private int maximumCapacity;

    private int noCancellationPercent;
    private String cancellationName;
    private String cancellationConditions;

    private int readyBookingDuration;
    private String readyBookingDurationType;

    private List<OthersLanguageDescriptionDTO> othersLanguageDescription;
    private List<PackageCertificateDTO> certificates;
    private List<AdditionImageDTO> additionImages;
    private List<OperationCycleDTO> operationCycles;
    private List<DisabledDiscountDTO> disabledDiscounts;
    private List<ChildrenDiscountDTO> childrenDiscounts;
    private List<SuitabilityDTO> suitabilities;
    private List<AmenitiesClassifierDTO> amenitiesClassifier;
    private List<TransportationDTO> transportation;
    private List<OthersLanguageDescriptionDTO> languageDescriptionList;
    private List<SuitabilityClassifierDTO> suitabilityClassifiers;

    private int adventureLevel;
    private int challengeLevel;
    private int friendshipLevel;
    private int happinessLevel;
    private int healthinessLevel;
    private int knowledgeLevel;
    private int peacefulnessLevel;
    private int romanceLevel;
    private int sophisticationLevel;
    private int unexpectedLevel;

    private double vat;
    private double ytComission;
    private double ytComissionVAT;
    private int colorID;
    private int servingPeriodID;
    private int targetCountryID;

    private String otherSubCategoryName;
    private String otherActivityName;
    private int categoryID;
    private int cancellationID;
    private boolean isRunning;
    private List<ClassifierDTO> classifiers;
    private int durationDay;
    private int durationHour;
    private int durationMinute;
    private boolean isEditing;
    private int restingtimeDay;
    private int restingtimeHour;
    private int restingtimeMinute;

    private boolean isUsingMaxQuota;
    private int maxQuota;
    private String quotaType;

    private String childrenDiscountJson;
    private String cancellationPolicyJson;
    private int durationMonth;
    private int durationYear;
    
    private double youtripperPrice;
    private String priceCurrency;

    private boolean isSpecificLaunchDate;
    private boolean isExceptSunday;
    private boolean isExceptMonday;
    private boolean isExceptTuesday;
    private boolean isExceptWednesday;
    private boolean isExceptThursday;
    private boolean isExceptFriday;
    private boolean isExceptSaturday;
    private boolean isWorkingEveryday;

    public PackageDTO() {
    }

    public PackageDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PackageDTO(int id, int providerID, String providerName, String name, String coverImage, String country, String city, double ordinaryPriceForAdult, String keywords, double rate, int numberOfRates, String providerImage, String categoryIcon) {
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
        this.categoryIcon = categoryIcon;
    }

    public PackageDTO(int id, int providerID, String providerName, String name, String durationType, int duration, int minTripper, int maxTripper, String coverImage, String city, double ordinaryPriceForAdult, double rate, int numberOfRates, int noOfClicks, String categoryName, String providerImage) {
        this.id = id;
        this.providerID = providerID;
        this.providerName = providerName;
        this.name = name;
        this.durationType = durationType;
        this.duration = duration;
        this.minTripper = minTripper;
        this.maxTripper = maxTripper;
        this.coverImage = coverImage;
        this.city = city;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.rate = rate;
        this.numberOfRates = numberOfRates;
        this.noOfClicks = noOfClicks;
        this.categoryName = categoryName;
        this.providerImage = providerImage;
    }

    public PackageDTO(int id, int providerID, String providerName, String name, String durationType, int duration, int minTripper, int maxTripper, String language, String coverImage, String images, String startDate, String endDate, String unavailableDays, String country, String city, String state, String coordinates, String included, String excluded, double ordinaryPriceForChild, double ordinaryPriceForAdult, int youtripperPercentage, String keywords, String departureLocation, String departureTime, String googleDescription, String mainDescription, String promotionJson, double rate, int numberOfRates, List<AmenitiesDTO> listAmenities, List<ActivityDTO> activites, List<TransportationDTO> transporations, List<GroupTypeDTO> groupTypes, List<TripTypeDTO> tripTypes) {
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
    }

    public PackageDTO(int id, String name, String coverImage, double ordinaryPriceForAdult, int professionlism, int staffAttitude, int convenient, int satisfaction, int amenityQuality, int cleanliness) {
        this.id = id;
        this.name = name;
        this.coverImage = coverImage;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.professionlism = professionlism;
        this.staffAttitude = staffAttitude;
        this.convenient = convenient;
        this.satisfaction = satisfaction;
        this.amenityQuality = amenityQuality;
        this.cleanliness = cleanliness;
    }

    public PackageDTO(int id, int providerID, String providerName, String name, String coverImage, double ordinaryPriceForAdult, double rate, int numberOfRates) {
        this.id = id;
        this.providerID = providerID;
        this.providerName = providerName;
        this.name = name;
        this.coverImage = coverImage;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.rate = rate;
        this.numberOfRates = numberOfRates;
    }

    public PackageDTO(int id, int providerID, String providerName, String providerInformation, String name, String durationType, int duration, int minTripper, int maxTripper, String language, String coverImage, String images, String startDate, String endDate, String unavailableDays, String country, String city, String state, String coordinates, String included, String excluded, double ordinaryPriceForChild, double ordinaryPriceForAdult, String keywords, String departureLocation, String departureTime, String googleDescription, String mainDescription, String promotionJson, double rate, int numberOfRates, List<AmenitiesDTO> listAmenities, List<TransportationDTO> transporations, List<CategoryDTO> categories) {
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

    public PackageDTO(int id, int providerID, String providerName, String providerInformation, String name, String durationType,
            int duration, int minTripper, int maxTripper, String language, String coverImage, String images,
            String startDate, String endDate, String unavailableDays, String country, String city, String state,
            String coordinates, String included, String excluded, double ordinaryPriceForChild, double ordinaryPriceForAdult,
            String keywords, String departureLocation, String departureTime, String googleDescription, String mainDescription,
            String promotionJson, double rate, int numberOfRates, String providerImage, int youtripperPercentage, String packageType, int coverPostion,
            String advancedChildPrice, String cancellation, int sequentialOperation, int resourceID, int minimumResources, String startOperationTime,
            String endOperationTime, boolean isFreeBooking, int freeInterval, int fixedHour, int fixedMinute, String nonEnglishDescription) {
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
        this.advancedChildPrice = advancedChildPrice;
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
    }

    public PackageDTO(int id, int providerID, String providerName, String providerInformation, String name, String durationType, int duration, int minTripper, int maxTripper, String language, String coverImage, String images, String startDate, String endDate, String unavailableDays, String country, String city, String state, String coordinates, String included, String excluded, double ordinaryPriceForChild, double ordinaryPriceForAdult, String keywords, String departureLocation, String departureTime, String googleDescription, String mainDescription, String promotionJson, double rate, int numberOfRates, int totalRecords) {
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

    public PackageDTO(int id, String name, int minTripper, int maxTripper, String coverImage, String startDate, String endDate, String unavailableDays,
            String country, String city, String state, double ordinaryPriceForAdult
            , String promotionJson, int providerID, int youtripperPercentage) {
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
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.departureTime = departureTime;
        this.promotionJson = promotionJson;
        this.providerID = providerID;
        this.youtripperPercentage = youtripperPercentage;

    }

    public PackageDTO(int id, int providerID, String name, String durationType, int duration, int minTripper, int maxTripper, String language, String coverImage, String images, String startDate, String endDate, String unavailableDays, String country, String city, String state, String coordinates, String included, String excluded, double ordinaryPriceForChild, double ordinaryPriceForAdult, String keywords, String departureLocation, String departureTime, String googleDescription, String mainDescription, String promotionJson, double rate, int numberOfRates) {
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

    public PackageDTO(String durationType, int duration, int minTripper, int maxTripper, String country, String city, String state, String included, String excluded, String googleDescription) {
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

    public PackageDTO(int id, String name, int maxTripper, List<BookingDTO> listBooking) {
        this.id = id;
        this.name = name;
        this.maxTripper = maxTripper;
        this.listBooking = listBooking;
    }

    public PackageDTO(int id, int providerID, String providerName, String name, String coverImage, double ordinaryPriceForAdult, int numberOfRates, String providerImage) {
        this.id = id;
        this.providerID = providerID;
        this.providerName = providerName;
        this.name = name;
        this.coverImage = coverImage;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.numberOfRates = numberOfRates;
        this.providerImage = providerImage;
    }

    public PackageDTO(int id, int providerID, String name, String durationType, int duration, Integer minTripper,
            Integer maxTripper, String language, String coverImage, String images, String startDate, String endDate, String unavailableDays,
            String country, String city, String state, double ordinaryPriceForAdult, int youtripperPercentage, String keywords,
            String mainDescription, String promotionJson, int profitPercentage, int coverPosition, double lat, double lng,
            int groupID, int tripID, double vat, double ytComission, double ytComissionVAT, String packageType,
            int sequentialOperation, int resourceID, int minimumResources, boolean isFreeBooking, int freeInterval, int fixedHour,
            int fixedMinute, int colorID, int adventureLevel, int challengeLevel, int friendshipLevel, int happinessLevel, int healthinessLevel,
            int knowledgeLevel, int peacefulnessLevel, int romanceLevel, int sophisticationLevel, int unexpectedLevel, int servingPeriodID,
            int targetCountryID, String otherSubCategoryName, int categoryID, int cancellationID, int noCancellationPercent, boolean isRunning,
            int readyBookingDuration, String readyBookingDurationType, int durationDay, int durationHour, int durationMinute, boolean isEditing) {
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
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.youtripperPercentage = youtripperPercentage;
        this.keywords = keywords;
        this.mainDescription = mainDescription;
        this.promotionJson = promotionJson;
        this.profitPercentage = profitPercentage;
        this.coverPosition = coverPosition;
        this.lat = lat;
        this.lng = lng;
        this.groupID = groupID;
        this.tripID = tripID;
        this.vat = vat;
        this.ytComission = ytComission;
        this.ytComissionVAT = ytComissionVAT;
        this.packageType = packageType;
        this.sequentialOperation = sequentialOperation;
        this.resourceID = resourceID;
        this.minimumResources = minimumResources;
        this.isFreeBooking = isFreeBooking;
        this.freeInterval = freeInterval;
        this.fixedHour = fixedHour;
        this.fixedMinute = fixedMinute;
        this.colorID = colorID;
        this.adventureLevel = adventureLevel;
        this.challengeLevel = challengeLevel;
        this.friendshipLevel = friendshipLevel;
        this.happinessLevel = happinessLevel;
        this.healthinessLevel = healthinessLevel;
        this.knowledgeLevel = knowledgeLevel;
        this.peacefulnessLevel = peacefulnessLevel;
        this.romanceLevel = romanceLevel;
        this.sophisticationLevel = sophisticationLevel;
        this.unexpectedLevel = unexpectedLevel;
        this.servingPeriodID = servingPeriodID;
        this.targetCountryID = targetCountryID;
        this.otherSubCategoryName = otherSubCategoryName;
        this.categoryID = categoryID;
        this.cancellationID = cancellationID;
        this.noCancellationPercent = noCancellationPercent;
        this.isRunning = isRunning;
        this.readyBookingDuration = readyBookingDuration;
        this.readyBookingDurationType = readyBookingDurationType;
        this.durationDay = durationDay;
        this.durationHour = durationHour;
        this.durationMinute = durationMinute;
        this.isEditing = isEditing;
    }

    public PackageDTO(int id, int providerID, String name, String durationType, int duration, Integer minTripper,
            Integer maxTripper, String language, String coverImage, String images, String startDate, String endDate, String unavailableDays,
            String country, String city, String state, double ordinaryPriceForAdult, int youtripperPercentage, String keywords,
            String mainDescription, String promotionJson, int profitPercentage, int coverPosition, double lat, double lng,
            int groupID, int tripID, double vat, double ytComission, double ytComissionVAT, String packageType,
            int sequentialOperation, int resourceID, int minimumResources, boolean isFreeBooking, int freeInterval, int fixedHour,
            int fixedMinute, int colorID, int adventureLevel, int challengeLevel, int friendshipLevel, int happinessLevel, int healthinessLevel,
            int knowledgeLevel, int peacefulnessLevel, int romanceLevel, int sophisticationLevel, int unexpectedLevel, int servingPeriodID,
            int targetCountryID, String otherSubCategoryName, int categoryID, int cancellationID, int noCancellationPercent, boolean isRunning,
            int readyBookingDuration, String readyBookingDurationType, int durationDay, int durationHour, int durationMinute, int restingTimeDay,
            int restingTimeHour, int restingTimeMinute, boolean isEditing, boolean isUsingMaxQuota, int maxQuota,
            String childrenDiscountJson, String cancellationPolicyJson, int durationMonth, int durationYear,
            String quotaType, double youtripperPrice, String priceCurrency) {
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
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.youtripperPercentage = youtripperPercentage;
        this.keywords = keywords;
        this.mainDescription = mainDescription;
        this.promotionJson = promotionJson;
        this.profitPercentage = profitPercentage;
        this.coverPosition = coverPosition;
        this.lat = lat;
        this.lng = lng;
        this.groupID = groupID;
        this.tripID = tripID;
        this.vat = vat;
        this.ytComission = ytComission;
        this.ytComissionVAT = ytComissionVAT;
        this.packageType = packageType;
        this.sequentialOperation = sequentialOperation;
        this.resourceID = resourceID;
        this.minimumResources = minimumResources;
        this.isFreeBooking = isFreeBooking;
        this.freeInterval = freeInterval;
        this.fixedHour = fixedHour;
        this.fixedMinute = fixedMinute;
        this.colorID = colorID;
        this.adventureLevel = adventureLevel;
        this.challengeLevel = challengeLevel;
        this.friendshipLevel = friendshipLevel;
        this.happinessLevel = happinessLevel;
        this.healthinessLevel = healthinessLevel;
        this.knowledgeLevel = knowledgeLevel;
        this.peacefulnessLevel = peacefulnessLevel;
        this.romanceLevel = romanceLevel;
        this.sophisticationLevel = sophisticationLevel;
        this.unexpectedLevel = unexpectedLevel;
        this.servingPeriodID = servingPeriodID;
        this.targetCountryID = targetCountryID;
        this.otherSubCategoryName = otherSubCategoryName;
        this.categoryID = categoryID;
        this.cancellationID = cancellationID;
        this.noCancellationPercent = noCancellationPercent;
        this.isRunning = isRunning;
        this.readyBookingDuration = readyBookingDuration;
        this.readyBookingDurationType = readyBookingDurationType;
        this.durationDay = durationDay;
        this.durationHour = durationHour;
        this.durationMinute = durationMinute;
        this.restingtimeDay = restingTimeDay;
        this.restingtimeHour = restingTimeHour;
        this.restingtimeMinute = restingTimeMinute;
        this.isEditing = isEditing;
        this.isUsingMaxQuota = isUsingMaxQuota;
        this.maxQuota = maxQuota;
        this.childrenDiscountJson = childrenDiscountJson;
        this.cancellationPolicyJson = cancellationPolicyJson;
        this.durationMonth = durationMonth;
        this.durationYear = durationYear;
        this.quotaType = quotaType;
        this.youtripperPrice = youtripperPrice;
        this.priceCurrency = priceCurrency;
    }

    public PackageDTO(int id, int providerID, String name, String durationType, int duration, int minTripper,
            int maxTripper, String language, String coverImage, String images, String startDate, String endDate, String unavailableDays,
            String country, String city, String state, String coordinates, String included, String excluded, double ordinaryPriceForChild,
            double ordinaryPriceForAdult, int youtripperPercentage, String keywords, String departureLocation, String departureTime,
            String googleDescription, String mainDescription, String promotionJson, int profitPercentage, boolean isPrivateTour, int groupID, int tripID) {
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
        this.promotionJson = promotionJson;
        this.profitPercentage = profitPercentage;
        this.isPrivateTour = isPrivateTour;
        this.groupID = groupID;
        this.tripID = tripID;
    }

    public PackageDTO(int id, int providerID, String providerName, String providerInformation, String name, String durationType, int duration, int minTripper, int maxTripper, String language, String coverImage, String images, String startDate, String endDate, String unavailableDays, String country, String city, String state, String coordinates, String included, String excluded, double ordinaryPriceForChild, double ordinaryPriceForAdult, int youtripperPercentage, String keywords, String departureLocation, String departureTime, String googleDescription, String mainDescription, List<AdditionalDescriptionDTO> additionalDescription, String promotionJson, double rate, int numberOfRates, List<AmenitiesDTO> listAmenities, List<ActivityDTO> activites, List<TransportationDTO> transporations, List<CategoryDTO> categories, List<ReviewDTO> reviews, List<BookingDTO> listBooking, int totalRecords, String providerImage, int professionlism, int staffAttitude, int convenient, int satisfaction, int amenityQuality, int cleanliness, String categoryName, int noOfClicks, int profitPercentage, boolean isPrivateTour, int groupID, int tripID) {
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
        this.youtripperPercentage = youtripperPercentage;
        this.keywords = keywords;
        this.departureLocation = departureLocation;
        this.departureTime = departureTime;
        this.googleDescription = googleDescription;
        this.mainDescription = mainDescription;
        this.additionalDescription = additionalDescription;
        this.promotionJson = promotionJson;
        this.rate = rate;
        this.numberOfRates = numberOfRates;
        this.listAmenities = listAmenities;
        this.activites = activites;
        this.transporations = transporations;
        this.categories = categories;
        this.reviews = reviews;
        this.listBooking = listBooking;
        this.totalRecords = totalRecords;
        this.providerImage = providerImage;
        this.professionlism = professionlism;
        this.staffAttitude = staffAttitude;
        this.convenient = convenient;
        this.satisfaction = satisfaction;
        this.amenityQuality = amenityQuality;
        this.cleanliness = cleanliness;
        this.categoryName = categoryName;
        this.noOfClicks = noOfClicks;
        this.profitPercentage = profitPercentage;
        this.isPrivateTour = isPrivateTour;
        this.groupID = groupID;
        this.tripID = tripID;
    }

    public PackageDTO(String durationType, double ordinaryPriceForAdult, String packageType, String advancedChildPrice,
            int minimumResources, int ytCommission, int maximumCapacity, int minTripper, int maxTripper) {
        this.durationType = durationType;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.packageType = packageType;
        this.advancedChildPrice = advancedChildPrice;
        this.minimumResources = minimumResources;
        this.ytCommission = ytCommission;
        this.maximumCapacity = maximumCapacity;
        this.minTripper = minTripper;
        this.maxTripper = maxTripper;
    }

    public PackageDTO(int id, int providerID, String providerName, String providerInformation, String durationType, int duration,
            int minTripper, int maxTripper, String coverImage, String country, String city, double ordinaryPriceForAdult,
            String providerImage, String categoryName, int coverPosition, String packageType, int sequentialOperation,
            boolean isFreeBooking, int freeInterval, int fixedHour, int fixedMinute, String activityName, String subCategoryName, String categoryIcon,
            int noCancellationPercent, String startOperationTime, String endOperationTime,
            int adventureLevel, int challengeLevel, int friendshipLevel, int happinessLevel,
            int healthinessLevel, int knowledgeLevel, int peacefulnessLevel, int romanceLevel, int sophisticationLevel,
            int unexpectedLevel, int durationDay, int durationHour, int durationMinute, String childrenDiscountJson, String cancellationPolicyJson,boolean isExceptSunday,
            boolean isExceptMonday,boolean isExceptTuesday,boolean isExceptWednesday,boolean isExceptThursday,boolean isExceptFriday,boolean isExceptSaturday,boolean isWorkingEveryday) {
        this.id = id;
        this.providerID = providerID;
        this.providerName = providerName;
        this.providerInformation = providerInformation;
        this.durationType = durationType;
        this.duration = duration;
        this.minTripper = minTripper;
        this.maxTripper = maxTripper;
        this.coverImage = coverImage;
        this.country = country;
        this.city = city;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.youtripperPercentage = youtripperPercentage;
        this.providerImage = providerImage;
        this.categoryName = categoryName;
        this.coverPosition = coverPosition;
        this.packageType = packageType;
        this.sequentialOperation = sequentialOperation;
        this.isFreeBooking = isFreeBooking;
        this.freeInterval = freeInterval;
        this.fixedHour = fixedHour;
        this.fixedMinute = fixedMinute;
        this.activityName = activityName;
        this.subCategoryName = subCategoryName;
        this.categoryIcon = categoryIcon;
        this.startOperationTime = startOperationTime;
        this.endOperationTime = endOperationTime;
        this.noCancellationPercent = noCancellationPercent;
        this.adventureLevel = adventureLevel;
        this.challengeLevel = challengeLevel;
        this.friendshipLevel = friendshipLevel;
        this.happinessLevel = happinessLevel;
        this.healthinessLevel = healthinessLevel;
        this.knowledgeLevel = knowledgeLevel;
        this.peacefulnessLevel = peacefulnessLevel;
        this.romanceLevel = romanceLevel;
        this.sophisticationLevel = sophisticationLevel;
        this.unexpectedLevel = unexpectedLevel;
        this.durationDay = durationDay;
        this.durationHour = durationHour;
        this.durationMinute = durationMinute;
        this.childrenDiscountJson = childrenDiscountJson;
        this.cancellationPolicyJson = cancellationPolicyJson;
        this.isExceptSunday = isExceptSunday;
        this.isExceptMonday = isExceptMonday;
        this.isExceptTuesday = isExceptTuesday;
        this.isExceptWednesday = isExceptWednesday;
        this.isExceptFriday = isExceptFriday;
        this.isExceptSaturday = isExceptSaturday;
        this.isWorkingEveryday = isWorkingEveryday;
    }

    public PackageDTO(int id, int providerID, String providerName, String providerInformation, String durationType, int duration,
            int minTripper, int maxTripper, String coverImage, String unavailableDays, String country, String city, double ordinaryPriceForAdult,
            int youtripperPercentage, String providerImage, String categoryName, int coverPosition, String packageType, int sequentialOperation,
            boolean isFreeBooking, int freeInterval, int fixedHour, int fixedMinute, String activityName, String subCategoryName, String categoryIcon,
            int noCancellationPercent, String startOperationTime, String endOperationTime,
            int readyBookingDuration, String readyBookingDurationType, int adventureLevel, int challengeLevel, int friendshipLevel, int happinessLevel,
            int healthinessLevel, int knowledgeLevel, int peacefulnessLevel, int romanceLevel, int sophisticationLevel, int unexpectedLevel, int durationDay, int durationHour,
            int durationMinute, int colorID, int targetCountryID, int servingPeriodID, boolean isEditing, boolean isUsingMaxQuota, int maxQuota,
            String childrenDiscountJson, String cancellationPolicyJson, int durationMonth, int durationYear) {
        this.id = id;
        this.providerID = providerID;
        this.providerName = providerName;
        this.providerInformation = providerInformation;
        this.durationType = durationType;
        this.duration = duration;
        this.minTripper = minTripper;
        this.maxTripper = maxTripper;
        this.coverImage = coverImage;
        this.unavailableDays = unavailableDays;
        this.country = country;
        this.city = city;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.youtripperPercentage = youtripperPercentage;
        this.providerImage = providerImage;
        this.categoryName = categoryName;
        this.coverPosition = coverPosition;
        this.packageType = packageType;
        this.sequentialOperation = sequentialOperation;
        this.isFreeBooking = isFreeBooking;
        this.freeInterval = freeInterval;
        this.fixedHour = fixedHour;
        this.fixedMinute = fixedMinute;
        this.activityName = activityName;
        this.subCategoryName = subCategoryName;
        this.categoryIcon = categoryIcon;
        this.startOperationTime = startOperationTime;
        this.endOperationTime = endOperationTime;
        this.noCancellationPercent = noCancellationPercent;
        this.readyBookingDuration = readyBookingDuration;
        this.readyBookingDurationType = readyBookingDurationType;
        this.adventureLevel = adventureLevel;
        this.challengeLevel = challengeLevel;
        this.friendshipLevel = friendshipLevel;
        this.happinessLevel = happinessLevel;
        this.healthinessLevel = healthinessLevel;
        this.knowledgeLevel = knowledgeLevel;
        this.peacefulnessLevel = peacefulnessLevel;
        this.romanceLevel = romanceLevel;
        this.sophisticationLevel = sophisticationLevel;
        this.unexpectedLevel = unexpectedLevel;
        this.durationDay = durationDay;
        this.durationHour = durationHour;
        this.durationMinute = durationMinute;
        this.colorID = colorID;
        this.targetCountryID = targetCountryID;
        this.servingPeriodID = servingPeriodID;
        this.isEditing = isEditing;
        this.isUsingMaxQuota = isUsingMaxQuota;
        this.maxQuota = maxQuota;
        this.childrenDiscountJson = childrenDiscountJson;
        this.cancellationPolicyJson = cancellationPolicyJson;
        this.durationMonth = durationMonth;
        this.durationYear = durationYear;
    }

    public PackageDTO(int id, String name, String coverImage, String country, String city, int noOfClicks, double youtripperPrice, String priceCurrency) {
        this.id = id;
        this.name = name;
        this.coverImage = coverImage;
        this.country = country;
        this.city = city;
        this.noOfClicks = noOfClicks;
        this.youtripperPrice = youtripperPrice;
        this.priceCurrency = priceCurrency;
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

    public double getYoutripperPrice() {
        return youtripperPrice;
    }

    public void setYoutripperPrice(double youtripperPrice) {
        this.youtripperPrice = youtripperPrice;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
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

    public List<AdditionalDescriptionDTO> getAdditionalDescription() {
        return additionalDescription;
    }

    public void setAdditionalDescription(List<AdditionalDescriptionDTO> additionalDescription) {
        this.additionalDescription = additionalDescription;
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

    public String getAdditionalDescriptionStr() {
        return additionalDescriptionStr;
    }

    public void setAdditionalDescriptionStr(String additionalDescriptionStr) {
        this.additionalDescriptionStr = additionalDescriptionStr;
    }

    public List<AmenitiesClassifierDTO> getAmenitiesClassifiers() {
        return amenitiesClassifiers;
    }

    public void setAmenitiesClassifiers(List<AmenitiesClassifierDTO> amenitiesClassifiers) {
        this.amenitiesClassifiers = amenitiesClassifiers;
    }

    public String getCancellation() {
        return cancellation;
    }

    public void setCancellation(String cancellation) {
        this.cancellation = cancellation;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public int getSequentialOperation() {
        return sequentialOperation;
    }

    public void setSequentialOperation(int sequentialOperation) {
        this.sequentialOperation = sequentialOperation;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getNoOfSelling() {
        return noOfSelling;
    }

    public void setNoOfSelling(int noOfSelling) {
        this.noOfSelling = noOfSelling;
    }

    public int getCoverPosition() {
        return coverPosition;
    }

    public void setCoverPosition(int coverPosition) {
        this.coverPosition = coverPosition;
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

    public String getNonEnglishDescription() {
        return nonEnglishDescription;
    }

    public void setNonEnglishDescription(String nonEnglishDescription) {
        this.nonEnglishDescription = nonEnglishDescription;
    }

    public String getPackageColor() {
        return PackageColor;
    }

    public void setPackageColor(String PackageColor) {
        this.PackageColor = PackageColor;
    }

    public String getAdvancedChildPrice() {
        return advancedChildPrice;
    }

    public void setAdvancedChildPrice(String advancedChildPrice) {
        this.advancedChildPrice = advancedChildPrice;
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    public List<UsedResourcesViewDTO> getUsedResources() {
        return usedResources;
    }

    public void setUsedResources(List<UsedResourcesViewDTO> usedResources) {
        this.usedResources = usedResources;
    }

    public int getYtCommission() {
        return ytCommission;
    }

    public void setYtCommission(int ytCommission) {
        this.ytCommission = ytCommission;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getNoCancellationPercent() {
        return noCancellationPercent;
    }

    public int getDurationMonth() {
        return durationMonth;
    }

    public void setDurationMonth(int durationMonth) {
        this.durationMonth = durationMonth;
    }

    public int getDurationYear() {
        return durationYear;
    }

    public void setDurationYear(int durationYear) {
        this.durationYear = durationYear;
    }

    public void setNoCancellationPercent(int noCancellationPercent) {
        this.noCancellationPercent = noCancellationPercent;
    }

    public String getCancellationName() {
        return cancellationName;
    }

    public void setCancellationName(String cancellationName) {
        this.cancellationName = cancellationName;
    }

    public String getCancellationConditions() {
        return cancellationConditions;
    }

    public void setCancellationConditions(String cancellationConditions) {
        this.cancellationConditions = cancellationConditions;
    }

    public List<OthersLanguageDescriptionDTO> getOthersLanguageDescription() {
        return othersLanguageDescription;
    }

    public void setOthersLanguageDescription(List<OthersLanguageDescriptionDTO> othersLanguageDescription) {
        this.othersLanguageDescription = othersLanguageDescription;
    }

    public List<AdditionImageDTO> getAdditionImages() {
        return additionImages;
    }

    public void setAdditionImages(List<AdditionImageDTO> additionImages) {
        this.additionImages = additionImages;
    }

    public List<PackageCertificateDTO> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<PackageCertificateDTO> certificates) {
        this.certificates = certificates;
    }

    public List<OperationCycleDTO> getOperationCycles() {
        return operationCycles;
    }

    public void setOperationCycles(List<OperationCycleDTO> operationCycles) {
        this.operationCycles = operationCycles;
    }

    public List<DisabledDiscountDTO> getDisabledDiscounts() {
        return disabledDiscounts;
    }

    public void setDisabledDiscounts(List<DisabledDiscountDTO> disabledDiscounts) {
        this.disabledDiscounts = disabledDiscounts;
    }

    public List<ChildrenDiscountDTO> getChildrenDiscounts() {
        return childrenDiscounts;
    }

    public void setChildrenDiscounts(List<ChildrenDiscountDTO> childrenDiscounts) {
        this.childrenDiscounts = childrenDiscounts;
    }

    public List<SuitabilityDTO> getSuitabilities() {
        return suitabilities;
    }

    public void setSuitabilities(List<SuitabilityDTO> suitabilities) {
        this.suitabilities = suitabilities;
    }

    public int getReadyBookingDuration() {
        return readyBookingDuration;
    }

    public void setReadyBookingDuration(int readyBookingDuration) {
        this.readyBookingDuration = readyBookingDuration;
    }

    public String getReadyBookingDurationType() {
        return readyBookingDurationType;
    }

    public void setReadyBookingDurationType(String readyBookingDurationType) {
        this.readyBookingDurationType = readyBookingDurationType;
    }

    public int getAdventureLevel() {
        return adventureLevel;
    }

    public void setAdventureLevel(int adventureLevel) {
        this.adventureLevel = adventureLevel;
    }

    public int getChallengeLevel() {
        return challengeLevel;
    }

    public void setChallengeLevel(int challengeLevel) {
        this.challengeLevel = challengeLevel;
    }

    public int getFriendshipLevel() {
        return friendshipLevel;
    }

    public void setFriendshipLevel(int friendshipLevel) {
        this.friendshipLevel = friendshipLevel;
    }

    public int getHappinessLevel() {
        return happinessLevel;
    }

    public void setHappinessLevel(int happinessLevel) {
        this.happinessLevel = happinessLevel;
    }

    public int getHealthinessLevel() {
        return healthinessLevel;
    }

    public void setHealthinessLevel(int healthinessLevel) {
        this.healthinessLevel = healthinessLevel;
    }

    public int getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public void setKnowledgeLevel(int knowledgeLevel) {
        this.knowledgeLevel = knowledgeLevel;
    }

    public int getPeacefulnessLevel() {
        return peacefulnessLevel;
    }

    public void setPeacefulnessLevel(int peacefulnessLevel) {
        this.peacefulnessLevel = peacefulnessLevel;
    }

    public int getRomanceLevel() {
        return romanceLevel;
    }

    public void setRomanceLevel(int romanceLevel) {
        this.romanceLevel = romanceLevel;
    }

    public int getSophisticationLevel() {
        return sophisticationLevel;
    }

    public void setSophisticationLevel(int sophisticationLevel) {
        this.sophisticationLevel = sophisticationLevel;
    }

    public int getUnexpectedLevel() {
        return unexpectedLevel;
    }

    public void setUnexpectedLevel(int unexpectedLevel) {
        this.unexpectedLevel = unexpectedLevel;
    }

    /**
     * @return the amenitiesClassifier
     */
    public List<AmenitiesClassifierDTO> getAmenitiesClassifier() {
        return amenitiesClassifier;
    }

    /**
     * @param amenitiesClassifier the amenitiesClassifier to set
     */
    public void setAmenitiesClassifier(List<AmenitiesClassifierDTO> amenitiesClassifier) {
        this.amenitiesClassifier = amenitiesClassifier;
    }

    /**
     * @return the transportation
     */
    public List<TransportationDTO> getTransportation() {
        return transportation;
    }

    /**
     * @param transportation the transportation to set
     */
    public void setTransportation(List<TransportationDTO> transportation) {
        this.transportation = transportation;
    }

    /**
     * @return the languageDescriptionList
     */
    public List<OthersLanguageDescriptionDTO> getLanguageDescriptionList() {
        return languageDescriptionList;
    }

    /**
     * @param languageDescriptionList the languageDescriptionList to set
     */
    public void setLanguageDescriptionList(List<OthersLanguageDescriptionDTO> languageDescriptionList) {
        this.languageDescriptionList = languageDescriptionList;
    }

    /**
     * @return the suitabilityClassifiers
     */
    public List<SuitabilityClassifierDTO> getSuitabilityClassifiers() {
        return suitabilityClassifiers;
    }

    /**
     * @param suitabilityClassifiers the suitabilityClassifiers to set
     */
    public void setSuitabilityClassifiers(List<SuitabilityClassifierDTO> suitabilityClassifiers) {
        this.suitabilityClassifiers = suitabilityClassifiers;
    }

    /**
     * @return the lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * @return the lng
     */
    public double getLng() {
        return lng;
    }

    /**
     * @param lng the lng to set
     */
    public void setLng(double lng) {
        this.lng = lng;
    }

    /**
     * @return the vat
     */
    public double getVat() {
        return vat;
    }

    /**
     * @param vat the vat to set
     */
    public void setVat(double vat) {
        this.vat = vat;
    }

    /**
     * @return the ytComission
     */
    public double getYtComission() {
        return ytComission;
    }

    /**
     * @param ytComission the ytComission to set
     */
    public void setYtComission(double ytComission) {
        this.ytComission = ytComission;
    }

    /**
     * @return the ytComissionVAT
     */
    public double getYtComissionVAT() {
        return ytComissionVAT;
    }

    /**
     * @param ytComissionVAT the ytComissionVAT to set
     */
    public void setYtComissionVAT(double ytComissionVAT) {
        this.ytComissionVAT = ytComissionVAT;
    }

    /**
     * @return the colorID
     */
    public int getColorID() {
        return colorID;
    }

    /**
     * @param colorID the colorID to set
     */
    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    /**
     * @return the servingPeriodID
     */
    public int getServingPeriodID() {
        return servingPeriodID;
    }

    /**
     * @param servingPeriodID the servingPeriodID to set
     */
    public void setServingPeriodID(int servingPeriodID) {
        this.servingPeriodID = servingPeriodID;
    }

    /**
     * @return the targetCountryID
     */
    public int getTargetCountryID() {
        return targetCountryID;
    }

    /**
     * @param targetCountryID the targetCountryID to set
     */
    public void setTargetCountryID(int targetCountryID) {
        this.targetCountryID = targetCountryID;
    }

    /**
     * @return the otherSubCategoryName
     */
    public String getOtherSubCategoryName() {
        return otherSubCategoryName;
    }

    /**
     * @param otherSubCategoryName the otherSubCategoryName to set
     */
    public void setOtherSubCategoryName(String otherSubCategoryName) {
        this.otherSubCategoryName = otherSubCategoryName;
    }

    /**
     * @return the otherActivityName
     */
    public String getOtherActivityName() {
        return otherActivityName;
    }

    /**
     * @param otherActivityName the otherActivityName to set
     */
    public void setOtherActivityName(String otherActivityName) {
        this.otherActivityName = otherActivityName;
    }

    /**
     * @return the categoryID
     */
    public int getCategoryID() {
        return categoryID;
    }

    /**
     * @param categoryID the categoryID to set
     */
    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    /**
     * @return the cancellationID
     */
    public int getCancellationID() {
        return cancellationID;
    }

    /**
     * @param cancellationID the cancellationID to set
     */
    public void setCancellationID(int cancellationID) {
        this.cancellationID = cancellationID;
    }

    /**
     * @return the isRunning
     */
    public boolean isIsRunning() {
        return isRunning;
    }

    /**
     * @param isRunning the isRunning to set
     */
    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    /**
     * @return the classifiers
     */
    public List<ClassifierDTO> getClassifiers() {
        return classifiers;
    }

    /**
     * @param classifiers the classifiers to set
     */
    public void setClassifiers(List<ClassifierDTO> classifiers) {
        this.classifiers = classifiers;
    }

    public int getDurationDay() {
        return durationDay;
    }

    public void setDurationDay(int durationDay) {
        this.durationDay = durationDay;
    }

    public int getDurationHour() {
        return durationHour;
    }

    public void setDurationHour(int durationHour) {
        this.durationHour = durationHour;
    }

    public int getDurationMinute() {
        return durationMinute;
    }

    public void setDurationMinute(int durationMinute) {
        this.durationMinute = durationMinute;
    }

    public boolean isIsEditing() {
        return isEditing;
    }

    public void setIsEditing(boolean isEditing) {
        this.isEditing = isEditing;
    }

    /**
     * @return the restingtimeDay
     */
    public int getRestingtimeDay() {
        return restingtimeDay;
    }

    /**
     * @param restingtimeDay the restingtimeDay to set
     */
    public void setRestingtimeDay(int restingtimeDay) {
        this.restingtimeDay = restingtimeDay;
    }

    /**
     * @return the restingtimeHour
     */
    public int getRestingtimeHour() {
        return restingtimeHour;
    }

    /**
     * @param restingtimeHour the restingtimeHour to set
     */
    public void setRestingtimeHour(int restingtimeHour) {
        this.restingtimeHour = restingtimeHour;
    }

    /**
     * @return the restingtimeMinute
     */
    public int getRestingtimeMinute() {
        return restingtimeMinute;
    }

    /**
     * @param restingtimeMinute the restingtimeMinute to set
     */
    public void setRestingtimeMinute(int restingtimeMinute) {
        this.restingtimeMinute = restingtimeMinute;
    }

    public boolean isIsUsingMaxQuota() {
        return isUsingMaxQuota;
    }

    public void setIsUsingMaxQuota(boolean isUsingMaxQuota) {
        this.isUsingMaxQuota = isUsingMaxQuota;
    }

    public int getMaxQuota() {
        return maxQuota;
    }

    public void setMaxQuota(int maxQuota) {
        this.maxQuota = maxQuota;
    }

    public String getChildrenDiscountJson() {
        return childrenDiscountJson;
    }

    public void setChildrenDiscountJson(String childrenDiscountJson) {
        this.childrenDiscountJson = childrenDiscountJson;
    }

    public String getCancellationPolicyJson() {
        return cancellationPolicyJson;
    }

    public void setCancellationPolicyJson(String cancellationPolicyJson) {
        this.cancellationPolicyJson = cancellationPolicyJson;
    }

    public String getQuotaType() {
        return quotaType;
    }

    public void setQuotaType(String quotaType) {
        this.quotaType = quotaType;
    }

    public boolean isIsSpecificLaunchDate() {
        return isSpecificLaunchDate;
    }

    public void setIsSpecificLaunchDate(boolean isSpecificLaunchDate) {
        this.isSpecificLaunchDate = isSpecificLaunchDate;
    }

    public boolean isIsExceptSunday() {
        return isExceptSunday;
    }

    public void setIsExceptSunday(boolean isExceptSunday) {
        this.isExceptSunday = isExceptSunday;
    }

    public boolean isIsExceptMonday() {
        return isExceptMonday;
    }

    public void setIsExceptMonday(boolean isExceptMonday) {
        this.isExceptMonday = isExceptMonday;
    }

    public boolean isIsExceptTuesday() {
        return isExceptTuesday;
    }

    public void setIsExceptTuesday(boolean isExceptTuesday) {
        this.isExceptTuesday = isExceptTuesday;
    }

    public boolean isIsExceptWednesday() {
        return isExceptWednesday;
    }

    public void setIsExceptWednesday(boolean isExceptWednesday) {
        this.isExceptWednesday = isExceptWednesday;
    }

    public boolean isIsExceptThursday() {
        return isExceptThursday;
    }

    public void setIsExceptThursday(boolean isExceptThursday) {
        this.isExceptThursday = isExceptThursday;
    }

    public boolean isIsExceptFriday() {
        return isExceptFriday;
    }

    public void setIsExceptFriday(boolean isExceptFriday) {
        this.isExceptFriday = isExceptFriday;
    }

    public boolean isIsExceptSaturday() {
        return isExceptSaturday;
    }

    public void setIsExceptSaturday(boolean isExceptSaturday) {
        this.isExceptSaturday = isExceptSaturday;
    }

    public boolean isIsWorkingEveryday() {
        return isWorkingEveryday;
    }

    public void setIsWorkingEveryday(boolean isWorkingEveryday) {
        this.isWorkingEveryday = isWorkingEveryday;
    }

}
