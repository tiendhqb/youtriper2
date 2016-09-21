/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.Service;

import DTO.BookingDTO;
import DTO.BookingMessageDTO;
import DTO.ConversationDTO;
import DTO.ConversationMessageDTO;
import Interface.DAO.BookingDAO;
import Interface.DAO.BookingMessageDAO;
import Interface.DAO.ConversationDAO;
import Interface.Service.MessageService;
import JavaClass.TripperConversation;
import com.google.gson.Gson;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author DINH KHANG
 */
public class MessageServiceImpl implements MessageService {

    @Autowired
    BookingDAO bookingDAO;

    @Autowired
    BookingMessageDAO bookingMessageDAO;

    @Autowired
    ConversationDAO conversationDAO;

    private final Gson gson;

    public MessageServiceImpl() {
        gson = new Gson();
    }

    @Override
    public boolean sendBookingMessage(String message, String userType, int userID, String bookingID) {
        BookingMessageDTO mybookingMess = new BookingMessageDTO(userType, message, String.valueOf(System.currentTimeMillis()), userID, bookingID, false);
        return bookingMessageDAO.insertNewBookingMessage(mybookingMess);
    }

    @Override
    public List<BookingDTO> getBookingListByTripperID(int tripperID) {
        List<BookingDTO> result = bookingDAO.getBookingListByTripperID(tripperID);
        return result;
    }

    @Override
    public List<BookingDTO> getBookingListByProviderID(int providerID) {
        List<BookingDTO> result = bookingDAO.getBookingListByProviderID(providerID);
        return result;
    }

    @Override
    public List<BookingMessageDTO> getBookingMessageByBookingID(String bookingID, int numberOfRecord) {
        List<BookingMessageDTO> result = bookingMessageDAO.getBookingMessageByBookingID(bookingID, numberOfRecord);
        return result;
    }

    @Override
    public String getListConversationbyProviderID(int providerID) {
        List<ConversationDTO> result = conversationDAO.getListConversationbyProviderID(providerID);
        return gson.toJson(result);
    }

    @Override
    public String getListConversationbyTripperID(int tripperID) {
        List<TripperConversation> result = conversationDAO.getListConversationbyTripperID(tripperID);
        return gson.toJson(result);
    }

    @Override
    public Integer getConversationID(int providerID, int tripperID, int conversationID) {
        return conversationDAO.getConversationID(providerID, tripperID, conversationID);
    }

    @Override
    public String sendConversationMessage(String message, String userType, int userID, int conversationID) {
        ConversationMessageDTO conversationMessage = new ConversationMessageDTO(userType, String.valueOf(System.currentTimeMillis()), message, userID, conversationID, false);
        return gson.toJson(conversationDAO.sendConversationMessage(conversationMessage));
    }

    @Override
    public String getConversationMessageByConversationID(int conversationID, int numberOfRecord) {
        String result;
        List<ConversationMessageDTO> conversation = conversationDAO.getConversationMessageByConversationID(conversationID, numberOfRecord);
        result = gson.toJson(conversation);
        return result;
    }

    @Override
    public int getTripperIDByConversationID(int conversationID) {
        return conversationDAO.getTripperIDByConversationID(conversationID);
    }

    @Override
    public int getProviderIDByConversationID(int conversationID) {
        return conversationDAO.getProviderIDByConversationID(conversationID);
    }

    @Override
    public int getTripperIDByBookingCode(String bookingCode) {
        return bookingDAO.getTripperIDByBookingCode(bookingCode);
    }

    @Override
    public int getProviderIDByBookingCode(String bookingCode) {
        return bookingDAO.getProviderIDByBookingCode(bookingCode);
    }

    @Override
    public boolean tripperReadBooking(String bookingID) {
        return bookingMessageDAO.tripperReadBooking(bookingID);
    }

    @Override
    public boolean providerReadBooking(String bookingID) {
        return bookingMessageDAO.providerReadBooking(bookingID);
    }

    @Override
    public boolean tripperReadConv(int conversationID, int tripperID) {
        return conversationDAO.tripperReadConv(conversationID, tripperID);
    }

    @Override
    public boolean providerReadConv(int conversationID) {
        return conversationDAO.providerReadConv(conversationID);
    }

    @Override
    public String getConversationMessageByConversationID(int conversationID, int numberOfRecord, int tripperID) {
        String result;
        List<ConversationMessageDTO> conversation = conversationDAO.getConversationMessageByConversationID(conversationID, numberOfRecord, tripperID);
        result = gson.toJson(conversation);
        return result;
    }

    @Override
    public boolean sendConversationMessage(String message, String userType, int userID, int conversationID, int ReplyTotripperID) {
        ConversationMessageDTO conversationMessage = new ConversationMessageDTO(userType, String.valueOf(System.currentTimeMillis()), message, userID, conversationID, false);
        return conversationDAO.sendConversationMessage(conversationMessage, ReplyTotripperID);
    }

    @Override
    public String loadMoreMessage(int conversationID, int tripperID, int numberOfRecord) {
        return gson.toJson(conversationDAO.loadMoreMessage(conversationID, tripperID, numberOfRecord));
    }

    @Override
    public String providerLoadConversationList(int providerID) {
        return gson.toJson(conversationDAO.providerLoadConversationList(providerID));
    }

    @Override
    public String getConvMessage(int conversationID,String userType, int numberOfRecord,String time) {
        String result;
        List<ConversationMessageDTO> conversation = conversationDAO.getConvMessage(conversationID,userType, numberOfRecord,time);
        result = gson.toJson(conversation);
        return result;
    }

}
