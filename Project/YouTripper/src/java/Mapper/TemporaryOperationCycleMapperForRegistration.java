/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TemporaryOperationCycle;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class TemporaryOperationCycleMapperForRegistration implements RowMapper<TemporaryOperationCycle> {

    private static TemporaryOperationCycleMapperForRegistration instance = null;

    private TemporaryOperationCycleMapperForRegistration() {
    }

    public static TemporaryOperationCycleMapperForRegistration getInstance() {
        if (instance == null) {
            instance = new TemporaryOperationCycleMapperForRegistration();
        }
        return instance;
    }

    @Override
    public TemporaryOperationCycle mapRow(ResultSet rs, int i) throws SQLException {
        int cycleID = rs.getInt("CycleID");
        String startDate = rs.getString("StartDate");
        String endDate = rs.getString("EndDate");
        return new TemporaryOperationCycle(cycleID, startDate, endDate);
    }

}
