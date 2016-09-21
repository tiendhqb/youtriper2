/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.CertificatesViewDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Tien
 */
public class CertificatesViewMapper implements RowMapper<CertificatesViewDTO> {
    
     private static CertificatesViewMapper instance = null;

    private CertificatesViewMapper() {
    }

    public static CertificatesViewMapper getInstance() {
        if (instance == null) {
            instance = new CertificatesViewMapper();
        }
        return instance;
    }

    @Override
    public CertificatesViewDTO mapRow(ResultSet rs, int i) throws SQLException {
        int certificateID = rs.getInt("certificateID");
        String name = rs.getString("Name");
        String coverImage = rs.getString("Image");
        boolean isApproved = rs.getBoolean("isApproved");
        return new CertificatesViewDTO(certificateID, name, coverImage,  isApproved);
    }
    
}
