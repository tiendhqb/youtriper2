/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.AccountSession;
import DTO.BusinessResourceDTO;
import DTO.PackageDTO;
import DTO.ProviderDTO;
import DTO.ProviderSession;
import DTO.ResourceSkillDTO;
import DTO.ReviewDTO;
import DTO.TemporaryPackageDTO;
import DTO.TrippSourceDTO;
import DTO.TrippSourceDTOMapperForManagement;
import Interface.DAO.ProviderDAO;
import JavaClass.BookingDetailInTripDash;
import JavaClass.BookingStatisticsInTrippDash;
import JavaClass.HighestPackageInTripDash;
import JavaClass.ListBookingInTripDash;
import JavaClass.LowestPackageInTripDash;
import JavaClass.ResourceManagementData;
import JavaClass.RevenueStatisticsInTrippDash;
import JavaClass.TotalBookingInTripDash;
import JavaClass.TripDash;
import Mapper.AccountSessionMaper;
import Mapper.BookingDetailInTripDashMapper;
import Mapper.BookingStatisticsInTrippDashMapper;
import Mapper.BusinessResouceDTOMapperForManagement;
import Mapper.HighestPackageInTripDashMapper;
import Mapper.ListBookingInTripDashMapper;
import Mapper.LowestPackageInTripDashMapper;
import Mapper.PackageDTOMapperForResourceManagement;
import Mapper.PackageListMapperForTrippDash;
import Mapper.PackageMapper;
import Mapper.PackagesViewMapper;
import Mapper.ProviderAccountInfoMapper;
import Mapper.ProviderDTOMapperForRefferal;
import Mapper.ProviderDTOMapperForView;
import Mapper.ProviderIDMapper;
import Mapper.ProviderPhoneNumberMapper;
import Mapper.ProviderSessionMapper;
import Mapper.ResourceSkillDTOMapperForManagement;
import Mapper.RevenueStatisticsInTrippDashMapper;
import Mapper.ReviewDTOMapper;
import Mapper.TempPackageDTOMapperCloneCheck;
import Mapper.TemporaryPackageDTOMapperForResourceManagement;
import Mapper.TotalBookingInTripDashMapper;
import com.google.gson.Gson;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.util.DigestUtils;

/**
 *
 * @author Nick
 */
public class ProviderDAOImpl implements ProviderDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public ProviderDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public AccountSession registerProvider(int businessType,  String businessName, int countryID, String city, String address, String phoneCode, String phone,
            String firstName, String lastName, String displayName, String job, String email, String password, boolean notification, String referralCode, String openTime, String closeTime, String referralOfficialID) {
        //generate ProviderOfficialID 
        String sql = "SELECT BusinessCode FROM BusinessType WHERE BusinessTypeID =?";
        String businessCode = jdbcTemplate.queryForObject(sql, String.class, businessType);
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        String yearInString = String.valueOf(year);
        String last = yearInString.substring(yearInString.length() - 2);
        sql = "SELECT COUNT(ProviderID) FROM Provider";
        int providerIDQuantity = jdbcTemplate.queryForObject(sql, Integer.class);

        String quantityProvider = String.valueOf(providerIDQuantity + 1);
        int lengthQuantity = quantityProvider.length();

        String numberOfProviderId = "";
        for (int i = 0; i < 4 - lengthQuantity; i++) {
            numberOfProviderId = numberOfProviderId + "0";
        }
        String providerOfficialId = businessCode + last + numberOfProviderId + quantityProvider;
        // end generate ProviderOfficialID

        password = DigestUtils.md5DigestAsHex(password.getBytes());
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertProvider");
        simpleJdbcCall.returningResultSet("rs1", AccountSessionMaper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("businessType", businessType).addValue("businessName", businessName)
                .addValue("countryID", countryID).addValue("city", city).addValue("address", address).addValue("phoneCode", phoneCode).addValue("phone", phone)
                .addValue("firstName", firstName).addValue("lastName", lastName).addValue("displayName", displayName).addValue("job", job).addValue("email", email)
                .addValue("password", password).addValue("notification", notification).addValue("referralCode", referralCode).addValue("providerOfficialID", providerOfficialId)
                .addValue("openTime", openTime).addValue("closeTime", closeTime).addValue("referralOfficialID", referralOfficialID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return ((List<AccountSession>) record.get("rs1")).get(0);

    }

    @Override
    public ProviderSession login(String username, String password) {
        ProviderSession provider;
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        String sql = "  SELECT ProviderID, LastName FROM Provider WHERE Email = ? AND [Password] = ?";
        provider = jdbcTemplate.queryForObject(sql, ProviderSessionMapper.getInstance(), username, password);
        return provider;
    }

    @Override
    public ProviderDTO getPhoneNumber(int providerID) {
        String sql = "Select PhoneCode,PhoneNumber\n"
                + "FROM Provider\n"
                + "Where ProviderID = " + providerID;
        List<ProviderDTO> result = jdbcTemplate.query(sql, ProviderPhoneNumberMapper.getInstance());
        return result.get(0);
    }

    @Override
    public ProviderDTO getProviderID(String url) {
        String sql = "Select ProviderID\n"
                + "FROM Provider\n"
                + "Where UsernameURL = ?";
        List<ProviderDTO> result = jdbcTemplate.query(sql, ProviderIDMapper.getInstance(), url);
        return result.get(0);
    }

    @Override
    public String getSMSCode(int providerID, String phoneCode, String phoneNumber) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("sendSMS");
        SqlParameterSource in = new MapSqlParameterSource().addValue("phoneCode", phoneCode)
                .addValue("phoneNumber", phoneNumber).addValue("ProviderID", providerID)
                .addValue("currentTime", String.valueOf(System.currentTimeMillis()));
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return String.valueOf(record.get("SMSCode"));
    }

    @Override
    public String verifySMS(int providerID, String smsCode) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("verifySMS");
        SqlParameterSource in = new MapSqlParameterSource().addValue("SMSCode", smsCode).addValue("ProviderID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return String.valueOf(record.get("result"));
    }

    @Override
    public ProviderDTO getAccountInfo(int providerID) {
        List<ProviderDTO> provider;
        String sql = "Select Provider.*,Country.Name From Provider,Country Where Provider.CountryID = Country.CountryID and providerID = ?" ;
        provider = jdbcTemplate.query(sql, ProviderAccountInfoMapper.getInstance(),providerID);
        return provider.get(0);
    }

    @Override
    public boolean checkVerifyPhoneNumber(int providerID) {
        List<ProviderDTO> provider;
        String sql = "Select Provider.*,Country.Name FROM Provider,Country Where Provider.ProviderID = " + providerID + " and Provider.PhoneActive = 1 and Provider.CountryID = Country.CountryID ";
        provider = jdbcTemplate.query(sql, ProviderAccountInfoMapper.getInstance());
        return provider.size() > 0;
    }

    @Override
    public boolean updateProviderImage(int providerID, String image) {
        String sql = "Update Provider "
                + "SET [Image] = ? "
                + "WHERE ProviderID = ?";
        jdbcTemplate.update(sql, image, providerID);
        return true;
    }

    @Override
    public boolean updateProviderPassportImage(int providerID, String image, String uploadTime) {
        String sql = "Update Provider "
                + "SET [PassportImage] = ?, PassportUploadTime = ?, PassportStatus = ? "
                + "WHERE ProviderID = ?";
        jdbcTemplate.update(sql, image, uploadTime, 0, providerID);
        return true;
    }

    @Override
    public boolean updateCertificateImage(int providerID, String image) {
        String sql = "Update Certificate "
                + "SET [Image] = ? "
                + "WHERE ProviderID = ?";
        jdbcTemplate.update(sql, image, providerID);
        return true;
    }

    @Override
    public AccountSession updateProviderInformation(String firstName, String lastName, String information, String interests, String taxnumber, String language, int providerID, boolean notification) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("updateProviderInformation");
        SqlParameterSource in = new MapSqlParameterSource().addValue("FirstName", firstName).addValue("LastName", lastName)
                .addValue("Information", information).addValue("Interests", interests).addValue("TaxNumber", taxnumber)
                .addValue("Language", language).addValue("Notification", notification).addValue("ProviderID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);

        AccountSession account = new AccountSession(Integer.parseInt(record.get("id").toString()), record.get("name").toString(), Integer.parseInt(record.get("type").toString()), record.get("image").toString());
        return account;
    }

    @Override
    public boolean updateCertificateInformation(String Name, int CertificateID) {
        String sql = "Update Certificate "
                + "SET Name = ?, isApproved = 0 "
                + "WHERE CertificateID = ?";
        jdbcTemplate.update(sql, Name, CertificateID);
        return true;
    }

    @Override
    public boolean updateCertificateStatus(int CertificateID) {
        String sql = "Update Certificate "
                + "SET isApproved = ? "
                + "WHERE CertificateID = ?";
        jdbcTemplate.update(sql, 0, CertificateID);
        return true;
    }

    @Override
    public boolean changeProviderPassword(int providerID, String oldPassword, String newPassword) {
        oldPassword = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
        newPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());
        String sql = "Update Provider Set Password = ? Where ProviderID = ? and Password = ?";
        int record = jdbcTemplate.update(sql, newPassword, providerID, oldPassword);
        if (record == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ProviderDTO getProviderPage(int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getProviderPage").returningResultSet("rs1", ReviewDTOMapper.getInstance())
                .returningResultSet("rs2", ProviderDTOMapperForView.getInstance()).returningResultSet("rs3", PackagesViewMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<ReviewDTO> review = ((List<ReviewDTO>) record.get("rs1"));
        ProviderDTO provider = ((List<ProviderDTO>) record.get("rs2")).get(0);
        List<PackageDTO> packageList = ((List<PackageDTO>) record.get("rs3"));
        provider.setReviewList(review);
        provider.setPackageList(packageList);
        return provider;
    }

    @Override
    public boolean isVerifyPhoneNumber(int providerID) {
        List<ProviderDTO> provider;
        String sql = "Select * From Provider Where ProviderID = ? and PhoneActive = 1";
        provider = jdbcTemplate.query(sql, ProviderPhoneNumberMapper.getInstance(), providerID);
        return provider.size() > 0;
    }

    @Override
    public int getReferralCount(int providerID) {
        int numberCount = 0;
        String sql = "Select count(*) From Referral Where ReceiverID IS NOT NULL AND ReferralStatus = 2 AND SenderID = " + providerID;
        numberCount = jdbcTemplate.queryForObject(sql, Integer.class);
        return numberCount;
    }
    
    @Override
    public List<ProviderDTO> getReferralInfo(int providerID) {
        String sql = "Select ProviderID,Email,ActivePackage From Provider Where ReferralID = ? ";
        return  jdbcTemplate.query(sql, ProviderDTOMapperForRefferal.getInstance(), providerID);
    }

    @Override
    public ResourceManagementData getResourceManagementData(int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getResourceManagementData").returningResultSet("rs1", ResourceSkillDTOMapperForManagement.getInstance())
                .returningResultSet("rs2", PackageDTOMapperForResourceManagement.getInstance())
                .returningResultSet("rs3", TemporaryPackageDTOMapperForResourceManagement.getInstance())
                .returningResultSet("rs4", BusinessResouceDTOMapperForManagement.getInstance())
                .returningResultSet("rs5", TrippSourceDTOMapperForManagement.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<ResourceSkillDTO> resourceSkills = ((List<ResourceSkillDTO>) record.get("rs1"));
        List<PackageDTO> packages = ((List<PackageDTO>) record.get("rs2"));
        List<TemporaryPackageDTO> temporaryPackages = ((List<TemporaryPackageDTO>) record.get("rs3"));
        List<BusinessResourceDTO> providerResources = ((List<BusinessResourceDTO>) record.get("rs4"));
        List<TrippSourceDTO> trippSources = ((List<TrippSourceDTO>) record.get("rs5"));
        return new ResourceManagementData(resourceSkills, packages, temporaryPackages, providerResources, trippSources);
    }

    @Override
    public boolean checkCreatingPackageExist(int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("checkCreatingPackageExist")
                .returningResultSet("rs1", TempPackageDTOMapperCloneCheck.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        TemporaryPackageDTO packageDTO = null;
        try {
            packageDTO = ((List<TemporaryPackageDTO>) record.get("rs1")).get(0);
        } catch (Exception e) {
        }
        if (packageDTO != null) {
            return true;
        }
        return false;
    }

    @Override
    public TripDash getProviderTrippDash(int providerID, long currentTime, long last30Days) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getTrippDashData")
                .returningResultSet("rs1", BookingDetailInTripDashMapper.getInstance())
                .returningResultSet("rs2", TotalBookingInTripDashMapper.getInstance())
                .returningResultSet("rs3", ListBookingInTripDashMapper.getInstance())
                .returningResultSet("rs4", HighestPackageInTripDashMapper.getInstance())
                .returningResultSet("rs5", LowestPackageInTripDashMapper.getInstance())
                .returningResultSet("rs6", RevenueStatisticsInTrippDashMapper.getInstance())
                .returningResultSet("rs7", PackageListMapperForTrippDash.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("date", currentTime).addValue("providerID", providerID)
                .addValue("last30DaysMill", last30Days);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        TripDash tripDash = new TripDash();
        List<BookingDetailInTripDash> bookingDetailinTripDash = null;
        try {
            bookingDetailinTripDash = ((List<BookingDetailInTripDash>) record.get("rs1"));
        } catch (Exception e) {
        }
        TotalBookingInTripDash totalBookingInTripDash = null;
        try {
            totalBookingInTripDash = ((List<TotalBookingInTripDash>) record.get("rs2")).get(0);
        } catch (Exception e) {
        }
        List<ListBookingInTripDash> listBookingInTripDash = null;
        try {
            listBookingInTripDash = (List<ListBookingInTripDash>) record.get("rs3");
        } catch (Exception e) {
        }
        HighestPackageInTripDash highestPackageInTripDash = null;
        try {
            highestPackageInTripDash = ((List<HighestPackageInTripDash>) record.get("rs4")).get(0);
        } catch (Exception e) {
        }
        LowestPackageInTripDash lowestPackageInTripDash = null;
        try {
            lowestPackageInTripDash = ((List<LowestPackageInTripDash>) record.get("rs5")).get(0);
        } catch (Exception e) {
        }
        RevenueStatisticsInTrippDash revenueStatisticsInTrippDash = null;
        try {
            revenueStatisticsInTrippDash = ((List<RevenueStatisticsInTrippDash>) record.get("rs6")).get(0);
        } catch (Exception e) {
        }
        List<PackageDTO> packageList = null;
        try {
            packageList = ((List<PackageDTO>) record.get("rs7"));
        } catch (Exception e) {
        }
        tripDash.setBookingDetailInTripDash(bookingDetailinTripDash);
        tripDash.setTotalBookingInTripDash(totalBookingInTripDash);
        tripDash.setListBookingInTripDash(listBookingInTripDash);
        tripDash.setHighestPackageInTripDash(highestPackageInTripDash);
        tripDash.setLowestPackageInTripDash(lowestPackageInTripDash);
        tripDash.setRevenueStatisticsInTrippDash(revenueStatisticsInTrippDash);
        tripDash.setPackageList(packageList);
        try {
            tripDash.setMaxDataResource((Integer) record.get("maxDataResource"));
        } catch (Exception e) {
        }
        return tripDash;
    }

    @Override
    public TripDash loadTopLeftBooking(int providerID, long date) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getBookingDetailInTripDash")
                .returningResultSet("rs1", BookingDetailInTripDashMapper.getInstance())
                .returningResultSet("rs2", TotalBookingInTripDashMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID).addValue("date", date);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        TripDash tripDash = new TripDash();
        List<BookingDetailInTripDash> bookingDetailinTripDash = null;
        try {
            bookingDetailinTripDash = ((List<BookingDetailInTripDash>) record.get("rs1"));
        } catch (Exception e) {
        }
        TotalBookingInTripDash totalBookingInTripDash = null;
        try {
            totalBookingInTripDash = ((List<TotalBookingInTripDash>) record.get("rs2")).get(0);
        } catch (Exception e) {
        }
        tripDash.setBookingDetailInTripDash(bookingDetailinTripDash);
        tripDash.setTotalBookingInTripDash(totalBookingInTripDash);
        try {
            tripDash.setMaxDataResource((Integer) record.get("maxResource"));
        } catch (Exception e) {
        }
        return tripDash;
    }

    @Override
    public HighestPackageInTripDash loadHighestPackage(int providerID, long date, long lastDate, String packageType) {
        if (packageType.equals("grossing")) {
            simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getHighestGrossingPackage")
                    .returningResultSet("rs1", HighestPackageInTripDashMapper.getInstance());
        } else if (packageType.equals("selling")) {
            simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getHighestSellingPackage")
                    .returningResultSet("rs1", HighestPackageInTripDashMapper.getInstance());
        } else if (packageType.equals("converting")) {
            simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getHighestConvertingPackage")
                    .returningResultSet("rs1", HighestPackageInTripDashMapper.getInstance());
        }
        SqlParameterSource in = new MapSqlParameterSource().addValue("date", date).addValue("providerID", providerID)
                .addValue("lastDaysMill", lastDate);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        HighestPackageInTripDash highestPackageInTripDash = null;
        try {
            highestPackageInTripDash = ((List<HighestPackageInTripDash>) record.get("rs1")).get(0);
        } catch (Exception e) {
        }
        return highestPackageInTripDash;
    }

    @Override
    public LowestPackageInTripDash loadLowestPackage(int providerID, long date, long lastDate, String packageType) {
        if (packageType.equals("grossing")) {
            simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getLowestGrossingPackage")
                    .returningResultSet("rs1", LowestPackageInTripDashMapper.getInstance());
        } else if (packageType.equals("selling")) {
            simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getLowestSellingPackage")
                    .returningResultSet("rs1", LowestPackageInTripDashMapper.getInstance());
        } else if (packageType.equals("converting")) {
            simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getLowestConvertingPackage")
                    .returningResultSet("rs1", LowestPackageInTripDashMapper.getInstance());
        }
        SqlParameterSource in = new MapSqlParameterSource().addValue("date", date).addValue("providerID", providerID)
                .addValue("lastDaysMill", lastDate);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        LowestPackageInTripDash lowestPackageInTripDash = null;
        try {
            lowestPackageInTripDash = ((List<LowestPackageInTripDash>) record.get("rs1")).get(0);
        } catch (Exception e) {
        }
        return lowestPackageInTripDash;
    }

    @Override
    public String loadStatisticsInTripDash(long date, int packageID, long lastDate, String statisticsType) {
        Gson gson = new Gson();
        if (statisticsType.equals("revenue")) {
            simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getRevenueStatisticsInTrippDash")
                    .returningResultSet("rs1", RevenueStatisticsInTrippDashMapper.getInstance());
            SqlParameterSource in = new MapSqlParameterSource().addValue("date", date).addValue("packageID", packageID)
                    .addValue("lastDaysMill", lastDate);
            Map<String, Object> record = simpleJdbcCall.execute(in);
            List<RevenueStatisticsInTrippDash> revenueStatisticsInTrippDash = null;
            try {
                revenueStatisticsInTrippDash = ((List<RevenueStatisticsInTrippDash>) record.get("rs1"));
                return gson.toJson(revenueStatisticsInTrippDash);
            } catch (Exception e) {
            }
        } else {
            simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getBookingsStatisticsInTrippDash")
                    .returningResultSet("rs1", BookingStatisticsInTrippDashMapper.getInstance());
            SqlParameterSource in = new MapSqlParameterSource().addValue("date", date).addValue("packageID", packageID)
                    .addValue("lastDaysMill", lastDate);
            Map<String, Object> record = simpleJdbcCall.execute(in);
            List<BookingStatisticsInTrippDash> revenueStatisticsInTrippDash = null;
            try {
                revenueStatisticsInTrippDash = ((List<BookingStatisticsInTrippDash>) record.get("rs1"));
                return gson.toJson(revenueStatisticsInTrippDash);
            } catch (Exception e) {
            }
        }
        return "";
    }
}
