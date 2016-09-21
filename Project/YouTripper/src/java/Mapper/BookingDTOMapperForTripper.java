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
 * @author DINH KHANG
 */
public class BookingDTOMapperForTripper implements RowMapper<BookingDTO> {

    public static BookingDTOMapperForTripper instance = null;

    public BookingDTOMapperForTripper() {
    }

    public static BookingDTOMapperForTripper getInstance() {
        if (instance == null) {
            instance = new BookingDTOMapperForTripper();
        }
        return instance;

    }

    @Override
    public BookingDTO mapRow(ResultSet rs, int i) throws SQLException {
        BookingDTO result = new BookingDTO(rs.getString("Code"), rs.getString("BookingDate"), 
                rs.getInt("NumberOfAdults"), rs.getDouble("AdultPrice"), rs.getString("SelectedDate"), rs.getInt("NoOfPackages"),
                rs.getInt("TripperID"), rs.getInt("PackageID"), rs.getInt("ProviderID"), rs.getString("PackageName"), rs.getString("CoverImage"),
                rs.getString("Country"), rs.getString("City"), rs.getDouble("OrdinaryPriceForAdult"), rs.getDouble("Rate"),
                rs.getInt("NumberRate"), rs.getString("LastName"), rs.getString("Image"));
        return result;
    }
}
