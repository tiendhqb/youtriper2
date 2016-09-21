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
 * @author DINH KHANG
 */
public class TemporaryOperationCycleMapperForPreview implements RowMapper<TemporaryOperationCycle> {

    private static TemporaryOperationCycleMapperForPreview instance = null;

    private TemporaryOperationCycleMapperForPreview() {
    }

    public static TemporaryOperationCycleMapperForPreview getInstance() {
        if (instance == null) {
            instance = new TemporaryOperationCycleMapperForPreview();
        }
        return instance;
    }

    @Override
    public TemporaryOperationCycle mapRow(ResultSet rs, int i) throws SQLException {
        String startDate = rs.getString("StartDate");
        String endDate = rs.getString("EndDate");
        return new TemporaryOperationCycle(startDate, endDate);
    }

}
