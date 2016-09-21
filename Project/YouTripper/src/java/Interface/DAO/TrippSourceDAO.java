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
public interface TrippSourceDAO {

    public void assignNewTrippSourceToPackage(Integer packageID, Integer temporaryPackageID, int noUnits, Integer hours, Integer minutes, Integer days);

    public void editTrippSource(Integer packageID, Integer temporaryPackageID, int providerID, int trippSourceID, int noUnits, Integer hours, Integer minutes, Integer days);
    
    public void assignNewSkillToTrippSource(Integer packageID, Integer temporaryPackageID, int providerID, int trippSourceID, int skillID);
    
    public void deleteTrippSource(int providerID, Integer packageID, Integer temporaryPackageID, int trippSourceID);
}
