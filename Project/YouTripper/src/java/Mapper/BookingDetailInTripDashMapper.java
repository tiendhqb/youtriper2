/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import JavaClass.BookingDetailInTripDash;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class BookingDetailInTripDashMapper implements RowMapper<BookingDetailInTripDash> {

    public static BookingDetailInTripDashMapper instance = null;

    public BookingDetailInTripDashMapper() {
    }

    public static BookingDetailInTripDashMapper getInstance() {
        if (instance == null) {
            instance = new BookingDetailInTripDashMapper();
        }
        return instance;

    }

    @Override
    public BookingDetailInTripDash mapRow(ResultSet rs, int i) throws SQLException {
        BookingDetailInTripDash result = new BookingDetailInTripDash(rs.getInt("PackageID"),rs.getInt("DurationDay"),rs.getInt("DurationHour"),rs.getInt("DurationMinute"),rs.getInt("MaxQuota"),
        rs.getBoolean("IsFreeBooking"),rs.getInt("FreeInterval"),rs.getString("StartOperationTime"),rs.getString("EndOperationTime"));
        return result;
    }

}
