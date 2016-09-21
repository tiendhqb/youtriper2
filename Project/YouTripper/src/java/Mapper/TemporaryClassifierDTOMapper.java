/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TemporaryClassifierDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class TemporaryClassifierDTOMapper implements RowMapper<TemporaryClassifierDTO> {

    private static TemporaryClassifierDTOMapper instance = null;

    private TemporaryClassifierDTOMapper() {
    }

    public static TemporaryClassifierDTOMapper getInstance() {
        if (instance == null) {
            instance = new TemporaryClassifierDTOMapper();
        }
        return instance;
    }

    @Override
    public TemporaryClassifierDTO mapRow(ResultSet rs, int i) throws SQLException {
        int temporaryPackageID = rs.getInt("TemporaryPackageID");
        int activityID = rs.getInt("ActivityID");
        String activityName = rs.getString("Name");
        int subCategoryID = rs.getInt("SubCategoryID");
        String content = rs.getString("Content");
        return new TemporaryClassifierDTO(temporaryPackageID, activityID, activityName, subCategoryID, content);
    }

}
