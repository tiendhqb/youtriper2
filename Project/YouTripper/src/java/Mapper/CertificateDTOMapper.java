/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.CertificateDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class CertificateDTOMapper implements RowMapper<CertificateDTO> {

    private static CertificateDTOMapper instance = null;

    private CertificateDTOMapper() {
    }

    public static CertificateDTOMapper getInstance() {
        if (instance == null) {
            instance = new CertificateDTOMapper();
        }
        return instance;
    }

    @Override
    public CertificateDTO mapRow(ResultSet rs, int i) throws SQLException {
        int certificateID = rs.getInt("CertificateID");
        String image = rs.getString("Image");
        String name = rs.getString("Name");
        return new CertificateDTO(certificateID, image, name);
    }

}
