/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import JavaClass.BookingStatisticsInTrippDash;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class BookingStatisticsInTrippDashMapper implements RowMapper<BookingStatisticsInTrippDash> {

    private static BookingStatisticsInTrippDashMapper instance = null;

    private BookingStatisticsInTrippDashMapper() {
    }

    public static BookingStatisticsInTrippDashMapper getInstance() {
        if (instance == null) {
            instance = new BookingStatisticsInTrippDashMapper();
        }
        return instance;
    }

    @Override
    public BookingStatisticsInTrippDash mapRow(ResultSet rs, int i) throws SQLException {
       BookingStatisticsInTrippDash result = new BookingStatisticsInTrippDash(rs.getInt("TotalBookings"), rs.getLong("SelectedDateMilliseconds"), rs.getString("selectedDate"));
       return result;
    }

}
