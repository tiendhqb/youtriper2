/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.AccountSession;
import DTO.ProviderDTO;
import DTO.ProviderSession;
import JavaClass.BookingDetailInTripDash;
import JavaClass.HighestPackageInTripDash;
import JavaClass.LowestPackageInTripDash;
import JavaClass.ResourceManagementData;
import JavaClass.TripDash;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface ProviderDAO {
    
    public AccountSession registerProvider(int businessType,  String businessName, int countryID, String city, String address,String phoneCode, String phone, 
            String firstName, String lastName, String displayName, String job, String email, String password, boolean notification, String referralCode, String openTime, String closeTime, String referralOfficialID);
    
    public ProviderSession login(String username, String password);
    
    public ProviderDTO getPhoneNumber(int providerID);
    
    public String getSMSCode(int providerID,String phoneCode,String phoneNumber);
    
    public String verifySMS(int providerID,String smsCode);
    
    
    public ProviderDTO getAccountInfo(int providerID);
    
    public int getReferralCount(int providerID);
    
    public List<ProviderDTO> getReferralInfo(int providerID);
    
    public boolean checkVerifyPhoneNumber(int providerID);
    
    public boolean updateProviderImage(int providerID, String image);
    
    public boolean updateProviderPassportImage(int providerID, String image, String uploadTime);
    
    public boolean updateCertificateImage(int providerID, String image);

    public AccountSession updateProviderInformation(String firstName, String lastName, String information, String interests, String taxnumber, String language, int providerID, boolean notification);
    
    public boolean updateCertificateInformation(String Name, int CertificateID);
    
    public boolean updateCertificateStatus(int CertificateID);
    
    public boolean changeProviderPassword(int providerID,String oldPassword,String newPassword);
    
    public ProviderDTO getProviderPage(int providerID);
    
    public ProviderDTO getProviderID(String url);
    
    public boolean isVerifyPhoneNumber(int providerID);
    
    public ResourceManagementData getResourceManagementData(int providerID);
    
    public boolean checkCreatingPackageExist(int providerID);
    
    public TripDash getProviderTrippDash(int providerID,long currentTime,long last30Days);
    
    public TripDash loadTopLeftBooking(int providerID,long date);
    
    public HighestPackageInTripDash loadHighestPackage(int providerID,long date,long lastDate,String packageType);
    
    public LowestPackageInTripDash loadLowestPackage(int providerID,long date,long lastDate,String packageType);
    
    public String loadStatisticsInTripDash(long date,int packageID,long lastDate,String statisticsType);
}
