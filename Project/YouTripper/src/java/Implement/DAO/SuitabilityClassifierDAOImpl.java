/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import Interface.DAO.SuitabilityClassifierDAO;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author QuangTran
 */
public class SuitabilityClassifierDAOImpl implements SuitabilityClassifierDAO{
    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public SuitabilityClassifierDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }
    
    @Override
    public void updateSuitabilityClassifier(int packageID, int suitbilityID, String content, int delete,int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("updateSuitabilityClassifier");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("suitabilityID", suitbilityID).addValue("content", content).addValue("isDelete", delete).addValue("providerID", providerID);
        simpleJdbcCall.execute(in);}
    
}
