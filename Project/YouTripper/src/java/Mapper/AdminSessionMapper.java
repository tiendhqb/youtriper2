/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.AdminSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class AdminSessionMapper implements RowMapper<AdminSession> {

    private static AdminSessionMapper instance = null;

    private AdminSessionMapper() {
    }

    public static AdminSessionMapper getInstance() {
        if (instance == null) {
            instance = new AdminSessionMapper();
        }
        return instance;
    }

    @Override
    public AdminSession mapRow(ResultSet rs, int i) throws SQLException {
        return new AdminSession(rs.getInt("AdminID"), rs.getString("Name"));
    }

}
