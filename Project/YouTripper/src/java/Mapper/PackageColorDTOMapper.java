/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.PackageColorDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class PackageColorDTOMapper implements RowMapper<PackageColorDTO> {

    private static PackageColorDTOMapper instance = null;

    private PackageColorDTOMapper() {
    }

    public static PackageColorDTOMapper getInstance() {
        if (instance == null) {
            instance = new PackageColorDTOMapper();
        }
        return instance;
    }

    @Override
    public PackageColorDTO mapRow(ResultSet rs, int i) throws SQLException {
        PackageColorDTO result = new PackageColorDTO(rs.getInt("ColorId"), rs.getString("ColorCode"));
        return result;
    }

}
