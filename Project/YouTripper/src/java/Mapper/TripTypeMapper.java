/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TripTypeDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class TripTypeMapper implements RowMapper<TripTypeDTO> {

    private static TripTypeMapper instance = null;

    private TripTypeMapper() {
    }

    public static TripTypeMapper getInstance() {
        if (instance == null) {
            instance = new TripTypeMapper();
        }
        return instance;
    }

    @Override
    public TripTypeDTO mapRow(ResultSet rs, int i) throws SQLException {
        return new TripTypeDTO(rs.getInt("TripTypeID"), rs.getString("Name"));
    }

}
