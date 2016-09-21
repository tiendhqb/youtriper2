/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.Service;

import DTO.ActivityDTO;
import DTO.AmenitiesDTO;
import DTO.CategoryDTO;
import DTO.DescriptionForm;
import DTO.ExtrasForm;
import DTO.PackageDTO;
import DTO.PackagesViewDTO;
import DTO.SubCategoryDTO;
import DTO.TemporaryPackageDTO;
import Interface.DAO.ActivityDAO;
import Interface.DAO.AmenitiesDAO;
import Interface.DAO.CategoryDAO;
import Interface.DAO.GroupTypeDAO;
import Interface.DAO.KeywordDAO;
import Interface.DAO.PackageDAO;
import Interface.Service.PackageService;
import Interface.DAO.SubCategoryDAO;
import Interface.DAO.TransporationDAO;
import Interface.DAO.TripTypeDAO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Nick
 */
public class PackageServiceImpl implements PackageService {

    @Autowired
    PackageDAO packageDAO;

    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    SubCategoryDAO subCategoryDAO;

    @Autowired
    ActivityDAO activityDAO;

    @Autowired
    AmenitiesDAO amenitiesDAO;

    @Autowired
    KeywordDAO keywordDAO;

    @Autowired
    TransporationDAO transporationDAO;

    @Autowired
    GroupTypeDAO groupTypeDAO;

    @Autowired
    TripTypeDAO tripTypeDAO;

    private final Gson gson;

    public PackageServiceImpl() {
        gson = new Gson();
    }

    @Override
    public List<CategoryDTO> getAllCategories() {

        return categoryDAO.getAllCategories();
    }

    @Override
    public List<SubCategoryDTO> getAllSubCategories() {
        return subCategoryDAO.getAllSubCategories();
    }

    @Override
    public List<ActivityDTO> getAllActivities() {
        return activityDAO.getAllActivities();
    }

    @Override
    public List<AmenitiesDTO> getAllAmenities() {
        return amenitiesDAO.getAllAmenities();
    }

    @Override
    public List<String> getKeywords(String data) {
        return keywordDAO.getKeywords(data);
    }

    @Override
    public TemporaryPackageDTO getTemporaryPackage(int providerID) {
        // get temporary package
        return packageDAO.getTemporaryPackageByID(providerID);
    }

    @Override
    public String getPackageForm() {
        return gson.toJson(packageDAO.getCreationForm(1));
    }

    @Override
    public boolean updateDescriptionFormOfTempPackage(String dataJson) {
        DescriptionForm form = gson.fromJson(dataJson, DescriptionForm.class);
        return true;
//        return packageDAO.updateDescriptionFormOfTemporaryPackage(form);
    }

    @Override
    public boolean updateExtrasOfTempPackage(String dataJson) {
        return true;
    }

    @Override
    public boolean updateCoverAndPhotoOfTempPackage(String dataJson) {
        JsonObject object = gson.fromJson(dataJson, JsonObject.class);
        String coverImage = object.get("coverImage").getAsString();
        String images = object.get("additionalImages").getAsString();
        int packageID = object.get("packageID").getAsInt();
//        return packageDAO.updateCoverAndPhotosOfTempPackage(packageID, coverImage, images);
        return true;
    }

    @Override
    public boolean updatePromotionOfTempPackage(String dataJson) {
        JsonObject object = gson.fromJson(dataJson, JsonObject.class);
        int packageID = object.get("packageID").getAsInt();
        String startDate = object.get("startDate").getAsString();
        String endDate = object.get("endDate").getAsString();
        String promotionJson = object.get("promotionJson").getAsString();
        String unavailableDays = object.get("unavailableDays").getAsString();
        int sequentialOperation = object.get("sequentialOperation").getAsInt();
        return packageDAO.updatePromotionOfTempPackage(packageID, startDate, endDate, promotionJson, unavailableDays,sequentialOperation);
    }

    @Override
    public String getTemporaryPackageForPreviewing(int temporaryPackageID) {
//        try {
//            PreviewTemporaryPackage temporaryPackage = packageDAO.getTemporaryPackageForPreview(temporaryPackageID);
//            return gson.toJson(temporaryPackage);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @Override
    public List<PackagesViewDTO> getBucketList(int tripperID) {
        return packageDAO.getBucketList(tripperID);
    }

    @Override
    public PackageDTO getPackageName(int packageID) {
        return packageDAO.getPackageName(packageID);
    }

    @Override
    public PackageDTO getPackageName(String bookingID) {
        return packageDAO.getPackageName(bookingID);
    }



}
