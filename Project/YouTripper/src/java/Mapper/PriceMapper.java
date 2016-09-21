/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.PriceDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class PriceMapper implements RowMapper<PriceDTO> {
    
    private static PriceMapper instance = null;

    private PriceMapper() {
    }

    public static PriceMapper getInstance() {
        if (instance == null) {
            instance = new PriceMapper();
        }
        return instance;
    }

    @Override
    public PriceDTO mapRow(ResultSet rs, int i) throws SQLException {
        int id = rs.getInt("TemporaryPriceID");
        int packageID = rs.getInt("PackageID");
        String date = rs.getString("Date");
        double amountForChild = rs.getDouble("AmountForChild"); 
        double amountForAdult = rs.getDouble("AmountForAdult"); 
        PriceDTO priceDTO = new PriceDTO(id, packageID, date, amountForChild, amountForAdult);
        return priceDTO;
    }
    
}
