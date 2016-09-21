/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.CategoryDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class CategoryMapperWithOnlyName implements RowMapper<CategoryDTO> {

    private static CategoryMapperWithOnlyName instance = null;

    private CategoryMapperWithOnlyName() {
    }

    public static CategoryMapperWithOnlyName getInstance() {
        if (instance == null) {
            instance = new CategoryMapperWithOnlyName();
        }
        return instance;
    }

    @Override
    public CategoryDTO mapRow(ResultSet rs, int i) throws SQLException {
        CategoryDTO category = new CategoryDTO(rs.getString("Name"));
        return category;
    }

}
