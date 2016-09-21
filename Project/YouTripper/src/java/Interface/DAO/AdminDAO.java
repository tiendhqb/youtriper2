/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.AdminSession;
import DTO.BookingDTO;
import DTO.CertificateDTO;
import DTO.ProviderPayment;
import DTO.TemporaryPackageDTO;
import JavaClass.PackageApprovedEmailData;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface AdminDAO {

    public AdminSession login(String username, String password);

    public List<ProviderPayment> getProviderPaymentList();
    
    public List<BookingDTO> viewBookingDetail(int providerID);
    
    public boolean payout();
    
    public boolean insertSalesman(String email, String firstName, String lastName,String phone);
    
    public PackageApprovedEmailData getPackageApprovedEmailData(int packageID);
}
