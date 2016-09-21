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
public class UsedResourcesViewDTOMapperForBookingEngine implements RowMapper<UsedResourcesViewDTO> {

    private static UsedResourcesViewDTOMapperForBookingEngine instance = null;

    private UsedResourcesViewDTOMapperForBookingEngine() {
    }

    public static UsedResourcesViewDTOMapperForBookingEngine getInstance() {
        if (instance == null) {
            instance = new UsedResourcesViewDTOMapperForBookingEngine();
        }
        return instance;
    }

    @Override
    public UsedResourcesViewDTO mapRow(ResultSet rs, int i) throws SQLException {
        int resourceID = rs.getInt("ResourceID");
        String tripDate = rs.getString("TripDate");
        String tripTime = rs.getString("TripTime");
        int noUsedResources = rs.getInt("NoUsedResources");
        
        UsedResourcesViewDTO usedResourcesView = new UsedResourcesViewDTO(resourceID, tripDate, tripTime, noUsedResources);
        return usedResourcesView;
    }

}
