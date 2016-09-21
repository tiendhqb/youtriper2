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
public class CategoryMapperWithNameAndIcon implements RowMapper<CategoryDTO> {

    private static CategoryMapperWithNameAndIcon instance = null;

    private CategoryMapperWithNameAndIcon() {
    }

    public static CategoryMapperWithNameAndIcon getInstance() {
        if (instance == null) {
            instance = new CategoryMapperWithNameAndIcon();
        }
        return instance;
    }

    @Override
    public CategoryDTO mapRow(ResultSet rs, int i) throws SQLException {
        CategoryDTO category = new CategoryDTO(rs.getInt("CategoryID"), rs.getString("Name"), rs.getString("Icon"));
        return category;
    }
}
