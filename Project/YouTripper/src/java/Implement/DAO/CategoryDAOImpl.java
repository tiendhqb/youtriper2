/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.CategoryDTO;
import Interface.DAO.CategoryDAO;
import Mapper.CategoryMapper;
import com.google.gson.Gson;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Nick
 */
public class CategoryDAOImpl implements CategoryDAO {

    private JdbcTemplate jdbcTemplate;

    public CategoryDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        String sql = "SELECT * FROM Category";
        List<CategoryDTO> categories = jdbcTemplate.query(sql, CategoryMapper.getInstance());        
        return categories;
    }

}
