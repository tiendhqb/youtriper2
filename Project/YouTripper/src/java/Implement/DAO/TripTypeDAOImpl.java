/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.TripTypeDTO;
import Interface.DAO.TripTypeDAO;
import Mapper.TripTypeMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Nick
 */
public class TripTypeDAOImpl implements TripTypeDAO {

    private JdbcTemplate jdbcTemplate;

    public TripTypeDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<TripTypeDTO> getAllTripTypes() {
        String sql = "SELECT * FROM TripType";
        List<TripTypeDTO> tripTypes = jdbcTemplate.query(sql, TripTypeMapper.getInstance());
        return tripTypes;
    }

    @Override
    public List<TripTypeDTO> getTripTypesByPackageID(int packageID) {
        String sql = "SELECT TripType.* FROM TripType, TemporaryTrip trip "
                + "WHERE  trip.TemporaryPackageID = ? AND trip.TripTypeID = TripType.TripTypeID";
        List<TripTypeDTO> tripTypes = jdbcTemplate.query(sql, TripTypeMapper.getInstance(), packageID);
        return tripTypes;
    }

    @Override
    public boolean insertTripTypeToPackage(TripTypeDTO tripTypeDTO, int packageID) {
        String sql = "INSERT INTO TemporaryTrip(TemporaryPackageID,TripTypeID) VALUES (?,?)";
        int record = jdbcTemplate.update(sql, packageID, tripTypeDTO.getTripTypeID());
        return true;
    }

    @Override
    public boolean deleteAllTripTypeOfPackage(int packageID) {
        String sql = "DELETE FROM TemporaryTrip WHERE TemporaryTrip.TemporaryPackageID = ?";
        int record = jdbcTemplate.update(sql, packageID);
        return true;
    }

}
