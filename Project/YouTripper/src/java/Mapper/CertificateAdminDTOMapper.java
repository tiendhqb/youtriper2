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
 * @author QuangTran
 */
public class CertificateAdminDTOMapper implements RowMapper<CertificateDTO>{
    private static CertificateAdminDTOMapper instance = null;

    private CertificateAdminDTOMapper() {
    }

    public static CertificateAdminDTOMapper getInstance() {
        if (instance == null) {
            instance = new CertificateAdminDTOMapper();
        }
        return instance;
    }

    @Override
    public CertificateDTO mapRow(ResultSet rs, int i) throws SQLException {
        int certificateID = rs.getInt("CertificateID");
        int providerID = rs.getInt("ProviderID");
        String image = rs.getString("Image");
        String name = rs.getString("Name");
        String providerName = rs.getString("LastName");
        return new CertificateDTO(certificateID,providerID,image, name, providerName);
    }
    
}
