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
public class TemporaryAmenitiesClassifierDTOMapper implements RowMapper<TemporaryAmenitiesClassifierDTO> {

    private static TemporaryAmenitiesClassifierDTOMapper instance = null;

    private TemporaryAmenitiesClassifierDTOMapper() {
    }

    public static TemporaryAmenitiesClassifierDTOMapper getInstance() {
        if (instance == null) {
            instance = new TemporaryAmenitiesClassifierDTOMapper();
        }
        return instance;
    }

    @Override
    public TemporaryAmenitiesClassifierDTO mapRow(ResultSet rs, int i) throws SQLException {
        int temporaryPackageID = rs.getInt("TemporaryPackageID");
        int amenitiesID = rs.getInt("AmenitiesID");
        int languageID = rs.getInt("LanguageID");
        String amenitiesName = rs.getString("AmenitiesType");
        String amenitiesIcon = rs.getString("Icon");
        String description = rs.getString("Description");
        return new TemporaryAmenitiesClassifierDTO(temporaryPackageID, amenitiesID, amenitiesName, amenitiesIcon, description, languageID);
    }

}
