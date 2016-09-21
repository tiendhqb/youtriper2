/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ProviderNotificationSetting;
import static Mapper.BookingDTOMapperForSale.instance;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class ProviderNotificationSetttingMapper implements RowMapper<ProviderNotificationSetting> {

    public static ProviderNotificationSetttingMapper instance = null;

    public ProviderNotificationSetttingMapper() {
    }

    public static ProviderNotificationSetttingMapper getInstance() {
        if (instance == null) {
            instance = new ProviderNotificationSetttingMapper();
        }
        return instance;

    }

    @Override
    public ProviderNotificationSetting mapRow(ResultSet rs, int i) throws SQLException {
    ProviderNotificationSetting result = new ProviderNotificationSetting(rs.getInt("ProviderNotificationID"));
    return result;
    }

}
