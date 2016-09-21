/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.ResourceDTOv2;
import Mapper.ResourceDTOv2Mapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import Interface.DAO.ResourceDAO;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author DINH KHANG
 */
public class ResourceDAOImpl implements ResourceDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public ResourceDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
//        simpleJdbcCall = new SimpleJdbcCall(dataSource);
    }

    @Override
    public List<ResourceDTOv2> getListOfResourceByProviderID(int providerID) {
        String sql = "SELECT * FROM ProviderResource where ProviderID = ?";
        List<ResourceDTOv2> resourceList = jdbcTemplate.query(sql, ResourceDTOv2Mapper.getInstance(), providerID);
        return resourceList;
    }

    @Override
    public boolean addNewResourceByProviderID(String resourceName, int MaximunCapacity, int providerID) {
        String sql = "INSERT INTO ProviderResource(ResourceName,MaximunCapacity,ProviderID) VALUES (?,?,?)";
        jdbcTemplate.update(sql, resourceName, MaximunCapacity, providerID);
        return true;
    }

    @Override
    public int insertNewResourceAndReturnID(String resourceName, int capacity, String note, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertProviderResourceWhenRegistration");
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID).addValue("resourceName", resourceName)
                .addValue("maximumCapacity", capacity).addValue("note", note);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return (Integer) record.get("resourceID");
    }

}
