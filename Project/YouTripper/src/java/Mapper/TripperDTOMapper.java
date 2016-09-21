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
public class TripperDTOMapper implements RowMapper<TripperDTO>{

    public static TripperDTOMapper instance = null;

    public TripperDTOMapper() {
    }

    public static TripperDTOMapper getInstance() {
        if (instance == null) {
            instance = new TripperDTOMapper();
        }
        return instance;

    }
    @Override
    public TripperDTO mapRow(ResultSet rs, int i) throws SQLException {
       TripperDTO result = new TripperDTO(rs.getInt("TripperID"),rs.getString("Email"),rs.getString("Password"),
               rs.getString("FirstName"),rs.getString("LastName"),rs.getString("Birthday"),rs.getString("Image"),
               rs.getString("PhoneNumber"),rs.getString("Address"),rs.getString("countryName"),rs.getString("Interest"),rs.getString("Information"),
               rs.getString("Language"),rs.getBoolean("Active"),rs.getString("ActiveDate"),rs.getBoolean("Gender"),rs.getBoolean("Notification"));
       return result;
    }
    
}
