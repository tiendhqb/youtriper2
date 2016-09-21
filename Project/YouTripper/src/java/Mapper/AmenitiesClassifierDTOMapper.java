/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.AmenitiesClassifierDTO;
import DTO.TemporaryAmenitiesClassifierDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class AmenitiesClassifierDTOMapper implements RowMapper<AmenitiesClassifierDTO> {

    private static AmenitiesClassifierDTOMapper instance = null;

    private AmenitiesClassifierDTOMapper() {
    }

    public static AmenitiesClassifierDTOMapper getInstance() {
        if (instance == null) {
            instance = new AmenitiesClassifierDTOMapper();
        }
        return instance;
    }

    @Override
    public AmenitiesClassifierDTO mapRow(ResultSet rs, int i) throws SQLException {
         int packageID = rs.getInt("PackageID");
        int amenitiesID = rs.getInt("AmenitiesID");
        int languageID = rs.getInt("LanguageID");
        String amenitiesName = rs.getString("AmenitiesType");
        String amenitiesIcon = rs.getString("Icon");
        String description = rs.getString("Description");
        return new AmenitiesClassifierDTO(packageID, amenitiesID, amenitiesName, amenitiesIcon, description, languageID);
    }

}
