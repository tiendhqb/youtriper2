/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.PackageDTO;
import DTO.TemporaryPackageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class PackageDTOMapperForPayment implements RowMapper<PackageDTO> {

    private static PackageDTOMapperForPayment instance = null;

    private PackageDTOMapperForPayment() {
    }

    public static PackageDTOMapperForPayment getInstance() {
        if (instance == null) {
            instance = new PackageDTOMapperForPayment();
        }
        return instance;
    }

    @Override
    public PackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        int id = rs.getInt("PackageID");
        String name = rs.getString("Name");
        int minTripper = rs.getInt("MinTripper");
        int maxTripper = rs.getInt("MaxTripper");
        String coverImage = rs.getString("CoverImage");
        String endDate = rs.getString("EndDate");
        String startDate = rs.getString("StartDate");
        String unavailableDays = rs.getString("unavailableDays");
        String country = rs.getString("Country");
        String city = rs.getString("City");
        String state = rs.getString("State");
        double ordinaryPriceForAdult = rs.getDouble("OrdinaryPriceForAdult");
        String promotionJson = rs.getString("PromotionJson");
        int providerID = rs.getInt("ProviderID");
        int youTripperPercentage = rs.getInt("YouTripperPercentage");
        return new PackageDTO(id, name, minTripper, maxTripper, coverImage, startDate, endDate, unavailableDays, country, city,
                state, ordinaryPriceForAdult, promotionJson, providerID,youTripperPercentage);
    }

}
