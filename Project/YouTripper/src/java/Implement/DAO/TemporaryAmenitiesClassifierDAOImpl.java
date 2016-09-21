/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.TemporaryAmenitiesClassifierDTO;
import Interface.DAO.TemporaryAmenitiesClassifierDAO;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author Nick
 */
public class TemporaryAmenitiesClassifierDAOImpl implements TemporaryAmenitiesClassifierDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public TemporaryAmenitiesClassifierDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public void insertNewAmenitiesClassifier(TemporaryAmenitiesClassifierDTO amenitiesClassifier) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertNewTemporaryAmenitiesClassifier");
        SqlParameterSource in = new MapSqlParameterSource().addValue("temporaryPackageID", amenitiesClassifier.getTemporaryPackageID())
                .addValue("amenitiesID", amenitiesClassifier.getAmenitiesID()).addValue("description", amenitiesClassifier.getDescription());
        simpleJdbcCall.execute(in);
    }

    @Override
    public void insertNewAmenitiesClassifierv2(TemporaryAmenitiesClassifierDTO amenitiesClassifier) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertNewTemporaryAmenitiesClassifierv2");
        SqlParameterSource in = new MapSqlParameterSource().addValue("temporaryPackageID", amenitiesClassifier.getTemporaryPackageID())
                .addValue("amenitiesID", amenitiesClassifier.getAmenitiesID()).addValue("description", amenitiesClassifier.getDescription());
        simpleJdbcCall.execute(in);
    }

    @Override
    public void updateAmeitiesClassifier(int packageID, int amenitiesID, int languageID, String description, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("updateTemporaryPackageAmenities");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("languageID", languageID)
                .addValue("amenitiesID", amenitiesID).addValue("description", description).addValue("providerID", providerID);
        simpleJdbcCall.execute(in);
    }
    
}
