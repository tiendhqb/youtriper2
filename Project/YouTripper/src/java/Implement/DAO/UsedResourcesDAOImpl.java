/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import Interface.DAO.UsedResourcesDAO;
import Mapper.PackageDTOv2ForNewestMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author Nick
 */
public class UsedResourcesDAOImpl implements UsedResourcesDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public UsedResourcesDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public boolean isTimeAvailable(int packageID, String tripDate, String tripTime) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getAvailabilityOfSpecificdateAndTime");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("tripDate", tripDate).addValue("tripTime", tripTime);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        Boolean isAvailable = (Boolean) record.get("isAvailable");
        return isAvailable;
    }

    @Override
    public boolean isDateAvailable(int packageID, String tripDate) {
         simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getAvailabilityOfSpecificdate");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("tripDate", tripDate);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        Boolean isAvailable = (Boolean) record.get("isAvailable");
        return isAvailable;
    }

}
