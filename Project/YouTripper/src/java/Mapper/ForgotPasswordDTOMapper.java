/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ForgotPasswordDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class ForgotPasswordDTOMapper implements RowMapper<ForgotPasswordDTO>{

    private static ForgotPasswordDTOMapper instance = null;

    private ForgotPasswordDTOMapper() {
    }

    public static ForgotPasswordDTOMapper getInstance() {
        if (instance == null) {
            instance = new ForgotPasswordDTOMapper();
        }
        return instance;
    }
    @Override
    public ForgotPasswordDTO mapRow(ResultSet rs, int i) throws SQLException {
        ForgotPasswordDTO result = new ForgotPasswordDTO(rs.getString("Token"), rs.getString("Email"));
        return result;
    }
    
}
