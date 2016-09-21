/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.OfflinePackageDTO;

/**
 *
 * @author Nick
 */
public interface OfflinePackageDAO {
    public OfflinePackageDTO getDurationOfPackage(int packageID);
}
