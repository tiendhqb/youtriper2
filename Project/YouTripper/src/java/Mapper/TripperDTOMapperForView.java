/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TripperDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class TripperDTOMapperForView implements RowMapper<TripperDTO>{

    private static TripperDTOMapperForView instance = null;

    public static TripperDTOMapperForView getInstance() {
        if (instance == null) {
            instance = new TripperDTOMapperForView();
        }
        return instance;
    }
    @Override
    public TripperDTO mapRow(ResultSet rs, int i) throws SQLException {
        TripperDTO result = new TripperDTO(rs.getInt("TripperID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Image"), rs.getString("Address"), rs.getString("Information"),rs.getBoolean("EmailActive"),rs.getString("ActiveDate"),rs.getString("Language"));
        return result;
    }
    
}
