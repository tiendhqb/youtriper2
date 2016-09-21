/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ProviderPayment;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class ProviderPaymentMapper implements RowMapper<ProviderPayment>{

    private static ProviderPaymentMapper instance = null;

    private ProviderPaymentMapper() {
    }

    public static ProviderPaymentMapper getInstance() {
        if (instance == null) {
            instance = new ProviderPaymentMapper();
        }
        return instance;
    }
    @Override
    public ProviderPayment mapRow(ResultSet rs, int i) throws SQLException {
        ProviderPayment payment = new ProviderPayment(rs.getInt("ProviderID"),rs.getString("LastName"),rs.getString("Image"),rs.getDouble("Total"));
        return payment;
    }
    
}
