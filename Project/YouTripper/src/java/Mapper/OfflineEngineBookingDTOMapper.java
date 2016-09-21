/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.OfflineBookingEngineDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class OfflineEngineBookingDTOMapper implements RowMapper<OfflineBookingEngineDTO> {

    private static OfflineEngineBookingDTOMapper instance = null;

    private OfflineEngineBookingDTOMapper() {
    }

    public static OfflineEngineBookingDTOMapper getInstance() {
        if (instance == null) {
            instance = new OfflineEngineBookingDTOMapper();
        }
        return instance;
    }

    @Override
    public OfflineBookingEngineDTO mapRow(ResultSet rs, int i) throws SQLException {
        int bookingID = rs.getInt("BookingID");
        String bookingDate = rs.getString("BookingDate");
        String selectedDate = rs.getString("SelectedDate");
        String selectedTime = rs.getString("SelectedTime");
        int noPackages = rs.getInt("NoPackages");
        int offlinePackageID = rs.getInt("OfflinePackageID");
        String packageName = rs.getString("PackageName");
        int resourceID = rs.getInt("ResourceID");
        int minimumNoResources = rs.getInt("MinimumNoResource");
        int duration = rs.getInt("Duration");
        String durationType = rs.getString("DurationType");
        String color = rs.getString("Color");
        return new OfflineBookingEngineDTO(bookingID, bookingDate, selectedDate, selectedTime,
                noPackages, offlinePackageID, packageName, resourceID, minimumNoResources, duration, durationType, color);
    }

}
