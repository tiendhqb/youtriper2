/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TempCustomisedWeekSlotDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Long Nguyen
 */
public class TempCustomisedWeekSlotDTOMapper implements RowMapper<TempCustomisedWeekSlotDTO> {

    private static TempCustomisedWeekSlotDTOMapper instance = null;

    private TempCustomisedWeekSlotDTOMapper() {
    }

    public static TempCustomisedWeekSlotDTOMapper getInstance() {
        if (instance == null) {
            instance = new TempCustomisedWeekSlotDTOMapper();
        }
        return instance;
    }

    @Override
    public TempCustomisedWeekSlotDTO mapRow(ResultSet rs, int i) throws SQLException {
        int id = rs.getInt("ID");
        int week = rs.getInt("Week");
        int day = rs.getInt("Day");
        int maxQuota = rs.getInt("MaxQuota");
        return new TempCustomisedWeekSlotDTO(id, week, day, maxQuota);
    }

}
