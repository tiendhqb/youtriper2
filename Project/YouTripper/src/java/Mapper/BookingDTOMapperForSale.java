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
public class BookingDTOMapperForSale implements RowMapper<BookingDTO> {

    public static BookingDTOMapperForSale instance = null;

    public BookingDTOMapperForSale() {
    }

    public static BookingDTOMapperForSale getInstance() {
        if (instance == null) {
            instance = new BookingDTOMapperForSale();
        }
        return instance;

    }

    @Override
    public BookingDTO mapRow(ResultSet rs, int i) throws SQLException {
        BookingDTO result = new BookingDTO(rs.getString("Code"), rs.getString("BookingDate"),rs.getString("SelectedDate"),rs.getInt("NumberOfAdults"),rs.getInt("NumberOfChilds"),rs.getDouble("AdultPrice"),rs.getDouble("ChildPrice"),rs.getInt("TripperID"),rs.getInt("PackageID"), rs.getInt("ProviderID"),rs.getString("Paid"),rs.getInt("YoutripperPercentage"));
        return result;
    }

}
