/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TemporaryAmenitiesClassifierDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class TemporaryAmenitiesClassifierDTOMapperForPreview implements RowMapper<TemporaryAmenitiesClassifierDTO> {

    private static TemporaryAmenitiesClassifierDTOMapperForPreview instance = null;

    private TemporaryAmenitiesClassifierDTOMapperForPreview() {
    }

    public static TemporaryAmenitiesClassifierDTOMapperForPreview getInstance() {
        if (instance == null) {
            instance = new TemporaryAmenitiesClassifierDTOMapperForPreview();
        }
        return instance;
    }

    @Override
    public TemporaryAmenitiesClassifierDTO mapRow(ResultSet rs, int i) throws SQLException {
        int languageID = rs.getInt("LanguageID");
        String languageName = rs.getString("LanguageName");
        String amenitiesName = rs.getString("AmenitiesType");
        String amenitiesIcon = rs.getString("Icon");
        String description = rs.getString("Description");
        return new TemporaryAmenitiesClassifierDTO(amenitiesName, amenitiesIcon, description, languageID, languageName);
    }
}
