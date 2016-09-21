/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.BookingDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class BookingMapperForDetail implements RowMapper<BookingDTO>  {
    
    
    public static BookingMapperForDetail instance = null;

    public BookingMapperForDetail() {
    }

    public static BookingMapperForDetail getInstance() {
        if (instance == null) {
            instance = new BookingMapperForDetail();
        }
        return instance;
    }

    @Override
    public BookingDTO mapRow(ResultSet rs, int i) throws SQLException {
           String code = rs.getString("Code");
        String selectedDate = rs.getString("SelectedDate");
        int numberOfAdults = rs.getInt("NumberOfAdults");
        int numberOfChilds = rs.getInt("NumberOfChilds");
        int tripperID = rs.getInt("TripperID");
        String packageCountry = rs.getString("Country");
        String packageCity = rs.getString("City");
        String packageDepartureTime = rs.getString("DepartureTime");
        String tripperImage = rs.getString("Image");
        String tripperLastName = rs.getString("LastName");
        String tripperFirstName = rs.getString("FirstName");
        String packageState = rs.getString("State");
        return new BookingDTO(code, selectedDate, numberOfAdults, numberOfChilds, tripperID, 
                packageCountry, packageCity, packageState, packageDepartureTime, tripperImage, tripperLastName, tripperFirstName);
    }
    
    
}
