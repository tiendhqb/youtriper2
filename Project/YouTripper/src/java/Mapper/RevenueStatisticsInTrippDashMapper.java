/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import JavaClass.RevenueStatisticsInTrippDash;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class RevenueStatisticsInTrippDashMapper implements RowMapper<RevenueStatisticsInTrippDash> {

    private static RevenueStatisticsInTrippDashMapper instance = null;

    private RevenueStatisticsInTrippDashMapper() {
    }

    public static RevenueStatisticsInTrippDashMapper getInstance() {
        if (instance == null) {
            instance = new RevenueStatisticsInTrippDashMapper();
        }
        return instance;
    }

    @Override
    public RevenueStatisticsInTrippDash mapRow(ResultSet rs, int i) throws SQLException {
        RevenueStatisticsInTrippDash result = new RevenueStatisticsInTrippDash(rs.getFloat("TotalRevenue"),rs.getLong("SelectedDateMilliseconds"), rs.getString("SelectedDate"));
        return result;
    }

}
