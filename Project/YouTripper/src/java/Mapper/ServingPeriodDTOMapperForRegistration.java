/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ResourcesDTO;
import DTO.ServingPeriodDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class ServingPeriodDTOMapperForRegistration implements RowMapper<ServingPeriodDTO> {

    private static ServingPeriodDTOMapperForRegistration instance = null;

    private ServingPeriodDTOMapperForRegistration() {
    }

    public static ServingPeriodDTOMapperForRegistration getInstance() {
        if (instance == null) {
            instance = new ServingPeriodDTOMapperForRegistration();
        }
        return instance;
    }

    @Override
    public ServingPeriodDTO mapRow(ResultSet rs, int i) throws SQLException {
        int id = rs.getInt("ID");
        String startOperationTime = rs.getString("StartOperationTime");
        String endOperationTime = rs.getString("EndOperationTime");
        String name = rs.getString("Name");
        return new ServingPeriodDTO(id, startOperationTime, endOperationTime, name);
    }

}
