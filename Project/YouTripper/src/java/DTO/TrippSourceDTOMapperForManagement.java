/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Long Nguyen
 */
public class TrippSourceDTOMapperForManagement implements RowMapper<TrippSourceDTO> {

    private static TrippSourceDTOMapperForManagement instance = null;

    private TrippSourceDTOMapperForManagement() {
    }

    public static TrippSourceDTOMapperForManagement getInstance() {
        if (instance == null) {
            instance = new TrippSourceDTOMapperForManagement();
        }
        return instance;
    }

    @Override
    public TrippSourceDTO mapRow(ResultSet rs, int i) throws SQLException {
        int trippSourceID = rs.getInt("TrippSourceID");
        int packageID = rs.getInt("PackageID");
        String packageName = rs.getString("Name");
        String type = rs.getString("PackageType");
        int noSkills = rs.getInt("NoSkills");
        int skillID = rs.getInt("SkillID");

        int hours;
        try {
            hours = rs.getInt("Hours");
        } catch (Exception e) {
            hours = 0;
        }

        int minutes;
        try {
            minutes = rs.getInt("Minutes");
        } catch (Exception e) {
            minutes = 0;
        }

        int days;
        try {
            days = rs.getInt("Days");
        } catch (Exception e) {
            days = 0;
        }

        int noUnits;
        try {
            noUnits = rs.getInt("NoUnits");
        } catch (Exception e) {
            noUnits = 0;
        }

        return new TrippSourceDTO(trippSourceID, packageID, packageName, type, noSkills, skillID, hours, minutes, days, noUnits);
    }

}
