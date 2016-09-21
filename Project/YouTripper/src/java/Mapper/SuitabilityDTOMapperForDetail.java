/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.SuitabilityDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class SuitabilityDTOMapperForDetail implements RowMapper<SuitabilityDTO> {

    public static SuitabilityDTOMapperForDetail instance = null;

    public SuitabilityDTOMapperForDetail() {
    }

    public static SuitabilityDTOMapperForDetail getInstance() {
        if (instance == null) {
            instance = new SuitabilityDTOMapperForDetail();
        }
        return instance;
    }

    @Override
    public SuitabilityDTO mapRow(ResultSet rs, int i) throws SQLException {
        String suitabilityName = rs.getString("Name");
        return new SuitabilityDTO(suitabilityName);
    }

}
