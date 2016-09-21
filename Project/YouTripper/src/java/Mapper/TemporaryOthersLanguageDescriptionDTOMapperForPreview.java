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
public class TemporaryOthersLanguageDescriptionDTOMapperForPreview implements RowMapper<TemporaryOthersLanguageDescriptionDTO> {

    private static TemporaryOthersLanguageDescriptionDTOMapperForPreview instance = null;

    private TemporaryOthersLanguageDescriptionDTOMapperForPreview() {
    }

    public static TemporaryOthersLanguageDescriptionDTOMapperForPreview getInstance() {
        if (instance == null) {
            instance = new TemporaryOthersLanguageDescriptionDTOMapperForPreview();
        }
        return instance;
    }

    @Override
    public TemporaryOthersLanguageDescriptionDTO mapRow(ResultSet rs, int i) throws SQLException {
        int languageID = rs.getInt("LanguageID");
        String languageName = rs.getString("LanguageName");
        String packageName = rs.getString("PackageName");
        String googleDescription = rs.getString("GoogleDescription");
        String description = rs.getString("Description");
        String advancedAddress = rs.getString("AdvancedAddress");
        String keywords = rs.getString("Keywords");
        String language = rs.getString("Language");
        return new TemporaryOthersLanguageDescriptionDTO(languageID, languageName, packageName, googleDescription, description, advancedAddress, keywords, language);
    }

}
