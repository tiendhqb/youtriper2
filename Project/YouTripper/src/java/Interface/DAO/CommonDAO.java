/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.AccountSession;
import DTO.AdvancedSearchForm;
import DTO.PackagesViewDTO;
import DTO.ProviderSignupForm;
import com.twilio.sdk.TwilioRestException;
import java.util.List;
import javax.mail.MessagingException;

/**
 *
 * @author Nick
 */
public interface CommonDAO {

    public ProviderSignupForm getProviderSignupForm();

    public AccountSession loginToYouTripper(String username, String password);
    
    public AccountSession loginToYouTripperFacebook(String email);

    public int getAccountIDByEmail(String email);
    
    public int getAccountIDByEmailRegister(String email);
    
    public int getAccountIDByBusinessName (String businessName);
    
    public int getAccountIDByUsernameURL (String usernameURL);
    
    public int getSalesidBySalesCode (String salesCode);

    public AdvancedSearchForm search(String searchText, int pageNumber, int pageSize);
    
    public AdvancedSearchForm liveSearch(String searchText);

    public List<PackagesViewDTO> searchWithPageNumber(String searchText, int pageNumber, int pageSize);

    public boolean sendMail(String title, String receiver, String message) throws MessagingException; 

    public boolean sendSMS(String receiver, String message) throws TwilioRestException;
    
    public AdvancedSearchForm searchPackageBelongtoSub(String searchText,String location,int subID, int pageNumber, int pageSize);

    public boolean insertNewLanguage();
    
    public boolean insertNewEmail(String email, long time);
    
    public void unSubscribe(int emailID);
    
}
