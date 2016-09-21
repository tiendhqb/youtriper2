/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.CityDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class CityDTOMapper implements RowMapper<CityDTO> {

    private static CityDTOMapper instance = null;

    private CityDTOMapper() {
    }

    public static CityDTOMapper getInstance() {
        if (instance == null) {
            instance = new CityDTOMapper();
        }
        return instance;
    }

    @Override
    public CityDTO mapRow(ResultSet rs, int i) throws SQLException {
        CityDTO result = new CityDTO(rs.getInt("CityID"),rs.getString("Name"), rs.getInt("CountryID"));
        return result;
    }

}
