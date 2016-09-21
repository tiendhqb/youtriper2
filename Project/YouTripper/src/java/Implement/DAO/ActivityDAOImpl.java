/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.ActivityDTO;
import Interface.DAO.ActivityDAO;
import Mapper.ActivityMapper;
import Mapper.ActivityMapperForHome;
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
public class ActivityDAOImpl implements ActivityDAO {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public ActivityDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public List<ActivityDTO> getAllActivities() {
        String sql = "SELECT * FROM Activity";
        List<ActivityDTO> activities = jdbcTemplate.query(sql, ActivityMapper.getInstance());
        return activities;
    }

    @Override
    public List<ActivityDTO> getAllActivitiesForHome(int pageSize, int pageNumber) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getAllActivitiesByPage")
                .returningResultSet("rs1", ActivityMapperForHome.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("RowspPage", pageSize).addValue("PageNumber", pageNumber);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return (List<ActivityDTO>) record.get("rs1");
    }

    @Override
    public List<ActivityDTO> getActivitiesWithLocationForHome(String location, int pageSize, int pageNumber) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getActivitiesWithinLocation")
                .returningResultSet("rs1", ActivityMapperForHome.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("RowspPage", pageSize).addValue("PageNumber", pageNumber)
                .addValue("country", location);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return (List<ActivityDTO>) record.get("rs1");
    }

    @Override
    public List<ActivityDTO> getActivitesByTempPackageID(int packageID) {
        String sql = "SELECT Activity.* FROM Activity, TemporaryClassifier AS classifier "
                + "WHERE classifier.TemporaryPackageID = ? AND classifier.ActivityID = Activity.ActivityID";
        List<ActivityDTO> activities = jdbcTemplate.query(sql, ActivityMapper.getInstance(), packageID);
        return activities;
    }

    @Override
    public boolean insertActitivyToPackage(ActivityDTO activityDTO, int packageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertActivityToTemporaryPackage");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("activityID", activityDTO.getActivityID());
        simpleJdbcCall.execute(in);
        return true;
    }

    @Override
    public boolean deleteAllActivityOfPackage(int packageID) {
        String sql = "DELETE FROM TemporaryClassifier WHERE TemporaryClassifier.TemporaryPackageID = ?";
        int record = jdbcTemplate.update(sql, packageID);
        return true;
    }

    @Override
    public List<ActivityDTO> getActivitesByCountry(String country) {
        String sql = "SELECT Activity.* \n"
                + "FROM Activity\n"
                + "WHERE Activity.ActivityID in (Select Classifier.ActivityID\n"
                + "FROM Classifier,Package\n"
                + "Where Package.Country= ? and Package.PackageID = Classifier.PackageID)";
        List<ActivityDTO> activities = jdbcTemplate.query(sql, ActivityMapper.getInstance(), country);
        return activities;
    }
}
