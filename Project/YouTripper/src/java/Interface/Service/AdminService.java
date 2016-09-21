/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Service;

import DTO.AdminSession;
import DTO.TemporaryPackageDTO;
import JavaClass.PackageApprovedEmailData;
import javax.mail.MessagingException;

/**
 *
 * @author Nick
 */
public interface AdminService {

    public AdminSession login(String username, String password);

    public String getCreatedTEmporaryPackage();
    
    public String getCreatedTEmporaryPassport();
    
    public String getCreatedTEmporaryPackagev2();
    
    public String getEditingPackages();

    public boolean approveTemporaryPackage(int packageID)  throws Exception;
    
    public boolean approveTemporaryPackagev2(int packageID)  throws Exception;

    public TemporaryPackageDTO editPackage(int packageID);
    
//    public String getPackageForm();

    public String getProviderPaymentList();

    public String viewBookingDetailByProviderID(int providerID);

    public boolean payOut();

    public String getKeywordCollection();

    public boolean insertNewSystemKeyword(String keyword, int times);

    public boolean deleteKeywordCollection(String keyword);

    public boolean deleteAllKeywordCollection();

    public boolean insertAllkeywordCollection();
    
    public void insertKeywordToSystem(int packageID);
    
    public void insertKeywordToSystemv2(int packageID);
    
    public boolean approveSubCategory(int temporaryPackageID);
    
    public boolean insertSalesman(String email,  String firstName, String lastName,String phoneNumber);
    
    public String getCertificae();
    
    public boolean approveCertificate(String[] certificateId);
    
    public boolean approvePassport(String data);
    
    public String getSalesman();
    
    public String getProviderListWithSalesman(String data);
    
    public boolean checkPhoneNumberIsExist(String data);
    
    public boolean sendPackageApprovedEmail(PackageApprovedEmailData emailData) throws MessagingException;
    
    public PackageApprovedEmailData getPackageApprovedEmailData(int providerID);
}
