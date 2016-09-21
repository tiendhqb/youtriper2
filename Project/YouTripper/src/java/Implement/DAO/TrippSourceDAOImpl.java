/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import Interface.DAO.TrippSourceDAO;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author Long Nguyen
 */
public class TrippSourceDAOImpl implements TrippSourceDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public TrippSourceDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public void assignNewTrippSourceToPackage(Integer packageID, Integer temporaryPackageID, int noUnits, Integer hours, Integer minutes, Integer days) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("addNewTrippSourceToPackage");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("temporaryPackageID", temporaryPackageID).addValue("noUnits", noUnits)
                .addValue("hours", hours).addValue("minutes", minutes).addValue("days", days);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void editTrippSource(Integer packageID, Integer temporaryPackageID, int providerID, int trippSourceID,
            int noUnits, Integer hours, Integer minutes, Integer days) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("editTrippSource");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("temporaryPackageID", temporaryPackageID).addValue("noUnits", noUnits).addValue("providerID", providerID)
                .addValue("hours", hours).addValue("minutes", minutes).addValue("days", days).addValue("trippSourceID", trippSourceID);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void assignNewSkillToTrippSource(Integer packageID, Integer temporaryPackageID, int providerID, int trippSourceID, int skillID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("assignNewTrippSourceSkill");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("temporaryPackageID", temporaryPackageID).addValue("providerID", providerID)
                .addValue("skillID", skillID).addValue("trippSourceID", trippSourceID);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void deleteTrippSource(int providerID, Integer packageID, Integer temporaryPackageID, int trippSourceID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("deleteTrippSource");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("temporaryPackageID", temporaryPackageID).addValue("providerID", providerID).addValue("trippSourceID", trippSourceID);
        simpleJdbcCall.execute(in);
    }

}
