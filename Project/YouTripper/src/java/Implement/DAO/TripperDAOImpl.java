/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.AccountSession;
import DTO.PackagesViewDTO;
import DTO.ReviewDTO;
import DTO.TripperDTO;
import Interface.DAO.TripperDAO;
import Mapper.AccountSessionMaper;
import Mapper.PackageDTOMapperForView;
import Mapper.PackagesViewMapper;
import Mapper.ReviewDTOMapper;
import Mapper.TripperDTOMapper;
import Mapper.TripperDTOMapperForView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.CreditCard;
import com.paypal.api.payments.FundingInstrument;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Timestamp;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import static org.joda.time.format.ISODateTimeFormat.date;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.util.DigestUtils;

/**
 *
 * @author Nick
 */
public class TripperDAOImpl implements TripperDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public TripperDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public AccountSession insertTripper(String email, String password, String firstName, String lastName) {
        password = DigestUtils.md5DigestAsHex(password.getBytes());       
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertTripper");
        simpleJdbcCall.returningResultSet("rs1", AccountSessionMaper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("firstName", firstName).addValue("lastName", lastName)
                .addValue("email", email).addValue("password", password);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return ((List<AccountSession>) record.get("rs1")).get(0);
    }

    @Override
    public TripperDTO getTripperAccount(int tripperID) {
        String sql = "With tripperList as (Select Tripper.*"
                + " FROM Tripper "
                + " Where TripperID = ?)"
                + " Select tripperList.* ,Country.name as countryName"
                + " From tripperList"
                + " Left Join Country"
                + " on tripperList.CountryID = Country.CountryID ";
        List<TripperDTO> tripper = jdbcTemplate.query(sql, TripperDTOMapper.getInstance(), tripperID);
        return tripper.get(0);
    }

    @Override
    public boolean updateTripperImage(int tripperID, String image) {
        String sql = "UPDATE Tripper "
                + "SET [Image] = ? "
                + "WHERE TripperID = ?";
        jdbcTemplate.update(sql, image, tripperID);
        return true;
    }

    @Override
    public AccountSession updateTripperInformation(String firstName, String lastName, String phoneNumber, int countryID, String address, String information, String interests, String language, int tripperID,String notification) {
        boolean notificationValue = false;
        if(!notification.equals("false")){
            notificationValue = true;
        }
        
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("updateTripperInformation")
                .returningResultSet("rs1", AccountSessionMaper.getInstance());
         SqlParameterSource in = new MapSqlParameterSource().addValue("FirstName", firstName).addValue("LastName", lastName)
                 .addValue("Information", information).addValue("Interests", interests)
                 .addValue("Language", language).addValue("Notification", notification).addValue("TripperID", tripperID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        AccountSession account = new AccountSession(Integer.parseInt(record.get("id").toString()), record.get("name").toString(), Integer.parseInt(record.get("type").toString()), record.get("image").toString());       
        return account;
    }

    @Override
    public boolean changeTripperPassword(int tripperID, String oldPassword, String newPassword) {
        oldPassword = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
        newPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());
        String sql = "Update Tripper Set Password = ? Where TripperID = ? and Password = ?";
         int record = jdbcTemplate.update(sql, newPassword, tripperID, oldPassword);
        if(record == 1){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public boolean getFacebookInfo(String nameFacebook, String emailFacebook) {
        return true;
    }

    @Override
    public TripperDTO getTripperPage(int tripperID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getTripperPage")
                .returningResultSet("rs1", ReviewDTOMapper.getInstance())
                .returningResultSet("rs2", TripperDTOMapperForView.getInstance())
                .returningResultSet("rs3", PackagesViewMapper.getInstance())
                .returningResultSet("rs4", PackagesViewMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("tripperID", tripperID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<ReviewDTO> review = ((List<ReviewDTO>) record.get("rs1"));
        TripperDTO tripper = ((List<TripperDTO>) record.get("rs2")).get(0);
        List<PackagesViewDTO> bookingList = ((List<PackagesViewDTO>) record.get("rs3"));
        List<PackagesViewDTO> bucketList = ((List<PackagesViewDTO>) record.get("rs4"));
        tripper.setReviewList(review);
        tripper.setBookingList(bookingList);
        tripper.setBucketList(bucketList);
        return tripper;
    }

    @Override
    public boolean paywithCreditCard(String cardType, String cardNumber, int expireMonth, int expireYear, int cvv,
            String FirstName, String LastName, String currency, String amount, String description) throws PayPalRESTException {
        Map<String, String> sdkConfig = new HashMap<String, String>();
        sdkConfig.put("mode", "sandbox");
        String accessToken = new OAuthTokenCredential("AbHiUaWBpZ2nL7iWNJDkyUqW7pQ1dOLmadliqd_lS9YROi63M1UP3_qV-MWzCkU9VP1kaHiFCgeehfL3", "EArWWwOuT7qMSftpOs0yZwU3x-i-eCqyrstn7D-WvH5nWc-IQKnEeyHCCScko25pMopZOsZ3yeCLuUpZ", sdkConfig).getAccessToken();
        APIContext apiContext = new APIContext(accessToken);
        apiContext.setConfigurationMap(sdkConfig);

        CreditCard creditCard = new CreditCard();
        creditCard.setType(cardType);
        creditCard.setNumber(cardNumber);
        creditCard.setExpireMonth(expireMonth);
        creditCard.setExpireYear(expireYear);
        creditCard.setFirstName(FirstName);
        creditCard.setLastName(LastName);
        creditCard.setCvv2(cvv);

        FundingInstrument fundingInstrument = new FundingInstrument();
        fundingInstrument.setCreditCard(creditCard);

        List<FundingInstrument> fundingInstrumentList = new ArrayList<FundingInstrument>();
        fundingInstrumentList.add(fundingInstrument);

        Payer payer = new Payer();
        payer.setFundingInstruments(fundingInstrumentList);
        payer.setPaymentMethod("credit_card");

        Amount amount1 = new Amount();
        amount1.setCurrency(currency);
        amount1.setTotal(amount);

        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount1);

        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction);

        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setTransactions(transactions);

        Payment createdPayment = payment.create(apiContext);
        Gson gson = new Gson();
        JsonObject newobj = gson.fromJson(createdPayment.toJSON(), JsonObject.class);
        return newobj.get("state").getAsString().equals("approved");
    }

    @Override
    public String paywithPaypal(AccountSession account, int packageID, int numberOfChilds, int numberOfAdults, String selectedDate,
            HttpServletRequest request, String currency, String amount, String description, List<Item> item) throws PayPalRESTException {

        Map<String, String> sdkConfig = new HashMap<String, String>();
        sdkConfig.put("mode", "sandbox");

        String accessToken = new OAuthTokenCredential("AbHiUaWBpZ2nL7iWNJDkyUqW7pQ1dOLmadliqd_lS9YROi63M1UP3_qV-MWzCkU9VP1kaHiFCgeehfL3", "EArWWwOuT7qMSftpOs0yZwU3x-i-eCqyrstn7D-WvH5nWc-IQKnEeyHCCScko25pMopZOsZ3yeCLuUpZ", sdkConfig).getAccessToken();
        APIContext apiContext = new APIContext(accessToken);
        apiContext.setConfigurationMap(sdkConfig);

        Amount amount1 = new Amount();
        amount1.setCurrency(currency);
        amount1.setTotal(amount);

        ItemList list = new ItemList();
        list.setItems(item);
        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount1);
        transaction.setItemList(list);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        RedirectUrls redirectUrls = new RedirectUrls();
        String contextPath = request.getContextPath();
        String baseUrl;
        if (contextPath != null || contextPath.isEmpty() || !contextPath.equals("")) {
            baseUrl = String.format("%s:/%s:%d" + contextPath, request.getScheme(), request.getServerName(), request.getServerPort());
        } else {
            baseUrl = String.format("%s:/%s:%d", request.getScheme(), request.getServerName(), request.getServerPort());
        }
        String info = "accountID=" + account.getId() + "&selDate="
                + selectedDate + "&packageID=" + packageID + "&numChild=" + numberOfChilds + "&numAdult=" + numberOfAdults;
        String failInfo = "selDate=" + selectedDate + "&packageID=" + packageID + "&numChild=" + numberOfChilds + "&numAdult=" + numberOfAdults;
        redirectUrls.setCancelUrl(baseUrl + "/Tripper/payPaypalFail?" + failInfo);
        redirectUrls.setReturnUrl(baseUrl + "/Tripper/payPaypalSuccess?" + info);
        payment.setRedirectUrls(redirectUrls);

        Payment createdPayment = payment.create(apiContext);
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String json = gson.toJson(createdPayment);
        JsonParser parser = new JsonParser();
        JsonObject jObject = parser.parse(json).getAsJsonObject();
        JsonArray jArray = jObject.getAsJsonArray("links");
        return jArray.get(1).getAsJsonObject().get("href").getAsString();

    }

    @Override
    public boolean verifyPayment(String paymentID, String payerID) throws PayPalRESTException {
        Map<String, String> sdkConfig = new HashMap<String, String>();
        sdkConfig.put("mode", "sandbox");

        String accessToken = new OAuthTokenCredential("AbHiUaWBpZ2nL7iWNJDkyUqW7pQ1dOLmadliqd_lS9YROi63M1UP3_qV-MWzCkU9VP1kaHiFCgeehfL3", "EArWWwOuT7qMSftpOs0yZwU3x-i-eCqyrstn7D-WvH5nWc-IQKnEeyHCCScko25pMopZOsZ3yeCLuUpZ", sdkConfig).getAccessToken();
        APIContext apiContext = new APIContext(accessToken);
        apiContext.setConfigurationMap(sdkConfig);

        Payment payment = new Payment();
        payment.setId(paymentID);

        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerID);
        Payment payment2 = payment.execute(apiContext, paymentExecute);
        return payment2.getState().equals("approved");
    }
    
    @Override 
     public boolean insertNewPassword (String password, int tripperID){
         password = DigestUtils.md5DigestAsHex(password.getBytes());       
           String sql = "UPDATE Tripper "
                + "SET Password = ?, Active = 1 "
                + "WHERE TripperID = ?";
        jdbcTemplate.update(sql, password, tripperID);
        return true;
     }
     
     

}
