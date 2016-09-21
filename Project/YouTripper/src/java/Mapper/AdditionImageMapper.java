/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import JavaClass.AdditionalImages;
import DTO.AdditionImageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class AdditionImageMapper implements RowMapper<AdditionImageDTO> {

    public static AdditionImageMapper instance = null;

    public AdditionImageMapper() {
    }

    public static AdditionImageMapper getInstance() {
        if (instance == null) {
            instance = new AdditionImageMapper();
        }
        return instance;

    }

    @Override
    public AdditionImageDTO mapRow(ResultSet rs, int i) throws SQLException {
        AdditionImageDTO result = new AdditionImageDTO(rs.getString("Link"), rs.getString("Caption"));
        return result;
    }

}
