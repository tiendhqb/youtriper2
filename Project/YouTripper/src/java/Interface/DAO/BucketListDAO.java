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
public interface BucketListDAO {

    public boolean saveWishList(int packageID, int tripperID, String currentDate);

    public boolean removeFromWishList(int packageID, int tripperID);
    
    public boolean deleteCertificate(int CertificateID);
    
    public String getCertificateURL(int CertificateID);
}