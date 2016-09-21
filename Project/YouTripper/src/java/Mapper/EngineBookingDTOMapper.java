/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.EngineBookingDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class EngineBookingDTOMapper implements RowMapper<EngineBookingDTO> {

    private static EngineBookingDTOMapper instance = null;

    private EngineBookingDTOMapper() {
    }

    public static EngineBookingDTOMapper getInstance() {
        if (instance == null) {
            instance = new EngineBookingDTOMapper();
        }
        return instance;
    }

    @Override
    public EngineBookingDTO mapRow(ResultSet rs, int i) throws SQLException {
        String bookingID = rs.getString("BookingID");
        String bookingDate = rs.getString("BookingDate");
        String selectedDate = rs.getString("SelectedDate");
        String selectedTime = rs.getString("SelectedTime");
        int noPackages = rs.getInt("NoPackages");
        int packageID = rs.getInt("PackageID");
        String packageName = rs.getString("PackageName");
        String durationType = rs.getString("DurationType");
        int duration = rs.getInt("Duration");
        String startOperationTime = rs.getString("StartOperationTime");
        String endOperationTime = rs.getString("EndOperationTime");
        boolean isFreeBooking = rs.getBoolean("IsFreeBooking");
        int freeInterval = rs.getInt("FreeInterval");
        int fixedHour = rs.getInt("FixedHour");
        int fixedMinute = rs.getInt("FixedMinute");
        int resourceID = rs.getInt("ResourceID");
        int minimumResources = rs.getInt("MinimumResources");
        String color = rs.getString("Color");
        return new EngineBookingDTO(bookingID, bookingDate, selectedDate, selectedTime, noPackages,
                packageID, packageName, durationType, duration, startOperationTime, endOperationTime,
                isFreeBooking, freeInterval, fixedHour, fixedMinute, resourceID, minimumResources, color);
    }

}
