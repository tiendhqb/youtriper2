/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.OfflinePackageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class OfflinePackageDTOMapper implements RowMapper<OfflinePackageDTO> {

    private static OfflinePackageDTOMapper instance = null;

    private OfflinePackageDTOMapper() {
    }

    public static OfflinePackageDTOMapper getInstance() {
        if (instance == null) {
            instance = new OfflinePackageDTOMapper();
        }
        return instance;
    }

    @Override
    public OfflinePackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        int packageID = rs.getInt("PackageID");
        String packageName = rs.getString("PackageName");
        int resourceID = rs.getInt("ResourceID");
        int minimumNoResources = rs.getInt("MinimumNoResource");
        int duration = rs.getInt("Duration");
        String durationType = rs.getString("DurationType");
        String color = rs.getString("Color");
        return new OfflinePackageDTO(packageID, packageName, resourceID, minimumNoResources, duration, durationType, color);
    }

}
