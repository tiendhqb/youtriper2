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
public interface TemporaryClassifierDAO {
    public void insertTemporaryClassifier(int temporaryPackageID,int activityID, String content,int categoryID,String subCategoryContent,int providerID);
    
    public void updateClassifier(int packageID,int activityID, String content,int categoryID,String subCategoryContent);
    
}
