/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.OfflinePackageDTO;
import DTO.PackageDTO;
import Interface.DAO.OfflinePackageDAO;
import Mapper.OfflinePackageMapperWithDuration;
import Mapper.PackageDTOMapperWithDuration;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author Nick
 */
public class OfflinePackageDAOImpl implements OfflinePackageDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public OfflinePackageDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public OfflinePackageDTO getDurationOfPackage(int packageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getDurationOfOflinePackage")
                .returningResultSet("rs1", OfflinePackageMapperWithDuration.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<OfflinePackageDTO> result = (List<OfflinePackageDTO>) record.get("rs1");
        return result.get(0);
    }

}
