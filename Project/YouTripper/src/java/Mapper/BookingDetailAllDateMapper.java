/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import JavaClass.BookingDetailAllDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class BookingDetailAllDateMapper implements RowMapper<BookingDetailAllDate> {

    public static BookingDetailAllDateMapper instance = null;

    public BookingDetailAllDateMapper() {
    }

    public static BookingDetailAllDateMapper getInstance() {
        if (instance == null) {
            instance = new BookingDetailAllDateMapper();
        }
        return instance;

    }

    @Override
    public BookingDetailAllDate mapRow(ResultSet rs, int i) throws SQLException {
        return new BookingDetailAllDate(rs.getString("SelectedDate"), rs.getInt("NoBooking"), rs.getInt("NoTripper"));
    }

}
