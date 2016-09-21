/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.AmenitiesClassifierDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class AmenitiesClassifierDTOMapperForDetail implements RowMapper<AmenitiesClassifierDTO> {

    private static AmenitiesClassifierDTOMapperForDetail instance = null;

    private AmenitiesClassifierDTOMapperForDetail() {
    }

    public static AmenitiesClassifierDTOMapperForDetail getInstance() {
        if (instance == null) {
            instance = new AmenitiesClassifierDTOMapperForDetail();
        }
        return instance;
    }

    @Override
    public AmenitiesClassifierDTO mapRow(ResultSet rs, int i) throws SQLException {
        int languageID = rs.getInt("LanguageID");
        String languageName = rs.getString("LanguageName");
        String amenitiesName = rs.getString("AmenitiesType");
        String amenitiesIcon = rs.getString("Icon");
        String description = rs.getString("Description");
        return new AmenitiesClassifierDTO(amenitiesName, amenitiesIcon, description, languageID, languageName);
    }
}
