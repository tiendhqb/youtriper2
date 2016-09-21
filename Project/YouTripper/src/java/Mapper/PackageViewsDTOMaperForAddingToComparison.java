/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.PackagesViewDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class PackageViewsDTOMaperForAddingToComparison implements RowMapper<PackagesViewDTO> {

    public static PackageViewsDTOMaperForAddingToComparison instance = null;

    public PackageViewsDTOMaperForAddingToComparison() {
    }

    public static PackageViewsDTOMaperForAddingToComparison getInstance() {
        if (instance == null) {
            instance = new PackageViewsDTOMaperForAddingToComparison();
        }
        return instance;

    }

    @Override
    public PackagesViewDTO mapRow(ResultSet rs, int i) throws SQLException {
        return new PackagesViewDTO(rs.getInt("PackageID"),rs.getString("Name"),rs.getString("coverImage"));
    }

}
