/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ProviderSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class ProviderSessionMapper implements RowMapper<ProviderSession> {
    private static ProviderSessionMapper instance = null;

    private ProviderSessionMapper() {
    }

    public static ProviderSessionMapper getInstance() {
        if (instance == null) {
            instance = new ProviderSessionMapper();
        }
        return instance;
    }

    @Override
    public ProviderSession mapRow(ResultSet rs, int i) throws SQLException {
        return new ProviderSession(rs.getInt("ProviderID"), rs.getString("LastName"));
    }
    
    
}
