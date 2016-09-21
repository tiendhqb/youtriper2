/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.TripperNotification;
import DTO.TripperNotificationSetting;
import Interface.DAO.TripperNotificationDAO;
import Mapper.TripperNotificationMapper;
import Mapper.TripperNotificationSettingMapper;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author DINH KHANG
 */
public class TripperNotificationDAOImpl implements TripperNotificationDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public TripperNotificationDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
//        simpleJdbcCall = new SimpleJdbcCall(dataSource);
    }

    @Override
    public List<TripperNotification> getTripperNotification() {
        String sql = "Select * From TripperNotification";
        List<TripperNotification> result = jdbcTemplate.query(sql, TripperNotificationMapper.getInstance());
        return result;
    }

    @Override
    public List<TripperNotificationSetting> getTripperNotificationSetting(int tripperID) {
        String sql = "Select TripperNotificationID From TripperNotificationSetting WHERE TripperID = " + tripperID;
        List<TripperNotificationSetting> result = jdbcTemplate.query(sql, TripperNotificationSettingMapper.getInstance());
        return result;
    }

    @Override
    public void deleteSetting(int tripperID) {

        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("deleteTripperSetting");
        SqlParameterSource in = new MapSqlParameterSource().addValue("tripperID", tripperID);
        Map<String, Object> record = simpleJdbcCall.execute(in);

    }

    @Override
    public boolean saveSetting(int tripperID, int settingValue) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertTripperSetting");
        SqlParameterSource in = new MapSqlParameterSource().addValue("tripperID", tripperID).addValue("notificationID", settingValue);
        simpleJdbcCall.execute(in);
        return true;

    }

}
