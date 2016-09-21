/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.UsedResourcesViewDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class UsedResourcesViewDTOMapperForCheckTripperBooking implements RowMapper<UsedResourcesViewDTO> {

    private static UsedResourcesViewDTOMapperForCheckTripperBooking instance = null;

    private UsedResourcesViewDTOMapperForCheckTripperBooking() {
    }

    public static UsedResourcesViewDTOMapperForCheckTripperBooking getInstance() {
        if (instance == null) {
            instance = new UsedResourcesViewDTOMapperForCheckTripperBooking();
        }
        return instance;
    }

    @Override
    public UsedResourcesViewDTO mapRow(ResultSet rs, int i) throws SQLException {
        String tripTime = rs.getString("TripTime");
        int noUsedResources = rs.getInt("NoUsedResources");
        return new UsedResourcesViewDTO(tripTime, noUsedResources);
    }
    
    
}
