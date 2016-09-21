/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import Interface.DAO.BucketListDAO;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author Nick
 */
public class BucketListDAOImpl implements BucketListDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public BucketListDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public boolean saveWishList(int packageID, int tripperID, String currentDate) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("saveWishList");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("tripperID", tripperID)
                .addValue("currentDate", currentDate);
        simpleJdbcCall.execute(in);
        return true;
    }

    @Override
    public boolean removeFromWishList(int packageID, int tripperID) {
        String sql = "DELETE "
                + "FROM BucketList "
                + "WHERE PackageID = ? AND TripperID = ?";
        jdbcTemplate.update(sql, packageID, tripperID);
        return true;
    }
    
    @Override
    public boolean deleteCertificate(int CertificateID) {
        String sql = "DELETE "
                + "FROM Certificate "
                + "WHERE CertificateID = ?";
        jdbcTemplate.update(sql, CertificateID);
        return true;
    }
    
     @Override
    public String getCertificateURL(int CertificateID) {
        String sql = "SELECT Image "
                + "FROM Certificate "
                + "WHERE CertificateID = ?";
        String result = jdbcTemplate.queryForObject(sql,String.class, CertificateID); 
        return result;
    }

}
