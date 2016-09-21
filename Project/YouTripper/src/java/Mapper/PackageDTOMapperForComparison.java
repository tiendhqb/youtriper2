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
public class PackageDTOMapperForComparison implements RowMapper<PackageDTO> {

    private static PackageDTOMapperForComparison instance = null;

    private PackageDTOMapperForComparison() {
    }

    public static PackageDTOMapperForComparison getInstance() {
        if (instance == null) {
            instance = new PackageDTOMapperForComparison();
        }
        return instance;
    }

    @Override
    public PackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        int id = rs.getInt("PackageID");
        String name = rs.getString("Name");
        String coverImage = rs.getString("CoverImage");
        double ordinaryPriceForAdult = rs.getDouble("OrdinaryPriceForAdult");
        int professionlism = rs.getInt("Professionlism");
        int staffAttitude = rs.getInt("StaffAttitude");
        int convenient = rs.getInt("Convenient");
        int satisfaction = rs.getInt("Satisfaction");
        int amenityQuality = rs.getInt("AmenityQuality");
        int cleanliness = rs.getInt("Cleanliness"); 
        return new PackageDTO(id, name, coverImage, ordinaryPriceForAdult, professionlism, staffAttitude, convenient, satisfaction, amenityQuality, cleanliness);
    }
}
