/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.AccountSession;
import DTO.AdvancedSearchForm;
import DTO.BusinessTypeDTO;
import DTO.CityDTO;
import DTO.CountryDTO;
import DTO.LanguageDTO;
import DTO.LocationDTO;
import DTO.PackagesViewDTO;
import DTO.PopularPackageDTO;
import DTO.ProviderSignupForm;
import Interface.DAO.CommonDAO;
import Mapper.BusinessTypeMapper;
import Mapper.CityDTOMapper;
import Mapper.CountryMapper;
import Mapper.LanguageDTOMapper;
import Mapper.LocationDTOMapper;
import Mapper.PackagesViewMapper;
import Mapper.PopularPackageMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.util.DigestUtils;

/**
 *
 * @author Nick
 */
public class CommonDAOImpl implements CommonDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public CommonDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
//        simpleJdbcCall = new SimpleJdbcCall(dataSource);
    }

    @Override
    public AccountSession loginToYouTripper(String username, String password) {
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("loginToYouTripper");
        SqlParameterSource in = new MapSqlParameterSource().addValue("username", username).addValue("password", password);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        int id = (int) record.get("id");
        String name = (String) record.get("name");
        int type = (int) record.get("type");
        String image = (String) record.get("image");
        return new AccountSession(id, name, type, image);
    }

    @Override
    public int getAccountIDByEmail(String email) {
        int providerID;
        String sql = "SELECT ProviderID AS id FROM Provider WHERE Email = ? "
                + "UNION "
                + "SELECT TripperID AS id FROM Tripper WHERE Email = ? ";
        try {
            providerID = jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

                @Override
                public Integer mapRow(ResultSet rs, int i) throws SQLException {
                    try {
                        return rs.getInt("id");
                    } catch (Exception e) {
                        return 0;
                    }
                }
            }, email, email);
        } catch (EmptyResultDataAccessException e) {
            providerID = 0;
        }

        return providerID;
    }
    
    @Override
    public int getAccountIDByEmailRegister(String email) {
        int providerID;
        String sql = "SELECT NewsletterID AS id FROM NewsletterEmail WHERE Email = ? ";
        try {
            providerID = jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

                @Override
                public Integer mapRow(ResultSet rs, int i) throws SQLException {
                    try {
                        return rs.getInt("id");
                    } catch (Exception e) {
                        return 0;
                    }
                }
            }, email);
        } catch (EmptyResultDataAccessException e) {
            providerID = 0;
        }

        return providerID;
    }

    @Override
    public AdvancedSearchForm search(String searchText, int pageNumber, int pageSize) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("searchPackages");
        simpleJdbcCall.returningResultSet("rs1", PackagesViewMapper.getInstance())
                .returningResultSet("rs2", new RowMapper<String>() {

                    @Override
                    public String mapRow(ResultSet rs, int i) throws SQLException {
                        return rs.getString("Keyword");
                    }
                })
                .returningResultSet("rs3", PopularPackageMapper.getInstance())
                .returningResultSet("rs4", LocationDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("searchText", searchText).addValue("PageNumber", pageNumber)
                .addValue("RowspPage", pageSize);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<PackagesViewDTO> packages = (List<PackagesViewDTO>) record.get("rs1");
        List<String> keywords = (List<String>) record.get("rs2");
        List<LocationDTO> locations = (List<LocationDTO>) record.get("rs4");
        List<PopularPackageDTO> popularPackages = (List<PopularPackageDTO>) record.get("rs3");
        return new AdvancedSearchForm(packages, keywords, locations, popularPackages);
    }

    @Override
    public List<PackagesViewDTO> searchWithPageNumber(String searchText, int pageNumber, int pageSize) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("searchPackagesWithPageNumber");
        simpleJdbcCall.returningResultSet("rs1", PackagesViewMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("searchText", searchText).addValue("PageNumber", pageNumber)
                .addValue("RowspPage", pageSize);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return (List<PackagesViewDTO>) record.get("rs1");
    }

    @Override
    public boolean sendMail(String title, String receiver, String messageContent) throws MessagingException {
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
        message.setContent(messageContent, "text/html; charset=utf-8");
        Transport.send(message);
        return true;

    }

    @Override
    public boolean sendSMS(String receiver, String messagecontent) throws TwilioRestException {
        final String ACCOUNT_SID = "ACb9f07687dadf6ed588bad771fcc62f2a";
        final String AUTH_TOKEN = "a7c07228d01ff5cde9b5df387cbfe7c3";
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

        // Build the parameters 
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("To", receiver));
        params.add(new BasicNameValuePair("From", "+16318761092"));
        params.add(new BasicNameValuePair("Body", messagecontent));

        MessageFactory messageFactory = client.getAccount().getMessageFactory();

        com.twilio.sdk.resource.instance.Message message = messageFactory.create(params);

        return true;
    }
    
    @Override
    public boolean insertNewEmail(String email, long time)  {
        String sql = "INSERT INTO NewsletterEmail (Email, SubcribedDateTime)"
                        + " VALUES (?,?)";
                jdbcTemplate.update(sql, email, time);
       return true;
    }
    
    @Override
    public void unSubscribe(int emailID) {
        String sql = "DELETE FROM NewsletterEmail WHERE NewsletterID= '" + emailID + "'";
        jdbcTemplate.execute(sql);
    }

    @Override
    public ProviderSignupForm getProviderSignupForm() {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getProviderSignupForm");
        simpleJdbcCall.returningResultSet("rs1", CountryMapper.getInstance()).returningResultSet("rs2", BusinessTypeMapper.getInstance())
                .returningResultSet("rs3", CityDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource();
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<CountryDTO> countries = (List<CountryDTO>) record.get("rs1");
        List<BusinessTypeDTO> businessTypes = (List<BusinessTypeDTO>) record.get("rs2");
        List<CityDTO> cities = (List<CityDTO>) record.get("rs3");
        return new ProviderSignupForm(countries, businessTypes,cities);
    }

    @Override
    public AdvancedSearchForm liveSearch(String searchText) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("liveSearch");
        simpleJdbcCall.returningResultSet("rs1", new RowMapper<String>() {

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
        return new AdvancedSearchForm(keywords, locations, popularPackages);
    }

    @Override
    public AdvancedSearchForm searchPackageBelongtoSub(String searchText, String location, int subID, int pageNumber, int pageSize) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("searchPackagesBelongsToSub");
        simpleJdbcCall.returningResultSet("rs1", PackagesViewMapper.getInstance())
                .returningResultSet("rs2", new RowMapper<String>() {

                    @Override
                    public String mapRow(ResultSet rs, int i) throws SQLException {
                        return rs.getString("Keyword");
                    }
                })
                .returningResultSet("rs3", PopularPackageMapper.getInstance())
                .returningResultSet("rs4", LocationDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("searchText", searchText).addValue("location", location).addValue("subID", subID).addValue("PageNumber", pageNumber)
                .addValue("RowspPage", pageSize);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<PackagesViewDTO> packages = (List<PackagesViewDTO>) record.get("rs1");
        List<String> keywords = (List<String>) record.get("rs2");
        List<LocationDTO> locations = (List<LocationDTO>) record.get("rs4");
        List<PopularPackageDTO> popularPackages = (List<PopularPackageDTO>) record.get("rs3");
        return new AdvancedSearchForm(packages, keywords, locations, popularPackages);
    }

    @Override
    public boolean insertNewLanguage() {
        String language = "JSON String";
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new StringReader(language));
        reader.setLenient(true);
        JsonObject myobject = gson.fromJson(reader, JsonObject.class);
        int flag = 0;
        for (Map.Entry<String, JsonElement> entry : myobject.entrySet()) {
            String name = entry.getValue().getAsJsonObject().get("name").toString();
            if (!name.equals("\"Old Church Slavonic, Church Slavic, Church Slavonic, Old Bulgarian, Old Slavonic\"")) {
                String sql = "INSERT INTO Language"
                        + " VALUES (?)";
                jdbcTemplate.update(sql, name.replaceAll("\"", ""));
            }
        }
        return true;
    }
    
   

    @Override
    public AccountSession loginToYouTripperFacebook(String email) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("loginToYoutripperFacebook");
        SqlParameterSource in = new MapSqlParameterSource().addValue("username", email);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        int id = (int) record.get("id");
        String name = (String) record.get("name");
        int type = (int) record.get("type");
        String image = (String) record.get("image");
        String token = (String) record.get("token");
        return new AccountSession(id, name, type, image, token);
    }

    @Override
    public int getAccountIDByBusinessName(String businessName) {
        int providerID;
        businessName = businessName.replaceAll("\\s+", "");
        String sql = "SELECT ProviderID AS id FROM Provider WHERE BusinessNameSimple = ? ";

        try {
            providerID = jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

                @Override
                public Integer mapRow(ResultSet rs, int i) throws SQLException {
                    try {
                        return rs.getInt("id");
                    } catch (Exception e) {
                        return 0;
                    }
                }
            }, businessName.toUpperCase());
        } catch (EmptyResultDataAccessException e) {
            providerID = 0;
        }

        return providerID;
    }
    
    @Override
    public int getAccountIDByUsernameURL(String usernameURL) {
        int providerID;
        usernameURL = usernameURL.replaceAll("\\s+", "");
        String sql = "SELECT ProviderID AS id FROM Provider WHERE UsernameURL = ? ";

        try {
            providerID = jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

                @Override
                public Integer mapRow(ResultSet rs, int i) throws SQLException {
                    try {
                        return rs.getInt("id");
                    } catch (Exception e) {
                        return 0;
                    }
                }
            }, usernameURL.toUpperCase());
        } catch (EmptyResultDataAccessException e) {
            providerID = 0;
        }

        return providerID;
    }

    @Override
    public int getSalesidBySalesCode(String salesCode) {
        int salesId;

        String sql = "SELECT SalesmanID AS id FROM Salesman WHERE PhoneNumber = ? ";

        try {
            salesId = jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

                @Override
                public Integer mapRow(ResultSet rs, int i) throws SQLException {
                    try {
                        return rs.getInt("id");
                    } catch (Exception e) {
                        return 0;
                    }
                }
            }, salesCode);
        } catch (EmptyResultDataAccessException e) {
            salesId = 0;
        }

        return salesId;
    }
}
