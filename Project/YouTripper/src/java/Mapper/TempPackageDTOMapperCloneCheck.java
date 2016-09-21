/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.TemporaryPackageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class TempPackageDTOMapperCloneCheck implements RowMapper<TemporaryPackageDTO> {

    private static TempPackageDTOMapperCloneCheck instance = null;

    private TempPackageDTOMapperCloneCheck() {
    }

    public static TempPackageDTOMapperCloneCheck getInstance() {
        if (instance == null) {
            instance = new TempPackageDTOMapperCloneCheck();
        }
        return instance;
    }

    @Override
    public TemporaryPackageDTO mapRow(ResultSet rs, int i) throws SQLException {
        TemporaryPackageDTO result = new TemporaryPackageDTO(rs.getInt("TemporaryPackageID"));
        return result;
    }

}
