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
public interface ServingPeriodDAO {
    public int insertServingPeriodAndGetID(int providerID, String startTime, String endTime, String name);
    
    public boolean updateServingPeriod(int servingID, String startTime, String endTime, String name);
}
