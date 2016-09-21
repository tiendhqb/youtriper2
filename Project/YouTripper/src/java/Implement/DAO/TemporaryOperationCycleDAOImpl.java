/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import Interface.DAO.TemporaryOperationCycleDAO;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author Nick
 */
public class TemporaryOperationCycleDAOImpl implements TemporaryOperationCycleDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public TemporaryOperationCycleDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public void insertNewTemporaryCycle(int packageID, String startDate, String endDate) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertNewTempCycle");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("startDate", startDate).addValue("endDate", endDate);
        simpleJdbcCall.execute(in);
    }

}
