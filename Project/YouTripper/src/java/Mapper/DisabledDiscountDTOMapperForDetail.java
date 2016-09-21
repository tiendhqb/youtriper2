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
 * @author Nick
 */
public class DisabledDiscountDTOMapperForDetail implements RowMapper<DisabledDiscountDTO> {

    private static DisabledDiscountDTOMapperForDetail instance = null;

    private DisabledDiscountDTOMapperForDetail() {
    }

    public static DisabledDiscountDTOMapperForDetail getInstance() {
        if (instance == null) {
            instance = new DisabledDiscountDTOMapperForDetail();
        }
        return instance;
    }

    @Override
    public DisabledDiscountDTO mapRow(ResultSet rs, int i) throws SQLException {
        int disabledDiscountID = rs.getInt("DisabledDiscountID");
        String condition = rs.getString("Condition");
        int discountPercent = rs.getInt("DiscountPercent");
        return new DisabledDiscountDTO(disabledDiscountID, condition, discountPercent);
    }

}
