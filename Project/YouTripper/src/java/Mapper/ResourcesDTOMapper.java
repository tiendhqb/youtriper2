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
public class ResourcesDTOMapper implements RowMapper<ResourcesDTO> {

    private static ResourcesDTOMapper instance = null;

    private ResourcesDTOMapper() {
    }

    public static ResourcesDTOMapper getInstance() {
        if (instance == null) {
            instance = new ResourcesDTOMapper();
        }
        return instance;
    }

    @Override
    public ResourcesDTO mapRow(ResultSet rs, int i) throws SQLException {
        int resourceID = rs.getInt("ResourceID");
        String name = rs.getString("Name");
        int noPeople = rs.getInt("NoPeople");
        return new ResourcesDTO(resourceID, name, noPeople);
    }

}
