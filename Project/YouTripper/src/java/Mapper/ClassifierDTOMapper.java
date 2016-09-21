/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ClassifierDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author QuangTran
 */
public class ClassifierDTOMapper implements RowMapper<ClassifierDTO> {
    
    private static ClassifierDTOMapper instance = null;

    private ClassifierDTOMapper() {
    }

    public static ClassifierDTOMapper getInstance() {
        if (instance == null) {
            instance = new ClassifierDTOMapper();
        }
        return instance;
    }

    @Override
    public ClassifierDTO mapRow(ResultSet rs, int i) throws SQLException {
        int temporaryPackageID = rs.getInt("PackageID");
        int activityID = rs.getInt("ActivityID");
        String activityName = rs.getString("Name");
        int subCategoryID = rs.getInt("SubCategoryID");
        String content = rs.getString("Content");
        return new ClassifierDTO(temporaryPackageID, activityID, activityName, subCategoryID, content);
    }
}
