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
public class BookingDTOMapperForBook implements RowMapper<BookingDTO> {

    public static BookingDTOMapperForBook instance = null;

    public BookingDTOMapperForBook() {
    }

    public static BookingDTOMapperForBook getInstance() {
        if (instance == null) {
            instance = new BookingDTOMapperForBook();
        }
        return instance;
    }

    @Override
    public BookingDTO mapRow(ResultSet rs, int i) throws SQLException {
        return new BookingDTO(rs.getString("SelectedDate"), rs.getInt("NumberOfAdults"), rs.getInt("NumberOfChilds"));
    }
    
    
}
