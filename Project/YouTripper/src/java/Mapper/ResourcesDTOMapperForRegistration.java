/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ResourcesDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class ResourcesDTOMapperForRegistration implements RowMapper<ResourcesDTO> {

    private static ResourcesDTOMapperForRegistration instance = null;

    private ResourcesDTOMapperForRegistration() {
    }

    public static ResourcesDTOMapperForRegistration getInstance() {
        if (instance == null) {
            instance = new ResourcesDTOMapperForRegistration();
        }
        return instance;
    }

    @Override
    public ResourcesDTO mapRow(ResultSet rs, int i) throws SQLException {
        int resourceID = rs.getInt("ResourceID");
        String name = rs.getString("ResourceName");
        String note = rs.getString("Note");
        int noPeople = rs.getInt("MaximunCapacity");
        return new ResourcesDTO(resourceID, name, noPeople, note);
    }
}
