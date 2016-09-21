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
public class PackageDTOMapperWithDuration implements RowMapper<PackageDTO> {

    private static PackageDTOMapperWithDuration instance = null;

    private PackageDTOMapperWithDuration() {
    }

    public static PackageDTOMapperWithDuration getInstance() {
        if (instance == null) {
            instance = new PackageDTOMapperWithDuration();
        }
        return instance;
    }

    @Override
    public PackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        String durationType = rs.getString("DurationType");
        int duration = rs.getInt("DurationMinutes");
        PackageDTO packageDTO = new PackageDTO();
        packageDTO.setDuration(duration);
        packageDTO.setDurationType(durationType);
        return packageDTO;
    }

}
