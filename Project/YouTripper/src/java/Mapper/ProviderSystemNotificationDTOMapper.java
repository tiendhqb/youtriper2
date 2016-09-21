/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ProviderSystemNotificationDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class ProviderSystemNotificationDTOMapper implements RowMapper<ProviderSystemNotificationDTO> {

    private static ProviderSystemNotificationDTOMapper instance = null;

    private ProviderSystemNotificationDTOMapper() {
    }

    public static ProviderSystemNotificationDTOMapper getInstance() {
        if (instance == null) {
            instance = new ProviderSystemNotificationDTOMapper();
        }
        return instance;
    }

    @Override
    public ProviderSystemNotificationDTO mapRow(ResultSet rs, int i) throws SQLException {
        ProviderSystemNotificationDTO result = new ProviderSystemNotificationDTO(rs.getInt("NotificationID"), rs.getString("Content"), rs.getBoolean("Seen"), rs.getString("Date"), rs.getInt("ProviderID"));
        return result;
    }

}
