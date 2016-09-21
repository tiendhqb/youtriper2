/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import Interface.DAO.ServingPeriodDAO;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author Nick
 */
public class ServingPeriodDAOImpl implements ServingPeriodDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public ServingPeriodDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
//        simpleJdbcCall = new SimpleJdbcCall(dataSource);
    }

    @Override
    public int insertServingPeriodAndGetID(int providerID, String startTime, String endTime, String name) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertServingPeriodWhenRegistration");
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID).addValue("startTime", startTime)
                .addValue("endTime", endTime).addValue("name", name);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return (Integer) record.get("servingID");
    }

    @Override
    public boolean updateServingPeriod(int servingID, String startTime, String endTime, String name) {
            String sql = "UPDATE ServingPeriod "
                + "SET StartOperationTime = ?, EndOperationTime = ?, Name = ? "
                + "WHERE ID = ?";
        jdbcTemplate.update(sql, startTime,endTime,name,servingID);
        return true;
    }

}
