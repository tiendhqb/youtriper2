/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.TripTypeDTO;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface TripTypeDAO {
    public List<TripTypeDTO> getAllTripTypes();
    
    public List<TripTypeDTO> getTripTypesByPackageID(int packageID);
    
    public boolean deleteAllTripTypeOfPackage(int packageID);
    
    public boolean insertTripTypeToPackage(TripTypeDTO tripTypeDTO, int packageID);
}
