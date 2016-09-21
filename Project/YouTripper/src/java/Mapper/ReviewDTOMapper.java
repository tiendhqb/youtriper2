/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.ReviewDTO;
import DTO.SubCategoryDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nick
 */
public class ReviewDTOMapper implements RowMapper<ReviewDTO> {

    private static ReviewDTOMapper instance = null;

    private ReviewDTOMapper() {
    }

    public static ReviewDTOMapper getInstance() {
        if (instance == null) {
            instance = new ReviewDTOMapper();
        }
        return instance;
    }

    @Override
    public ReviewDTO mapRow(ResultSet rs, int i) throws SQLException {
//        SubCategoryDTO subCategoryDTO = new SubCategoryDTO(rs.getInt("SubCategoryID"), rs.getString("Name"), rs.getInt("CategoryID"));
        return new ReviewDTO(rs.getInt("TripperID"), rs.getString("TripperName"), rs.getInt("PackageID")
                , rs.getString("Review"), rs.getInt("Rate"), rs.getString("Date"), rs.getInt("TotalRecords"),rs.getString("tripperImage"));
    }
}
