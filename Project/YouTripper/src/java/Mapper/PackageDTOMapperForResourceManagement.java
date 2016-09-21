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
 * @author Long Nguyen
 */
public class PackageDTOMapperForResourceManagement implements RowMapper<PackageDTO> {

    private static PackageDTOMapperForResourceManagement instance = null;

    private PackageDTOMapperForResourceManagement() {
    }

    public static PackageDTOMapperForResourceManagement getInstance() {
        if (instance == null) {
            instance = new PackageDTOMapperForResourceManagement();
        }
        return instance;
    }

    @Override
    public PackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        int id = rs.getInt("PackageID");
        String name = rs.getString("Name");
        return new PackageDTO(id, name);
    }

}
