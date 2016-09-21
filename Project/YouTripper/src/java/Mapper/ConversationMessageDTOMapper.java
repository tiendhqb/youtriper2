/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ConversationMessageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class ConversationMessageDTOMapper implements RowMapper<ConversationMessageDTO> {

    private static ConversationMessageDTOMapper instance = null;

    private ConversationMessageDTOMapper() {
    }

    public static ConversationMessageDTOMapper getInstance() {
        if (instance == null) {
            instance = new ConversationMessageDTOMapper();
        }
        return instance;
    }

    @Override
    public ConversationMessageDTO mapRow(ResultSet rs, int i) throws SQLException {
      ConversationMessageDTO conversationMessage = new ConversationMessageDTO(rs.getInt("MessageID"), rs.getString("UserType"), 
              rs.getString("Time"), rs.getString("Message"), rs.getInt("UserID"), rs.getInt("ConversationID"),
              rs.getString("LastName"),rs.getString("Image"),rs.getBoolean("isRead"));
      return conversationMessage;
    }

}
