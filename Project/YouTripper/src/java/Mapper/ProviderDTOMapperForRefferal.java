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
public class ProviderDTOMapperForRefferal implements RowMapper<ProviderDTO> {
    
    private static ProviderDTOMapperForRefferal instance = null;
    
    public static ProviderDTOMapperForRefferal getInstance() {
        if (instance == null) {
            instance = new ProviderDTOMapperForRefferal();
        }
        return instance;
    }
    
    @Override
    public ProviderDTO mapRow(ResultSet rs, int i) throws SQLException {
        ProviderDTO provider = new ProviderDTO(rs.getInt("providerID"), rs.getString("email"), rs.getInt("ActivePackage"));
        return provider;
    }
    
}
