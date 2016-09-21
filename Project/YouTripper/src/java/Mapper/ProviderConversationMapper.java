/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import JavaClass.ProviderConversation;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class ProviderConversationMapper implements RowMapper<ProviderConversation> {

    public static ProviderConversationMapper instance = null;

    public ProviderConversationMapper() {
    }

    public static ProviderConversationMapper getInstance() {
        if (instance == null) {
            instance = new ProviderConversationMapper();
        }
        return instance;
    }

    @Override
    public ProviderConversation mapRow(ResultSet rs, int i) throws SQLException {
        ProviderConversation result = new ProviderConversation(rs.getString("Message"), rs.getBoolean("isRead"),rs.getString("UserType"), rs.getInt("ConversationID"),rs.getString("Time"), 
                rs.getInt("PackageID"), rs.getInt("NoUnreads"), rs.getInt("ProviderID"), rs.getString("LastName"), rs.getString("Name"),rs.getBoolean("isProviderMarked"));
        return result;
    }

}
