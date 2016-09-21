/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.PackageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class PackageDTOMapperForCheckTripperBooking implements RowMapper<PackageDTO> {

    private static PackageDTOMapperForCheckTripperBooking instance = null;

    private PackageDTOMapperForCheckTripperBooking() {
    }

    public static PackageDTOMapperForCheckTripperBooking getInstance() {
        if (instance == null) {
            instance = new PackageDTOMapperForCheckTripperBooking();
        }
        return instance;
    }

    @Override
    public PackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        String durationType = rs.getString("DurationType");
        double ordinaryPriceForAdult = Double.parseDouble(rs.getFloat("OrdinaryPriceForAdult") + "");
        String packageType = rs.getString("PackageType");
        String advancedChildPrice = rs.getString("AdvancedChildPrice");
        int minimumResources = rs.getInt("MinimumResources");
        int ytCommission = rs.getInt("YTComission");
        int maximumCapacity = rs.getInt("MaximunCapacity");
        int minTripper = rs.getInt("MinTripper");
        int maxTripper = rs.getInt("MaxTripper");
        return new PackageDTO(durationType, ordinaryPriceForAdult, packageType, advancedChildPrice, minimumResources, ytCommission, maximumCapacity, minTripper, maxTripper);
    }

}
