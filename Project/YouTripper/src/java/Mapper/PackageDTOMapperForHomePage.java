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
 * @author DINH KHANG
 */
public class PackageDTOMapperForHomePage implements RowMapper<PackageDTO> {

    private static PackageDTOMapperForHomePage instance = null;

    private PackageDTOMapperForHomePage() {
    }

    public static PackageDTOMapperForHomePage getInstance() {
        if (instance == null) {
            instance = new PackageDTOMapperForHomePage();
        }
        return instance;
    }

    @Override
    public PackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        int packageID = rs.getInt("PackageID");
        String packageName = rs.getString("PackageName");
        String coverImage = rs.getString("CoverImage");
        double youtripperPrice = rs.getDouble("YoutripperPrice");
        String priceCurrency = rs.getString("PriceCurrency");
        String city = rs.getString("City");
        String country = rs.getString("Country");
        int noClick = rs.getInt("NoClick");
        
        PackageDTO result = new PackageDTO(packageID, packageName, coverImage, country, city, noClick, youtripperPrice, priceCurrency);
        return result;
    }

}
