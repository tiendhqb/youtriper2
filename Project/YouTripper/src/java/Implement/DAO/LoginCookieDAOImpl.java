/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.AccountSession;
import Interface.DAO.LoginCookieDAO;
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
public class LoginCookieDAOImpl implements LoginCookieDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public LoginCookieDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
//        simpleJdbcCall = new SimpleJdbcCall(dataSource);
    }

    @Override
    public String insertNewToken(String username, String token) {
        String sql = "Insert Into LoginCookie(username,token,last_used)\n"
                + "Values(?,?,?)";

        int record = jdbcTemplate.update(sql, username, token, System.currentTimeMillis());
        if (record > 0) {
            return token;
        }
        return "";
    }

    @Override
    public AccountSession checkCookie(String token) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("loginwithToken");
        SqlParameterSource in = new MapSqlParameterSource().addValue("token", token).addValue("currentTime", System.currentTimeMillis());
        Map<String, Object> record = simpleJdbcCall.execute(in);
        int id = (int) record.get("id");
        String name = (String) record.get("name");
        int type = (int) record.get("type");
        String image = (String) record.get("image");
        return new AccountSession(id, name, type, image);

    }

    @Override
    public void deleteCookie(String token) {
        String sql = "DELETE FROM LoginCookie\n"
                + "WHERE token= '" + token + "'";
        jdbcTemplate.execute(sql);
    }

}
