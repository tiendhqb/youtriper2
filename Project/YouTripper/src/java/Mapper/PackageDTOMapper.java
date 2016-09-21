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
public class PackageDTOMapper implements RowMapper<PackageDTO> {

    private static PackageDTOMapper instance = null;

    private PackageDTOMapper() {
    }

    public static PackageDTOMapper getInstance() {
        if (instance == null) {
            instance = new PackageDTOMapper();
        }
        return instance;
    }

    @Override
    public PackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        int id = rs.getInt("PackageID");
        int providerID = rs.getInt("ProviderID");
        String providerName = rs.getString("ProviderName");
        String providerInformation = rs.getString("Information");
        String durationType = rs.getString("DurationType");
        int duration = rs.getInt("DurationMinutes");
        int minTripper = rs.getInt("MinTripper");
        int maxTripper = rs.getInt("MaxTripper");
        String coverImage = rs.getString("CoverImage");
//        String unavailableDays = rs.getString("unavailableDays");
        String country = rs.getString("Country");
        String city = rs.getString("City");
        double ordinaryPriceForAdult = rs.getDouble("OrdinaryPriceForAdult");
        String providerImage = rs.getString("Image");
        String packageType = rs.getString("PackageType");
//        int youtripperPercentage = rs.getInt("YouTripperPercentage");
        int coverPosition = rs.getInt("CoverPosition");
        int sequentialOperation = rs.getInt("SequentialOperation");
        boolean isFreeBooking = rs.getBoolean("IsFreeBooking");
        int freeInterval = rs.getInt("FreeInterval");
        int fixedHour = rs.getInt("FixedHour");
        int fixedMinute = rs.getInt("FixedMinute");
        String activityName = rs.getString("ActivityName");
        String subCategoryName = rs.getString("SubName");
        String categoryName = rs.getString("CategoryName");
        String categoryIcon = rs.getString("categoryIcon");
        int noCancellationPercent = rs.getInt("NoCancellationPercent");
        String startOperationTime = rs.getString("StartTime");
        String endOperationTime = rs.getString("EndTime");
//        int readyBookingDuration = rs.getInt("ReadyBookingDuration");
//        String readyBookingDurationType = rs.getString("ReadyBookingDurationType");
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
        int durationDay = rs.getInt("DurationDay");
        int durationHour = rs.getInt("DurationHour");
        int durationMinute = rs.getInt("DurationMinute");
        String childrenDiscountJson = rs.getString("ChildrenDiscountJson");
        String cancellationPolicyJson = rs.getString("CancellationPolicyJson");
        boolean isExceptSunday = rs.getBoolean("IsExceptSunday");
        boolean isExceptMonday = rs.getBoolean("IsExceptMonday");
        boolean isExceptTuesday = rs.getBoolean("IsExceptTuesday");
        boolean isExceptWednesday = rs.getBoolean("IsExceptWednesday");
        boolean isExcepThursday = rs.getBoolean("IsExceptThursday");
        boolean isExceptFriday = rs.getBoolean("IsExceptFriday");
        boolean isExceptSaturday = rs.getBoolean("IsExceptSaturday");
        boolean isWorkingEveryday = rs.getBoolean("IsWorkingEveryday");

        PackageDTO packageDTO = new PackageDTO(id, providerID, providerName, providerInformation, durationType,
                duration, minTripper, maxTripper, coverImage, country, city, ordinaryPriceForAdult,
                providerImage, categoryName, coverPosition, packageType, sequentialOperation, isFreeBooking,
                freeInterval, fixedHour, fixedMinute, activityName, subCategoryName, categoryIcon,
                noCancellationPercent, startOperationTime, endOperationTime,
                adventureLevel, challengeLevel, friendshipLevel,
                happinessLevel, healthinessLevel, knowledgeLevel, peacefulnessLevel, romanceLevel, sophisticationLevel,
                unexpectedLevel, durationDay, durationHour, durationMinute, childrenDiscountJson, cancellationPolicyJson,
        isExceptSunday,isExceptMonday,isExceptTuesday,isExceptWednesday,isExcepThursday,isExceptFriday,isExceptSaturday,isWorkingEveryday);
        return packageDTO;
    }
}
