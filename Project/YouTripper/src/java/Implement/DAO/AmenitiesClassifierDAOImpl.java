/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import Interface.DAO.AmenitiesClassifierDAO;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author QuangTran
 */
public class AmenitiesClassifierDAOImpl implements AmenitiesClassifierDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public AmenitiesClassifierDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public void updateAmeitiesClassifier(int packageID, int amenitiesID, int languageID, String description,int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("updatePackageAmenities");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("languageID", languageID)
                .addValue("amenitiesID", amenitiesID).addValue("description", description).addValue("providerID", providerID);
        simpleJdbcCall.execute(in);
    }

}
