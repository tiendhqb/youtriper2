/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.SuitabilityClassifierDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class SuitabilityClassifierDTOMapper implements RowMapper<SuitabilityClassifierDTO> {

    private static SuitabilityClassifierDTOMapper instance = null;

    private SuitabilityClassifierDTOMapper() {
    }

    public static SuitabilityClassifierDTOMapper getInstance() {
        if (instance == null) {
            instance = new SuitabilityClassifierDTOMapper();
        }
        return instance;
    }

    @Override
    public SuitabilityClassifierDTO mapRow(ResultSet rs, int i) throws SQLException {
        int suitabilityID = rs.getInt("SuitabilityID");
        String suitabilityName = rs.getString("Name");
        String content = rs.getString("Content");
        int selectedInt = rs.getInt("Selected");
        boolean selected = false;
        if (selectedInt > 0) {
            selected = true;
        }
        return new SuitabilityClassifierDTO(suitabilityID, suitabilityName, content, selected);
    }

}
