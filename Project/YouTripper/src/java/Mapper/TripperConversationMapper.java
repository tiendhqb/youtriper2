/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import JavaClass.TripperConversation;
import static Mapper.ProviderConversationMapper.instance;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class TripperConversationMapper implements RowMapper<TripperConversation> {

    public static TripperConversationMapper instance = null;

    public TripperConversationMapper() {
    }

    public static TripperConversationMapper getInstance() {
        if (instance == null) {
            instance = new TripperConversationMapper();
        }
        return instance;
    }

    @Override
    public TripperConversation mapRow(ResultSet rs, int i) throws SQLException {
        TripperConversation result = new TripperConversation(rs.getString("Message"), rs.getBoolean("isRead"), rs.getString("UserType"), rs.getInt("ConversationID"), rs.getString("Time"),
                rs.getInt("PackageID"), rs.getInt("NoUnreads"), rs.getInt("TripperID"), rs.getString("Name"), rs.getBoolean("isTripperMarked"));
        return result;
    }

}
