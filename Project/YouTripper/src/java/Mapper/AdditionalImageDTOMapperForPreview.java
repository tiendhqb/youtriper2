/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.AdditionImageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class AdditionalImageDTOMapperForPreview implements RowMapper<AdditionImageDTO> {

    private static AdditionalImageDTOMapperForPreview instance = null;

    private AdditionalImageDTOMapperForPreview() {
    }

    public static AdditionalImageDTOMapperForPreview getInstance() {
        if (instance == null) {
            instance = new AdditionalImageDTOMapperForPreview();
        }
        return instance;
    }

    @Override
    public AdditionImageDTO mapRow(ResultSet rs, int i) throws SQLException {
        String image = rs.getString("Link");
        String caption = rs.getString("Caption");
        return new AdditionImageDTO(image, caption);
    }

}
