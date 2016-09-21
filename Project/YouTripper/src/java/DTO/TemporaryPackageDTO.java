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
public class TemporaryPackageDTO {

    private int id;
    private int providerID;
    private String providerName;
    private String providerInformation;
    private String providerImage;
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
    private double ordinaryPriceForAdult;
    private int youtripperPercentage;
    private String keywords;
    private String mainDescription;
    private boolean isFinshed;
    private String promotionJson;

    private int profitPercentage;
    private int coverPosition;
    private double lat;
    private double lng;

    private List<AmenitiesDTO> listAmenities;
    private List<ActivityDTO> activites;
    private List<TransportationDTO> transporations;
    // new AmenitiesClassifier
    private List<TemporaryAmenitiesClassifierDTO> amenitiesClassifiers;

    private int groupID;
    private int tripID;

    private String packageAddress;

    private List<TemporaryClassifierDTO> temporaryClassifiers;

    private List<TemporarySuitabilityClassifierDTO> temporarySuitabiltyClassifiers;

    private List<TemporaryTransoprtationWayDTO> temporaryTransportations;

    private double vat;
    private double ytComission;
    private double ytComissionVAT;

    private String packageType;
    private int sequentialOperation;
    private int resourceID;
    private int minimumResources;
    private boolean isFreeBooking;
    private int freeInterval;
    private int fixedHour;
    private int fixedMinute;
    private int colorID;
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
    private int servingPeriodID;
    private int targetCountryID;

    private String otherSubCategoryName;
    private String otherActivityName;
    private int categoryID;

    private List<TemporaryOthersLanguageDescriptionDTO> languageDescriptionList;

    private List<TemporaryPackageCertificatesDTO> certificates;
    private List<TemporaryOperationCycle> operationsCycles;

    private int cancellationID;
    private String cancellationName;
    private String cancellationConditions;
    private int noCancellationPercent;
    private List<TemporaryPackageChildrenDiscountDTO> childrenDiscounts;
    private List<TemporaryPackageDisabledDiscountDTO> disabledDiscounts;

    private List<AdditionImageDTO> additionImages;

    private boolean isRunning;

    private String activityName;
    private String subCategoryName;
    private String categoryName;
    private String categoryIcon;

    private List<TemporaryOperationCycle> operationCycles;
    private List<TemporarySuitabilityClassifierDTO> suitabilities;
    private int maximumCapacity;
    private String startOperationTime;
    private String endOperationTime;
    private List<ChildrenDiscountDTO> childrenDiscountPreview;
    private List<DisabledDiscountDTO> disabledDiscountPreview;
    private int durationDay;
    private int durationHour;
    private int durationMinute;
    private int durationWeek;
    private int restingtimeDay;
    private int restingtimeHour;
    private int restingtimeMinute;
    private boolean isFinished;

    private boolean isUsingMaxQuota;
    private int maxQuota;
    private int noLimit;
    private boolean isSpecificLaunchDate;

    private String childrenDiscountJson;
    private String cancellationPolicyJson;
    private int durationMonth;
    private int durationYear;
    private long createdTime;
    private String priceCurrency;
    private double youtripperPrice;
    private int subCategoryID;
    private String freeCondition;

    private int readyBookingHours;
    private int readyBookingDays;
    private int readyBookingWeeks;
    private int readyBookingMonths;

    private boolean isExceptSunday;
    private boolean isExceptMonday;
    private boolean isExceptTuesday;
    private boolean isExceptWednesday;
    private boolean isExceptThursday;
    private boolean isExceptFriday;
    private boolean isExceptSaturday;
    private boolean isWorkingEveryday;
    private boolean isMonthlyDays;
    private boolean isSpecificSlots;
    private boolean isSameQuota;

    private boolean isExceptOnJan;
    private boolean isExceptOnFeb;
    private boolean isExceptOnMar;
    private boolean isExceptOnApr;
    private boolean isExceptOnMay;
    private boolean isExceptOnJun;
    private boolean isExceptOnJul;
    private boolean isExceptOnAug;
    private boolean isExceptOnSep;
    private boolean isExceptOnOct;
    private boolean isExceptOnNov;
    private boolean isExceptOnDec;

    private List<TempCustomisedWeekSlotDTO> tempCustomiseWeekSlots;
    private List<TempSpecificDateSlotsDTO> tempSpecificDateSlots;
    private List<TempSpecificTimeSlotsDTO> tempSpecificTimeSlots;

    public TemporaryPackageDTO() {
    }

    public TemporaryPackageDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TemporaryPackageDTO(int id, String name, String coverImage, String City, double price,
            String mainDescription, boolean isFinished, boolean isUsingMaxQuota, String keywords,
            String providerImage, String lastName, int providerID, long createdTime) {
        this.id = id;
        this.name = name;
        this.coverImage = coverImage;
        this.city = City;
        this.ordinaryPriceForAdult = price;
        this.mainDescription = mainDescription;
        this.isFinished = isFinished;
        this.isUsingMaxQuota = isUsingMaxQuota;
        this.keywords = keywords;
        this.providerImage = providerImage;
        this.providerName = lastName;
        this.providerID = providerID;
        this.createdTime = createdTime;
    }

    public TemporaryPackageDTO(int id, int providerID, String providerName, String name, String durationType, int duration, Integer minTripper, Integer maxTripper, String language, String coverImage, String images, String startDate, String endDate, String unavailableDays,
            String country, String city, String state, double ordinaryPriceForAdult, int youtripperPercentage, String keywords, String mainDescription, boolean isFinshed, String promotionJson, int profitPercentage, int coverPosition, double lat, double lng, List<AmenitiesDTO> listAmenities, List<ActivityDTO> activites, List<TransportationDTO> transporations, List<TemporaryAmenitiesClassifierDTO> amenitiesClassifiers, int groupID, int tripID, String packageAddress, List<TemporaryClassifierDTO> temporaryClassifiers, List<TemporarySuitabilityClassifierDTO> temporarySuitabiltyClassifiers, List<TemporaryTransoprtationWayDTO> temporaryTransportations, double vat, double ytComission, double ytComissionVAT, String packageType, int sequentialOperation, int resourceID, int minimumResources, boolean isFreeBooking, int freeInterval,
            int fixedHour, int fixedMinute, int colorID, int adventureLevel, int challengeLevel, int friendshipLevel, int happinessLevel, int healthinessLevel, int knowledgeLevel, int peacefulnessLevel, int romanceLevel, int sophisticationLevel, int unexpectedLevel, int servingPeriodID,
            int targetCountryID, String otherSubCategoryName, int categoryID, List<TemporaryOthersLanguageDescriptionDTO> languageDescriptionList, List<TemporaryPackageCertificatesDTO> certificates) {
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
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.youtripperPercentage = youtripperPercentage;
        this.keywords = keywords;
        this.mainDescription = mainDescription;
        this.isFinshed = isFinshed;
        this.promotionJson = promotionJson;
        this.profitPercentage = profitPercentage;
        this.coverPosition = coverPosition;
        this.lat = lat;
        this.lng = lng;
        this.listAmenities = listAmenities;
        this.activites = activites;
        this.transporations = transporations;
        this.amenitiesClassifiers = amenitiesClassifiers;
        this.groupID = groupID;
        this.tripID = tripID;
        this.packageAddress = packageAddress;
        this.temporaryClassifiers = temporaryClassifiers;
        this.temporarySuitabiltyClassifiers = temporarySuitabiltyClassifiers;
        this.temporaryTransportations = temporaryTransportations;
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
        this.languageDescriptionList = languageDescriptionList;
        this.certificates = certificates;

    }

    public TemporaryPackageDTO(int id, int providerID, String name, String durationType, int duration, Integer minTripper,
            Integer maxTripper, String language, String coverImage, String images, String startDate, String endDate, String unavailableDays,
            String country, String city, String state, double ordinaryPriceForAdult, int youtripperPercentage, String keywords,
            String mainDescription, boolean isFinshed, String promotionJson, int profitPercentage, int coverPosition, double lat, double lng,
            int groupID, int tripID, double vat, double ytComission, double ytComissionVAT, String packageType,
            int sequentialOperation, int resourceID, int minimumResources, boolean isFreeBooking, int freeInterval, int fixedHour,
            int fixedMinute, int colorID, int adventureLevel, int challengeLevel, int friendshipLevel, int happinessLevel, int healthinessLevel,
            int knowledgeLevel, int peacefulnessLevel, int romanceLevel, int sophisticationLevel, int unexpectedLevel, int servingPeriodID,
            int targetCountryID, String otherSubCategoryName, int categoryID, int cancellationID, int noCancellationPercent, boolean isRunning,
            int durationDay, int durationHour, int durationMinute) {
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
        this.isFinshed = isFinshed;
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
        this.durationDay = durationDay;
        this.durationHour = durationHour;
        this.durationMinute = durationMinute;
    }

    public TemporaryPackageDTO(int id, int providerID, String name, String durationType, Integer minTripper,
            Integer maxTripper, String coverImage, String images, String startDate,
            String country, String city, double ordinaryPriceForAdult,
            String mainDescription, String keywords, boolean isFinshed, int profitPercentage, int coverPosition,
            double vat, double ytComission, double ytComissionVAT, String packageType,
            int sequentialOperation, boolean isFreeBooking, int freeInterval, int fixedHour,
            int fixedMinute, int colorID, int adventureLevel, int challengeLevel, int friendshipLevel, int happinessLevel, int healthinessLevel,
            int knowledgeLevel, int peacefulnessLevel, int romanceLevel, int sophisticationLevel, int unexpectedLevel, int servingPeriodID,
            int targetCountryID, int subCategoryID, String otherSubCategoryName, int noCancellationPercent,
            int durationDay, int durationHour, int durationMinute, int durationWeek,
            int restingTimeHour, int restingTimeMinute, boolean isUsingMaxQuota, int maxQuota, int noLimit,
            String childrenDiscountJson, String cancellationPolicyJson,
            boolean isSpecificLaunchDate, double youtripperPrice, String priceCurrency, String freeCondition,
            int readyBookingHours, int readyBookingDays, int readyBookingWeeks, int readyBookingMonths,
            boolean isExceptSunday, boolean isExceptMonday, boolean isExceptTuesday, boolean isExceptWednesday,
            boolean isExceptThursday, boolean isExceptFriday, boolean isExceptSaturday, boolean isWorkingEveryday,
            boolean isMonthlyDays, boolean isSpecificSlots, boolean isSameQuota, boolean isExceptOnJan, boolean isExceptOnFeb,
            boolean isExceptOnMar, boolean isExceptOnApr, boolean isExceptOnMay, boolean isExceptOnJun, boolean isExceptOnJul,
            boolean isExceptOnAug, boolean isExceptOnSep, boolean isExceptOnOct, boolean isExceptOnNov, boolean isExceptOnDec) {
        this.id = id;
        this.providerID = providerID;
        this.name = name;
        this.durationType = durationType;
        this.minTripper = minTripper;
        this.maxTripper = maxTripper;
//        this.language = language;
        this.coverImage = coverImage;
        this.images = images;
        this.startDate = startDate;
//        this.endDate = endDate;
//        this.unavailableDays = unavailableDays;
        this.country = country;
        this.city = city;
//        this.state = state;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
//        this.youtripperPercentage = youtripperPercentage;
        this.keywords = keywords;
        this.mainDescription = mainDescription;
        this.isFinshed = isFinshed;
//        this.promotionJson = promotionJson;
        this.profitPercentage = profitPercentage;
        this.coverPosition = coverPosition;
//        this.lat = lat;
//        this.lng = lng;
//        this.groupID = groupID;
//        this.tripID = tripID;
        this.vat = vat;
        this.ytComission = ytComission;
        this.ytComissionVAT = ytComissionVAT;
        this.packageType = packageType;
        this.sequentialOperation = sequentialOperation;
//        this.resourceID = resourceID;
//        this.minimumResources = minimumResources;
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
//        this.categoryID = categoryID;
//        this.cancellationID = cancellationID;
        this.noCancellationPercent = noCancellationPercent;
//        this.isRunning = isRunning;
//        this.readyBookingDuration = readyBookingDuration;
//        this.readyBookingDurationType = readyBookingDurationType;
        this.durationDay = durationDay;
        this.durationHour = durationHour;
        this.durationMinute = durationMinute;
        this.durationWeek = durationWeek;
//        this.restingtimeDay = restingTimeDay;
        this.restingtimeHour = restingTimeHour;
        this.restingtimeMinute = restingTimeMinute;
        this.isUsingMaxQuota = isUsingMaxQuota;
        this.maxQuota = maxQuota;
        this.noLimit = noLimit;
        this.childrenDiscountJson = childrenDiscountJson;
        this.cancellationPolicyJson = cancellationPolicyJson;
//        this.durationMonth = durationMonth;
//        this.durationYear = durationYear;
        this.isSpecificLaunchDate = isSpecificLaunchDate;
//        this.quotaType = quotaType;
        this.youtripperPrice = youtripperPrice;
        this.priceCurrency = priceCurrency;
        this.subCategoryID = subCategoryID;
        this.freeCondition = freeCondition;
        this.readyBookingHours = readyBookingHours;
        this.readyBookingDays = readyBookingDays;
        this.readyBookingWeeks = readyBookingWeeks;
        this.readyBookingMonths = readyBookingMonths;
        this.isExceptSunday = isExceptSunday;
        this.isExceptMonday = isExceptMonday;
        this.isExceptTuesday = isExceptTuesday;
        this.isExceptWednesday = isExceptWednesday;
        this.isExceptThursday = isExceptThursday;
        this.isExceptFriday = isExceptFriday;
        this.isExceptSaturday = isExceptSaturday;
        this.isWorkingEveryday = isWorkingEveryday;
        this.isMonthlyDays = isMonthlyDays;
        this.isSpecificSlots = isSpecificSlots;
        this.isExceptOnJan = isExceptOnJan;
        this.isExceptOnFeb = isExceptOnFeb;
        this.isExceptOnMar = isExceptOnMar;
        this.isExceptOnApr = isExceptOnApr;
        this.isExceptOnMay = isExceptOnMay;
        this.isExceptOnJun = isExceptOnJun;
        this.isExceptOnJul = isExceptOnJul;
        this.isExceptOnAug = isExceptOnAug;
        this.isExceptOnSep = isExceptOnSep;
        this.isExceptOnOct = isExceptOnOct;
        this.isExceptOnNov = isExceptOnNov;
        this.isExceptOnDec = isExceptOnDec;
    }

    public TemporaryPackageDTO(int id, int providerID, String providerName, String providerInformation, String providerImage, String durationType,
            int duration, Integer minTripper, Integer maxTripper, String coverImage, String unavailableDays, String country, String city,
            int youtripperPercentage, int coverPosition, String packageType, int sequentialOperation, boolean isFreeBooking, int freeInterval,
            int fixedHour, int fixedMinute, String otherSubCategoryName, String otherActivityName, String cancellationName, String cancellationConditions,
            int noCancellationPercent, String activityName, String subCategoryName, String categoryName, String categoryIcon, double ordinaryPriceForAdult) {
        this.id = id;
        this.providerID = providerID;
        this.providerName = providerName;
        this.providerInformation = providerInformation;
        this.providerImage = providerImage;
        this.durationType = durationType;
        this.duration = duration;
        this.minTripper = minTripper;
        this.maxTripper = maxTripper;
        this.coverImage = coverImage;
        this.unavailableDays = unavailableDays;
        this.country = country;
        this.city = city;
        this.youtripperPercentage = youtripperPercentage;
        this.coverPosition = coverPosition;
        this.packageType = packageType;
        this.sequentialOperation = sequentialOperation;
        this.isFreeBooking = isFreeBooking;
        this.freeInterval = freeInterval;
        this.fixedHour = fixedHour;
        this.fixedMinute = fixedMinute;
        this.otherSubCategoryName = otherSubCategoryName;
        this.otherActivityName = otherActivityName;
        this.cancellationName = cancellationName;
        this.cancellationConditions = cancellationConditions;
        this.noCancellationPercent = noCancellationPercent;
        this.activityName = activityName;
        this.subCategoryName = subCategoryName;
        this.categoryIcon = categoryIcon;
        this.categoryName = categoryName;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
    }

    public TemporaryPackageDTO(int id, int providerID, String providerName, String providerInformation, String durationType, int duration,
            int minTripper, int maxTripper, String coverImage, String unavailableDays, String country, String city, double ordinaryPriceForAdult,
            int youtripperPercentage, String providerImage, String categoryName, int coverPosition, String packageType, int sequentialOperation,
            boolean isFreeBooking, int freeInterval, int fixedHour, int fixedMinute, String activityName, String subCategoryName, String categoryIcon,
            int noCancellationPercent, String startOperationTime, String endOperationTime, int adventureLevel, int challengeLevel, int friendshipLevel, int happinessLevel,
            int healthinessLevel, int knowledgeLevel, int peacefulnessLevel, int romanceLevel, int sophisticationLevel, int unexpectedLevel, int colorID,
            int targetCountryID, int resourceID, int servingPeriodID, int durationDay, int durationHour, int durationMinute,
            boolean isUsingMaxQuota, int maxQuota, String childrenDiscountJson, String cancellationPolicyJson, int durationMonth, int durationYear) {
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
        this.colorID = colorID;
        this.targetCountryID = targetCountryID;
        this.resourceID = resourceID;
        this.servingPeriodID = servingPeriodID;
        this.durationDay = durationDay;
        this.durationHour = durationHour;
        this.durationMinute = durationMinute;
        this.isUsingMaxQuota = isUsingMaxQuota;
        this.maxQuota = maxQuota;
        this.childrenDiscountJson = childrenDiscountJson;
        this.cancellationPolicyJson = cancellationPolicyJson;
        this.durationMonth = durationMonth;
        this.durationYear = durationYear;
    }
    
    public TemporaryPackageDTO(int id, int providerID, String providerName, String providerInformation, String durationType, 
            int durationMinute,
            int minTripper, int maxTripper, String coverImage,  String country, String city, 
            double ordinaryPriceForAdult,
             String providerImage, String packageType, int coverPosition,  
            int sequentialOperation,
            boolean isFreeBooking, int freeInterval, int fixedHour, int fixedMinute, String activityName, 
            String subCategoryName, String categoryName, String categoryIcon,
            int noCancellationPercent, String startOperationTime, String endOperationTime, int adventureLevel, 
            int challengeLevel, int friendshipLevel, int happinessLevel,
            int healthinessLevel, int knowledgeLevel, int peacefulnessLevel, int romanceLevel, int sophisticationLevel, 
            int unexpectedLevel, int colorID,
            int targetCountryID, int servingPeriodID, int durationDay, int durationHour, 
            String childrenDiscountJson, String cancellationPolicyJson) {
        this.id = id;
        this.providerID = providerID;
        this.providerName = providerName;
        this.providerInformation = providerInformation;
        this.durationType = durationType;
        this.durationMinute = durationMinute;
        this.minTripper = minTripper;
        this.maxTripper = maxTripper;
        this.coverImage = coverImage;
        this.country = country;
        this.city = city;
        this.ordinaryPriceForAdult = ordinaryPriceForAdult;
        this.providerImage = providerImage;
        this.coverPosition = coverPosition;
        this.packageType = packageType;
        this.sequentialOperation = sequentialOperation;
        this.isFreeBooking = isFreeBooking;
        this.freeInterval = freeInterval;
        this.fixedHour = fixedHour;
        this.fixedMinute = fixedMinute;
        this.activityName = activityName;
        this.subCategoryName = subCategoryName;
        this.categoryName = categoryName;
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
        this.colorID = colorID;
        this.targetCountryID = targetCountryID;
        this.servingPeriodID = servingPeriodID;
        this.durationDay = durationDay;
        this.durationHour = durationHour;
        this.childrenDiscountJson = childrenDiscountJson;
        this.cancellationPolicyJson = cancellationPolicyJson;
    }

    public TemporaryPackageDTO(int id) {
        this.id = id;
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

    public int getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(int profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

    public int getCoverPosition() {
        return coverPosition;
    }

    public void setCoverPosition(int coverPosition) {
        this.coverPosition = coverPosition;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
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

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public double getYoutripperPrice() {
        return youtripperPrice;
    }

    public void setYoutripperPrice(double youtripperPrice) {
        this.youtripperPrice = youtripperPrice;
    }

    public void setTransporations(List<TransportationDTO> transporations) {
        this.transporations = transporations;
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

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
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

    public boolean isIsFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public boolean isIsUsingMaxQuota() {
        return isUsingMaxQuota;
    }

    public void setIsUsingMaxQuota(boolean isUsingMaxQuota) {
        this.isUsingMaxQuota = isUsingMaxQuota;
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

    public int getServingPeriodID() {
        return servingPeriodID;
    }

    public void setServingPeriodID(int servingPeriodID) {
        this.servingPeriodID = servingPeriodID;
    }

    public int getTargetCountryID() {
        return targetCountryID;
    }

    public void setTargetCountryID(int targetCountryID) {
        this.targetCountryID = targetCountryID;
    }

    public String getOtherSubCategoryName() {
        return otherSubCategoryName;
    }

    public void setOtherSubCategoryName(String otherSubCategoryName) {
        this.otherSubCategoryName = otherSubCategoryName;
    }

    public List<TemporaryOthersLanguageDescriptionDTO> getLanguageDescriptionList() {
        return languageDescriptionList;
    }

    public void setLanguageDescriptionList(List<TemporaryOthersLanguageDescriptionDTO> languageDescriptionList) {
        this.languageDescriptionList = languageDescriptionList;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public List<TemporaryPackageCertificatesDTO> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<TemporaryPackageCertificatesDTO> certificates) {
        this.certificates = certificates;
    }

    public List<TemporaryOperationCycle> getOperationsCycles() {
        return operationsCycles;
    }

    public void setOperationsCycles(List<TemporaryOperationCycle> operationsCycles) {
        this.operationsCycles = operationsCycles;
    }

    public int getNoCancellationPercent() {
        return noCancellationPercent;
    }

    public void setNoCancellationPercent(int noCancellationPercent) {
        this.noCancellationPercent = noCancellationPercent;
    }

    public int getCancellationID() {
        return cancellationID;
    }

    public void setCancellationID(int cancellationID) {
        this.cancellationID = cancellationID;
    }

    public List<TemporaryPackageChildrenDiscountDTO> getChildrenDiscounts() {
        return childrenDiscounts;
    }

    public void setChildrenDiscounts(List<TemporaryPackageChildrenDiscountDTO> childrenDiscounts) {
        this.childrenDiscounts = childrenDiscounts;
    }

    public List<TemporaryPackageDisabledDiscountDTO> getDisabledDiscounts() {
        return disabledDiscounts;
    }

    public void setDisabledDiscounts(List<TemporaryPackageDisabledDiscountDTO> disabledDiscounts) {
        this.disabledDiscounts = disabledDiscounts;
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public List<AdditionImageDTO> getAdditionImages() {
        return additionImages;
    }

    public void setAdditionImages(List<AdditionImageDTO> additionImages) {
        this.additionImages = additionImages;
    }

    public String getOtherActivityName() {
        return otherActivityName;
    }

    public void setOtherActivityName(String otherActivityName) {
        this.otherActivityName = otherActivityName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    public String getCancellationName() {
        return cancellationName;
    }

    public void setCancellationName(String cancellationName) {
        this.cancellationName = cancellationName;
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

    public String getCancellationConditions() {
        return cancellationConditions;
    }

    public void setCancellationConditions(String cancellationConditions) {
        this.cancellationConditions = cancellationConditions;
    }

    public String getProviderInformation() {
        return providerInformation;
    }

    public void setProviderInformation(String providerInformation) {
        this.providerInformation = providerInformation;
    }

    public String getProviderImage() {
        return providerImage;
    }

    public void setProviderImage(String providerImage) {
        this.providerImage = providerImage;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
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

    public List<TemporarySuitabilityClassifierDTO> getSuitabilities() {
        return suitabilities;
    }

    public void setSuitabilities(List<TemporarySuitabilityClassifierDTO> suitabilities) {
        this.suitabilities = suitabilities;
    }

    public List<TemporaryOperationCycle> getOperationCycles() {
        return operationCycles;
    }

    public void setOperationCycles(List<TemporaryOperationCycle> operationCycles) {
        this.operationCycles = operationCycles;
    }

    public List<ChildrenDiscountDTO> getChildrenDiscountPreview() {
        return childrenDiscountPreview;
    }

    public void setChildrenDiscountPreview(List<ChildrenDiscountDTO> childrenDiscountPreview) {
        this.childrenDiscountPreview = childrenDiscountPreview;
    }

    public List<DisabledDiscountDTO> getDisabledDiscountPreview() {
        return disabledDiscountPreview;
    }

    public void setDisabledDiscountPreview(List<DisabledDiscountDTO> disabledDiscountPreview) {
        this.disabledDiscountPreview = disabledDiscountPreview;
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

    public boolean isIsSpecificLaunchDate() {
        return isSpecificLaunchDate;
    }

    public void setIsSpecificLaunchDate(boolean isSpecificLaunchDate) {
        this.isSpecificLaunchDate = isSpecificLaunchDate;
    }

    public int getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(int subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public String getFreeCondition() {
        return freeCondition;
    }

    public void setFreeCondition(String freeCondition) {
        this.freeCondition = freeCondition;
    }

    public int getReadyBookingHours() {
        return readyBookingHours;
    }

    public void setReadyBookingHours(int readyBookingHours) {
        this.readyBookingHours = readyBookingHours;
    }

    public int getReadyBookingDays() {
        return readyBookingDays;
    }

    public void setReadyBookingDays(int readyBookingDays) {
        this.readyBookingDays = readyBookingDays;
    }

    public int getReadyBookingWeeks() {
        return readyBookingWeeks;
    }

    public void setReadyBookingWeeks(int readyBookingWeeks) {
        this.readyBookingWeeks = readyBookingWeeks;
    }

    public int getReadyBookingMonths() {
        return readyBookingMonths;
    }

    public void setReadyBookingMonths(int readyBookingMonths) {
        this.readyBookingMonths = readyBookingMonths;
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

    public boolean isIsMonthlyDays() {
        return isMonthlyDays;
    }

    public void setIsMonthlyDays(boolean isMonthlyDays) {
        this.isMonthlyDays = isMonthlyDays;
    }

    public boolean isIsSpecificSlots() {
        return isSpecificSlots;
    }

    public void setIsSpecificSlots(boolean isSpecificSlots) {
        this.isSpecificSlots = isSpecificSlots;
    }

    public int getNoLimit() {
        return noLimit;
    }

    public void setNoLimit(int noLimit) {
        this.noLimit = noLimit;
    }

    public boolean isIsSameQuota() {
        return isSameQuota;
    }

    public void setIsSameQuota(boolean isSameQuota) {
        this.isSameQuota = isSameQuota;
    }

    public List<TempCustomisedWeekSlotDTO> getTempCustomiseWeekSlots() {
        return tempCustomiseWeekSlots;
    }

    public void setTempCustomiseWeekSlots(List<TempCustomisedWeekSlotDTO> tempCustomiseWeekSlots) {
        this.tempCustomiseWeekSlots = tempCustomiseWeekSlots;
    }

    public List<TempSpecificDateSlotsDTO> getTempSpecificDateSlots() {
        return tempSpecificDateSlots;
    }

    public void setTempSpecificDateSlots(List<TempSpecificDateSlotsDTO> tempSpecificDateSlots) {
        this.tempSpecificDateSlots = tempSpecificDateSlots;
    }

    public int getDurationWeek() {
        return durationWeek;
    }

    public void setDurationWeek(int durationWeek) {
        this.durationWeek = durationWeek;
    }

    public List<TempSpecificTimeSlotsDTO> getTempSpecificTimeSlots() {
        return tempSpecificTimeSlots;
    }

    public void setTempSpecificTimeSlots(List<TempSpecificTimeSlotsDTO> tempSpecificTimeSlots) {
        this.tempSpecificTimeSlots = tempSpecificTimeSlots;
    }

    public boolean isIsExceptOnJan() {
        return isExceptOnJan;
    }

    public void setIsExceptOnJan(boolean isExceptOnJan) {
        this.isExceptOnJan = isExceptOnJan;
    }

    public boolean isIsExceptOnFeb() {
        return isExceptOnFeb;
    }

    public void setIsExceptOnFeb(boolean isExceptOnFeb) {
        this.isExceptOnFeb = isExceptOnFeb;
    }

    public boolean isIsExceptOnMar() {
        return isExceptOnMar;
    }

    public void setIsExceptOnMar(boolean isExceptOnMar) {
        this.isExceptOnMar = isExceptOnMar;
    }

    public boolean isIsExceptOnApr() {
        return isExceptOnApr;
    }

    public void setIsExceptOnApr(boolean isExceptOnApr) {
        this.isExceptOnApr = isExceptOnApr;
    }

    public boolean isIsExceptOnMay() {
        return isExceptOnMay;
    }

    public void setIsExceptOnMay(boolean isExceptOnMay) {
        this.isExceptOnMay = isExceptOnMay;
    }

    public boolean isIsExceptOnJun() {
        return isExceptOnJun;
    }

    public void setIsExceptOnJun(boolean isExceptOnJun) {
        this.isExceptOnJun = isExceptOnJun;
    }

    public boolean isIsExceptOnJul() {
        return isExceptOnJul;
    }

    public void setIsExceptOnJul(boolean isExceptOnJul) {
        this.isExceptOnJul = isExceptOnJul;
    }

    public boolean isIsExceptOnAug() {
        return isExceptOnAug;
    }

    public void setIsExceptOnAug(boolean isExceptOnAug) {
        this.isExceptOnAug = isExceptOnAug;
    }

    public boolean isIsExceptOnSep() {
        return isExceptOnSep;
    }

    public void setIsExceptOnSep(boolean isExceptOnSep) {
        this.isExceptOnSep = isExceptOnSep;
    }

    public boolean isIsExceptOnOct() {
        return isExceptOnOct;
    }

    public void setIsExceptOnOct(boolean isExceptOnOct) {
        this.isExceptOnOct = isExceptOnOct;
    }

    public boolean isIsExceptOnNov() {
        return isExceptOnNov;
    }

    public void setIsExceptOnNov(boolean isExceptOnNov) {
        this.isExceptOnNov = isExceptOnNov;
    }

    public boolean isIsExceptOnDec() {
        return isExceptOnDec;
    }

    public void setIsExceptOnDec(boolean isExceptOnDec) {
        this.isExceptOnDec = isExceptOnDec;
    }

}
