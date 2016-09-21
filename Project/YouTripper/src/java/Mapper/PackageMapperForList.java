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
public class PackageMapperForList implements RowMapper<PackageDTO> {

    private static PackageMapperForList instance = null;

    private PackageMapperForList() {
    }

    public static PackageMapperForList getInstance() {
        if (instance == null) {
            instance = new PackageMapperForList();
        }
        return instance;
    }

    @Override
    public PackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        return new PackageDTO(rs.getInt("PackageID"), rs.getInt("ProviderID"), rs.getString("LastName"), rs.getString("Name"),
                rs.getString("CoverImage"), rs.getDouble("OrdinaryPriceForAdult"), rs.getDouble("Rate"), rs.getInt("NumberRate"));
    }

}
