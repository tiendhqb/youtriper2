/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.PackageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class PackageDTOMapperForEditPackage implements RowMapper<PackageDTO> {

    private static PackageDTOMapperForEditPackage instance = null;

    private PackageDTOMapperForEditPackage() {
    }

    public static PackageDTOMapperForEditPackage getInstance() {
        if (instance == null) {
            instance = new PackageDTOMapperForEditPackage();
        }
        return instance;
    }

    @Override
    public PackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        int id = rs.getInt("PackageID");
        int providerID = rs.getInt("ProviderID");
        String name = rs.getString("Name");
        String durationType = rs.getString("DurationType");
        int duration = rs.getInt("Duration");
        int minTripper = rs.getInt("MinTripper");
        int maxTripper = rs.getInt("MaxTripper");
        String language = rs.getString("Language");
        String coverImage = rs.getString("CoverImage");
        String images = rs.getString("Images");
        String endDate = rs.getString("EndDate");
        String startDate = rs.getString("StartDate");
        String country = rs.getString("Country");
        String city = rs.getString("City");
        String state = rs.getString("State");
        double ordinaryPriceForAdult = rs.getDouble("OrdinaryPriceForAdult");
        int youtripperPercentage = rs.getInt("YoutripperPercentage");
        String keywords = rs.getString("Keywords");
        String mainDescription = rs.getString("MainDescription");
        String unavailableDays = rs.getString("unavailableDays");
        String promotionJson = rs.getString("PromotionJson");
        int profitPercentage = rs.getInt("ProfitPercentage");
        String packageType = rs.getString("PackageType");
        int groupID = rs.getInt("GroupID");
        int tripID = rs.getInt("TripID");
        int coverPosition = rs.getInt("CoverPosition");
        double lat = rs.getDouble("Lat");
        double lng = rs.getDouble("Lng");
        double vat = rs.getDouble("VAT");
        double ytComission = rs.getDouble("YTComission");
        double ytComissionVAT = rs.getDouble("YTComissionVAT");
//        String cancellation = rs.getString("Cancellation");
        int sequentialOperation = rs.getInt("SequentialOperation");
        int resourceID = rs.getInt("ResourceID");
        int minimumResources = rs.getInt("MinimumResources");
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
        int categoryID = 0;
        String otherSubCategoryName = "";
//        if (rs.getString("CategoryID") != null) {
//            categoryID = rs.getInt("CategoryID");
//        }
        int cancellationID = rs.getInt("CancellationID");
        int noCancellationPercent = rs.getInt("NoCancellationPercent");
        boolean isRunning = rs.getBoolean("isRunning");
        int readyBookingDuration = rs.getInt("ReadyBookingDuration");
        String readyBookingDurationType = rs.getString("ReadyBookingDurationType");
        int durationDay = rs.getInt("DurationDay");
        int durationHour = rs.getInt("DurationHour");
        int durationMinute = rs.getInt("DurationMinute");
        boolean isEditing = rs.getBoolean("isEditing");
        int restingDay = rs.getInt("RestingTimeDays");
        int restingHour = rs.getInt("RestingTimeHours");
        int restingMinute = rs.getInt("RestingTimeMinutes");
        boolean isUsingMaxQuota = rs.getBoolean("isUsingMaxQuota");
        int maxQuota = rs.getInt("MaxQuota");
        String childrenDiscountJson = rs.getString("ChildrenDiscountJson");
        String cancellationPolicyJson = rs.getString("CancellationPolicyJson");
        int durationMonth = rs.getInt("DurationMonths");
        int durationYear = rs.getInt("DurationYears");
        String quotaType = rs.getString("QuotaType");
        double youtripperPrice = rs.getDouble("YoutripperPrice");
        String priceCurrency = rs.getString("PriceCurrency");

        PackageDTO packageDTO = new PackageDTO(id, providerID, name, durationType, duration, minTripper, maxTripper, language,
                coverImage, images, startDate, endDate, unavailableDays, country, city, state, ordinaryPriceForAdult, youtripperPercentage,
                keywords, mainDescription, promotionJson, profitPercentage, coverPosition, lat, lng, groupID, tripID, vat, ytComission, ytComissionVAT,
                packageType, sequentialOperation, resourceID, minimumResources, isFreeBooking, freeInterval, fixedHour,
                fixedMinute, colorID, adventureLevel, challengeLevel, friendshipLevel, happinessLevel, healthinessLevel, knowledgeLevel, peacefulnessLevel,
                romanceLevel, sophisticationLevel, unexpectedLevel, servingPeriodID, targetCountryID, otherSubCategoryName, categoryID, cancellationID, noCancellationPercent,
                isRunning, readyBookingDuration, readyBookingDurationType, durationDay, durationHour, durationMinute,
                restingDay, restingHour, restingMinute, isEditing, isUsingMaxQuota, maxQuota, childrenDiscountJson,
                cancellationPolicyJson, durationMonth, durationYear, quotaType,youtripperPrice,priceCurrency);
        return packageDTO;
    }
}
