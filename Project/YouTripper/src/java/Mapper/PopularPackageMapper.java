/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.PopularPackageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class PopularPackageMapper implements RowMapper<PopularPackageDTO> {
    
     private static PopularPackageMapper instance = null;

    private PopularPackageMapper() {
    }

    public static PopularPackageMapper getInstance() {
        if (instance == null) {
            instance = new PopularPackageMapper();
        }
        return instance;
    }

    @Override
    public PopularPackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        return new PopularPackageDTO(rs.getInt("PackageID"), rs.getString("Name"));
    }
    
}
