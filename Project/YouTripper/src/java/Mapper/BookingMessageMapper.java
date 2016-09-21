/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.BookingMessageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class BookingMessageMapper implements RowMapper<BookingMessageDTO> {

    private static BookingMessageMapper instance = null;

    public BookingMessageMapper() {
    }

    public static BookingMessageMapper getInstance() {
        if (instance == null) {
            instance = new BookingMessageMapper();
        }
        return instance;
    }

    @Override
    public BookingMessageDTO mapRow(ResultSet rs, int i) throws SQLException {
        BookingMessageDTO bookingMessage = new BookingMessageDTO(rs.getInt("MessageID"), rs.getString("UserType"), rs.getString("Message"), rs.getString("Time"), rs.getInt("UserID"), rs.getString("BookingID"), rs.getString("Name"), rs.getString("Avatar"), rs.getBoolean("isRead"));
        return bookingMessage;
    }

}
