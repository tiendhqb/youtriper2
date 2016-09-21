/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import Interface.DAO.KeywordDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
public class KeywordDAOImpl implements KeywordDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public KeywordDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public List<String> getKeywords(String data) {
        String sql = "SELECT Keyword FROM SystemKeyword WHERE Keyword LIKE ? ORDER BY NumberViews";
        List<String> keywords = jdbcTemplate.query(sql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                String keyword = rs.getString("Keyword");
                return keyword;
            }
        }, "%" + data + "%");
        return keywords;
    }

    @Override
    public boolean insertNewKeyword(String keyword, String ip, String date) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertKeyword");
        SqlParameterSource in = new MapSqlParameterSource().addValue("keyword", keyword)
                .addValue("date", date)
                .addValue("IP", ip);
        simpleJdbcCall.execute(in);
        return true;

    }

    @Override
    public boolean insertNewSystemKeyword(String keyword, int times) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("addNewKeyword");
        SqlParameterSource in = new MapSqlParameterSource().addValue("keyword", keyword)
                .addValue("times", times);
        simpleJdbcCall.execute(in);
        return true;

    }

    @Override
    public boolean deleteKeywordCollection(String keyword) {
        String sql = "DELETE FROM KeywordCollection"
                + " WHERE Keyword = ?";
        jdbcTemplate.update(sql, keyword);
        return true;
    }

    @Override
    public boolean deleteAllKeywordCollection() {
        String sql = "DELETE FROM KeywordCollection";
        jdbcTemplate.update(sql);
        return true;
    }
}
