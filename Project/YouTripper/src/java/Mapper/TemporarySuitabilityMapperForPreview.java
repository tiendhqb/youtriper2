/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TemporarySuitabilityClassifierDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class TemporarySuitabilityMapperForPreview implements RowMapper<TemporarySuitabilityClassifierDTO> {

    public static TemporarySuitabilityMapperForPreview instance = null;

    public TemporarySuitabilityMapperForPreview() {
    }

    public static TemporarySuitabilityMapperForPreview getInstance() {
        if (instance == null) {
            instance = new TemporarySuitabilityMapperForPreview();
        }
        return instance;
    }

    @Override
    public TemporarySuitabilityClassifierDTO mapRow(ResultSet rs, int i) throws SQLException {
        String suitabilityName = rs.getString("Name");
        return new TemporarySuitabilityClassifierDTO(suitabilityName);
    }

}
