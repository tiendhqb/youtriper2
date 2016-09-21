/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.Service;

import DTO.AccountSession;
import DTO.BookingDTO;
import DTO.BookingStatistics;
import DTO.CancellationDTO;
import DTO.CertificatesViewDTO;
import DTO.ChildrenDiscountDTO;
import DTO.DescriptionForm;
import DTO.DisabledDiscountDTO;
import DTO.ExtrasForm;
import DTO.OfflinePackageDTO;
import DTO.PackageDTO;
import DTO.ProviderDTO;
import DTO.ProviderNotification;
import DTO.ProviderNotificationSetting;
import DTO.ProviderSession;
import DTO.ReferralDTO;
import DTO.SaleInfo;
import DTO.TemporaryAmenitiesClassifierDTO;
import DTO.TemporaryPackageDTO;
import DTO.TemporaryPackageDTOv2;
import DTO.TemporaryTransoprtationWayDTO;
import Interface.DAO.ActivityDAO;
import Interface.DAO.AmenitiesDAO;
import Interface.DAO.BookingDAO;
import Interface.DAO.BucketListDAO;
import Interface.DAO.CategoryDAO;
import Interface.DAO.CertificateDAO;
import Interface.DAO.GroupTypeDAO;
import Interface.DAO.KeywordDAO;
import Interface.DAO.OfflinePackageDAO;
import Interface.DAO.PackageDAO;
import Interface.DAO.ProviderDAO;
import Interface.DAO.ProviderNotificationDAO;
import Interface.DAO.ProviderSystemNotificationDAO;
import Interface.DAO.ReferralDAO;
import Interface.DAO.SubCategoryDAO;
import Interface.DAO.TemporaryAmenitiesClassifierDAO;
import Interface.DAO.TemporaryClassifierDAO;
import Interface.DAO.TemporaryPackageCertificatesDAO;
import Interface.DAO.TemporarySuitabilityClassifierDAO;
import Interface.DAO.TransporationDAO;
import Interface.DAO.TripTypeDAO;
import Interface.Service.ProviderService;
import DTO.AdditionImageDTO;
import DTO.OfflineResourceDTO;
import Interface.DAO.AmenitiesClassifierDAO;
import Interface.DAO.BusinessResourceDAO;
import Interface.DAO.ClassifierDAO;
import Interface.DAO.PackageCertificatesDAO;
import JavaClass.BookingDetailAllDate;
import JavaClass.BookingEngineData;
import JavaClass.BookingUserList;
import JavaClass.DateBookingDetail;
import JavaClass.FileMeta;
import JavaClass.Sale;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import Interface.DAO.ResourceDAO;
import Interface.DAO.ResourceSkillDAO;
import Interface.DAO.ServingPeriodDAO;
import Interface.DAO.SuitabilityClassifierDAO;
import Interface.DAO.TemporaryOperationCycleDAO;
import Interface.DAO.TrippSourceDAO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.mail.Address;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Nick
 */
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    ProviderDAO providerDAO;

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
    BucketListDAO bucketListDAO;

    @Autowired
    TransporationDAO transporationDAO;

    @Autowired
    GroupTypeDAO groupTypeDAO;

    @Autowired
    TripTypeDAO tripTypeDAO;

    @Autowired
    BookingDAO bookingDAO;

    @Autowired
    ProviderNotificationDAO providerNotificationDAO;

    @Autowired
    ProviderSystemNotificationDAO providerSystemNotificationDAO;

    @Autowired
    TemporaryAmenitiesClassifierDAO temporaryAmenitiesClassifierDAO;
    @Autowired
    AmenitiesClassifierDAO amenitiesClassifierDAO;

    @Autowired
    TemporaryClassifierDAO temporaryClassifierDAO;

    @Autowired
    ClassifierDAO classifierDAO;

    @Autowired
    TemporarySuitabilityClassifierDAO temporarySuitabilityClassifierDAO;

    @Autowired
    SuitabilityClassifierDAO suitabilityClassifierDAO;

    @Autowired
    CertificateDAO certificateDAO;

    @Autowired
    ResourceDAO resourceDAO;

    @Autowired
    ReferralDAO referralDAO;

    @Autowired
    OfflinePackageDAO offlinePackageDAO;

    @Autowired
    PackageCertificatesDAO packageCertificatesDAO;

    @Autowired
    TemporaryPackageCertificatesDAO temporaryPackageCertificatesDAO;

    @Autowired
    ServingPeriodDAO servingPeriodDAO;

    @Autowired
    TemporaryOperationCycleDAO temporaryOperationCycleDAO;

    @Autowired
    ResourceSkillDAO resourceSkillDAO;

    @Autowired
    BusinessResourceDAO businessResourceDAO;

    @Autowired
    TrippSourceDAO trippSourceDAO;

    private final Gson gson;

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final int CODE_LENGTH = 12;
    static final int IMAGE_LENGTH = 5;

    private static final int MINIMUM_INTERVAL = 5;

    public ProviderServiceImpl() {
        gson = new Gson();
    }

    @Override
    public ProviderSession login(String email, String password) {
        try {
            return providerDAO.login(email, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getPackagesOfProvider(int providerID) {
        return gson.toJson(packageDAO.getAllPackageOfProvider(providerID));
    }

    @Override
    public String getCertificatesOfProvider(int providerID) {
        return gson.toJson(packageDAO.getAllCertificateOfProvider(providerID));
    }

    @Override
    public String getApprovedCertificatesOfProvider(int providerID) {
        return gson.toJson(packageDAO.getApprovedCertificateOfProvider(providerID));
    }

    @Override
    public CertificatesViewDTO getCertificateURL(int certificateID) {
        return packageDAO.getCertificateURL(certificateID);
    }

    @Override
    public boolean isProvider(AccountSession account) {
        return account != null && account.getRole() != 1;
    }

    @Override
    public TemporaryPackageDTO getTemporaryPackage(int providerID) {
        return packageDAO.getTemporaryPackageByID(providerID);
    }

    @Override
    public TemporaryPackageDTOv2 getTemporaryPackagev2(int providerID) {
        return packageDAO.getTemporaryPackageByIDv2(providerID);
    }

    @Override
    public PackageDTO getPackage(int packageId) {
        return packageDAO.getPackage(packageId);
    }

    @Override
    public String getPackageForm(int providerID) {
        return gson.toJson(packageDAO.getCreationForm(providerID));
    }

    @Override
    public String getPackageFormForEdit(int providerID) {
        return gson.toJson(packageDAO.getCreationFormForEdit(providerID));
    }

    @Override
    public boolean applyTempPackageToPreview(int packageID, int providerID) {
        return packageDAO.applyTempPackageToPreview(packageID, providerID);
    }

    @Override
    public boolean applyTempPackageToPreviewv2(int packageID) {
        return packageDAO.applyTempPackageToPreviewv2(packageID);
    }

    @Override
    public List<String> getKeywords(String data) {
        return keywordDAO.getKeywords(data);
    }

    @Override
    public boolean insertActivityForm(String dataJson, int providerID) {
        // get data from json string
        JsonObject object = gson.fromJson(dataJson, JsonObject.class);
        int packageID = object.get("packageID").getAsInt();
//        String activites = object.get("activities").getAsString();

        // delete old data and update groupID, tripID
        packageDAO.insertActivityFormToTempPackage(packageID, providerID);
        String otherSubCategoryContent = "";
        try {
          otherSubCategoryContent = object.get("subCategoryContent").getAsString();
        } catch (Exception e) {
        }
        int subCategoryID = 0;
        try {
          subCategoryID = object.get("subCategoryID").getAsInt();
        } catch (Exception e) {
        }
        
        System.out.println("subCategoryID" + subCategoryID);
        // get list suitability json
        JsonArray suitabilityJson = object.getAsJsonArray("suitability");
        // insert list suitability
        for (JsonElement suitabilityElm : suitabilityJson) {
            // convert to object
            JsonObject suitabilityObj = suitabilityElm.getAsJsonObject();
            boolean selected = suitabilityObj.get("selected").getAsBoolean();
            if (selected) { // check this suitbaility is selected or not
                // if is selected then insert
                int suitablityID = suitabilityObj.get("suitabilityID").getAsInt();
                String content = suitabilityObj.get("content").getAsString();
                temporarySuitabilityClassifierDAO.insertTemporarySuitabilityClassifier(packageID, suitablityID, content, providerID);
            }
        }

        //Get Package Color,Target Country,Feeling of Package
        int packageColor = object.get("packageColor").getAsInt();
        int targetCountryID = object.get("targetCountryID").getAsInt();
        int adventureLevel = object.get("adventureLevel").getAsInt();
        int challengeLevel = object.get("challengeLevel").getAsInt();
        int friendshipLevel = object.get("friendshipLevel").getAsInt();
        int happinessLevel = object.get("happinessLevel").getAsInt();
        int healthinessLevel = object.get("healthinessLevel").getAsInt();
        int knowledgeLevel = object.get("knowledgeLevel").getAsInt();
        int peacefulnessLevel = object.get("peacefulnessLevel").getAsInt();
        int romanceLevel = object.get("romanceLevel").getAsInt();
        int sophisticationLevel = object.get("sophisticationLevel").getAsInt();
        int unexpectedLevel = object.get("unexpectedLevel").getAsInt();
        packageDAO.saveAdditionalCategory(packageID, packageColor, targetCountryID, adventureLevel, challengeLevel,
                friendshipLevel, happinessLevel, healthinessLevel, knowledgeLevel, peacefulnessLevel, romanceLevel,
                sophisticationLevel, unexpectedLevel, subCategoryID, otherSubCategoryContent, providerID);
        return true;
    }

    @Override
    public boolean editActivityForm(String dataJson, int providerID) {

        // get data from json string
        JsonObject object = gson.fromJson(dataJson, JsonObject.class);
        int packageID = object.get("packageID").getAsInt();
//        String activites = object.get("activities").getAsString();
        int tripID = object.get("tripID").getAsInt();
        int groupID = object.get("groupID").getAsInt();
        // insert data
        JsonArray activitiesJson = object.getAsJsonArray("activities");
        packageDAO.updateActivity(packageID, "", groupID, tripID, providerID);
        //------------------------------
        String subCategoryContent = "";
        int categoryID = 0;
        if (object.get("subCategoryContent") != null && !object.get("subCategoryContent").getAsString().equals("")) {
            subCategoryContent = object.get("subCategoryContent").getAsString();
            categoryID = object.get("subCategoryID").getAsInt();
        }

        for (JsonElement activityJson : activitiesJson) { // get json activities array
            JsonObject activityObj = activityJson.getAsJsonObject(); // convert to object
            int activityID = activityObj.get("activityID").getAsInt();
            String content = "";
            try {
                content = activityObj.get("content").getAsString();
            } catch (Exception e) {
                content = "";
            }

            classifierDAO.updateClassifier(packageID, activityID, content, categoryID, subCategoryContent, providerID);
        }

        // get list suitability json
        JsonArray suitabilityJson = object.getAsJsonArray("suitability");
        // insert list suitability
        int delete = 1;
        for (JsonElement suitabilityElm : suitabilityJson) {
            // convert to object
            JsonObject suitabilityObj = suitabilityElm.getAsJsonObject();
            boolean selected = suitabilityObj.get("selected").getAsBoolean();
            if (selected) { // check this suitbaility is selected or not
                // if is selected then insert
                int suitabilityID = suitabilityObj.get("suitabilityID").getAsInt();
                System.out.println(suitabilityID);
                String content = suitabilityObj.get("content").getAsString();
                suitabilityClassifierDAO.updateSuitabilityClassifier(packageID, suitabilityID, content, delete, providerID);
            }
            delete = 0;
        }
        //Get Package Color,Target Country,Feeling of Package
        int packageColor = object.get("packageColor").getAsInt();
        int targetCountryID = object.get("targetCountryID").getAsInt();
        int adventureLevel = object.get("adventureLevel").getAsInt();
        int challengeLevel = object.get("challengeLevel").getAsInt();
        int friendshipLevel = object.get("friendshipLevel").getAsInt();
        int happinessLevel = object.get("happinessLevel").getAsInt();
        int healthinessLevel = object.get("healthinessLevel").getAsInt();
        int knowledgeLevel = object.get("knowledgeLevel").getAsInt();
        int peacefulnessLevel = object.get("peacefulnessLevel").getAsInt();
        int romanceLevel = object.get("romanceLevel").getAsInt();
        int sophisticationLevel = object.get("sophisticationLevel").getAsInt();
        int unexpectedLevel = object.get("unexpectedLevel").getAsInt();
        packageDAO.editAdditionalCategory(packageID, packageColor, targetCountryID, adventureLevel, challengeLevel, friendshipLevel,
                happinessLevel, healthinessLevel, knowledgeLevel, peacefulnessLevel, romanceLevel, sophisticationLevel, unexpectedLevel, providerID);

        return true;
    }

    @Override
    public void updateDescriptionFormOfTempPackage(String data, int providerID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        // get packageID
        int packageID = dataJson.get("packageID").getAsInt();

        // delete old data first
        String country = null;
        try {
            country = dataJson.get("country").getAsString();
        } catch (Exception e) {

        }

        String city = null;
        try {
            city = dataJson.get("city").getAsString();
        } catch (Exception e) {

        }
        packageDAO.deleteOldDescriptionForm(packageID, country, city, providerID);

        // get list of language description
        JsonArray descriptions = dataJson.get("descriptions").getAsJsonArray();
        for (JsonElement descriptionElement : descriptions) {
            // insert each language
            JsonObject descriptionObject = descriptionElement.getAsJsonObject();
            int languageID = descriptionObject.get("languageID").getAsInt();

            String packageName;
            try {
                packageName = descriptionObject.get("packageName").getAsString();
            } catch (Exception e) {
                packageName = null;
            }

            String googleDescription;
            try {
                googleDescription = descriptionObject.get("googleDescription").getAsString();
            } catch (Exception e) {
                googleDescription = null;
            }

            String description;
            try {
                description = descriptionObject.get("description").getAsString();
            } catch (Exception e) {
                description = null;
            }

            String searchDescription = null;
            try {
                if (description != null) {
                    searchDescription = "";
                    JsonArray descriptionStrObjects = gson.fromJson(description, JsonArray.class);
                    if (descriptionStrObjects.size() > 0) {
                        // first E
                        JsonObject descriptionStr = descriptionStrObjects.get(0).getAsJsonObject();
                        String header = descriptionStr.get("header").getAsString();
                        String content = descriptionStr.get("description").getAsString();
                        if (header != null && content != null) {
                            searchDescription += header + " " + content;
                        }

                        for (int l = 1, max = descriptionStrObjects.size(); l < max; l++) {
                            descriptionStr = descriptionStrObjects.get(l).getAsJsonObject();
                            header = descriptionStr.get("header").getAsString();
                            content = descriptionStr.get("description").getAsString();
                            if (header != null && content != null) {
                                searchDescription += ";" + header + " " + content;
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }

            String advancedAddress;
            try {
                advancedAddress = descriptionObject.get("advancedAddress").getAsString();
            } catch (Exception e) {
                advancedAddress = null;
            }

            String searchPackageAddress = null;
            try {
                if (advancedAddress != null) {
                    searchPackageAddress = "";
                    JsonObject advancedAddressObj = gson.fromJson(advancedAddress, JsonObject.class);
                    JsonArray packageAddressObjs = advancedAddressObj.get("action").getAsJsonArray();
                    if (packageAddressObjs.size() > 0) {
                        // first E
                        JsonObject packageAddr = packageAddressObjs.get(0).getAsJsonObject();
                        String addr = packageAddr.get("addr").getAsString();
                        if (addr != null) {
                            searchPackageAddress += addr;
                        }

                        // others El
                        for (int l = 1, max = packageAddressObjs.size(); l < max; l++) {
                            JsonObject packageAddressObj = packageAddressObjs.get(l).getAsJsonObject();
                            packageAddr = packageAddressObj.getAsJsonObject();
                            addr = packageAddr.get("addr").getAsString();
                            if (addr != null) {
                                searchPackageAddress += ";" + addr;
                            }
                        }

                    }
                }
            } catch (Exception e) {
            }

            String keywords;
            try {
                keywords = descriptionObject.get("keywords").getAsString();
            } catch (Exception e) {
                keywords = null;
            }
            String keywordStrs = null;
            try {
                if (keywords != null) {
                    keywordStrs = "";
                    JsonArray keywordStrsArray = gson.fromJson(keywords, JsonArray.class);

                    if (keywordStrsArray.size() > 0) {
                        // first E
                        JsonObject keywordStrObj = keywordStrsArray.get(0).getAsJsonObject();
                        String keyword = keywordStrObj.get("text").getAsString();
                        if (keyword != null) {
                            keywordStrs += keyword;
                        }

                        for (int l = 1, max = keywordStrsArray.size(); l < max; l++) {
                            keywordStrObj = keywordStrsArray.get(l).getAsJsonObject();
                            keyword = keywordStrObj.get("text").getAsString();
                            if (keyword != null) {
                                keywordStrs += "," + keyword;
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }

            String language;
            try {
                language = descriptionObject.get("language").getAsString();
            } catch (Exception e) {
                language = null;
            }
            packageDAO.updateDescriptionFormOfTemporaryPackage(packageID, languageID, packageName, googleDescription, description,
                    advancedAddress, keywords, language, searchDescription, searchPackageAddress, keywordStrs, providerID);
        }

        // get list of amenities
        JsonArray amenitiesClassifier = dataJson.get("amenitiesClassifier").getAsJsonArray();
        for (JsonElement amenitiesClassifierElement : amenitiesClassifier) {
            // insert each amenities
            JsonObject amenitiesObject = amenitiesClassifierElement.getAsJsonObject();
            int amenitiesID = amenitiesObject.get("amenitiesID").getAsInt();
            int languageID = amenitiesObject.get("languageID").getAsInt();

            String description;
            try {
                description = amenitiesObject.get("description").getAsString();
            } catch (Exception e) {
                description = null;
            }
            temporaryAmenitiesClassifierDAO.updateAmeitiesClassifier(packageID, amenitiesID, languageID, description, providerID);
        }

        // get list of amenities
        JsonArray certificates = dataJson.get("certificates").getAsJsonArray();
        for (JsonElement certificate : certificates) {
            JsonObject certificateObject = certificate.getAsJsonObject();
            int certificateID = certificateObject.get("certificateID").getAsInt();
            temporaryPackageCertificatesDAO.updateNewCertificate(packageID, certificateID, providerID);
        }
    }

    @Override
    public void updateDescriptionFormOfPackage(String data, int providerID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        // get packageID
        int packageID = dataJson.get("packageID").getAsInt();

        // delete old data first
        String country = null;
        try {
            country = dataJson.get("country").getAsString();
        } catch (Exception e) {

        }

        String city = null;
        try {
            city = dataJson.get("city").getAsString();
        } catch (Exception e) {

        }
        packageDAO.deleteOldDescriptionFormPackage(packageID, country, city, providerID);

        // get list of language description
        JsonArray descriptions = dataJson.get("descriptions").getAsJsonArray();
        for (JsonElement descriptionElement : descriptions) {
            // insert each language
            JsonObject descriptionObject = descriptionElement.getAsJsonObject();
            int languageID = descriptionObject.get("languageID").getAsInt();

            String packageName;
            try {
                packageName = descriptionObject.get("packageName").getAsString();
            } catch (Exception e) {
                packageName = null;
            }

            String googleDescription;
            try {
                googleDescription = descriptionObject.get("googleDescription").getAsString();
            } catch (Exception e) {
                googleDescription = null;
            }

            String description;
            try {
                description = descriptionObject.get("description").getAsString();
            } catch (Exception e) {
                description = null;
            }

            String searchDescription = null;
            try {
                if (description != null) {
                    searchDescription = "";
                    JsonArray descriptionStrObjects = gson.fromJson(description, JsonArray.class);
                    if (descriptionStrObjects.size() > 0) {
                        // first E
                        JsonObject descriptionStr = descriptionStrObjects.get(0).getAsJsonObject();
                        String header = descriptionStr.get("header").getAsString();
                        String content = descriptionStr.get("description").getAsString();
                        if (header != null && content != null) {
                            searchDescription += header + " " + content;
                        }

                        for (int l = 1, max = descriptionStrObjects.size(); l < max; l++) {
                            descriptionStr = descriptionStrObjects.get(l).getAsJsonObject();
                            header = descriptionStr.get("header").getAsString();
                            content = descriptionStr.get("description").getAsString();
                            if (header != null && content != null) {
                                searchDescription += ";" + header + " " + content;
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }

            String advancedAddress;
            try {
                advancedAddress = descriptionObject.get("advancedAddress").getAsString();
            } catch (Exception e) {
                advancedAddress = null;
            }

            String searchPackageAddress = null;
            try {
                if (advancedAddress != null) {
                    searchPackageAddress = "";
                    JsonObject advancedAddressObj = gson.fromJson(advancedAddress, JsonObject.class);
                    JsonArray packageAddressObjs = advancedAddressObj.get("action").getAsJsonArray();
                    if (packageAddressObjs.size() > 0) {
                        // first E
                        JsonObject packageAddr = packageAddressObjs.get(0).getAsJsonObject();
                        String addr = packageAddr.get("addr").getAsString();
                        if (addr != null) {
                            searchPackageAddress += addr;
                        }

                        // others El
                        for (int l = 1, max = packageAddressObjs.size(); l < max; l++) {
                            JsonObject packageAddressObj = packageAddressObjs.get(l).getAsJsonObject();
                            packageAddr = packageAddressObj.getAsJsonObject();
                            addr = packageAddr.get("addr").getAsString();
                            if (addr != null) {
                                searchPackageAddress += ";" + addr;
                            }
                        }

                    }
                }
            } catch (Exception e) {
            }

            String keywords;
            try {
                keywords = descriptionObject.get("keywords").getAsString();
            } catch (Exception e) {
                keywords = null;
            }
            String keywordStrs = null;
            try {
                if (keywords != null) {
                    keywordStrs = "";
                    JsonArray keywordStrsArray = gson.fromJson(keywords, JsonArray.class);

                    if (keywordStrsArray.size() > 0) {
                        // first E
                        JsonObject keywordStrObj = keywordStrsArray.get(0).getAsJsonObject();
                        String keyword = keywordStrObj.get("text").getAsString();
                        if (keyword != null) {
                            keywordStrs += keyword;
                        }

                        for (int l = 1, max = keywordStrsArray.size(); l < max; l++) {
                            keywordStrObj = keywordStrsArray.get(l).getAsJsonObject();
                            keyword = keywordStrObj.get("text").getAsString();
                            if (keyword != null) {
                                keywordStrs += "," + keyword;
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }

            String language;
            try {
                language = descriptionObject.get("language").getAsString();
            } catch (Exception e) {
                language = null;
            }
            packageDAO.updateDescriptionFormOfPackage(packageID, languageID, packageName, googleDescription, description,
                    advancedAddress, keywords, language, searchDescription, searchPackageAddress, keywordStrs, providerID);
        }

        // get list of amenities
        JsonArray amenitiesClassifier = dataJson.get("amenitiesClassifier").getAsJsonArray();
        for (JsonElement amenitiesClassifierElement : amenitiesClassifier) {
            // insert each amenities
            JsonObject amenitiesObject = amenitiesClassifierElement.getAsJsonObject();
            int amenitiesID = amenitiesObject.get("amenitiesID").getAsInt();
            int languageID = amenitiesObject.get("languageID").getAsInt();

            String description;
            try {
                description = amenitiesObject.get("description").getAsString();
            } catch (Exception e) {
                description = null;
            }
            amenitiesClassifierDAO.updateAmeitiesClassifier(packageID, amenitiesID, languageID, description, providerID);
        }

        // get list of amenities
        JsonArray certificates = dataJson.get("certificates").getAsJsonArray();
        for (JsonElement certificate : certificates) {
            JsonObject certificateObject = certificate.getAsJsonObject();
            int certificateID = certificateObject.get("certificateID").getAsInt();
            packageCertificatesDAO.updateNewCertificate(packageID, certificateID, providerID);
        }
    }

    @Override
    public boolean updateExtrasOfTempPackage(String dataJson
    ) {
        ExtrasForm form = gson.fromJson(dataJson, ExtrasForm.class);
        int packageID = form.getPackageID();
        // delete old information and update new
        packageDAO.updateExtrasFormOfTempPackage(packageID, form.getIncluded(), form.getExcluded(), form.getCertificateID());

        // insert list amenities
//        List<AmenitiesDTO> listAmenities = form.getListAmenities();
//        for (AmenitiesDTO amenities : listAmenities) {
//            amenitiesDAO.insertAmenitiesOfTempPackage(packageID, amenities.getAmenitiesID());
//        }
        List<TemporaryAmenitiesClassifierDTO> amenitiesClassifiers = form.getAmenitiesClassifiers();
        for (TemporaryAmenitiesClassifierDTO amenitiesClassifier : amenitiesClassifiers) {
            temporaryAmenitiesClassifierDAO.insertNewAmenitiesClassifier(amenitiesClassifier);
        }

        // insert transportation ways
        List<TemporaryTransoprtationWayDTO> ways = form.getTransportationWays();
//            int othersID = 7;
        for (TemporaryTransoprtationWayDTO way : ways) {
            transporationDAO.insertOtherWayToTempPackage(way.getTemporaryPackageID(), way.getTransporattionID(), way.getContent());
        }

        return true;
    }

    @Override
    public boolean updateExtrasOfTempPackagev2(String dataJson
    ) {
        ExtrasForm form = gson.fromJson(dataJson, ExtrasForm.class);
        int packageID = form.getPackageID();
        // delete old information and update new
        packageDAO.updateExtrasFormOfTempPackagev2(packageID, form.getIncluded(), form.getExcluded(), form.getCertificateID());

        // insert list amenities
//        List<AmenitiesDTO> listAmenities = form.getListAmenities();
//        for (AmenitiesDTO amenities : listAmenities) {
//            amenitiesDAO.insertAmenitiesOfTempPackage(packageID, amenities.getAmenitiesID());
//        }
        List<TemporaryAmenitiesClassifierDTO> amenitiesClassifiers = form.getAmenitiesClassifiers();
        for (TemporaryAmenitiesClassifierDTO amenitiesClassifier : amenitiesClassifiers) {
            temporaryAmenitiesClassifierDAO.insertNewAmenitiesClassifierv2(amenitiesClassifier);
        }

        // insert transportation ways
        List<TemporaryTransoprtationWayDTO> ways = form.getTransportationWays();
//            int othersID = 7;
        for (TemporaryTransoprtationWayDTO way : ways) {
            transporationDAO.insertOtherWayToTempPackagev2(way.getTemporaryPackageID(), way.getTransporattionID(), way.getContent());
        }

        return true;
    }

    @Override
    public boolean editExtrasOfPackage(String dataJson
    ) {
        // get data from json
        JsonObject object = gson.fromJson(dataJson, JsonObject.class);
        String include = object.get("included").getAsString();
        String exclude = object.get("excluded").getAsString();
        String amenities = object.get("listAmenities").getAsString();
        String ways = object.get("transportationWays").getAsString();
        int packageID = object.get("packageID").getAsInt();

        // call DAO to edit
        packageDAO.editExtrasOfPackage(packageID, include, exclude, amenities, ways);
        return true;
    }

    @Override
    public boolean updateCoverAndPhotoOfTempPackage(String type, String dataJson, int providerID) {
        Type listType = new TypeToken<List<AdditionImageDTO>>() {
        }.getType();
        JsonObject object = gson.fromJson(dataJson, JsonObject.class);
        int packageID = object.get("packageID").getAsInt();
        String Typename = type.substring(type.lastIndexOf(".") + 1);
        // cover information
        String coverImage = null;
        try {
            coverImage = "/Images/TemporaryPackages/" + packageID + "/cover." + Typename;

        } catch (Exception e) {
        }
        double coverPosition = object.get("coverPosition").getAsDouble();

        List<AdditionImageDTO> images = gson.fromJson(object.get("additionalImages").getAsString(), listType);

        return packageDAO.updateCoverAndPhotosOfTempPackage(packageID, coverImage, images, coverPosition, providerID);
    }

    @Override
    public boolean updateCoverAndPhotoOfTempPackagev2(String dataJson, int providerID
    ) {
        Type listType = new TypeToken<List<AdditionImageDTO>>() {
        }.getType();
        JsonObject object = gson.fromJson(dataJson, JsonObject.class);

        // cover information
        String coverImage = object.get("coverImage").getAsString();
        double coverPosition = object.get("coverPosition").getAsDouble();

        List<AdditionImageDTO> images = gson.fromJson(object.get("additionalImages").getAsString(), listType);
        int packageID = object.get("packageID").getAsInt();
        return packageDAO.updateCoverAndPhotosOfTempPackagev2(packageID, coverImage, images, coverPosition, providerID);
    }

    @Override
    public boolean editPhotoOfPackage(String type, String dataJson, int providerID
    ) {
        Type listType = new TypeToken<List<AdditionImageDTO>>() {
        }.getType();

        JsonObject object = gson.fromJson(dataJson, JsonObject.class);
        String Typename = type.substring(type.lastIndexOf(".") + 1);

        int packageID = object.get("packageID").getAsInt();
        // cover information
        String coverImage = null;
        try {
            coverImage = "/Images/PrimaryPackages/" + packageID + "/cover." + Typename;
        } catch (Exception e) {
        }
        double coverPosition = object.get("coverPosition").getAsDouble();

        List<AdditionImageDTO> images = gson.fromJson(object.get("additionalImages").getAsString(), listType);

        return packageDAO.updateCoverAndPhotosOfTempPackagev2(packageID, coverImage, images, coverPosition, providerID);
    }

    @Override
    public boolean updateLocationOfTemPackage(String dataJson
    ) {
        JsonObject object = gson.fromJson(dataJson, JsonObject.class);
        int packageID = object.get("packageID").getAsInt();
        String country = object.get("country").getAsString();
        String city = object.get("city").getAsString();
        String state = object.get("state").getAsString();
        String coordinate = object.get("coordinates").getAsString();
        String[] LatLng = coordinate.split(",");
        BigDecimal lat = new BigDecimal(LatLng[0]);

        BigDecimal lng = new BigDecimal(LatLng[1]);
//        String packageAddress = object.get("packageAddress").getAsString();
        String additionalAddress = object.get("additionalAddress").getAsString();
        return packageDAO.updateLocationOfTemPackage(packageID, country, city, state, coordinate, "", additionalAddress, lat, lng);
    }

    @Override
    public boolean updateLocationOfTemPackagev2(String dataJson
    ) {
        JsonObject object = gson.fromJson(dataJson, JsonObject.class);
        int packageID = object.get("packageID").getAsInt();
        String country = object.get("country").getAsString();
        String city = object.get("city").getAsString();
        String state = object.get("state").getAsString();
        String coordinate = object.get("coordinates").getAsString();
        String[] LatLng = coordinate.split(",");
        BigDecimal lat = new BigDecimal(LatLng[0]);

        BigDecimal lng = new BigDecimal(LatLng[1]);
//        String packageAddress = object.get("packageAddress").getAsString();
        String additionalAddress = object.get("additionalAddress").getAsString();
        return packageDAO.updateLocationOfTemPackagev2(packageID, country, city, state, coordinate, "", additionalAddress, lat, lng);
    }

    @Override
    public boolean editLocationOfPackage(String dataJson
    ) {
        JsonObject object = gson.fromJson(dataJson, JsonObject.class);
        int packageID = object.get("packageID").getAsInt();
        String country = object.get("country").getAsString();
        String city = object.get("city").getAsString();
        String state = object.get("state").getAsString();
        String coordinate = object.get("coordinates").getAsString();
        packageDAO.editLocationOfPackage(packageID, country, city, state, coordinate);
        return true;
    }

    @Override
    public boolean updatePriceOfTemPackage(String dataJson, int providerID
    ) {
        JsonObject object = gson.fromJson(dataJson, JsonObject.class);
        int packageID = object.get("packageID").getAsInt();

        double youtripperPrice = 0;
        try {
            youtripperPrice = object.get("youtripperPrice").getAsDouble();
        } catch (UnsupportedOperationException e) {
            youtripperPrice = 0;
        }

        String freeCondition = "";
        try {
            freeCondition = object.get("freeCondition").getAsString();
        } catch (UnsupportedOperationException e) {
            freeCondition = "";
        }
        String packageType = object.get("packageType").getAsString();


        String priceCurrency = object.get("priceCurrency").getAsString();
        int minTripper = 0;
        try {
           minTripper = object.get("minTripper").getAsInt();
        } catch (Exception e) {
        }
        int maxTripper = 0;
        try {
           maxTripper = object.get("maxTripper").getAsInt();
        } catch (Exception e) {
        }

        String childrenDiscounts = object.get("childrenDiscounts").getAsString();
        String cancellationPolicy = object.get("cancellationPolicy").getAsString();
        int noCancellationPrice = object.get("noCancellationPercent").getAsInt();

        return packageDAO.updatePriceOfTemPackage(packageID, youtripperPrice, priceCurrency, cancellationPolicy, childrenDiscounts, noCancellationPrice, providerID,freeCondition,packageType,minTripper,
        maxTripper);
    }

    @Override
    public boolean editPriceOfPackage(String dataJson, int providerID
    ) {
        JsonObject object = gson.fromJson(dataJson, JsonObject.class);
        int packageID = object.get("packageID").getAsInt();

        double adultPrice = 0;
        try {
            adultPrice = object.get("ordinaryPriceForAdult").getAsDouble();
        } catch (UnsupportedOperationException e) {
            adultPrice = 0;
        }
        double youtripperPrice = 0;
        try {
            youtripperPrice = object.get("youtripperPrice").getAsDouble();
        } catch (UnsupportedOperationException e) {
            youtripperPrice = 0;
        }
        String priceCurrency = object.get("priceCurrency").getAsString();

        int percentage = object.get("youtripperPercentage").getAsInt();
        int noCancellationPercent = object.get("noCancellationPercent").getAsInt();
        String childrenDiscountJson = object.get("childrenDiscounts").getAsString();
        String cancellationPolicyJson = object.get("cancellationPolicy").getAsString();

        return packageDAO.updatePriceOfMainPackage(packageID, adultPrice, youtripperPrice, priceCurrency, percentage, noCancellationPercent,
                providerID, childrenDiscountJson, cancellationPolicyJson);
    }

    @Override
    public boolean updatePromotionOfTempPackage(String dataJson
    ) {
        JsonObject object = gson.fromJson(dataJson, JsonObject.class);
        int packageID = object.get("packageID").getAsInt();
        String startDate = object.get("startDate").getAsString();
        String endDate = object.get("endDate").getAsString();
        String promotionJson = object.get("promotionJson").getAsString();
        String unavailableDays = object.get("unavailableDays").getAsString();
        int sequentialOperation = Integer.parseInt(object.get("sequentialOperation").getAsString().replaceAll("\"", ""));
        return packageDAO.updatePromotionOfTempPackage(packageID, startDate, endDate, promotionJson, unavailableDays, sequentialOperation);
    }

    @Override
    public boolean editPromotionOfPackage(String dataJson
    ) {
        JsonObject object = gson.fromJson(dataJson, JsonObject.class);
        int packageID = object.get("packageID").getAsInt();
        String startDate = object.get("startDate").getAsString();
        String endDate = object.get("endDate").getAsString();
        String promotionJson = object.get("promotionJson").getAsString();
        String unavailableDays = object.get("unavailableDays").getAsString();
        packageDAO.editPromotionOfPackage(packageID, startDate, endDate, promotionJson, unavailableDays);
        return true;
    }

    @Override
    public String getTemporaryPackageForPreviewing(int temporaryPackageID, boolean isFinished) {
        TemporaryPackageDTO packageDTO = packageDAO.getTemporaryPackageForPreview(temporaryPackageID);
        boolean isValid = true;

        // validate temporary package
        if (isFinished) {

        }

        if (isValid) { // valid then return json
            return gson.toJson(packageDTO);
        } else { // if not return fail
            return "fail";
        }
    }

    @Override
    public String getTemporaryPackageForPreviewingv2(int temporaryPackageID, boolean isFinished
    ) {
        PackageDTO packageDTO = packageDAO.getTemporaryPackageForPreviewv2(temporaryPackageID);
        boolean isValid = true;

        // validate temporary package
        if (isFinished) {
//            if (packageDTO.getName().isEmpty() || packageDTO.getGoogleDescription().isEmpty() || packageDTO.getMainDescription().isEmpty()
//                    || packageDTO.getDuration() <= 0 || packageDTO.getDepartureTime().isEmpty() || packageDTO.getDepartureLocation().isEmpty()
//                    || packageDTO.getKeywords().isEmpty() || packageDTO.getLanguage().isEmpty() || packageDTO.getCoverImage().isEmpty()
//                    || packageDTO.getCountry().isEmpty() || packageDTO.getCity().isEmpty() || (!packageDTO.isIsPrivateTour() && packageDTO.getOrdinaryPriceForChild() <= 0)
//                    || packageDTO.getOrdinaryPriceForAdult() <= 0 || packageDTO.getStartDate().isEmpty() || packageDTO.getEndDate().isEmpty()
//                    || packageDTO.getActivites() == null || packageDTO.getActivites().size() <= 0 || packageDTO.getListAmenities() == null
//                    || packageDTO.getListAmenities().size() <= 0 || packageDTO.getTransporations() == null || packageDTO.getTransporations().size() <= 0) {
//                isValid = false;
//            }
        }

        if (isValid) { // valid then return json
            return gson.toJson(packageDTO);
        } else { // if not return fail
            return "fail";
        }
    }

    @Override
    public String removeAdditionalImage(String data
    ) {
        // parse string to json
        Type listType = new TypeToken<List<AdditionImageDTO>>() {
        }.getType();
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String deletedImage = jsonObject.get("deletedImage").getAsString();
//        int deletedPosition = jsonObject.get("deletedPosition").getAsInt();
//        JsonElement imagesJson = jsonObject.get("images");
        int packageID = jsonObject.get("packageID").getAsInt();
//        List<AdditionImage> images = gson.fromJson(imagesJson, listType);
        String path = System.getProperty("catalina.base");
        File deletedFile = new File(path + "/webapps" + deletedImage);
        if (deletedFile.exists()) {
            deletedFile.delete();
        }
//        String newImages = gson.toJson(images);
        deleteAdditionalImage(deletedImage, packageID);
        return "true";
    }

    @Override
    public String removeAdditionalImagePackage(String data
    ) {
        // parse string to json
        Type listType = new TypeToken<List<AdditionImageDTO>>() {
        }.getType();
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String deletedImage = jsonObject.get("deletedImage").getAsString();
//        int deletedPosition = jsonObject.get("deletedPosition").getAsInt();
//        JsonElement imagesJson = jsonObject.get("images");
        int packageID = jsonObject.get("packageID").getAsInt();
//        List<AdditionImage> images = gson.fromJson(imagesJson, listType);
        String path = System.getProperty("catalina.base");
        File deletedFile = new File(path + "/webapps" + deletedImage);
        if (deletedFile.exists()) {
            deletedFile.delete();
        }
//        String newImages = gson.toJson(images);
        deleteAdditionalImagePackage(deletedImage, packageID);
        return "true";
    }

    @Override
    public String removeAdditionalImagev2(String data
    ) {
        // parse string to json
        Type listType = new TypeToken<List<AdditionImageDTO>>() {
        }.getType();
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String deletedImage = jsonObject.get("deletedImage").getAsString();
//        int deletedPosition = jsonObject.get("deletedPosition").getAsInt();
//        JsonElement imagesJson = jsonObject.get("images");
        int packageID = jsonObject.get("packageID").getAsInt();
//        List<AdditionImage> images = gson.fromJson(imagesJson, listType);
        String path = System.getProperty("catalina.base");
        File deletedFile = new File(path + "/webapps" + deletedImage);
        if (deletedFile.exists()) {
            deletedFile.delete();
        }
//        String newImages = gson.toJson(images);
        deleteAdditionalImagev2(deletedImage, packageID);
        return "true";
    }

    @Override
    public boolean updateAdditionImage(int packageID, List<AdditionImageDTO> images
    ) {
        return packageDAO.updateAdditionalImage(packageID, images);
    }

    @Override
    public boolean updateAdditionImagePackage(int packageID, List<AdditionImageDTO> images
    ) {
        return packageDAO.updateAdditionalImagePackage(packageID, images);
    }

    @Override
    public boolean updateAdditionImagev2(int packageID, List<AdditionImageDTO> images
    ) {
        return packageDAO.updateAdditionalImagev2(packageID, images);
    }

    @Override
    public String uploadAdditionalImagesPackage(MultipartFile[] additionalImages, int packageID, String imagesJson) throws IOException {

        List<AdditionImageDTO> images;
        List<AdditionImageDTO> images2 = new ArrayList<AdditionImageDTO>();
        Type listType = new TypeToken<List<AdditionImageDTO>>() {
        }.getType();
        images = gson.fromJson(imagesJson, listType);

        String path = System.getProperty("catalina.base");
        File folderPackage = new File(path + "/webapps/Images/PrimaryPackages/" + packageID);
        if (!folderPackage.exists()) {
            folderPackage.mkdirs();
        }
//        int maximumNumber = images.getMaximumNumber();
        for (MultipartFile additionalImage : additionalImages) {
            int randomNum = 1000 + (int) (Math.random() * 9999);
            boolean checkExist = checkImageExist(String.valueOf(randomNum), packageID);
            while (checkExist == true) {
                randomNum = 1000 + (int) (Math.random() * 9999);
                checkExist = checkImageExist(String.valueOf(randomNum), packageID);
            }
            String name = String.valueOf(randomNum) + "." + FilenameUtils.getExtension(additionalImage.getOriginalFilename());
            FileCopyUtils.copy(additionalImage.getBytes(), new FileOutputStream(new File(folderPackage, name)));
            AdditionImageDTO additionalImageClass = new AdditionImageDTO("/Images/PrimaryPackages/" + packageID + "/" + name, "");
            images.add(additionalImageClass);
            images2.add(additionalImageClass);
        }
//        images.setMaximumNumber(maximumNumber);
        imagesJson = gson.toJson(images2);
        updateAdditionImagePackage(packageID, images2);

        return imagesJson;

    }

    @Override
    public String uploadAdditionalImages(MultipartFile[] additionalImages, int temporaryPackageID, String imagesJson) throws IOException {

        List<AdditionImageDTO> images;
        List<AdditionImageDTO> images2 = new ArrayList<AdditionImageDTO>();
        Type listType = new TypeToken<List<AdditionImageDTO>>() {
        }.getType();
        images = gson.fromJson(imagesJson, listType);

        String path = System.getProperty("catalina.base");
        File folderPackage = new File(path + "/webapps/Images/TemporaryPackages/" + temporaryPackageID);
        if (!folderPackage.exists()) {
            folderPackage.mkdirs();
        }
//        int maximumNumber = images.getMaximumNumber();
        for (MultipartFile additionalImage : additionalImages) {
            int randomNum = 1000 + (int) (Math.random() * 9999);
            boolean checkExist = checkImageExist(String.valueOf(randomNum), temporaryPackageID);
            while (checkExist == true) {
                randomNum = 1000 + (int) (Math.random() * 9999);
                checkExist = checkImageExist(String.valueOf(randomNum), temporaryPackageID);
            }
            String name = String.valueOf(randomNum) + "." + FilenameUtils.getExtension(additionalImage.getOriginalFilename());
            FileCopyUtils.copy(additionalImage.getBytes(), new FileOutputStream(new File(folderPackage, name)));
            AdditionImageDTO additionalImageClass = new AdditionImageDTO("/Images/TemporaryPackages/" + temporaryPackageID + "/" + name, "");
            images.add(additionalImageClass);
            images2.add(additionalImageClass);
        }
//        images.setMaximumNumber(maximumNumber);
        imagesJson = gson.toJson(images2);
        updateAdditionImage(temporaryPackageID, images2);

        return imagesJson;

    }

    @Override
    public String uploadAdditionalImagesv2(MultipartFile[] additionalImages, int temporaryPackageID, String imagesJson) throws IOException {
        List<AdditionImageDTO> images;
        List<AdditionImageDTO> images2 = new ArrayList<AdditionImageDTO>();
        Type listType = new TypeToken<List<AdditionImageDTO>>() {
        }.getType();
        images = gson.fromJson(imagesJson, listType);
        String path = System.getProperty("catalina.base");
        File folderPackage = new File(path + "/webapps/Imagesv2/" + temporaryPackageID);
        if (!folderPackage.exists()) {
            folderPackage.mkdirs();
        }
//        int maximumNumber = images.getMaximumNumber();
        for (MultipartFile additionalImage : additionalImages) {
            int randomNum = 1000 + (int) (Math.random() * 9999);
            boolean checkExist = checkImageExist(String.valueOf(randomNum), temporaryPackageID);
            while (checkExist == true) {
                randomNum = 1000 + (int) (Math.random() * 9999);
                checkExist = checkImageExist(String.valueOf(randomNum), temporaryPackageID);
            }
            String name = String.valueOf(randomNum) + "." + FilenameUtils.getExtension(additionalImage.getOriginalFilename());
            FileCopyUtils.copy(additionalImage.getBytes(), new FileOutputStream(new File(folderPackage, name)));
            AdditionImageDTO additionalImageClass = new AdditionImageDTO("/Imagesv2/" + temporaryPackageID + "/" + name, "");
            images.add(additionalImageClass);
            images2.add(additionalImageClass);
        }
//        images.setMaximumNumber(maximumNumber);
        imagesJson = gson.toJson(images2);
        updateAdditionImagev2(temporaryPackageID, images2);

        return imagesJson;

    }

    @Override
    public ProviderDTO getPhoneNumber(int providerID
    ) {
        return providerDAO.getPhoneNumber(providerID);
    }

    @Override
    public String getSMSCode(int providerID, String phoneCode, String phoneNumber
    ) {
        return providerDAO.getSMSCode(providerID, phoneCode, phoneNumber);
    }

    @Override
    public String verifySMS(int providerID, String smsCode
    ) {
        return providerDAO.verifySMS(providerID, smsCode);
    }

    @Override
    public ProviderDTO getAccountInfo(int providerID
    ) {
        return providerDAO.getAccountInfo(providerID);
    }

    @Override
    public int getReferralCount(int providerID
    ) {
        return providerDAO.getReferralCount(providerID);
    }

    @Override
    public String getReferralList(int providerID) {
        return gson.toJson(providerDAO.getReferralInfo(providerID));
    }

    @Override
    public List<PackageDTO> getPackageForStatictis(int providerID
    ) {
        List<PackageDTO> listPackage = packageDAO.getAllPackageForStatictis(providerID);
        HashMap<Integer, List<BookingDTO>> bookingHashMap = new HashMap<>();
//            for (int i = 0; i < listBooking.size(); i++) {
//                if (!bookingHashMap.containsKey(listBooking.get(i).getPackageID())) {
//                    List<BookingDTO> newBooking = new ArrayList<BookingDTO>();
//                    newBooking.add(listBooking.get(i));
//                    bookingHashMap.put(listBooking.get(i).getPackageID(), newBooking);
//                } else {
//                    List<BookingDTO> existBooking = bookingHashMap.get(listBooking.get(i).getPackageID());
//                    existBooking.add(listBooking.get(i));
//                    bookingHashMap.put(listBooking.get(i).getPackageID(), existBooking);
//                }
//            }
//            for (Integer i : bookingHashMap.keySet()) {
//               for(int k = 0 ; k < listPackage.size();k++){
//                   if(listPackage.get(k).getId()== i){
//                       listPackage.get(k).setListBooking(bookingHashMap.get(i));
//                   }
//               }
//            }
        return listPackage;

    }

    @Override
    public String getBookingForStatictis(int packageID
    ) {
        List<BookingDTO> listBooking = bookingDAO.getBookingListForStatictis(packageID);
        HashMap<String, BookingStatistics> bookingHashMap = new HashMap<>();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date currentDate = new Date();
        dateFormat.format(currentDate);

        for (int i = 0; i < listBooking.size(); i++) {
            String bookingDate = listBooking.get(i).getBookingDate().substring(0, 10);
            if (!bookingHashMap.containsKey(bookingDate)) {
                int completed = 0;
                int pending = 0;
                Date selectDate = new Date(listBooking.get(i).getSelectedDate());
                if (currentDate.after(selectDate)) {
                    completed++;
                } else {
                    pending++;
                }
                BookingStatistics newBooking = new BookingStatistics(1, listBooking.get(i).getNumberOfAdults() + listBooking.get(i).getNumberOfChilds(), listBooking.get(i).getMaxQuota(), pending, completed);

                bookingHashMap.put(bookingDate, newBooking);
            } else {
                int numberOfBooking = bookingHashMap.get(bookingDate).getNumberOfBooking();
                int completed = bookingHashMap.get(bookingDate).getCompleted();
                int pending = bookingHashMap.get(bookingDate).getPending();
                int numberOfTripper = bookingHashMap.get(bookingDate).getNumberOfTripper();
                Date selectDate = new Date(listBooking.get(i).getSelectedDate());
                if (currentDate.after(selectDate)) {
                    completed++;
                } else {
                    pending++;
                }
                BookingStatistics newBooking = new BookingStatistics(numberOfBooking + 1, numberOfTripper + listBooking.get(i).getNumberOfAdults() + listBooking.get(i).getNumberOfChilds(), listBooking.get(i).getMaxQuota(), pending, completed);

                bookingHashMap.put(bookingDate, newBooking);
            }
        }
        return gson.toJson(bookingHashMap);
    }

    @Override
    public SaleInfo getSaleInfo(int providerID
    ) {
        return bookingDAO.getSaleInfo(providerID);
    }

    @Override
    public List<ProviderNotification> getProviderNotification() {
        return providerNotificationDAO.getProviderNotification();
    }

    @Override
    public List<ProviderNotificationSetting> getProviderNotificationSetting(int providerID
    ) {
        return providerNotificationDAO.getProviderNotificationSetting(providerID);
    }

    @Override
    public boolean saveSetting(int providerID, String settingValue
    ) {
        Type typeOfT = new TypeToken<List<Integer>>() {
        }.getType();
        List<Integer> settings = gson.fromJson(settingValue, typeOfT);
        providerNotificationDAO.deleteSetting(providerID);
        for (int i = 0; i < settings.size(); i++) {
            providerNotificationDAO.saveSetting(providerID, settings.get(i));
        }
        return true;
    }

    @Override
    public boolean checkValidatePhoneNumber(int providerID
    ) {
        return providerDAO.checkVerifyPhoneNumber(providerID);
    }

    @Override
    public boolean updateProviderImage(int providerID, String image
    ) {
        return providerDAO.updateProviderImage(providerID, image);
    }

    @Override
    public String cropAndSaveProviderImage(String data, int providerID, FileMeta imageMeta) throws IOException {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        // get data from json
        int positionX = jsonObject.get("positionX").getAsInt();
        int positionY = jsonObject.get("positionY").getAsInt();
        int imageWidth = jsonObject.get("width").getAsInt();
        int imageHeight = jsonObject.get("height").getAsInt();
        int cropWidth = jsonObject.get("cropWidth").getAsInt();
        int cropHeight = jsonObject.get("cropHeight").getAsInt();

        // transform crop into current crop
        byte[] imageInByte = imageMeta.getBytes();
        InputStream in = new ByteArrayInputStream(imageInByte);
        BufferedImage bImageFromConvert = ImageIO.read(in);
        int currentImageWidth = bImageFromConvert.getWidth();
        int currentImageHeight = bImageFromConvert.getHeight();
        int newPositionX = currentImageWidth * positionX / imageWidth;
        int newPositionY = currentImageHeight * positionY / imageHeight;
        int widthRatio = currentImageWidth * cropWidth / imageWidth;
        int heightRatio = currentImageHeight * cropHeight / imageHeight;

        // then crop
        BufferedImage croppedImage = bImageFromConvert.getSubimage(newPositionX, newPositionY, widthRatio, heightRatio);

        // get name to save
        String extension = FilenameUtils.getExtension(imageMeta.getFileName());
        String name = "provider." + extension;

        String path = System.getProperty("catalina.base");
        File folderPackage = new File(path + "/webapps/Images/Provider/" + providerID);
        if (!folderPackage.exists()) {
            folderPackage.mkdirs();
        }
        ImageIO.write(croppedImage, extension, new File(folderPackage, name));

        String image = "Images/Provider/" + providerID + "/" + name;
        providerDAO.updateProviderImage(providerID, image);
        return image;
    }

    @Override
    public String updateProviderPassportImage(int providerID, MultipartFile providerImage) {
        String path = System.getProperty("catalina.base");
        File folderPackage = new File(path + "/webapps/Images/Provider/" + providerID);
        if (!folderPackage.exists()) {
            folderPackage.mkdirs();
        }
        String name = "passport." + FilenameUtils.getExtension(providerImage.getOriginalFilename());
        try {
            FileCopyUtils.copy(providerImage.getBytes(), new FileOutputStream(new File(folderPackage, name)));
        } catch (IOException ex) {
            Logger.getLogger(ProviderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String image = "Images/Provider/" + providerID + "/" + name;
        String uploadTime = String.valueOf(System.currentTimeMillis());

        providerDAO.updateProviderPassportImage(providerID, image, uploadTime);
        return image;
    }

    @Override
    public boolean updateCertificateImage(int providerID, String image) {
        return providerDAO.updateCertificateImage(providerID, image);
    }

    @Override
    public AccountSession updateProviderInformation(HttpServletRequest request, HttpSession session
    ) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        String information = request.getParameter("information");
        String interests = request.getParameter("interests");
        String taxnumber = request.getParameter("taxnumber");
        String language = request.getParameter("language");
        String notificationStr = request.getParameter("notification");
        if (firstName.equals("") || lastName.equals("")) {
            return null;
        }
        boolean notification = false;
        if (!notificationStr.equals("false")) {
            notification = true;
        }
        AccountSession account = (AccountSession) session.getAttribute("account");
        int providerID = account.getId();
        return providerDAO.updateProviderInformation(firstName, lastName, information, interests, taxnumber, language, providerID, notification);
    }

    @Override
    public boolean updateCertificateInformation(HttpServletRequest request, HttpSession session) {
        String Name = request.getParameter("Name");
        if (Name.equals("")) {
            return false;
        }
//        AccountSession account = (AccountSession) session.getAttribute("account");
//        int providerID = account.getId();

        String CertificateIDString = request.getParameter("CertificateID");

        int CertificateID = Integer.parseInt(CertificateIDString);

        return providerDAO.updateCertificateInformation(Name, CertificateID);
    }

    @Override
    public boolean updateCertificateUpdate(int CertificateID) {

        return providerDAO.updateCertificateStatus(CertificateID);
    }

    @Override
    public boolean changeProviderPassword(int providerID, String oldPassword, String newPassword
    ) {
        return providerDAO.changeProviderPassword(providerID, oldPassword, newPassword);

    }

    @Override
    public boolean isVerifyPhoneNumber(int providerID
    ) {
        return providerDAO.isVerifyPhoneNumber(providerID);
    }

    @Override
    public boolean insertNewProviderSystemNotification(String content, boolean seen, int providerID
    ) {
        return providerSystemNotificationDAO.insertNewProviderSystemNotification(content, seen, providerID);
    }

    @Override
    public String getProviderNewNotification(int providerID
    ) {
        return gson.toJson(providerSystemNotificationDAO.getProviderNewNotification(providerID));
    }

    @Override
    public boolean seenNotification(int notificationID
    ) {
        return providerSystemNotificationDAO.seenNotification(notificationID);
    }

    @Override
    public String getBookings(int packageID, int providerID) throws ParseException {
        List<BookingDetailAllDate> bookingDates = packageDAO.getBookingsForManagement(packageID, providerID);
        HashMap<String, BookingDetailAllDate> bookingsOverview = new HashMap<>();
        DateFormat fromFormat = new SimpleDateFormat("MM/dd/yyyy");
        fromFormat.setLenient(false);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        if (bookingDates != null) {
            for (BookingDetailAllDate bookingDate : bookingDates) {
                if (bookingDate.getNoBookings() > 0) {
                    Date date = fromFormat.parse(bookingDate.getSelectedDate());
                    String tripStart = dateFormat.format(date);
                    bookingsOverview.put(tripStart, bookingDate);
                }
            }
        }
        return gson.toJson(bookingsOverview);
    }

    @Override
    public String getDateBookingDetail(int providerID, int packageID, String data) throws ParseException {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String selectedDate = jsonObject.get("selectedDate").getAsString();
//        DateFormat fromFormat = new SimpleDateFormat("dd/MM/yyyy");
//        fromFormat.setLenient(false);
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        dateFormat.setLenient(false);
//        Date date = fromFormat.parse(selectedDate);
//        selectedDate = dateFormat.format(date);
        HashMap<Integer, String> packages = new HashMap<>();
        List<DateBookingDetail> details = packageDAO.getDateBookingDetail(providerID, packageID, selectedDate);
        for (DateBookingDetail detail : details) {
            packages.put(detail.getPackageID(), detail.getPackageName());
        }
        BookingUserList users = new BookingUserList(packages, details);
        return gson.toJson(users);
    }

    @Override
    public String getAllPackageOfProviderWithName(int providerID
    ) {
        return gson.toJson(packageDAO.getPackagesBelongToProviderWithName(providerID));
    }

    @Override
    public String getSales(String data, int providerID) throws ParseException {
        int packageID;
        Date fromDate;
        Date toDate;
        Calendar calendar = Calendar.getInstance();
        DateFormat MMddyyyyFormat = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat ddMMyyyyFormat = new SimpleDateFormat("dd/MM/yyyy");
        ddMMyyyyFormat.setLenient(false);
        if (data == null) {
            packageID = 0;
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            fromDate = calendar.getTime();
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            toDate = calendar.getTime();
        } else {
            JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
            String fromDateStr = jsonObject.get("fromDate").getAsString();
            String toDateStr = jsonObject.get("toDate").getAsString();
            packageID = jsonObject.get("packageID").getAsInt();
            fromDate = MMddyyyyFormat.parse(fromDateStr);
            toDate = MMddyyyyFormat.parse(toDateStr);
        }
        List<BookingDTO> bookings = bookingDAO.getSales(packageID, providerID);
        List<Sale> sales = new ArrayList<Sale>();
        Date toDay = new Date();
        DateFormat MMddyyyyHHmmssFormat = new SimpleDateFormat("MM/dd/yyyy HH:ss:mm");
        MMddyyyyFormat.setLenient(false);
        for (BookingDTO booking : bookings) {
            String bookingDateStr = booking.getBookingDate().substring(0, 10);
            Date bookingDate = MMddyyyyFormat.parse(bookingDateStr);
            if (bookingDate.compareTo(fromDate) >= 0 && bookingDate.compareTo(toDate) <= 0) {
                int tripperID = booking.getTripperID();
                String tripperName = booking.getTripperFirstName() + " " + booking.getTripperLastName();
                int mainPackageID = booking.getPackageID();
                String packageName = booking.getPackageName();
                int status;
                String paidDateStr = booking.getPaid();
                if (paidDateStr != null && !paidDateStr.equals("none")) {
                    status = 1;
                } else {
                    status = 4;
                }
                double revenue = (booking.getAdultPrice() * booking.getNumberOfAdults() + booking.getChildPrice() * booking.getNumberOfChilds()) * (100 - booking.getYouTripperPercentage() - booking.getProfitPercentage()) / 100;
                Sale sale = new Sale(bookingDateStr, tripperID, tripperName, mainPackageID, packageName, status, revenue);
                sales.add(sale);
            }
        }
        return gson.toJson(sales);
    }

    @Override
    public String getBookingDetail(String data
    ) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String bookingCode = jsonObject.get("bookingCode").getAsString();
        return gson.toJson(bookingDAO.getBookingDetail(bookingCode));
    }

    @Override
    public boolean seenMessage(int providerID
    ) {
        return providerSystemNotificationDAO.seenMessage(providerID);
    }

    @Override
    public String getPackageForEdit(int packageID
    ) {
        return gson.toJson(packageDAO.getPackageForEdit(packageID));
    }

    @Override
    public boolean deletePackage(int packageID
    ) {
        return packageDAO.deletePackage(packageID);
    }

    @Override
    public boolean checkImageExist(String name, int temporaryPackageID
    ) {
        return packageDAO.checkImageExist(name, temporaryPackageID);
    }

    @Override
    public boolean deleteAdditionalImage(String image, int temporaryPackageID
    ) {
        return packageDAO.deleteAdditionImage(image, temporaryPackageID);
    }

    @Override
    public boolean deleteAdditionalImagePackage(String image, int temporaryPackageID
    ) {
        return packageDAO.deleteAdditionImagePackage(image, temporaryPackageID);
    }

    @Override
    public boolean deleteAdditionalImagev2(String image, int temporaryPackageID
    ) {
        return packageDAO.deleteAdditionImagev2(image, temporaryPackageID);
    }

    @Override
    public boolean deleteCertificate(int CertificateID, HttpSession session) {
        AccountSession account = (AccountSession) session.getAttribute("account");
        String path1 = System.getProperty("catalina.base");
        String path2 = bucketListDAO.getCertificateURL(CertificateID);
        String path = path1 + "/webapps" + path2;
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            out.write("aString1\n");
            out.close();
            boolean success = (new File(path)).delete();
            BufferedReader in = new BufferedReader(new FileReader(path));
            in.close();
        } catch (IOException e) {
            System.out.println("exception occoured" + e);
        }

        return bucketListDAO.deleteCertificate(CertificateID);
    }

    @Override
    public String insertNewCertificate(String data, FileMeta certificateImage, int providerID) throws FileNotFoundException, IOException {
        // get data from json
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String name = jsonObject.get("name").getAsString();

        // initiate instance to store image
        Random rnd = new Random();
        StringBuilder sb;
        String code;

        // create folder certificate if not exist
        String path = System.getProperty("catalina.base");
        String image = "/Images/Provider/" + providerID + "/Certificate";
        File folderPackage = new File(path + "/webapps" + image);
        if (!folderPackage.exists()) {
            folderPackage.mkdirs();
        }

        // store file to created folder
        String imageName;

        // get file type (Png/jpeg..)
        String imageType = FilenameUtils.getExtension(certificateImage.getFileName());
        do { // check random name is exist or not
            sb = new StringBuilder(CODE_LENGTH);
            for (int i = 0; i < CODE_LENGTH; i++) {
                sb.append(AB.charAt(rnd.nextInt(AB.length())));
            }
            code = sb.toString();
            imageName = "/" + code + "." + imageType;
            folderPackage = new File(folderPackage, imageName);
        } while (folderPackage.exists());
        image += imageName;
        FileCopyUtils.copy(certificateImage.getBytes(), new FileOutputStream(folderPackage));

        // store data to database
        return gson.toJson(certificateDAO.insertNewCertificates(providerID, image, name));
    }

    @Override
    public String insertNewCertificateProvider(String data, FileMeta certificateImage) throws FileNotFoundException, IOException {
        // get data from json
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        int providerID = jsonObject.get("providerID").getAsInt();
        String name = jsonObject.get("name").getAsString();

        // initiate instance to store image
        Random rnd = new Random();
        StringBuilder sb;
        String code;

        // create folder certificate if not exist
        String path = System.getProperty("catalina.base");
        String image = "/Images/Provider/" + providerID + "/Certificate";
        File folderPackage = new File(path + "/webapps" + image);
        if (!folderPackage.exists()) {
            folderPackage.mkdirs();
        }

        // store file to created folder
        String imageName;

        // get file type (Png/jpeg..)
        String imageType = FilenameUtils.getExtension(certificateImage.getFileName());
        do { // check random name is exist or not
            sb = new StringBuilder(CODE_LENGTH);
            for (int i = 0; i < CODE_LENGTH; i++) {
                sb.append(AB.charAt(rnd.nextInt(AB.length())));
            }
            code = sb.toString();
            imageName = "/" + code + "." + imageType;
            folderPackage = new File(folderPackage, imageName);
        } while (folderPackage.exists());
        image += imageName;
        FileCopyUtils.copy(certificateImage.getBytes(), new FileOutputStream(folderPackage));

        // store data to database
        return gson.toJson(certificateDAO.insertNewCertificates(providerID, image, name));
    }

    @Override
    public String getBookingEngineDat(int providerID) {
        DateTime now = new DateTime().withTime(0, 0, 0, 0);

        long currentTime = now.getMillis();
        BookingEngineData data = bookingDAO.getBookingEngineData(providerID, currentTime);
        // iniate no bookings for each day

        String dataJson = gson.toJson(data);
//        String finalJson = "{\"data\":" + dataJson + ",\"remainingResources\":" + affectedInterval + ",\"noBookings\":" + noBookingsJson + "}";
        String finalJson = "{\"data\":" + dataJson + "}";
        return finalJson;
    }

    @Override
    public String getResourceManagementData(int providerID) {
        return gson.toJson(providerDAO.getResourceManagementData(providerID));
    }

    @Override
    public String getResourceListbyProviderID(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        int providerID = jsonObject.get("providerID").getAsInt();
        return gson.toJson(resourceDAO.getListOfResourceByProviderID(providerID));
    }

    @Override
    public String addNewResourceByProviderID(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String resourceName = jsonObject.get("resourceName").getAsString();
        int maximunCapacity = Integer.parseInt(jsonObject.get("resourceValue").getAsString().replaceAll("\"", ""));
        int providerID = jsonObject.get("providerID").getAsInt();
        return gson.toJson(resourceDAO.addNewResourceByProviderID(resourceName, maximunCapacity, providerID));
    }

    @Override
    public String insertResourceAndGetInsertedID(String data, int providerID) {
        JsonObject dataObject = gson.fromJson(data, JsonObject.class);
        String resourceName = dataObject.get("name").getAsString();
        int capacity = dataObject.get("noPeople").getAsInt();

        String note = "";
        try {
            note = dataObject.get("note").getAsString();
        } catch (Exception e) {
        }

        int resourceID = resourceDAO.insertNewResourceAndReturnID(resourceName, capacity, note, providerID);
        return "{\"resourceID\" : " + resourceID + "}";
    }

    @Override
    public String
            insertServingPeriodAndGetID(int providerID, String data) {
        JsonObject dataObject = gson.fromJson(data, JsonObject.class
        );
        String name = dataObject.get("name").getAsString();
        String startTime = dataObject.get("startOperationTime").getAsString();
        String endTime = dataObject.get("endOperationTime").getAsString();
        int servingID = servingPeriodDAO.insertServingPeriodAndGetID(providerID, startTime, endTime, name);
        return "{\"servingID\" : " + servingID + "}";
    }

    @Override
    public boolean saveAvailability(String data
    ) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class
        );
        int temporaryPackageID = jsonObject.get("temporaryPackageID").getAsInt();
        int duration = jsonObject.get("duration").getAsInt();
        String durationType = jsonObject.get("durationType").getAsString();
        String startOperationTime = "";
        String endOperationTime = "";
        if (!durationType.equals("days")) {
            startOperationTime = jsonObject.get("startOperationTime").getAsString();
            endOperationTime = jsonObject.get("endOperationTime").getAsString();
        }
        int resourceID = jsonObject.get("resourceID").getAsInt();
        int minResource = jsonObject.get("minResource").getAsInt();
        boolean isFreeBooking = jsonObject.get("isFreeBooking").getAsBoolean();
        int fixedHour = 0;
        int fixedMinute = 0;
        if (!isFreeBooking) {
            fixedHour = jsonObject.get("fixedHour").getAsInt();
            fixedMinute = jsonObject.get("fixedMinute").getAsInt();
        }
        return packageDAO.saveAvailability(temporaryPackageID, duration, durationType, startOperationTime, endOperationTime, resourceID, minResource, isFreeBooking, fixedHour, fixedMinute);
    }

    private String getBookingCode() {
        Random rnd = new Random();
        StringBuilder sb;
        String code;
        do {
            sb = new StringBuilder(CODE_LENGTH);
            for (int i = 0; i < CODE_LENGTH; i++) {
                sb.append(AB.charAt(rnd.nextInt(AB.length())));
            }
            code = sb.toString();
        } while (bookingDAO.isBookingCodeExist(code));
        return code;
    }

    @Override
    public String
            insertEngineBooking(String data, int providerID) {
        // get data from json
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String bookingDate = jsonObject.get("bookingDate").getAsString();
        String tripDate = jsonObject.get("tripDate").getAsString();
        String tripTime = null;
        try {
            tripTime = jsonObject.get("tripTime").getAsString();
        } catch (Exception e) {
        }
        int noPackages = jsonObject.get("noPackages").getAsInt();
        int packageID = jsonObject.get("packageID").getAsInt();
        String resourceNote = null;
        try {
            resourceNote = jsonObject.get("resourceNote").getAsString();
        } catch (Exception e) {
        }
        String customerName = jsonObject.get("customerName").getAsString();
        String customerPhone = jsonObject.get("customerPhone").getAsString();
        String customerEmail = null;
        try {
            customerEmail = jsonObject.get("customerEmail").getAsString();
        } catch (Exception e) {
        }

        // get duration and duration type to construct affected list
        OfflinePackageDTO packageDTO = offlinePackageDAO.getDurationOfPackage(packageID);

        // insert to database
        bookingDAO.insertOfflineEngineBooking(bookingDate, tripDate, tripTime, noPackages, packageID, resourceNote,
                customerName, customerPhone, customerEmail, packageDTO.getDurationType(), packageDTO.getDuration(), MINIMUM_INTERVAL, providerID);

//            bookingDAO.addPackageAndInsertOfflineEngineBooking(bookingDate, tripDate, tripTime, noPackages, resourceNote, packageName, resourceID,
//                    minimumNoResource, duration, durationType, createdDatePackage, providerID, customerName, customerPhone, customerEmail);
//        
        // get new list bookings
        return getBookingEngineDat(providerID);
    }

    @Override
    public void insertOfflineBooking(String data, int providerID) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");

        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        int hours;
        try {
            hours = jsonObject.get("hours").getAsInt();
        } catch (Exception e) {
            hours = 0;
        }

        int minutes;
        try {
            minutes = jsonObject.get("minutes").getAsInt();
        } catch (Exception e) {
            minutes = 0;
        }

        int days;
        try {
            days = jsonObject.get("days").getAsInt();
        } catch (Exception e) {
            days = 0;
        }

        String dateStr = jsonObject.get("dateStr").getAsString();
        // get resourceTime
        DateTime resourceTimeDT = formatter.parseDateTime(dateStr + " 00:00:00");
        long resourceTime = resourceTimeDT.getMillis();

        String customerName = jsonObject.get("customerName").getAsString();
        String customerPhone = jsonObject.get("customerPhone").getAsString();
        String email;
        try {
            email = jsonObject.get("email").getAsString();
        } catch (Exception e) {
            email = null;
        }

        JsonArray resourceJsonArray = jsonObject.get("resources").getAsJsonArray();
        List<OfflineResourceDTO> offlineResources = new ArrayList<>();
        for (JsonElement resourceJsonElement : resourceJsonArray) {
            JsonObject resourceObject = resourceJsonElement.getAsJsonObject();
            int providerResourceID = resourceObject.get("id").getAsInt();
            int noUnits = resourceObject.get("noUnits").getAsInt();
            int resourceHours = hours;
            int resourceMinutes = minutes;
            int resourceDays = days;
//            int resourceHours = resourceObject.get("hours").getAsInt();
//            int resourceMinutes = resourceObject.get("minutes").getAsInt();
//            int resourceDays;
//            try {
//                resourceDays = resourceObject.get("days").getAsInt();
//            } catch (Exception e) {
//                resourceDays = 0;
//            }
            OfflineResourceDTO newOfflineResource = new OfflineResourceDTO(providerResourceID, noUnits,
                    resourceHours, resourceMinutes, resourceDays);
            offlineResources.add(newOfflineResource);
        }

        DateTime now = new DateTime();
        long bookingTime = now.getMillis();

        String timeStr;
        DateTime tripTimeOb;
        if (days > 0) {
            timeStr = null;
            tripTimeOb = formatter.parseDateTime(dateStr + " 00:00:00");
        } else {
            timeStr = jsonObject.get("timeStr").getAsString();
            tripTimeOb = formatter.parseDateTime(dateStr + " " + timeStr + ":00");
        }
        long tripTime = tripTimeOb.getMillis();

        bookingDAO.insertOfflineBooking(providerID, days, hours, minutes, bookingTime, tripTime, dateStr,
                timeStr, customerName, customerPhone, email, offlineResources, MINIMUM_INTERVAL, resourceTime);
    }

    @Override
    public String
            insertNewOfflineAndReturnNewList(String data, int providerID) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class
        );
        String packageName = jsonObject.get("packageName").getAsString();
        int newPackageResource = jsonObject.get("newPackageResource").getAsInt();
        int newPackageMinimumResource = jsonObject.get("newPackageMinimumResource").getAsInt();
        int newPackageDuration = jsonObject.get("newPackageDuration").getAsInt();
        String newPackageDurationType = jsonObject.get("newPackageDurationType").getAsString();

        DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy");
        DateTime currentDate = new DateTime();
        String createdDatePackage = currentDate.toString(dtf);
        List<OfflinePackageDTO> offlines = bookingDAO.addOfflinePackageAndReturnNewList(packageName, newPackageResource, newPackageMinimumResource, newPackageDuration,
                newPackageDurationType, createdDatePackage, providerID);
        return gson.toJson(offlines);
    }

    @Override
    public boolean sendMail(HttpServletRequest request, String providerName, int providerID, String baseUrl) throws MessagingException {
        final String username = "registration@youtripper.com";
        final String password = "Tripregister190515";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtpm.csloxinfo.com");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        //Create data for referral
        java.util.Date date = new java.util.Date();
        String s = providerID + (new Timestamp(date.getTime()).toString());
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ProviderServiceImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        m.update(s.getBytes(), 0, s.length());
        String md5 = (new BigInteger(1, m.digest()).toString(16));

        String title = "You have an invitation from your friend.";
        String receiver = request.getParameter("email");

//        StringBuilder messageContentHtml = new StringBuilder();
//        messageContentHtml.append(request.getParameter("message") + "<br />\n");
//        messageContentHtml.append("You can become a provider from here:  " + baseUrl + "/Common/Provider/SignupReferral/" + md5);
//        String messageContent = messageContentHtml.toString();
        String emailContent = "  <div style='background: url(cid:bg_Icon) no-repeat;background-color:#ebebec;text-align: center;width:610px;height:365px'>"
                + "            <p style='font-size:16px;padding-top: 45px; padding-bottom: 15px;'>Your friend <b>" + providerName + "</b> has invited you to complete purchase via</p>"
                + "            <a href='http://youtripper.com/Common/Provider/SignupReferral/" + md5 + "' style='width: 160px;height: 50px;border-radius: 5px;border: 0;"
                + "                    background-color: #ff514e;font-size: 14px;font-weight: bolder;color: #fff;display: block;line-height: 50px;margin: 0 auto;text-decoration:none;' >Refferal Link</a>"
                + "            <p style='font-size:16px;margin:30px;'><b>" + providerName + "</b> will get 25 credit</p>"
                + "            <a href='http://youtripper.com' target='_blank'><img src='cid:gift_Icon' width='90' height='90'></a>"
                + "            <a href='http://youtripper.com' target='_blank' style='font-size:10px;color:#939598;text-decoration:none'><p>from www.youtripper.com</p></a>"
                + "            "
                + "            "
                + "        </div>";

        String path = System.getProperty("catalina.base");
        MimeBodyPart backgroundImage = new MimeBodyPart();
        // attach the file to the message
        DataSource source = new FileDataSource(new File(path + "/webapps/Images/Email/backgroundImage.png"));
        backgroundImage.setDataHandler(new DataHandler(source));
        backgroundImage.setFileName("backgroundImage.png");
        backgroundImage.setDisposition(MimeBodyPart.INLINE);
        backgroundImage.setHeader("Content-ID", "<bg_Icon>"); // cid:image_cid

        MimeBodyPart giftImage = new MimeBodyPart();
        // attach the file to the message
        source = new FileDataSource(new File(path + "/webapps/Images/Email/emailGift.png"));
        giftImage.setDataHandler(new DataHandler(source));
        giftImage.setFileName("emailGift.png");
        giftImage.setDisposition(MimeBodyPart.INLINE);
        giftImage.setHeader("Content-ID", "<gift_Icon>"); // cid:image_cid

        MimeBodyPart mbp1 = new MimeBodyPart();
        mbp1.setText(emailContent, "US-ASCII", "html");

        Multipart mp = new MimeMultipart("related");
        mp.addBodyPart(mbp1);
        mp.addBodyPart(backgroundImage);
        mp.addBodyPart(giftImage);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("registration@youtripper.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(receiver));
        message.setSubject(title);
        message.setContent(mp);
        message.saveChanges();
        Transport.send(message);

        ReferralDTO referral = new ReferralDTO(providerID, receiver, String.valueOf(System.currentTimeMillis()), md5, 0);
        referralDAO.insertNewReferral(referral);
        return true;
    }

    @Override
    public boolean sendEmailReferral(String data, int providerID, String baseUrl) throws MessagingException {
        final String username = "registration@youtripper.com";
        final String password = "Tripregister190515";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "mail.youtripper.com");


        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        String title = "You have an invitation from your friend.";

        JsonObject jsonObject = gson.fromJson(data, JsonObject.class
        );
        String content = jsonObject.get("content").getAsString();
        JsonArray sportsArray = jsonObject.get("emails").getAsJsonArray();
        ArrayList<String> listEmail = new ArrayList<>();
        if (sportsArray != null) {
            for (int i = 0; i < sportsArray.size(); i++) {
                listEmail.add(sportsArray.get(i).getAsString());
            }
        }
       
        String path = System.getProperty("catalina.base");
        MimeBodyPart backgroundImage = new MimeBodyPart();
        // attach the file to the message
        DataSource source = new FileDataSource(new File(path + "/webapps/Images/Email/backgroundImage.png"));
        backgroundImage.setDataHandler(new DataHandler(source));
        backgroundImage.setFileName("backgroundImage.png");
        backgroundImage.setDisposition(MimeBodyPart.INLINE);
        backgroundImage.setHeader("Content-ID", "<bg_Icon>"); // cid:image_cid

        MimeBodyPart giftImage = new MimeBodyPart();
        // attach the file to the message
        source = new FileDataSource(new File(path + "/webapps/Images/Email/emailGift.png"));
        giftImage.setDataHandler(new DataHandler(source));
        giftImage.setFileName("emailGift.png");
        giftImage.setDisposition(MimeBodyPart.INLINE);
        giftImage.setHeader("Content-ID", "<gift_Icon>"); // cid:image_cid

        MimeBodyPart mbp1 = new MimeBodyPart();
        mbp1.setText(content, "US-ASCII", "html");

        Multipart mp = new MimeMultipart("related");
        mp.addBodyPart(mbp1);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("registration@youtripper.com"));
        String addresses = "";
        for (int i = 0; i < listEmail.size(); i++) {
            if (i< listEmail.size() -1 ){
                addresses = addresses +listEmail.get(i) + ",";
            } else {
                addresses = addresses +listEmail.get(i);
            }
        }
        
        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(addresses));
        
        message.setSubject(title);
        message.setContent(mp);
        message.saveChanges();
         try {
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        System.out.println("sent");
        return true;
    }

    @Override
    public String
            editPolicy(String data) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class
        );
        int providerID = dataJson.get("providerID").getAsInt();
        int cancellationID = dataJson.get("cancellationID").getAsInt();
        String name = dataJson.get("name").getAsString();
        String condition = dataJson.get("condition").getAsJsonArray().toString();
        boolean result = packageDAO.editPolicy(providerID, cancellationID, name, condition);
        String finalJson = "{\"data\":" + result + "}";
        return finalJson;
    }

    @Override
    public String
            createPolicy(String data) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class
        );
        int providerID = dataJson.get("providerID").getAsInt();
        String name = dataJson.get("name").getAsString();
        String condition = dataJson.get("condition").getAsJsonArray().toString();
        CancellationDTO result = packageDAO.createPolicy(providerID, name, condition);
        return gson.toJson(result);
    }

    @Override
    public String
            createChildrenDiscount(String data, int providerID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class
        );
        String condition = dataJson.get("condition").getAsString();
        int discountPercent = dataJson.get("discountPercent").getAsInt();
        int packageID = dataJson.get("packageID").getAsInt();
        ChildrenDiscountDTO result = packageDAO.createChildrenDiscount(packageID, condition, discountPercent, providerID);
        return gson.toJson(result);
    }

    @Override
    public String
            createChildrenDiscountForMainPackage(String data, int providerID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class
        );
        String condition = dataJson.get("condition").getAsString();
        int discountPercent = dataJson.get("discountPercent").getAsInt();
        int packageID = dataJson.get("packageID").getAsInt();
        ChildrenDiscountDTO result = packageDAO.createChildrenDiscountForMainPackage(packageID, condition, discountPercent, providerID);
        return gson.toJson(result);
    }

    @Override
    public String
            createDisabledDiscount(String data, int providerID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class
        );
        String condition = dataJson.get("condition").getAsString();
        int discountPercent = dataJson.get("discountPercent").getAsInt();
        int packageID = dataJson.get("packageID").getAsInt();
        DisabledDiscountDTO result = packageDAO.createDisabledDiscount(packageID, condition, discountPercent, providerID);
        return gson.toJson(result);
    }

    @Override
    public String
            createDisabledDiscountForMainPackage(String data, int providerID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class
        );
        String condition = dataJson.get("condition").getAsString();
        int discountPercent = dataJson.get("discountPercent").getAsInt();
        int packageID = dataJson.get("packageID").getAsInt();
        DisabledDiscountDTO result = packageDAO.createDisabledDiscountForMainPackage(packageID, condition, discountPercent, providerID);
        return gson.toJson(result);
    }

    @Override
    public void updateBookingRegistrationFom(String data, int providerID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class
        );
        int packageID = dataJson.get("packageID").getAsInt();
        String packageType = dataJson.get("packageType").getAsString();
        Integer minTripper = null;
        try {
            minTripper = dataJson.get("minTripper").getAsInt();
        } catch (Exception e) {
        }

        Integer maxTripper = null;
        try {
            maxTripper = dataJson.get("maxTripper").getAsInt();
        } catch (Exception e) {
        }

        Integer resourceID = null;
        try {
            resourceID = dataJson.get("resourceID").getAsInt();
        } catch (Exception e) {
        }

        Integer minimumResources = null;
        try {
            minimumResources = dataJson.get("minimumResources").getAsInt();
        } catch (Exception e) {
        }

        Integer durationDay = 0;
        try {
            durationDay = dataJson.get("durationDay").getAsInt();
        } catch (Exception e) {
        }
        Integer durationMonth = 0;
        try {
            durationMonth = dataJson.get("durationMonth").getAsInt();
        } catch (Exception e) {
        }
        Integer durationYear = 0;
        try {
            durationYear = dataJson.get("durationYear").getAsInt();
        } catch (Exception e) {
        }

        System.out.println("day " + durationDay);
        System.out.println("month " + durationMonth);
        System.out.println("year " + durationYear);
        Integer durationHour = 0;
        try {
            durationHour = dataJson.get("durationHour").getAsInt();
        } catch (Exception e) {
        }

        Integer durationMinute = 0;
        try {
            durationMinute = dataJson.get("durationMinute").getAsInt();
        } catch (Exception e) {
        }

        Integer servingID = null;
        try {
            servingID = dataJson.get("servingID").getAsInt();
        } catch (Exception e) {
        }

        boolean isFreeBooking = dataJson.get("isFreeBooking").getAsBoolean();
        int freeInterval = dataJson.get("freeInterval").getAsInt();
        boolean isRunning = dataJson.get("isRunning").getAsBoolean();

        Integer fixedHour = null;
        try {
            fixedHour = dataJson.get("fixedHour").getAsInt();
        } catch (Exception e) {
        }

        Integer fixedMinute = null;
        try {
            fixedMinute = dataJson.get("fixedMinute").getAsInt();
        } catch (Exception e) {
        }

        Integer restingDay = 0;
        try {
            restingDay = dataJson.get("restingtimeDay").getAsInt();
        } catch (Exception e) {
        }
        Integer restingHour = 0;
        try {
            restingHour = dataJson.get("restingtimeHour").getAsInt();
        } catch (Exception e) {
        }

        Integer restingMinute = 0;
        try {
            restingMinute = dataJson.get("restingtimeMinute").getAsInt();
        } catch (Exception e) {
        }

        Integer readyBookingDuration = null;
        try {
            readyBookingDuration = dataJson.get("readyBookingDuration").getAsInt();
        } catch (Exception e) {
        }
        String readyBookingDurationType = null;
        try {
            readyBookingDurationType = dataJson.get("readyBookingDurationType").getAsString();
        } catch (Exception e) {
        }
        Date toDay = new Date();
        SimpleDateFormat fortmatMMddyyyy = new SimpleDateFormat("MM/dd/yyyy");
        String todaystartDate = fortmatMMddyyyy.format(toDay);

        String startDate;
        try {
            startDate = dataJson.get("startDate").getAsString();
        } catch (Exception e) {
            DateTime toDate = new DateTime();
            startDate = toDate.toString("MM/dd/yyyy");
        }

        boolean isUsingMaxQuota = dataJson.get("isUsingMaxQuota").getAsBoolean();
        int maxQuota;
        try {
            maxQuota = dataJson.get("maxQuota").getAsInt();
        } catch (Exception e) {
            maxQuota = 0;
        }
        String quotaType = dataJson.get("quotaType").getAsString();
        boolean isSpecificLaunchDate = dataJson.get("isSpecificLaunchDate").getAsBoolean();

        String unavailableDays = dataJson.get("unavailableDays").getAsString();
        int sequentialOperation = dataJson.get("sequentialOperation").getAsInt();
        packageDAO.updateBookingFormOfTempPackage(packageID, packageType, minTripper, maxTripper, resourceID,
                minimumResources, servingID, isFreeBooking, freeInterval, fixedHour,
                fixedMinute, unavailableDays, sequentialOperation, isRunning, readyBookingDuration, readyBookingDurationType,
                durationDay, durationMonth, durationYear, durationHour, durationMinute, restingDay,
                restingHour, restingMinute, providerID, startDate,
                isUsingMaxQuota, maxQuota, quotaType, isSpecificLaunchDate);

//        JsonArray cyclesJson = dataJson.get("operationCycles").getAsJsonArray();
//        if (!isRunning) {
//            for (JsonElement cycleElement : cyclesJson) {
//                JsonObject cycle = cycleElement.getAsJsonObject();
//                String startDate = null;
//                try {
//                    startDate = cycle.get("startDate").getAsString();
//                } catch (Exception e) {
//                }
//                String endDate = null;
//                try {
//
//                    endDate = cycle.get("endDate").getAsString();
//                } catch (Exception e) {
//                }
//                temporaryOperationCycleDAO.insertNewTemporaryCycle(packageID, startDate, endDate);
//            }
//        } else {
//            temporaryOperationCycleDAO.insertNewTemporaryCycle(packageID, todaystartDate, null);
//        }
    }

    @Override
    public boolean updateServingPeriodAndGetID(String data) {
        JsonObject dataObject = gson.fromJson(data, JsonObject.class);
        String name = dataObject.get("name").getAsString();
        int servingID = dataObject.get("servingID").getAsInt();
        String startTime = dataObject.get("startOperationTime").getAsString();
        String endTime = dataObject.get("endOperationTime").getAsString();
        servingPeriodDAO.updateServingPeriod(servingID, startTime, endTime, name);
        return true;
    }

    @Override
    public String editChildrenDiscount(String data) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        int childrenDiscountID = dataJson.get("childrenDiscountID").getAsInt();
        String condition = dataJson.get("condition").getAsString();
        int discountPercent = dataJson.get("discountPercent").getAsInt();
        boolean result = packageDAO.editChildrenDiscount(childrenDiscountID, condition, discountPercent);
        String finalJson = "{\"data\":" + result + "}";
        return finalJson;
    }

    @Override
    public String editDisabledDiscount(String data) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        int childrenDiscountID = dataJson.get("disabledDiscountID").getAsInt();
        String condition = dataJson.get("condition").getAsString();
        int discountPercent = dataJson.get("discountPercent").getAsInt();
        boolean result = packageDAO.editDisabledDiscount(childrenDiscountID, condition, discountPercent);
        String finalJson = "{\"data\":" + result + "}";
        return finalJson;
    }

    @Override
    public String insertNewResourceSkillAndGetNewResourceManagementData(String data, int providerID) {
        // get data and insert
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        String resourceName = dataJson.get("resourceName").getAsString();
        resourceSkillDAO.insertNewResourceSkill(providerID, resourceName);

        // return new data
        return getResourceManagementData(providerID);
    }

    @Override
    public String insertNewProviderResourceAndGetNewResourceManagementData(String data, int providerID) {
        // get data and insert
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        String resourceName = dataJson.get("resourceName").getAsString();
        int capacity = dataJson.get("capacity").getAsInt();
        businessResourceDAO.insertNewResource(resourceName, capacity, providerID);

        // return new data
        return getResourceManagementData(providerID);
    }

    @Override
    public String assignNewTrippSourceToPackageAndGetNewResourceManagementData(String data, int providerID) {
        // get data and insert
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        Integer packageID;
        try {
            packageID = dataJson.get("packageID").getAsInt();
        } catch (Exception e) {
            packageID = null;
        }

        Integer temporaryPackageID;
        try {
            temporaryPackageID = dataJson.get("temporaryPackageID").getAsInt();
        } catch (Exception e) {
            temporaryPackageID = null;
        }
        int noUnits = dataJson.get("noUnits").getAsInt();
        Integer hours;
        try {
            hours = dataJson.get("hours").getAsInt();
        } catch (Exception e) {
            hours = null;
        }
        Integer minutes;
        try {
            minutes = dataJson.get("minutes").getAsInt();
        } catch (Exception e) {
            minutes = null;
        }
        Integer days;
        try {
            days = dataJson.get("days").getAsInt();
        } catch (Exception e) {
            days = null;
        }
        trippSourceDAO.assignNewTrippSourceToPackage(packageID, temporaryPackageID, noUnits, hours, minutes, days);

        // return new data
        return getResourceManagementData(providerID);
    }

    @Override
    public String editProviderResource(String data, int providerID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        String name = dataJson.get("name").getAsString();
        int capacity = dataJson.get("capacity").getAsInt();
        int resourceID = dataJson.get("resourceID").getAsInt();

        JsonArray listJsonOfSkill;
        try {
            listJsonOfSkill = dataJson.get("skills").getAsJsonArray();
        } catch (Exception e) {
            listJsonOfSkill = new JsonArray();
        }
        // edit first and delete old skills
        businessResourceDAO.editOldResource(name, providerID, capacity, resourceID);

        // then insert list of new skills
        for (JsonElement skillJson : listJsonOfSkill) {
            int skillID = skillJson.getAsInt();
            businessResourceDAO.assignNewSkillToResource(resourceID, skillID);
        }
        return "{\"result\": \"success\"}";
    }

    @Override
    public String deleteProviderResource(String data, int providerID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        int resourceID = dataJson.get("resourceID").getAsInt();
        businessResourceDAO.deleteResource(resourceID, providerID);
        return "{\"result\": \"success\"}";
    }

    @Override
    public String editTrippSource(String data, int providerID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        int trippSourceID = dataJson.get("trippSourceID").getAsInt();
        Integer packageID;
        try {
            packageID = dataJson.get("packageID").getAsInt();
        } catch (Exception e) {
            packageID = null;
        }

        Integer temporaryPackageID;
        try {
            temporaryPackageID = dataJson.get("temporaryPackageID").getAsInt();
        } catch (Exception e) {
            temporaryPackageID = null;
        }
        int noUnits = dataJson.get("noUnits").getAsInt();
        Integer hours;
        try {
            hours = dataJson.get("hours").getAsInt();
        } catch (Exception e) {
            hours = null;
        }
        Integer minutes;
        try {
            minutes = dataJson.get("minutes").getAsInt();
        } catch (Exception e) {
            minutes = null;
        }
        Integer days;
        try {
            days = dataJson.get("days").getAsInt();
        } catch (Exception e) {
            days = null;
        }
        JsonArray listJsonOfSkill;
        try {
            listJsonOfSkill = dataJson.get("skills").getAsJsonArray();
        } catch (Exception e) {
            listJsonOfSkill = new JsonArray();
        }
        // edit first and delete old skills
        trippSourceDAO.editTrippSource(packageID, temporaryPackageID, providerID, trippSourceID, noUnits, hours, minutes, days);

        // then insert list of new skills
        for (JsonElement skillJson : listJsonOfSkill) {
            int skillID = skillJson.getAsInt();
            trippSourceDAO.assignNewSkillToTrippSource(packageID, temporaryPackageID, providerID, trippSourceID, skillID);
        }
        return "{\"result\": \"success\"}";
    }

    @Override
    public String deleteTrippSource(String data, int providerID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        int trippSourceID = dataJson.get("trippSourceID").getAsInt();
        Integer packageID;
        try {
            packageID = dataJson.get("packageID").getAsInt();
        } catch (Exception e) {
            packageID = null;
        }

        Integer temporaryPackageID;
        try {
            temporaryPackageID = dataJson.get("temporaryPackageID").getAsInt();
        } catch (Exception e) {
            temporaryPackageID = null;
        }

        trippSourceDAO.deleteTrippSource(providerID, packageID, temporaryPackageID, trippSourceID);
        return "{\"result\": \"success\"}";
    }

    @Override
    public String deleteSkill(String data, int provideID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        int skillID = dataJson.get("skillID").getAsInt();

        resourceSkillDAO.deleteSkill(provideID, skillID);
        return getResourceManagementData(provideID);
    }

    @Override
    public String editSkill(String data, int provideID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        int skillID = dataJson.get("skillID").getAsInt();
        String skillName = dataJson.get("skillName").getAsString();

        resourceSkillDAO.updateSkill(provideID, skillID, skillName);
        return getResourceManagementData(provideID);
    }

    @Override
    public String getPackageForChat(int providerID) {
        return gson.toJson(packageDAO.getPackageForChat(providerID));
    }

    @Override
    public void updateBookingOfMainPackage(String data, int providerID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class
        );
        int packageID = dataJson.get("packageID").getAsInt();
        String packageType = dataJson.get("packageType").getAsString();
        Integer minTripper = null;
        try {
            minTripper = dataJson.get("minTripper").getAsInt();
        } catch (Exception e) {
        }

        Integer maxTripper = null;
        try {
            maxTripper = dataJson.get("maxTripper").getAsInt();
        } catch (Exception e) {
        }

        Integer resourceID = null;
        try {
            resourceID = dataJson.get("resourceID").getAsInt();
        } catch (Exception e) {
        }

        Integer minimumResources = null;
        try {
            minimumResources = dataJson.get("minimumResources").getAsInt();
        } catch (Exception e) {
        }

        Integer durationDay = 0;
        try {
            durationDay = dataJson.get("durationDay").getAsInt();
        } catch (Exception e) {
        }

        Integer durationMonth = 0;
        try {
            durationMonth = dataJson.get("durationMonth").getAsInt();
        } catch (Exception e) {
        }
        Integer durationYear = 0;
        try {
            durationYear = dataJson.get("durationYear").getAsInt();
        } catch (Exception e) {
        }

        Integer durationHour = 0;
        try {
            durationHour = dataJson.get("durationHour").getAsInt();
        } catch (Exception e) {
        }

        Integer durationMinute = 0;
        try {
            durationMinute = dataJson.get("durationMinute").getAsInt();
        } catch (Exception e) {
        }

        Integer servingID = null;
        try {
            servingID = dataJson.get("servingID").getAsInt();
        } catch (Exception e) {
        }

        boolean isFreeBooking = dataJson.get("isFreeBooking").getAsBoolean();
        int freeInterval = dataJson.get("freeInterval").getAsInt();
        boolean isRunning = dataJson.get("isRunning").getAsBoolean();

        Integer fixedHour = null;
        try {
            fixedHour = dataJson.get("fixedHour").getAsInt();
        } catch (Exception e) {
        }

        Integer fixedMinute = null;
        try {
            fixedMinute = dataJson.get("fixedMinute").getAsInt();
        } catch (Exception e) {
        }

        Integer restingDay = 0;
        try {
            restingDay = dataJson.get("restingtimeDay").getAsInt();
        } catch (Exception e) {
        }
        Integer restingHour = 0;
        try {
            restingHour = dataJson.get("restingtimeHour").getAsInt();
        } catch (Exception e) {
        }

        Integer restingMinute = 0;
        try {
            restingMinute = dataJson.get("restingtimeMinute").getAsInt();
        } catch (Exception e) {
        }

        Integer readyBookingDuration = null;
        try {
            readyBookingDuration = dataJson.get("readyBookingDuration").getAsInt();
        } catch (Exception e) {
        }
        String readyBookingDurationType = null;
        try {
            readyBookingDurationType = dataJson.get("readyBookingDurationType").getAsString();
        } catch (Exception e) {
        }
        Date toDay = new Date();
        SimpleDateFormat fortmatMMddyyyy = new SimpleDateFormat("MM/dd/yyyy");
        String todaystartDate = fortmatMMddyyyy.format(toDay);

        String unavailableDays = dataJson.get("unavailableDays").getAsString();
        int sequentialOperation = dataJson.get("sequentialOperation").getAsInt();

        String startDate;
        try {
            startDate = dataJson.get("startDate").getAsString();
        } catch (Exception e) {
            DateTime toDate = new DateTime();
            startDate = toDate.toString("MM/dd/yyyy");
        }

        boolean isUsingMaxQuota = dataJson.get("isUsingMaxQuota").getAsBoolean();
        int maxQuota;
        try {
            maxQuota = dataJson.get("maxQuota").getAsInt();
        } catch (Exception e) {
            maxQuota = 0;
        }

        String quotaType = dataJson.get("quotaType").getAsString();
        packageDAO.editBookingFormOfMainPackage(packageID, packageType, minTripper, maxTripper, resourceID,
                minimumResources, servingID, isFreeBooking, freeInterval, fixedHour,
                fixedMinute, unavailableDays, sequentialOperation, isRunning, readyBookingDuration, readyBookingDurationType,
                durationDay, durationMonth, durationYear, durationHour, durationMinute, restingDay, restingHour, restingMinute, providerID, startDate,
                isUsingMaxQuota, maxQuota, quotaType);

//        JsonArray cyclesJson = dataJson.get("operationCycles").getAsJsonArray();
//        if (!isRunning) {
//            for (JsonElement cycleElement : cyclesJson) {
//                JsonObject cycle = cycleElement.getAsJsonObject();
//                String startDate = null;
//                try {
//                    startDate = cycle.get("startDate").getAsString();
//                } catch (Exception e) {
//                }
//                String endDate = null;
//                try {
//
//                    endDate = cycle.get("endDate").getAsString();
//                } catch (Exception e) {
//                }
//                temporaryOperationCycleDAO.insertNewTemporaryCycle(packageID, startDate, endDate);
//            }
//        } else {
//            temporaryOperationCycleDAO.insertNewTemporaryCycle(packageID, todaystartDate, null);
//        }
    }

    @Override
    public boolean checkCreatingPackageExist(int providerID) {
        return providerDAO.checkCreatingPackageExist(providerID);
    }

    @Override
    public void clonePackage(int providerID, int packageID, String packageStatus,
            boolean cloneAll, boolean cloneCategory, boolean cloneDescription, boolean clonePhoto,
            boolean cloneBooking, boolean clonePricing) throws IOException {
        //Insert new package
        int temporaryPackageID = 0;
        File sourceImageFolder = null;
        String path = System.getProperty("catalina.base");
        if (packageStatus.equals("approved")) {

            temporaryPackageID = packageDAO.clonePackage(providerID, packageID,
                    cloneAll, cloneCategory, cloneDescription, clonePhoto, cloneBooking, clonePricing);
            sourceImageFolder = new File(path + "/webapps/Images/PrimaryPackages/" + packageID);
            if (cloneBooking) {
                packageDAO.insertServingPeriodID(providerID, packageID);
            }

        } else if (packageStatus.equals("pending")) {

            temporaryPackageID = packageDAO.clonePendingPackage(providerID, packageID,
                    cloneAll, cloneCategory, cloneDescription, clonePhoto, cloneBooking, clonePricing);
            sourceImageFolder = new File(path + "/webapps/Images/TemporaryPackages/" + packageID);
            if (cloneBooking) {
                packageDAO.insertServingPeriodIDPendding(providerID, packageID);
            }
        }

        if (clonePhoto) {

            //Insert create image folder
            File folderPackage = new File(path + "/webapps/Images/TemporaryPackages/" + temporaryPackageID);
            if (!folderPackage.exists()) {
                folderPackage.mkdirs();
            }

            //Copy image to new folder
            FileUtils.copyDirectory(sourceImageFolder, folderPackage);

            //Update database
            for (final File fileEntry : sourceImageFolder.listFiles()) {
                String fileName = fileEntry.getName();
                if (fileName.contains("cover")) {
                    packageDAO.updateTemporaryCoverImage(temporaryPackageID, fileName);
                } else {
                    packageDAO.updateTemporaryAdditionalImage(temporaryPackageID, fileName, "%" + fileName + "%");
                }
            }
        }
    }

    @Override
    public void stopPackage(String data, int providerID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        int packageID = dataJson.get("packageID").getAsInt();
        packageDAO.stopPackage(packageID, providerID);
    }

    @Override
    public void startPackage(String data, int providerID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        int packageID = dataJson.get("packageID").getAsInt();
        packageDAO.startPackage(packageID, providerID);
    }

    @Override
    public void deletePackage(String data, int providerID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        int packageID = dataJson.get("packageID").getAsInt();
        String reason = dataJson.get("deleteReason").getAsString();
        int deleteID = dataJson.get("deleteReasonID").getAsInt();
        packageDAO.deletePackage(packageID, reason, deleteID, providerID);
    }

    @Override
    public void deleteTemporaryPackage(String data, int providerID) {

        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        int packageID = dataJson.get("packageID").getAsInt();
        String path = System.getProperty("catalina.base");
        File folderPackage = new File(path + "/webapps/Images/TemporaryPackages/" + packageID);
        folderPackage.delete();

        packageDAO.deleteTemporaryPackage(packageID, providerID);
    }

    @Override
    public boolean checkExistBooking(String data, int providerID) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        int packageID = dataJson.get("packageID").getAsInt();
        return packageDAO.checkExistPackage(packageID);
    }

    @Override
    public boolean applyPackageEditing(int packageID, int providerID) {
        return packageDAO.applyPackageEditing(packageID, providerID);
    }

    @Override
    public boolean insertEditingReason(String data) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        int packageID = dataJson.get("packageID").getAsInt();
        int providerID = dataJson.get("providerID").getAsInt();
        String reason = dataJson.get("editingReason").getAsString();
        return packageDAO.insertEditingReason(packageID, reason, providerID);
    }

    @Override
    public String getProviderTrippDash(int providerID) {

        DateTime toDateObj = new DateTime();
        Date result = new Date(toDateObj.getYear() - 1900, toDateObj.getMonthOfYear() - 1, toDateObj.getDayOfMonth());
        long currentTime = Long.valueOf(result.getTime() + Long.valueOf("86400000"));
        long last30Day = currentTime - Long.valueOf("2592000000");

        return gson.toJson(providerDAO.getProviderTrippDash(providerID, currentTime, last30Day));
    }

    @Override
    public int countNumberOfPackage(int providerID) {
        return packageDAO.countNumberOfPackage(providerID);
    }

    @Override
    public String loadTopLeftBooking(String data) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        long date = dataJson.get("dateTime").getAsLong();
        int providerID = dataJson.get("providerID").getAsInt();
        return gson.toJson(providerDAO.loadTopLeftBooking(providerID, date));

    }

    @Override
    public String loadHighestPackage(String data) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        long date = dataJson.get("dateTime").getAsLong();
        int providerID = dataJson.get("providerID").getAsInt();
        long lastDate = dataJson.get("lastDate").getAsLong();
        String highestPackageType = dataJson.get("highestPackageType").getAsString();
        return gson.toJson(providerDAO.loadHighestPackage(providerID, date, lastDate, highestPackageType));
    }

    @Override
    public String loadLowestPackage(String data) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        long date = dataJson.get("dateTime").getAsLong();
        int providerID = dataJson.get("providerID").getAsInt();
        long lastDate = dataJson.get("lastDate").getAsLong();
        String lowestPackageType = dataJson.get("lowestPackageType").getAsString();
        return gson.toJson(providerDAO.loadLowestPackage(providerID, date, lastDate, lowestPackageType));
    }

    @Override
    public String loadStatisticsInTripDash(String data) {
        JsonObject dataJson = gson.fromJson(data, JsonObject.class);
        long date = dataJson.get("date").getAsLong();
        int packageID = dataJson.get("packageID").getAsInt();
        long lastDate = dataJson.get("lastDate").getAsLong();
        String statisticsType = dataJson.get("statisticsType").getAsString();
        return providerDAO.loadStatisticsInTripDash(date, packageID, lastDate, statisticsType);
    }

}
