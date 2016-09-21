/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.SalesmanDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author QuangTran
 */
public class SalesmanMapper implements RowMapper<SalesmanDTO> {

    private static SalesmanMapper instance = null;

    public SalesmanMapper() {
    }

    public static SalesmanMapper getInstance() {
        if (instance == null) {
            instance = new SalesmanMapper();
        }
        return instance;
    }

    @Override
    public SalesmanDTO mapRow(ResultSet rs, int i) throws SQLException {
        SalesmanDTO salesmanDTO = new SalesmanDTO(rs.getInt("SalesmanID"),rs.getString("Email"),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("PhoneNumber") );
        return salesmanDTO;
    }
}
