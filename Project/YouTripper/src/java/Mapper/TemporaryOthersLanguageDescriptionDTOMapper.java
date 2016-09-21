/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TemporaryOthersLanguageDescriptionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class TemporaryOthersLanguageDescriptionDTOMapper implements RowMapper<TemporaryOthersLanguageDescriptionDTO> {

    private static TemporaryOthersLanguageDescriptionDTOMapper instance = null;

    private TemporaryOthersLanguageDescriptionDTOMapper() {
    }

    public static TemporaryOthersLanguageDescriptionDTOMapper getInstance() {
        if (instance == null) {
            instance = new TemporaryOthersLanguageDescriptionDTOMapper();
        }
        return instance;
    }

    @Override
    public TemporaryOthersLanguageDescriptionDTO mapRow(ResultSet rs, int i) throws SQLException {
        int languageID = rs.getInt("LanguageID");
        String packageName = rs.getString("PackageName");
        String googleDescription = rs.getString("GoogleDescription");
        String description = rs.getString("Description");
        String advancedAddress = rs.getString("AdvancedAddress");
        String keywords = rs.getString("Keywords");
        String language = rs.getString("Language");
        return new TemporaryOthersLanguageDescriptionDTO(languageID, packageName, googleDescription, description, advancedAddress, keywords, language);
    }

}
