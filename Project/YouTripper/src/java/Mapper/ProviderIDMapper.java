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
public class ProviderIDMapper implements RowMapper<ProviderDTO> {

    private static ProviderIDMapper instance = null;

    private ProviderIDMapper() {
    }

    public static ProviderIDMapper getInstance() {
        if (instance == null) {
            instance = new ProviderIDMapper();
        }
        return instance;
    }

    @Override
    public ProviderDTO mapRow(ResultSet rs, int i) throws SQLException {
      ProviderDTO result = new ProviderDTO(rs.getInt("ProviderID"));
      return result;
    }

}
