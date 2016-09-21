/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.TripperSystemNotificationDTO;
import Interface.DAO.TripperSystemNotificationDAO;
import Mapper.TripperSystemNotificationDTOMapper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author DINH KHANG
 */
public class TripperSystemNotificationDAOImpl implements TripperSystemNotificationDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public TripperSystemNotificationDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public boolean insertNewTripperSystemNotification(String content, boolean seen, int tripperID) {
        String sql = "Insert INTO TripperSystemNotification VALUES(?,?,?,?)";
        Date date = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        jdbcTemplate.update(sql, content, seen, formatter.format(date), tripperID);
        return true;
    }

    @Override
    public boolean seenNotification(int notificationID) {
        String sql = "Update TripperSystemNotification"
                + " SET Seen = 1"
                + " Where NotificationID = ?";
        jdbcTemplate.update(sql, notificationID);
        return true;
    }

    @Override
    public List<TripperSystemNotificationDTO> getTripperNewNotification(int tripperID) {
        String sql = "Select *"
                + " FROM TripperSystemNotification"
                + " Where TripperID = ? and seen = 0";
        List<TripperSystemNotificationDTO> result = jdbcTemplate.query(sql, TripperSystemNotificationDTOMapper.getInstance(), tripperID);
        return result;
    }

    @Override
    public boolean seenMessage(int tripperID) {
              String sql = "Update TripperSystemNotification"
                + " SET Seen = 1"
              + " Where TripperID = ? and Content like '%You have a new message in%'";
        jdbcTemplate.update(sql, tripperID);
        return true;
    }
}
