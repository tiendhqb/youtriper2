/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ResourceSkillDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Long Nguyen
 */
public class ResourceSkillDTOMapperForManagement implements RowMapper<ResourceSkillDTO> {

    private static ResourceSkillDTOMapperForManagement instance = null;

    private ResourceSkillDTOMapperForManagement() {
    }

    public static ResourceSkillDTOMapperForManagement getInstance() {
        if (instance == null) {
            instance = new ResourceSkillDTOMapperForManagement();
        }
        return instance;
    }

    @Override
    public ResourceSkillDTO mapRow(ResultSet rs, int i) throws SQLException {
        int skillID = rs.getInt("SkillID");
        String name = rs.getString("Name");
        return new ResourceSkillDTO(skillID, name);
    }

}
