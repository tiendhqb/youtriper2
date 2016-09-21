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
public class TemporaryPackageCertificatesMapperForRegistration implements RowMapper<TemporaryPackageCertificatesDTO> {

    private static TemporaryPackageCertificatesMapperForRegistration instance = null;

    private TemporaryPackageCertificatesMapperForRegistration() {
    }

    public static TemporaryPackageCertificatesMapperForRegistration getInstance() {
        if (instance == null) {
            instance = new TemporaryPackageCertificatesMapperForRegistration();
        }
        return instance;
    }

    @Override
    public TemporaryPackageCertificatesDTO mapRow(ResultSet rs, int i) throws SQLException {
        int certificatesID = rs.getInt("CertificateID");
        String imageLink = rs.getString("Image");
        return new TemporaryPackageCertificatesDTO(certificatesID, imageLink);
    }

}
