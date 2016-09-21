/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ResourceDTOv2;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class ResourceDTOv2Mapper implements RowMapper<ResourceDTOv2> {

    private static ResourceDTOv2Mapper instance = null;

    private ResourceDTOv2Mapper() {
    }

    public static ResourceDTOv2Mapper getInstance() {
        if (instance == null) {
            instance = new ResourceDTOv2Mapper();
        }
        return instance;
    }

    @Override
    public ResourceDTOv2 mapRow(ResultSet rs, int i) throws SQLException {
        ResourceDTOv2 result = new ResourceDTOv2(rs.getInt("ResourceID"), rs.getString("ResourceName"),rs.getInt("MaximunCapacity"),rs.getInt("ProviderID"));
        return result;
    }



}
