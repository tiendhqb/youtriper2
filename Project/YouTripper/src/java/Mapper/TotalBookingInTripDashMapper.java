/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import JavaClass.TotalBookingInTripDash;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class TotalBookingInTripDashMapper implements RowMapper<TotalBookingInTripDash> {

    private static TotalBookingInTripDashMapper instance = null;

    private TotalBookingInTripDashMapper() {
    }

    public static TotalBookingInTripDashMapper getInstance() {
        if (instance == null) {
            instance = new TotalBookingInTripDashMapper();
        }
        return instance;
    }

    @Override
    public TotalBookingInTripDash mapRow(ResultSet rs, int i) throws SQLException {
        TotalBookingInTripDash result = new TotalBookingInTripDash(rs.getInt("NoBookedResources"),rs.getInt("NoFilledQuotas"),rs.getInt("TotalBookings"),rs.getInt("TotalSales"));
        return result;
    }

}
