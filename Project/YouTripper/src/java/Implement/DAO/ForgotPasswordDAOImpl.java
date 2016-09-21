/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.ForgotPasswordDTO;
import Interface.DAO.ForgotPasswordDAO;
import Mapper.ForgotPasswordDTOMapper;
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
public class ForgotPasswordDAOImpl implements ForgotPasswordDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public ForgotPasswordDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public boolean insertNewToken(String token, String email) {
        String sql = "Insert into ForgotPassword Values(?,?)";
        int record = jdbcTemplate.update(sql, token, email);
        return true;
    }

    @Override
    public ForgotPasswordDTO checkForgotPasswordToken(String token) {
        String sql = "Select * From ForgotPassword Where Token = ?";
        List<ForgotPasswordDTO> result = jdbcTemplate.query(sql, ForgotPasswordDTOMapper.getInstance(), token);
        return result.get(0);
    }

    @Override
    public boolean resetPassword(String token, String password) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("ResetPassword");
        SqlParameterSource in = new MapSqlParameterSource().addValue("token", token).addValue("password", password);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        String email = (String) record.get("email");
        return true;
    }

    @Override
    public boolean deleteEmail(String token) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("deleteForgotPasswordToken");
        SqlParameterSource in = new MapSqlParameterSource().addValue("token", token);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        String email = (String) record.get("email");
        return true;
    }

}
