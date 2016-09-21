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
public class DisabledDiscountDTOMapper implements RowMapper<DisabledDiscountDTO> {

    private static DisabledDiscountDTOMapper instance = null;

    private DisabledDiscountDTOMapper() {
    }

    public static DisabledDiscountDTOMapper getInstance() {
        if (instance == null) {
            instance = new DisabledDiscountDTOMapper();
        }
        return instance;
    }

    @Override
    public DisabledDiscountDTO mapRow(ResultSet rs, int i) throws SQLException {
        DisabledDiscountDTO result = new DisabledDiscountDTO(rs.getInt("DisabledDiscountID"), rs.getString("Condition"), rs.getInt("DiscountPercent"), rs.getInt("ProviderID"));
        return result;
    }

}
