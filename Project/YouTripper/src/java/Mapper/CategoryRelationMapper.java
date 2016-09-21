/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import JavaClass.CategoryRelation;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class CategoryRelationMapper implements RowMapper<CategoryRelation> {

    private static CategoryRelationMapper instance = null;

    private CategoryRelationMapper() {
    }

    public static CategoryRelationMapper getInstance() {
        if (instance == null) {
            instance = new CategoryRelationMapper();
        }
        return instance;
    }

    @Override
    public CategoryRelation mapRow(ResultSet rs, int i) throws SQLException {
        int categoryID = rs.getInt("CategoryID");
        String categoryName = rs.getString("CategoryName");
        String categoryIcon = rs.getString("CategoryICon");
        int subCategoryID = rs.getInt("SubCategoryID");
        String subCategoryName = rs.getString("SubCategoryName");
        int activityID = rs.getInt("ActivityID");
        String activityName = rs.getString("ActivityName");
        return new CategoryRelation(categoryID, categoryName, categoryIcon, subCategoryID, subCategoryName, activityID, activityName);
    }

}
