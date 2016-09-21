/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.AccountSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class AccountSessionMaper implements RowMapper<AccountSession> {

    private static AccountSessionMaper instance = null;

    private AccountSessionMaper() {
    }

    public static AccountSessionMaper getInstance() {
        if (instance == null) {
            instance = new AccountSessionMaper();
        }
        return instance;
    }
    
    @Override
    public AccountSession mapRow(ResultSet rs, int i) throws SQLException {
        return new AccountSession(rs.getInt("id"), rs.getString("name"), rs.getInt("type"), rs.getString("image"));
    }
    
}
