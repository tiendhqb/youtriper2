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
public class ProviderPhoneNumberMapper implements RowMapper<ProviderDTO> {

    private static ProviderPhoneNumberMapper instance = null;

    private ProviderPhoneNumberMapper() {
    }

    public static ProviderPhoneNumberMapper getInstance() {
        if (instance == null) {
            instance = new ProviderPhoneNumberMapper();
        }
        return instance;
    }

    @Override
    public ProviderDTO mapRow(ResultSet rs, int i) throws SQLException {
      ProviderDTO result = new ProviderDTO(rs.getString("PhoneCode").trim(),rs.getString("PhoneNumber"));
      return result;
    }

}
