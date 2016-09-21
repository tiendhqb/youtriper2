/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.CountryDTO;
import Interface.DAO.CountryDAO;
import Mapper.CountryMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author DINH KHANG
 */
public class CountryDAOImpl implements CountryDAO{
    private JdbcTemplate jdbcTemplate;

    public CountryDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
        
    
    @Override
    public List<CountryDTO> getAllCountry() {
        String sql = "Select * From Country";
        List<CountryDTO> result = jdbcTemplate.query(sql, CountryMapper.getInstance());
        return result;
    }
    
}
