/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.AdditionalDescriptionDTO;
import DTO.TemporaryPackageDTO;
import DTO.TemporaryPackageDTOv2;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class PackageMapperv2 implements RowMapper<TemporaryPackageDTOv2> {

    private static PackageMapperv2 instance = null;

    private PackageMapperv2() {
    }

    public static PackageMapperv2 getInstance() {
        if (instance == null) {
            instance = new PackageMapperv2();
        }
        return instance;
    }

    @Override
    public TemporaryPackageDTOv2 mapRow(ResultSet rs, int i) throws SQLException {
        Gson gson = new Gson();
        int id = rs.getInt("TemporaryPackageID");
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
        String coordinates = rs.getString("Coordinates");
        String included = rs.getString("Included");
        String excluded = rs.getString("Excluded");
        double ordinaryPriceForChild = rs.getDouble("OrdinaryPriceForChild");
        double ordinaryPriceForAdult = rs.getDouble("OrdinaryPriceForAdult");
        int youtripperPercentage = rs.getInt("YoutripperPercentage");
        String keywords = rs.getString("Keywords");
        String departureLocation = rs.getString("DepartureLocation");
        String departureTime = rs.getString("DepartureTime");
        String googleDescription = rs.getString("GoogleDescription");
        String mainDescription = rs.getString("MainDescription");
        List<AdditionalDescriptionDTO> additionalDescription = (List<AdditionalDescriptionDTO>) gson.fromJson(rs.getString("AddtionalDescription"), new TypeToken<List<AdditionalDescriptionDTO>>(){}.getType());
        boolean isFinished = rs.getBoolean("isFinished");
        String unavailableDays = rs.getString("unavailableDays");
        String promotionJson = rs.getString("PromotionJson");
        String profitPercentage = rs.getString("ProfitPercentage");
        String packageType = rs.getString("PackageType");
        int groupID = rs.getInt("GroupID");
        int tripID = rs.getInt("TripID");
        String packageAddress = rs.getString("PackageAddress");
        String additionalAddress = rs.getString("AdditionalAddress");
        double coverPosition = rs.getDouble("CoverPosition");
        double vat = rs.getDouble("VAT");
        double ytComission = rs.getDouble("YTComission");
        double ytComissionVAT = rs.getDouble("YTComissionVAT");
        int certificateID = rs.getInt("CertificateID");
        String advancedPriceChild = rs.getString("AdvancedChildPrice");
        
        String cancellation = rs.getString("Cancellation");
        int sequentialOperation = rs.getInt("SequentialOperation");
        int resourceID = rs.getInt("ResourceID");
        int minimumResources = rs.getInt("MinimumResources");
        String startOperationTime = rs.getString("StartOperationTime");
        String endOperationTime = rs.getString("EndOperationTime");
        boolean isFreeBooking = rs.getBoolean("IsFreeBooking");
        int freeInterval = rs.getInt("FreeInterval");
        int fixedHour = rs.getInt("FixedHour");
        int fixedMinute = rs.getInt("FixedMinute");
        String nonEnglishDescription = rs.getString("NonEnglishDescription");
        String packageColor = rs.getString("PackageColor");
        
        TemporaryPackageDTOv2 packageDTO = new TemporaryPackageDTOv2(id, providerID, name, durationType, duration, minTripper, maxTripper,
                language, coverImage, images, startDate, endDate, unavailableDays, country, city, state, coordinates, included, excluded, ordinaryPriceForChild,
                ordinaryPriceForAdult, youtripperPercentage, keywords, departureLocation, departureTime, googleDescription,
                mainDescription,additionalDescription, isFinished, promotionJson, profitPercentage, packageType, groupID,
                tripID, packageAddress,additionalAddress,coverPosition, vat, ytComission, ytComissionVAT,certificateID, advancedPriceChild,cancellation,sequentialOperation
        ,resourceID,minimumResources,startOperationTime,endOperationTime,isFreeBooking,freeInterval,fixedHour,fixedMinute,nonEnglishDescription,packageColor);
        return packageDTO;
    }


}
