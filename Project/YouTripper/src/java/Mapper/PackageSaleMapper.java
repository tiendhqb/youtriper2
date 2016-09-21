/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.PackageSale;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class PackageSaleMapper implements RowMapper<PackageSale>{
    public static PackageSaleMapper instance = null;

    public PackageSaleMapper() {
    }

    public static PackageSaleMapper getInstance() {
        if (instance == null) {
            instance = new PackageSaleMapper();
        }
        return instance;

    }
    @Override
    public PackageSale mapRow(ResultSet rs, int i) throws SQLException {
     PackageSale result = new PackageSale(rs.getInt("PackageID"),rs.getString("Name"), rs.getInt("NumberOfBooking"),0,rs.getString("EndDate"),rs.getDouble("Revenue"),rs.getString("Paid"));
     return result;
    }
    
}
