/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.TransportationDTO;
import Interface.DAO.TransporationDAO;
import Mapper.TransportationMapper;
import Mapper.TransportationWayMapper;
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
public class TransporationDAOImpl implements TransporationDAO {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public TransporationDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public List<TransportationDTO> getAllTransportation() {
        String sql = "SELECT * FROM Transportation";
        List<TransportationDTO> transportations = jdbcTemplate.query(sql, TransportationMapper.getInstance());
        return transportations;
    }

    @Override
    public List<TransportationDTO> getTransportationsByPackageID(int packageID) {
        String sql = "SELECT Transportation.TransportationID, Transportation.Name, way.[Content] "
                + "FROM Transportation, TemporaryTransportationWay way "
                + "WHERE  way.TemporaryPackageID = ? AND way.TransportationID = Transportation.TransportationID";
        List<TransportationDTO> transportations = jdbcTemplate.query(sql, TransportationWayMapper.getInstance(), packageID);
        return transportations;
    }

    @Override
    public boolean insertWayToTempPackage(int packageID, int transportationID) {
        String sql = "INSERT INTO TemporaryTransportationWay(TemporaryPackageID,TransportationID) VALUES (?,?)";
        jdbcTemplate.update(sql, packageID, transportationID);
        return true;
    }

    @Override
    public boolean insertOtherWayToTempPackage(int packageID, int transportationID, String content) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertWayToTempPackage");
        SqlParameterSource in = new MapSqlParameterSource().addValue("TemporaryPackageID", packageID).addValue("TransportationID", transportationID)
                .addValue("Content", content);
        simpleJdbcCall.execute(in);
        return true;
    }

    @Override
    public boolean insertOtherWayToTempPackagev2(int packageID, int transportationID, String content) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertWayToTempPackagev2");
        SqlParameterSource in = new MapSqlParameterSource().addValue("TemporaryPackageID", packageID).addValue("TransportationID", transportationID)
                .addValue("Content", content);
        simpleJdbcCall.execute(in);
        return true;
    }

}
