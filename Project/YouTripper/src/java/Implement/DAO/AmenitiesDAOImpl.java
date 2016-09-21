/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.AmenitiesDTO;
import Interface.DAO.AmenitiesDAO;
import Mapper.AmenitiesMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Nick
 */
public class AmenitiesDAOImpl implements AmenitiesDAO {

    private JdbcTemplate jdbcTemplate;

    public AmenitiesDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<AmenitiesDTO> getAllAmenities() {
        String sql = "SELECT * FROM Amenities";
        List<AmenitiesDTO> listAmenities = jdbcTemplate.query(sql, AmenitiesMapper.getInstance());
        return listAmenities;
    }

    @Override
    public List<AmenitiesDTO> getListAmenitiesByPackageID(int packageID) {
        String sql = "SELECT Amenities.* FROM Amenities, TemporaryAmenitiesClassifier classifier "
                + "WHERE  classifier.TemporaryPackageID = ? AND classifier.AmenitiesID = Amenities.AmenitiesID";
        List<AmenitiesDTO> listAmenities = jdbcTemplate.query(sql, AmenitiesMapper.getInstance(), packageID);
        return listAmenities;
    }

    @Override
    public boolean insertAmenitiesOfTempPackage(int packageID, int amenitiesID) {
        String sql = "INSERT INTO TemporaryAmenitiesClassifier(TemporaryPackageID,AmenitiesID) VALUES (?,?)";
        jdbcTemplate.update(sql, packageID, amenitiesID);
        return true;
    }

}
