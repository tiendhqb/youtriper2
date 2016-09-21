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
public class PackageListMapperForTrippDash implements RowMapper<PackageDTO> {

    private static PackageListMapperForTrippDash instance = null;

    private PackageListMapperForTrippDash() {
    }

    public static PackageListMapperForTrippDash getInstance() {
        if (instance == null) {
            instance = new PackageListMapperForTrippDash();
        }
        return instance;
    }

    @Override
    public PackageDTO mapRow(ResultSet rs, int i) throws SQLException {
       PackageDTO result = new PackageDTO(rs.getInt("PackageID"), rs.getString("PackageName"));
       return result;
    }

}
