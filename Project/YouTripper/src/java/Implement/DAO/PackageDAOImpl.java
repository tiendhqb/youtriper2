/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.ActivityDTO;
import DTO.AmenitiesDTO;
import DTO.CancellationDTO;
import DTO.CategoryDTO;
import DTO.CertificateDTO;
import DTO.CertificatesViewDTO;
import DTO.ChildrenDiscountDTO;
import DTO.DisabledDiscountDTO;
import DTO.FilterOption;
import DTO.GroupTypeDTO;
import DTO.LanguageDTO;
import DTO.LocationDTO;
import DTO.PackageColorDTO;
import DTO.PackageDTO;
import DTO.PackageDTOv2;
import DTO.PackageForm;
import DTO.PackagesViewDTO;
import DTO.PopularPackageDTO;
import DTO.ReviewDTO;
import DTO.ServingPeriodDTO;
import DTO.SubCategoryDTO;
import DTO.TargetCountryDTO;
import DTO.TemporaryAmenitiesClassifierDTO;
import DTO.TemporaryClassifierDTO;
import DTO.TemporaryOthersLanguageDescriptionDTO;
import DTO.TemporaryPackageCertificatesDTO;
import DTO.TemporaryPackageDTO;
import DTO.TemporaryPackageDTOv2;
import DTO.TemporarySuitabilityClassifierDTO;
import DTO.TemporaryTransoprtationWayDTO;
import DTO.TransportationDTO;
import DTO.TripTypeDTO;
import DTO.UsedResourcesViewDTO;
import Interface.DAO.PackageDAO;
import DTO.AdditionImageDTO;
import DTO.AmenitiesClassifierDTO;
import DTO.ClassifierDTO;
import DTO.DeleteReasonDTO;
import DTO.OperationCycleDTO;
import DTO.OthersLanguageDescriptionDTO;
import DTO.PackageCertificateDTO;
import DTO.SuitabilityClassifierDTO;
import DTO.SuitabilityDTO;
import DTO.TempCustomisedWeekSlotDTO;
import DTO.TempSpecificDateSlotsDTO;
import DTO.TempSpecificTimeSlotsDTO;
import JavaClass.AdvancedCategory;
import JavaClass.BookingDetailAllDate;
import JavaClass.CategoryRelation;
import JavaClass.DateBookingDetail;
import JavaClass.NearMeCategory;
import JavaClass.NearMeLocation;
import JavaClass.NearMeTable;
import JavaClass.QuickComparisonList;
import JavaClass.TemporaryPackageAndPackage;
import Mapper.ActivityMapper;
import Mapper.AdditionImageMapper;
import Mapper.AdditionalImageDTOMapperForPreview;
import Mapper.AmenitiesClassifierDTOMapper;
import Mapper.AmenitiesClassifierDTOMapperForDetail;
import Mapper.AmenitiesMapper;
import Mapper.BookingDetailAllDateMapper;
import Mapper.CancellationDTOMapper;
import Mapper.CertificatesViewMapper2;
import Mapper.CategoryMapper;
import Mapper.CategoryRelationMapper;
import Mapper.CertificateDTOMapper;
import Mapper.PackageCertificateDTOMapperForDetail;
import Mapper.CertificatesViewMapper;
import Mapper.ChildrenDiscountDTOMapper;
import Mapper.ChildrenDiscountDTOMapperForDetail;
import Mapper.ClassifierDTOMapper;
import Mapper.DateBookingDetailMapper;
import Mapper.DeleteReasonMapper;
import Mapper.DisabledDiscountDTOMapper;
import Mapper.DisabledDiscountDTOMapperForDetail;
import Mapper.GroupTypeMapper;
import Mapper.LanguageDTOMapper;
import Mapper.LocationDTOMapper;
import Mapper.NearMeCategoryMapper;
import Mapper.NearMeLocationMapper;
import Mapper.OperationCycleMapperForDetail;
import Mapper.OthersLanguageDescriptionDTOMapper;
import Mapper.OthersLanguageDescriptionDTOMapperFoDetail;
import Mapper.PackageCertificatesMapperForRegistration;
import Mapper.PackageColorDTOMapper;
import Mapper.PackageDTOForChatMapper;
import Mapper.PackageDTOMapper;
import Mapper.PackageDTOMapperForCheckTripperBooking;
import Mapper.PackageDTOMapperForComparison;
import Mapper.PackageDTOMapperForEdit;
import Mapper.PackageDTOMapperForPayment;
import Mapper.PackageDTOMapperForQuickComparison;
import Mapper.PackageDTOMapperForShare;
import Mapper.PackageDTOMapperForStatistics;
import Mapper.PackageDTOMapperWithDuration;
import Mapper.PackageDTOMapperForEditPackage;
import Mapper.PackageDTOMapperForHomePage;
import Mapper.PackageDTOMapperForPreviewEditing;
import Mapper.PackageDTOv2ForNewestMapper;
import Mapper.PackageMapper;
import Mapper.PackageMapperForList;
import Mapper.PackageMapperv2;
import Mapper.PackageViewsDTOMaperForAddingToComparison;
import Mapper.PackagesViewMapper;
import Mapper.PackagesViewMapperWithNewStatus;
import Mapper.PopularPackageMapper;
import Mapper.ReviewDTOMapper;
import Mapper.ServingPeriodDTOMapperForRegistration;
import Mapper.SubCategoryMapper;
import Mapper.SuitabilityClassifierDTOMapper;
import Mapper.SuitabilityDTOMapperForDetail;
import Mapper.TargetCountryDTOMapper;
import Mapper.TempCustomisedWeekSlotDTOMapper;
import Mapper.TempSpecificDateSlotsDTOMapper;
import Mapper.TempSpecificTimeSlotsMapper;
import Mapper.TemporaryAmenitiesClassifierDTOMapper;
import Mapper.TemporaryAmenitiesClassifierDTOMapperForPreview;
import Mapper.TemporaryClassifierDTOMapper;
import Mapper.TemporaryOthersLanguageDescriptionDTOMapper;
import Mapper.TemporaryOthersLanguageDescriptionDTOMapperForPreview;
import Mapper.TemporaryPackageCertificatesMapperForPreview;
import Mapper.TemporaryPackageCertificatesMapperForRegistration;
import Mapper.TemporaryPackageDTOMapperForPreview;
import Mapper.TemporaryPackageForStatus;
import Mapper.TemporarySuitabilityClassifierDTOMapper;
import Mapper.TemporarySuitabilityMapperForPreview;
import Mapper.TemporaryTransportationWayDTOMapper;
import Mapper.TransportationWayMapper;
import Mapper.TripTypeMapper;
import Mapper.UsedResourcesViewDTOMapperForCheckTripperBooking;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author Nick
 */
public class PackageDAOImpl implements PackageDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public PackageDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public TemporaryPackageDTO getTemporaryPackageByID(int providerID) {
        TemporaryPackageDTO packageDTO;
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getTemporaryPackageForCreate");
        simpleJdbcCall.returningResultSet("rs1", PackageMapper.getInstance())
                .returningResultSet("rs2", TemporaryAmenitiesClassifierDTOMapper.getInstance())
                .returningResultSet("rs3", TemporarySuitabilityClassifierDTOMapper.getInstance())
                .returningResultSet("rs4", AdditionImageMapper.getInstance())
                .returningResultSet("rs5", TemporaryOthersLanguageDescriptionDTOMapper.getInstance())
                .returningResultSet("rs6", TemporaryPackageCertificatesMapperForRegistration.getInstance())
                .returningResultSet("rs7", TempCustomisedWeekSlotDTOMapper.getInstance())
                .returningResultSet("rs8", TempSpecificDateSlotsDTOMapper.getInstance())
                .returningResultSet("rs9", TempSpecificTimeSlotsMapper.getInstance());

        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        packageDTO = ((List<TemporaryPackageDTO>) record.get("rs1")).get(0);

        List<TemporaryAmenitiesClassifierDTO> amenitiesClassifiers = (List<TemporaryAmenitiesClassifierDTO>) record.get("rs2");

        List<TemporarySuitabilityClassifierDTO> temporarySuitabilityClassifiers = (List<TemporarySuitabilityClassifierDTO>) record.get("rs3");
        List<AdditionImageDTO> additionImage = (List<AdditionImageDTO>) record.get("rs4");
        List<TemporaryOthersLanguageDescriptionDTO> languageDescriptionList = (List<TemporaryOthersLanguageDescriptionDTO>) record.get("rs5");
        List<TemporaryPackageCertificatesDTO> certificates = (List<TemporaryPackageCertificatesDTO>) record.get("rs6");
        List<TempCustomisedWeekSlotDTO> tempCustomisedWeekSlots = (List<TempCustomisedWeekSlotDTO>) record.get("rs7");
        List<TempSpecificDateSlotsDTO> tempSpecificDateSlotsDTO = (List<TempSpecificDateSlotsDTO>) record.get("rs8");
        List<TempSpecificTimeSlotsDTO> tempSpecificTimeSlotsDTO = (List<TempSpecificTimeSlotsDTO>) record.get("rs9");

        packageDTO.setAmenitiesClassifiers(amenitiesClassifiers);

        packageDTO.setTemporarySuitabiltyClassifiers(temporarySuitabilityClassifiers);
        packageDTO.setLanguageDescriptionList(languageDescriptionList);
        packageDTO.setCertificates(certificates);
        packageDTO.setTempCustomiseWeekSlots(tempCustomisedWeekSlots);
        packageDTO.setTempSpecificDateSlots(tempSpecificDateSlotsDTO);
        packageDTO.setTempSpecificTimeSlots(tempSpecificTimeSlotsDTO);

        Gson gson = new Gson();
        packageDTO.setImages(gson.toJson(additionImage));
        return packageDTO;
    }

    @Override
    public PackageDTO getPackage(int packageId) {
        PackageDTO packageDTO;
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getPackageFormForEdit");
        simpleJdbcCall.returningResultSet("rs1", PackageDTOMapperForEditPackage.getInstance()).returningResultSet("rs2", ClassifierDTOMapper.getInstance())
                .returningResultSet("rs3", AmenitiesClassifierDTOMapper.getInstance())
                .returningResultSet("rs4", SuitabilityClassifierDTOMapper.getInstance())
                .returningResultSet("rs5", AdditionImageMapper.getInstance())
                .returningResultSet("rs6", OthersLanguageDescriptionDTOMapper.getInstance())
                .returningResultSet("rs7", PackageCertificatesMapperForRegistration.getInstance());

        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageId);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        packageDTO = ((List<PackageDTO>) record.get("rs1")).get(0);
        List<ClassifierDTO> classifiers = (List<ClassifierDTO>) record.get("rs2");
        List<AmenitiesClassifierDTO> amenitiesClassifiers = (List<AmenitiesClassifierDTO>) record.get("rs3");
        List<SuitabilityClassifierDTO> suitabilityClassifiers = (List<SuitabilityClassifierDTO>) record.get("rs4");
        List<AdditionImageDTO> additionImage = (List<AdditionImageDTO>) record.get("rs5");
        List<OthersLanguageDescriptionDTO> languageDescriptionList = (List<OthersLanguageDescriptionDTO>) record.get("rs6");
        List<PackageCertificateDTO> certificates = (List<PackageCertificateDTO>) record.get("rs7");

        packageDTO.setAmenitiesClassifiers(amenitiesClassifiers);
        packageDTO.setClassifiers(classifiers);
        packageDTO.setSuitabilityClassifiers(suitabilityClassifiers);
        packageDTO.setLanguageDescriptionList(languageDescriptionList);
        packageDTO.setCertificates(certificates);
        Gson gson = new Gson();
        packageDTO.setImages(gson.toJson(additionImage));
        return packageDTO;
    }

    @Override
    public TemporaryPackageDTOv2 getTemporaryPackageByIDv2(int providerID) {
        TemporaryPackageDTOv2 packageDTO;
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getTemporaryPackageForCreatev2");
        simpleJdbcCall.returningResultSet("rs1", PackageMapperv2.getInstance()).returningResultSet("rs2", TemporaryClassifierDTOMapper.getInstance())
                .returningResultSet("rs3", TemporaryAmenitiesClassifierDTOMapper.getInstance())
                .returningResultSet("rs4", TemporaryTransportationWayDTOMapper.getInstance())
                .returningResultSet("rs5", TemporarySuitabilityClassifierDTOMapper.getInstance())
                .returningResultSet("rs6", AdditionImageMapper.getInstance())
                .returningResultSet("rs7", LanguageDTOMapper.getInstance())
                .returningResultSet("rs8", new RowMapper<Integer>() {
                    @Override
                    public Integer mapRow(ResultSet rs, int i) throws SQLException {
                        return rs.getInt("TotalPackage");
                    }
                });

        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        packageDTO = ((List<TemporaryPackageDTOv2>) record.get("rs1")).get(0);
        List<TemporaryClassifierDTO> temporaryClassifiers = (List<TemporaryClassifierDTO>) record.get("rs2");
        List<TemporaryAmenitiesClassifierDTO> amenitiesClassifiers = (List<TemporaryAmenitiesClassifierDTO>) record.get("rs3");
        List<TemporaryTransoprtationWayDTO> ways = (List<TemporaryTransoprtationWayDTO>) record.get("rs4");
        List<TemporarySuitabilityClassifierDTO> temporarySuitabilityClassifiers = (List<TemporarySuitabilityClassifierDTO>) record.get("rs5");
        List<AdditionImageDTO> additionImage = (List<AdditionImageDTO>) record.get("rs6");
        List<LanguageDTO> languageList = (List<LanguageDTO>) record.get("rs7");
        //Get package number to select color for package
        packageDTO.setPackageColor("rgb(204, 153, 255)");

        packageDTO.setTemporaryClassifiers(temporaryClassifiers);
        packageDTO.setAmenitiesClassifiers(amenitiesClassifiers);
        packageDTO.setTemporaryTransportations(ways);
        packageDTO.setTemporarySuitabiltyClassifiers(temporarySuitabilityClassifiers);
        packageDTO.setLanguageList(languageList);
        Gson gson = new Gson();
        packageDTO.setImages(gson.toJson(additionImage));
        return packageDTO;
    }

    @Override
    public void updateDescriptionFormOfTemporaryPackage(int packageID, int languageID, String packageName, String googleDescription,
            String description, String advancedAddress, String keywords, String language, String searchDescription, String searchAdvancedAddress,
            String keywordStrs, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("updateTemporaryPackageDescription");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("languageID", languageID)
                .addValue("packageName", packageName).addValue("googleDescription", googleDescription)
                .addValue("advancedAddress", advancedAddress).addValue("description", description)
                .addValue("keywords", keywords).addValue("language", language).addValue("descriptionStr", searchDescription)
                .addValue("advancedAddressStr", searchAdvancedAddress).addValue("keywordStrs", keywordStrs)
                .addValue("providerID", providerID);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void updateDescriptionFormOfPackage(int packageID, int languageID, String packageName, String googleDescription,
            String description, String advancedAddress, String keywords, String language, String searchDescription, String searchAdvancedAddress,
            String keywordStrs, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("updatePackageDescription");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("languageID", languageID)
                .addValue("packageName", packageName).addValue("googleDescription", googleDescription)
                .addValue("advancedAddress", advancedAddress).addValue("description", description)
                .addValue("keywords", keywords).addValue("language", language).addValue("descriptionStr", searchDescription)
                .addValue("advancedAddressStr", searchAdvancedAddress).addValue("keywordStrs", keywordStrs).addValue("providerID", providerID);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void deleteOldDescriptionForm(int packageID, String country, String city, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("deleteOldDescriptionFormOfTempPackage");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("country", country).addValue("city", city).addValue("providerID", providerID);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void deleteOldDescriptionFormPackage(int packageID, String country, String city, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("deleteOldDescriptionFormOfPackage");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("country", country).addValue("city", city).addValue("providerID", providerID);
        simpleJdbcCall.execute(in);
    }

    @Override
    public boolean updateExtrasFormOfTempPackage(int packageID, String included, String excluded, int certificateID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("updateExtrasFormOfTempPackage");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("included", included)
                .addValue("excluded", excluded).addValue("certificateID", certificateID);
        simpleJdbcCall.execute(in);
        return true;
    }

    @Override
    public boolean updateExtrasFormOfTempPackagev2(int packageID, String included, String excluded, int certificateID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("updateExtrasFormOfTempPackagev2");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("included", included)
                .addValue("excluded", excluded).addValue("certificateID", certificateID);
        simpleJdbcCall.execute(in);
        return true;
    }

    @Override
    public boolean editExtrasOfPackage(int packageID, String included, String excluded, String amenities, String ways) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("editExtras");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("include", included)
                .addValue("exclude", excluded).addValue("amenities", amenities).addValue("transportations", ways);
        simpleJdbcCall.execute(in);
        return true;
    }

    @Override
    public boolean updateCoverAndPhotosOfTempPackage(int packageID, String coverImage, List<AdditionImageDTO> photos, double coverPosition, int providerID) {
        String sql = "UPDATE TemporaryPackage "
                + "SET CoverImage = ?, CoverPosition = ? "
                + "WHERE TemporaryPackageID = ? AND ProviderID = ?";
        jdbcTemplate.update(sql, coverImage, coverPosition, packageID, providerID);
        sql = "UPDATE TemporaryImage "
                + "SET Link = ?,Caption = ? "
                + "WHERE TemporaryPackageID = ? and Link = ? ";
        for (int i = 0; i < photos.size(); i++) {
            jdbcTemplate.update(sql, photos.get(i).getImage(), photos.get(i).getCaption(), packageID, photos.get(i).getImage());
        }
        return true;
    }

    @Override
    public boolean updateCoverAndPhotosOfTempPackagev2(int packageID, String coverImage, List<AdditionImageDTO> photos, double coverPosition, int providerID) {
        String sql = "UPDATE Package "
                + "SET CoverImage = ?, CoverPosition = ? "
                + "WHERE PackageID = ? AND ProviderID = ?";
        jdbcTemplate.update(sql, coverImage, coverPosition, packageID, providerID);
        sql = "UPDATE PackageImage "
                + "SET Link = ?,Caption = ? "
                + "WHERE PackageID = ? and Link = ? ";
        for (int i = 0; i < photos.size(); i++) {
            jdbcTemplate.update(sql, photos.get(i).getImage(), photos.get(i).getCaption(), packageID, photos.get(i).getImage());
        }
        return true;
    }

    @Override
    public boolean editCoverAndPhotosOfPackage(int packageID, String coverImage, String photos) {
        String sql = "UPDATE Package "
                + "SET CoverImage = ?, Images = ? "
                + "WHERE PackageID = ?";
        jdbcTemplate.update(sql, coverImage, photos, packageID);
        return true;

    }

    @Override
    public boolean updateLocationOfTemPackage(int packageID, String country, String city, String state,
            String coordinates, String packageAddress, String additionalAddress, BigDecimal Lat, BigDecimal Lng) {
        String sql = "UPDATE TemporaryPackage "
                + "SET Country = ?, City = ?, Coordinates = ?, PackageAddress = ?, AdditionalAddress = ?, Lat = ?, Lng = ? "
                + "WHERE TemporaryPackageID = ?";
        jdbcTemplate.update(sql, country, city, coordinates, packageAddress, additionalAddress, Lat, Lng, packageID);
        return true;
    }

    @Override
    public boolean updateLocationOfTemPackagev2(int packageID, String country, String city, String state,
            String coordinates, String packageAddress, String additionalAddress, BigDecimal Lat, BigDecimal Lng) {
        String sql = "UPDATE TemporaryPackagev2 "
                + "SET Country = ?, City = ?, Coordinates = ?, PackageAddress = ?, AdditionalAddress = ?, Lat = ?, Lng = ? "
                + "WHERE TemporaryPackageID = ?";
        jdbcTemplate.update(sql, country, city, coordinates, packageAddress, additionalAddress, Lat, Lng, packageID);
        return true;
    }

    @Override
    public void editLocationOfPackage(int packageID, String country, String city, String state, String coordinates) {
        String sql = "UPDATE Package "
                + "SET Country = ?, City = ?, [State] = ?, Coordinates = ? "
                + "WHERE PackageID = ?";
        jdbcTemplate.update(sql, country, city, state, coordinates, packageID);
    }

    @Override
    public boolean updatePriceOfTemPackage(int packageID, double youtripperPrice, String priceCurrency, String cancellationPolicyJson,
            String childrenDiscountJson, int noCancellationPrice, int providerID,String freeCondition,String packageType,int minTripper,int maxTripper) {
        
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("saveTemporaryPackagePrice");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("youtripperPrice", youtripperPrice).addValue("priceCurrency", priceCurrency)
                .addValue("cancellationPolicyJson", cancellationPolicyJson)
                .addValue("chilrenDiscountJson", childrenDiscountJson).addValue("noCancellationPrice", noCancellationPrice).addValue("providerID", providerID)
                .addValue("freeCondition", freeCondition).addValue("packageType", packageType).addValue("minTripper", minTripper).addValue("maxTripper", maxTripper);
        simpleJdbcCall.execute(in);
        return true;

    }

    @Override
    public void editPriceOfPackage(int packageID, double childPrice, double adultPrice, boolean isPrivateTour, int minTripper, int maxTripper) {
        String sql = "UPDATE Package "
                + " SET OrdinaryPriceForAdult = ?, OrdinaryPriceForChild = ?, FilterPrice =  ROUND (? * (100 - YoutripperPercentage) / 100,2),"
                + " isPrivateTour = ?, MinTripper = ?, MaxTripper = ?"
                + " WHERE PackageID = ?";
        jdbcTemplate.update(sql, adultPrice, childPrice, adultPrice, isPrivateTour, minTripper, maxTripper, packageID);
    }

    @Override
    public boolean updatePromotionOfTempPackage(int packageID, String startDate, String endDate, String promotionJson, String unavailableDays, int sequentialOperation) {
        String sql = "UPDATE TemporaryPackage "
                + "SET StartDate = ?, EndDate = ?, PromotionJson = ?, unavailableDays = ?, SequentialOperation = ? "
                + "WHERE TemporaryPackageID = ?";
        jdbcTemplate.update(sql, startDate, endDate, promotionJson, unavailableDays, sequentialOperation, packageID);
        return true;
    }

    @Override
    public void editPromotionOfPackage(int packageID, String startDate, String endDate, String promotionJson, String unavailableDays) {
        String sql = "UPDATE Package "
                + "SET StartDate = ?, EndDate = ?, PromotionJson = ?, unavailableDays = ? "
                + "WHERE PackageID = ?";
        jdbcTemplate.update(sql, startDate, endDate, promotionJson, unavailableDays, packageID);
    }

    @Override
    public TemporaryPackageDTO getTemporaryPackageForPreview(int temporaryPackageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getTemporaryPackageToPreview")
                .returningResultSet("rs1", TemporaryPackageDTOMapperForPreview.getInstance())
                .returningResultSet("rs2", TemporaryAmenitiesClassifierDTOMapperForPreview.getInstance())
                .returningResultSet("rs3", TemporaryOthersLanguageDescriptionDTOMapperForPreview.getInstance())
                .returningResultSet("rs4", TemporaryPackageCertificatesMapperForPreview.getInstance())
                .returningResultSet("rs5", AdditionalImageDTOMapperForPreview.getInstance())
                .returningResultSet("rs6", TemporarySuitabilityMapperForPreview.getInstance());

        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", temporaryPackageID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        TemporaryPackageDTO packageDTO = ((List<TemporaryPackageDTO>) record.get("rs1")).get(0);
        List<TemporaryAmenitiesClassifierDTO> listAmenities = (List<TemporaryAmenitiesClassifierDTO>) record.get("rs2");
        List<TemporaryOthersLanguageDescriptionDTO> othersLanguage = (List<TemporaryOthersLanguageDescriptionDTO>) record.get("rs3");
        List<TemporaryPackageCertificatesDTO> certificates = (List<TemporaryPackageCertificatesDTO>) record.get("rs4");
        List<AdditionImageDTO> images = (List<AdditionImageDTO>) record.get("rs5");
        List<TemporarySuitabilityClassifierDTO> temporarySuitability = (List<TemporarySuitabilityClassifierDTO>) record.get("rs6");
        packageDTO.setAmenitiesClassifiers(listAmenities);
        packageDTO.setLanguageDescriptionList(othersLanguage);
        packageDTO.setCertificates(certificates);
        packageDTO.setAdditionImages(images);
        packageDTO.setSuitabilities(temporarySuitability);

        return packageDTO;
    }

    @Override
    public PackageDTO getTemporaryPackageForPreviewv2(int temporaryPackageID) {
//        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getTemporaryPackageToPreviewv2")
//                .returningResultSet("rs1", PackageDTOMapperv2.getInstance())
//                .returningResultSet("rs2", TransportationWayMapper.getInstance())
//                .returningResultSet("rs3", AmenitiesTypeMapperWithOnlyType.getInstance())
//                .returningResultSet("rs4", CategoryMapperWithNameAndIcon.getInstance())
//                .returningResultSet("rs5", ReviewDTOMapper.getInstance());
//
//        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", temporaryPackageID);
//        Map<String, Object> record = simpleJdbcCall.execute(in);
//        PackageDTO packageDTO = ((List<PackageDTO>) record.get("rs1")).get(0);
//        List<TransportationDTO> ways = (List<TransportationDTO>) record.get("rs2");
//        List<AmenitiesDTO> listAmenities = (List<AmenitiesDTO>) record.get("rs3");
//        List<CategoryDTO> categoris = (List<CategoryDTO>) record.get("rs4");
//        List<ReviewDTO> reviews = new ArrayList<ReviewDTO>();
//        packageDTO.setTransporations(ways);
//        packageDTO.setCategories(categoris);
//        packageDTO.setListAmenities(listAmenities);
//        packageDTO.setReviews(reviews);
        return null;
    }

    @Override
    public boolean applyTempPackageToPreview(int temporaryPackageID, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("applyPackageToPreview");
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID).addValue("temporaryPackageID", temporaryPackageID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        int noFinishedPackages = (int) record.get("noFinishedPackages");
        return noFinishedPackages > 1;
    }

    @Override
    public boolean applyTempPackageToPreviewv2(int temporaryPackageID) {
        String sql = "UPDATE TemporaryPackagev2 "
                + "SET isFinished = ? "
                + "WHERE TemporaryPackageID = ?";
        jdbcTemplate.update(sql, true, temporaryPackageID);
//        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("approveTemporaryPackage");
//        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", temporaryPackageID);
//        simpleJdbcCall.execute(in);
        return true;
    }

    @Override
    public PackageForm getCreationForm(int providerID) {
        PackageForm form;
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getPackageCreationForm");
        simpleJdbcCall.returningResultSet("rs1", ActivityMapper.getInstance()).returningResultSet("rs2", AmenitiesMapper.getInstance())
                .returningResultSet("rs3", CategoryMapper.getInstance()).returningResultSet("rs4", SubCategoryMapper.getInstance())
                .returningResultSet("rs5", CategoryRelationMapper.getInstance())
                .returningResultSet("rs6", CertificateDTOMapper.getInstance()).returningResultSet("rs7", TargetCountryDTOMapper.getInstance())
                .returningResultSet("rs8", LanguageDTOMapper.getInstance())
                .returningResultSet("rs9", PackageColorDTOMapper.getInstance())
                .returningResultSet("rs10", ServingPeriodDTOMapperForRegistration.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<ActivityDTO> activities = (List<ActivityDTO>) record.get("rs1");
        List<AmenitiesDTO> listAmenities = (List<AmenitiesDTO>) record.get("rs2");
        List<CategoryDTO> categories = (List<CategoryDTO>) record.get("rs3");
        List<SubCategoryDTO> subCategories = (List<SubCategoryDTO>) record.get("rs4");

        List<CategoryRelation> categoryRelations = (List<CategoryRelation>) record.get("rs5");
        List<CertificateDTO> certificates = (List<CertificateDTO>) record.get("rs6");
        List<TargetCountryDTO> targetCountry = (List<TargetCountryDTO>) record.get("rs7");
        List<LanguageDTO> languageList = (List<LanguageDTO>) record.get("rs8");
        List<PackageColorDTO> packageColor = (List<PackageColorDTO>) record.get("rs9");
        List<ServingPeriodDTO> servingPeriods = (List<ServingPeriodDTO>) record.get("rs10");
        // construct advanced category
        HashMap<Integer, AdvancedCategory> categoryRelation = new HashMap<>();
        HashMap<Integer, AdvancedCategory> sortedCategoryRelation = new HashMap<>();
        for (CategoryRelation category : categoryRelations) {
            Integer categoryID = category.getCategoryID();

            // new Activity
            int activityID = category.getActivityID();
            String activityName = category.getActivityName();
            int subCategoryID = category.getSubCategoryID();
            ActivityDTO activity = new ActivityDTO(activityID, activityName, subCategoryID);

            if (categoryRelation.containsKey(categoryID)) { // if same category
                // get old category
                AdvancedCategory advancedCategory = categoryRelation.get(categoryID);

                // get old map sub Categories
                HashMap<Integer, SubCategoryDTO> subCategoriesHashMap = advancedCategory.getSubCategories();

                SubCategoryDTO subCategory;
                if (subCategoriesHashMap.containsKey(subCategoryID)) { // if new record is same sub category
                    // get old subCAtegory
                    subCategory = subCategoriesHashMap.get(subCategoryID);

                    // add new Activty
                    subCategory.getActivites().add(activity);

                } else { // if new record is new sub category

                    // construct List Act
                    List<ActivityDTO> secondActivities = new ArrayList<>();
                    secondActivities.add(activity);

                    // new SubCategory
                    String subCategoryName = category.getSubCategoryName();
                    subCategory = new SubCategoryDTO(subCategoryID, subCategoryName, categoryID, secondActivities, false);

                    // add to old category
                    subCategoriesHashMap.put(subCategoryID, subCategory);
                }

            } else { // if category is not exist
                // then construct new Category
                AdvancedCategory advancedCategory = new AdvancedCategory();

                // construct List Act
                List<ActivityDTO> secondActivities = new ArrayList<>();
                secondActivities.add(activity);

                // new SubCategory
                String subCategoryName = category.getSubCategoryName();
                SubCategoryDTO subCategory = new SubCategoryDTO(subCategoryID, subCategoryName, categoryID, secondActivities, false);

                // construct new Category
                String categoryName = category.getCategoryName();
                String categoryICon = category.getCategoryIcon();
                HashMap<Integer, SubCategoryDTO> subCategoriesHashMap = new HashMap<>();
                subCategoriesHashMap.put(subCategoryID, subCategory);

                advancedCategory.setCategoryID(categoryID);
                advancedCategory.setCategoryName(categoryName);
                advancedCategory.setCategoryICon(categoryICon);
                advancedCategory.setSubCategories(subCategoriesHashMap);
                // add new category in hash map categories
                categoryRelation.put(categoryID, advancedCategory);
            }
        }
        //Sort Category List
        List<AdvancedCategory> categoryByName = new ArrayList<AdvancedCategory>(categoryRelation.values());

        Collections.sort(categoryByName, new Comparator<AdvancedCategory>() {

            public int compare(AdvancedCategory o1, AdvancedCategory o2) {
                return (o1.getCategoryName()).compareTo(o2.getCategoryName());
            }
        });
        int categoryID = 1;
        for (AdvancedCategory p : categoryByName) {
            sortedCategoryRelation.put(categoryID, p);
            categoryID = categoryID + 1;
        }
        //Sort SubCategory List
        for (int i : sortedCategoryRelation.keySet()) {
            List<SubCategoryDTO> subCategoryByName = new ArrayList<SubCategoryDTO>(sortedCategoryRelation.get(i).getSubCategories().values());
            Collections.sort(subCategoryByName, new Comparator<SubCategoryDTO>() {
                @Override
                public int compare(SubCategoryDTO o1, SubCategoryDTO o2) {
                    return o1.getName().compareTo(o2.getName());
                }

            });
            SubCategoryDTO temSubCategory = null;
            for (int j = 0; j < subCategoryByName.size(); j++) {
                if (subCategoryByName.get(j).getName().equals("Not Listed")) {
                    temSubCategory = subCategoryByName.get(j);
                    subCategoryByName.remove(j);
                }
            }
            subCategoryByName.add(temSubCategory);
            HashMap<Integer, SubCategoryDTO> sortedSubCategoriesHashMap = new HashMap<>();
            int subCategoryIDFlag = 1;
            for (SubCategoryDTO p : subCategoryByName) {
                //Sort Activity
//                System.out.println("p" + p.getActivites());
                if (p != null) {
                    Collections.sort(p.getActivites(), new Comparator<ActivityDTO>() {
                        @Override
                        public int compare(ActivityDTO o1, ActivityDTO o2) {
                            return o1.getName().compareTo(o2.getName());
                        }
                    });
                    //Move Not Listed to the end
                    ActivityDTO tempActiviy = null;
                    for (int k = 0; k < p.getActivites().size(); k++) {
                        if (p.getActivites().get(k).getName().equals("Not Listed")) {
                            tempActiviy = p.getActivites().get(k);
                            p.getActivites().remove(k);
                        }
                    }
                    p.getActivites().add(tempActiviy);
                    sortedSubCategoriesHashMap.put(subCategoryIDFlag, p);
                    subCategoryIDFlag = subCategoryIDFlag + 1;
                }

            }
            sortedCategoryRelation.get(i).setSubCategories(sortedSubCategoriesHashMap);
        }

        form = new PackageForm(categories, subCategories, activities, listAmenities, sortedCategoryRelation, certificates, languageList, targetCountry, packageColor);
        form.setServingPeriods(servingPeriods);
        return form;
    }

    @Override
    public PackageForm getCreationFormForEdit(int providerID) {
        PackageForm form;
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getPackageEditingForm");
        simpleJdbcCall.returningResultSet("rs1", ActivityMapper.getInstance()).returningResultSet("rs2", AmenitiesMapper.getInstance())
                .returningResultSet("rs3", CategoryMapper.getInstance()).returningResultSet("rs4", SubCategoryMapper.getInstance())
                .returningResultSet("rs5", CategoryRelationMapper.getInstance())
                .returningResultSet("rs6", CertificateDTOMapper.getInstance()).returningResultSet("rs7", TargetCountryDTOMapper.getInstance())
                .returningResultSet("rs8", LanguageDTOMapper.getInstance())
                .returningResultSet("rs9", PackageColorDTOMapper.getInstance())
                .returningResultSet("rs10", ServingPeriodDTOMapperForRegistration.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<ActivityDTO> activities = (List<ActivityDTO>) record.get("rs1");
        List<AmenitiesDTO> listAmenities = (List<AmenitiesDTO>) record.get("rs2");
        List<CategoryDTO> categories = (List<CategoryDTO>) record.get("rs3");
        List<SubCategoryDTO> subCategories = (List<SubCategoryDTO>) record.get("rs4");
        List<CategoryRelation> categoryRelations = (List<CategoryRelation>) record.get("rs5");
        List<CertificateDTO> certificates = (List<CertificateDTO>) record.get("rs6");
        List<TargetCountryDTO> targetCountry = (List<TargetCountryDTO>) record.get("rs7");
        List<LanguageDTO> languageList = (List<LanguageDTO>) record.get("rs8");
        List<PackageColorDTO> packageColor = (List<PackageColorDTO>) record.get("rs9");
        List<ServingPeriodDTO> servingPeriods = (List<ServingPeriodDTO>) record.get("rs10");
        // construct advanced category
        HashMap<Integer, AdvancedCategory> categoryRelation = new HashMap<>();
        HashMap<Integer, AdvancedCategory> sortedCategoryRelation = new HashMap<>();
        for (CategoryRelation category : categoryRelations) {
            Integer categoryID = category.getCategoryID();

            // new Activity
            int activityID = category.getActivityID();
            String activityName = category.getActivityName();
            int subCategoryID = category.getSubCategoryID();
            ActivityDTO activity = new ActivityDTO(activityID, activityName, subCategoryID);

            if (categoryRelation.containsKey(categoryID)) { // if same category
                // get old category
                AdvancedCategory advancedCategory = categoryRelation.get(categoryID);

                // get old map sub Categories
                HashMap<Integer, SubCategoryDTO> subCategoriesHashMap = advancedCategory.getSubCategories();

                SubCategoryDTO subCategory;
                if (subCategoriesHashMap.containsKey(subCategoryID)) { // if new record is same sub category
                    // get old subCAtegory
                    subCategory = subCategoriesHashMap.get(subCategoryID);

                    // add new Activty
                    subCategory.getActivites().add(activity);

                } else { // if new record is new sub category

                    // construct List Act
                    List<ActivityDTO> secondActivities = new ArrayList<>();
                    secondActivities.add(activity);

                    // new SubCategory
                    String subCategoryName = category.getSubCategoryName();
                    subCategory = new SubCategoryDTO(subCategoryID, subCategoryName, categoryID, secondActivities, false);

                    // add to old category
                    subCategoriesHashMap.put(subCategoryID, subCategory);
                }

            } else { // if category is not exist
                // then construct new Category
                AdvancedCategory advancedCategory = new AdvancedCategory();

                // construct List Act
                List<ActivityDTO> secondActivities = new ArrayList<>();
                secondActivities.add(activity);

                // new SubCategory
                String subCategoryName = category.getSubCategoryName();
                SubCategoryDTO subCategory = new SubCategoryDTO(subCategoryID, subCategoryName, categoryID, secondActivities, false);

                // construct new Category
                String categoryName = category.getCategoryName();
                String categoryICon = category.getCategoryIcon();
                HashMap<Integer, SubCategoryDTO> subCategoriesHashMap = new HashMap<>();
                subCategoriesHashMap.put(subCategoryID, subCategory);

                advancedCategory.setCategoryID(categoryID);
                advancedCategory.setCategoryName(categoryName);
                advancedCategory.setCategoryICon(categoryICon);
                advancedCategory.setSubCategories(subCategoriesHashMap);
                // add new category in hash map categories
                categoryRelation.put(categoryID, advancedCategory);
            }
        }
        //Sort Category List
        List<AdvancedCategory> categoryByName = new ArrayList<AdvancedCategory>(categoryRelation.values());

        Collections.sort(categoryByName, new Comparator<AdvancedCategory>() {

            public int compare(AdvancedCategory o1, AdvancedCategory o2) {
                return (o1.getCategoryName()).compareTo(o2.getCategoryName());
            }
        });
        int categoryID = 1;
        for (AdvancedCategory p : categoryByName) {
            sortedCategoryRelation.put(categoryID, p);
            categoryID = categoryID + 1;
        }
        //Sort SubCategory List
        for (int i : sortedCategoryRelation.keySet()) {
            List<SubCategoryDTO> subCategoryByName = new ArrayList<SubCategoryDTO>(sortedCategoryRelation.get(i).getSubCategories().values());
            Collections.sort(subCategoryByName, new Comparator<SubCategoryDTO>() {
                @Override
                public int compare(SubCategoryDTO o1, SubCategoryDTO o2) {
                    return o1.getName().compareTo(o2.getName());
                }

            });
            SubCategoryDTO temSubCategory = null;
            for (int j = 0; j < subCategoryByName.size(); j++) {
                if (subCategoryByName.get(j).getName().equals("Not Listed")) {
                    temSubCategory = subCategoryByName.get(j);
                    subCategoryByName.remove(j);
                }
            }
            subCategoryByName.add(temSubCategory);
            HashMap<Integer, SubCategoryDTO> sortedSubCategoriesHashMap = new HashMap<>();
            int subCategoryIDFlag = 1;
            for (SubCategoryDTO p : subCategoryByName) {
                //Sort Activity
                Collections.sort(p.getActivites(), new Comparator<ActivityDTO>() {
                    @Override
                    public int compare(ActivityDTO o1, ActivityDTO o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                //Move Not Listed to the end
                ActivityDTO tempActiviy = null;
                for (int k = 0; k < p.getActivites().size(); k++) {
                    if (p.getActivites().get(k).getName().equals("Not Listed")) {
                        tempActiviy = p.getActivites().get(k);
                        p.getActivites().remove(k);
                    }
                }
                p.getActivites().add(tempActiviy);
                sortedSubCategoriesHashMap.put(subCategoryIDFlag, p);
                subCategoryIDFlag = subCategoryIDFlag + 1;
            }
            sortedCategoryRelation.get(i).setSubCategories(sortedSubCategoriesHashMap);
        }

        form = new PackageForm(categories, subCategories, activities, listAmenities, sortedCategoryRelation, certificates, languageList, targetCountry, packageColor);

        form.setServingPeriods(servingPeriods);
        return form;
    }

    @Override
    public List<PackageDTO> getCreatedPackage() {
        String sql = "SELECT TemporaryPackageID  AS PackageID, Name, Provider.ProviderID, Provider.LastName, Provider.Image, CoverImage,"
                + " OrdinaryPriceForAdult, 0 AS Rate, 0 AS NumberRate "
                + "FROM TemporaryPackage, Provider "
                + "WHERE isFinished = ? AND TemporaryPackage.ProviderID = Provider.ProviderID "
                + "AND (isAdminEditing IS NULL OR isAdminEditing = ?)";
//                + "AND TemporaryPackage.TemporaryPackageID NOT IN "
//                + "( SELECT DISTINCT TemporaryPackageID FROM VersionPackage )";
        return jdbcTemplate.query(sql, PackageMapperForList.getInstance(), true, false);
    }

    @Override
    public List<PackageDTO> getCreatedPackagev2() {
        String sql = "SELECT TemporaryPackageID  AS PackageID, Name, Provider.ProviderID, Provider.LastName, Provider.Image, CoverImage,"
                + " OrdinaryPriceForAdult, 0 AS Rate, 0 AS NumberRate "
                + "FROM TemporaryPackagev2, Provider "
                + "WHERE isFinished = ? AND TemporaryPackagev2.ProviderID = Provider.ProviderID "
                + "AND (isAdminEditing IS NULL OR isAdminEditing = ?)";
//                + "AND TemporaryPackage.TemporaryPackageID NOT IN "
//                + "( SELECT DISTINCT TemporaryPackageID FROM VersionPackage )";
        return jdbcTemplate.query(sql, PackageMapperForList.getInstance(), true, false);
    }

    @Override
    public List<PackageDTO> getEditingPackages() {
        String sql = "SELECT TemporaryPackageID  AS PackageID, Name, Provider.ProviderID, Provider.LastName, Provider.Image, CoverImage,"
                + " OrdinaryPriceForAdult, 0 AS Rate, 0 AS NumberRate "
                + "FROM TemporaryPackage, Provider "
                + "WHERE isFinished = ? AND TemporaryPackage.ProviderID = Provider.ProviderID "
                + "AND (isAdminEditing = ?)";
//                + "AND TemporaryPackage.TemporaryPackageID NOT IN "
//                + "( SELECT DISTINCT TemporaryPackageID FROM VersionPackage )";
        return jdbcTemplate.query(sql, PackageMapperForList.getInstance(), true, true);
    }

    @Override
    public int approveTemporaryPackage(int temporaryPackage, String startDate) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("bonusProviderReferral");
        SqlParameterSource in2 = new MapSqlParameterSource().addValue("packageId", temporaryPackage).addValue("currentTime", String.valueOf(System.currentTimeMillis()));
        simpleJdbcCall.execute(in2);

        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("approveTemporaryPackage");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", temporaryPackage).addValue("startDate", startDate);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        int newPackageID = 0;
        if ((boolean) record.get("result")) {
            newPackageID = (int) record.get("newPackageID");
        }
        return newPackageID;
    }

    @Override
    public boolean approveTemporaryPackagev2(int temporaryPackage) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("approveTemporaryPackagev2");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", temporaryPackage);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return (boolean) record.get("result");
    }

    @Override
    public boolean approveVersionPackage(int packageID, int temporaryPackageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("approveVersionPackage");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("temporaryPackageID", temporaryPackageID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return (boolean) record.get("result");
    }

    @Override
    public boolean editPackage(int packageID, int temporaryPackageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("createNewVersionPackage");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("temporaryPackageID", temporaryPackageID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return (boolean) record.get("result");
    }

    @Override
    public TemporaryPackageDTO editPackage(int temporaryPackageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("createVersionPackage")
                .returningResultSet("rs1", PackageMapper.getInstance()).returningResultSet("rs2", ActivityMapper.getInstance())
                .returningResultSet("rs3", AmenitiesMapper.getInstance()).returningResultSet("rs4", TransportationWayMapper.getInstance())
                .returningResultSet("rs5", GroupTypeMapper.getInstance()).returningResultSet("rs6", TripTypeMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("temporaryPackageID", temporaryPackageID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        TemporaryPackageDTO packageDTO = ((List<TemporaryPackageDTO>) record.get("rs1")).get(0);
        List<ActivityDTO> activities = (List<ActivityDTO>) record.get("rs2");
        List<AmenitiesDTO> listAmenities = (List<AmenitiesDTO>) record.get("rs3");
        List<TransportationDTO> ways = (List<TransportationDTO>) record.get("rs4");
        List<GroupTypeDTO> groupTypes = (List<GroupTypeDTO>) record.get("rs5");
        List<TripTypeDTO> tripTypes = (List<TripTypeDTO>) record.get("rs6");
        packageDTO.setActivites(activities);
        packageDTO.setListAmenities(listAmenities);
        packageDTO.setTransporations(ways);
        return packageDTO;
    }

    @Override
    public TemporaryPackageAndPackage getAllPackageOfProvider(int providerID) {

        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getAllPackageByProviderForStatus")
                .returningResultSet("rs1", PackagesViewMapperWithNewStatus.getInstance())
                .returningResultSet("rs2", TemporaryPackageForStatus.getInstance())
                .returningResultSet("rs3", DeleteReasonMapper.getInstance());

        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<PackagesViewDTO> listPackage = (List<PackagesViewDTO>) record.get("rs1");

        List<TemporaryPackageDTO> listTemporaryPackage = (List<TemporaryPackageDTO>) record.get("rs2");
        List<DeleteReasonDTO> listDeleteReason = (List<DeleteReasonDTO>) record.get("rs3");
        TemporaryPackageAndPackage getAll = new TemporaryPackageAndPackage();
        getAll.setListPackage(listPackage);
        getAll.setListTemporaryPackage(listTemporaryPackage);
        getAll.setListDeleteReason(listDeleteReason);
        return getAll;
    }

    @Override
    public List<CertificatesViewDTO> getAllCertificateOfProvider(int providerID) {
        String sql = "SELECT Certificate.CertificateID, Name, Image, isApproved "
                + " FROM Certificate"
                + " WHERE ProviderID = ?";
        return jdbcTemplate.query(sql, CertificatesViewMapper.getInstance(), providerID);
    }

    @Override
    public List<CertificatesViewDTO> getApprovedCertificateOfProvider(int providerID) {
        String sql = "SELECT Certificate.CertificateID, Name, Image, isApproved "
                + " FROM Certificate"
                + " WHERE ProviderID = ? AND isApproved = ?";
        return jdbcTemplate.query(sql, CertificatesViewMapper.getInstance(), providerID, 1);
    }

    @Override
    public CertificatesViewDTO getCertificateURL(int certificateID) {
        String sql = "SELECT Image "
                + " FROM Certificate"
                + " WHERE CertificateID = ?";
        return ((List<CertificatesViewDTO>) jdbcTemplate.query(sql, CertificatesViewMapper2.getInstance(), certificateID)).get(0);
    }

    @Override
    public PackageDTO getPackageByID(int packageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getPackageByID")
                .returningResultSet("rs1", PackageDTOMapper.getInstance())
                .returningResultSet("rs2", AmenitiesClassifierDTOMapperForDetail.getInstance())
                .returningResultSet("rs3", OthersLanguageDescriptionDTOMapperFoDetail.getInstance())
                .returningResultSet("rs4", PackageCertificateDTOMapperForDetail.getInstance())
                .returningResultSet("rs5", AdditionalImageDTOMapperForPreview.getInstance())
                .returningResultSet("rs6", ReviewDTOMapper.getInstance())
                .returningResultSet("rs7", SuitabilityDTOMapperForDetail.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        PackageDTO packageDTO = ((List<PackageDTO>) record.get("rs1")).get(0);
        List<AmenitiesClassifierDTO> amenitiesClassifier = (List<AmenitiesClassifierDTO>) record.get("rs2");
        List<OthersLanguageDescriptionDTO> othersLanguageDescription = (List<OthersLanguageDescriptionDTO>) record.get("rs3");
        List<PackageCertificateDTO> certificates = (List<PackageCertificateDTO>) record.get("rs4");
        List<AdditionImageDTO> additionImages = (List<AdditionImageDTO>) record.get("rs5");
        List<ReviewDTO> reviews = (List<ReviewDTO>) record.get("rs6");
        List<SuitabilityDTO> suitabilities = (List<SuitabilityDTO>) record.get("rs7");
        packageDTO.setAmenitiesClassifiers(amenitiesClassifier);
        packageDTO.setReviews(reviews);
        packageDTO.setOthersLanguageDescription(othersLanguageDescription);
        packageDTO.setCertificates(certificates);
        packageDTO.setAdditionImages(additionImages);
        packageDTO.setSuitabilities(suitabilities);
        return packageDTO;
    }

    @Override
    public PackageDTO getPackageForPayment(int packageID) {
        PackageDTO packageDTO;
        String sql = "Select PackageID, Name, CoverImage, StartDate, EndDate, unavailableDays,"
                + " OrdinaryPriceForAdult, PromotionJson,"
                + " MinTripper, MaxTripper, Country, City, [State], ProviderID,YoutripperPercentage"
                + " FROM Package"
                + " WHERE PackageID = ?";
        packageDTO = jdbcTemplate.queryForObject(sql, PackageDTOMapperForPayment.getInstance(), packageID);
        return packageDTO;
    }

    @Override
    public boolean updateAdditionalImage(int packageID, List<AdditionImageDTO> images) {
        String sql = "INSERT INTO TemporaryImage "
                + "VALUES (?,?,?)";
        for (int i = 0; i < images.size(); i++) {
            jdbcTemplate.update(sql, images.get(i).getImage(), images.get(i).getCaption(), packageID);
        }

        return true;
    }

    @Override
    public boolean updateAdditionalImagePackage(int packageID, List<AdditionImageDTO> images) {
        String sql = "INSERT INTO PackageImage "
                + "VALUES (?,?,?)";
        for (int i = 0; i < images.size(); i++) {
            jdbcTemplate.update(sql, images.get(i).getImage(), images.get(i).getCaption(), packageID);
        }

        return true;
    }

    @Override
    public boolean updateAdditionalImagev2(int packageID, List<AdditionImageDTO> images) {
        String sql = "INSERT INTO TemporaryImagev2 "
                + "VALUES (?,?,?)";
        for (int i = 0; i < images.size(); i++) {
            jdbcTemplate.update(sql, images.get(i).getImage(), images.get(i).getCaption(), packageID);
        }

        return true;
    }

    @Override
    public List<PackageDTO> getAllPackageByLocationAndActivity(String location, int activityID) {
        return null;
    }

    @Override
    public List<PackageDTO> getAllPackageForStatictis(int providerID) {
        List<PackageDTO> result;
        String sql = "Select PackageID, Name,MaxTripper "
                + "FROM Package "
                + "Where Package.ProviderID = ?";
        result = jdbcTemplate.query(sql, PackageDTOMapperForStatistics.getInstance(), providerID);
        return result;
    }

    @Override
    public List<PackagesViewDTO> getBucketList(int tripperID) {
        List<PackagesViewDTO> result;
        String sql = "SELECT SmartSearchPackages.PackageID, Name, MainDescription, Keywords, "
                + " CoverImage, City, Rate, NumberRate,"
                + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 0 as TotalRecords"
                + " FROM SmartSearchPackages"
                + " INNER JOIN BucketList ON SmartSearchPackages.PackageID = BucketList.PackageID"
                + " WHERE BucketList.TripperID = ?";
        result = jdbcTemplate.query(sql, PackagesViewMapper.getInstance(), tripperID);
        return result;
    }

    @Override
    public List<PackagesViewDTO> searchPackagesWithFilter(List<Integer> tripTypesID, List<Integer> groupTypesID, List<Integer> amentiesIDs,
            int rate, double minPrice, double maxPrice,
            int pageSize, int pageNumber, String searchText) {
        List<PackagesViewDTO> result;
        String sql = "WITH Orders_cte AS ( "
                + "SELECT DISTINCT TOP 300 PackageID, Name, MainDescription, Keywords, CoverImage, "
                + "Location, Rate, NumberRate, OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage "
                + "FROM IndexPackages WITH (Index(IndexSearchPackages)) ";
        int numberOfParams = 9;
        if (rate <= 0) {
            numberOfParams--;
        }
        int sizeOfTrip = tripTypesID.size();
        int sizeOfGroup = groupTypesID.size();
        int sizeOfAmenities = amentiesIDs.size();
        numberOfParams += sizeOfTrip;
        numberOfParams += sizeOfGroup;
        numberOfParams += sizeOfAmenities;
        Object[] listParams = new Object[numberOfParams];
        int index = 0;
        searchText = "%" + searchText + "%";
        String whereStatement = "WHERE (Name LIKE ? OR Keywords LIKE ? OR Location Like ? )";
        for (; index < 3; index++) {
            listParams[index] = searchText;
        }
        if (sizeOfTrip > 0) {
            whereStatement += "AND TripTypeID IN (";
            for (int i = 0; i < sizeOfTrip; i++) {
                listParams[index] = tripTypesID.get(i);
                if (i < (sizeOfTrip - 1)) {
                    whereStatement += "?,";
                } else {
                    whereStatement += "?";
                }
                index++;
            }
            whereStatement += ") ";
        }

        if (sizeOfGroup > 0) {
            whereStatement += "AND GroupTypeID IN (";
            for (int i = 0; i < sizeOfGroup; i++) {
                listParams[index] = groupTypesID.get(i);
                if (i < (sizeOfGroup - 1)) {
                    whereStatement += "?,";
                } else {
                    whereStatement += "?";
                }
                index++;
            }
            whereStatement += ") ";
        }

        if (sizeOfAmenities > 0) {
            whereStatement += "AND AmenitiesID IN (";
            for (int i = 0; i < sizeOfAmenities; i++) {
                listParams[index] = amentiesIDs.get(i);
                if (i < (sizeOfAmenities - 1)) {
                    whereStatement += "?,";
                } else {
                    whereStatement += "?";
                }
                index++;
            }
            whereStatement += ") ";
        }

        if (rate > 0) {
            whereStatement += "AND ROUND(Rate,0) = ? ";
            listParams[index] = rate;
            index++;
        }
        whereStatement += "AND OrdinaryPriceForAdult >= ? ";
        listParams[index] = minPrice;
        index++;
        whereStatement += "AND OrdinaryPriceForAdult <= ? ";
        listParams[index] = maxPrice;
        index++;
        sql += whereStatement + ") SELECT * "
                + "FROM Orders_cte CROSS JOIN (SELECT Count(*) AS TotalRecords FROM Orders_cte) AS tCountOrders "
                + "ORDER BY PackageID "
                + "OFFSET ((? - 1) * ?) ROWS "
                + "FETCH NEXT ? ROWS ONLY";
        listParams[index] = pageNumber;
        index++;
        listParams[index] = pageSize;
        index++;
        listParams[index] = pageSize;
        index++;
        result = jdbcTemplate.query(sql, listParams, PackagesViewMapper.getInstance());
        return result;
    }

    @Override
    public FilterOption getFilterOptions(String searchText) {
        FilterOption options;
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getFilter")
                .returningResultSet("rs1", new RowMapper<String>() {

                    @Override
                    public String mapRow(ResultSet rs, int i) throws SQLException {
                        return rs.getString("Keyword");
                    }
                })
                .returningResultSet("rs2", PopularPackageMapper.getInstance())
                .returningResultSet("rs3", LocationDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("searchText", searchText);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<String> keywords = (List<String>) record.get("rs1");
        List<LocationDTO> locations = (List<LocationDTO>) record.get("rs3");
        List<PopularPackageDTO> popularPackages = (List<PopularPackageDTO>) record.get("rs2");
        options = new FilterOption(keywords, locations, popularPackages);
        return options;
    }

    @Override
    public String getPackagesWithinActivity(int activityID, int pageNumber, int pageSize, List<PackagesViewDTO> packages) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getPackagesWithinActivity")
                .returningResultSet("rs1", PackagesViewMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("activityID", activityID).addValue("PageNumber", pageNumber)
                .addValue("RowspPage", pageSize);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<PackagesViewDTO> packagesResult = (List<PackagesViewDTO>) record.get("rs1");
        for (PackagesViewDTO packageA : packagesResult) {
            packages.add(packageA);
        }
        return (String) record.get("activityName");
    }

    @Override
    public String getPackagesWithinActivityAndCountry(int activityID, String country, int pageNumber, int pageSize, List<PackagesViewDTO> packages) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getPackagesWithinLocationAndActivity")
                .returningResultSet("rs1", PackagesViewMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("activityID", activityID).addValue("country", country)
                .addValue("PageNumber", pageNumber).addValue("RowspPage", pageSize);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<PackagesViewDTO> packagesResult = (List<PackagesViewDTO>) record.get("rs1");
        for (PackagesViewDTO packageA : packagesResult) {
            packages.add(packageA);
        }
        return (String) record.get("activityName");
    }

    @Override
    public PackageDTO getQuickInformation(int packageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getQuickInformationOfPackage")
                .returningResultSet("rs1", PackageDTOMapper.getInstance())
                .returningResultSet("rs2", AmenitiesClassifierDTOMapperForDetail.getInstance())
                .returningResultSet("rs3", OthersLanguageDescriptionDTOMapperFoDetail.getInstance())
                .returningResultSet("rs4", OperationCycleMapperForDetail.getInstance())
                .returningResultSet("rs5", ChildrenDiscountDTOMapperForDetail.getInstance())
                .returningResultSet("rs6", DisabledDiscountDTOMapperForDetail.getInstance())
                .returningResultSet("rs7", SuitabilityDTOMapperForDetail.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        PackageDTO packageDTO = ((List<PackageDTO>) record.get("rs1")).get(0);
        List<AmenitiesClassifierDTO> amenitiesClassifier = (List<AmenitiesClassifierDTO>) record.get("rs2");
        List<OthersLanguageDescriptionDTO> othersLanguageDescription = (List<OthersLanguageDescriptionDTO>) record.get("rs3");

        List<OperationCycleDTO> operationCycles = (List<OperationCycleDTO>) record.get("rs3");
        List<ChildrenDiscountDTO> childrenDiscounts = (List<ChildrenDiscountDTO>) record.get("rs4");
        List<DisabledDiscountDTO> disabledDiscounts = (List<DisabledDiscountDTO>) record.get("rs5");
        List<SuitabilityDTO> suitabilities = (List<SuitabilityDTO>) record.get("rs6");

        packageDTO.setAmenitiesClassifiers(amenitiesClassifier);
        packageDTO.setOthersLanguageDescription(othersLanguageDescription);
        packageDTO.setOperationCycles(operationCycles);
        packageDTO.setChildrenDiscounts(childrenDiscounts);
        packageDTO.setDisabledDiscounts(disabledDiscounts);
        packageDTO.setSuitabilities(suitabilities);
        return packageDTO;
    }

    @Override
    public PackageDTO getPackageForShare(int packageID) {
        String sql = "Select Package.PackageID,OthersLanguageDescription.PackageName as Name,Package.CoverImage,Provider.ProviderID,Provider.LastName,Package.OrdinaryPriceForAdult,Package.NumberRate,Provider.Image"
                + "         FROM Package,Provider,OthersLanguageDescription"
                + "         Where Package.PackageID = ? and Package.ProviderID = Provider.ProviderID and Package.PackageID = OthersLanguageDescription.PackageID";
        List<PackageDTO> result = jdbcTemplate.query(sql, PackageDTOMapperForShare.getInstance(), packageID);
        return result.get(0);
    }

    @Override
    public List<PackagesViewDTO> getSimiliarPackages(int packageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getSimiliarPackages");
        simpleJdbcCall.returningResultSet("rs1", PackagesViewMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return (List<PackagesViewDTO>) record.get("rs1");
    }

    @Override
    public PackagesViewDTO getPackagesForAddingToComparison(int packageID) {
        String sql = "SELECT PackageID, Name, CoverImage"
                + "         FROM Package"
                + "         Where Package.PackageID = ?";
        List<PackagesViewDTO> result = jdbcTemplate.query(sql, PackageViewsDTOMaperForAddingToComparison.getInstance(), packageID);
        return result.get(0);
    }

    @Override
    public List<PackageDTO> getPackagesForComparison(List<PackagesViewDTO> viewPackages) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date myDate = new Date();
        Date thirtydaysBefore = new Date(myDate.getTime() - (30 * 24 * 60 * 60 * 1000));
        int numberOfParams = viewPackages.size();
        List<PackageDTO> result;
        if (numberOfParams > 0) {
            Object[] listParams = new Object[numberOfParams];
            String whereCondition = "(";
            for (int i = 0; i < numberOfParams; i++) {
                listParams[i] = viewPackages.get(i).getPackageID();
                whereCondition += "?";
                if (i != (numberOfParams - 1)) {
                    whereCondition += ",";
                }
            }
            whereCondition += ")";
            String sql = "SELECT Package.PackageID, Package.Name, Package.CoverImage, Package.OrdinaryPriceForAdult,  ISNULL(AVG(Professionlism), 5 ) AS Professionlism, "
                    + "ISNULL(AVG(StaffAttitude),5) AS StaffAttitude,  ISNULL(AVG(Convenient),5) AS Convenient, ISNULL(AVG(Satisfaction),5) AS Satisfaction,"
                    + " ISNULL(AVG(AmenityQuality),5) AS AmenityQuality, ISNULL(AVG(Cleanliness),5) AS Cleanliness"
                    + " FROM Package LEFT JOIN Review ON Package.PackageID = Review.PackageID"
                    + " WHERE Package.PackageID IN " + whereCondition
                    + " GROUP BY Package.PackageID, Name, CoverImage, OrdinaryPriceForAdult "
                    + "ORDER BY StaffAttitude DESC";
            result = jdbcTemplate.query(sql, listParams, PackageDTOMapperForComparison.getInstance());

        } else {
            result = new ArrayList<PackageDTO>();

        }

        return result;
    }

    @Override
    public List<BookingDetailAllDate> getBookingsForManagement(int packageID, int providerID) {
        String packageCondi = "";
        Object[] listParams;
        if (packageID > 0) {
            listParams = new Object[2];
            packageCondi = " AND Package.PackageID = ?";
            listParams[1] = packageID;
        } else {
            listParams = new Object[1];
        }
        listParams[0] = providerID;
        String sql = "SELECT COUNT(Code) AS NoBooking, SelectedDate, SUM(NumberOfAdults + NumberOfChilds) AS NoTripper"
                + " FROM Package LEFT JOIN Booking ON Package.PackageID = Booking.PackageID"
                + " WHERE Package.ProviderID = ?" + packageCondi
                + " GROUP BY SelectedDate";
        List<BookingDetailAllDate> result = jdbcTemplate.query(sql, listParams, BookingDetailAllDateMapper.getInstance());
        return result;
    }

    @Override
    public List<PackageDTO> getPackagesBelongToProviderWithName(int providerID) {
        String sql = "SELECT PackageID, Name"
                + " FROM Package"
                + " WHERE ProviderID = ?";
        List<PackageDTO> result = jdbcTemplate.query(sql, new RowMapper<PackageDTO>() {

            @Override
            public PackageDTO mapRow(ResultSet rs, int i) throws SQLException {
                return new PackageDTO(rs.getInt("PackageID"), rs.getString("Name"));
            }
        }, providerID);
        return result;
    }

    @Override
    public List<DateBookingDetail> getDateBookingDetail(int providerID, int packageID, String selectedDate) {
        String packageCondi = "";
        Object[] listParams;
        if (packageID > 0) {
            listParams = new Object[3];
            packageCondi = " AND Booking.PackageID = ?";
            listParams[2] = packageID;
        } else {
            listParams = new Object[2];
        }
        listParams[0] = selectedDate;
        listParams[1] = providerID;
        String sql = "SELECT Tripper.TripperID, Tripper.LastName, Tripper.FirstName, Tripper.[Image], "
                + "(Booking.NumberOfAdults + Booking.NumberOfChilds) AS NoTripper, BookingDate, Package.Name As PackageName, Package.PackageID As PackageID, Booking.Code"
                + " FROM Booking LEFT JOIN Tripper ON Booking.TripperID = Tripper.TripperID, Package"
                + " WHERE SelectedDate = ? AND Booking.ProviderID = ? AND Booking.PackageID = Package.PackageID" + packageCondi;
        List<DateBookingDetail> result = jdbcTemplate.query(sql, listParams, DateBookingDetailMapper.getInstance());
        return result;
    }

    @Override
    public String getKeywordsOfPackage(int packageID) {
        String sql = "SELECT Keywords"
                + " FROM TemporaryPackage"
                + " WHERE TemporaryPackageID = ?";
        List<String> result = jdbcTemplate.query(sql, new RowMapper<String>() {

            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                return rs.getString("Keywords");
            }
        }, packageID);
        return result.get(0);
    }

    @Override
    public String getKeywordsOfPackagev2(int packageID) {
        String sql = "SELECT Keywords"
                + " FROM TemporaryPackagev2"
                + " WHERE TemporaryPackageID = ?";
        List<String> result = jdbcTemplate.query(sql, new RowMapper<String>() {

            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                return rs.getString("Keywords");
            }
        }, packageID);
        return result.get(0);
    }

    @Override
    public String getKeywordsOfMainPackage(int packageID) {
        String sql = "SELECT Keywords"
                + " FROM Package"
                + " WHERE PackageID = ?";
        List<String> result = jdbcTemplate.query(sql, new RowMapper<String>() {

            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                return rs.getString("Keywords");
            }
        }, packageID);
        return result.get(0);
    }

    @Override
    public List<PackagesViewDTO> getSuggestionPackages(List<String> keywords) {

        int noParams = keywords.size();
        List<PackagesViewDTO> packages = new ArrayList<>();
        if (noParams > 0) {
            if (noParams > 3) {
                noParams = 3;
            }
            Object[] listParams = new Object[noParams];
            listParams[0] = "%" + keywords.get(0) + "%";
            String sql = "SELECT * FROM"
                    + " (SELECT DISTINCT TOP 1 PackageID, Name, MainDescription, Keywords,"
                    + " CoverImage, City, Rate, NumberRate, OrdinaryPriceForAdult,"
                    + " ProviderID, LastName, ProviderImage, 0 AS TotalRecords"
                    + " FROM SmartSearchPackages"
                    + " WHERE Keywords LIKE ?"
                    + " ORDER BY PackageID) Pk0";
            for (int i = 1; i < noParams; i++) {
                listParams[i] = "%" + keywords.get(i) + "%";
                sql += " UNION ALL "
                        + " SELECT * FROM"
                        + " (SELECT DISTINCT TOP 1 PackageID, Name, MainDescription, Keywords,"
                        + " CoverImage, City, Rate, NumberRate, OrdinaryPriceForAdult,"
                        + " ProviderID, LastName, ProviderImage, 0 AS TotalRecords"
                        + " FROM SmartSearchPackages"
                        + " WHERE Keywords LIKE ?"
                        + " ORDER BY PackageID) Pk" + i;
            }
            packages = jdbcTemplate.query(sql, listParams, PackagesViewMapper.getInstance());
        }
        return packages;
    }

    @Override
    public List<PackagesViewDTO> smarteSearchPakages(String searchText, String trips, String groups,
            String minDuration, String maxDuration, String durationType,
            String language, String servingType, String date, int noTripper,
            double minPrice, double maxPrice, int pageNumber, int rowsPage, int sortType, String city, double lat, double lng) {

        // Build dynamic sql
//        String tripCon = "";
//        String groupCon = "";
//        String serCon = "";
//        String languageCon = "";
//        String durationCon = "";
//
//        if (!trips.isEmpty()) {
//            String[] tripStrs = trips.split(",");
//            tripCon += " AND TripID IN (" + tripStrs[0];
//            for (int i = 1; i < tripStrs.length; i++) {
//                tripCon += "," + tripStrs[i];
//            }
//            tripCon += ")";
//        }
//
//        if (!groups.isEmpty()) {
//            String[] groupStrs = groups.split(",");
//            groupCon += " AND GroupID IN (" + groupStrs[0];
//            for (int i = 1; i < groupStrs.length; i++) {
//                groupCon += "," + groupStrs[i];
//            }
//            groupCon += ")";
//        }
//
//        if (!servingType.isEmpty()) {
//            String[] servingStrs = servingType.split(",");
//            serCon += " AND isPrivateTour IN (" + servingStrs[0];
//            for (int i = 1; i < servingStrs.length; i++) {
//                serCon += "," + servingStrs[i];
//            }
//            serCon += ")";
//        }
//
//        if (!language.isEmpty()) {
//            languageCon += " AND Language LIKE '%" + language + "%'";
//        }
//
//        if (!minDuration.isEmpty()) {
//            String[] minDurationStrs = minDuration.split(",");
//            String[] maxDurationStrs = maxDuration.split(",");
//            String[] durationTypeStrs = durationType.split(",");
//            durationCon += " AND ((DurationType = " + durationTypeStrs[0] + " AND "
//                    + "Duration >= " + minDurationStrs[0];
//            if (!maxDurationStrs[0].equals("0")) {
//                durationCon += " AND Duration <= " + maxDurationStrs[0];
//            }
//            durationCon += ")";
//            for (int i = 1; i < minDurationStrs.length; i++) {
//                durationCon += " OR (DurationType = " + durationTypeStrs[i] + " AND "
//                        + "Duration >= " + minDurationStrs[i];
//                if (!maxDurationStrs[0].isEmpty()) {
//                    durationCon += " AND Duration <= " + maxDurationStrs[i];
//                }
//                durationCon += ")";
//            }
//            durationCon += ")";
//        }
//
//        int top = rowsPage * pageNumber;
//
//        String bookingSql = "";
//        if (!date.isEmpty()) {
//            bookingSql = " WHERE TempTable.PackageID NOT IN ("
//                    + " SELECT PackageID"
//                    + " FROM AdvancedPrivateBooking"
//                    + " WHERE SelectedDate LIKE '%" + date + "%'"
//                    + " AND (MaxTripper <= NoPackages OR MinTripper < @noTrippersVar)"
//                    + " UNION "
//                    + " SELECT PackageID"
//                    + " FROM AdvancedOpenBooking"
//                    + " WHERE SelectedDate LIKE '%" + date + "%'"
//                    + " AND (MaxTripper < @noTrippersVar OR MaxTripper < (NoPackages + @noTrippersVar)))";
//        }
//
//        String dynamicSql;
//        if (sortType == 1) {// Sort by Top Selling
//            dynamicSql = "SELECT TOP " + top + " TempTable.PackageID AS PackageID, Name, MainDescription, Keywords, CoverImage,"
//                    + "  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 0 AS TotalRecords"
//                    + " FROM ("
//                    + " SELECT TOP 2147483647 PackageID, Name, MainDescription, Keywords, CoverImage,  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage"
//                    + " FROM SellingPackages INNER JOIN @xmlSearchVar.nodes('/ROOT/S') T(C)"
//                    + " ON ActivityName  LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " OR SubCategoryName  LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " OR CategoryName  LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " OR Name  LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " OR Country LIKE '%' + T.C.value('.','VARCHAR(20)') + '%' OR City LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " OR Keywords LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " OR MainDescription LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " ORDER BY NoOfSellingPackages DESC ) TempTable"
//                    + " INNER JOIN ("
//                    + " SELECT PackageID"
//                    + " FROM FilterPackages"
//                    + " WHERE FilterPrice >= @minVar AND FilterPrice <= @maxVar"
//                    + " AND NoTripper >= @noTrippersVar"
//                    + tripCon
//                    + groupCon
//                    + serCon
//                    + languageCon
//                    + durationCon
//                    + ") SeTable"
//                    + " ON TempTable.PackageID = SeTable.PackageID"
//                    + bookingSql;
//        } else if (sortType == 2) { // Sort by Rate
//            dynamicSql = "SELECT TOP " + top + " TempTable.PackageID AS PackageID, Name, MainDescription, Keywords, CoverImage,"
//                    + "  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 0 AS TotalRecords"
//                    + " FROM ("
//                    + " SELECT TOP 2147483647 PackageID, Name, MainDescription, Keywords, CoverImage,  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage"
//                    + " FROM RatePackages INNER JOIN @xmlSearchVar.nodes('/ROOT/S') T(C)"
//                    + " ON ActivityName  LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " OR SubCategoryName  LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " OR CategoryName  LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " OR Name  LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " OR Country LIKE '%' + T.C.value('.','VARCHAR(20)') + '%' OR City LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " OR Keywords LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " OR MainDescription LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " ORDER BY Rate DESC ) TempTable"
//                    + " INNER JOIN ("
//                    + " SELECT PackageID"
//                    + " FROM FilterPackages"
//                    + " WHERE FilterPrice >= @minVar AND FilterPrice <= @maxVar"
//                    + " AND NoTripper >= @noTrippersVar"
//                    + tripCon
//                    + groupCon
//                    + serCon
//                    + languageCon
//                    + durationCon
//                    + ") SeTable"
//                    + " ON TempTable.PackageID = SeTable.PackageID"
//                    + bookingSql;
//        } else { // Sort by best match
//            dynamicSql = "WITH Orders_cte AS(SELECT TOP 2147483647 TempTable.PackageID AS PackageID, Name, MainDescription, Keywords, CoverImage,"
//                    + "  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, "
//                    + " COUNT(TempTable.PackageID) AS NoNumber, Min(TempTable.[Priority]) AS Pri FROM ("
//                    + " SELECT PackageID, Name, MainDescription, Keywords, CoverImage,  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 1 AS [Priority]"
//                    + " FROM SmartSearchPackages INNER JOIN @xmlSearchVar.nodes('/ROOT/S') T(C)"
//                    + " ON ActivityName  LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " UNION ALL "
//                    + " SELECT PackageID, Name, MainDescription, Keywords, CoverImage,  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 1 AS [Priority]"
//                    + " FROM SmartSearchPackages INNER JOIN @xmlSearchVar.nodes('/ROOT/S') T(C)"
//                    + " ON SubCategoryName  LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " UNION ALL "
//                    + " SELECT PackageID, Name, MainDescription, Keywords, CoverImage,  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 1 AS [Priority]"
//                    + " FROM SmartSearchPackages INNER JOIN @xmlSearchVar.nodes('/ROOT/S') T(C)"
//                    + " ON CategoryName  LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " UNION ALL"
//                    + " SELECT PackageID, Name, MainDescription, Keywords, CoverImage, City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 2 AS [Priority]"
//                    + " FROM SmartSearchPackages INNER JOIN @xmlSearchVar.nodes('/ROOT/S') T(C)"
//                    + " ON Name  LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " UNION ALL"
//                    + " SELECT PackageID, Name, MainDescription, Keywords, CoverImage,  City,Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 3 AS [Priority]"
//                    + " FROM SmartSearchPackages INNER JOIN @xmlSearchVar.nodes('/ROOT/S') T(C)"
//                    + " ON Country LIKE '%' + T.C.value('.','VARCHAR(20)') + '%' OR City LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " UNION ALL"
//                    + " SELECT PackageID, Name, MainDescription, Keywords, CoverImage,  City,Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 4 AS [Priority]"
//                    + " FROM SmartSearchPackages INNER JOIN @xmlSearchVar.nodes('/ROOT/S') T(C)"
//                    + " ON Keywords LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " UNION ALL"
//                    + " SELECT PackageID, Name, MainDescription, Keywords, CoverImage,  City,Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 5 AS [Priority]"
//                    + " FROM SmartSearchPackages INNER JOIN @xmlSearchVar.nodes('/ROOT/S') T(C)"
//                    + " ON MainDescription LIKE '%' + T.C.value('.','VARCHAR(20)') + '%') TempTable"
//                    + " INNER JOIN ("
//                    + " SELECT PackageID"
//                    + " FROM FilterPackages"
//                    + " WHERE FilterPrice >= @minVar AND FilterPrice <= @maxVar "
//                    + " AND NoTripper >= @noTrippersVar"
//                    + tripCon
//                    + groupCon
//                    + serCon
//                    + languageCon
//                    + durationCon
//                    + ") SeTable"
//                    + " ON TempTable.PackageID = SeTable.PackageID"
//                    + bookingSql
//                    + " GROUP BY TempTable.PackageID, Name, MainDescription, Keywords, CoverImage,  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage"
//                    + " ORDER BY NoNumber DESC,"
//                    + " Pri ASC"
//                    + " )"
//                    + " SELECT TOP " + top + "PackageID, Name, MainDescription, Keywords, CoverImage,  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 0 AS TotalRecords"
//                    + " FROM Orders_cte";
//        }
////        System.out.println(dynamicSql);
//
//        // Build Param Condition For Procedure
//        String paramCondition = "@xmlSearchVar XML, @minVar INT, @maxVar INT, @noTrippersVar INT";
//        // Exec Procedure
//        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("smartSearch");
//        simpleJdbcCall.returningResultSet("rs1", PackagesViewMapper.getInstance());
//        SqlParameterSource in = new MapSqlParameterSource().addValue("searchText", searchText)
//                .addValue("minPrice", minPrice).addValue("maxPrice", maxPrice).addValue("noTripper", noTripper)
//                .addValue("SearchStatement", dynamicSql).addValue("ParmDefinition", paramCondition);
        // new procedure
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("newSmartSearch");
        simpleJdbcCall.returningResultSet("rs1", PackagesViewMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("searchText", searchText);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<PackagesViewDTO> packages = (List<PackagesViewDTO>) record.get("rs1");
        return packages;
    }
    
    
    @Override
    public List<PackagesViewDTO> citySearch(String searchText) {

        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("SearchPackagesByLocation");
        simpleJdbcCall.returningResultSet("rs1", PackagesViewMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("city", searchText);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<PackagesViewDTO> packages = (List<PackagesViewDTO>) record.get("rs1");
        
        return packages;
    }

    @Override
    public List<PackagesViewDTO> matrixSearchPakages(String searchText, String trips, String groups, String minDuration, String maxDuration, String durationType,
            String language, String servingType, String date, int noTripper,
            double minPrice, double maxPrice, int pageNumber, int rowsPage, String location, String subCate, int sortType) {

        // Old Search
//        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("searchPackages");
//        simpleJdbcCall.returningResultSet("rs1", PackagesViewMapper.getInstance());
//        SqlParameterSource in = new MapSqlParameterSource().addValue("searchText", searchText).addValue("PageNumber", pageNumber)
//                .addValue("RowspPage", rowsPage).addValue("tripTypes", trips).addValue("groupTypes", groups).addValue("amenities", amenities)
//                .addValue("minPrice", minPrice).addValue("maxPrice", maxPrice).addValue("rate", rate);
//        Map<String, Object> record = simpleJdbcCall.execute(in);
//        List<PackagesViewDTO> packages = (List<PackagesViewDTO>) record.get("rs1");
        // New Search
        // Build dynamic sql
//        String tripCon = "";
//        String groupCon = "";
//        String serCon = "";
//        String languageCon = "";
//        String durationCon = "";
//
//        if (!trips.isEmpty()) {
//            String[] tripStrs = trips.split(",");
//            tripCon += " AND TripID IN (" + tripStrs[0];
//            for (int i = 1; i < tripStrs.length; i++) {
//                tripCon += "," + tripStrs[i];
//            }
//            tripCon += ")";
//        }
//
//        if (!groups.isEmpty()) {
//            String[] groupStrs = groups.split(",");
//            groupCon += " AND GroupID IN (" + groupStrs[0];
//            for (int i = 1; i < groupStrs.length; i++) {
//                groupCon += "," + groupStrs[i];
//            }
//            groupCon += ")";
//        }
//
//        if (!servingType.isEmpty()) {
//            String[] servingStrs = servingType.split(",");
//            serCon += " AND isPrivateTour IN (" + servingStrs[0];
//            for (int i = 1; i < servingStrs.length; i++) {
//                serCon += "," + servingStrs[i];
//            }
//            serCon += ")";
//        }
//
//        if (!language.isEmpty()) {
//            languageCon += " AND Language LIKE '%" + language + "%'";
//        }
//
//        if (!minDuration.isEmpty()) {
//            String[] minDurationStrs = minDuration.split(",");
//            String[] maxDurationStrs = maxDuration.split(",");
//            String[] durationTypeStrs = durationType.split(",");
//            durationCon += " AND ((DurationType = " + durationTypeStrs[0] + " AND "
//                    + "Duration >= " + minDurationStrs[0];
//            if (!maxDurationStrs[0].equals("0")) {
//                durationCon += " AND Duration <= " + maxDurationStrs[0];
//            }
//            durationCon += ")";
//            for (int i = 1; i < minDurationStrs.length; i++) {
//                durationCon += " OR (DurationType = " + durationTypeStrs[i] + " AND "
//                        + "Duration >= " + minDurationStrs[i];
//                if (!maxDurationStrs[0].isEmpty()) {
//                    durationCon += " AND Duration <= " + maxDurationStrs[i];
//                }
//                durationCon += ")";
//            }
//            durationCon += ")";
//        }
//
//        int top = rowsPage * pageNumber;
//
//        String bookingSql = "";
//        if (!date.isEmpty()) {
//            bookingSql = " WHERE TempTable.PackageID NOT IN ("
//                    + " SELECT PackageID"
//                    + " FROM AdvancedPrivateBooking"
//                    + " WHERE SelectedDate LIKE '%" + date + "%'"
//                    + " AND (MaxTripper <= NoPackages OR MinTripper < @noTrippersVar)"
//                    + " UNION "
//                    + " SELECT PackageID"
//                    + " FROM AdvancedOpenBooking"
//                    + " WHERE SelectedDate LIKE '%" + date + "%'"
//                    + " AND (MaxTripper < @noTrippersVar OR MaxTripper < (NoPackages + @noTrippersVar)))";
//        }
//
//        String dynamicSql;
//        if (sortType == 1) {// Sort by Top Selling
//            dynamicSql = "SELECT TOP " + top + " TempTable.PackageID AS PackageID, Name, MainDescription, Keywords, CoverImage,"
//                    + "  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 0 AS TotalRecords"
//                    + " FROM ("
//                    + " SELECT TOP 2147483647 PackageID, Name, MainDescription, Keywords, CoverImage,  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage"
//                    + " FROM SellingPackages INNER JOIN @xmlSearchVar.nodes('/ROOT/S') T(C)"
//                    + " ON Name  LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " OR Keywords LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " OR MainDescription LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " WHERE SubCategoryName  LIKE '%" + subCate + "%'"
//                    + " AND Country LIKE '%" + location + "%' OR City LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " ORDER BY NoOfSellingPackages DESC ) TempTable"
//                    + " INNER JOIN ("
//                    + " SELECT PackageID"
//                    + " FROM FilterPackages"
//                    + " WHERE FilterPrice >= @minVar AND FilterPrice <= @maxVar"
//                    + " AND NoTripper >= @noTrippersVar"
//                    + tripCon
//                    + groupCon
//                    + serCon
//                    + languageCon
//                    + durationCon
//                    + ") SeTable"
//                    + " ON TempTable.PackageID = SeTable.PackageID"
//                    + bookingSql;
//        } else if (sortType == 2) { // Sort by Rate
//            dynamicSql = "SELECT TOP " + top + " TempTable.PackageID AS PackageID, Name, MainDescription, Keywords, CoverImage,"
//                    + "  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 0 AS TotalRecords"
//                    + " FROM ("
//                    + " SELECT TOP 2147483647 PackageID, Name, MainDescription, Keywords, CoverImage,  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage"
//                    + " FROM RatePackages INNER JOIN @xmlSearchVar.nodes('/ROOT/S') T(C)"
//                    + " ON Name  LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " OR Keywords LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " OR MainDescription LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " WHERE SubCategoryName  LIKE '%" + subCate + "%'"
//                    + " AND Country LIKE '%" + location + "%' OR City LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " ORDER BY Rate DESC ) TempTable"
//                    + " INNER JOIN ("
//                    + " SELECT PackageID"
//                    + " FROM FilterPackages"
//                    + " WHERE FilterPrice >= @minVar AND FilterPrice <= @maxVar"
//                    + " AND NoTripper >= @noTrippersVar"
//                    + tripCon
//                    + groupCon
//                    + serCon
//                    + languageCon
//                    + durationCon
//                    + ") SeTable"
//                    + " ON TempTable.PackageID = SeTable.PackageID"
//                    + bookingSql;
//        } else { // Sort by best match
//            dynamicSql = "WITH Orders_cte AS(SELECT TOP 2147483647 TempTable.PackageID AS PackageID, Name, MainDescription, Keywords, CoverImage,"
//                    + "  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, "
//                    + " COUNT(TempTable.PackageID) AS NoNumber, Min(TempTable.[Priority]) AS Pri FROM ("
//                    + " SELECT PackageID, Name, MainDescription, Keywords, CoverImage, City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 2 AS [Priority]"
//                    + " FROM SmartSearchPackages INNER JOIN @xmlSearchVar.nodes('/ROOT/S') T(C)"
//                    + " ON Name  LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " WHERE SubCategoryName  LIKE '%" + subCate + "%' AND Country LIKE '%" + location + "%'"
//                    + " UNION ALL"
//                    + " SELECT PackageID, Name, MainDescription, Keywords, CoverImage,  City,Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 4 AS [Priority]"
//                    + " FROM SmartSearchPackages INNER JOIN @xmlSearchVar.nodes('/ROOT/S') T(C)"
//                    + " ON Keywords LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " WHERE SubCategoryName  LIKE '%" + subCate + "%' AND Country LIKE '%" + location + "%'"
//                    + " UNION ALL"
//                    + " SELECT PackageID, Name, MainDescription, Keywords, CoverImage,  City,Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 5 AS [Priority]"
//                    + " FROM SmartSearchPackages INNER JOIN @xmlSearchVar.nodes('/ROOT/S') T(C)"
//                    + " ON MainDescription LIKE '%' + T.C.value('.','VARCHAR(20)') + '%'"
//                    + " WHERE SubCategoryName  LIKE '%" + subCate + "%' AND Country LIKE '%" + location + "%'"
//                    + ") TempTable"
//                    + " INNER JOIN ("
//                    + " SELECT PackageID"
//                    + " FROM FilterPackages"
//                    + " WHERE FilterPrice >= @minVar AND FilterPrice <= @maxVar"
//                    + " AND NoTripper >= @noTrippersVar"
//                    + tripCon
//                    + groupCon
//                    + serCon
//                    + languageCon
//                    + durationCon
//                    + ") SeTable"
//                    + " ON TempTable.PackageID = SeTable.PackageID"
//                    + bookingSql
//                    + " GROUP BY TempTable.PackageID, Name, MainDescription, Keywords, CoverImage,  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage"
//                    + " ORDER BY NoNumber DESC,"
//                    + " Pri ASC"
//                    + " )"
//                    + " SELECT TOP " + top + " PackageID, Name, MainDescription, Keywords, CoverImage,  City, Rate, NumberRate, "
//                    + " OrdinaryPriceForAdult, ProviderID, LastName, ProviderImage, 0 AS TotalRecords"
//                    + " FROM Orders_cte"
//                    + " ORDER BY NoNumber DESC,"
//                    + " Pri ASC";
//        }
//        String paramCondition = "@xmlSearchVar XML, @minVar INT, @maxVar INT, @noTrippersVar INT";
//
//        // define procedure
//        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("searchPackagesWithinLocationAndSubCategories");
//        simpleJdbcCall.returningResultSet("rs1", PackagesViewMapper.getInstance());
//
//        // pass parameters
//        SqlParameterSource in = new MapSqlParameterSource().addValue("searchText", searchText)
//                .addValue("minPrice", minPrice).addValue("maxPrice", maxPrice).addValue("noTripper", noTripper)
//                .addValue("SearchStatement", dynamicSql).addValue("ParmDefinition", paramCondition);
        // execute procedure
        // new procedure
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("newMatrixSearch");
        simpleJdbcCall.returningResultSet("rs1", PackagesViewMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("searchText", searchText)
                .addValue("activityName", subCate).addValue("location", location);
        Map<String, Object> record = simpleJdbcCall.execute(in);

        // get result
        List<PackagesViewDTO> packages = (List<PackagesViewDTO>) record.get("rs1");
        return packages;
    }

    @Override
    public QuickComparisonList getQuickComparison(int packageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("QuickComparison");
        simpleJdbcCall.returningResultSet("rs1", PackageDTOMapperForQuickComparison.getInstance())
                .returningResultSet("rs2", PackageDTOMapperForQuickComparison.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        QuickComparisonList result = new QuickComparisonList((List<PackageDTO>) record.get("rs2"), (List<PackageDTO>) record.get("rs1"));
        return result;
    }

    @Override
    public PackageDTO getPackageName(int packageID) {
        String sql = "SELECT PackageID,Name,MaxTripper"
                + " FROM Package"
                + " WHERE PackageID = ?";
        List<PackageDTO> result = jdbcTemplate.query(sql, PackageDTOMapperForStatistics.getInstance(), packageID);
        return result.get(0);
    }

    @Override
    public PackageDTO getPackageName(String bookingID) {
        String sql = "SELECT PackageID,Name,MaxTripper"
                + " FROM Package,Booking"
                + " WHERE Package.PackageID = Booking.PackageID and Booking.Code = ?";
        List<PackageDTO> result = jdbcTemplate.query(sql, PackageDTOMapperForStatistics.getInstance(), bookingID);
        return result.get(0);
    }

    @Override
    public PackageDTO getPackageForEdit(int packageID) {
        PackageDTO packageDTO;
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getPackageForEdit");
        simpleJdbcCall.returningResultSet("rs1", PackageDTOMapperForEdit.getInstance()).returningResultSet("rs2", ActivityMapper.getInstance())
                .returningResultSet("rs3", AmenitiesMapper.getInstance()).returningResultSet("rs4", TransportationWayMapper.getInstance())
                .returningResultSet("rs5", GroupTypeMapper.getInstance()).returningResultSet("rs6", TripTypeMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        packageDTO = ((List<PackageDTO>) record.get("rs1")).get(0);
        List<ActivityDTO> activities = (List<ActivityDTO>) record.get("rs2");
        List<AmenitiesDTO> listAmenities = (List<AmenitiesDTO>) record.get("rs3");
        List<TransportationDTO> ways = (List<TransportationDTO>) record.get("rs4");
        packageDTO.setActivites(activities);
        packageDTO.setListAmenities(listAmenities);
        packageDTO.setTransporations(ways);
        return packageDTO;
    }

    @Override
    public void updateActivity(int packageID, String activities, int groupID, int tripID, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("editActivities");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("tripID", tripID)
                .addValue("groupID", groupID).addValue("activities", activities).addValue("providerID", providerID);
        simpleJdbcCall.execute(in);
    }

    @Override
    public List<String> getFilterOptionOnlyKeyword(String searchText, int numOfRecords) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getFilterOnlyKeyword")
                .returningResultSet("rs1", new RowMapper<String>() {

                    @Override
                    public String mapRow(ResultSet rs, int i) throws SQLException {
                        return rs.getString("Keyword");
                    }
                });
        SqlParameterSource in = new MapSqlParameterSource().addValue("searchText", searchText).addValue("numberofRecord", numOfRecords);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<String> keywords = (List<String>) record.get("rs1");
        return keywords;
    }

    @Override
    public boolean deletePackage(int packageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("deletePackage");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        int result = (int) record.get("result");
        if (result == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void insertActivityFormToTempPackage(int tempPackageID, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertActivitiesForm");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", tempPackageID).addValue("providerID", providerID);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void insertServingPeriodID(int providerID, int packageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("checkClonePackageServingPeriod");
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID).addValue("packageID", packageID);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void insertServingPeriodIDPendding(int providerID, int packageID) {
        System.out.println("providerID = " + providerID + " packageID = " + packageID);
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("checkClonePackageServingPeriodPendding");
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID).addValue("packageID", packageID);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void insertActivityFormToTempPackagev2(int tempPackageID, int groupID, int tripID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertActivitiesForm");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", tempPackageID).addValue("tripID", tripID)
                .addValue("groupID", groupID).addValue("activities", "");
        simpleJdbcCall.execute(in);
    }

    @Override
    public int getNoOfBookedPackages(int packageID, String selectedDate) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getNoOfBookedPackages");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("SelectedDate", selectedDate);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        int noOfBookedPackages = 0;
        if (record.get("NoOfPackages") == null) {
            noOfBookedPackages = 0;
        } else {
            noOfBookedPackages = (int) record.get("NoOfPackages");
        }
        return noOfBookedPackages;
    }

    @Override
    public List<LocationDTO> getFilterOptionOnlyLocation(String searchText, int numOfRecords) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getFilterOnlyLocation")
                .returningResultSet("rs1", LocationDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("searchText", searchText).addValue("numberofRecord", numOfRecords);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<LocationDTO> locations = (List<LocationDTO>) record.get("rs1");
        return locations;
    }

    @Override
    public List<PopularPackageDTO> getFilterOptionOnlyPackage(String searchText, int numOfRecords) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getFilterOnlyLocation")
                .returningResultSet("rs1", LocationDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("searchText", searchText).addValue("numberofRecord", numOfRecords);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<PopularPackageDTO> popularPackages = (List<PopularPackageDTO>) record.get("rs1");
        return popularPackages;
    }

    @Override
    public NearMeTable getNearMeData() {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getNearMeTable")
                .returningResultSet("rs1", NearMeLocationMapper.getInstance()).returningResultSet("rs2", NearMeCategoryMapper.getInstance());
        Map<String, Object> record = simpleJdbcCall.execute();
        List<NearMeLocation> locations = (List<NearMeLocation>) record.get("rs1");
        List<NearMeCategory> categories = (List<NearMeCategory>) record.get("rs2");
        return new NearMeTable(categories, locations);
    }

    @Override
    public boolean checkImageExist(String name, int temporaryPackageID) {
        String sql = "Select * FROM TemporaryImage Where Link like ? and TemporaryPackageID = ?";
        List<String> result = jdbcTemplate.query(sql, new RowMapper<String>() {

            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                return rs.getString("Link");
            }
        }, name, temporaryPackageID);
        if (result.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteAdditionImage(String image, int temporaryPackageID) {
        String sql = "Delete FROM TemporaryImage "
                + "WHERE Link = ? and TemporaryPackageID = ?";
        jdbcTemplate.update(sql, image, temporaryPackageID);
        return true;
    }

    @Override
    public boolean deleteAdditionImagePackage(String image, int packageID) {
        String sql = "Delete FROM PackageImage "
                + "WHERE Link = ? and PackageID = ?";
        jdbcTemplate.update(sql, image, packageID);
        return true;
    }

    @Override
    public boolean deleteAdditionImagev2(String image, int temporaryPackageID) {
        String sql = "Delete FROM TemporaryImagev2 "
                + "WHERE Link = ? and TemporaryPackageID = ?";
        jdbcTemplate.update(sql, image, temporaryPackageID);
        return true;
    }

    @Override
    public boolean saveAvailability(int temporaryPackageID, int duration, String durationType, String startOperationTime, String endOperationTime, int resourceID, int minResource, boolean isFreeBooking, int fixedHour, int fixedMinute) {
        String sql = "Update TemporaryPackage"
                + " Set Duration = ?, DurationType = ?,StartOperationTime = ?,EndOperationTime = ?,ResourceID = ?,MinimumResources = ?, IsFreeBooking = ?, FixedHour = ?, FixedMinute = ?"
                + " Where TemporaryPackageID = ?";
        jdbcTemplate.update(sql, duration, durationType, startOperationTime, endOperationTime, resourceID, minResource, isFreeBooking, fixedHour, fixedMinute, temporaryPackageID);
        return true;
    }

    @Override
    public List<PackageDTOv2> loadNewTrip() {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getNewestPackages")
                .returningResultSet("rs1", PackageDTOv2ForNewestMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("randomNoOuput", 0);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<PackageDTOv2> result = (List<PackageDTOv2>) record.get("rs1");
        return result;
    }

    @Override
    public PackageDTO getDurationOfPackage(int packageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getDurationOfPackage")
                .returningResultSet("rs1", PackageDTOMapperWithDuration.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<PackageDTO> result = (List<PackageDTO>) record.get("rs1");
        return result.get(0);
    }

    @Override
    public boolean approveSubCategory(int temporaryPackageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("approveSubCategory")
                .returningResultSet("rs1", PackageDTOv2ForNewestMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("temporaryPackageID", temporaryPackageID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return true;
    }

    @Override
    public PackageDTO getPackageToCheckBooking(int packageID, String tripDate) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getPackagePriceForBook")
                .returningResultSet("rs1", PackageDTOMapperForCheckTripperBooking.getInstance())
                .returningResultSet("rs2", UsedResourcesViewDTOMapperForCheckTripperBooking.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("tripDate", tripDate);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<PackageDTO> packageDTOs = (List<PackageDTO>) record.get("rs1");
        List<UsedResourcesViewDTO> usedResources = (List<UsedResourcesViewDTO>) record.get("rs2");
        PackageDTO packageDTO = packageDTOs.get(0);
        packageDTO.setUsedResources(usedResources);
        return packageDTO;
    }

    @Override
    public boolean saveAdditionalCategory(int temporaryPackageID, int packageColor, int targetCountryID, int adventureLevel, int challengeLevel, int friendshipLevel,
            int happinessLevel, int healthinessLevel, int knowledgeLevel, int peacefulnessLevel, int romanceLevel, int sophisticationLevel, int unexpectedLevel,int subCategoryID,String otherSubCategoryContent, int providerID) {
        String sql = "Update TemporaryPackage SET ColorID = ?,TargetCountryID = ?,AdventureLevel = ?,"
                + " ChallengeLevel = ?,FriendshipLevel = ?, HappinessLevel = ?,HealthinessLevel=?,KnowledgeLevel = ?,"
                + "PeacefulnessLevel = ?,RomanceLevel = ?,SophisticationLevel = ?,UnexpectedLevel = ?,SubCategoryID = ?, OtherSubCategoryContent = ? "
                + "Where TemporaryPackageID = ? and ProviderID = ? ";
        Integer targetCountryIDInt = null;
        if (targetCountryID != 0) {
            targetCountryIDInt = targetCountryID;
        }

        Integer packageColorInt = null;
        if (packageColor != 0) {
            packageColorInt = packageColor;
        }
        Integer subCategoryIDInt = null;
        if(subCategoryID !=0){
            subCategoryIDInt = subCategoryID;
        }
        jdbcTemplate.update(sql, packageColorInt, targetCountryIDInt, adventureLevel, challengeLevel, friendshipLevel,
                happinessLevel, healthinessLevel, knowledgeLevel, peacefulnessLevel, romanceLevel, sophisticationLevel,
                unexpectedLevel,subCategoryIDInt,otherSubCategoryContent, temporaryPackageID, providerID);
        return true;
    }

    @Override
    public boolean editAdditionalCategory(int packageID, int packageColor, int targetCountryID, int adventureLevel, int challengeLevel,
            int friendshipLevel, int happinessLevel, int healthinessLevel, int knowledgeLevel, int peacefulnessLevel, int romanceLevel,
            int sophisticationLevel, int unexpectedLevel, int providerID) {
        String sql = "Update Package SET ColorID = ?,TargetCountryID = ?,AdventureLevel = ?,"
                + " ChallengeLevel = ?,FriendshipLevel = ?, HappinessLevel = ?,HealthinessLevel=?,KnowledgeLevel = ?,"
                + "PeacefulnessLevel = ?,RomanceLevel = ?,SophisticationLevel = ?,UnexpectedLevel = ? "
                + "Where PackageID = ? and ProviderID = ?";

        Integer targetCountryIDInt = null;
        if (targetCountryID != 0) {
            targetCountryIDInt = targetCountryID;
        }

        Integer packageColorInt = null;
        if (packageColor != 0) {
            packageColorInt = packageColor;
        }
        jdbcTemplate.update(sql, packageColorInt, targetCountryIDInt, adventureLevel, challengeLevel, friendshipLevel,
                happinessLevel, healthinessLevel, knowledgeLevel, peacefulnessLevel, romanceLevel, sophisticationLevel, unexpectedLevel, packageID, providerID);
        return true;
    }

    @Override
    public boolean editPolicy(int providerID, int cancellationID, String name, String condition) {
        String sql = "Update Cancellation SET Conditions = ?,name = ? Where CancellationID = ?";
        jdbcTemplate.update(sql, condition, name, cancellationID);
        return true;
    }

    @Override
    public CancellationDTO createPolicy(int providerID, String name, String condition) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("createPolicy")
                .returningResultSet("rs1", CancellationDTOMapper.getInstance());

        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID)
                .addValue("name", name).addValue("condition", condition);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<CancellationDTO> policy = (List<CancellationDTO>) record.get("rs1");
        return policy.get(0);
    }

    @Override
    public ChildrenDiscountDTO createChildrenDiscount(int packageID, String condition, int percent, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("createChildrenDiscount")
                .returningResultSet("rs1", ChildrenDiscountDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID)
                .addValue("packageID", packageID).addValue("condition", condition).addValue("percent", percent);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<ChildrenDiscountDTO> policy = (List<ChildrenDiscountDTO>) record.get("rs1");
        return policy.get(0);
    }

    @Override
    public ChildrenDiscountDTO createChildrenDiscountForMainPackage(int packageID, String condition, int percent, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("createChildrenDiscountForMainPackage")
                .returningResultSet("rs1", ChildrenDiscountDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID)
                .addValue("packageID", packageID).addValue("condition", condition).addValue("percent", percent);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<ChildrenDiscountDTO> policy = (List<ChildrenDiscountDTO>) record.get("rs1");
        return policy.get(0);
    }

    @Override
    public DisabledDiscountDTO createDisabledDiscount(int packageID, String condition, int percent, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("createDisabledDiscount")
                .returningResultSet("rs1", DisabledDiscountDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID)
                .addValue("packageID", packageID).addValue("condition", condition).addValue("percent", percent);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<DisabledDiscountDTO> policy = (List<DisabledDiscountDTO>) record.get("rs1");
        return policy.get(0);
    }

    @Override
    public DisabledDiscountDTO createDisabledDiscountForMainPackage(int packageID, String condition, int percent, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("createDisabledDiscountForMainPackage")
                .returningResultSet("rs1", DisabledDiscountDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID)
                .addValue("packageID", packageID).addValue("condition", condition).addValue("percent", percent);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<DisabledDiscountDTO> policy = (List<DisabledDiscountDTO>) record.get("rs1");
        return policy.get(0);
    }

    @Override
    public boolean deleteOldDiscount(int packageID, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("deleteOldDiscount")
                .returningResultSet("rs1", DisabledDiscountDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        if (record.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean saveChildrenDiscount(int packageID, int childrenDiscountID, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertTemporaryPackageChildrenDiscount");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("childrenDiscountID", childrenDiscountID)
                .addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return true;
    }

    @Override
    public boolean saveDisabledDiscount(int packageID, int disabledDiscountID, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertTemporaryPackageDisabledDiscount");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("disabledDiscountID", disabledDiscountID)
                .addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return true;
    }

    @Override
    public void updateBookingFormOfTempPackage(int packageID, String packageType, Integer minTripper, Integer maxTripper, Integer resourceID,
            Integer minimumResources, Integer servingID, boolean isFreeBooking, int freeInterval,
            Integer fixedHour, Integer fixedMinute, String unavailableDays, int sequentialOperation, boolean isRunning, int readyBookingDuration, String readyBookingDurationType,
            int durationDay, int durationMonth, int durationYear, int durationHour, int durationMinute, int restingDay,
            int restingHour, int restingMinute, int providerID, String startDate,
            boolean isUsingMaxQuota, int maxQuota, String quotaType, boolean isSpecificLaunchDate) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("updateBookingFormOfTempPackage");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("packageType", packageType).addValue("minTripper", minTripper).addValue("maxTripper", maxTripper)
                .addValue("resourceID", resourceID).addValue("minimumResource", minimumResources).addValue("isRunning", isRunning)
                .addValue("servingID", servingID).addValue("isFreeBooking", isFreeBooking).addValue("freeInterval", freeInterval)
                .addValue("fixedHour", fixedHour).addValue("fixedMinute", fixedMinute).addValue("unavailableDays", unavailableDays)
                .addValue("sequentialOperation", sequentialOperation).addValue("readyBookingDuration", readyBookingDuration)
                .addValue("readyBookingDurationType", readyBookingDurationType)
                .addValue("durationDay", durationDay).addValue("durationMonth", durationMonth).addValue("durationYear", durationYear)
                .addValue("durationHour", durationHour)
                .addValue("durationMinute", durationMinute).addValue("providerID", providerID)
                .addValue("restingDay", restingDay).addValue("restingHour", restingHour).addValue("restingMinute", restingMinute)
                .addValue("startDate", startDate).addValue("isUsingMaxQuota", isUsingMaxQuota).addValue("maxQuota", maxQuota)
                .addValue("quotaType", quotaType).addValue("isSpecificLaunchDate", isSpecificLaunchDate);
        simpleJdbcCall.execute(in);
    }

    @Override
    public boolean editChildrenDiscount(int childrenDiscountID, String condition, int discountPercent) {
        String sql = "Update ChildrenDiscount SET Condition = ?,DiscountPercent = ? Where ChildrenDiscountID = ?";
        jdbcTemplate.update(sql, condition, discountPercent, childrenDiscountID);
        return true;
    }

    @Override
    public boolean editDisabledDiscount(int disabledDiscountID, String condition, int discountPercent) {
        String sql = "Update DisabledDiscount SET Condition = ?,DiscountPercent = ? Where DisabledDiscountID = ?";
        jdbcTemplate.update(sql, condition, discountPercent, disabledDiscountID);
        return true;
    }

    @Override
    public boolean processFreeDiscount(int temporaryPackageID, int childrenDiscountID, boolean selectFree, int ageValue, String ageType) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("processFreeDiscount");
        SqlParameterSource in = new MapSqlParameterSource().addValue("temporaryPackageID", temporaryPackageID)
                .addValue("childrenDiscountID", childrenDiscountID).addValue("ageType", ageType)
                .addValue("ageValue", ageValue).addValue("selectFree", selectFree);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        if (record.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<PackageDTO> getPackageForChat(int providerID) {
        String sql = "Select Package.PackageID,OthersLanguageDescription.PackageName as Name FROM Package,OthersLanguageDescription Where ProviderID = ? and Package.PackageID = OthersLanguageDescription.PackageID";
        List<PackageDTO> reuslt = jdbcTemplate.query(sql, PackageDTOForChatMapper.getInstance(), providerID);
        return reuslt;
    }

    @Override
    public boolean deleteOldDiscountForPackage(int packageID, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("deleteOldDiscountForMainPackage")
                .returningResultSet("rs1", DisabledDiscountDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        if (record.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean saveChildrenDiscountMainPackage(int packageID, int childrenDiscountID, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("editPackageChildrenDiscount");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("childrenDiscountID", childrenDiscountID)
                .addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return true;
    }

    @Override
    public boolean saveDisabledDiscountMainPackage(int packageID, int disabledDiscountID, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("editPackageDisabledDiscount");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID).addValue("disabledDiscountID", disabledDiscountID)
                .addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return true;
    }

    @Override
    public boolean updatePriceOfMainPackage(int packageID, double adultPrice, double youtripperPrice, String priceCurrency,
            int youtripperPercentage, int noCancellationPercent, int providerID, String childrenDiscountJson, String cancellationPolicyJson) {
        String nullValue = "";

        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("saveMainPackagePrice");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("adultPirce", adultPrice).addValue("youtripperPrice", youtripperPrice)
                .addValue("priceCurrency", priceCurrency)
                .addValue("youtripperPercentage", youtripperPercentage).addValue("noCancellationPercent", noCancellationPercent)
                .addValue("providerID", providerID).addValue("childrenDiscountJson", childrenDiscountJson)
                .addValue("cancellationPolicyJson", cancellationPolicyJson);
        simpleJdbcCall.execute(in);
        return true;

    }

    @Override
    public void editBookingFormOfMainPackage(int packageID, String packageType, Integer minTripper, Integer maxTripper, Integer resourceID,
            Integer minimumResources, Integer servingID, boolean isFreeBooking, int freeInterval,
            Integer fixedHour, Integer fixedMinute, String unavailableDays, int sequentialOperation, boolean isRunning, int readyBookingDuration, String readyBookingDurationType,
            int durationDay, int durationMonth, int durationYear, int durationHour, int durationMinute, int restingDay, int restingHour, int restingMinute, int providerID, String startDate,
            boolean isUsingMaxQuota, int maxQuota, String quotaType) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("updateBookingFormOfPackage");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("packageType", packageType).addValue("minTripper", minTripper).addValue("maxTripper", maxTripper)
                .addValue("resourceID", resourceID).addValue("minimumResource", minimumResources).addValue("isRunning", isRunning)
                .addValue("servingID", servingID).addValue("isFreeBooking", isFreeBooking).addValue("freeInterval", freeInterval)
                .addValue("fixedHour", fixedHour).addValue("fixedMinute", fixedMinute).addValue("unavailableDays", unavailableDays)
                .addValue("sequentialOperation", sequentialOperation).addValue("readyBookingDuration", readyBookingDuration)
                .addValue("readyBookingDurationType", readyBookingDurationType)
                .addValue("durationDay", durationDay).addValue("durationMonth", durationMonth).addValue("durationYear", durationYear)
                .addValue("durationHour", durationHour)
                .addValue("durationMinute", durationMinute).addValue("providerID", providerID)
                .addValue("restingDay", restingDay).addValue("restingHour", restingHour).addValue("restingMinute", restingMinute)
                .addValue("startDate", startDate).addValue("isUsingMaxQuota", isUsingMaxQuota).addValue("maxQuota", maxQuota)
                .addValue("quotaType", quotaType);
        simpleJdbcCall.execute(in);

    }

    @Override
    public int clonePendingPackage(int providerID, int packageID,
            boolean cloneAll,
            boolean cloneCategory, boolean cloneDescription, boolean clonePhoto,
            boolean cloneBooking, boolean clonePricing) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("ClonePendingPackage");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("providerID", providerID).addValue("cloneAll", cloneAll)
                .addValue("cloneCategory", cloneCategory).addValue("cloneDescription", cloneDescription)
                .addValue("clonePhoto", clonePhoto).addValue("cloneBooking", cloneBooking)
                .addValue("clonePricing", clonePricing);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        int result = (int) record.get("newTemporaryPackageID");
        return result;
    }

    @Override
    public int clonePackage(int providerID, int packageID, boolean cloneAll,
            boolean cloneCategory, boolean cloneDescription, boolean clonePhoto,
            boolean cloneBooking, boolean clonePricing) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("ClonePackage");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("providerID", providerID).addValue("cloneAll", cloneAll)
                .addValue("cloneCategory", cloneCategory).addValue("cloneDescription", cloneDescription)
                .addValue("clonePhoto", clonePhoto).addValue("cloneBooking", cloneBooking)
                .addValue("clonePricing", clonePricing);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        int result = (int) record.get("newTemporaryPackageID");
        return result;
    }

    @Override
    public void updateTemporaryCoverImage(int packageID, String link) {
        String sql = "UPDATE TemporaryPackage "
                + "SET CoverImage = ? "
                + "WHERE TemporaryPackageID = ?";
        jdbcTemplate.update(sql, "/Images/TemporaryPackages/" + packageID + "/" + link, packageID);
    }

    @Override
    public void updateTemporaryAdditionalImage(int packageID, String link, String oldLink) {
        String sql = "UPDATE TemporaryImage "
                + "SET Link = ? "
                + "WHERE TemporaryPackageID = ? and Link like ?";
        jdbcTemplate.update(sql, "/Images/TemporaryPackages/" + packageID + "/" + link, packageID, oldLink);
    }

    @Override
    public void stopPackage(int packageID, int providerID) {
        String sql = "UPDATE Package "
                + "SET isStopped = ? "
                + "WHERE PackageID = ? AND ProviderID = ?";
        jdbcTemplate.update(sql, 1, packageID, providerID);
    }

    @Override
    public void startPackage(int packageID, int providerID) {
        String sql = "UPDATE Package "
                + "SET isStopped = ? "
                + "WHERE PackageID = ? AND ProviderID = ?";
        jdbcTemplate.update(sql, 0, packageID, providerID);
    }

    @Override
    public void deletePackage(int packageID, String reason, int deleteID, int providerID) {
        int result = 0;
        String sql = "Select Count(code) from Booking "
                + "WHERE PackageID = ? AND BookingMilliseconds > ?";
        result = jdbcTemplate.queryForObject(sql, Integer.class, packageID, System.currentTimeMillis());
        if (result == 0) {
            sql = "UPDATE Package "
                    + "SET isDeleting = ?, DeleteReason = ?, DeleteReasonID = ? "
                    + "WHERE PackageID = ? AND ProviderID = ? AND isStopped = 1";
            jdbcTemplate.update(sql, 1, reason, deleteID, packageID, providerID);
        }
    }

    @Override
    public void deleteTemporaryPackage(int packageID, int providerID) {
        String sql = "Delete FROM TemporaryPackage "
                + "WHERE TemporaryPackageID = ? AND ProviderID = ?";
        jdbcTemplate.update(sql, packageID, providerID);

    }

    @Override
    public boolean checkExistPackage(int packageID) {
        int result = 0;
        String sql = "Select Count(code) from Booking "
                + "WHERE PackageID = ? AND BookingMilliseconds > ?";
        result = jdbcTemplate.queryForObject(sql, Integer.class, packageID, System.currentTimeMillis());
        return result > 0;
    }

    @Override
    public PackageDTO getPreviewPackageEditing(int packageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getPackageEditing")
                .returningResultSet("rs1", PackageDTOMapperForPreviewEditing.getInstance())
                .returningResultSet("rs2", AmenitiesClassifierDTOMapperForDetail.getInstance())
                .returningResultSet("rs3", OthersLanguageDescriptionDTOMapperFoDetail.getInstance())
                .returningResultSet("rs4", PackageCertificateDTOMapperForDetail.getInstance())
                .returningResultSet("rs5", AdditionalImageDTOMapperForPreview.getInstance())
                .returningResultSet("rs6", ReviewDTOMapper.getInstance())
                .returningResultSet("rs7", SuitabilityDTOMapperForDetail.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        PackageDTO packageDTO = ((List<PackageDTO>) record.get("rs1")).get(0);
        List<AmenitiesClassifierDTO> amenitiesClassifier = (List<AmenitiesClassifierDTO>) record.get("rs2");
        List<OthersLanguageDescriptionDTO> othersLanguageDescription = (List<OthersLanguageDescriptionDTO>) record.get("rs3");
        List<PackageCertificateDTO> certificates = (List<PackageCertificateDTO>) record.get("rs4");
        List<AdditionImageDTO> additionImages = (List<AdditionImageDTO>) record.get("rs5");
        List<ReviewDTO> reviews = (List<ReviewDTO>) record.get("rs6");
        List<SuitabilityDTO> suitabilities = (List<SuitabilityDTO>) record.get("rs7");
        packageDTO.setAmenitiesClassifiers(amenitiesClassifier);
        packageDTO.setReviews(reviews);
        packageDTO.setOthersLanguageDescription(othersLanguageDescription);
        packageDTO.setCertificates(certificates);
        packageDTO.setAdditionImages(additionImages);
        packageDTO.setSuitabilities(suitabilities);
        return packageDTO;
    }

    @Override
    public boolean applyPackageEditing(int packageID, int providerID) {
        String sql = "UPDATE Package "
                + " SET isPending = ? ,isEditing = ?"
                + " WHERE PackageID = ? AND ProviderID = ? AND isEditing = ?";
        jdbcTemplate.update(sql, 1, 0, packageID, providerID, 1);
        return true;
    }

    @Override
    public boolean insertEditingReason(int packageID, String reason, int providerID) {
        long editTime = System.currentTimeMillis();
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertEditingReason");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("reason", reason).addValue("editDate", editTime).addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return true;
    }

    @Override
    public boolean updateCoverAfterApprove(int packageID, String link) {
        String sql = "UPDATE Package "
                + " SET CoverImage = ? "
                + " WHERE PackageID = ?";
        jdbcTemplate.update(sql, link, packageID);
        return true;
    }

    @Override
    public boolean updateAdditionalAfterApprove(int packageID, String imageName, String link) {
        String sql = "UPDATE PackageImage "
                + "SET Link = ? "
                + "WHERE PackageID = ? and Link like ?";
        jdbcTemplate.update(sql, link, packageID, imageName);
        return true;
    }

    @Override
    public int countNumberOfPackage(int providerID) {
        String sql = "SELECT (select count(*) from TemporaryPackage where providerID = ?) "
                + "+ (select count(*) from Package where providerID = ?)";
        return jdbcTemplate.queryForObject(sql, Integer.class, providerID, providerID);
    }

    @Override
    public List<PackageDTO> getRecommededPackage() {
      simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getRecommendedPackage")
                .returningResultSet("rs1", PackageDTOMapperForHomePage.getInstance());
         Map<String, Object> record = simpleJdbcCall.execute();
        List<PackageDTO> packageList = (List<PackageDTO>) record.get("rs1");
        return packageList;
    }

    @Override
    public List<PackageDTO> getPackageInBangkok() {
              simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getPackageInBangkok")
                .returningResultSet("rs1", PackageDTOMapperForHomePage.getInstance());
         Map<String, Object> record = simpleJdbcCall.execute();
        List<PackageDTO> packageList = (List<PackageDTO>) record.get("rs1");
        return packageList;
    }

}
