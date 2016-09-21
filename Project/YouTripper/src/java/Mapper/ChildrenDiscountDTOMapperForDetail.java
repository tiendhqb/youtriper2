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
 * @author Nick
 */
public class ChildrenDiscountDTOMapperForDetail implements RowMapper<ChildrenDiscountDTO> {

    private static ChildrenDiscountDTOMapperForDetail instance = null;

    private ChildrenDiscountDTOMapperForDetail() {
    }

    public static ChildrenDiscountDTOMapperForDetail getInstance() {
        if (instance == null) {
            instance = new ChildrenDiscountDTOMapperForDetail();
        }
        return instance;
    }

    @Override
    public ChildrenDiscountDTO mapRow(ResultSet rs, int i) throws SQLException {
        int childrenDiscountID = rs.getInt("ChildrenDiscountID");
        String condition = rs.getString("Condition");
        int age = rs.getInt("Age");
        String ageType = rs.getString("AgeType");
        int discountPercent = rs.getInt("DiscountPercent");
        boolean isFree = rs.getBoolean("isFree");
        return new ChildrenDiscountDTO(childrenDiscountID, condition, age, ageType, discountPercent, isFree);
    }
}
