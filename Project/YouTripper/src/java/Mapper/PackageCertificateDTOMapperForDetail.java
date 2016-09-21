/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.CertificateDTO;
import DTO.PackageCertificateDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class PackageCertificateDTOMapperForDetail implements RowMapper<PackageCertificateDTO> {

    private static PackageCertificateDTOMapperForDetail instance = null;

    private PackageCertificateDTOMapperForDetail() {
    }

    public static PackageCertificateDTOMapperForDetail getInstance() {
        if (instance == null) {
            instance = new PackageCertificateDTOMapperForDetail();
        }
        return instance;
    }

    @Override
    public PackageCertificateDTO mapRow(ResultSet rs, int i) throws SQLException {
        String imageLink = rs.getString("Image");
        boolean isApproved = rs.getBoolean("isApproved");
        return new PackageCertificateDTO(imageLink, isApproved);
    }
}
