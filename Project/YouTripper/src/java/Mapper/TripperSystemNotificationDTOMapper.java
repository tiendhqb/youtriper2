/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TripperSystemNotificationDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class TripperSystemNotificationDTOMapper implements RowMapper<TripperSystemNotificationDTO> {

    private static TripperSystemNotificationDTOMapper instance = null;

    private TripperSystemNotificationDTOMapper() {
    }

    public static TripperSystemNotificationDTOMapper getInstance() {
        if (instance == null) {
            instance = new TripperSystemNotificationDTOMapper();
        }
        return instance;
    }

    @Override
    public TripperSystemNotificationDTO mapRow(ResultSet rs, int i) throws SQLException {
       TripperSystemNotificationDTO result = new TripperSystemNotificationDTO(rs.getInt("NotificationID"), rs.getString("Content"), rs.getBoolean("Seen"), rs.getString("Date"), rs.getInt("TripperID"));
       return result;
    }

}
