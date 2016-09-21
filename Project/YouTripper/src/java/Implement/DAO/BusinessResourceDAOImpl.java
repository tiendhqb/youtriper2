/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import Interface.DAO.BusinessResourceDAO;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author Long Nguyen
 */
public class BusinessResourceDAOImpl implements BusinessResourceDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public BusinessResourceDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public void insertNewResource(String name, int capacity, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("addNewProviderResource");
        SqlParameterSource in = new MapSqlParameterSource().addValue("name", name)
                .addValue("providerID", providerID).addValue("capacity", capacity);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void editOldResource(String name, int providerID, int capacity, int resourceID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("editProviderResource");
        SqlParameterSource in = new MapSqlParameterSource().addValue("name", name).addValue("resourceID", resourceID)
                .addValue("providerID", providerID).addValue("capacity", capacity);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void assignNewSkillToResource(int resourceID, int skillID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("assignSkillToProviderResource");
        SqlParameterSource in = new MapSqlParameterSource().addValue("resourceID", resourceID)
                .addValue("skillID", skillID);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void deleteResource(int resourceID, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("deleteProviderResorce");
        SqlParameterSource in = new MapSqlParameterSource().addValue("resourceID", resourceID)
                .addValue("providerID", providerID);
        simpleJdbcCall.execute(in);
    }

}
