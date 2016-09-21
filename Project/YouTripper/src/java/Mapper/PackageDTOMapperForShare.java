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
public class PackageDTOMapperForShare implements RowMapper<PackageDTO>{
    private static PackageDTOMapperForShare instance = null;

    private PackageDTOMapperForShare() {
    }

    public static PackageDTOMapperForShare getInstance() {
        if (instance == null) {
            instance = new PackageDTOMapperForShare();
        }
        return instance;
    }
    @Override
    public PackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        PackageDTO result = new PackageDTO(rs.getInt("PackageID"), rs.getInt("ProviderID"),rs.getString("LastName"),rs.getString("Name"), rs.getString("CoverImage"),rs.getDouble("OrdinaryPriceForAdult"),rs.getInt("NumberRate"),rs.getString("Image"));
        return result;
    }
    
}
