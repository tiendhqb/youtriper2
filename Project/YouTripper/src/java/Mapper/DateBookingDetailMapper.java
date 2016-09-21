/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import JavaClass.DateBookingDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class DateBookingDetailMapper implements RowMapper<DateBookingDetail> {

    public static DateBookingDetailMapper instance = null;

    public DateBookingDetailMapper() {
    }

    public static DateBookingDetailMapper getInstance() {
        if (instance == null) {
            instance = new DateBookingDetailMapper();
        }
        return instance;

    }

    @Override
    public DateBookingDetail mapRow(ResultSet rs, int i) throws SQLException {
        return new DateBookingDetail(rs.getInt("TripperID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Image"),
                rs.getInt("PackageID"), rs.getString("PackageName"), rs.getInt("NoTripper"), rs.getString("BookingDate"), rs.getString("Code"));
    }

}
