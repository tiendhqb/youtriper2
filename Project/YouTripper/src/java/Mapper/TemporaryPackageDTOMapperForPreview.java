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
public class TemporaryPackageDTOMapperForPreview implements RowMapper<TemporaryPackageDTO> {

    private static TemporaryPackageDTOMapperForPreview instance = null;

    private TemporaryPackageDTOMapperForPreview() {
    }

    public static TemporaryPackageDTOMapperForPreview getInstance() {
        if (instance == null) {
            instance = new TemporaryPackageDTOMapperForPreview();
        }
        return instance;
    }

    @Override
    public TemporaryPackageDTO mapRow(ResultSet rs, int i) throws SQLException {

        int id = rs.getInt("TemporaryPackageID");
        int providerID = rs.getInt("ProviderID");
        String providerName = rs.getString("ProviderName");
        String providerInformation = rs.getString("Information");
        String durationType = rs.getString("DurationType");
        int minTripper = rs.getInt("MinTripper");
        int maxTripper = rs.getInt("MaxTripper");
        String coverImage = rs.getString("CoverImage");
        String country = rs.getString("Country");
        String city = rs.getString("City");
        double ordinaryPriceForAdult = rs.getDouble("OrdinaryPriceForAdult");
        String providerImage = rs.getString("Image");
        String packageType = rs.getString("PackageType");
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
        int colorID = rs.getInt("ColorID");
        int targetCountryID = rs.getInt("TargetCountryID");
        int servingPeriodID = rs.getInt("servingPeriodID");
        int durationDay = rs.getInt("DurationDay");
        int durationHour = rs.getInt("DurationHour");
        int durationMinute = rs.getInt("DurationMinutes");
        String childrenDiscountJson = rs.getString("ChildrenDiscountJson");
        String cancellationPolicyJson = rs.getString("CancellationPolicyJson");

        TemporaryPackageDTO packageDTO = new TemporaryPackageDTO(id,providerID, providerName, providerInformation, 
                durationType, 
            durationMinute,
            minTripper, maxTripper, coverImage,  country, city, 
             ordinaryPriceForAdult,
              providerImage,  packageType,  coverPosition,  
             sequentialOperation,
             isFreeBooking,freeInterval,  fixedHour,  fixedMinute,  activityName, 
             subCategoryName,  categoryName,  categoryIcon,
             noCancellationPercent,  startOperationTime, endOperationTime,  adventureLevel, 
             challengeLevel,  friendshipLevel,  happinessLevel,
             healthinessLevel,  knowledgeLevel,  peacefulnessLevel,  romanceLevel, sophisticationLevel, 
             unexpectedLevel,  colorID,
            targetCountryID, servingPeriodID, durationDay,  durationHour, 
            childrenDiscountJson,  cancellationPolicyJson);
        return packageDTO;
    }

}
