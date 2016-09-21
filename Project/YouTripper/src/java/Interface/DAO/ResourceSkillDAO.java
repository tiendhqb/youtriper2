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
public interface ResourceSkillDAO {

    public void insertNewResourceSkill(int providerID, String resourceName);

    public void deleteSkill(int providerID, int skillID);

    public void updateSkill(int providerID, int skillID, String skillName);
    
}
