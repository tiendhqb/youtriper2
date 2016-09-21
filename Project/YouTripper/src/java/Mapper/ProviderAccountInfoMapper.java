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
 * @author DINH KHANG
 */
public class ProviderAccountInfoMapper implements RowMapper<ProviderDTO> {
    
    private static ProviderAccountInfoMapper instance = null;
    
    public static ProviderAccountInfoMapper getInstance() {
        if (instance == null) {
            instance = new ProviderAccountInfoMapper();
        }
        return instance;
    }
    
    @Override
    public ProviderDTO mapRow(ResultSet rs, int i) throws SQLException {
        ProviderDTO provider = new ProviderDTO(rs.getInt("providerID"), rs.getString("email"), rs.getString("LastName"),
                rs.getString("FirstName"), rs.getString("image"), rs.getString("PhoneCode"), rs.getString("PhoneNumber"),
                rs.getString("Information"), rs.getString("job"), rs.getString("Language"), rs.getString("Gender"),
                rs.getString("Bank"), rs.getString("BankHolder"), rs.getString("City"), rs.getString("Address"),
                rs.getString("BusinessName"), rs.getString("Name"), rs.getBoolean("PhoneActive"), rs.getString("Interests"), 
                rs.getString("TaxNumber"), rs.getBoolean("Notification"),rs.getString("PassportImage"),
                rs.getBoolean("PassportStatus"),rs.getString("DisplayName"),rs.getString("UsernameURL"),rs.getString("ProviderOfficialID"));
        return provider;
    }
    
}
