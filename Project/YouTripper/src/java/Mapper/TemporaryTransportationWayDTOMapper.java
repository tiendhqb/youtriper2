/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TemporaryTransoprtationWayDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class TemporaryTransportationWayDTOMapper implements RowMapper<TemporaryTransoprtationWayDTO> {

    private static TemporaryTransportationWayDTOMapper instance = null;

    private TemporaryTransportationWayDTOMapper() {
    }

    public static TemporaryTransportationWayDTOMapper getInstance() {
        if (instance == null) {
            instance = new TemporaryTransportationWayDTOMapper();
        }
        return instance;
    }

    @Override
    public TemporaryTransoprtationWayDTO mapRow(ResultSet rs, int i) throws SQLException {
        int temporaryPackageID = rs.getInt("TemporaryPackageID");
        int transporattionID = rs.getInt("TransportationID");
        String transportationName = rs.getString("Name");
        String transportationImage = rs.getString("Image");
        String content = rs.getString("Content");
        return new TemporaryTransoprtationWayDTO(temporaryPackageID, transporattionID, transportationName, transportationImage, content);
    }

}
