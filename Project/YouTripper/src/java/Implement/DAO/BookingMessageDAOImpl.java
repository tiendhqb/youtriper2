/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.BookingMessageDTO;
import Interface.DAO.BookingMessageDAO;
import Mapper.BookingMessageMapper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author DINH KHANG
 */
public class BookingMessageDAOImpl implements BookingMessageDAO {

    private JdbcTemplate jdbcTemplate;

    public BookingMessageDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<BookingMessageDTO> getBookingMessageByBookingID(String bookingID, int numberOfRecord) {
        String sql = " WITH ConversationMess AS (SELECT  BookingMessage.MessageID, BookingMessage.UserType,BookingMessage.Time, BookingMessage.[Message],BookingMessage.UserID,BookingID,Tripper.LastName AS Name,Tripper.Image as Avatar, isRead"
                + " FROM BookingMessage, Tripper"
                + " WHERE BookingMessage.BookingID = ? AND BookingMessage.UserType = 'tripper'"
                + " AND BookingMessage.UserID = Tripper.TripperID"
                + ""
                + " UNION ALL "
                + ""
                + " SELECT  BookingMessage.MessageID, BookingMessage.UserType,BookingMessage.Time, BookingMessage.[Message],BookingMessage.UserID,BookingID, Provider.LastName AS Name,Provider.Image as Avatar, isRead"
                + " FROM BookingMessage, Provider"
                + " WHERE BookingMessage.BookingID = ? AND BookingMessage.UserType = 'provider'"
                + " AND BookingMessage.UserID = Provider.ProviderID)"
                + ""
                + " SELECT TOP (?) *"
                + " FROM ConversationMess"
                + " ORDER BY MessageID DESC";
        List<BookingMessageDTO> messages = jdbcTemplate.query(sql, BookingMessageMapper.getInstance(), bookingID, bookingID, numberOfRecord);
        for (int i = 0; i < messages.size(); i++) {
            long foo = Long.parseLong(messages.get(i).getTime());
            Date date = new Date(foo);
            DateFormat formatter = new SimpleDateFormat("HH:mm dd/MM/yyyy");
            messages.get(i).setTime(formatter.format(date));
        }
        return messages;
    }

    @Override
    public boolean deleteBookingMessageByMessageID(int messageID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteBookingMessageByBookingID(int bookingID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertNewBookingMessage(BookingMessageDTO bookingMessage) {
        String sql = "Insert Into BookingMessage Values(?,?,?,?,?,0)";
        jdbcTemplate.update(sql, bookingMessage.getUserType(), bookingMessage.getMessage(), bookingMessage.getTime(), bookingMessage.getUserID(), bookingMessage.getBookID());
        return true;
    }

    @Override
    public boolean tripperReadBooking(String bookingID) {
        String sql = "UPDATE BookingMessage"
                + " SET isRead = 1"
                + " WHERE BookingID = ? and UserType = 'provider'";
        jdbcTemplate.update(sql, bookingID);
        return true;
    }

    @Override
    public boolean providerReadBooking(String bookingID) {
        String sql = "UPDATE BookingMessage"
                + " SET isRead = 1"
                + " WHERE BookingID = ? and UserType = 'tripper'";
        jdbcTemplate.update(sql, bookingID);
        return true;
    }

}
