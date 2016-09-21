/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.TemporaryAmenitiesClassifierDTO;

/**
 *
 * @author Nick
 */
public interface TemporaryAmenitiesClassifierDAO {
    public void insertNewAmenitiesClassifier(TemporaryAmenitiesClassifierDTO amenitiesClassifier);
    
    public void insertNewAmenitiesClassifierv2(TemporaryAmenitiesClassifierDTO amenitiesClassifier);
    
    public void updateAmeitiesClassifier(int packageID, int amenitiesID, int languageId, String description, int providerID);
}
