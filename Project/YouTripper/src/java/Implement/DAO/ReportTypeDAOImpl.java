/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.ReportTypeDTO;
import Interface.DAO.ReportTypeDAO;
import Mapper.ReportTypeDTOMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author DINH KHANG
 */
public class ReportTypeDAOImpl implements ReportTypeDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public ReportTypeDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public List<ReportTypeDTO> getReportType() {
        String sql = "Select * FROM ReportType";
        return jdbcTemplate.query(sql, ReportTypeDTOMapper.getInstance());
    }

}
