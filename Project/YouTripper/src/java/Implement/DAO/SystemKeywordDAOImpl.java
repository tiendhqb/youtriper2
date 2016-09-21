/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import Interface.DAO.SystemKeywordDAO;
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
public class SystemKeywordDAOImpl implements SystemKeywordDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public SystemKeywordDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public void insertKeyword(String keyword) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("updateSystemKeyword");
        SqlParameterSource in = new MapSqlParameterSource().addValue("keyword", keyword);
        simpleJdbcCall.execute(in);
    }

    @Override
    public List<String> getSuggestionKeywords(String keyword, List<String> oldKeywords, int noKeywords) {
        int noParam = oldKeywords.size() + 1;
        Object[] listParams = new Object[noParam];
        listParams[0] = keyword;
        String condition = "SELECT TOP " + noKeywords + " (Keyword)"
                + " FROM SystemKeyword"
                + " WHERE Keyword LIKE ?";
        int index = 1;
        for (String oldKeyword : oldKeywords) {
            condition += " AND Keyword NOT LIKE ?";
            listParams[index] = "%" + oldKeyword + "%";
            index++;
        }
        String sql = "" + condition + " ORDER BY NumberViews";
        List<String> result = jdbcTemplate.query(sql, listParams, new RowMapper<String>() {

            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                return rs.getString("Keyword");
            }
        });
        return result;
    }

    @Override
    public void updateKeywordByPackage(int packageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("updatePopKeyword");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID);
        simpleJdbcCall.execute(in);
    }

}
