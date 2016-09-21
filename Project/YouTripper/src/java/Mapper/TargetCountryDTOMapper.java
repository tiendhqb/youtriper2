/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TargetCountryDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class TargetCountryDTOMapper implements RowMapper<TargetCountryDTO> {

    private static TargetCountryDTOMapper instance = null;

    private TargetCountryDTOMapper() {
    }

    public static TargetCountryDTOMapper getInstance() {
        if (instance == null) {
            instance = new TargetCountryDTOMapper();
        }
        return instance;
    }

    @Override
    public TargetCountryDTO mapRow(ResultSet rs, int i) throws SQLException {
        TargetCountryDTO result = new TargetCountryDTO(rs.getInt("CountryID"), rs.getString("name"));
        return result;
    }

}
