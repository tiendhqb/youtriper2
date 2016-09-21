/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.ProviderSystemNotificationDTO;
import Interface.DAO.ProviderSystemNotificationDAO;
import Mapper.ProviderSystemNotificationDTOMapper;
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
public class ProviderSystemNotificationDAOImpl implements ProviderSystemNotificationDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public ProviderSystemNotificationDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public boolean insertNewProviderSystemNotification(String content, boolean seen, int providerID) {
        String sql = "Insert Into ProviderSystemNotification VALUES(?,?,?,?)";
        Date date = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        jdbcTemplate.update(sql, content, seen, formatter.format(date), providerID);
        return true;
    }

    @Override
    public List<ProviderSystemNotificationDTO> getProviderNewNotification(int providerID) {
        String sql = "Select *"
                + " FROM ProviderSystemNotification"
                + " Where ProviderID = ? and seen = 0";
        List<ProviderSystemNotificationDTO> result = jdbcTemplate.query(sql, ProviderSystemNotificationDTOMapper.getInstance(), providerID);
        return result;
    }

    @Override
    public boolean seenNotification(int notificationID) {
        String sql = "Update ProviderSystemNotification"
                + " SET Seen = 1"
                + " Where NotificationID = ?";
        jdbcTemplate.update(sql, notificationID);
        return true;
    }

    @Override
    public boolean seenMessage(int providerID) {
                String sql = "Update ProviderSystemNotification"
                + " SET Seen = 1"
                + " Where ProviderID = ? and Content like '%You have a new message in%'";
        jdbcTemplate.update(sql, providerID);
        return true;
    }

}
