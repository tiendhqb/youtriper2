/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.PackageDTO;
import DTO.PackageDTOv2;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class PackageDTOMapperv2 implements RowMapper<PackageDTO>{

    private static PackageDTOMapperv2 instance = null;

    private PackageDTOMapperv2() {
    }

    public static PackageDTOMapperv2 getInstance() {
        if (instance == null) {
            instance = new PackageDTOMapperv2();
        }
        return instance;
    }

    @Override
    public PackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        int id = rs.getInt("PackageID");
        int providerID = rs.getInt("ProviderID");
        String providerName = rs.getString("ProviderName");
        String information = rs.getString("Information");
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
        String unavailableDays = rs.getString("unavailableDays");
        String country = rs.getString("Country");
        String city = rs.getString("City");
        String state = rs.getString("State");
        String coordinates = rs.getString("Coordinates");
        String included = rs.getString("Included");
        String excluded = rs.getString("Excluded");
        double ordinaryPriceForChild = rs.getDouble("OrdinaryPriceForChild");
        double ordinaryPriceForAdult = rs.getDouble("OrdinaryPriceForAdult");
        String keywords = rs.getString("Keywords");
        String departureLocation = rs.getString("DepartureLocation");
        String departureTime = rs.getString("DepartureTime");
        String googleDescription = rs.getString("GoogleDescription");
        String mainDescription = rs.getString("MainDescription");
        String promotionJson = rs.getString("PromotionJson");
        double rate = rs.getDouble("Rate");
        int numberRAtes = rs.getInt("NumberRate");
        String providerImage = rs.getString("Image");
        String packageType = rs.getString("PackageType");
        int youtripperPercentage = rs.getInt("YouTripperPercentage");
        String additionalDescription = rs.getString("AddtionalDescription");
        double coverPosition = rs.getDouble("CoverPosition");

        return null;
    }
}
