/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TemporaryPackageDisabledDiscountDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class TempDisabledDiscountDTOMapper implements RowMapper<TemporaryPackageDisabledDiscountDTO> {

    private static TempDisabledDiscountDTOMapper instance = null;

    private TempDisabledDiscountDTOMapper() {
    }

    public static TempDisabledDiscountDTOMapper getInstance() {
        if (instance == null) {
            instance = new TempDisabledDiscountDTOMapper();
        }
        return instance;
    }

    @Override
    public TemporaryPackageDisabledDiscountDTO mapRow(ResultSet rs, int i) throws SQLException {
        TemporaryPackageDisabledDiscountDTO result = new TemporaryPackageDisabledDiscountDTO(rs.getInt("TemporaryPackageID"), rs.getInt("DisabledDiscountID"));
        return result;
    }

}
