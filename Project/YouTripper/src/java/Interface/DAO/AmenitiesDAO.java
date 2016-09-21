/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.AmenitiesDTO;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface AmenitiesDAO {
    
     /**
     * get all activities
     *
     * @return list of activities
     */
    public List<AmenitiesDTO> getAllAmenities();
    
    public List<AmenitiesDTO> getListAmenitiesByPackageID(int packageID);
    
    public boolean insertAmenitiesOfTempPackage(int packageID, int amenitiesID);
    
}
