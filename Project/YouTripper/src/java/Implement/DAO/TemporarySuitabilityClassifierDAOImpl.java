/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import Interface.DAO.TemporarySuitabilityClassifierDAO;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author Nick
 */
public class TemporarySuitabilityClassifierDAOImpl implements TemporarySuitabilityClassifierDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public TemporarySuitabilityClassifierDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public void insertTemporarySuitabilityClassifier(int temporaryPackageID, int suitbilityID, String content,int providerID) {
            simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertNewTemporarySuitabilityClassifier");
        SqlParameterSource in = new MapSqlParameterSource().addValue("temporaryPackageID", temporaryPackageID)
                .addValue("suitbilityID", suitbilityID).addValue("content", content).addValue("providerID", providerID);
        simpleJdbcCall.execute(in);
    }
    @Override
    public void insertTemporarySuitabilityClassifierv2(int temporaryPackageID, int suitbilityID, String content) {
            simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertNewTemporarySuitabilityClassifierv2");
        SqlParameterSource in = new MapSqlParameterSource().addValue("temporaryPackageID", temporaryPackageID)
                .addValue("suitbilityID", suitbilityID).addValue("content", content);
        simpleJdbcCall.execute(in);
    }
}
