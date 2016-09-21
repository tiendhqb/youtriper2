/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Service;

import DTO.ActivityDTO;
import DTO.AmenitiesDTO;
import DTO.CategoryDTO;
import DTO.PackageDTO;
import DTO.PackagesViewDTO;
import DTO.SubCategoryDTO;
import DTO.TemporaryPackageDTO;
import java.util.List;

/**
 *
 * @author Nick
 */
public interface PackageService {

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
     * get all activities
     *
     * @return list of activities
     */
    public List<ActivityDTO> getAllActivities();

    /**
     * get all amenities
     *
     * @return list of amenities
     */
    public List<AmenitiesDTO> getAllAmenities();

    /**
     *
     * @param data get from user
     * @return keywords contains data
     */
    public List<String> getKeywords(String data);
    
    /**
     *
     * @param providerID receive ID of provider
     * @return 
     */
    public TemporaryPackageDTO getTemporaryPackage(int providerID);   
    
    public String getPackageForm();
    
    public boolean updateDescriptionFormOfTempPackage(String dataJson);
    
    public boolean updateExtrasOfTempPackage(String dataJson);
    
    public boolean updateCoverAndPhotoOfTempPackage(String dataJson);
    
//    public boolean updateLocationOfTemPackage(String dataJson);
    
//    public boolean updatePriceOfTemPackage(String dataJson);
    
    public boolean updatePromotionOfTempPackage(String dataJson);
    
    public String getTemporaryPackageForPreviewing(int temporaryPackageID);
    
    public List<PackagesViewDTO> getBucketList(int tripperID);
       
    public PackageDTO getPackageName(int packageID);
    
    public PackageDTO getPackageName(String bookingID);
            
}
