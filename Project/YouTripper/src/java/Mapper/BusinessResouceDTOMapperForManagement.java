/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.BusinessResourceDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Long Nguyen
 */
public class BusinessResouceDTOMapperForManagement implements RowMapper<BusinessResourceDTO> {

    private static BusinessResouceDTOMapperForManagement instance = null;

    private BusinessResouceDTOMapperForManagement() {
    }

    public static BusinessResouceDTOMapperForManagement getInstance() {
        if (instance == null) {
            instance = new BusinessResouceDTOMapperForManagement();
        }
        return instance;
    }

    @Override
    public BusinessResourceDTO mapRow(ResultSet rs, int i) throws SQLException {
        int businessResourceID = rs.getInt("ResourceID");
        String resourceName = rs.getString("Name");

        int capacity;
        try {
            capacity = rs.getInt("Capacity");
        } catch (Exception e) {
            capacity = 0;
        }

        int noSkills;
        try {
            noSkills = rs.getInt("NoSkills");
        } catch (Exception e) {
            noSkills = 0;
        }

        int skillID;
        try {
            skillID = rs.getInt("SkillID");
        } catch (Exception e) {
            skillID = 0;
        }
        
        return new BusinessResourceDTO(businessResourceID, resourceName, capacity, noSkills, skillID);
    }

}
