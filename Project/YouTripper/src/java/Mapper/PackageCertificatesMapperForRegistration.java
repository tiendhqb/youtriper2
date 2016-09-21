/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.PackageCertificateDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class PackageCertificatesMapperForRegistration implements RowMapper<PackageCertificateDTO> {

    private static PackageCertificatesMapperForRegistration instance = null;

    private PackageCertificatesMapperForRegistration() {
    }

    public static PackageCertificatesMapperForRegistration getInstance() {
        if (instance == null) {
            instance = new PackageCertificatesMapperForRegistration();
        }
        return instance;
    }

    @Override
    public PackageCertificateDTO mapRow(ResultSet rs, int i) throws SQLException {
        int certificatesID = rs.getInt("CertificateID");
        String imageLink = rs.getString("Image");
        return new PackageCertificateDTO(certificatesID, imageLink);
    }

}
