/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TemporaryPackageChildrenDiscountDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class TempChildrenDiscountDTOMapper implements RowMapper<TemporaryPackageChildrenDiscountDTO> {

    private static TempChildrenDiscountDTOMapper instance = null;

    private TempChildrenDiscountDTOMapper() {
    }

    public static TempChildrenDiscountDTOMapper getInstance() {
        if (instance == null) {
            instance = new TempChildrenDiscountDTOMapper();
        }
        return instance;
    }

    @Override
    public TemporaryPackageChildrenDiscountDTO mapRow(ResultSet rs, int i) throws SQLException {
        TemporaryPackageChildrenDiscountDTO result = new TemporaryPackageChildrenDiscountDTO(rs.getInt("TemporaryPackageID"),rs.getInt("ChildrenDiscountID"));
        return result;
    }

}
