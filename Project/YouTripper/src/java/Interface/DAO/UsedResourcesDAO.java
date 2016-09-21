/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

/**
 *
 * @author Nick
 */
public interface UsedResourcesDAO {

    public boolean isTimeAvailable(int packageID, String tripDate, String tripTime);

    public boolean isDateAvailable(int packageID, String tripDate);
}
