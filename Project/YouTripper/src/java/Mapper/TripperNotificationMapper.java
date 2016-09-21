/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TripperNotification;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class TripperNotificationMapper implements RowMapper<TripperNotification>{
    public static TripperNotificationMapper instance = null;

    public TripperNotificationMapper() {
    }

    public static TripperNotificationMapper getInstance() {
        if (instance == null) {
            instance = new TripperNotificationMapper();
        }
        return instance;

    }
    @Override
    public TripperNotification mapRow(ResultSet rs, int i) throws SQLException {
       TripperNotification result = new TripperNotification(rs.getInt("TripperNotificationID"),rs.getString("Name"));
       return result;
    }
    
}
