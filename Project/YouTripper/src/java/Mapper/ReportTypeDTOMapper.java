/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ReportTypeDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class ReportTypeDTOMapper implements RowMapper<ReportTypeDTO>{
    private static ReportTypeDTOMapper instance = null;

    private ReportTypeDTOMapper() {
    }

    public static ReportTypeDTOMapper getInstance() {
        if (instance == null) {
            instance = new ReportTypeDTOMapper();
        }
        return instance;
    }
    @Override
    public ReportTypeDTO mapRow(ResultSet rs, int i) throws SQLException {
      ReportTypeDTO result = new ReportTypeDTO(rs.getInt("ReportTypeID"),rs.getString("Name").trim());
      return result;
    }
}
