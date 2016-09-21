/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import JavaClass.OtherSubCategory;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class OtherSubCategoryMapper implements RowMapper<OtherSubCategory> {

    private static OtherSubCategoryMapper instance = null;

    public OtherSubCategoryMapper() {
    }

    public static OtherSubCategoryMapper getInstance() {
        if (instance == null) {
            instance = new OtherSubCategoryMapper();
        }
        return instance;

    }

    @Override
    public OtherSubCategory mapRow(ResultSet rs, int i) throws SQLException {
       OtherSubCategory result = new OtherSubCategory(rs.getInt("SubOtherID"),rs.getInt("PackageID"),rs.getInt("CategoryID"), rs.getString("name"));
       return result;
    }

}
