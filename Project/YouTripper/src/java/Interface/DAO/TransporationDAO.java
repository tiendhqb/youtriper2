/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.TransportationDTO;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface TransporationDAO {

    public List<TransportationDTO> getAllTransportation();

    public List<TransportationDTO> getTransportationsByPackageID(int packageID);
    
    public boolean insertWayToTempPackage(int packageID, int transportationID);
    
    public boolean insertOtherWayToTempPackage(int packageID, int transportationID, String content);
    
    public boolean insertOtherWayToTempPackagev2(int packageID, int transportationID, String content);
}
