/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.AccountSession;
import DTO.TripperDTO;
import com.paypal.api.payments.Item;
import com.paypal.base.rest.PayPalRESTException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nick
 */
public interface TripperDAO {

    public AccountSession insertTripper(String email, String password, String firstName, String lastName);
    
    public TripperDTO getTripperAccount(int tripperID);
    
    public boolean updateTripperImage(int tripperID, String image);
    
    public AccountSession updateTripperInformation(String firstName, String lastName,String phoneNumber,int countryID,String address, String information, String interests, String language, int tripperID,String notification);

    public boolean changeTripperPassword(int tripperID,String oldPassword,String newPassword);
    
    public boolean getFacebookInfo(String nameFacebook,String emailFacebook);
    
    public TripperDTO getTripperPage(int tripperID) throws Exception;
    
    public boolean paywithCreditCard(String cardType,String cardNumber,int expireMonth,int expireYear,int cvv,
            String FirstName,String LastName,String currency,String amount,String description) throws PayPalRESTException;
    
    public String paywithPaypal(AccountSession account,int packageID,int numberOfChilds,int numberOfAdults,
            String selectedDate,HttpServletRequest request,String currency,String amount,String description,List<Item> item) throws PayPalRESTException;
    
    public boolean verifyPayment(String paymentID,String payerID) throws PayPalRESTException;    
    
    public boolean insertNewPassword (String password,int tripperID);
    
     
    
}
