/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import JavaClass.HighestPackageInTripDash;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class HighestPackageInTripDashMapper implements RowMapper<HighestPackageInTripDash> {

    public static HighestPackageInTripDashMapper instance = null;

    public HighestPackageInTripDashMapper() {
    }

    public static HighestPackageInTripDashMapper getInstance() {
        if (instance == null) {
            instance = new HighestPackageInTripDashMapper();
        }
        return instance;

    }

    @Override
    public HighestPackageInTripDash mapRow(ResultSet rs, int i) throws SQLException {
        HighestPackageInTripDash result = new HighestPackageInTripDash(rs.getInt("PackageID"),
                rs.getString("PackageTitle"), rs.getString("COverImage"), rs.getFloat("FilterPrice"));
        return result;
    }

}
