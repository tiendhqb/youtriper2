/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Service;

import DTO.BookingDTO;
import DTO.BookingMessageDTO;
import DTO.ConversationDTO;
import java.util.List;

/**
 *
 * @author DINH KHANG
 */
public interface MessageService {

    public boolean sendBookingMessage(String message, String userType, int userID, String bookingID);

    public List<BookingDTO> getBookingListByTripperID(int tripperID);

    public List<BookingDTO> getBookingListByProviderID(int providerID);

    public List<BookingMessageDTO> getBookingMessageByBookingID(String bookingID, int numberOfRecord);

    public Integer getConversationID(int providerID, int tripperID, int conversationID);

    public String getListConversationbyProviderID(int providerID);

    public String getListConversationbyTripperID(int tripperID);

    public String sendConversationMessage(String message, String userType, int userID, int conversationID);

    public boolean sendConversationMessage(String message, String userType, int userID, int conversationID, int ReplyTotripperID);

    public String getConversationMessageByConversationID(int conversationID, int numberOfRecord);

    public String getConversationMessageByConversationID(int conversationID, int numberOfRecord, int tripperID);

    public int getTripperIDByConversationID(int conversationID);

    public int getProviderIDByConversationID(int conversationID);

    public int getTripperIDByBookingCode(String bookingCode);

    public int getProviderIDByBookingCode(String bookingCode);

    public boolean tripperReadBooking(String bookingID);

    public boolean providerReadBooking(String bookingID);

    public boolean tripperReadConv(int conversationID, int tripperID);

    public boolean providerReadConv(int conversationID);

    public String loadMoreMessage(int conversationID, int tripperID, int numberOfRecord);

    //Redesign New Chat
    public String providerLoadConversationList(int providerID);

    public String getConvMessage(int conversationID,String userType, int numberOfRecord,String time);

}
