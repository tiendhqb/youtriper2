/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.LanguageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class LanguageDTOMapper implements RowMapper<LanguageDTO> {

    public static LanguageDTOMapper instance = null;

    public LanguageDTOMapper() {
    }

    public static LanguageDTOMapper getInstance() {
        if (instance == null) {
            instance = new LanguageDTOMapper();
        }
        return instance;
    }

    @Override
    public LanguageDTO mapRow(ResultSet rs, int i) throws SQLException {
        LanguageDTO result = new LanguageDTO(rs.getInt("LanguageID"), rs.getString("LanguageName"),rs.getString("LanguageCode"));
        return result;
    }
}
