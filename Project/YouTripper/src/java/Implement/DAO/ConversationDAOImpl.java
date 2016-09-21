/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.ConversationDTO;
import DTO.ConversationMessageDTO;
import Interface.DAO.ConversationDAO;
import JavaClass.ProviderConversation;
import JavaClass.TripperConversation;
import Mapper.ConversationDTOMapper;
import Mapper.ConversationMessageDTOMapper;
import Mapper.ProviderConversationMapper;
import Mapper.TripperConversationMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author DINH KHANG
 */
public class ConversationDAOImpl implements ConversationDAO {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;
    
    public ConversationDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public int getConversationID(int providerID, int tripperID, int conversationID) {
        simpleJdbcCall.setProcedureName("getConversationID");
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID)
                .addValue("tripperID", tripperID).addValue("conversationID", conversationID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        int conID = (int) record.get("conversationID");
        String providerName = (String) record.get("providerName");
        String tripperName = (String) record.get("tripperName");
//        String result = "{\"conversationID\":\"" + conID + "\",\"providerName\":\"" + providerName + "\",\"tripperName\":\"" + tripperName + "\"}";
        return conID;
    }

    @Override
    public List<ConversationDTO> getListConversationbyProviderID(int providerID) {
        String sql = "SELECT Conv.ConversationID,Temp.Message,Temp.Time AS LatestTime, Temp.NumberNotRead,Package.Name,Package.CoverImage"
                + "                 FROM [Conversation] AS Conv LEFT JOIN ("
                + "                  SELECT DISTINCT( Conv.ConversationID), Conv.[Message], Conv.[Time], NumberNotRead"
                + "                  FROM ConversationMessage Conv LEFT JOIN ( SELECT COUNT(isRead) As NumberNotRead, ConversationID"
                + "                  FROM ConversationMessage"
                + "                  WHERE isRead = 0 AND UserID != ? AND UserType != 'provider'"
                + "                  GROUP BY ConversationID) TempB ON Conv.ConversationID = TempB.ConversationID, (SELECT MAX(MessageID) As MaxMessage, ConversationID FROM ConversationMessage GROUP BY ConversationID) TableA"
                + "                 WHERE Conv.ConversationID = TableA.ConversationID AND Conv.MessageID = TableA.MaxMessage) Temp"
                + "                 ON Conv.ConversationID = Temp.ConversationID, Tripper, Provider,Package"
                + "                 WHERE Conv.ProviderID = ? AND Conv.ConversationID = Package.PackageID"
                + "                 Group BY Conv.ConversationID,Temp.Message,Temp.Time, Temp.NumberNotRead,Package.Name,Package.CoverImage";
        List<ConversationDTO> conversations = jdbcTemplate.query(sql, ConversationDTOMapper.getInstance(), providerID, providerID);
        for (int i = 0; i < conversations.size(); i++) {
            if (conversations.get(i).getLatestMessage() == null) {
                conversations.get(i).setLatestMessage(" ");
            }
        }
        for (int i = 0; i < conversations.size(); i++) {
            if (conversations.get(i).getTime() != null) {
                long foo = Long.parseLong(conversations.get(i).getTime());
                Date date = new Date(foo);
                DateFormat formatter = new SimpleDateFormat("HH:mm dd/MM/yyyy");
                conversations.get(i).setTime(formatter.format(date));
            }
        }
        return conversations;
    }

    @Override
    public List<TripperConversation> getListConversationbyTripperID(int tripperID) {
        String sql = "Select * FROM LastConversationMessageForTripper Where TripperID = ?";
        List<TripperConversation> conversations = jdbcTemplate.query(sql, TripperConversationMapper.getInstance(),tripperID);
        return conversations;
    }

    @Override
    public ConversationMessageDTO sendConversationMessage(ConversationMessageDTO conversationMessage) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("sendConvMessage").returningResultSet("rs1", ConversationMessageDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("userType", conversationMessage.getUserType())
                .addValue("time", conversationMessage.getTime()).addValue("message", conversationMessage.getMessage())
                .addValue("userID", conversationMessage.getUserID()).addValue("conversationID", conversationMessage.getConversationID());

        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<ConversationMessageDTO> result = (List<ConversationMessageDTO>) record.get("rs1");
        return result.get(0);

    }

    @Override
    public List<ConversationMessageDTO> getConversationMessageByConversationID(int conversationID, int numberOfRecord) {
        String sql = "WITH cte AS"
                + " ("
                + "   SELECT *,"
                + "         DENSE_RANK() OVER (PARTITION BY ReplyToTripperID  ORDER BY Time ASC) AS rn"
                + "   FROM ConversationMessage"
                + "   Where ConversationID = ?"
                + " )"
                + " SELECT TOP (?) * FROM ("
                + " SELECT cte.*,tripper.lastName as Name,Tripper.Image as Avatar"
                + " FROM cte,tripper"
                + " WHERE (rn = 1) and UserType = 'tripper' and userID = tripper.TripperID"
                + " UNION ALL       "
                + " SELECT cte.*,provider.lastName as Name,provider.Image as Avatar"
                + " FROM cte,provider"
                + " WHERE (rn = 1) and UserType = 'provider' and userID = provider.ProviderID"
                + " ) A"
                + " Order BY ReplyToTripperID";
        List<ConversationMessageDTO> messages = jdbcTemplate.query(sql, ConversationMessageDTOMapper.getInstance(), conversationID, numberOfRecord);
        for (int i = 0; i < messages.size(); i++) {
            long foo = Long.parseLong(messages.get(i).getTime());
            Date date = new Date(foo);
            DateFormat formatter = new SimpleDateFormat("HH:mm dd/MM/yyyy");
            messages.get(i).setTime(formatter.format(date));
        }
        return messages;

    }

    @Override
    public int getTripperIDByConversationID(int conversationID) {
        int result;
        String sql = "Select TOP 1 UserID as TripperID"
                + " FROM ConversationMessage"
                + " Where ConversationID = ? and UserType = 'tripper'";
        result = jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

            @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                try {
                    return rs.getInt("TripperID");
                } catch (Exception e) {
                    return 0;
                }
            }
        }, conversationID);
        return result;
    }

    @Override
    public int getProviderIDByConversationID(int conversationID) {
        int result;
        String sql = " Select ProviderID"
                + " FROM Conversation"
                + " Where ConversationID = ?";
        result = jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

            @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                try {
                    return rs.getInt("ProviderID");
                } catch (Exception e) {
                    return 0;
                }
            }
        }, conversationID);
        return result;
    }

    @Override
    public boolean tripperReadConv(int conversationID, int tripperID) {
        String sql = "UPDATE ConversationMessage"
                + " SET isRead = 1"
                + " WHERE ConversationID = ? and UserType = 'provider' and ReplyToTripperID = ?";
        jdbcTemplate.update(sql, conversationID, tripperID);
        return true;
    }

    @Override
    public boolean providerReadConv(int conversationID) {
        String sql = "UPDATE ConversationMessage"
                + " SET isRead = 1"
                + " WHERE ConversationID = ? and UserType = 'tripper'";
        jdbcTemplate.update(sql, conversationID);
        return true;
    }

    @Override
    public List<ConversationMessageDTO> getConversationMessageByConversationID(int conversationID, int numberOfRecord, int tripperID) {
        String sql = "WITH ConversationMess AS (SELECT ConversationMessage.MessageID, ConversationMessage.UserType,ConversationMessage.Time, ConversationMessage.[Message],ConversationMessage.UserID,ConversationID,Tripper.LastName AS Name,Tripper.Image as Avatar, isRead,ConversationMessage.ReplyToTripperID"
                + " FROM ConversationMessage, Tripper"
                + " WHERE ConversationMessage.ConversationID = ? AND ConversationMessage.UserType = 'tripper' and ConversationMessage.UserID = ?"
                + " AND ConversationMessage.UserID = Tripper.TripperID"
                + " UNION ALL"
                + " SELECT  ConversationMessage.MessageID, ConversationMessage.UserType,ConversationMessage.Time, ConversationMessage.[Message],ConversationMessage.UserID,ConversationID, Provider.LastName AS Name,Provider.Image as Avatar, isRead,ConversationMessage.ReplyToTripperID"
                + " FROM ConversationMessage, Provider"
                + " WHERE ConversationMessage.ConversationID = ? AND ConversationMessage.UserType = 'provider' and ConversationMessage.ReplyToTripperID = ?"
                + " AND ConversationMessage.UserID = Provider.ProviderID)"
                + " SELECT TOP (?) *"
                + " FROM ConversationMess"
                + " ORDER BY MessageID DESC";
        List<ConversationMessageDTO> messages = jdbcTemplate.query(sql, ConversationMessageDTOMapper.getInstance(), conversationID, tripperID, conversationID, tripperID, numberOfRecord);
        for (int i = 0; i < messages.size(); i++) {
            long foo = Long.parseLong(messages.get(i).getTime());
            Date date = new Date(foo);
            DateFormat formatter = new SimpleDateFormat("HH:mm dd/MM/yyyy");
            messages.get(i).setTime(formatter.format(date));
        }
        return messages;

    }

    @Override
    public boolean sendConversationMessage(ConversationMessageDTO conversationMessage, int replyToTripperID) {
        String sql = "Insert Into ConversationMessage Values(?,?,?,?,?,0,?)";
        jdbcTemplate.update(sql, conversationMessage.getUserType(), conversationMessage.getTime(), conversationMessage.getMessage(), conversationMessage.getUserID(), conversationMessage.getConversationID(), replyToTripperID);
        return true;
    }

    @Override
    public List<ConversationMessageDTO> loadMoreMessage(int conversationID, int tripperID, int numberOfRecord) {
        String sql = "WITH ConversationMess AS (Select TOP (?) ConversationMessage.*"
                + " FROM ConversationMessage"
                + " Where ConversationID = ? and ReplyToTripperID = ? "
                + "ORDER BY ConversationMessage.MessageID DESC)"
                + ""
                + " Select ConversationMess.*,Tripper.Image as Avatar,Tripper.LastName as Name"
                + " FROM ConversationMess,Tripper"
                + " Where ConversationMess.UserType = 'tripper' and ConversationMess.UserID = Tripper.TripperID"
                + " UNION ALL"
                + " Select ConversationMess.*,Provider.Image as Avatar,Provider.LastName as Name"
                + " FROM ConversationMess,Provider"
                + " Where ConversationMess.UserType = 'provider' and ConversationMess.UserID = Provider.ProviderID";
        List<ConversationMessageDTO> result = jdbcTemplate.query(sql, ConversationMessageDTOMapper.getInstance(), numberOfRecord, conversationID, tripperID);
        for (int i = 0; i < result.size(); i++) {
            long foo = Long.parseLong(result.get(i).getTime());
            Date date = new Date(foo);
            DateFormat formatter = new SimpleDateFormat("HH:mm dd/MM/yyyy");
            result.get(i).setTime(formatter.format(date));
        }
        return result;
    }

    @Override
    public List<ProviderConversation> providerLoadConversationList(int providerID) {
        String sql = "Select * FROM LastConversationMessageForProvider Where ProviderID = ?";
        List<ProviderConversation> result = jdbcTemplate.query(sql, ProviderConversationMapper.getInstance(), providerID);
        return result;
    }

    @Override
    public List<ConversationMessageDTO> getConvMessage(int conversationID, String userType, int numberOfRecord, String time) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getConvMessage").returningResultSet("rs1", ConversationMessageDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("time", time)
                .addValue("conversationID", conversationID).addValue("numberOfRecord", numberOfRecord).addValue("userType", userType);

        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<ConversationMessageDTO> result = (List<ConversationMessageDTO>) record.get("rs1");      
        return result;
    }

}
