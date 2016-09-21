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
public class CertificatesViewMapper2 implements RowMapper<CertificatesViewDTO> {
    
     private static CertificatesViewMapper2 instance = null;

    private CertificatesViewMapper2() {
    }

    public static CertificatesViewMapper2 getInstance() {
        if (instance == null) {
            instance = new CertificatesViewMapper2();
        }
        return instance;
    }

    @Override
    public CertificatesViewDTO mapRow(ResultSet rs, int i) throws SQLException {
        String coverImage = rs.getString("Image");
        return new CertificatesViewDTO( coverImage);
    }
    
}
