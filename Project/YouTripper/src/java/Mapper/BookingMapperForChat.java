/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.BookingDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class BookingMapperForChat implements RowMapper<BookingDTO> {

    private static BookingMapperForChat instance = null;

    public BookingMapperForChat() {
    }

    public static BookingMapperForChat getInstance() {
        if (instance == null) {
            instance = new BookingMapperForChat();
        }
        return instance;

    }

    @Override
    public BookingDTO mapRow(ResultSet rs, int i) throws SQLException {
        BookingDTO booking = new BookingDTO(rs.getString("Code"), rs.getString("BookingDate"), rs.getString("ProviderName"),
                rs.getString("TripperName"), rs.getString("PackageName"),rs.getString("CoverImage"),
                rs.getString("providerImage"),rs.getString("tripperImage"),rs.getString("LatestTime"),rs.getInt("NumberNotRead"));
        return booking;
    }

}
