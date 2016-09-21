/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import JavaClass.ListBookingInTripDash;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class ListBookingInTripDashMapper implements RowMapper<ListBookingInTripDash> {

    public static ListBookingInTripDashMapper instance = null;

    public ListBookingInTripDashMapper() {
    }

    public static ListBookingInTripDashMapper getInstance() {
        if (instance == null) {
            instance = new ListBookingInTripDashMapper();
        }
        return instance;
    }

    @Override
    public ListBookingInTripDash mapRow(ResultSet rs, int i) throws SQLException {
        ListBookingInTripDash result = new ListBookingInTripDash(rs.getInt("NoTrippers"),rs.getBoolean("isOffline"), rs.getString("BuyerName"),
                rs.getString("LastName"), rs.getString("SelectedDate"),rs.getLong("SelectedDateMilliseconds"), rs.getString("PackageTitle"),rs.getString("OfflineType")
        ,rs.getString("PackageType"));
        return result;
    }

}
