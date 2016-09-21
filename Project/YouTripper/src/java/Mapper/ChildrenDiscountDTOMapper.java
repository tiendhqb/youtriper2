/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ChildrenDiscountDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class ChildrenDiscountDTOMapper implements RowMapper<ChildrenDiscountDTO> {

    private static ChildrenDiscountDTOMapper instance = null;

    private ChildrenDiscountDTOMapper() {
    }

    public static ChildrenDiscountDTOMapper getInstance() {
        if (instance == null) {
            instance = new ChildrenDiscountDTOMapper();
        }
        return instance;
    }

    @Override
    public ChildrenDiscountDTO mapRow(ResultSet rs, int i) throws SQLException {
        ChildrenDiscountDTO result = new ChildrenDiscountDTO(rs.getInt("ChildrenDiscountID"), rs.getString("Condition"), rs.getInt("Age"), rs.getString("AgeType"), rs.getInt("DiscountPercent"), rs.getBoolean("isFree"), rs.getInt("ProviderID"));
        return result;
    }

}
