/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.AccountSession;
import DTO.SignupTokenDTO;
import Interface.DAO.SignupTokenDAO;
import Mapper.SignupTokenMapper;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.util.DigestUtils;

/**
 *
 * @author DINH KHANG
 */
public class SignupTokenDAOImpl implements SignupTokenDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public SignupTokenDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public String insertNewToken(String email, String referralToken) throws UnsupportedEncodingException {
        byte[] bytesOfMessage = email.getBytes("UTF-8");
        String expireTime = String.valueOf(System.currentTimeMillis() + 86400000);
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertSignupToken");
        simpleJdbcCall.returningResultSet("rs1", SignupTokenMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("email", email).addValue("token", DigestUtils.md5DigestAsHex(bytesOfMessage).toString()).addValue("expireTime", expireTime).addValue("referralToken", referralToken);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        String result = ((List<SignupTokenDTO>) record.get("rs1")).get(0).getToken();
        return result;
    }

    @Override
    public AccountSession validateTokenForProvider(String token) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("activeProviderAccount");
        SqlParameterSource in = new MapSqlParameterSource().addValue("currentToken", token).addValue("currentTime", String.valueOf(System.currentTimeMillis()));
        Map<String, Object> record = simpleJdbcCall.execute(in);
        int result = (Integer) record.get("result");
        int id = (int) record.get("id");
        String name = (String) record.get("name");
        int type = (int) record.get("type");
        String image = (String) record.get("image");
        String email = (String) record.get("emailReg");
        return new AccountSession(id, name, type, image,"", email);
    }
}
