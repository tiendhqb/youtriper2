/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TripperNotificationSetting;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class TripperNotificationSettingMapper implements RowMapper<TripperNotificationSetting>{

    public static TripperNotificationSettingMapper instance = null;

    public TripperNotificationSettingMapper() {
    }

    public static TripperNotificationSettingMapper getInstance() {
        if (instance == null) {
            instance = new TripperNotificationSettingMapper();
        }
        return instance;

    }
    @Override
    public TripperNotificationSetting mapRow(ResultSet rs, int i) throws SQLException {
        TripperNotificationSetting result = new TripperNotificationSetting(rs.getInt("TripperNotificationID"));
    return result;
    }
    
}
