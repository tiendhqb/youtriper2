/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import Interface.DAO.TemporaryClassifierDAO;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author Nick
 */
public class TemporaryClassifierDAOImpl implements TemporaryClassifierDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public TemporaryClassifierDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public void insertTemporaryClassifier(int temporaryPackageID, int activityID, String content,int categoryID,String subCategoryContent,int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertNewTemporaryClassifier");
        SqlParameterSource in = new MapSqlParameterSource().addValue("temporaryPackageID", temporaryPackageID)
                .addValue("activityID", activityID).addValue("content", content).addValue("categoryID", categoryID)
                .addValue("subCategoryContent", subCategoryContent).addValue("providerID", providerID);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void updateClassifier(int packageID, int activityID, String content, int categoryID, String subCategoryContent) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("updateClassifier");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("activityID", activityID).addValue("content", content).addValue("categoryID", categoryID).addValue("subCategoryContent", subCategoryContent);
        simpleJdbcCall.execute(in); }
}
