/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ActivityDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class ActivityMapper implements RowMapper<ActivityDTO> {

    private static ActivityMapper instance = null;

    private ActivityMapper() {
    }

    public static ActivityMapper getInstance() {
        if (instance == null) {
            instance = new ActivityMapper();
        }
        return instance;
    }
    
    @Override
    public ActivityDTO mapRow(ResultSet rs, int i) throws SQLException {
        ActivityDTO activityDTO = new ActivityDTO(rs.getInt("ActivityID"), rs.getString("Name"),rs.getInt("SubCategoryID"));
        return activityDTO;
    }
    
}
