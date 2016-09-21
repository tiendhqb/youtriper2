/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.KeywordCollectionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class KeywordCollectionDTOMapper implements RowMapper<KeywordCollectionDTO>{
    private static KeywordCollectionDTOMapper instance = null;

    private KeywordCollectionDTOMapper() {
    }

    public static KeywordCollectionDTOMapper getInstance() {
        if (instance == null) {
            instance = new KeywordCollectionDTOMapper();
        }
        return instance;
    }
    @Override
    public KeywordCollectionDTO mapRow(ResultSet rs, int i) throws SQLException {
        KeywordCollectionDTO result = new KeywordCollectionDTO(rs.getString("Keyword"),rs.getInt("Times"));
        return result;
    }
    
}
