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
public class OperationCycleMapperForDetail implements RowMapper<OperationCycleDTO> {

    private static OperationCycleMapperForDetail instance;

    private OperationCycleMapperForDetail() {
    }

    public static OperationCycleMapperForDetail getInstance() {
        if (instance == null) {
            instance = new OperationCycleMapperForDetail();
        }
        return instance;
    }

    @Override
    public OperationCycleDTO mapRow(ResultSet rs, int i) throws SQLException {
        String startDate = rs.getString("StartDate");
        String endDate = rs.getString("EndDate");
        return new OperationCycleDTO(startDate, endDate);
    }

}
