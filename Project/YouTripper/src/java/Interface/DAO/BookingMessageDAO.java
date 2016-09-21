/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.BookingDTO;
import DTO.BookingMessageDTO;
import java.util.List;

/**
 *
 * @author DINH KHANG
 */
public interface BookingMessageDAO {   
    public List<BookingMessageDTO> getBookingMessageByBookingID(String bookingID,int numberOfRecord);
    public boolean deleteBookingMessageByMessageID(int messageID);
    public boolean deleteBookingMessageByBookingID(int bookingID);
    public boolean insertNewBookingMessage(BookingMessageDTO bookingMessage);
    public boolean tripperReadBooking(String bookingID);
    public boolean providerReadBooking(String bookingID);
}
