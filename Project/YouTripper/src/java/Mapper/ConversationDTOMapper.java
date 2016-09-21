/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ConversationDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class ConversationDTOMapper implements RowMapper<ConversationDTO> {

    private static ConversationDTOMapper instance = null;

    private ConversationDTOMapper() {
    }

    public static ConversationDTOMapper getInstance() {
        if (instance == null) {
            instance = new ConversationDTOMapper();
        }
        return instance;
    }

    @Override
    public ConversationDTO mapRow(ResultSet rs, int i) throws SQLException {
        ConversationDTO result = new ConversationDTO(rs.getInt("ConversationID"), rs.getString("Message"),
                rs.getString("LatestTime"),rs.getInt("NumberNotRead"),rs.getString("Name"),rs.getString("CoverImage"),rs.getString("LatestTime"));
        return result;
    }
}
