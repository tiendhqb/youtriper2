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
 * @author QuangTran
 */
public class ProviderSalesmanMapper implements RowMapper<ProviderDTO>{
    private static ProviderSalesmanMapper instance = null;

    public static ProviderSalesmanMapper getInstance() {
        if (instance == null) {
            instance = new ProviderSalesmanMapper();
        }
        return instance;
    }
    
    @Override
    public ProviderDTO mapRow(ResultSet rs, int i) throws SQLException {
       ProviderDTO provider = new ProviderDTO(rs.getInt("ProviderID"),rs.getString("Email"), rs.getString("LastName"),rs.getString("FirstName"),rs.getString("PhoneNumber"),rs.getString("Address"),
               rs.getString("ActiveDate"),0,rs.getString("ActiveDate"),0,rs.getString("ProviderOfficialID"));
       return provider;
    }
}
