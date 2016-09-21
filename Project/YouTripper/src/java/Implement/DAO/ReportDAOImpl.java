/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import Interface.DAO.ReportDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author DINH KHANG
 */
public class ReportDAOImpl implements ReportDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public ReportDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public boolean reportProvider(int providerID, String report) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String date2 = dateFormat.format(date);
        String sql = "INSERT INTO Report VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, date2, report, "provider", null, providerID);
        return true;
    }

    @Override
    public boolean reportTripper(int tripperID, String report) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String date2 = dateFormat.format(date);
        String sql = "INSERT INTO Report VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, date2, report, "tripper", tripperID, null);
        return true;
    }

}
