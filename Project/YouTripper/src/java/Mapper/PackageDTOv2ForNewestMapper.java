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
public class PackageDTOv2ForNewestMapper implements RowMapper<PackageDTO> {

    private static PackageDTOv2ForNewestMapper instance = null;

    private PackageDTOv2ForNewestMapper() {
    }

    public static PackageDTOv2ForNewestMapper getInstance() {
        if (instance == null) {
            instance = new PackageDTOv2ForNewestMapper();
        }
        return instance;
    }

    @Override
    public PackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        int packageID = rs.getInt("PackageID");
        String packageName = rs.getString("Name");
        String keywords = rs.getString("Keywords");
        String coverImage = rs.getString("CoverImage");
        String country = rs.getString("Country");
        String city = rs.getString("city");
        double rate = rs.getFloat("Rate");
        int numberOfRate = rs.getInt("NumberRate");
        int providerID = rs.getInt("ProviderID");
        String providerName = rs.getString("LastName");
        String providerImage = rs.getString("ProviderImage");
        double ordinaryPriceForAdult = rs.getFloat("OrdinaryPriceForAdult");
        String categoryIcon = rs.getString("Icon");
        PackageDTO result = new PackageDTO(packageID, providerID, providerName, packageName, coverImage, country, city, ordinaryPriceForAdult, keywords,
                rate, numberOfRate, providerImage,categoryIcon);
        return result;
    }
}
