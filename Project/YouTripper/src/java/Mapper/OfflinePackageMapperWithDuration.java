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
public class OfflinePackageMapperWithDuration implements RowMapper<OfflinePackageDTO> {

    private static OfflinePackageMapperWithDuration instance = null;

    private OfflinePackageMapperWithDuration() {
    }

    public static OfflinePackageMapperWithDuration getInstance() {
        if (instance == null) {
            instance = new OfflinePackageMapperWithDuration();
        }
        return instance;
    }

    @Override
    public OfflinePackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        int duration = rs.getInt("Duration");
        String durationType = rs.getString("DurationType");
        OfflinePackageDTO packageDTO = new OfflinePackageDTO();
        packageDTO.setDuration(duration);
        packageDTO.setDurationType(durationType);
        return packageDTO;
    }
}
