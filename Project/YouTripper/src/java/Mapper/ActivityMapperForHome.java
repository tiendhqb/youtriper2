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
public class ActivityMapperForHome implements RowMapper<ActivityDTO> {

    private static ActivityMapperForHome instance = null;

    private ActivityMapperForHome() {
    }

    public static ActivityMapperForHome getInstance() {
        if (instance == null) {
            instance = new ActivityMapperForHome();
        }
        return instance;
    }

    @Override
    public ActivityDTO mapRow(ResultSet rs, int i) throws SQLException {
        ActivityDTO activityDTO = new ActivityDTO(rs.getInt("ActivityID"), rs.getString("Name"), rs.getString("Image"), rs.getInt("TotalRecords"));
        return activityDTO;
    }
}
