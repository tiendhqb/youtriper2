/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.ProviderNotification;
import DTO.ProviderNotificationSetting;
import Interface.DAO.ProviderNotificationDAO;
import Mapper.ProviderNotificationMapper;
import Mapper.ProviderNotificationSetttingMapper;
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
public class ProviderNotificationDAOImpl implements ProviderNotificationDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public ProviderNotificationDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public List<ProviderNotification> getProviderNotification() {
        String sql = "Select * From ProviderNotification";
        List<ProviderNotification> result = jdbcTemplate.query(sql, ProviderNotificationMapper.getInstance());
        return result;
    }

    @Override
    public List<ProviderNotificationSetting> getProviderNotificationSetting(int providerID) {
        String sql = "Select ProviderNotificationID From ProviderNotificationSetting WHERE providerID = " + providerID;
        List<ProviderNotificationSetting> result = jdbcTemplate.query(sql, ProviderNotificationSetttingMapper.getInstance());
        return result;
    }

    @Override
    public boolean saveSetting(int providerID, int settingValue) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertProviderSetting");
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID).addValue("notificationID", settingValue);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return true;
    }

    @Override
    public void deleteSetting(int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("deleteProviderSetting");
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID);
        simpleJdbcCall.execute(in);
    }

}
