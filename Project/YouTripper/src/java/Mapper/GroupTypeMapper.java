/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.GroupTypeDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class GroupTypeMapper implements RowMapper<GroupTypeDTO> {

    private static GroupTypeMapper instance = null;

    private GroupTypeMapper() {
    }

    public static GroupTypeMapper getInstance() {
        if (instance == null) {
            instance = new GroupTypeMapper();
        }
        return instance;
    }

    @Override
    public GroupTypeDTO mapRow(ResultSet rs, int i) throws SQLException {
        return new GroupTypeDTO(rs.getInt("GroupTypeID"), rs.getString("Name"));
    }

}
