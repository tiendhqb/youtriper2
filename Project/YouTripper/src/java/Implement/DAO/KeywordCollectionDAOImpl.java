/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.KeywordCollectionDTO;
import Interface.DAO.KeywordCollectionDAO;
import Mapper.KeywordCollectionDTOMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author DINH KHANG
 */
public class KeywordCollectionDAOImpl implements KeywordCollectionDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public KeywordCollectionDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public List<KeywordCollectionDTO> getKeywordCollectionList() {
        String sql = "Select * FROM KeywordCollection";
        List<KeywordCollectionDTO> result = jdbcTemplate.query(sql, KeywordCollectionDTOMapper.getInstance());
        return result;
    }

}
