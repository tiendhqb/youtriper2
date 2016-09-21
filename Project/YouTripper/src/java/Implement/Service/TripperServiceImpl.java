/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.Service;

import DTO.AccountSession;
import DTO.BookingDTO;
import DTO.PackageDTO;
import DTO.TripperDTO;
import DTO.TripperNotification;
import DTO.TripperNotificationSetting;
import DTO.UsedResourcesViewDTO;
import Interface.DAO.BookingDAO;
import Interface.DAO.BucketListDAO;
import Interface.DAO.PackageDAO;
import Interface.DAO.ReviewDAO;
import Interface.DAO.TripperDAO;
import Interface.DAO.TripperNotificationDAO;
import Interface.DAO.TripperSystemNotificationDAO;
import Interface.Service.TripperService;
import JavaClass.FileMeta;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.Item;
import com.paypal.base.rest.PayPalRESTException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Nick
 */
public class TripperServiceImpl implements TripperService {

    @Autowired
    TripperDAO tripperDAO;

    @Autowired
    PackageDAO packageDAO;

    @Autowired
    BookingDAO bookingDAO;

    @Autowired
    BucketListDAO bucketListDAO;

    @Autowired
    TripperNotificationDAO tripperNotificationDAO;

    @Autowired
    ReviewDAO reviewDAO;

    @Autowired
    TripperSystemNotificationDAO tripperSystemNotificationDAO;

    private final Gson gson;

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final int CODE_LENGTH = 12;

    public TripperServiceImpl() {
        gson = new Gson();
    }

    @Override
    public boolean isUser(AccountSession account) {
        return account != null && account.getRole() == 1;
    }

    @Override
    public PackageDTO getPackageForPayment(int packageID) {
        return packageDAO.getPackageForPayment(packageID);
    }

    @Override
    public List<Double> getPriceOfSelectedDate(String selectedDate, PackageDTO packageDTO) throws ParseException {
        String promotionJson = packageDTO.getPromotionJson();
        JsonArray promotions = gson.fromJson(promotionJson, JsonArray.class);
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date selectDate;
        selectDate = format.parse(selectedDate);
        double priceAdult = 0;
        double priceChild = 0;
        for (JsonElement promotion : promotions) {
            JsonObject jsonObject = promotion.getAsJsonObject();
            JsonArray datesArray = jsonObject.get("dates").getAsJsonArray();
            for (JsonElement dateJson : datesArray) {
                String dateStr = dateJson.getAsString();
                Date promotionDate = format.parse(dateStr);
                if (selectDate.compareTo(promotionDate) == 0) {
                    priceAdult = jsonObject.get("priceAdult").getAsDouble();
                    priceChild = jsonObject.get("priceChild").getAsDouble();
                    break;
                }
            }
            if (priceAdult > 0) {
                break;
            }
        }
        List<Double> prices = new ArrayList<Double>();
        if (priceAdult > 0) {
            prices.add(priceAdult);
            prices.add(priceChild);
        } else {
            prices.add(packageDTO.getOrdinaryPriceForAdult());
            prices.add(packageDTO.getOrdinaryPriceForChild());
        }
        return prices;
    }

    @Override
    public String getBookingCode() {
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
    public boolean insertBooking(String code, int packageID, String selectedDate, int numberOfChilds, int numberOfAdult, int accountID) throws ParseException {
        PackageDTO packgeDTO = getPackageForPayment(packageID);
        List<Double> prices = getPriceOfSelectedDate(selectedDate, packgeDTO);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String bookingDate = dateFormat.format(date);
        int noOfPackages = 0;
        if (!packgeDTO.isIsPrivateTour()) {
            noOfPackages = numberOfAdult + numberOfChilds;
        } else {
            noOfPackages = (int) Math.round(Math.ceil((float) (numberOfAdult + numberOfChilds) / packgeDTO.getMinTripper()));
        }
        BookingDTO bookingDTO = new BookingDTO(code, bookingDate, selectedDate, numberOfAdult, numberOfChilds, noOfPackages,
                prices.get(0), prices.get(1), accountID, packgeDTO.getId(), packgeDTO.getProviderID());
        return bookingDAO.insertNewBooking(bookingDTO);
    }

    @Override
    public List<TripperNotification> getTripperNotification() {
        List<TripperNotification> result = tripperNotificationDAO.getTripperNotification();
        return result;
    }

    @Override
    public List<TripperNotificationSetting> getTripperNotificationSetting(int tripperID) {

        return tripperNotificationDAO.getTripperNotificationSetting(tripperID);

    }

    @Override
    public TripperDTO getTripperAccount(int tripperID) {
        return tripperDAO.getTripperAccount(tripperID);

    }

    @Override
    public List<BookingDTO> getBookingListForTripper(int tripperID) {

        return bookingDAO.getBookingForTripper(tripperID);

    }

    @Override
    public boolean updateTripperImage(int tripperID, String image) {
        return tripperDAO.updateTripperImage(tripperID, image);
    }

    @Override
    public boolean saveSetting(int tripperID, String settingValue) {

        Type typeOfT = new TypeToken<List<Integer>>() {
        }.getType();
        List<Integer> settings = gson.fromJson(settingValue, typeOfT);
        tripperNotificationDAO.deleteSetting(tripperID);
        for (int i = 0; i < settings.size(); i++) {
            tripperNotificationDAO.saveSetting(tripperID, settings.get(i));
        }
        return true;

    }

    @Override
    public boolean saveWishList(String data, HttpSession session) {
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        int packageID = jsonObject.get("packageID").getAsInt();
        AccountSession account = (AccountSession) session.getAttribute("account");
        int tripperID = account.getId();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date now = new Date();
        String currentDate = sdf.format(now);
        return bucketListDAO.saveWishList(packageID, tripperID, currentDate);
    }

    @Override
    public boolean removeWishlist(int packageID, HttpSession session) {
        AccountSession account = (AccountSession) session.getAttribute("account");
        int tripperID = account.getId();
        return bucketListDAO.removeFromWishList(packageID, tripperID);
    }

   

    @Override
    public AccountSession updateTripperInformation(HttpServletRequest request, HttpSession session) {
        int countryID;
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNumber = request.getParameter("phoneNumber");
        if (firstName.equals("") || lastName.equals("")) {
            return null;
        }
        if (request.getParameter("singleSelect") == null || request.getParameter("singleSelect").equals("?")) {
            countryID = 0;
        } else {
            countryID = Integer.valueOf(request.getParameter("singleSelect"));
        }
        String address = request.getParameter("address");
        String information = request.getParameter("information");
        String interests = request.getParameter("interests");
        String language = request.getParameter("language");
        String notification = request.getParameter("notification");
        AccountSession account = (AccountSession) session.getAttribute("account");
        int tripperID = account.getId();

        return tripperDAO.updateTripperInformation(firstName, lastName, phoneNumber, countryID, address, information, interests, language, tripperID, notification);
    }

    @Override
    public boolean changeTripperPassword(int tripperID, String oldPassword, String newPassword) {
        return tripperDAO.changeTripperPassword(tripperID, oldPassword, newPassword);
    }

    @Override
    public boolean paywithCreditCard(String cardType, String cardNumber, int expireMonth, int expireYear, int cvv,
            String FirstName, String LastName, String currency, String amount, String description) throws PayPalRESTException {
        return tripperDAO.paywithCreditCard(cardType, cardNumber, expireMonth, expireYear, cvv, FirstName, LastName, currency, amount, description);
    }

    @Override
    public String paywithPaypal(AccountSession account, int packageID, int numberOfChilds, int numberOfAdults,
            String selectedDate, HttpServletRequest request, String currency, String amount, String description, List<Item> item) throws PayPalRESTException {
        return tripperDAO.paywithPaypal(account, packageID, numberOfChilds, numberOfAdults, selectedDate, request, currency, amount, description, item);
    }

    @Override
    public boolean verifyPayment(String paymentID, String payerID) throws PayPalRESTException {
        return tripperDAO.verifyPayment(paymentID, payerID);
    }

    @Override
    public boolean makeReview(int tripperID, String bookingID, int packageID, String review, double rate, int Professionlism, int StaffAttitude, int Convenient, int Satisfaction, int AmenityQuality, int Cleanliness) {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date now = new Date();
        String currentDate = format.format(now);
        return reviewDAO.makeReview(tripperID, bookingID, packageID, review, rate, currentDate, Professionlism, StaffAttitude, Convenient, Satisfaction, AmenityQuality, Cleanliness);
    }

    @Override
    public boolean insertNewTripperSystemNotification(String content, boolean seen, int tripperID) {
        return tripperSystemNotificationDAO.insertNewTripperSystemNotification(content, seen, tripperID);
    }

    @Override
    public boolean seenNotification(int notificationID) {
        return tripperSystemNotificationDAO.seenNotification(notificationID);
    }

    @Override
    public String getTripperNewNotification(int tripperID) {
        return gson.toJson(tripperSystemNotificationDAO.getTripperNewNotification(tripperID));
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
        String name = "tripper." + extension;

        String path = System.getProperty("catalina.base");
        File folderPackage = new File(path + "/webapps/Images/Tripper/" + providerID);
        if (!folderPackage.exists()) {
            folderPackage.mkdirs();
        }
        ImageIO.write(croppedImage, extension, new File(folderPackage, name));

        String image = "Images/Tripper/" + providerID + "/" + name;
        tripperDAO.updateTripperImage(providerID, image);
        return image;
    }
    
    @Override
    public boolean seenMessage(int tripperID) {
        return tripperSystemNotificationDAO.seenMessage(tripperID);
    }
    
     @Override
    public boolean getFacebookInfo(String nameFacebook, String emailFacebook) {
        return tripperDAO.getFacebookInfo(nameFacebook, emailFacebook);
    }

    @Override
    public boolean tripperBooking(String noAdultsStr, String[] noChildsStrs, String packageIDstr, String tripDate, String tripTime) {
        // calculate no people
        int noPeople;

        // no adults
        noPeople = Integer.parseInt(noAdultsStr);

        if (noPeople > 0) {
            // no childs
            for (String noChildStr : noChildsStrs) {
                int noChilds;
                try {
                    noChilds = Integer.parseInt(noChildStr);
                } catch (Exception e) {
                    noChilds = 0;
                }
                noPeople += noChilds;
            }

            // get data
            int packageID = Integer.parseInt(packageIDstr);

            if (tripDate != null) {
                if (!tripDate.isEmpty()) { // check selected Date
                    // get datafrom database to check
                    PackageDTO packageDTO = packageDAO.getPackageToCheckBooking(packageID, tripDate);

                    // check no People
                    String packageType = packageDTO.getPackageType();
                    String durationType = packageDTO.getDurationType();
                    List<UsedResourcesViewDTO> usedResources = packageDTO.getUsedResources();
                    boolean isBooked = false;
                    if (usedResources.size() > 0) {
                        if (!durationType.equals("days")) {
                            // check time
                            for (UsedResourcesViewDTO usedResource : usedResources) {
                                String bookedTripTime = usedResource.getTripTime();
                                if (bookedTripTime.equals(tripTime)) {
                                    isBooked = true;
                                    break;
                                }
                            }
                        } else {
                            isBooked = true;
                        }
                    }

                    if (packageType.equals("Joint") && !isBooked) { // if package type is joint and this is first time, must  satisfy min Quota
                        int minTripper = packageDTO.getMinTripper();
                        // check MinTripper
                        if (noPeople < minTripper) {
                            return false;
                        }
                    }

                    // checkMaxTripper
                    int maxTripper = packageDTO.getMaxTripper();
                    if (noPeople > maxTripper) {
                        return false;
                    }

                    // if noPeople is correct
                    // check resource
                    if (!packageType.equals("Joint")) {
                        // if not quota check Resource
                        int noUsedResource = packageDTO.getMaximumCapacity();
                        if (usedResources.size() > 0) {
                            if (!durationType.equals("days")) {
                                // check time
                                for (UsedResourcesViewDTO usedResource : usedResources) {
                                    String bookedTripTime = usedResource.getTripTime();
                                    if (bookedTripTime.equals(tripTime)) {
                                        noUsedResource = usedResource.getNoUsedResources();
                                        break;
                                    }
                                }
                            } else {
                                int maxNo = 0;
                                for (UsedResourcesViewDTO usedResource : usedResources) {
                                    int noBookedUsedResource = usedResource.getNoUsedResources();
                                    if (noBookedUsedResource > maxNo) {
                                        maxNo = noBookedUsedResource;
                                    }
                                }
                                noUsedResource = maxNo;
                            }
                        }

                    }
                }
            }
        }
        return false;
    }

}
