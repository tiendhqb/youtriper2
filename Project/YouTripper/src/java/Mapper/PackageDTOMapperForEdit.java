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
public class PackageDTOMapperForEdit implements RowMapper<PackageDTO> {

    private static PackageDTOMapperForEdit instance = null;

    private PackageDTOMapperForEdit() {
    }

    public static PackageDTOMapperForEdit getInstance() {
        if (instance == null) {
            instance = new PackageDTOMapperForEdit();
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
        String unavailableDays = rs.getString("unavailableDays");
        String promotionJson = rs.getString("PromotionJson");
        String profitPercentage = rs.getString("ProfitPercentage");
        boolean isPrivateTour = rs.getBoolean("isPrivateTour");
        int groupID = rs.getInt("GroupID");
        int tripID = rs.getInt("TripID");
        return new PackageDTO(id, providerID, name, durationType, duration, minTripper, maxTripper, language,
                coverImage, images, startDate, endDate, unavailableDays, country, city, state, coordinates,
                included, excluded, ordinaryPriceForChild, ordinaryPriceForAdult, youtripperPercentage, keywords,
                departureLocation, departureTime, googleDescription, mainDescription, promotionJson, youtripperPercentage, isPrivateTour,groupID, tripID);
    }

}
