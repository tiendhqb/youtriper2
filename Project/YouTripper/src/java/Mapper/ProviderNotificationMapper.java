/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ProviderNotification;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class ProviderNotificationMapper implements RowMapper<ProviderNotification> {

    public static ProviderNotificationMapper instance = null;

    public ProviderNotificationMapper() {
    }

    public static ProviderNotificationMapper getInstance() {
        if (instance == null) {
            instance = new ProviderNotificationMapper();
        }
        return instance;

    }

    @Override
    public ProviderNotification mapRow(ResultSet rs, int i) throws SQLException {
       ProviderNotification result = new ProviderNotification(rs.getInt("ProviderNotificationID"),rs.getString("Name"));
       return result;
    }

}
