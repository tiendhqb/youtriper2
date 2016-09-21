/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.DisabledDiscountDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class PackageDisabledDiscountDTOMapper implements RowMapper<DisabledDiscountDTO>{
    private static PackageDisabledDiscountDTOMapper instance = null;

    private PackageDisabledDiscountDTOMapper() {
    }

    public static PackageDisabledDiscountDTOMapper getInstance() {
        if (instance == null) {
            instance = new PackageDisabledDiscountDTOMapper();
        }
        return instance;
    }
    @Override
    public DisabledDiscountDTO mapRow(ResultSet rs, int i) throws SQLException {
       DisabledDiscountDTO result = new DisabledDiscountDTO(rs.getInt("PackageID"), rs.getInt("DisabledDiscountID"));
       return result;
    }
    
}
