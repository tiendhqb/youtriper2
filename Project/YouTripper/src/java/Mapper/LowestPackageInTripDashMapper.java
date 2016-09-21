/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import JavaClass.LowestPackageInTripDash;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class LowestPackageInTripDashMapper implements RowMapper<LowestPackageInTripDash> {

    public static LowestPackageInTripDashMapper instance = null;

    public LowestPackageInTripDashMapper() {
    }

    public static LowestPackageInTripDashMapper getInstance() {
        if (instance == null) {
            instance = new LowestPackageInTripDashMapper();
        }
        return instance;

    }

    @Override
    public LowestPackageInTripDash mapRow(ResultSet rs, int i) throws SQLException {
        LowestPackageInTripDash result = new LowestPackageInTripDash(rs.getInt("PackageID"),rs.getString("PackageTitle"),rs.getString("CoverImage"), rs.getFloat("FilterPrice"));
        return result;
    }

}
