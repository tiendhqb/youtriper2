/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.DeleteReasonDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author QuangTran
 */
public class DeleteReasonMapper implements RowMapper<DeleteReasonDTO>{
     private static DeleteReasonMapper instance = null;

    private DeleteReasonMapper() {
    }

    public static DeleteReasonMapper getInstance() {
        if (instance == null) {
            instance = new DeleteReasonMapper();
        }
        return instance;
    }
    
     @Override
    public DeleteReasonDTO mapRow(ResultSet rs, int i) throws SQLException {
        DeleteReasonDTO eletdeReasonDTO = new DeleteReasonDTO(rs.getInt("DeleteReasonID"), rs.getString("DeleteContent"),rs.getBoolean("isOther"));
        return eletdeReasonDTO;
    }
}
