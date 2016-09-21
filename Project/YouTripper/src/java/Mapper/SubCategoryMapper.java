/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.SubCategoryDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class SubCategoryMapper implements RowMapper<SubCategoryDTO> {
    private static SubCategoryMapper instance = null;

    private SubCategoryMapper() {
    }

    public static SubCategoryMapper getInstance() {
        if (instance == null) {
            instance = new SubCategoryMapper();
        }
        return instance;
    }

    @Override
    public SubCategoryDTO mapRow(ResultSet rs, int i) throws SQLException {
        SubCategoryDTO subCategoryDTO = new SubCategoryDTO(rs.getInt("SubCategoryID"), rs.getString("Name"),rs.getInt("CategoryID"),"");
        return subCategoryDTO;
    }   
}
