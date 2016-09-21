/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TemporaryPackageCertificatesDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class TemporaryPackageCertificatesMapperForPreview implements RowMapper<TemporaryPackageCertificatesDTO> {

    private static TemporaryPackageCertificatesMapperForPreview instance = null;

    private TemporaryPackageCertificatesMapperForPreview() {
    }

    public static TemporaryPackageCertificatesMapperForPreview getInstance() {
        if (instance == null) {
            instance = new TemporaryPackageCertificatesMapperForPreview();
        }
        return instance;
    }

    @Override
    public TemporaryPackageCertificatesDTO mapRow(ResultSet rs, int i) throws SQLException {
        String imageLink = rs.getString("Image");
        boolean isApproved = rs.getBoolean("isApproved");
        return new TemporaryPackageCertificatesDTO(imageLink, isApproved);
    }
}
