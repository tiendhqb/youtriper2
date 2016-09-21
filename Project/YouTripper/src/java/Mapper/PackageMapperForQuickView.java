/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.PackageDTO;
import DTO.TemporaryPackageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class PackageMapperForQuickView implements RowMapper<PackageDTO> {

    private static PackageMapperForQuickView instance = null;

    private PackageMapperForQuickView() {
    }

    public static PackageMapperForQuickView getInstance() {
        if (instance == null) {
            instance = new PackageMapperForQuickView();
        }
        return instance;
    }

    @Override
    public PackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        String durationType = rs.getString("DurationType");
        int duration = rs.getInt("Duration");
        int minTripper = rs.getInt("MinTripper");
        int maxTripper = rs.getInt("MaxTripper");
        String country = rs.getString("Country");
        String city = rs.getString("City");
        String state = rs.getString("State");
//        String included = rs.getString("Included");
//        String excluded = rs.getString("Excluded");
//        String googleDescription = rs.getString("GoogleDescription");
        return new PackageDTO(durationType, duration, minTripper, maxTripper, country, city, state, "", "", "");
    }
}
