/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import JavaClass.NearMeLocation;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class NearMeLocationMapper implements RowMapper<NearMeLocation> {

    private static NearMeLocationMapper instance = null;

    private NearMeLocationMapper() {
    }

    public static NearMeLocationMapper getInstance() {
        if (instance == null) {
            instance = new NearMeLocationMapper();
        }
        return instance;
    }

    @Override
    public NearMeLocation mapRow(ResultSet rs, int i) throws SQLException {
        return new NearMeLocation(rs.getString("Location"), rs.getInt("NoNumber"));
    }

}
