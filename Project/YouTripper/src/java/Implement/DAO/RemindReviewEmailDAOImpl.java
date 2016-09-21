/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.RemindReviewEmail;
import Interface.DAO.RemindReviewEmailDAO;
import Mapper.RemindReviewEmailMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author DINH KHANG
 */
public class RemindReviewEmailDAOImpl implements RemindReviewEmailDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public RemindReviewEmailDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public List<RemindReviewEmail> getBookingList() {
        String sql = "Select Booking.Code,Booking.SelectedDate,Tripper.Email,Tripper.LastName,Package.PackageID,Package.DurationType,Package.Duration"
                + " FROM Booking,Package,Tripper"
                + " WHERE Tripper.TripperID = Booking.TripperID and Package.PackageID = Booking.PackageID";
        List<RemindReviewEmail> result = jdbcTemplate.query(sql, RemindReviewEmailMapper.getInstance());
        return result;
    }

}
