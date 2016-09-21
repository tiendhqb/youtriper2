/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.SubCategoryDTO;
import Interface.DAO.SubCategoryDAO;
import Mapper.SubCategoryMapper;
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
public class SubCategoryDAOImpl implements SubCategoryDAO {


    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public SubCategoryDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public List<SubCategoryDTO> getAllSubCategories() {
        String sql = "SELECT * FROM SubCategory";
        List<SubCategoryDTO> subCategories = jdbcTemplate.query(sql, SubCategoryMapper.getInstance());
        return subCategories;
    }

    @Override
    public List<SubCategoryDTO> getAllSubCategoriesWithinLocation(String location,int categoryID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getSubCategoriesWithinLocation")
                .returningResultSet("rs1", SubCategoryMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("country", location).addValue("categoryID", categoryID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return (List<SubCategoryDTO>) record.get("rs1");
    }
}
