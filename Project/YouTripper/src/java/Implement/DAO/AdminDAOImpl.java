/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.AdminSession;
import DTO.BookingDTO;
import DTO.CertificateDTO;
import DTO.ProviderPayment;
import Interface.DAO.AdminDAO;
import JavaClass.PackageApprovedEmailData;
import Mapper.AdminSessionMapper;
import Mapper.BookingDTOMapperForSale;
import Mapper.ProviderPaymentMapper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
public class AdminDAOImpl implements AdminDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public AdminDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public AdminSession login(String username, String password) {
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        String sql = "SELECT AdminID, Name FROM [Admin] "
                + "WHERE Username = ? AND [Password] = ?";
        List<AdminSession> adminList = jdbcTemplate.query(sql, AdminSessionMapper.getInstance(), username, password);
        if (adminList.size() > 0) {
            AdminSession admin = adminList.get(0);
            return admin;
        }
        return null;
    }

    @Override
    public List<ProviderPayment> getProviderPaymentList() {
        String sql = "Select Provider.ProviderID,Provider.LastName,Provider.Image,SUM((NumberOfAdults*AdultPrice+NumberOfChilds*ChildPrice)*(100-Package.YoutripperPercentage)/100) as Total"
                + " FROM Booking,Provider,Package"
                + " Where Booking.ProviderID = Provider.ProviderID and Booking.Paid = 'none' and Booking.PackageID = Package.PackageID"
                + " GROUP BY Provider.ProviderID,Provider.LastName,Provider.Image";
        List<ProviderPayment> result = jdbcTemplate.query(sql, ProviderPaymentMapper.getInstance());
        return result;
    }

    @Override
    public List<BookingDTO> viewBookingDetail(int providerID) {
        String sql = "Select Booking.*,Package.YoutripperPercentage"
                + " FROM Booking,Package"
                + " Where Booking.ProviderID = ? and Booking.Paid = 'none' and Booking.PackageID = Package.PackageID";
        List<BookingDTO> result = jdbcTemplate.query(sql, BookingDTOMapperForSale.getInstance(), providerID);
        return result;
    }

    @Override
    public boolean payout() {
        String sql = "Update Booking SET Paid = ? WHERE Paid = 'none'";
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date currentDate = new Date();
        jdbcTemplate.update(sql, dateFormat.format(currentDate));
        return true;
    }

    @Override
    public boolean insertSalesman(String email, String firstName, String lastName, String phone) {

        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertSalesman");
        SqlParameterSource in = new MapSqlParameterSource().addValue("firstName", firstName).addValue("lastName", lastName)
                .addValue("email", email).addValue("phoneNumber", phone);
        simpleJdbcCall.execute(in);

        final String username = "registration@youtripper.com";
        final String passwordEmail = "Tripregister190515";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "mail.youtripper.com");
//
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, passwordEmail);
//            }
//        });
//
//        //send email information of salesman
//   
//        StringBuilder messageContentHtml = new StringBuilder();
//        messageContentHtml.append("Your Password: ");
//        String messageContent = messageContentHtml.toString();
//        Message message = new MimeMessage(session);
//        try {
//            message.setFrom(new InternetAddress("registration@youtripper.com"));
//             message.setRecipients(Message.RecipientType.TO,
//                InternetAddress.parse(email));
//            message.setSubject("Your information");
//            message.setContent(messageContent, "text/html; charset=utf-8");
//            Transport.send(message);
//        } catch (MessagingException ex) {
//            Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       
        return true;
    }

    @Override
    public PackageApprovedEmailData getPackageApprovedEmailData(int packageID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getPackageApprovedEmailData");
        SqlParameterSource in = new MapSqlParameterSource().addValue("tempPackageID", packageID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        PackageApprovedEmailData result = new PackageApprovedEmailData(record.get("lastName").toString(), record.get("email").toString(), record.get("packageName").toString());
        return result;
    }

}
