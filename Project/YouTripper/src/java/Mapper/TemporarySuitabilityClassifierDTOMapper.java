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
 * @author Nick
 */
public class TemporarySuitabilityClassifierDTOMapper implements RowMapper<TemporarySuitabilityClassifierDTO> {

    private static TemporarySuitabilityClassifierDTOMapper instance = null;

    private TemporarySuitabilityClassifierDTOMapper() {
    }

    public static TemporarySuitabilityClassifierDTOMapper getInstance() {
        if (instance == null) {
            instance = new TemporarySuitabilityClassifierDTOMapper();
        }
        return instance;
    }

    @Override
    public TemporarySuitabilityClassifierDTO mapRow(ResultSet rs, int i) throws SQLException {
        int suitabilityID = rs.getInt("SuitabilityID");
        String suitabilityName = rs.getString("Name");
        String content = rs.getString("Content");
        int selectedInt = rs.getInt("Selected");
        boolean selected = false;
        if (selectedInt > 0) {
            selected = true;
        }
        return new TemporarySuitabilityClassifierDTO(suitabilityID, suitabilityName, content, selected);
    }

}
