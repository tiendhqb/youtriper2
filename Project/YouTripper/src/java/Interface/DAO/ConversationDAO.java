/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.ConversationDTO;
import DTO.ConversationMessageDTO;
import JavaClass.ProviderConversation;
import JavaClass.TripperConversation;
import java.util.List;

/**
 *
 * @author DINH KHANG
 */
public interface ConversationDAO {

    public int getConversationID(int providerID, int tripperID,int conversationID);

    public List<ConversationDTO> getListConversationbyProviderID(int providerID);

    public List<TripperConversation> getListConversationbyTripperID(int tripperID);

    public ConversationMessageDTO sendConversationMessage(ConversationMessageDTO conversationMessage);
    
    public boolean sendConversationMessage(ConversationMessageDTO conversationMessage,int replyToTripperID);

    public List<ConversationMessageDTO> getConversationMessageByConversationID(int conversationID, int numberOfRecord);
    
    public List<ConversationMessageDTO> getConversationMessageByConversationID(int conversationID, int numberOfRecord,int tripperID);

    public int getTripperIDByConversationID(int conversationID);

    public int getProviderIDByConversationID(int conversationID);

    public boolean tripperReadConv(int conversationID,int tripperID);

    public boolean providerReadConv(int conversationID);
    
    public List<ConversationMessageDTO> loadMoreMessage(int conversationID,int tripperID,int numberOfRecord);
    
    public List<ProviderConversation> providerLoadConversationList(int providerID);
    
    public List<ConversationMessageDTO> getConvMessage(int conversationID,String userType, int numberOfRecord,String time);
}
