/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.OfflineBookingDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Long Nguyen
 */
public class OfflineBookingDTOMapperForBookingEngine implements RowMapper<OfflineBookingDTO> {

    private static OfflineBookingDTOMapperForBookingEngine instance = null;

    private OfflineBookingDTOMapperForBookingEngine() {
    }

    public static OfflineBookingDTOMapperForBookingEngine getInstance() {
        if (instance == null) {
            instance = new OfflineBookingDTOMapperForBookingEngine();
        }
        return instance;
    }

    @Override
    public OfflineBookingDTO mapRow(ResultSet rs, int i) throws SQLException {
        int offlineBookingID = rs.getInt("OfflineBookingID");
        int days = rs.getInt("Days");
        int hours = rs.getInt("Hours");
        int minutes = rs.getInt("Minutes");
        String dateStr = rs.getString("DateStr");
        String timeStr = rs.getString("TimeStr");
        return new OfflineBookingDTO(offlineBookingID, days, hours, minutes, dateStr, timeStr);
    }

}
