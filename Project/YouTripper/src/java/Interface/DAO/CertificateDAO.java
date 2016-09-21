/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.CertificateDTO;
import DTO.ProviderDTO;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface CertificateDAO {
    public List<CertificateDTO> insertNewCertificates(int providerID, String image, String name);
    
    public List<CertificateDTO> getCertificate();
    
    
    public boolean approveCertificate(Object[] setCertificateId, String sqlPlus);
    
    public boolean approvePassport(String sqlPlus, Object[] providerIDArr);
    
    public List<ProviderDTO> getCreatedPassport();
}
