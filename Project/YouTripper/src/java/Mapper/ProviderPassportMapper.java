/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ProviderDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Tien
 */
public class ProviderPassportMapper implements RowMapper<ProviderDTO> {
    
    private static ProviderPassportMapper instance = null;
    
    public static ProviderPassportMapper getInstance() {
        if (instance == null) {
            instance = new ProviderPassportMapper();
        }
        return instance;
    }
    
    @Override
    public ProviderDTO mapRow(ResultSet rs, int i) throws SQLException {
        ProviderDTO provider = new ProviderDTO(rs.getInt("ProviderID"), 
                rs.getString("FirstName"), rs.getString("Image"),
                rs.getString("PassportImage"),rs.getBoolean("PassportStatus"),rs.getString("BusinessName"),rs.getString("Email"), rs.getString("PassportUploadTime"));
        return provider;
    }
    
}
