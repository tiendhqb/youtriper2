/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TemporaryPackageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class PackageMapper implements RowMapper<TemporaryPackageDTO> {

    private static PackageMapper instance = null;

    private PackageMapper() {
    }

    public static PackageMapper getInstance() {
        if (instance == null) {
            instance = new PackageMapper();
        }
        return instance;
    }

    @Override
    public TemporaryPackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        int id = rs.getInt("TemporaryPackageID");
        int providerID = rs.getInt("ProviderID");
        String name = rs.getString("Name");
        String durationType = rs.getString("DurationType");
//        int duration = rs.getInt("Duration");
        int minTripper = rs.getInt("MinTripper");
        int maxTripper = rs.getInt("MaxTripper");
//        String language = rs.getString("Language");
        String coverImage = rs.getString("CoverImage");
        String images = rs.getString("Images");
//        String endDate = rs.getString("EndDate");
        String startDate = rs.getString("StartDate");
        String country = rs.getString("Country");
        String city = rs.getString("City");
//        String state = rs.getString("State");
        double ordinaryPriceForAdult = rs.getDouble("OrdinaryPriceForAdult");
//        int youtripperPercentage = rs.getInt("YoutripperPercentage");
        String keywords = rs.getString("Keywords");
        String mainDescription = rs.getString("MainDescription");
        boolean isFinished = rs.getBoolean("isFinished");
//        String unavailableDays = rs.getString("unavailableDays");
//        String promotionJson = rs.getString("PromotionJson");
        int profitPercentage = rs.getInt("ProfitPercentage");
        String packageType = rs.getString("PackageType");
//        int groupID = rs.getInt("GroupID");
//        int tripID = rs.getInt("TripID");
        int coverPosition = rs.getInt("CoverPosition");
//        double lat = rs.getDouble("Lat");
//        double lng = rs.getDouble("Lng");
        double vat = rs.getDouble("VAT");
        double ytComission = rs.getDouble("YTComission");
        double ytComissionVAT = rs.getDouble("YTComissionVAT");
//        String cancellation = rs.getString("Cancellation");
        int sequentialOperation = rs.getInt("SequentialOperation");
//        int resourceID = rs.getInt("ResourceID");
//        int minimumResources = rs.getInt("MinimumResources");
        boolean isFreeBooking = rs.getBoolean("IsFreeBooking");
        int freeInterval = rs.getInt("FreeInterval");
        int fixedHour = rs.getInt("FixedHour");
        int fixedMinute = rs.getInt("FixedMinute");
        int colorID = rs.getInt("ColorID");
        int adventureLevel = rs.getInt("AdventureLevel");
        int challengeLevel = rs.getInt("ChallengeLevel");
        int friendshipLevel = rs.getInt("FriendshipLevel");
        int happinessLevel = rs.getInt("HappinessLevel");
        int healthinessLevel = rs.getInt("HealthinessLevel");
        int knowledgeLevel = rs.getInt("KnowledgeLevel");
        int peacefulnessLevel = rs.getInt("PeacefulnessLevel");
        int romanceLevel = rs.getInt("RomanceLevel");
        int sophisticationLevel = rs.getInt("SophisticationLevel");
        int unexpectedLevel = rs.getInt("UnexpectedLevel");
        int servingPeriodID = rs.getInt("ServingPeriodID");
        int targetCountryID = rs.getInt("TargetCountryID");
//        int disabledDiscountID = rs.getInt("DisabledDiscountID");

        String otherSubCategoryName = rs.getString("OtherSubCategoryContent");

//        int cancellationID = rs.getInt("CancellationID");
        int noCancellationPercent = rs.getInt("NoCancellationPercent");
//        boolean isRunning = rs.getBoolean("isRunning");
//        int readyBookingDuration = rs.getInt("ReadyBookingDuration");
//        String readyBookingDurationType = rs.getString("ReadyBookingDurationType");
        int durationDay = rs.getInt("DurationDay");
        int durationHour = rs.getInt("DurationHour");
        int durationMinute = rs.getInt("DurationMinute");
        int durationWeek = rs.getInt("DurationWeek");
//        int restingDay = rs.getInt("RestingTimeDays");
        int restingHour = rs.getInt("RestingTimeHours");
        int restingMinute = rs.getInt("RestingTimeMinutes");
        boolean isUsingMaxQuota = rs.getBoolean("isUsingMaxQuota");
        int maxQuota = rs.getInt("MaxQuota");
        int noLimit = rs.getInt("NoLimit");
        String childrenDiscountJson = rs.getString("ChildrenDiscountJson");
        String cancellationPolicyJson = rs.getString("CancellationPolicyJson");
//        int durationMonth = rs.getInt("DurationMonths");
//        int durationYear = rs.getInt("DurationYears");
//        String quotaType = rs.getString("QuotaType");
        boolean isSpecificLaunchDate = rs.getBoolean("isSpecificLaunchDate");
        double youtripperPrice = rs.getDouble("YoutripperPrice");
        String priceCurrency = rs.getString("PriceCurrency");
        int subCategoryID = rs.getInt("subCategoryID");
        String freeCondition = rs.getString("FreeCondition");

        int readyBookingHours = rs.getInt("ReadyBookingHours");
        int readyBookingDays = rs.getInt("ReadyBookingDays");
        int readyBookingWeeks = rs.getInt("readyBookingWeeks");
        int readyBookingMonths = rs.getInt("ReadyBookingMonths");

        boolean isExceptSunday = rs.getBoolean("IsExceptSunday");
        boolean isExceptMonday = rs.getBoolean("IsExceptMonday");
        boolean isExceptTuesday = rs.getBoolean("IsExceptTuesday");
        boolean isExceptWednesday = rs.getBoolean("IsExceptWednesday");
        boolean isExceptThursday = rs.getBoolean("IsExceptThursday");
        boolean isExceptFriday = rs.getBoolean("IsExceptFriday");
        boolean isExceptSaturday = rs.getBoolean("IsExceptSaturday");
        boolean isWorkingEveryday = rs.getBoolean("IsWorkingEveryday");
        boolean isMonthlyDays = rs.getBoolean("IsMonthlyDays");
        boolean isSpecificSlots = rs.getBoolean("IsSpecificSlots");
        boolean isSameQuota = rs.getBoolean("IsSameQuota");

        boolean isExceptOnJan = rs.getBoolean("IsExceptOnJan");
        boolean isExceptOnFeb = rs.getBoolean("IsExceptOnFeb");
        boolean isExceptOnMar = rs.getBoolean("IsExceptOnMar");
        boolean isExceptOnApr = rs.getBoolean("IsExceptOnApr");
        boolean isExceptOnMay = rs.getBoolean("IsExceptOnMay");
        boolean isExceptOnJun = rs.getBoolean("IsExceptOnJun");
        boolean isExceptOnJul = rs.getBoolean("IsExceptOnJul");
        boolean isExceptOnAug = rs.getBoolean("IsExceptOnAug");
        boolean isExceptOnSep = rs.getBoolean("IsExceptOnSep");
        boolean isExceptOnOct = rs.getBoolean("IsExceptOnOct");
        boolean isExceptOnNov = rs.getBoolean("IsExceptOnNov");
        boolean isExceptOnDec = rs.getBoolean("IsExceptOnDec");

        TemporaryPackageDTO packageDTO = new TemporaryPackageDTO(id, providerID, name, durationType, minTripper, maxTripper,
                coverImage, images, startDate, country, city, ordinaryPriceForAdult,
                mainDescription, keywords, isFinished, profitPercentage, coverPosition, vat, ytComission, ytComissionVAT,
                packageType, sequentialOperation, isFreeBooking, freeInterval, fixedHour,
                fixedMinute, colorID, adventureLevel, challengeLevel, friendshipLevel, happinessLevel, healthinessLevel, knowledgeLevel, peacefulnessLevel,
                romanceLevel, sophisticationLevel, unexpectedLevel, servingPeriodID, targetCountryID, subCategoryID, otherSubCategoryName, noCancellationPercent,
                durationDay, durationHour, durationMinute, durationWeek,
                restingHour, restingMinute, isUsingMaxQuota, maxQuota, noLimit, childrenDiscountJson,
                cancellationPolicyJson, isSpecificLaunchDate, youtripperPrice, priceCurrency, freeCondition,
                readyBookingHours, readyBookingDays, readyBookingWeeks, readyBookingMonths, isExceptSunday, isExceptMonday, isExceptTuesday,
                isExceptWednesday, isExceptThursday, isExceptFriday, isExceptSaturday, isWorkingEveryday, isMonthlyDays, isSpecificSlots, isSameQuota,
                isExceptOnJan, isExceptOnFeb, isExceptOnMar, isExceptOnApr, isExceptOnMay, isExceptOnJun, isExceptOnJul,
                isExceptOnAug, isExceptOnSep, isExceptOnOct, isExceptOnNov, isExceptOnDec);
        return packageDTO;
    }
}
