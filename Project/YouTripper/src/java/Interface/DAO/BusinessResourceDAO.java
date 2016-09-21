/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

/**
 *
 * @author Long Nguyen
 */
public interface BusinessResourceDAO {

    public void insertNewResource(String name, int capacity, int providerID);

    public void editOldResource(String name, int providerID, int capacity, int resourceID);
    
    public void assignNewSkillToResource(int resourceID, int skillID);
    
    public void deleteResource(int resourceID, int providerI);
}
