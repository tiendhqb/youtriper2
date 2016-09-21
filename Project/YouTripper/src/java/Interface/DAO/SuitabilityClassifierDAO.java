/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

/**
 *
 * @author QuangTran
 */
public interface SuitabilityClassifierDAO {
    public void updateSuitabilityClassifier(int packageID, int suitbilityID, String content, int delete,int providerID);
}
