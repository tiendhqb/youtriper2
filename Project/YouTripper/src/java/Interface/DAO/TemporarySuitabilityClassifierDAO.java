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
public interface TemporarySuitabilityClassifierDAO {
    public void insertTemporarySuitabilityClassifier(int temporaryPackageID, int suitbilityID, String content,int providerID);
    public void insertTemporarySuitabilityClassifierv2(int temporaryPackageID, int suitbilityID, String content);
}
