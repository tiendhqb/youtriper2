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
public class ProviderDTOMapperForView implements RowMapper<ProviderDTO>{
    private static ProviderDTOMapperForView instance = null;

    private ProviderDTOMapperForView() {
    }

    public static ProviderDTOMapperForView getInstance() {
        if (instance == null) {
            instance = new ProviderDTOMapperForView();
        }
        return instance;
    }
    @Override
    public ProviderDTO mapRow(ResultSet rs, int i) throws SQLException {
        ProviderDTO result = new ProviderDTO(rs.getInt("ProviderID"), rs.getBoolean("EmailActive"), rs.getString("LastName"),
                rs.getString("FirstName"), rs.getString("Image"), rs.getString("PhoneCode"), rs.getString("PhoneNumber"),
                rs.getBoolean("PhoneActive"), rs.getString("Information"), rs.getString("Language"), rs.getString("City"), rs.getString("Address"),rs.getString("CountryName"),rs.getString("activeDate"), rs.getString("BusinessName"),rs.getString("BusinessType"),rs.getBoolean("PassportStatus"));
        return result;
    }
    
}
