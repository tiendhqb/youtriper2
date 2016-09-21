/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.AmenitiesDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class AmenitiesTypeMapperWithOnlyType implements RowMapper<AmenitiesDTO> {

    private static AmenitiesTypeMapperWithOnlyType instance = null;

    private AmenitiesTypeMapperWithOnlyType() {
    }

    public static AmenitiesTypeMapperWithOnlyType getInstance() {
        if (instance == null) {
            instance = new AmenitiesTypeMapperWithOnlyType();
        }
        return instance;
    }

    @Override
    public AmenitiesDTO mapRow(ResultSet rs, int i) throws SQLException {
        AmenitiesDTO amenitiesDTO = new AmenitiesDTO(rs.getString("AmenitiesType"),rs.getString("Image"));
        return amenitiesDTO;
    }
}
