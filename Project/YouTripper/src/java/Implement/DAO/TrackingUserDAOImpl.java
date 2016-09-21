/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import Interface.DAO.TrackingUserDAO;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author DINH KHANG
 */
public class TrackingUserDAOImpl implements TrackingUserDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public TrackingUserDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public boolean logNewVisitor(int affiliateCode, String referrerURL, String ip, String device, String visitTime, String visitURL) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("logNewVisitor");
        SqlParameterSource in = new MapSqlParameterSource().addValue("referrer", referrerURL).addValue("affiliateCode", affiliateCode)
                .addValue("ip", ip).addValue("device", device).addValue("visitTime", visitTime).addValue("visitURL", visitURL);
        simpleJdbcCall.execute(in);
        return true;
    }

    @Override
    public boolean existingUserLogin(String username, String role, String time, String ip) {
        String sql = "UPDATE TrackingUser"
                + " SET ExistedUsername = ?,Role = ?"
                + " WHERE CAST(VisitTime as DECIMAL) >= CAST(? as DECIMAL) and IP = ?";
        int record = jdbcTemplate.update(sql, username,role,time,ip);
        if(record >0) {
            return true;
        }
        return false;
    }

}
