/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.Service;

import DTO.AccountSession;
import DTO.ActivityDTO;
import DTO.AdminSession;
import DTO.AdvancedSearchForm;
import DTO.CategoryDTO;
import DTO.CountryDTO;
import DTO.ForgotPasswordDTO;
import DTO.PackageDTO;
import DTO.PackageDTOv2;
import DTO.RemindReviewEmail;
import DTO.PackagesViewDTO;
import DTO.ProviderDTO;
import DTO.ProviderSession;
import DTO.ReviewDTO;
import DTO.SubCategoryDTO;
import Interface.DAO.ActivityDAO;
import Interface.DAO.AdminDAO;
import Interface.DAO.BookingDAO;
import Interface.DAO.CategoryDAO;
import Interface.DAO.CommonDAO;
import Interface.DAO.CountryDAO;
import Interface.DAO.ForgotPasswordDAO;
import Interface.DAO.KeywordDAO;
import Interface.DAO.LoginCookieDAO;
import Interface.DAO.PackageDAO;
import Interface.DAO.ProviderDAO;
import Interface.DAO.RemindReviewEmailDAO;
import Interface.DAO.ReportDAO;
import Interface.DAO.ReportTypeDAO;
import Interface.DAO.ReviewDAO;
import Interface.DAO.SignupTokenDAO;
import Interface.DAO.SubCategoryDAO;
import Interface.DAO.SystemKeywordDAO;
import Interface.DAO.TrackingUserDAO;
import Interface.DAO.TripperDAO;
import Interface.DAO.UsedResourcesDAO;
import Interface.Service.CommonService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.twilio.sdk.TwilioRestException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 *
 * @author Nick
 */
public class CommonServiceImpl implements CommonService {

    @Autowired
    CommonDAO commonDAO;

    @Autowired
    PackageDAO packageDAO;

    @Autowired
    ReviewDAO reviewDAO;

    @Autowired
    SignupTokenDAO signupTokenDAO;

    @Autowired
    ActivityDAO activityDAO;

    @Autowired
    CountryDAO countryDAO;

    @Autowired
    TripperDAO tripperDAO;

    @Autowired
    ProviderDAO providerDAO;

    @Autowired
    LoginCookieDAO loginCookieDAO;

    @Autowired
    ReportTypeDAO reportTypeDAO;

    @Autowired
    ReportDAO reportDAO;

    @Autowired
    ForgotPasswordDAO forgotPasswordDAO;

    @Autowired
    RemindReviewEmailDAO remindReviewEmailDAO;

    @Autowired
    KeywordDAO keywordDAO;

    @Autowired
    AdminDAO adminDAO;

    @Autowired
    SystemKeywordDAO systemKeywordDAO;

    @Autowired
    SubCategoryDAO subCategoryDAO;

    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    BookingDAO bookingDAO;

    @Autowired
    TrackingUserDAO trackingUserDAO;

    @Autowired
    UsedResourcesDAO usedResourcesDAO;

    private final Gson gson;
    private final int searchPageSize = 9;
    private final int activitiesPageSize = 9;
    private final Type listIntegerType;
    private final Type listStringType;

    public static String nearMeJson = "{\"categories\":[{\"categoryID\":1,\"categoryName\":\"Beauty \\u0026 Well-being\",\"totalPackages\":13},{\"categoryID\":2,\"categoryName\":\"Health Care\",\"totalPackages\":0},{\"categoryID\":3,\"categoryName\":\"Education \\u0026 Lifestyle\",\"totalPackages\":0},{\"categoryID\":4,\"categoryName\":\"Extreme Sports\",\"totalPackages\":0},{\"categoryID\":5,\"categoryName\":\"Motor Sports\",\"totalPackages\":0},{\"categoryID\":6,\"categoryName\":\"Indoor Activities\",\"totalPackages\":0},{\"categoryID\":7,\"categoryName\":\"Outdoor Activities\",\"totalPackages\":0},{\"categoryID\":8,\"categoryName\":\"Sightseeing\",\"totalPackages\":0},{\"categoryID\":9,\"categoryName\":\"Water Activities\",\"totalPackages\":0}],\"locations\":[{\"location\":\"Bangkok\",\"totalPackages\":8},{\"location\":\"Pattaya\",\"totalPackages\":1},{\"location\":\"Phuket\",\"totalPackages\":1}]}"; // for near me table

    public CommonServiceImpl() {
        gson = new Gson();
        listIntegerType = new TypeToken<List<Integer>>() {
        }.getType();
        listStringType = new TypeToken<List<String>>() {
        }.getType();
    }

    @Override
    public AccountSession loginToYouTripper(String username, String password) {
        return commonDAO.loginToYouTripper(username, password);
    }

    @Override
    public boolean checkEmailIsExist(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String email = jsonObject.get("email").getAsString();
        int providerID = commonDAO.getAccountIDByEmail(email);
        return providerID > 0;
    }

    @Override
    public boolean checkEmailIsExistRegister(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String email = jsonObject.get("email").getAsString();
        int providerID = commonDAO.getAccountIDByEmailRegister(email);
        return providerID > 0;
    }

    @Override
    public boolean checkBusinessNameIsExist(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String businessName = jsonObject.get("businessName").getAsString();
        int providerID = commonDAO.getAccountIDByBusinessName(businessName);
        return providerID > 0;
    }

    @Override
    public boolean checkUsernameURLIsExist(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String usernameURL = jsonObject.get("usernameURL").getAsString();
        int providerID = commonDAO.getAccountIDByUsernameURL(usernameURL);
        return providerID > 0;
    }

    @Override
    public boolean checkSalesCode(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String salesCode = jsonObject.get("salesCode").getAsString();
        int providerID = commonDAO.getSalesidBySalesCode(salesCode);
        return providerID > 0;
    }

    @Override
    public boolean checkCaptcha(String captcha) throws UnsupportedEncodingException, IOException {

        InputStream is = null;
        BufferedReader reader = null;
        URLConnection connection = null;

        String charSet = java.nio.charset.StandardCharsets.UTF_8.name();
        String url = "https://www.google.com/recaptcha/api/siteverify";
//        String key = "6LfkbRATAAAAAOH4eTC7auJckiY2_NyhL0JqLfhX";
        String key = "6LcR5xUTAAAAAEcgtErii7-UMEiG1FSKQZXyd2H1";
        String query = String.format("secret=%s&response=%s",
                URLEncoder.encode(key, charSet),
                URLEncoder.encode(captcha, charSet));
        connection = new URL(url + "?" + query).openConnection();
        is = connection.getInputStream();
        reader = new BufferedReader(new InputStreamReader(is));
        JsonObject response = gson.fromJson(reader, JsonObject.class);
        boolean result = response.get("success").getAsBoolean();
        if (is != null) {
            try {
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public List<String> getSuggestionKeywords(String keyword) {
        List<String> keywords = new ArrayList<>();
        int index = keyword.length() - 1;
        List<String> oldKeywords = new ArrayList<>();
        oldKeywords.add(keyword);
        int noKeywords = 3;
        while (noKeywords > 0 && index > 0) {
            String newKeyword = keyword.substring(0, index);
            keywords.addAll(systemKeywordDAO.getSuggestionKeywords("%" + newKeyword + "%", oldKeywords, noKeywords));
            oldKeywords.add(newKeyword);
            index--;
            noKeywords = 3 - keywords.size();
        }
        return keywords;
    }

    @Override
    public String commonSearchPackages(String searchText) {
        AdvancedSearchForm form = commonDAO.search("%" + searchText + "%", 1, searchPageSize);
        if (form.getPackages().size() <= 0) {
            List<String> suggestionKeywords = getSuggestionKeywords(searchText);
            if (suggestionKeywords.size() > 0) {
                HashMap<String, PackagesViewDTO> suggestion = new HashMap<>();
                List<PackagesViewDTO> suggestionPackages = packageDAO.getSuggestionPackages(suggestionKeywords);
                for (int i = 0; i < suggestionPackages.size(); i++) {
                    suggestion.put(suggestionKeywords.get(i), suggestionPackages.get(i));
                }
                form.setSuggestion(suggestion);
            }
        }
        return gson.toJson(form);
    }

    @Override
    public String searchWithPageNumber(String data) {
        JsonObject object = gson.fromJson(data, JsonObject.class);
        String search = object.get("search").getAsString();
        int pageNumber = object.get("pageNumber").getAsInt();
        return gson.toJson(commonDAO.searchWithPageNumber("%" + search + "%", pageNumber, searchPageSize));
    }

    @Override
    public String getPackageByID(int packageID) {
        String keywords = packageDAO.getKeywordsOfMainPackage(packageID);
        String[] keywordList = keywords.split(",");
        for (String keyword : keywordList) {
            systemKeywordDAO.insertKeyword(keyword);
        }
        return gson.toJson(packageDAO.getPackageByID(packageID));
    }

    @Override
    public String getReviewsByTime(String jsonStr) {
        JsonObject jsonObject = gson.fromJson(jsonStr, JsonObject.class);
        int packageID = jsonObject.get("packageID").getAsInt();
        int time = jsonObject.get("time").getAsInt();
        List<ReviewDTO> reviews = reviewDAO.getReviewsByTime(time * 5, packageID);
        return gson.toJson(reviews);
    }

    @Override
    public String getReviewsOfProviderByTime(String jsonStr) {
        JsonObject jsonObject = gson.fromJson(jsonStr, JsonObject.class);
        int providerID = jsonObject.get("providerID").getAsInt();
        int time = jsonObject.get("time").getAsInt();
        List<ReviewDTO> reviews = reviewDAO.getReviewsOfProviderByTime(time * 5, providerID);
        return gson.toJson(reviews);
    }

    @Override
    public String getReviewsOfTripperByTime(String jsonStr) {
        JsonObject jsonObject = gson.fromJson(jsonStr, JsonObject.class);
        int tripperID = jsonObject.get("tripperID").getAsInt();
        int time = jsonObject.get("time").getAsInt();
        List<ReviewDTO> reviews = reviewDAO.getReviewsOfTripperByTime(time * 5, tripperID);
        return gson.toJson(reviews);
    }

    @Override
    public boolean sendActivationEmail(String title, String receiverName, String receiver, String token, String baseUrl) throws MessagingException {

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
                + "        <p style='margin:25px 0px 0px 0px;'> Welcome to Youtripper! </p>"
                + "    </div>"
                + "    <div style=' padding: 50px;margin-bottom: 20px;'>"
                + "        <div id='email-form'>"
                + "            <div style='margin-bottom: 20px'>"
                + "                Hi " + receiverName + " ,<br/>"
                + "                In order to get started, you need to confirm your email address."
                + "            </div>"
                + "            <div style='margin-bottom: 20px'>"
                + "                <a style='display: block; width: 100%; line-height: 35px;text-align: center; text-decoration: none; color: #fff;background-color: #46c1c6;border-radius: 5px' href='" + baseUrl + "/Common/Activation/" + token + " ' title=''>Confirm email</a>"
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

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("registration@youtripper.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(receiver));
        message.setSubject(title);
        message.setContent(mp);
        message.saveChanges();
        Transport.send(message);
        return true;
    }

    @Override
    public boolean sendFollowEmail(String title, String receiver, String baseUrl) throws MessagingException {

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
        //get ID of email
        int emailID = commonDAO.getAccountIDByEmailRegister(receiver);

        String content = "<div style=' width: 507px;background-color: #f2f2f4;'>"
                + "    <div style='padding: 30px 0;text-align: center; color: #fff; background-color: #ff514e;font-size: 30px;font-weight: bold;'>"
                + "        <img style=' text-align:center;' width=57 height=57 src='cid:logo_Icon'/>"
                + "        <p style='margin:25px 0px 0px 0px;'> Welcome to Youtripper! </p>"
                + "    </div>"
                + "    <div style=' padding: 50px;margin-bottom: 20px;'>"
                + "        <div id='email-form'>"
                + "            <div style='margin-bottom: 20px'>"
                + "                Hi there,<br/><br/>"
                + "                Thank you for subscribing to our newsletter. We are excited to have you on board of our development and we will keep you updated with the latest developments and offers to come. <br/><br/>"
                + "                If you are an activity provider and would like to know more about our ideas please contact us at registration@youtripper.com"
                + "            </div>"
                + "            <div style='margin-bottom: 20px'>"
                + "                See you soon,<br/>"
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
                + "            <div style='margin-top: 20px; text-align: center'>"
                + "                <a style='' href='" + baseUrl + "/Common/Unsubscribe/" + emailID + " ' title=''>Unsubscribe</a>"
                + "            </div>"
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

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("registration@youtripper.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(receiver));
        message.setSubject(title);
        message.setContent(mp);
        message.saveChanges();
        Transport.send(message);
        return true;
    }

    @Override
    public String insertNewSignUpToken(String email, String referralToken) throws UnsupportedEncodingException {
        return signupTokenDAO.insertNewToken(email, referralToken);

    }

    @Override
    public boolean insertPassword(String password, int tripperID) {
        return tripperDAO.insertNewPassword(password, tripperID);
    }

    @Override
    public boolean insertEmail(String email, long time) {
        return commonDAO.insertNewEmail(email, time);
    }

    @Override
    public AccountSession validateTokenForProvider(String token) {
        return signupTokenDAO.validateTokenForProvider(token);
    }

    @Override
    public boolean sendSMS(String receiver, String message) throws TwilioRestException {
        return commonDAO.sendSMS(receiver, message);
    }

    @Override
    public List<CountryDTO> getAllCountry() {
        return countryDAO.getAllCountry();
    }

    @Override
    public String getProviderSignupForm() {
        return gson.toJson(commonDAO.getProviderSignupForm());
    }

    @Override
    public AccountSession insertTripper(String email, String password, String firstName, String lastName) {
        return tripperDAO.insertTripper(email, password, firstName, lastName);
    }

    @Override
    public AccountSession insertProvider(int businessTypeID, String businessName, int countryID, String city, String address,
            String phoneCode, String phone, String firstName, String lastName, String displayName, String job, String email, String password, String referralCode, String openTime, String closeTime, String referralOfficialID) {
        return providerDAO.registerProvider(businessTypeID, businessName, countryID, city, address, phoneCode, phone, firstName, lastName, displayName, job, email, password, true, referralCode, openTime, closeTime, referralOfficialID);
    }

    @Override
    public List<ActivityDTO> getActivitesByCountry(String country) {
        return activityDAO.getActivitesByCountry(country);
    }

    @Override
    public List<PackageDTO> getAllPackageByLocationAndActivity(String location, int activityID) {
        return packageDAO.getAllPackageByLocationAndActivity(location, activityID);
    }

    @Override
    public String insertNewCookie(String username) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedtoken = passwordEncoder.encode(username);
        String resultToken = loginCookieDAO.insertNewToken(username, hashedtoken);
        return resultToken;
    }

    @Override
    public AccountSession checkCookie(String token) {
        AccountSession account = loginCookieDAO.checkCookie(token);
        return account;

    }

    @Override
    public void deleteCookie(String token) {
        loginCookieDAO.deleteCookie(token);
    }

    @Override
    public void unSubscribe(int emailID) {
        commonDAO.unSubscribe(emailID);
    }

    @Override
    public int getSearchPageSize() {
        return searchPageSize;
    }

    @Override
    public int getActivitiesPageSize() {
        return activitiesPageSize;
    }

    @Override
    public String searchPackagesWithFilter(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String searchText = jsonObject.get("searchText").getAsString();
        int rate = jsonObject.get("rate").getAsInt();
        int pageNumber = jsonObject.get("pageNumber").getAsInt();
        double minPrice = jsonObject.get("minPrice").getAsDouble();
        double maxPrice = jsonObject.get("maxPrice").getAsDouble();
        List<Integer> tripTypeIDs = gson.fromJson(jsonObject.get("tripTypeIDs"), listIntegerType);
        List<Integer> groupTypeIDs = gson.fromJson(jsonObject.get("groupTypeIDs"), listIntegerType);
        List<Integer> amenitiesIDs = gson.fromJson(jsonObject.get("amenitiesIDs"), listIntegerType);
        return gson.toJson(packageDAO.searchPackagesWithFilter(tripTypeIDs, groupTypeIDs, amenitiesIDs, rate,
                minPrice, maxPrice, searchPageSize, pageNumber, searchText));
    }

    @Override
    public String getFilterOptions(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String searchText = jsonObject.get("searchText").getAsString();
        return gson.toJson(packageDAO.getFilterOptions(searchText));
    }

    @Override
    public String getProviderPage(int providerID) {
        return gson.toJson(providerDAO.getProviderPage(providerID));
    }

    @Override
    public String getProviderID(String url) {

        return gson.toJson(providerDAO.getProviderID(url));

    }

    @Override
    public String getReportType() {
        return gson.toJson(reportTypeDAO.getReportType());
    }

    @Override
    public boolean reportProvider(int providerID, String report) {
        return reportDAO.reportProvider(providerID, report);
    }

    @Override
    public String getTripperPage(int tripperID) throws Exception {
        return gson.toJson(tripperDAO.getTripperPage(tripperID));
    }

    @Override
    public boolean reportTripper(int tripperID, String report) {
        return reportDAO.reportTripper(tripperID, report);
    }

    @Override
    public boolean insertNewForgotPasswordToken(String token, String email) {
        String hashedtoken = DigestUtils.md5DigestAsHex((email + token).getBytes());
        return forgotPasswordDAO.insertNewToken(hashedtoken, email);
    }

    @Override
    public ForgotPasswordDTO checkForgotPasswordToken(String token) {
        return forgotPasswordDAO.checkForgotPasswordToken(token);
    }

    @Override
    public boolean resetPassword(String token, String password) {
        return forgotPasswordDAO.resetPassword(token, password);
    }

    @Override
    public boolean sendForgotPasswordEmail(String title, String receiver, String token, String baseUrl) throws MessagingException {
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
                + "        <p style='margin:25px 0px 0px 0px;'> Reset Password! </p>"
                + "    </div>"
                + "    <div style=' padding: 50px;margin-bottom: 20px;'>"
                + "        <div id='email-form'>"
                + "            <div style='margin-bottom: 20px'>"
                + "                Click on button below to reset your password"
                + "            </div>"
                + "            <div style='margin-bottom: 20px'>"
                + "                <a style='display: block; width: 100%; line-height: 35px;text-align: center; text-decoration: none; color: #fff;background-color: #46c1c6;border-radius: 5px' href='" + baseUrl + "/Common/ChangePassword/" + token + " ' title=''>Reset password</a>"
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

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("noreply@youtripper.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(receiver));
        message.setSubject(title);
        message.setContent(mp);
        message.saveChanges();
        Transport.send(message);
        return true;
    }

    @Override
    public String getAllActivities() {
        return gson.toJson(activityDAO.getAllActivitiesForHome(activitiesPageSize, 1));
    }

    @Override
    public String getAllActivitiesWithinLocation(String location) {
        return gson.toJson(activityDAO.getActivitiesWithLocationForHome("%" + location + "%", activitiesPageSize, 1));
    }

    @Override
    public String getActivitiesWithPageNumber(String dataJson) {
        JsonObject jsonObject = gson.fromJson(dataJson, JsonObject.class);
        int pageNumber = jsonObject.get("pageNumber").getAsInt();
        String location = jsonObject.get("location").getAsString();
        if (location.equals("all")) {
            return gson.toJson(activityDAO.getAllActivitiesForHome(activitiesPageSize, pageNumber));
        }
        return gson.toJson(activityDAO.getActivitiesWithLocationForHome("%" + location + "%", activitiesPageSize, pageNumber));
    }

    @Override
    public String getPackagesWithLocationAndActivity(int activityID, String country) {
        List<PackagesViewDTO> packages = new ArrayList<PackagesViewDTO>();
        String activityName;
        if (!country.equals("all")) {
            activityName = packageDAO.getPackagesWithinActivityAndCountry(activityID, "%" + country + "%", 1, activitiesPageSize, packages);
        } else {
            activityName = packageDAO.getPackagesWithinActivity(activityID, 1, activitiesPageSize, packages);
        }
        String packagesJson = gson.toJson(packages);
        String result = "{\"packages\": " + packagesJson + ","
                + "\"activityName\": \"" + activityName + "\","
                + "\"activityID\": " + activityID + "}";
        return result;
    }

    @Override
    public String getPackagesWithLocationAndActivity(String dataJson) {
        JsonObject jsonObject = gson.fromJson(dataJson, JsonObject.class);
        int pageNumber = jsonObject.get("pageNumber").getAsInt();
        String country = jsonObject.get("location").getAsString();
        int activityID = jsonObject.get("activityID").getAsInt();

        List<PackagesViewDTO> packages = new ArrayList<PackagesViewDTO>();
        String activityName;
        if (!country.equals("all")) {
            activityName = packageDAO.getPackagesWithinActivityAndCountry(activityID, "%" + country + "%", pageNumber, activitiesPageSize, packages);
        } else {
            activityName = packageDAO.getPackagesWithinActivity(activityID, pageNumber, activitiesPageSize, packages);
        }
        String packagesJson = gson.toJson(packages);
        String result = "{\"packages\": " + packagesJson + ","
                + "\"activityName\": \"" + activityName + "\","
                + "\"activityID\": " + activityID + "}";
        return result;
    }

    @Override
    public List<RemindReviewEmail> getBookingList() {
        return remindReviewEmailDAO.getBookingList();
    }

    @Override
    public boolean sendRemindReviewEmail(String title, String receiver, int PackageID, String baseUrl, String bookingID) throws MessagingException {
        return commonDAO.sendMail(title, receiver, "Please click on this link to review your booked Package: " + baseUrl + "/Tripper/ReviewPackage/" + PackageID + "/" + bookingID);
    }

    @Override
    public boolean checkReviewExist(int tripperID, String bookingID) {
        return reviewDAO.checkReviewExist(tripperID, bookingID);
    }

    @Override
    public String getQuickInformationOfPackage(String dataJson) {
        JsonObject jsonObject = gson.fromJson(dataJson, JsonObject.class);
        int packageID = jsonObject.get("packageID").getAsInt();
        PackageDTO packageDTO = packageDAO.getQuickInformation(packageID);
        return gson.toJson(packageDTO);
    }

    @Override
    public String getQuickInformationOfPackage(int packageID) {
        PackageDTO packageDTO = packageDAO.getQuickInformation(packageID);
        return gson.toJson(packageDTO);
    }

    @Override
    public String insertNewKeyword(String dataJson, HttpServletRequest request) {
        JsonObject jsonObject = gson.fromJson(dataJson, JsonObject.class);
        String keyword = jsonObject.get("keyword").getAsString();
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date currentDate = new Date();
        String dateStr = dateFormat.format(currentDate);
        keywordDAO.insertNewKeyword(keyword, ip, dateStr);
        return "success";
    }

    @Override
    public boolean sendPackageViaEmail(int packageID, String senderName, String email, String message, String baseURL, String baseURLNoContext) throws MessagingException {
        PackageDTO packageResult = packageDAO.getPackageForShare(packageID);
//        String emailContent = "<html xmlns=\"http://www.w3.org/1999/xhtml\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;background-color:#fff;font-size:16px;color:#565a5c;line-height:150%'>"
//                + ""
//                + "  <head style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "  <meta name=\"viewport\" content='width=\"device-width\"' style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + ""
//                + "  "
//                + "  "
//                + "</head>"
//                + ""
//                + ""
//                + "  <body bgcolor=\"#EEEEEE\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;-webkit-text-size-adjust:none;-webkit-font-smoothing:antialiased;height:100%;line-height:150%;font-size:16px;color:#565a5c;background-color:#fff;width:100% !important'>"
//                + "    <div class=\"preheader\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;height:0;visibility:hidden;opacity:0;color:transparent;width:0;display:none !important'></div>"
//                + "    <table class=\"body-wrap\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;line-height:150%;border-spacing:0;background-color:#fff;width:100%'>"
//                + "      <tr style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "        <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></td>"
//                + "        <td class=\"container\" style='padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;display:block !important;margin:0 auto !important;clear:both !important;max-width:610px !important'>"
//                + "          <div class=\"content\" style='font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:15px;max-width:435px;margin:0 auto;display:block;padding-left:5px;padding-right:5px;padding-bottom:5px;padding-top:0px'>"
//                + "            <table class=\"head-wrap\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;line-height:150%;border-spacing:0;margin-bottom:10px;margin-top:10px;width:100%'>"
//                + "  <tr style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "    <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></td>"
//                + "    <td class=\"container header\" style='padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;display:block !important;margin:0 auto !important;clear:both !important;max-width:610px !important'>"
//                + "      <div class=\"content\" style='font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:15px;max-width:600px;margin:0 auto;display:block;padding-left:5px;padding-right:5px;padding-bottom:5px;padding-top:0px'>"
//                + "        <table style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;border-spacing:0;line-height:150%;width:100%'>"
//                + "          <tr style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "            <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;text-align: center;'>"
//                + "              <a href=\"https://www.youtripper.com\" title=\"YouTripper\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#ff5a5f;text-decoration:none'>"
//                + "                <img src=\"http://i.imgur.com/LejlkKu.png\" border=\"0\" alt=\"YouTripper\" height=\"55\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;max-width:100%;border:0'>"
//                + "              </a>"
//                + "            </td>"
//                + "          </tr>"
//                + "        </table>"
//                + "      </div>"
//                + "    </td>"
//                + "    <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></td>"
//                + "  </tr>"
//                + "</table>"
//                + ""
//                + "            "
//                + "            <div class=\"section center\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;text-align:center'>"
//                + "  "
//                + "  <div class=\"p \" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;'>"
//                + "  "
//                + "    "+senderName+" has shared a trip with you"
//                + ""
//                + "</div>"
//                + ""
//                + ""
//                + ""
//                + "  <div class=\"timestamp\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#EEEEEE;font-size:1px;height:1px;line-height:1px'>2015-12-01 10:59:29 +0000</div>"
//                + "</div>"
//                + "<br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'><br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + ""
//                + "<div class=\"section \" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "  "
//                + "  "
//                + ""
//                + ""
//                + ""
//                + "  "
//                + ""
//                + "<div class=\"panel listing-panel-top\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding-bottom:15px;padding-left:15px;padding-right:15px;padding-top:15px;border-bottom-width:1px;border-style:solid;border-color:#dbdbdb;border-left-width:1px;border-right-width:1px;border-top-width:0;padding:0px;border-bottom:0px;text-align:center;background-color:#cacccd;line-height:0;'>"
//                + "  "
//                + "    <a href=\""+baseURL+"/Common/Package/"+packageResult.getId()+"\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#ff5a5f;text-decoration:none'>"
//                + ""
//                + "  <img class=\"image-card-v2\" src=\""+baseURLNoContext+packageResult.getCoverImage()+"\" alt=\"\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;max-width:100%;border:0; height: 313px'>"
//                + ""
//                + "    </a>"
//                + ""
//                + "</div>"
//                + "<div class=\"panel listing-panel-bottom\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding-left:15px;padding-bottom:15px;border-bottom-width:1px;border-top-width:0;padding-top:15px;background-color:#ffffff;border-style:solid;border-color:#dbdbdb;border-left-width:1px;border-right-width:1px;padding-right:15px;padding:0 !important;'>"
//                + "  "
//                + "  <table style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;line-height:150%;width:100%;border-spacing:0'>"
//                + "    <tr style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "      <td class=\"listing-info\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:4px 15px'>"
//                + "        <div style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "            <a href=\""+baseURL+"/Common/Package/"+packageResult.getId()+"\" title=\""+packageResult.getName()+"\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#565a5c;text-decoration:none'>"
//                + "              "
//                + ""
//                + ""
//                + "      <strong style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"+packageResult.getName()+"</strong><br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "      <div class=\"listing-subtitle\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;color:#9ca299;font-size:14px'>"
//                + "        <span style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></span>"
//                + "      </div>"
//                + ""
//                + ""
//                + "            </a>"
//                + "        </div>"
//                + "      </td>"
//                + "        <td class=\"photo\" width=\"11%\" valign=\"top\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0px;min-width:56px;line-height:0'>"
//                + "            <a href=\""+baseURL+"/Common/ProviderPage/"+packageResult.getProviderID()+"\" title=\"\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#565a5c;text-decoration:none'>"
//                + ""
//                + "          <img src=\""+baseURLNoContext+"/"+packageResult.getProviderImage()+"\" alt=\"\" width=\"100%\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;max-width:100%;border:0'>"
//                + ""
//                + "            </a>"
//                + "        </td>"
//                + "    </tr>"
//                + "  </table>"
//                + ""
//                + "</div>"
//                + ""
//                + ""
//                + ""
//                + ""
//                + ""
//                + "  <div class=\"timestamp\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#EEEEEE;font-size:1px;height:1px;line-height:1px'>2015-12-01 10:59:29 +0000</div>"
//                + "</div>"
//                + "<br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'><br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + ""
//                + "<div class=\"section center\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;text-align:center'>"
//                + "  "
//                + "  <a class=\"btn btn-primary\" href=\""+baseURL+"/Common/Package/"+packageResult.getId()+"\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;cursor:pointer;display:block;padding:10px 16px;text-decoration:none;border-radius:2px;border:1px solid;text-align:center;vertical-align:middle;font-weight:bold;white-space:nowrap;background:#ffffff;box-shadow:0 1px 0 0 #e00007;border-color:#ff5a5f;background-color:#ff5a5f;color:#ffffff;border-top-width:1px'>"
//                + "    View Package"
//                + "  </a>"
//                + ""
//                + "  <div class=\"timestamp\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#EEEEEE;font-size:1px;height:1px;line-height:1px'>2015-12-01 10:59:29 +0000</div>"
//                + "</div>"
//                + "<br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'><br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + ""
//                + "    <div class=\"p \" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;'>"
//                + "  "
//                + "      Message from "+senderName+":"
//                + ""
//                + "</div>"
//                + ""
//                + ""
//                + "    <div class=\"p \" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;margin-top:1em;'>"
//                + "  "
//                + "      "+message+""
//                + ""
//                + "</div>"
//                + ""
//                + ""
//                + ""
//                + "          </div>"
//                + "        </td>"
//                + "        <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></td>"
//                + "      </tr>"
//                + ""
//                + "      <tr style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "        <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></td>"
//                + "        <td class=\"container no-max-width\" style='padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;display:block !important;margin:0 auto !important;clear:both !important;max-width:400px !important'>"
//                + "          <div class=\"section footer\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "  "
//                + "  <div class=\"content center text-center\" style='font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:15px;max-width:600px;margin:0 auto;display:block;padding-right:5px;padding-bottom:5px;padding-top:0px;color:#9ca299;font-size:14px;text-align:center;text-shadow:0 1px #ffffff;padding-left:5px'>"
//                + "      <table cellpadding=\"10\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;border-spacing:0;line-height:150%;width:100%;padding: 10px; Margin: auto;'>"
//                + "        <tr style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "          <td align=\"center\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "            <table cellpadding=\"5\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;border-spacing:0;line-height:150%;width:100%;width: auto;'>"
//                + "              <tr style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "                <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding: 5px;'>"
//                + "                  <a href=\"\" title=\"Facebook\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#ff5a5f;text-decoration:none'>"
//                + "                    <img alt=\"Facebook\" height=\"42\" src=\"http://i.imgur.com/NslfeQS.png\" width=\"42\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;max-width:100%;border:0'>"
//                + "</a>                </td>"
//                + ""
//                + "                <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding: 5px;'>"
//                + "                  <a href=\"\" title=\"Twitter\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#ff5a5f;text-decoration:none'>"
//                + "                    <img alt=\"Twitter\" height=\"42\" src=\"http://i.imgur.com/W2HblvK.png\" width=\"42\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;max-width:100%;border:0'>"
//                + "</a>                </td>"
//                + ""
//                + "                <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding: 5px;'>"
//                + "                  <a href=\"\" title=\"Instagram\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#ff5a5f;text-decoration:none'>"
//                + "                    <img alt=\"Instagram\" height=\"42\" src=\"http://i.imgur.com/a3Mgcl2.png\" width=\"42\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;max-width:100%;border:0'>"
//                + "</a>                </td>"
//                + ""
//                + "                <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding: 5px;'>"
//                + "                  <a href=\"\" title=\"Pinterest\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#ff5a5f;text-decoration:none'>"
//                + "                    <img alt=\"Pinterest\" height=\"42\" src=\"http://i.imgur.com/xrbTBQz.png\" width=\"42\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;max-width:100%;border:0'>"
//                + "</a>                </td>"
//                + "              </tr>"
//                + "            </table>"
//                + "          </td>"
//                + "        </tr>"
//                + "      </table>"
//                + ""
//                + "    <table class=\"row\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;border-spacing:0;line-height:150%;width:100%'>"
//                + "  <tr style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "    <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></td>"
//                + "    <td class=\"container\" style='padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;display:block !important;margin:0 auto !important;clear:both !important;max-width:610px !important'>"
//                + "      <div class=\"content\" style='font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:15px;max-width:600px;margin:0 auto;display:block;padding-right:5px;padding-bottom:5px;padding-top:0px;padding-left:5px;color:#9ca299;font-size:14px;text-align:center;text-shadow:0 1px #ffffff'>"
//                + "        "
//                + "        Sent with <img alt=\"&amp;#9829;\" height=\"10\" src=\"http://i.imgur.com/T0cwz6z.png\" width=\"12\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;max-width:100%'> from YouTripper<br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "        Address 1,<br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>Address 2"
//                + "        <br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "        <br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + "        <a class=\"muted\" href=\"https://www.YouTripper.com/email/unsubscribe?token=eyJlbWFpbF9hZGRyZXNzIjoidm4xMTIyMTFAZ21haWwuY29tIiwiY2F0ZWdvcnkiOiJzaGFyaW5nIiwidGVtcGxhdGUiOiJzaGFyZV9saXN0aW5nIiwidXVpZCI6IjFjODAyZjEzLTZkM2YtYzZjYi0zZGQ2LTMyOTc5OWM2NDA2NCJ9&amp;mac=BM1FWvP7suU8rOePJNv3gNecfuM=\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#9ca299;text-decoration:underline'>"
//                + "  Unsubscribe"
//                + "</a>"
//                + ""
//                + ""
//                + "      </div>"
//                + "    </td>"
//                + "    <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></td>"
//                + "  </tr>"
//                + "</table>"
//                + "  </div>"
//                + ""
//                + "  <div class=\"timestamp\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#EEEEEE;font-size:1px;height:1px;line-height:1px'>2015-12-01 10:59:29 +0000</div>"
//                + "</div>"
//                + "<br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'><br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
//                + ""
//                + "        </td>"
//                + "        <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></td>"
//                + "      </tr>"
//                + "    </table>"
//                + ""
//                + "    <span class=\"ghost\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;opacity:0 !important;font-size:1px !important;color:#EEEEEE !important'>### YouTripper ###</span>"
//                + "  "
//                + ""
//                + "<img src=\"http://email.YouTripper.com/wf/open?upn=1cAH4nBenyqmjw45X74OZBHKgKE7klz0sZfqOnKdspMADC55ZlzksmEGT-2Fs9hnRlcq6cuGPO86-2F2VOVzpir-2FJOPFIihE8H5lwnwWxxKHSn6-2F-2BcNquo0F0xFl9cSV2smegL-2BIt-2FBB07wCOOOJrD6-2BZBhY-2B0V5IPA8WFWXVBg7VV-2FeJhB97hxrsHkzhr6WXSRK5jgOmhf8ZX2wdkzG5Z7JcEqoU71sogqOLhNDgj8BtGtfYSAyUZG9bj-2Fe8lVftukGjahSG7oBx-2BZyXK2Zko1vJi4Dg0phAw49fImH7ChJw-2FO6xWAAl2UD8B9CGg2ILspQcGm-2BlyALmx-2BLm0Hyb6yDS94qjjJyP9CVrIfsCRNmDocA-2Be7KZV0HqgdUru1n-2B6nrpWSW6ffgJ05dv-2BJ1zbrJ5A-3D-3D\" alt=\"\" width=\"1\" height=\"1\" border=\"0\" style=\"height:1px !important;width:1px !important;border-width:0 !important;margin-top:0 !important;margin-bottom:0 !important;margin-right:0 !important;margin-left:0 !important;padding-top:0 !important;padding-bottom:0 !important;padding-right:0 !important;padding-left:0 !important;\"/>"
//                + "</body>"
//                + "  <img class=\"tracking\" src=\"https://www.YouTripper.com/tracking/pixel/email_opened/1448967569?rookery_uuid=1c802f13-6d3f-c6cb-3dd6-329799c64064\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;max-width:100%'>"
//                + ""
//                + "</html>";
        int evenPrice = (int) Math.round(packageResult.getRate());
        String star = "";
        int i = 0;
        for (; i < evenPrice; i++) {
            star += "<li style='margin:0;padding:0; background: url(http://i.imgur.com/DpAfiN9.png);"
                    + "                                                        background-repeat: no-repeat;     background-size: cover;     width: 14px; height: 13px;"
                    + "                                                        margin-left: 2px; white-space: nowrap; list-style: none;"
                    + "                                                        font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif; float: left'>"
                    + "</li>";
        }
        for (; i < 5; i++) {
            star += "<li style='margin:0;padding:0; background: url(http://i.imgur.com/57FDU3b.png);"
                    + "                                                        background-repeat: no-repeat;     background-size: cover;     width: 14px; height: 13px;"
                    + "                                                        margin-left: 2px; white-space: nowrap; list-style: none;"
                    + "                                                        font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif; float: left'>"
                    + "</li>";
        }
        String emailContent = "<html xmlns=\"http://www.w3.org/1999/xhtml\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "      background-color:#fff;font-size:16px;color:#565a5c;line-height:150%'> "
                + "    <head style='margin:0;padding:0;"
                + "          font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>  "
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" style='margin:0;padding:0;"
                + "              font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'> "
                + "            <meta name=\"viewport\" content='width=\"device-width\"' "
                + "                  style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'> "
                + "    </head> "
                + "    <body bgcolor=\"#EEEEEE\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "          -webkit-text-size-adjust:none;-webkit-font-smoothing:antialiased;height:100%;"
                + "          line-height:150%;font-size:16px;color:#565a5c;background-color:#fff;width:100% !important'>   "
                + "        <div class=\"preheader\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;height:0;"
                + "             visibility:hidden;opacity:0;color:transparent;width:0;display:none !important'></div>   "
                + "        <table class=\"body-wrap\""
                + "               style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;line-height:150%;"
                + "               border-spacing:0;background-color:#fff;width:100%'>      <tr style='margin:0;padding:0;"
                + "                    font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>       "
                + "                <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></td>     "
                + "                <td class=\"container\" style='padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;display:block !important;"
                + "                    margin:0 auto !important;clear:both !important;max-width:610px !important'>   "
                + "                    <div class=\"content\" style='font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "                         padding:15px;max-width:435px;margin:0 auto;display:block;padding-left:5px;padding-right:5px;padding-bottom:5px;padding-top:0px'>    "
                + "                        <table class=\"head-wrap\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "                               line-height:150%;border-spacing:0;margin-bottom:10px;margin-top:10px;width:100%'>"
                + "                            <tr style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>   "
                + "                                <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></td> "
                + "                                <td class=\"container header\" style='padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "                                    display:block !important;margin:0 auto !important;clear:both !important;max-width:610px !important'>"
                + "                                    <div class=\"content\" style='font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:15px;"
                + "                                         max-width:600px;margin:0 auto;display:block;padding-left:5px;padding-right:5px;padding-bottom:5px;padding-top:0px'>   "
                + "                                        <table style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;border-spacing:0;line-height:150%;width:100%'>"
                + "                                            <tr style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>      "
                + "                                                <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;text-align: center;'>      "
                + "                                                    <a href=\"https://www.youtripper.com\" title=\"YouTripper\" style='margin:0;padding:0;"
                + "                                                       font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#ff5a5f;text-decoration:none'>             "
                + "                                                        <img src=\"http://i.imgur.com/LejlkKu.png\" border=\"0\" alt=\"YouTripper\" height=\"55\" "
                + "                                                             style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;max-width:100%;border:0'>  "
                + "                                                    </a>      "
                + "                                                </td>        "
                + "                                            </tr>      "
                + "                                        </table>     "
                + "                                    </div>    "
                + "                                </td>  "
                + "                                <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></td>  </tr>"
                + "                        </table>                        "
                + "                        <div class=\"section center\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;text-align:center'> "
                + "                            <div class=\"p \" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;'>"
                + "                                " + senderName + " has shared a trip with you</div>  "
                + "                            <div class=\"timestamp\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "                                 color:#EEEEEE;font-size:1px;height:1px;line-height:1px'>2015-12-01 10:59:29 +0000</div>"
                + "                        </div>"
                + "                        <br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'/>"
                + "                        <br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'/>"
                + "                        <div class=\"section \" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'> "
                + "                            <div class=\"panel listing-panel-top\" "
                + "                                 style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "                                 padding-bottom:15px;padding-left:15px;padding-right:15px;padding-top:15px;"
                + "                                 padding:0px;text-align:center;line-height:0;'>   "
                + "                                <a href=\"" + baseURL + "/Package/" + packageResult.getId() + "\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#ff5a5f;text-decoration:none'>"
                + "                                    <div class=\"image-card-v2\" style=\"background: url(http://i.imgur.com/wFaBxvN.jpg) no-repeat center / cover;"
                + "                                         background-size: cover; margin:0; width: 100%; height: 313px; position: relative\">"
                + "                                        <span style=\"top: 15px; right: 15px; color: #fff;padding: 6px 12px; line-height: 24px; margin-top: 15px; margin-right: 15px;"
                + "                                              position: absolute; font-size: 2em; border-radius: 17px; background-color: #E76B4A; float: right;"
                + "                                              box-shadow: 0 1px 1px rgba(0,0,0,.075); -webkit-box-shadow: 0 1px 1px rgba(0,0,0,.075);\">$" + packageResult.getOrdinaryPriceForAdult() + "</span>"
                + "                                    </div>"
                + "                                </a>"
                + "                            </div>"
                + "                            <div class=\"panel listing-panel-bottom\""
                + "                                 style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "                                 padding-left:15px;padding-bottom:15px;border-bottom-width:1px;border-top-width:0;padding-top:15px;"
                + "                                 background-color:#ECECEC;padding-right:15px;padding:0 !important;'>    "
                + "                                <table style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;line-height:"
                + "                                       150%;width:100%;border-spacing:0'>   "
                + "                                    <tr style='margin:0;padding:0;"
                + "                                        font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
                + "                                        <td colspan=\"2\" style='margin:0;"
                + "                                            font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:4px 15px'>"
                + "                                            <strong>" + packageResult.getName() + "</strong>"
                + "                                        </td>"
                + "                                    </tr>"
                + "                                    <tr style='margin:0;padding:0;"
                + "                                        font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>   "
                + "                                        <td style='margin:0;"
                + "                                            font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:4px 15px'>"
                + "                                            <div style='background: url(http://i.imgur.com/sTCydxO.jpg) no-repeat center / cover; background-size: cover;"
                + "                                                 width: 42px; height: 42px; border-radius: 50%;overflow: hidden;float: left' >"
                + ""
                + "                                            </div>"
                + "                                            <div style='margin:0;"
                + "                                                 font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif; float:left; line-height: 42px;"
                + "                                                 margin-left: 10px; font-size: 14px'>"
                + packageResult.getProviderName()
                + "                                            </div>"
                + "                                        </td>"
                + "                                        <td style='margin:0;"
                + "                                            font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:4px 15px'> "
                + "                                            <div style='margin:0;"
                + "                                                 font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif; float:right;"
                + "                                                 paddig-top: 12px; padding-left: 0px;'>"
                + "                                                <ul style='margin:0;padding:0; font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "                                                    float: right; line-height: 0;'>"
                + star
                + "                                                </ul>"
                + "                                                <span style='margin:0;padding:0; font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "                                                      float: right;font-size: 11px;font-weight: bold; white-space: nowrap; width: 100%; text-align: right;"
                + "                                                      line-height: 14px;'>"
                + packageResult.getNumberOfRates() + " Reviews"
                + "                                                </span>"
                + "                                            </div>"
                + "                                        </td>"
                + ""
                + "                                </table>"
                + "                            </div>  "
                + "                            <div class=\"timestamp\" "
                + "                                 style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "                                 color:#EEEEEE;font-size:1px;height:1px;line-height:1px'>2015-12-01 10:59:29 +0000</div>"
                + ""
                + "                        </div>"
                + "                        <br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'/>"
                + "                        <br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'/>"
                + "                        <div class=\"section center\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "                             padding:0;text-align:center'> "
                + "                            <a class=\"btn btn-primary\" href=\"" + baseURL + "/Package/" + packageResult.getId() + "\""
                + "                               style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "                               cursor:pointer;display:block;padding:10px 16px;text-decoration:none;"
                + "                               text-align:center;"
                + "                               vertical-align:middle;font-weight:bold;white-space:nowrap;"
                + "                               background-color:#e95d48; border-radius: 20px;"
                + "                               box-shadow: 2px 2px 0px 1px #cf4e3f;"
                + "                               color:#ffffff;border-top-width:1px'>"
                + "                                View Package "
                + "                            </a> "
                + "                            <div class=\"timestamp\" "
                + "                                 style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "                                 color:#EEEEEE;font-size:1px;height:1px;line-height:1px'>2015-12-01 10:59:29 +0000</div>"
                + ""
                + "                        </div>"
                + "                        <br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'/>"
                + "                        <br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'/> "
                + "                        <div class=\"p \" style='margin:0;padding:0;"
                + "                             font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;'>Message from " + senderName + ":</div> "
                + "                        <div class=\"p \" style='margin:0;"
                + "                             font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;margin-top:1em;'>"
                + message
                + "                        </div>         "
                + "                    </div>      "
                + "                </td>       "
                + "                <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></td>    "
                + "            </tr>    "
                + "            <tr style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>    "
                + "                <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></td>      "
                + "                <td class=\"container no-max-width\" style='padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "                    display:block !important;margin:0 auto !important;clear:both !important;max-width:610px !important'>    "
                + "                    <div class=\"section footer\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>  "
                + "                        <div class=\"content center text-center\""
                + "                             style='font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "                             padding:15px;max-width:600px;margin:0 auto;display:block;padding-right:5px;"
                + "                             padding-bottom:5px;padding-top:0px;color:#9ca299;font-size:14px;"
                + "                             text-align:center;text-shadow:0 1px #ffffff;padding-left:5px'> "
                + "                            <table class=\"row\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;border-spacing:0;line-height:150%;width:100%'>"
                + "                                <tr style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>    <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></td>   "
                + "                                    <td class=\"container\" style='padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;display:block !important;margin:0 auto !important;clear:both !important;max-width:610px !important'>     "
                + "                                        <div class=\"content\" style='font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:15px;max-width:600px;margin:0 auto;"
                + "                                             display:block;padding-right:5px;padding-bottom:5px;padding-top:0px;padding-left:5px;"
                + "                                             color:#9ca299;font-size:14px;text-align:center;text-shadow:0 1px #ffffff'>  "
                + "                                            Sent from YouTripper"
                + "                                        </div>"
                + "                                    </td>   "
                + "                                    <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></td>  "
                + "                                </tr>"
                + "                            </table>"
                + "                            <table cellpadding=\"10\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;border-spacing:0;line-height:150%;width:100%;padding: 10px; Margin: auto;'>       "
                + "                                <tr style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>          <td align=\"center\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>       "
                + "                                        <table cellpadding=\"5\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;border-spacing:0;line-height:150%;width:100%;width: auto;'>       "
                + "                                            <tr style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>      "
                + "                                                <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding: 5px;'>   "
                + "                                                    <a href=\"\" title=\"Facebook\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#ff5a5f;text-decoration:none'>                 "
                + "                                                        <img alt=\"Facebook\" height=\"42\" src=\"http://i.imgur.com/NslfeQS.png\" width=\"42\" style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;max-width:100%;border:0'></a>              "
                + "                                                </td>            "
                + "                                                <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding: 5px;'>       "
                + "                                                    <a href=\"\" title=\"Twitter\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#ff5a5f;text-decoration:none'> "
                + "                                                        <img alt=\"Twitter\" height=\"42\" src=\"http://i.imgur.com/W2HblvK.png\" width=\"42\""
                + "                                                             style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;max-width:100%;border:0'></a>    "
                + "                                                </td>                <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding: 5px;'>   "
                + "                                                    <a href=\"\" title=\"Instagram\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#ff5a5f;text-decoration:none'>   "
                + "                                                        <img alt=\"Instagram\" height=\"42\" src=\"http://i.imgur.com/a3Mgcl2.png\" width=\"42\" "
                + "                                                             style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;max-width:100%;border:0'></a>"
                + "                                                </td>                <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding: 5px;'>      "
                + "                                                    <a href=\"\" title=\"Pinterest\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;color:#ff5a5f;text-decoration:none'>  "
                + "                                                        <img alt=\"Pinterest\" height=\"42\" src=\"http://i.imgur.com/xrbTBQz.png\" width=\"42\" "
                + "                                                             style='margin:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:0;max-width:100%;border:0'></a>  "
                + "                                                </td>              </tr>            "
                + "                                        </table>   "
                + "                                    </td>       "
                + "                                </tr>   "
                + "                            </table>"
                + "                            <table cellpadding=\"10\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;border-spacing:0;line-height:150%;width:100%;padding: 10px; margin: auto;'> "
                + "                                <tr style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
                + "                                    <td  class=\"container\" align=\"center\" style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'>"
                + "                                        <div class=\"content\" style='font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;padding:15px;max-width:600px;margin:0 auto;"
                + "                                             display:block;padding-right:5px;padding-bottom:5px;padding-top:0px;padding-left:5px;"
                + "                                             color:#9ca299;font-size:14px;text-align:center;text-shadow:0 1px #ffffff'>  "
                + "                                            Youtripper Ltd., 56 Soi Seri Villa, Srinakarin Rd., Nongbon, <br style='margin: 0px; padding:0px'/>"
                + "                                            Pravet, Bangkok, Thailand 10250"
                + "                                        </div>"
                + "                                    </td>"
                + "                                </tr>"
                + "                            </table>"
                + "                        </div> "
                + "                        <div class=\"timestamp\" style='margin:0;padding:0;"
                + "                             font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"
                + "                             color:#EEEEEE;font-size:1px;height:1px;line-height:1px'>2015-12-01 10:59:29 +0000</div>"
                + ""
                + "                    </div>"
                + "                    <br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'/>"
                + "                    <br style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'/>       "
                + "                </td>      "
                + "                <td style='margin:0;padding:0;font-family:\"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif'></td>     "
                + "            </tr>  "
                + "        </table>   "
                + "    </body>"
                + "</html>";
        return commonDAO.sendMail(senderName + " shared a trip with you", email, emailContent);
    }

    @Override
    public boolean deleteEmail(String token) {
        return forgotPasswordDAO.deleteEmail(token);
    }

//    @Override
//    public AccountSession updateImage(AccountSession account) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
    @Override
    public AdminSession loginToAdmin(String username, String password) {
        return adminDAO.login(username, password);
    }

    @Override
    public String getSimilarPackages(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        int packageID = jsonObject.get("packageID").getAsInt();
        List<PackagesViewDTO> packages = packageDAO.getSimiliarPackages(packageID);
        return gson.toJson(packages);
    }

    @Override
    public String getPackageForComparisonList(String data, String comparisonListData) {
        Type listType = new TypeToken<ArrayList<PackagesViewDTO>>() {
        }.getType();
        List<PackagesViewDTO> packages = gson.fromJson(comparisonListData, listType);
        if (packages == null) {
            packages = new ArrayList<PackagesViewDTO>();
        }
        if (packages.size() < 5) {
            JsonObject object = gson.fromJson(data, JsonObject.class);
            int packageID = object.get("packageID").getAsInt();
            for (PackagesViewDTO aPackage : packages) {
                if (aPackage.getPackageID() == packageID) {
                    return "{\"result\": \"exist\"}";
                }
            }
            PackagesViewDTO newPackage = packageDAO.getPackagesForAddingToComparison(packageID);
            if (newPackage != null) {
                packages.add(newPackage);
                return gson.toJson(packages);
            } else {
                return "{\"result\": \"error\"}";
            }
        } else {
            return "{\"result\": \"full\"}";
        }
    }

    @Override
    public String getComparisonList(String data) {
        Type listType = new TypeToken<ArrayList<PackagesViewDTO>>() {
        }.getType();
        List<PackagesViewDTO> packages = gson.fromJson(data, listType);
        if (packages == null) {
            packages = new ArrayList<PackagesViewDTO>();
        }
        return gson.toJson(packageDAO.getPackagesForComparison(packages));
    }

    @Override
    public String removePackageFromComparisonList(String data, String comparisonListData) {
        Type listType = new TypeToken<ArrayList<PackagesViewDTO>>() {
        }.getType();
        List<PackagesViewDTO> packages = gson.fromJson(comparisonListData, listType);
        JsonObject object = gson.fromJson(data, JsonObject.class);
        int position = object.get("position").getAsInt();
        packages.remove(position);
        return gson.toJson(packages);
    }

    @Override
    public String liveSearch(String searchText) {
        return gson.toJson(commonDAO.liveSearch("%" + searchText + "%"));
    }

    @Override
    public String getAllSubCategoriesWithinLocation(String dataJson) {
        JsonObject jsonObject = gson.fromJson(dataJson, JsonObject.class);
        int categoryID = jsonObject.get("categoryID").getAsInt();
        String location = jsonObject.get("location").getAsString();
        if (location.equals("all")) {
            return "all";
        }
        return gson.toJson(subCategoryDAO.getAllSubCategoriesWithinLocation("%" + location + "%", categoryID));
    }

    @Override
    public String searchPackageBelongtoSub(String searchText, String location, int subID) {
        AdvancedSearchForm form = commonDAO.searchPackageBelongtoSub("%" + searchText + "%", location, subID, 1, searchPageSize);
        if (form.getPackages().size() <= 0) {
            List<String> suggestionKeywords = getSuggestionKeywords(searchText);
            if (suggestionKeywords.size() > 0) {
                HashMap<String, PackagesViewDTO> suggestion = new HashMap<>();
                List<PackagesViewDTO> suggestionPackages = packageDAO.getSuggestionPackages(suggestionKeywords);
                for (int i = 0; i < suggestionPackages.size(); i++) {
                    suggestion.put(suggestionKeywords.get(i), suggestionPackages.get(i));
                }
                form.setSuggestion(suggestion);
            }
        }
        return gson.toJson(form);
    }

    @Override
    public List<PackagesViewDTO> citySearch(HttpServletRequest request, HttpSession session) {
        String cityName = request.getParameter("cityName");
        
        List<PackagesViewDTO> packages = packageDAO.citySearch(cityName);
        
//return string
        //return gson.toJson(packages);
        return packages;
        
    }
    
    @Override
    public String smartSearchPakages(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String searchText = jsonObject.get("searchText").getAsString();
        String trips = jsonObject.get("trips").getAsString();
        String groups = jsonObject.get("groups").getAsString();

        double minPrice = jsonObject.get("minPrice").getAsDouble();
        double maxPrice = jsonObject.get("maxPrice").getAsDouble();

//        int rate = jsonObject.get("rate").getAsInt();
//        if (rate == 0) {
//            rate = -1;
//        }
        int pageNumber = jsonObject.get("pageNumber").getAsInt();

        String minDuration = jsonObject.get("minDuration").getAsString();
        String maxDuration = jsonObject.get("maxDuration").getAsString();
        String durationType = jsonObject.get("durationType").getAsString();

        String language = jsonObject.get("language").getAsString();

        String servingType = jsonObject.get("servingType").getAsString();

        String date = jsonObject.get("date").getAsString();
        int noTripper = jsonObject.get("noTripper").getAsInt();

        int sortType = jsonObject.get("sortType").getAsInt();
        //get city from place near me
        String city = jsonObject.get("city").getAsString();
        //get lat from place near me
        double lat = jsonObject.get("lat").getAsDouble();
        //get lng from place near me
        double lng = jsonObject.get("lng").getAsDouble();
        List<PackagesViewDTO> packages = packageDAO.smarteSearchPakages(searchText, trips, groups, minDuration, maxDuration,
                durationType, language, servingType, date, noTripper, minPrice, maxPrice, pageNumber, searchPageSize, sortType, city, lat, lng);

        if (packages.size() <= 0) {
            List<String> suggestionKeywords = getSuggestionKeywords(searchText);
            if (suggestionKeywords.size() > 0) {
                HashMap<String, PackagesViewDTO> suggestion = new HashMap<>();
                List<PackagesViewDTO> suggestionPackages = packageDAO.getSuggestionPackages(suggestionKeywords);
                for (int i = 0; i < suggestionPackages.size(); i++) {
                    suggestion.put(suggestionKeywords.get(i), suggestionPackages.get(i));
                }
                return gson.toJson(suggestion);
            }
        }
        return gson.toJson(packages);
    }

    @Override
    public String matrixSearchPakages(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);

        String searchText = jsonObject.get("searchText").getAsString();
        String trips = jsonObject.get("trips").getAsString();
        String groups = jsonObject.get("groups").getAsString();

        double minPrice = jsonObject.get("minPrice").getAsDouble();
        double maxPrice = jsonObject.get("maxPrice").getAsDouble();

//        int rate = jsonObject.get("rate").getAsInt();
//        if (rate == 0) {
//            rate = -1;
//        }
        int pageNumber = jsonObject.get("pageNumber").getAsInt();

        String minDuration = jsonObject.get("minDuration").getAsString();
        String maxDuration = jsonObject.get("maxDuration").getAsString();
        String durationType = jsonObject.get("durationType").getAsString();

        String language = jsonObject.get("language").getAsString();

        String servingType = jsonObject.get("servingType").getAsString();

        String date = jsonObject.get("date").getAsString();
        int noTripper = jsonObject.get("noTripper").getAsInt();

        String location = jsonObject.get("location").getAsString();
        if (location.equals("All")) {
            location = "";
        }

        String subCate = jsonObject.get("subCate").getAsString();

        int sortType = jsonObject.get("sortType").getAsInt();
        List<PackagesViewDTO> packages = packageDAO.matrixSearchPakages(searchText, trips, groups, minDuration, maxDuration,
                durationType, language, servingType, date, noTripper, minPrice, maxPrice, pageNumber, searchPageSize, location, subCate, sortType);
        if (packages.size() <= 0) {
            List<String> suggestionKeywords = getSuggestionKeywords(searchText);
            if (suggestionKeywords.size() > 0) {
                HashMap<String, PackagesViewDTO> suggestion = new HashMap<>();
                List<PackagesViewDTO> suggestionPackages = packageDAO.getSuggestionPackages(suggestionKeywords);
                for (int i = 0; i < suggestionPackages.size(); i++) {
                    suggestion.put(suggestionKeywords.get(i), suggestionPackages.get(i));
                }
                return gson.toJson(suggestion);
            }
        }
        return gson.toJson(packages);
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
    public void updateKeyWordByPackage(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        int packageID = jsonObject.get("packageID").getAsInt();
        systemKeywordDAO.updateKeywordByPackage(packageID);
    }

    @Override
    public String getFilterOptionOnlyKeyword(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String searchText = jsonObject.get("searchText").getAsString();
        int numOfRecord = jsonObject.get("numOfRecord").getAsInt();
        return gson.toJson(packageDAO.getFilterOptionOnlyKeyword(searchText, numOfRecord));
    }

    @Override
    public String getNoTripperOfSpecificDate(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String date = jsonObject.get("date").getAsString();
        int packageID = jsonObject.get("packageID").getAsInt();
        return gson.toJson(bookingDAO.getNumberTripperOfSpecificDate(date, packageID));
    }

    @Override
    public int getNoOfBookedPackages(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        int packageID = jsonObject.get("packageID").getAsInt();
        String selectedDate = jsonObject.get("selectedDate").getAsString();
        return packageDAO.getNoOfBookedPackages(packageID, selectedDate);
    }

    @Override
    public String getFilterOptionOnlyLocation(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String searchText = jsonObject.get("searchText").getAsString();
        int numOfRecord = jsonObject.get("numOfRecord").getAsInt();
        return gson.toJson(packageDAO.getFilterOptionOnlyLocation(searchText, numOfRecord));
    }

    @Override
    public String getFilterOptionOnlyPackage(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String searchText = jsonObject.get("searchText").getAsString();
        int numOfRecord = jsonObject.get("numOfRecord").getAsInt();
        return gson.toJson(packageDAO.getFilterOptionOnlyPackage(searchText, numOfRecord));
    }

    @Override
    public void updateNearMeJson() {
        nearMeJson = gson.toJson(packageDAO.getNearMeData());
    }

    @Override
    public boolean logNewVisitor(int affiliateCode, String referrerURL, String ip, String device, String visitTime, String visitURL) {
        return trackingUserDAO.logNewVisitor(affiliateCode, referrerURL, ip, device, visitTime, visitURL);
    }

    @Override
    public boolean existingUserLogin(String username, String role, String time, String ip) {
        return trackingUserDAO.existingUserLogin(username, role, time, ip);
    }

    @Override
    public boolean insertNewLanguage() {
        return commonDAO.insertNewLanguage();
    }

    @Override
    public String getQuickComparison(int packageID) {
        return gson.toJson(packageDAO.getQuickComparison(packageID));
    }

    @Override
    public boolean sendMail(HttpServletRequest request) throws MessagingException {
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
        String receiver = request.getParameter("email");

        StringBuilder messageContentHtml = new StringBuilder();
        messageContentHtml.append(request.getParameter("message") + "<br />\n");
        messageContentHtml.append("You can become to a provider from here: http://beta.youtripper.com/Common/BeProvider");
        String messageContent = messageContentHtml.toString();

//        String messageContent = ;
//        messageContent = messageContent + "\r\n";
//        messageContent = messageContent + "\n";
//        
//        messageContent = messageContent + "You can become to a provider from here: http://beta.youtripper.com/Common/BeProvider";
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("registration@youtripper.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(receiver));
        message.setSubject(title);
        message.setContent(messageContent, "text/html; charset=utf-8");
        Transport.send(message);
        return true;

    }

    @Override
    public List<PackageDTOv2> getNewTrip() {
        return packageDAO.loadNewTrip();
    }

    @Override
    public List<PackageDTOv2> getNewTrip2() {
        return (List<PackageDTOv2>) packageDAO.loadNewTrip();
    }

    @Override
    public String isAvailableForSpecificDate(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        int packageID = jsonObject.get("packageID").getAsInt();
        String tripDate = jsonObject.get("tripDate").getAsString();
        boolean isAvailable = usedResourcesDAO.isDateAvailable(packageID, tripDate);
        return "{\"result\":" + isAvailable + "}";
    }

    @Override
    public String isAvailableForSpecificTime(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        int packageID = jsonObject.get("packageID").getAsInt();
        String tripDate = jsonObject.get("tripDate").getAsString();
        String tripTime = jsonObject.get("tripTime").getAsString();
        boolean isAvailable = usedResourcesDAO.isDateAvailable(packageID, tripDate);
        return "{\"result\":" + isAvailable + "}";
    }

    @Override
    public String isJointBooked(String data) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        int packageID = jsonObject.get("packageID").getAsInt();
        String tripDate = jsonObject.get("tripDate").getAsString();
        String tripTime = jsonObject.get("tripTime").getAsString();
        boolean isBooked = bookingDAO.isJointBooked(packageID, tripDate, tripTime);
        return "{\"result\":" + isBooked + "}";
    }

    @Override
    public String getGeolocation() {
        String macAddress = "";
        try {
            InetAddress ip = InetAddress.getLocalHost();

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            macAddress = sb.toString();
        } catch (UnknownHostException | SocketException ex) {
            Logger.getLogger(CommonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return macAddress;
    }

    @Override
    public AccountSession loginToYoutripperFacebook(String email) {
        return commonDAO.loginToYouTripperFacebook(email);
    }

    @Override
    public String getToDateUnderFormatMMddyyyy() {
        DateTime toDateObj = new DateTime();
        String toDate = toDateObj.toString("MM/dd/yyyy");
        return toDate;
    }

    @Override
    public String getPreviewPackageEditing(int packageID) {
        return gson.toJson(packageDAO.getPreviewPackageEditing(packageID));
    }

    @Override
    public String getToDateUnderFormatyyyyMMdd() {
        String timeNow = new DateTime().toString("yyyy-MM-dd");
        return timeNow;
    }

    @Override
    public String getToDateInMillisecond() {
        DateTime toDateObj = new DateTime();
        Date result = new Date(toDateObj.getYear() - 1900, toDateObj.getMonthOfYear() - 1, toDateObj.getDayOfMonth());
        return String.valueOf(result.getTime() + Long.valueOf("86400000"));
    }

    @Override
    public List<PackageDTO> getRecommendedPackage() {
        return packageDAO.getRecommededPackage();
    }

    @Override
    public List<PackageDTO> getPackageInBangkok() {
        return packageDAO.getPackageInBangkok();
    }

}
