/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.ResourceDTOv2;
import java.util.List;

/**
 *
 * @author DINH KHANG
 */
public interface ResourceDAO {

    public List<ResourceDTOv2> getListOfResourceByProviderID(int providerID);
    
    public boolean addNewResourceByProviderID(String resourceName,int MaximunCapacity,int providerID);
    
    public int insertNewResourceAndReturnID(String resourceName, int capacity, String note, int providerID);
    
}
