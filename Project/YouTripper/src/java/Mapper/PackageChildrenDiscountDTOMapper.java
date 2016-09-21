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
public class PackageChildrenDiscountDTOMapper implements RowMapper<ChildrenDiscountDTO>{
    
    private static PackageChildrenDiscountDTOMapper instance = null;

    private PackageChildrenDiscountDTOMapper() {
    }

    public static PackageChildrenDiscountDTOMapper getInstance() {
        if (instance == null) {
            instance = new PackageChildrenDiscountDTOMapper();
        }
        return instance;
    }

    @Override
    public ChildrenDiscountDTO mapRow(ResultSet rs, int i) throws SQLException {
        ChildrenDiscountDTO result = new ChildrenDiscountDTO(rs.getInt("PackageID"), rs.getInt("ChildrenDiscountID"));
        return result;
    }
    
}
