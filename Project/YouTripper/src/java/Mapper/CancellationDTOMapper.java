/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.CancellationDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class CancellationDTOMapper implements RowMapper<CancellationDTO> {

    private static CancellationDTOMapper instance = null;

    private CancellationDTOMapper() {
    }

    public static CancellationDTOMapper getInstance() {
        if (instance == null) {
            instance = new CancellationDTOMapper();
        }
        return instance;
    }

    @Override
    public CancellationDTO mapRow(ResultSet rs, int i) throws SQLException {
        CancellationDTO result = new CancellationDTO(rs.getInt("CancellationID"), rs.getInt("ProviderID"), rs.getString("Name"),rs.getString("Conditions"));
        return result;
    }
}
