/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.OperationCycleDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class OperationCycleMapperForRegistration implements RowMapper<OperationCycleDTO> {

    private static OperationCycleMapperForRegistration instance = null;

    private OperationCycleMapperForRegistration() {
    }

    public static OperationCycleMapperForRegistration getInstance() {
        if (instance == null) {
            instance = new OperationCycleMapperForRegistration();
        }
        return instance;
    }

    @Override
    public OperationCycleDTO mapRow(ResultSet rs, int i) throws SQLException {
        int cycleID = rs.getInt("CycleID");
        String startDate = rs.getString("StartDate");
        String endDate = rs.getString("EndDate");
        return new OperationCycleDTO(cycleID, startDate, endDate);
    }

}