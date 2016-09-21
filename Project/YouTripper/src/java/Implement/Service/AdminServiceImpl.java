/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.Service;

import DTO.AdminSession;
import DTO.KeywordCollectionDTO;
import DTO.TemporaryPackageDTO;
import Interface.DAO.AdminDAO;
import Interface.DAO.CertificateDAO;
import Interface.DAO.KeywordCollectionDAO;
import Interface.DAO.KeywordDAO;
import Interface.DAO.PackageDAO;
import Interface.DAO.SalesmanDAO;
import Interface.DAO.SystemKeywordDAO;
import Interface.Service.AdminService;
import JavaClass.PackageApprovedEmailData;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Nick
 */
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDAO adminDAO;

    @Autowired
    PackageDAO packageDAO;

    @Autowired
    KeywordCollectionDAO keywordCollectionDAO;

    @Autowired
    SystemKeywordDAO systemKeywordDAO;

    @Autowired
    KeywordDAO keywordDAO;

    @Autowired
    CertificateDAO certificateDAO;

    @Autowired
    SalesmanDAO salesmanDAO;

    private final Gson gson;

    public AdminServiceImpl() {
        gson = new Gson();
    }

    @Override
    public AdminSession login(String username, String password) {
        return adminDAO.login(username, password);
    }

    @Override
    public String getCreatedTEmporaryPackage() {
        return gson.toJson(packageDAO.getCreatedPackage());
    }

    @Override
    public String getCreatedTEmporaryPassport() {
        return gson.toJson(certificateDAO.getCreatedPassport());
    }

    @Override
    public String getCreatedTEmporaryPackagev2() {
        return gson.toJson(packageDAO.getCreatedPackagev2());
    }

    @Override
    public String getEditingPackages() {
        return gson.toJson(packageDAO.getEditingPackages());
    }

    @Override
    public boolean approveTemporaryPackage(int packageID) throws Exception {
        DateTime now = new DateTime();
        String startDateStr = now.toString("MM/dd/yyyy");
        int newPackageID = packageDAO.approveTemporaryPackage(packageID, startDateStr);
        //Insert create image folder
        String path = System.getProperty("catalina.base");
        File folderPackage = new File(path + "/webapps/Images/TemporaryPackages/" + packageID);
        if (!folderPackage.exists()) {
            folderPackage.mkdirs();
        }

        //Copy image to new folder
        File sourceImageFolder = new File(path + "/webapps/Images/PrimaryPackages/" + newPackageID);
        if (!sourceImageFolder.exists()) {
            sourceImageFolder.mkdirs();
        }

        FileUtils.copyDirectory(folderPackage, sourceImageFolder);
        folderPackage.delete();
        //Update database
        for (final File fileEntry : sourceImageFolder.listFiles()) {
            String fileName = fileEntry.getName();
            String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (fileName.contains("cover")) {
                packageDAO.updateCoverAfterApprove(newPackageID, "/Images/PrimaryPackages/" + newPackageID + "/cover." + fileExtension);
            } else {
                packageDAO.updateAdditionalAfterApprove(newPackageID, "%" + fileName + "%", "/Images/PrimaryPackages/" + newPackageID + "/" + fileName);
            }
        }
        return true;
    }

    @Override
    public boolean approveTemporaryPackagev2(int packageID) throws Exception {
        return packageDAO.approveTemporaryPackagev2(packageID);
    }

    @Override
    public TemporaryPackageDTO editPackage(int packageID) {
        return packageDAO.editPackage(packageID);
    }

//    @Override
//    public String getPackageForm() {
//        return gson.toJson(packageDAO.getCreationForm());
//    }
    @Override
    public String getProviderPaymentList() {
        return gson.toJson(adminDAO.getProviderPaymentList());
    }

    @Override
    public String viewBookingDetailByProviderID(int providerID) {
        return gson.toJson(adminDAO.viewBookingDetail(providerID));
    }

    @Override
    public boolean payOut() {
        return adminDAO.payout();
    }

    @Override
    public String getKeywordCollection() {
        return gson.toJson(keywordCollectionDAO.getKeywordCollectionList());
    }

    @Override
    public boolean insertNewSystemKeyword(String keyword, int times) {
        return keywordDAO.insertNewSystemKeyword(keyword, times);
    }

    @Override
    public boolean deleteKeywordCollection(String keyword) {
        return keywordDAO.deleteKeywordCollection(keyword);
    }

    @Override
    public boolean deleteAllKeywordCollection() {
        return keywordDAO.deleteAllKeywordCollection();
    }

    @Override
    public boolean insertAllkeywordCollection() {
        List<KeywordCollectionDTO> result = keywordCollectionDAO.getKeywordCollectionList();
        for (int i = 0; i < result.size(); i++) {
            keywordDAO.insertNewSystemKeyword(result.get(i).getKeyword(), result.get(i).getTimes());
        }
        return true;
    }

    @Override
    public void insertKeywordToSystem(int packageID) {
        String keywords = packageDAO.getKeywordsOfPackage(packageID);
        if (keywords != null) {
            String[] keywordList = keywords.split(",");
            for (String keyword : keywordList) {
                if (!keyword.isEmpty()) {
                    systemKeywordDAO.insertKeyword(keyword);
                }
            }
        }
    }

    @Override
    public void insertKeywordToSystemv2(int packageID) {
        String keywords = packageDAO.getKeywordsOfPackagev2(packageID);
        String[] keywordList = keywords.split(",");
        for (String keyword : keywordList) {
            systemKeywordDAO.insertKeyword(keyword);
        }
    }

    @Override
    public boolean approveSubCategory(int temporaryPackageID) {
        return packageDAO.approveSubCategory(temporaryPackageID);
    }

    @Override
    public boolean insertSalesman(String email, String firstName, String lastName, String phone) {
        return adminDAO.insertSalesman(email, firstName, lastName, phone);
    }

    @Override
    public String getCertificae() {
        return gson.toJson(certificateDAO.getCertificate());
    }

    @Override
    public boolean approveCertificate(String[] certificateId) {
        String sqlPlus = "";
        for (int i = 1, length = certificateId.length; i < length; i++) {
            sqlPlus += " OR CertificateID = ?";
        }
        Object[] listCertificate = new Object[certificateId.length];
        for (int i = 0; i < certificateId.length; i++) {
            listCertificate[i] = Integer.parseInt(certificateId[i]);
        }
        return certificateDAO.approveCertificate(listCertificate, sqlPlus);
    }

    @Override
    public boolean approvePassport(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        int length = jsonObject.get("providerIDSize").getAsInt();
        Object[] providerIDArr = new Object[length];
        String sqlPlus = "";
        int providerID = 0;
        int i;
        for (i = 2; i <= length; i++) {
            sqlPlus += " OR ProviderID = ?";
        }
        for (i = 1; i <= length; i++) {
            providerID = jsonObject.get("providerID" + i).getAsInt();
            providerIDArr[i - 1] = providerID;
        }
        return certificateDAO.approvePassport(sqlPlus, providerIDArr);
    }

    @Override
    public String getSalesman() {
        return gson.toJson(salesmanDAO.getSalesmanList());
    }

    @Override
    public String getProviderListWithSalesman(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        int salesmanId = jsonObject.get("salesmanId").getAsInt();
        return gson.toJson(salesmanDAO.getProviderlistBySalesmanId(salesmanId));
    }

    @Override
    public boolean checkPhoneNumberIsExist(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String phoneNumber = jsonObject.get("phoneNumber").getAsString();
        int salesManId = salesmanDAO.getSalesmanIdByPhoneNumber(phoneNumber);
        return salesManId > 0;
    }

    @Override
    public boolean sendPackageApprovedEmail(PackageApprovedEmailData emailData) throws MessagingException {
        String path = System.getProperty("catalina.base");
        MimeBodyPart logo = new MimeBodyPart();
        // attach the file to the message
        DataSource source = new FileDataSource(new File(path + "/webapps/Images/Email/logoIcon.png"));
        logo.setDataHandler(new DataHandler(source));
        logo.setFileName("logoIcon.png");
        logo.setDisposition(MimeBodyPart.INLINE);
        logo.setHeader("Content-ID", "<logo_Icon>"); // cid:image_cid

        MimeBodyPart facebook = new MimeBodyPart();
        // attach the file to the message
        source = new FileDataSource(new File(path + "/webapps/Images/Email/facebookIcon.png"));
        facebook.setDataHandler(new DataHandler(source));
        facebook.setFileName("facebookIcon.png");
        facebook.setDisposition(MimeBodyPart.INLINE);
        facebook.setHeader("Content-ID", "<fb_Icon>"); // cid:image_cid

        MimeBodyPart twitter = new MimeBodyPart();
        // attach the file to the message
        source = new FileDataSource(new File(path + "/webapps/Images/Email/twitterIcon.png"));
        twitter.setDataHandler(new DataHandler(source));
        twitter.setFileName("twitterIcon.png");
        twitter.setDisposition(MimeBodyPart.INLINE);
        twitter.setHeader("Content-ID", "<twitter_Icon>"); // cid:image_cid

        MimeBodyPart insta = new MimeBodyPart();
        // attach the file to the message
        source = new FileDataSource(new File(path + "/webapps/Images/Email/instaIcon.png"));
        insta.setDataHandler(new DataHandler(source));
        insta.setFileName("instaIcon.png");
        insta.setDisposition(MimeBodyPart.INLINE);
        insta.setHeader("Content-ID", "<insta_Icon>"); // cid:image_cid

        MimeBodyPart youtube = new MimeBodyPart();
        // attach the file to the message
        source = new FileDataSource(new File(path + "/webapps/Images/Email/youtubeIcon.png"));
        youtube.setDataHandler(new DataHandler(source));
        youtube.setFileName("youtubeIcon.png");
        youtube.setDisposition(MimeBodyPart.INLINE);
        youtube.setHeader("Content-ID", "<yt_Icon>"); // cid:image_cid

        MimeBodyPart pinterest = new MimeBodyPart();
        // attach the file to the message
        source = new FileDataSource(new File(path + "/webapps/Images/Email/pinterestIcon.png"));
        pinterest.setDataHandler(new DataHandler(source));
        pinterest.setFileName("pinterestIcon.png");
        pinterest.setDisposition(MimeBodyPart.INLINE);
        pinterest.setHeader("Content-ID", "<pin_Icon>"); // cid:image_cid

        String content = "<div style=' width: 507px;background-color: #f2f2f4;'>"
                + "    <div style='padding: 30px 0;text-align: center; color: #fff; background-color: #ff514e;font-size: 30px;font-weight: bold;'>"
                + "        <img style=' text-align:center;' width=57 height=57 src='cid:logo_Icon'/>"
                + "        <p style='margin:25px 0px 0px 0px;'> Package Approved! </p>"
                + "    </div>"
                + "    <div style=' padding: 50px;margin-bottom: 20px;'>"
                + "        <div id='email-form'>"
                + "            <div style='margin-bottom: 20px'>"
                + "                Hi " + emailData.getLastName() + " ,<br/>"
                + "                Your package " + emailData.getLastestPackageName() + " has been approved"
                + "            </div>"
                + "            <div style='margin-bottom: 20px'>"
                + "                Thanks,<br/>"
                + "                Youtripper team\n"
                + "            </div>"
                + "        </div>"
                + "        <div style='border-top: solid 1px #c4c5cc;text-align:center;'>"
                + "            <p style='text-align: center; color: #3b3e53;margin-top: 10px;margin-bottom: 0px;font-size: 10px;'>Sent from Youtripper.com</p>"
                + "            <div>"
                + "                <a href='https://www.facebook.com/youtrippers/'><img style='margin:10px;' src='cid:fb_Icon' alt=''/></a>"
                + "                <a href='https://twitter.com/youtrippers'><img style='margin:10px;' src='cid:twitter_Icon' alt=''/></a>"
                + "                <a href='https://www.instagram.com/youtrippers/'><img style='margin:10px;' src='cid:insta_Icon' alt=''/></a>"
                + "                <a href='https://www.youtube.com/channel/UCtd4xd_SSjRR9Egug7tXIWA'><img style='margin:10px;' src='cid:yt_Icon' alt=''/></a>"
                + "                <a href='https://www.pinterest.com/youtrippers/'><img style='margin:10px;' src='cid:pin_Icon' alt=''/></a>"
                + "            </div>"
                + "            <p>Youtripper Ltd., 56 Soi Seri Villa, Srinakarin Rd., Nongbon,"
                + "                <br>Pravet, Bangkok, Thailand 10250</p>"
                + "        </div>"
                + "    </div>"
                + "</div>";

        MimeBodyPart mbp1 = new MimeBodyPart();
        mbp1.setText(content, "US-ASCII", "html");

        Multipart mp = new MimeMultipart("related");
        mp.addBodyPart(mbp1);
        mp.addBodyPart(logo);
        mp.addBodyPart(facebook);
        mp.addBodyPart(twitter);
        mp.addBodyPart(insta);
        mp.addBodyPart(youtube);
        mp.addBodyPart(pinterest);

        final String username = "noreply@youtripper.com";
        final String password = "Tripper190515";
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

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("noreply@youtripper.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(emailData.getEmail()));
        message.setSubject("Package Approved!");
        message.setContent(mp);
        message.saveChanges();
        Transport.send(message);
        return true;
    }

    @Override
    public PackageApprovedEmailData getPackageApprovedEmailData(int providerID) {
        return adminDAO.getPackageApprovedEmailData(providerID);
    }
}
