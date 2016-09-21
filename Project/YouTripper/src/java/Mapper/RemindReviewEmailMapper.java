/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import DTO.RemindReviewEmail;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DINH KHANG
 */
public class RemindReviewEmailMapper implements RowMapper<RemindReviewEmail> {

    private static RemindReviewEmailMapper instance = null;

    private RemindReviewEmailMapper() {
    }

    public static RemindReviewEmailMapper getInstance() {
        if (instance == null) {
            instance = new RemindReviewEmailMapper();
        }
        return instance;
    }

    @Override
    public RemindReviewEmail mapRow(ResultSet rs, int i) throws SQLException {
        RemindReviewEmail result = new RemindReviewEmail(rs.getString("Code"), rs.getString("SelectedDate"), rs.getString("Email"), rs.getString("LastName"), rs.getInt("PackageID"), rs.getInt("DurationType"), rs.getInt("Duration"));
        return result;
    }

}
