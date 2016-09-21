/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import Interface.DAO.ResourceSkillDAO;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author Long Nguyen
 */
public class ResourceSkillDAOImpl implements ResourceSkillDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public ResourceSkillDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public void insertNewResourceSkill(int providerID, String resourceName) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("addNewResourceSkill");
        SqlParameterSource in = new MapSqlParameterSource().addValue("name", resourceName)
                .addValue("providerID", providerID);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void deleteSkill(int providerID, int skillID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("deleteSkill");
        SqlParameterSource in = new MapSqlParameterSource().addValue("skillID", skillID)
                .addValue("providerID", providerID);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void updateSkill(int providerID, int skillID, String skillName) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("editSkill");
        SqlParameterSource in = new MapSqlParameterSource().addValue("skillID", skillID)
                .addValue("providerID", providerID).addValue("skillName", skillName);
        simpleJdbcCall.execute(in);
    }

}
