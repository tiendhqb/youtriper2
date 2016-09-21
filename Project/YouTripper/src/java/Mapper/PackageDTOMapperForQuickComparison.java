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
public class PackageDTOMapperForQuickComparison implements RowMapper<PackageDTO> {

    private static PackageDTOMapperForQuickComparison instance = null;

    private PackageDTOMapperForQuickComparison() {
    }

    public static PackageDTOMapperForQuickComparison getInstance() {
        if (instance == null) {
            instance = new PackageDTOMapperForQuickComparison();
        }
        return instance;
    }

    @Override
    public PackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        PackageDTO result = new PackageDTO(rs.getInt("PackageID"),rs.getInt("providerID"),rs.getString("providerName"),rs.getString("Name"),
                rs.getString("DurationType"),rs.getInt("Duration"),rs.getInt("MinTripper"),rs.getInt("MaxTripper"),rs.getString("CoverImage"),
                rs.getString("City"),rs.getDouble("OrdinaryPriceForAdult"),rs.getInt("Rate"),
                rs.getInt("NumberRate"),rs.getInt("NoClick"),rs.getString("CategoryName"),rs.getString("Image"));
        return result;
    }

}
