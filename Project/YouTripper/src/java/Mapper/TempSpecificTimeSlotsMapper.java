/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TempSpecificTimeSlotsDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author asus
 */
public class TempSpecificTimeSlotsMapper implements RowMapper<TempSpecificTimeSlotsDTO> {

    private static TempSpecificTimeSlotsMapper instance = null;

    private TempSpecificTimeSlotsMapper() {
    }

    public static TempSpecificTimeSlotsMapper getInstance() {
        if (instance == null) {
            instance = new TempSpecificTimeSlotsMapper();
        }
        return instance;
    }

    @Override
    public TempSpecificTimeSlotsDTO mapRow(ResultSet rs, int i) throws SQLException {
        String timeStr = rs.getString("TimeStr");
        int timeInMinutes = rs.getInt("TimeInMinutes");
        String minute = rs.getString("Minute");
        String hour = rs.getString("Hour");
        int numberOfMinutes = rs.getInt("NumberOfMinute");
        int numberOfHours = rs.getInt("NumberOfHour");
        int maxQuota = rs.getInt("MaxQuota");
        return new TempSpecificTimeSlotsDTO(timeStr, timeInMinutes, minute, hour, numberOfMinutes, numberOfHours, maxQuota);
    }

}
