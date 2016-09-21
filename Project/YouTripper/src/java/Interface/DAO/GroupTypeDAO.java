/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.GroupTypeDTO;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface GroupTypeDAO {

    public List<GroupTypeDTO> getAllGroupTypes();

    public List<GroupTypeDTO> getGroupTypesByPackageID(int packageID);
    
    public boolean deleteAllGroupTypeOfPackage(int packageID);
    
    public boolean insertGroupTypeToPackage(GroupTypeDTO groupTypeDTO, int packageID);
}
