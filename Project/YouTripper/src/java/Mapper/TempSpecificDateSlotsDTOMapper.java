/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TempSpecificDateSlotsDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Long Nguyen
 */
public class TempSpecificDateSlotsDTOMapper implements RowMapper<TempSpecificDateSlotsDTO> {

    private static TempSpecificDateSlotsDTOMapper instance = null;

    private TempSpecificDateSlotsDTOMapper() {
    }

    public static TempSpecificDateSlotsDTOMapper getInstance() {
        if (instance == null) {
            instance = new TempSpecificDateSlotsDTOMapper();
        }
        return instance;
    }

    @Override
    public TempSpecificDateSlotsDTO mapRow(ResultSet rs, int i) throws SQLException {
        int id = rs.getInt("ID");
        String dateStr = rs.getString("DateStr");
        long dateInMilliseconds = rs.getLong("DateInMilliseconds");
        int maxQuota = rs.getInt("MaxQuota");
        
        return new TempSpecificDateSlotsDTO(id, dateStr, dateInMilliseconds, maxQuota);
    }

}
