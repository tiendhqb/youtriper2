/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.PreviewTemporaryPackage;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class PreviewTemporaryPackageMapper implements RowMapper<PreviewTemporaryPackage> {

    private static PreviewTemporaryPackageMapper instance = null;

    private PreviewTemporaryPackageMapper() {
    }

    public static PreviewTemporaryPackageMapper getInstance() {
        if (instance == null) {
            instance = new PreviewTemporaryPackageMapper();
        }
        return instance;
    }

    @Override
    public PreviewTemporaryPackage mapRow(ResultSet rs, int i) throws SQLException {
        int id = rs.getInt("TemporaryPackageID");
        int providerID = rs.getInt("ProviderID");
        String name = rs.getString("Name");
        int durationType = rs.getInt("DurationType");
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
        boolean isFinished = rs.getBoolean("isFinished");
        String unavailableDays = rs.getString("unavailableDays");
        String promotionJson = rs.getString("PromotionJson");
        PreviewTemporaryPackage temporaryPackage = new PreviewTemporaryPackage(id, providerID, name, durationType, duration, minTripper,
                maxTripper, language, coverImage, images, startDate, endDate, unavailableDays, country, city, state, coordinates, included,
                excluded, ordinaryPriceForChild, ordinaryPriceForAdult, youtripperPercentage, keywords, departureLocation, departureTime,
                googleDescription, mainDescription, isFinished, promotionJson);
        return temporaryPackage;
    }

}
