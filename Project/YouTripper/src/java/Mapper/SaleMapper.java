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
public class SaleMapper implements RowMapper<BookingDTO> {

    private static SaleMapper instance = null;

    private SaleMapper() {
    }

    public static SaleMapper getInstance() {
        if (instance == null) {
            instance = new SaleMapper();
        }
        return instance;
    }

    @Override
    public BookingDTO mapRow(ResultSet rs, int i) throws SQLException {
        String bookingDate = rs.getString("BookingDate");
        int numberOfAdults = rs.getInt("NumberOfAdults");
        int numberOfChilds = rs.getInt("NumberOfChilds");
        double adultPrice = rs.getDouble("AdultPrice");
        double childPrice = rs.getDouble("ChildPrice");
        int tripperID = rs.getInt("TripperID");
        int packageID = rs.getInt("PackageID");
        String packageName = rs.getString("PackageName");
        String paid = rs.getString("Paid");
        int youTripperPercentage = rs.getInt("YoutripperPercentage");
        String tripperLastName = rs.getString("FirstName");
        String tripperFirstName = rs.getString("LastName");
        int profitPercentage = rs.getInt("ProfitPercentage");
        return new BookingDTO(bookingDate, numberOfAdults, numberOfChilds, adultPrice, childPrice, tripperID, packageID, packageName, paid, youTripperPercentage, tripperLastName, tripperFirstName,profitPercentage);
    }

}
