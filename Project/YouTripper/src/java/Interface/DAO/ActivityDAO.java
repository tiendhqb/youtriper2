/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.ActivityDTO;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface ActivityDAO {

    /**
     * get all activities
     *
     * @return list of activities
     */
    public List<ActivityDTO> getAllActivities();
    
    public List<ActivityDTO> getActivitesByTempPackageID(int packageID);
    
    public List<ActivityDTO> getActivitesByCountry(String country);
    
    public boolean deleteAllActivityOfPackage(int packageID);
    
    public boolean insertActitivyToPackage(ActivityDTO activityDTO, int packageID);
    
    public List<ActivityDTO> getAllActivitiesForHome(int pageSize, int pageNumber);
    
    public List<ActivityDTO> getActivitiesWithLocationForHome(String location, int pageSize, int pageNumber);
}
