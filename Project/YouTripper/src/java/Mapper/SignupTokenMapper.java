/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.SignupTokenDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class SignupTokenMapper implements RowMapper<SignupTokenDTO>{
    private static SignupTokenMapper instance = null;
    public SignupTokenMapper() {
    }
    public static SignupTokenMapper getInstance(){
        if(instance==null){
            instance = new SignupTokenMapper();
        }
        return instance;
    }
    @Override
    public SignupTokenDTO mapRow(ResultSet rs, int i) throws SQLException {
        SignupTokenDTO result = new SignupTokenDTO(rs.getString("Token"));
        return result;
    }
    
}
