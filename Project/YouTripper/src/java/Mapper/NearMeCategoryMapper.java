/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import JavaClass.NearMeCategory;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class NearMeCategoryMapper implements RowMapper<NearMeCategory> {

    private static NearMeCategoryMapper instance = null;

    private NearMeCategoryMapper() {
    }

    public static NearMeCategoryMapper getInstance() {
        if (instance == null) {
            instance = new NearMeCategoryMapper();
        }
        return instance;
    }

    @Override
    public NearMeCategory mapRow(ResultSet rs, int i) throws SQLException {
        return new NearMeCategory(rs.getInt("CategoryID"), rs.getString("Name"), rs.getInt("NoNumber"));
    }

}
