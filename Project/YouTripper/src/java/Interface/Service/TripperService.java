/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Service;

import DTO.AccountSession;
import DTO.BookingDTO;
import DTO.PackageDTO;
import DTO.TripperDTO;
import DTO.TripperNotification;
import DTO.TripperNotificationSetting;
import JavaClass.FileMeta;
import com.paypal.api.payments.Item;
import com.paypal.base.rest.PayPalRESTException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nick
 */
public interface TripperService {

    public boolean isUser(AccountSession account);

    public PackageDTO getPackageForPayment(int packageID);

    public List<Double> getPriceOfSelectedDate(String selectedDate, PackageDTO packageDTO) throws ParseException;

    public String getBookingCode();

    public boolean insertBooking(String code, int packageID, String selectedDate, int numberOfChilds, int numberOfAdult, int accountID) throws ParseException;

    public List<TripperNotification> getTripperNotification();

    public List<TripperNotificationSetting> getTripperNotificationSetting(int tripperID);

    public TripperDTO getTripperAccount(int tripperID);

    public List<BookingDTO> getBookingListForTripper(int tripperID);

    public boolean updateTripperImage(int tripperID, String image);

    public boolean saveSetting(int tripperID, String settingValue);

    public boolean saveWishList(String data, HttpSession session);

    public boolean removeWishlist(int packageID, HttpSession session);
    
    public boolean getFacebookInfo(String nameFacebook, String emailFacebook);

    public AccountSession updateTripperInformation(HttpServletRequest request, HttpSession session);

    public boolean changeTripperPassword(int tripperID, String oldPassword, String newPassword);

    public boolean paywithCreditCard(String cardType, String cardNumber, int expireMonth, int expireYear, int cvv,
            String FirstName, String LastName, String currency, String amount, String description) throws PayPalRESTException;

    public String paywithPaypal(AccountSession account, int packageID, int numberOfChilds, int numberOfAdults,
            String selectedDate, HttpServletRequest request, String currency, String amount, String description, List<Item> item) throws PayPalRESTException;

    public boolean verifyPayment(String paymentID, String payerID) throws PayPalRESTException;
    
    public String cropAndSaveProviderImage(String data, int providerID, FileMeta imageMeta) throws IOException;

    public boolean makeReview(int tripperID, String bookingID, int packageID, String review, double rate, int Professionlism, int StaffAttitude, int Convenient, int Satisfaction, int AmenityQuality, int Cleanliness);

    public boolean insertNewTripperSystemNotification(String content, boolean seen, int tripperID);

    public boolean seenNotification(int notificationID);

    public String getTripperNewNotification(int tripperID);

    public boolean seenMessage(int tripperID);

    public boolean tripperBooking(String noAdultsStr, String[] noChildsStrs, String packageIDstr, String tripDate, String tripTime);
}
