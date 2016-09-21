/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.GroupTypeDTO;
import Interface.DAO.GroupTypeDAO;
import Mapper.GroupTypeMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Nick
 */
public class GroupTypeDAOImpl implements GroupTypeDAO {

    private JdbcTemplate jdbcTemplate;

    public GroupTypeDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<GroupTypeDTO> getAllGroupTypes() {
        String sql = "SELECT * FROM GroupType";
        List<GroupTypeDTO> groupTypes = jdbcTemplate.query(sql, GroupTypeMapper.getInstance());
        return groupTypes;
    }

    @Override
    public List<GroupTypeDTO> getGroupTypesByPackageID(int packageID) {
        String sql = "SELECT GroupType.* FROM GroupType, TemporaryGroup temporaryGroup "
                + "WHERE  temporaryGroup.TemporaryPackageID = ? AND temporaryGroup.GroupTypeID = GroupType.GroupTypeID";
        List<GroupTypeDTO> groupTypes = jdbcTemplate.query(sql, GroupTypeMapper.getInstance(), packageID);
        return groupTypes;
    }

    @Override
    public boolean insertGroupTypeToPackage(GroupTypeDTO groupTypeDTO, int packageID) {
        String sql = "INSERT INTO TemporaryGroup(TemporaryPackageID,GroupTypeID) VALUES (?,?)";
        jdbcTemplate.update(sql, packageID, groupTypeDTO.getGroupTypeID());
        return true;
    }

    @Override
    public boolean deleteAllGroupTypeOfPackage(int packageID) {
        String sql = "DELETE FROM TemporaryGroup WHERE TemporaryGroup.TemporaryPackageID = ?";
        jdbcTemplate.update(sql, packageID);
        return true;
    }
}
