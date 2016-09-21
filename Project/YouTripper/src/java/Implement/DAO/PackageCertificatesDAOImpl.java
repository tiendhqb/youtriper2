/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import Interface.DAO.PackageCertificatesDAO;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author QuangTran
 */
public class PackageCertificatesDAOImpl implements PackageCertificatesDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public PackageCertificatesDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public void updateNewCertificate(int packageID, int certificateID,int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("updatePackageCertificates");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("certificateID", certificateID).addValue("providerID", providerID);
        simpleJdbcCall.execute(in);
    }

}
