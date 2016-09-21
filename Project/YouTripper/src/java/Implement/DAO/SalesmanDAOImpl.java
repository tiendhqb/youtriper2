/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.AccountSession;
import DTO.ProviderDTO;
import DTO.SalemanSession;
import DTO.SalesmanDTO;
import Interface.DAO.SalesmanDAO;
import Mapper.AccountSessionMaper;
import Mapper.ProviderPhoneNumberMapper;
import Mapper.ProviderSalesmanMapper;
import Mapper.SalesmanMapper;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.util.DigestUtils;

/**
 *
 * @author QuangTran
 */
public class SalesmanDAOImpl implements SalesmanDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public SalesmanDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public SalemanSession loginToSalesmanAccount(String username, String password) {
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("loginToSalesman");
        SqlParameterSource in = new MapSqlParameterSource().addValue("username", username).addValue("password", password);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        int id = (int) record.get("id");
        String name = (String) record.get("name");
        return new SalemanSession(id, name, 4);
    }

    @Override
    public List<ProviderDTO> getProviderlistBySalesmanId(int salesmanId) {
//        String sql = "Select ProviderID,FirstName,ProviderOfficialID,LastName,ActiveDate,Email,PhoneNumber,Address From Provider Where SalesmanID = ?";
//        List<ProviderDTO> listProvider = (List<ProviderDTO>) jdbcTemplate.query(sql, ProviderSalesmanMapper.getInstance(), salesmanId);
//        for (int i = 0; i < listProvider.size(); i++) {
//            ProviderDTO provider = listProvider.get(i);
//            String apSql = "SELECT COUNT(PackageID) FROM Package WHERE ProviderID ="+provider.getProviderID();
//            provider.setActivatePackage(jdbcTemplate.queryForObject(apSql, Integer.class));
//            apSql = "SELECT COUNT(TemporaryPackageID) FROM TemporaryPackage WHERE ProviderID ="+provider.getProviderID();
//            provider.setPendingPackage(jdbcTemplate.queryForObject(apSql, Integer.class));
//        }

        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getProviderListFromSalesman");
        simpleJdbcCall.returningResultSet("rs1", ProviderSalesmanMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("salesmanId", salesmanId);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return ((List<ProviderDTO>) record.get("rs1"));
    }

    @Override
    public List<SalesmanDTO> getSalesmanList() {
        String sql = "Select * From Salesman";
        return (List<SalesmanDTO>) jdbcTemplate.query(sql, SalesmanMapper.getInstance());
    }

    @Override
    public int getSalesmanIdByPhoneNumber(String phonenumber) {
        String sql = "Select Count(SalesmanID) From Salesman WHERE PhoneNumber=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, phonenumber);
    }

}
