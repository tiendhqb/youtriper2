/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Service;

import DTO.AccountSession;
import DTO.CertificatesViewDTO;
import DTO.PackageDTO;
import DTO.ProviderDTO;
import DTO.ProviderNotification;
import DTO.ProviderNotificationSetting;
import DTO.ProviderSession;
import DTO.SaleInfo;
import DTO.TemporaryPackageDTO;
import DTO.TemporaryPackageDTOv2;
import DTO.AdditionImageDTO;
import JavaClass.FileMeta;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Nick
 */
public interface ProviderService {

    public ProviderSession login(String email, String password);

    public String getPackagesOfProvider(int providerID);

    public String getCertificatesOfProvider(int providerID);
    
    public String getApprovedCertificatesOfProvider(int providerID);

    public CertificatesViewDTO getCertificateURL(int certificateID);

    public boolean isProvider(AccountSession account);

    public TemporaryPackageDTO getTemporaryPackage(int providerID);

    public TemporaryPackageDTOv2 getTemporaryPackagev2(int providerID);

    public PackageDTO getPackage(int packageId);

    public String getPackageForm(int providerID);

    public String getPackageFormForEdit(int providerID);

    public boolean applyTempPackageToPreview(int packageID, int providerID);

    public boolean applyTempPackageToPreviewv2(int packageID);

    public boolean deleteCertificate(int CertificateID, HttpSession session);

    public List<String> getKeywords(String data);

    public boolean insertActivityForm(String dataJson,int providerID);

    public boolean editActivityForm(String dataJson,int providerID);

    public void updateDescriptionFormOfTempPackage(String dataJson, int providerID);

    public void updateDescriptionFormOfPackage(String dataJson,int providerID);

    public boolean updateExtrasOfTempPackage(String dataJson);

    public boolean updateExtrasOfTempPackagev2(String dataJson);

    public boolean editExtrasOfPackage(String dataJson);

    public boolean updateCoverAndPhotoOfTempPackage(String type, String dataJson,int providerID);

    public boolean updateCoverAndPhotoOfTempPackagev2(String dataJson,int providerID);

    public boolean editPhotoOfPackage(String type, String dataJson,int providerID);

    public boolean updateLocationOfTemPackage(String dataJson);

    public boolean updateLocationOfTemPackagev2(String dataJson);

    public boolean editLocationOfPackage(String dataJson);

    public boolean updatePriceOfTemPackage(String dataJson,int providerID);

    public boolean editPriceOfPackage(String dataJson,int providerID);

    public boolean updatePromotionOfTempPackage(String dataJson);

    public boolean editPromotionOfPackage(String dataJson);

    public String getTemporaryPackageForPreviewing(int temporaryPackageID, boolean isFinished);

    public String getTemporaryPackageForPreviewingv2(int temporaryPackageID, boolean isFinished);

    public boolean updateAdditionImage(int packageID, List<AdditionImageDTO> images);

    public boolean updateAdditionImagePackage(int packageID, List<AdditionImageDTO> images);

    public boolean updateAdditionImagev2(int packageID, List<AdditionImageDTO> images);

    public String removeAdditionalImage(String data);

    public String removeAdditionalImagePackage(String data);

    public String removeAdditionalImagev2(String data);

    public String uploadAdditionalImages(MultipartFile[] additionalImages, int temporaryPackageID, String imagesJson) throws IOException;

    public String uploadAdditionalImagesPackage(MultipartFile[] additionalImages, int temporaryPackageID, String imagesJson) throws IOException;

    public String uploadAdditionalImagesv2(MultipartFile[] additionalImages, int temporaryPackageID, String imagesJson) throws IOException;

    public ProviderDTO getPhoneNumber(int providerID);

    public ProviderDTO getAccountInfo(int providerID);

    public int getReferralCount(int providerID);
    
    public String getReferralList(int providerID);

    public List<PackageDTO> getPackageForStatictis(int providerID);

    public String getBookingForStatictis(int packageID);

    public SaleInfo getSaleInfo(int providerID);

    public List<ProviderNotification> getProviderNotification();

    public List<ProviderNotificationSetting> getProviderNotificationSetting(int providerID);

    public boolean saveSetting(int providerID, String settingValue);

    public String getSMSCode(int providerID, String phoneCode, String phoneNumber);

    public String verifySMS(int providerID, String smsCode);

    public boolean checkValidatePhoneNumber(int providerID);

    public boolean updateProviderImage(int providerID, String image);

    public String cropAndSaveProviderImage(String data, int providerID, FileMeta imageMeta) throws IOException;

    public String updateProviderPassportImage(int providerID, MultipartFile providerImage);

    public boolean updateCertificateImage(int providerID, String image);

    public AccountSession updateProviderInformation(HttpServletRequest request, HttpSession session);

    public boolean updateCertificateInformation(HttpServletRequest request, HttpSession session);
    
    public boolean updateCertificateUpdate(int certificateID);

    public boolean changeProviderPassword(int providerID, String oldPassword, String newPassword);

    public boolean isVerifyPhoneNumber(int providerID);

    public boolean insertNewProviderSystemNotification(String content, boolean seen, int providerID);

    public String getProviderNewNotification(int providerID);

    public boolean seenNotification(int notificationID);

    public String getBookings(int packageID, int providerID) throws ParseException;

    public String getDateBookingDetail(int providerID, int packageID, String data) throws ParseException;

    public String getBookingDetail(String data);

    public String getAllPackageOfProviderWithName(int providerID);

    public String getSales(String data, int providerID) throws ParseException;

    public boolean seenMessage(int providerID);

    public String getPackageForEdit(int packageID);

    public boolean deletePackage(int packageID);

    public boolean checkImageExist(String name, int temporaryPackageID);

    public boolean deleteAdditionalImage(String image, int temporaryPackageID);
    
    public boolean deleteAdditionalImagePackage(String image, int temporaryPackageID);

    public boolean deleteAdditionalImagev2(String image, int temporaryPackageID);

    public String insertNewCertificate(String data, FileMeta certificateImage, int providerID) throws FileNotFoundException, IOException;

    public String insertNewCertificateProvider(String data, FileMeta certificateImage) throws FileNotFoundException, IOException;

    public String getBookingEngineDat(int providerID);

    public String getResourceListbyProviderID(String data);

    public String addNewResourceByProviderID(String data);

    public String insertResourceAndGetInsertedID(String data, int providerID);

    public boolean saveAvailability(String data);

    public String insertEngineBooking(String data, int providerID);
    
    public void insertOfflineBooking(String data, int providerID);

    public String insertNewOfflineAndReturnNewList(String data, int providerID);

    public boolean sendMail(HttpServletRequest request, String providerName, int providerID, String baseUrl) throws MessagingException;
    
    public boolean sendEmailReferral(String data, int providerID, String baseUrl) throws MessagingException;

    public String editPolicy(String data);

    public String createPolicy(String data);

    public String insertServingPeriodAndGetID(int providerID, String data);

    public String createChildrenDiscount(String data, int providerID);
    
    public String createChildrenDiscountForMainPackage(String data, int providerID);

    public String createDisabledDiscount(String data, int providerID);
    
    public String createDisabledDiscountForMainPackage(String data, int providerID);

    public boolean updateServingPeriodAndGetID(String data);

    public void updateBookingRegistrationFom(String data,int providerID);

    public String editChildrenDiscount(String data);

    public String editDisabledDiscount(String data);

    public String getResourceManagementData(int providerID);

    public String getPackageForChat(int providerID);

    public String insertNewResourceSkillAndGetNewResourceManagementData(String data, int providerID);

    public String insertNewProviderResourceAndGetNewResourceManagementData(String data, int providerID);

    public String assignNewTrippSourceToPackageAndGetNewResourceManagementData(String data, int providerID);

    public String editProviderResource(String data, int providerID);

    public String deleteProviderResource(String data, int providerID);

    public String editTrippSource(String data, int providerID);

    public String deleteTrippSource(String data, int providerID);

    public String deleteSkill(String data, int provideID);

    public String editSkill(String data, int provideID);
    
    public void updateBookingOfMainPackage(String data,int providerID);
    
    public boolean checkCreatingPackageExist(int providerID);
    
    public void clonePackage(int providerID,int packageID,String packageStatus, 
            boolean cloneAll,boolean cloneCategory,boolean cloneDescription,boolean clonePhoto,
            boolean cloneBooking,boolean clonePricing) throws IOException;

    public void stopPackage(String data, int providerID);
    
    public void startPackage(String data, int providerID);
    
    public void deletePackage(String data, int providerID);
    
    public void deleteTemporaryPackage(String data, int providerID);
    
    public boolean checkExistBooking(String data, int providerID);
    
    public boolean applyPackageEditing(int packageID,int providerID);
    
    public boolean insertEditingReason(String data);

    public int countNumberOfPackage (int providerID);

    public String getProviderTrippDash(int providerID);
    
    public String loadTopLeftBooking(String data);
    
    public String loadHighestPackage(String data);
    
    public String loadLowestPackage(String data);
    
    public String loadStatisticsInTripDash(String data);
}
