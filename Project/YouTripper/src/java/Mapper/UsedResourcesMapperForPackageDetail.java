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
public class UsedResourcesMapperForPackageDetail implements RowMapper<UsedResourcesViewDTO> {

    private static UsedResourcesMapperForPackageDetail instance = null;

    private UsedResourcesMapperForPackageDetail() {
    }

    public static UsedResourcesMapperForPackageDetail getInstance() {
        if (instance == null) {
            instance = new UsedResourcesMapperForPackageDetail();
        }
        return instance;
    }

    @Override
    public UsedResourcesViewDTO mapRow(ResultSet rs, int i) throws SQLException {
        String tripDate = rs.getString("TripDate");
        String tripTime = rs.getString("TripTime");
        int noUsedResources = rs.getInt("NoUsedResources");

        UsedResourcesViewDTO usedResourcesView = new UsedResourcesViewDTO(tripDate, tripTime, noUsedResources);
        return usedResourcesView;
    }

}
