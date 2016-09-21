/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.CountryDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class CountryMapper implements RowMapper<CountryDTO> {
    
    private static CountryMapper instance = null;

    private CountryMapper() {
    }

    public static CountryMapper getInstance() {
        if (instance == null) {
            instance = new CountryMapper();
        }
        return instance;
    }

    @Override
    public CountryDTO mapRow(ResultSet rs, int i) throws SQLException {
        return new CountryDTO(rs.getInt("CountryID"), rs.getString("Name"), rs.getString("Code"));
    }
    
}
