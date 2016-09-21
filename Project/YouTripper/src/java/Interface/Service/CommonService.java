/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Service;

import DTO.AccountSession;
import DTO.ActivityDTO;
import DTO.AdminSession;
import DTO.CategoryDTO;
import DTO.CountryDTO;
import DTO.ForgotPasswordDTO;
import DTO.PackageDTO;
import DTO.PackageDTOv2;
import DTO.PackagesViewDTO;
import DTO.ProviderDTO;
import DTO.ProviderSession;
import DTO.RemindReviewEmail;
import DTO.SubCategoryDTO;
import com.twilio.sdk.TwilioRestException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.Future;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nick
 */
public interface CommonService {

    public AccountSession loginToYouTripper(String username, String password);

    public AccountSession loginToYoutripperFacebook(String email);

    public boolean checkEmailIsExist(String data);
    
    public boolean checkEmailIsExistRegister(String data);

    public boolean checkBusinessNameIsExist(String data);
    
    public boolean checkUsernameURLIsExist(String data);
    
    public boolean checkSalesCode(String data);

    public boolean checkCaptcha(String captcha) throws UnsupportedEncodingException, IOException;

    public String commonSearchPackages(String searchText);

    public String liveSearch(String searchText);

    public String searchWithPageNumber(String data);

    public String getPackageByID(int packageID);

    public String getReviewsByTime(String jsonStr);

    public String getReviewsOfProviderByTime(String jsonStr);

    public String getReviewsOfTripperByTime(String jsonStr);

    public boolean sendActivationEmail(String title,String receiverName, String receiver, String token, String baseUrl) throws MessagingException;

    public boolean sendFollowEmail(String title, String receiver, String baseUrl) throws MessagingException;
    
    public void unSubscribe(int emailID);
    
    public String insertNewSignUpToken(String email, String referralToken) throws UnsupportedEncodingException;

    public boolean insertPassword(String password, int tripperID);
    
    public boolean insertEmail(String email, long time);

    public AccountSession validateTokenForProvider(String token);

    public boolean sendSMS(String receiver, String message) throws TwilioRestException;

    public List<CountryDTO> getAllCountry();

    public String getProviderSignupForm();

    public AccountSession insertTripper(String email, String password, String firstName, String lastName);

    public AccountSession insertProvider(int businessTypeID, String businessName, int countryID, String city, String address,
            String phoneCode, String phone, String firstName, String lastName, String displayName, String job, String email, String password, String referralCode, String openTime, String closeTime, String referralOfficialID);

    public List<ActivityDTO> getActivitesByCountry(String country);

    public List<PackageDTO> getAllPackageByLocationAndActivity(String location, int activityID);

    public String insertNewCookie(String username);

    public AccountSession checkCookie(String token);

    public void deleteCookie(String token);

    public int getSearchPageSize();

    public int getActivitiesPageSize();

    public String searchPackagesWithFilter(String data);

    public String getFilterOptions(String data);

    public String getComparisonList(String comparisonListData);

    public String getProviderPage(int providerID);
    
    public String getProviderID(String url);

    public String getReportType();

    public boolean reportProvider(int providerID, String report);

    public String getTripperPage(int tripperID) throws Exception;

    public boolean reportTripper(int tripperID, String report);

    public boolean insertNewForgotPasswordToken(String token, String email);

    public ForgotPasswordDTO checkForgotPasswordToken(String token);

    public boolean resetPassword(String token, String password);

    public boolean sendForgotPasswordEmail(String title, String receiver, String token, String baseUrl) throws MessagingException;

    public String getAllActivities();

    public String getAllActivitiesWithinLocation(String location);

    public String getActivitiesWithPageNumber(String dataJson);

    public String getAllSubCategoriesWithinLocation(String dataJson);

    public String getPackagesWithLocationAndActivity(int activityID, String country);

    public String getPackagesWithLocationAndActivity(String dataJson);

    public List<RemindReviewEmail> getBookingList();

    public boolean sendRemindReviewEmail(String title, String receiver, int PackageID, String baseUrl, String bookingID) throws MessagingException;

    public boolean checkReviewExist(int tripperID, String bookingID);

    public String getQuickInformationOfPackage(String datajSon);

    public String insertNewKeyword(String datajSon, HttpServletRequest request);

    public String getQuickInformationOfPackage(int packageID);

    public boolean sendPackageViaEmail(int packageID, String senderName, String email, String message, String baseURL, String baseURLNoContext) throws MessagingException;

    public boolean deleteEmail(String token);

    public AdminSession loginToAdmin(String username, String password);
//    public AccountSession updateImage(AccountSession account);

    public String getSimilarPackages(String data);

    public String getPackageForComparisonList(String data, String comparisonListData);

    public String removePackageFromComparisonList(String data, String comparisonListData);

    public String searchPackageBelongtoSub(String searchText, String location, int subID);

    public List<PackagesViewDTO> citySearch(HttpServletRequest request, HttpSession session);
    
    /**
     * for live search
     *
     * @param data
     * @return
     */
    public String smartSearchPakages(String data);

    /**
     * for live matrix search
     *
     * @param data
     * @return
     */
    public String matrixSearchPakages(String data);

    /**
     * get all categories
     *
     * @return list of all advanced categories
     */
    public List<CategoryDTO> getAllCategories();

    /**
     * get all sub categories
     *
     * @return list of sub categories
     */
    public List<SubCategoryDTO> getAllSubCategories();

    /**
     * get list of keyword
     *
     * @param data
     * @return list of keyword
     */
    public String getFilterOptionOnlyKeyword(String data);

    public void updateKeyWordByPackage(String data);

    public String getNoTripperOfSpecificDate(String data);

    public int getNoOfBookedPackages(String data);

    /**
     * get list of location
     *
     * @param data
     * @return list of location
     */
    public String getFilterOptionOnlyLocation(String data);

    /**
     * get list of package
     *
     * @param data
     * @return list of package
     */
    public String getFilterOptionOnlyPackage(String data);

    public void updateNearMeJson();

    /**
     * log new visitor
     *
     * @param affiliateCode
     * @param referrerURL
     * @param ip
     * @param device
     * @param visitTime
     * @param visitURL
     * @return boolean
     */
    public boolean logNewVisitor(int affiliateCode, String referrerURL, String ip, String device, String visitTime, String visitURL);

    /**
     * update guest with username if they existed
     *
     * @param username
     * @param role
     * @param time
     * @param ip
     * @return boolean
     */
    public boolean existingUserLogin(String username, String role, String time, String ip);

    public boolean insertNewLanguage();

    public String getQuickComparison(int packageID);

    public boolean sendMail(HttpServletRequest request) throws MessagingException;

    //Get newest trip
    public List<PackageDTOv2> getNewTrip();
    
    public List<PackageDTOv2> getNewTrip2();

    public String isAvailableForSpecificDate(String data);

    public String isAvailableForSpecificTime(String data);

    public String isJointBooked(String data);

    //Get user geolocation
    public String getGeolocation();

    public String getToDateUnderFormatMMddyyyy();
    
    public String getPreviewPackageEditing(int packageID);
    
    public String getToDateUnderFormatyyyyMMdd();
    
    public String getToDateInMillisecond();
    
    public List<PackageDTO> getRecommendedPackage();
    
    public List<PackageDTO> getPackageInBangkok();
   

}
