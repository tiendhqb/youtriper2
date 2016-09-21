/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.ReviewDTO;
import Interface.DAO.ReviewDAO;
import Mapper.ReviewDTOMapper;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author Nick
 */
public class ReviewDAOImpl implements ReviewDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public ReviewDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
//        simpleJdbcCall = new SimpleJdbcCall(dataSource);
    }

    @Override
    public List<ReviewDTO> getReviewsByTime(int time, int packageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getReviewsByT");
        simpleJdbcCall.returningResultSet("rs1", ReviewDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("time", time);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return (List<ReviewDTO>) record.get("rs1");
    }

    @Override
    public List<ReviewDTO> getReviewsOfProviderByTime(int time, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getReviewsOfProviderByT");
        simpleJdbcCall.returningResultSet("rs1", ReviewDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID).addValue("time", time);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return (List<ReviewDTO>) record.get("rs1");
    }

    @Override
    public List<ReviewDTO> getReviewsOfTripperByTime(int time, int tripperID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getReviewsOfTripperByT");
        simpleJdbcCall.returningResultSet("rs1", ReviewDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("tripperID", tripperID).addValue("time", time);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return (List<ReviewDTO>) record.get("rs1");
    }

    @Override
    public boolean checkReviewExist(int tripperID,String bookingID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("checkReviewExist");
        SqlParameterSource in = new MapSqlParameterSource().addValue("tripperID", tripperID).addValue("bookingID", bookingID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        String result = (String) record.get("result");
        return result.equals("true");
    }

    @Override
    public boolean makeReview(int tripperID,String bookingID, int packageID, String review, double rate, String date,int Professionlism,int StaffAttitude,int Convenient,int Satisfaction,int AmenityQuality,int Cleanliness) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("makeReview");
        SqlParameterSource in = new MapSqlParameterSource().addValue("tripperID", tripperID).addValue("bookingID", bookingID)
                .addValue("packageID", packageID).addValue("review", review).addValue("rate", rate).addValue("date", date).addValue("Professionlism", Professionlism)
                .addValue("StaffAttitude", StaffAttitude).addValue("Convenient", Convenient).addValue("Satisfaction", Satisfaction).addValue("AmenityQuality", AmenityQuality).addValue("Cleanliness", Cleanliness);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return true;
    }

}
