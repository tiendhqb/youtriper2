/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.CancellationDTO;
import DTO.CertificatesViewDTO;
import DTO.ChildrenDiscountDTO;
import DTO.DisabledDiscountDTO;
import DTO.FilterOption;
import DTO.LocationDTO;
import DTO.PackageDTO;
import DTO.PackageDTOv2;
import DTO.PackageForm;
import DTO.PackagesViewDTO;
import DTO.PopularPackageDTO;
import DTO.TemporaryPackageDTO;
import DTO.TemporaryPackageDTOv2;
import DTO.AdditionImageDTO;
import JavaClass.BookingDetailAllDate;
import JavaClass.DateBookingDetail;
import JavaClass.NearMeTable;
import JavaClass.QuickComparisonList;
import JavaClass.TemporaryPackageAndPackage;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface PackageDAO {

    public TemporaryPackageDTO getTemporaryPackageByID(int providerID);

    public PackageDTO getPackage(int packageId);

    public PackageForm getCreationForm(int providerID);

    public PackageForm getCreationFormForEdit(int providerID);

    public void updateDescriptionFormOfTemporaryPackage(int packageID, int languageID, String packageName, String googleDescription,
            String description, String advancedAddress, String keywords, String language, String searchDescription, String searchAdvancedAddress,
            String keywordStrs, int providerID);

    public void updateDescriptionFormOfPackage(int packageID, int languageID, String packageName, String googleDescription,
            String description, String advancedAddress, String keywords, String language, String searchDescription, String searchAdvancedAddress,
            String keywordStrs,int providerID);

    public void deleteOldDescriptionForm(int packageID, String country, String city, int providerID);

    public void deleteOldDescriptionFormPackage(int packageID, String country, String city,int providerID);

    public boolean updateExtrasFormOfTempPackage(int packageID, String included, String excluded, int certificateID);

    public boolean updateExtrasFormOfTempPackagev2(int packageID, String included, String excluded, int certificateID);

    public boolean editExtrasOfPackage(int packageID, String included, String excluded, String amenities, String ways);

    public boolean updateCoverAndPhotosOfTempPackage(int packageID, String coverImage, List<AdditionImageDTO> photos, double coverPosition,int providerID);

    public boolean updateCoverAndPhotosOfTempPackagev2(int packageID, String coverImage, List<AdditionImageDTO> photos, double coverPosition,int providerID);

    public boolean editCoverAndPhotosOfPackage(int packageID, String coverImage, String photos);

    public boolean updateLocationOfTemPackage(int packageID, String country, String city, String state, String coordinates, String packageAddress, String additionalAddress, BigDecimal Lat, BigDecimal Lng);

    public boolean updateLocationOfTemPackagev2(int packageID, String country, String city, String state, String coordinates, String packageAddress, String additionalAddress, BigDecimal Lat, BigDecimal Lng);

    public void editLocationOfPackage(int packageID, String country, String city, String state, String coordinates);

    public boolean updatePriceOfTemPackage(int packageID, double youtripperPrice,String priceCurrency,String cancellationPolicyJson,String childrenDiscountJson,
            int noCancellationPrice, int providerID,String freeCondition,String packageType,int minTripper,int maxTripper);

    public void editPriceOfPackage(int packageID, double childPrice, double adultPrice, boolean isPrivateTour, int minTripper, int maxTripper);

    public boolean updatePromotionOfTempPackage(int packageID, String startDate, String endDate, String promotionJson, String unDates, int sequentialOperation);

    public void editPromotionOfPackage(int packageID, String startDate, String endDate, String promotionJson, String unDates);

    public TemporaryPackageDTO getTemporaryPackageForPreview(int temporaryPackageID);

    public PackageDTO getTemporaryPackageForPreviewv2(int temporaryPackageID);

    public boolean applyTempPackageToPreview(int temporaryPackageID, int providerID);

    public boolean applyTempPackageToPreviewv2(int temporaryPackageID);

    public List<PackageDTO> getCreatedPackage();

    public List<PackageDTO> getCreatedPackagev2();

    public List<PackageDTO> getEditingPackages();

    public int approveTemporaryPackage(int temporaryPackage, String startDate) throws Exception;

    public boolean approveTemporaryPackagev2(int temporaryPackage) throws Exception;

    public boolean approveVersionPackage(int packageID, int temporaryPackage);

    public boolean editPackage(int packageID, int temporaryPackageID);

    public TemporaryPackageDTO editPackage(int temporaryPackage);

    public TemporaryPackageAndPackage getAllPackageOfProvider(int providerID);
    

    public CertificatesViewDTO getCertificateURL(int certificateID);

    public List<CertificatesViewDTO> getAllCertificateOfProvider(int providerID);

    public List<CertificatesViewDTO> getApprovedCertificateOfProvider(int providerID);

    public PackageDTO getPackageByID(int packageID);

    public PackageDTO getPackageForPayment(int packageID);

    public List<PackageDTO> getAllPackageByLocationAndActivity(String location, int activityID);

    public boolean updateAdditionalImage(int packageID, List<AdditionImageDTO> image);

    public boolean updateAdditionalImagePackage(int packageID, List<AdditionImageDTO> image);

    public boolean updateAdditionalImagev2(int packageID, List<AdditionImageDTO> image);

    public List<PackageDTO> getAllPackageForStatictis(int providerID);

    public List<PackagesViewDTO> getBucketList(int tripperID);

    public List<PackagesViewDTO> searchPackagesWithFilter(List<Integer> tripTypesID, List<Integer> groupTypesID, List<Integer> amenitiesIDs,
            int rate, double minPrice, double maxPrice,
            int pageSize, int pageNumber, String searchText);

    public FilterOption getFilterOptions(String searchText);

    public String getPackagesWithinActivity(int activityID, int pageNumber, int pageSize, List<PackagesViewDTO> packages);

    public String getPackagesWithinActivityAndCountry(int activityID, String country, int pageNumber, int pageSize, List<PackagesViewDTO> packages);

    public PackageDTO getQuickInformation(int activityID);

    public PackageDTO getPackageForShare(int packageID);

    public List<PackagesViewDTO> getSimiliarPackages(int packageID);

    public PackagesViewDTO getPackagesForAddingToComparison(int packageID);

    public List<PackageDTO> getPackagesForComparison(List<PackagesViewDTO> viewPackages);

    public List<BookingDetailAllDate> getBookingsForManagement(int packageID, int providerID);

    public List<PackageDTO> getPackagesBelongToProviderWithName(int providerID);

    public List<DateBookingDetail> getDateBookingDetail(int providerID, int packageID, String selectedDate);

    public String getKeywordsOfPackage(int packageID);

    public String getKeywordsOfPackagev2(int packageID);

    public String getKeywordsOfMainPackage(int packageID);

    public List<PackagesViewDTO> getSuggestionPackages(List<String> keywords);
    
    public List<PackagesViewDTO> citySearch(String searchText);

    public List<PackagesViewDTO> smarteSearchPakages(String searchText, String trips, String groups, String minDuration, String maxDuration, String durationType,
            String language, String servingType, String date, int noTripper,
            double minPrice, double maxPrice, int pageNumber, int rowsPage, int sortType, String city, double lat, double lng);

    public List<PackagesViewDTO> matrixSearchPakages(String searchText, String trips, String groups, String minDuration, String maxDuration, String durationType,
            String language, String servingType, String date, int noTripper,
            double minPrice, double maxPrice, int pageNumber, int rowsPage, String location, String subCate, int sortType);

    public QuickComparisonList getQuickComparison(int packageID);

    public PackageDTO getPackageName(int packageID);

    public PackageDTO getPackageName(String bookingID);

    public PackageDTO getPackageForEdit(int packageID);

    public void updateActivity(int packageID, String activities, int groupID, int tripID,int providerID);

    public List<String> getFilterOptionOnlyKeyword(String searchText, int numOfRecords);

    public boolean deletePackage(int packageID);

    public void insertActivityFormToTempPackage(int tempPackageID,int providerID);
    
    public void insertServingPeriodID(int providerID, int packageID);
    
    public void insertServingPeriodIDPendding(int providerID, int packageID);

    public void insertActivityFormToTempPackagev2(int tempPackageID, int groupID, int tripID);

    public int getNoOfBookedPackages(int packageID, String selectedDate);

    public List<LocationDTO> getFilterOptionOnlyLocation(String searchText, int numOfRecords);

    public List<PopularPackageDTO> getFilterOptionOnlyPackage(String searchText, int numOfRecords);

    public NearMeTable getNearMeData();

    public boolean checkImageExist(String name, int temporaryPackageID);

    public boolean deleteAdditionImage(String image, int temporaryPackageID);

    public boolean deleteAdditionImagePackage(String image, int temporaryPackageID);

    public boolean deleteAdditionImagev2(String image, int temporaryPackageID);

    public TemporaryPackageDTOv2 getTemporaryPackageByIDv2(int providerID);

    public boolean saveAvailability(int temporaryPackageID, int duration, String durationType, String startOperationTime, String endOperationTime, int resourceID, int minResource, boolean isFreeBooking, int fixedHour, int fixedMinute);

    public List<PackageDTOv2> loadNewTrip();

    public PackageDTO getDurationOfPackage(int packageID);

    public boolean approveSubCategory(int temporaryPackageID);

    public PackageDTO getPackageToCheckBooking(int packageID, String tripDate);

    public boolean saveAdditionalCategory(int temporaryPackageID, int packageColor, int targetCountryID, int adventureLevel, int challengeLevel,
            int friendshipLevel, int happinessLevel, int healthinessLevel, int knowledgeLevel, int peacefulnessLevel, int romanceLevel, int sophisticationLevel,
            int unexpectedLevel,int subCategoryID,String otherSubCategoryContent, int providerID);

    public boolean editAdditionalCategory(int packageID, int packageColor, int targetCountryID, int adventureLevel, int challengeLevel,
            int friendshipLevel, int happinessLevel, int healthinessLevel, int knowledgeLevel, int peacefulnessLevel, int romanceLevel, int sophisticationLevel,
            int unexpectedLevel,int providerID);

    public boolean editPolicy(int providerID, int cancellationID, String name, String condition);

    public CancellationDTO createPolicy(int providerID, String name, String condition);

    public ChildrenDiscountDTO createChildrenDiscount(int packageID, String condition, int percent, int providerID);
    
    public ChildrenDiscountDTO createChildrenDiscountForMainPackage(int packageID, String condition, int percent, int providerID);

    public DisabledDiscountDTO createDisabledDiscount(int packageID, String condition, int percent, int providerID);
    
    public DisabledDiscountDTO createDisabledDiscountForMainPackage(int packageID, String condition, int percent, int providerID);

    public boolean deleteOldDiscount(int packageID,int providerID);

    public boolean saveChildrenDiscount(int packageID, int childrenDiscountID,int providerID);

    public boolean saveDisabledDiscount(int packageID, int disabledDiscountID,int providerID);

    public void updateBookingFormOfTempPackage(int packageID, String packageType, Integer minTripper, Integer maxTripper,
            Integer resourceID, Integer minimumResources, Integer servingID, boolean isFreeBooking, int freeInterval,
            Integer fixedHour, Integer fixedMinute, String unavailableDays, int sequentialOperation, boolean isRunning, 
            int readyBookingDuration, String readyBookingDurationType, int durationDay, int durationMonth, int durationYear,
            int durationHour, int durationMinute, int restingDay, int restingHour, int restingMinute,
            int providerID, String startDate, boolean isUsingMaxQuota, int maxQuota, String quotaType, boolean isSpecificLaunchDate);

    public boolean editChildrenDiscount(int childrenDiscountID, String condition, int discountPercent);

    public boolean editDisabledDiscount(int disabledDiscountID, String condition, int discountPercent);

    public boolean processFreeDiscount(int temporaryPackageID, int childrenDiscountID, boolean selectFree, int ageValue, String ageType);

    public List<PackageDTO> getPackageForChat(int providerID);

    public boolean deleteOldDiscountForPackage(int packageID,int providerID);

    public boolean saveChildrenDiscountMainPackage(int packageID, int childrenDiscountID,int providerID);

    public boolean saveDisabledDiscountMainPackage(int packageID, int disabledDiscountID,int providerID);

    public boolean updatePriceOfMainPackage(int packageID, double adultPrice, double youtripperPrice, String priceCurrency,
            int youtripperPercentage, int noCancellationPercent, int providerID,String childrenDiscountJson,String cancellationPolicyJson);

    public void editBookingFormOfMainPackage(int packageID, String packageType, Integer minTripper, Integer maxTripper,
            Integer resourceID, Integer minimumResources, Integer servingID, boolean isFreeBooking, int freeInterval,
            Integer fixedHour, Integer fixedMinute, String unavailableDays, int sequentialOperation, boolean isRunning,
            int readyBookingDuration, String readyBookingDurationType, int durationDay, int durationMonth, int durationYear,
            int durationHour, int durationMinute,int restingDay, int restingHour, int restingMinute,int providerID,
            String startDate, boolean isUsingMaxQuota, int maxQuota, String quotaType);

    public int clonePackage(int providerID, int packageID,boolean cloneAll, 
            boolean cloneCategory, boolean cloneDescription, boolean clonePhoto,
            boolean cloneBooking, boolean clonePricing);
    
    public void updateTemporaryCoverImage(int packageID,String link);
    
    public void updateTemporaryAdditionalImage(int packageID,String newLink,String oldLink);
    
    public int clonePendingPackage(int providerID, int packageID,
            boolean cloneAll, 
            boolean cloneCategory, boolean cloneDescription, boolean clonePhoto,
            boolean cloneBooking, boolean clonePricing);
    
    public void stopPackage( int packageID, int providerID);
    
    public void startPackage( int packageID, int providerID);
    
    public void deletePackage( int packageID, String reason, int deleteID, int providerID);
    
    public void deleteTemporaryPackage( int packageID, int providerID);
    
    public boolean checkExistPackage( int packageID);
    
    public PackageDTO getPreviewPackageEditing(int packageID);
    
    public boolean applyPackageEditing(int packageID,int providerID);
    
    public boolean insertEditingReason(int packageID,String reason,int providerID);
    
    public boolean updateCoverAfterApprove(int packageID,String link);
    
    public boolean updateAdditionalAfterApprove(int packageID,String imageName,String link);
    
    public int countNumberOfPackage(int providerID);
    
    public List<PackageDTO> getRecommededPackage();
    
    public List<PackageDTO> getPackageInBangkok();
}
