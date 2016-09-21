/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.EnginePackageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class EnginePackageMapper implements RowMapper<EnginePackageDTO> {

    private static EnginePackageMapper instance = null;

    private EnginePackageMapper() {
    }

    public static EnginePackageMapper getInstance() {
        if (instance == null) {
            instance = new EnginePackageMapper();
        }
        return instance;
    }

    @Override
    public EnginePackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        int packageID = rs.getInt("PackageID");
        String packageName = rs.getString("PackageName");
        String durationType = rs.getString("DurationType");
        int duration = rs.getInt("Duration");
        String startOperationTime = rs.getString("StartOperationTime");
        String endOperationTime = rs.getString("EndOperationTime");
        boolean isFreeBooking = rs.getBoolean("IsFreeBooking");
        int freeInterval = rs.getInt("FreeInterval");
        int fixedHour = rs.getInt("FixedHour");
        int fixedMinute = rs.getInt("FixedMinute");
        int resourceID = rs.getInt("ResourceID");
        int minimumResources = rs.getInt("MinimumResources");
        String color = rs.getString("Color");
        return new EnginePackageDTO(packageID, packageName, durationType, duration, startOperationTime,
                endOperationTime, isFreeBooking, freeInterval, fixedHour, fixedMinute, resourceID, minimumResources, color);
    }

}
