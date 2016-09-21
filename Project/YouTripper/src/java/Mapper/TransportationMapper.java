/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TransportationDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class TransportationMapper implements RowMapper<TransportationDTO> {

    private static TransportationMapper instance = null;

    private TransportationMapper() {
    }

    public static TransportationMapper getInstance() {
        if (instance == null) {
            instance = new TransportationMapper();
        }
        return instance;
    }

    @Override
    public TransportationDTO mapRow(ResultSet rs, int i) throws SQLException {
        return new TransportationDTO(rs.getInt("TransportationID"), rs.getString("Name"), null, rs.getString("Image"));
    }

}
