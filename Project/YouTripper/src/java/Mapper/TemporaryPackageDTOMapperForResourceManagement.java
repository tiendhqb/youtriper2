/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TemporaryPackageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Long Nguyen
 */
public class TemporaryPackageDTOMapperForResourceManagement implements RowMapper<TemporaryPackageDTO> {

    private static TemporaryPackageDTOMapperForResourceManagement instance = null;

    private TemporaryPackageDTOMapperForResourceManagement() {
    }

    public static TemporaryPackageDTOMapperForResourceManagement getInstance() {
        if (instance == null) {
            instance = new TemporaryPackageDTOMapperForResourceManagement();
        }
        return instance;
    }

    @Override
    public TemporaryPackageDTO mapRow(ResultSet rs, int i) throws SQLException {
         int id = rs.getInt("TemporaryPackageID");
         String name = rs.getString("Name");
         return new TemporaryPackageDTO(id, name);
    }
    
}
