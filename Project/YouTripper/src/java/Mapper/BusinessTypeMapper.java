/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.BusinessTypeDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class BusinessTypeMapper implements RowMapper<BusinessTypeDTO> {

    private static BusinessTypeMapper instance = null;

    private BusinessTypeMapper() {
    }

    public static BusinessTypeMapper getInstance() {
        if (instance == null) {
            instance = new BusinessTypeMapper();
        }
        return instance;
    }

    @Override
    public BusinessTypeDTO mapRow(ResultSet rs, int i) throws SQLException {
        return new BusinessTypeDTO(rs.getInt("BusinessTypeID"), rs.getString("Type"));
    }
    
    

}
