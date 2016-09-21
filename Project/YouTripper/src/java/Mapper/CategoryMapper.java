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
public class CategoryMapper implements RowMapper<CategoryDTO> {

    private static CategoryMapper instance = null;

    private CategoryMapper() {
    }

    public static CategoryMapper getInstance() {
        if (instance == null) {
            instance = new CategoryMapper();
        }
        return instance;
    }

    @Override
    public CategoryDTO mapRow(ResultSet rs, int i) throws SQLException {
        CategoryDTO category = new CategoryDTO(rs.getInt("CategoryID"), rs.getString("Name"),rs.getString("Image"), rs.getString("Icon"));
        return category;
    }

}
