/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.LocationDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class LocationDTOMapper implements RowMapper<LocationDTO> {
    
     private static LocationDTOMapper instance = null;

    private LocationDTOMapper() {
    }

    public static LocationDTOMapper getInstance() {
        if (instance == null) {
            instance = new LocationDTOMapper();
        }
        return instance;
    }

    @Override
    public LocationDTO mapRow(ResultSet rs, int i) throws SQLException {
        return new LocationDTO(rs.getString("Country"), rs.getString("City"));
    }
    
}
