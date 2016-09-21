/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.DAO;

import DTO.BookingDTO;
import DTO.EngineBookingDTO;
import DTO.EnginePackageDTO;
import DTO.OfflineBookingDTO;
import DTO.OfflineBookingEngineDTO;
import DTO.OfflinePackageDTO;
import DTO.OfflineResourceDTO;
import DTO.PackageSale;
import DTO.ResourcesDTO;
import DTO.SaleInfo;
import DTO.UsedResourcesViewDTO;
import Interface.DAO.BookingDAO;
import JavaClass.BookingEngineData;
import Mapper.BookingDTOMapperForSale;
import Mapper.BookingDTOMapperForStatistics;
import Mapper.BookingDTOMapperForTripper;
import Mapper.BookingMapperForChat;
import Mapper.BookingMapperForDetail;
import Mapper.EngineBookingDTOMapper;
import Mapper.EnginePackageMapper;
import Mapper.OfflineBookingDTOMapperForBookingEngine;
import Mapper.OfflineEngineBookingDTOMapper;
import Mapper.OfflinePackageDTOMapper;
import Mapper.PackageSaleMapper;
import Mapper.ResourcesDTOMapper;
import Mapper.SaleMapper;
import Mapper.UsedResourcesViewDTOMapperForBookingEngine;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 *
 * @author DINH KHANG
 */
public class BookingDAOImpl implements BookingDAO {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;
    private final DataSource dataSource;

    public BookingDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
//        simpleJdbcCall = new SimpleJdbcCall(dataSource);
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        String sql = "Select * From Booking";
        List<BookingDTO> bookings = jdbcTemplate.query(sql, BookingMapperForChat.getInstance());
        return bookings;
    }

    @Override
    public List<BookingDTO> getBookingByCode(int code) {
        String sql = "Select * From Booking where Code = " + code;
        List<BookingDTO> bookings = jdbcTemplate.query(sql, BookingMapperForChat.getInstance());
        return bookings;
    }

    @Override
    public boolean deleteBookingofCode(int code) {
        String sql = "Delete From Booking Where Code = " + code;
        jdbcTemplate.update(sql);
        return true;
    }

    @Override
    public boolean insertNewBooking(BookingDTO bookingDTO) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insertBooking");
        SqlParameterSource in = new MapSqlParameterSource().addValue("Code", bookingDTO.getCode()).addValue("BookingDate", bookingDTO.getBookingDate()).addValue("SelectedDate", bookingDTO.getSelectedDate())
                .addValue("NumberOfAdults", bookingDTO.getNumberOfAdults()).addValue("NumberOfChilds", bookingDTO.getNumberOfChilds()).addValue("AdultPrice", bookingDTO.getAdultPrice()).addValue("ChildPrice", bookingDTO.getChildPrice())
                .addValue("tripperID", bookingDTO.getTripperID()).addValue("packageID", bookingDTO.getPackageID()).addValue("ProviderID", bookingDTO.getProviderID()).addValue("Paid", "none").addValue("NoOfPackages", bookingDTO.getNoOfPackages());
        Map<String, Object> record = simpleJdbcCall.execute(in);
        String sql = "DELETE FROM [Conversation] WHERE ProviderID = ? AND TripperID = ? And ConversationID = ?";
        jdbcTemplate.update(sql, bookingDTO.getProviderID(), bookingDTO.getTripperID(), bookingDTO.getPackageID());
        if (record.size() > 0) {
            return true;
        }
        return false;

    }

    @Override
    public boolean isBookingCodeExist(String code) {
        String sql = "SELECT Code FROM Booking WHERE Code = ?";
        String resultCode;
        try {
            resultCode = (String) jdbcTemplate.queryForObject(
                    sql, new Object[]{code}, String.class);
        } catch (DataAccessException e) {
            resultCode = null;
        }
        return resultCode != null;
    }

    @Override
    public List<BookingDTO> getBookingListByTripperID(int tripperID) {
        String sql = " SELECT Conv.*,Package.Name as PackageName,Package.CoverImage, Provider.LastName as providerName,Tripper.LastName as tripperName,Temp.Message,Temp.Time AS LatestTime,Provider.Image as providerImage,Tripper.Image as tripperImage, Temp.NumberNotRead"
                + " FROM [Booking] AS Conv LEFT JOIN ("
                + "                SELECT Conv.BookingID, Conv.[Message], Conv.[Time], NumberNotRead"
                + "                 FROM BookingMessage Conv LEFT JOIN ( SELECT COUNT(isRead) As NumberNotRead, BookingID"
                + "                 FROM BookingMessage"
                + "                 WHERE isRead = 0 AND UserID != ? AND UserType != 'tripper'"
                + "                 GROUP BY BookingID) TempB ON Conv.BookingID = TempB.BookingID, (SELECT MAX(MessageID) As MaxMessage, BookingID FROM BookingMessage GROUP BY BookingID) TableA"
                + "                 WHERE Conv.BookingID = TableA.BookingID AND Conv.MessageID = TableA.MaxMessage) Temp"
                + "                 ON Conv.Code = Temp.BookingID, Tripper, Provider,Package"
                + "                 WHERE Conv.TripperID = ? AND Conv.ProviderID = Provider.ProviderID AND Conv.TripperID = Tripper.TripperID and Conv.PackageID = Package.PackageID";
        List<BookingDTO> result = jdbcTemplate.query(sql, BookingMapperForChat.getInstance(), tripperID, tripperID);
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getLatestTime() == null || result.get(i).getLatestTime() == "") {
                result.get(i).setLatestTime("0");
            }
        }
        return result;
    }

    @Override
    public List<BookingDTO> getBookingListByProviderID(int providerID) {
        String sql = " SELECT Conv.*,Package.Name as PackageName,Package.CoverImage, Provider.LastName as providerName,Tripper.LastName as tripperName,Temp.Message,Temp.Time AS LatestTime,Provider.Image as providerImage,Tripper.Image as tripperImage, Temp.NumberNotRead"
                + " FROM [Booking] AS Conv LEFT JOIN ("
                + "                SELECT Conv.BookingID, Conv.[Message], Conv.[Time], NumberNotRead"
                + "                 FROM BookingMessage Conv LEFT JOIN ( SELECT COUNT(isRead) As NumberNotRead, BookingID"
                + "                 FROM BookingMessage"
                + "                 WHERE isRead = 0 AND UserID != ? AND UserType != 'provider'"
                + "                 GROUP BY BookingID) TempB ON Conv.BookingID = TempB.BookingID, (SELECT MAX(MessageID) As MaxMessage, BookingID FROM BookingMessage GROUP BY BookingID) TableA"
                + "                 WHERE Conv.BookingID = TableA.BookingID AND Conv.MessageID = TableA.MaxMessage) Temp"
                + "                 ON Conv.Code = Temp.BookingID, Tripper, Provider,Package"
                + "                 WHERE Conv.ProviderID = ? AND Conv.ProviderID = Provider.ProviderID AND Conv.TripperID = Tripper.TripperID and Conv.PackageID = Package.PackageID";
        List<BookingDTO> result = jdbcTemplate.query(sql, BookingMapperForChat.getInstance(), providerID, providerID);
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getLatestTime() == null || result.get(i).getLatestTime() == "") {
                result.get(i).setLatestTime("0");
            }
        }
        return result;
    }

    @Override
    public List<BookingDTO> getBookingListForStatictis(int packageID) {
        List<BookingDTO> result;
        String sql = "Select Booking.*,Package.MaxTripper FROM Booking,Package Where Booking.PackageID =" + packageID + " and Booking.PackageID = Package.PackageID";
        result = jdbcTemplate.query(sql, BookingDTOMapperForStatistics.getInstance());
        return result;
    }

    @Override
    public SaleInfo getSaleInfo(int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getSaleInfo")
                .returningResultSet("rs1", BookingDTOMapperForSale.getInstance())
                .returningResultSet("rs2", PackageSaleMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<BookingDTO> bookingList = (List<BookingDTO>) record.get("rs1");
        List<PackageSale> packageList = (List<PackageSale>) record.get("rs2");
        SaleInfo result = new SaleInfo(bookingList, packageList);
        return result;
    }

    @Override
    public List<BookingDTO> getBookingForTripper(int tripperID) {
        List<BookingDTO> result;
        String sql = "Select Booking.Code, Booking.BookingDate, Booking.NumberOfAdults, Booking.AdultPrice, Booking.SelectedDate, Booking.NoOfPackages, "
                + "Package.PackageID, OthersLanguageDescription.PackageName, Package.CoverImage, Package.City, Package.Country, Package.Rate, Package.NumberRate, Package.OrdinaryPriceForAdult, "
                + "Provider.ProviderID, Provider.LastName, Provider.[Image], Booking.TripperID "
                + "FROM Booking, Package, Provider, OthersLanguageDescription "
                + "WHere Booking.PackageID = Package.PackageID AND Booking.TripperID = ? AND Package.ProviderID = Provider.ProviderID AND OthersLanguageDescription.PackageID = Booking.PackageID";
        result = jdbcTemplate.query(sql, BookingDTOMapperForTripper.getInstance(), tripperID);
        return result;
    }

    @Override
    public int getTripperIDByBookingCode(String bookingCode) {
        int result;
        String sql = "Select TOP 1 UserID as TripperID"
                + " FROM BookingMessage"
                + " Where BookingID = ? and UserType = 'tripper'";
        result = jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

            @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                try {
                    if (rs.getInt("TripperID") > 0) {
                        return rs.getInt("TripperID");
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    return 0;
                }
            }
        }, bookingCode);
        return result;
    }

    @Override
    public int getProviderIDByBookingCode(String bookingCode) {
        int result;
        String sql = "Select TOP 1 UserID as ProviderID"
                + " FROM BookingMessage"
                + " Where BookingID = ? and UserType = 'provider'";
        result = jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

            @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                try {
                    return rs.getInt("ProviderID");
                } catch (Exception e) {
                    return 0;
                }
            }
        }, bookingCode);
        return result;
    }

    @Override
    public List<BookingDTO> getSales(int packageID, int providerID) {
        String packageCondi = "";
        Object[] listParams;
        if (packageID > 0) {
            listParams = new Object[2];
            packageCondi = " AND Package.PackageID = ?";
            listParams[1] = packageID;
        } else {
            listParams = new Object[1];
        }
        listParams[0] = providerID;
        String sql = "SELECT BookingDate, NumberOfAdults, 0 AS NumberOfChilds, AdultPrice,0 AS ChildPrice, Paid, "
                + " FirstName, LastName, Tripper.TripperID, Package.Name AS PackageName, Package.YoutripperPercentage, Package.PackageID,Package.ProfitPercentage "
                + " FROM Booking, Package, Tripper "
                + " WHERE Booking.PackageID = Package.PackageID AND Booking.TripperID = Tripper.TripperID AND Booking.ProviderID = ?" + packageCondi;
        List<BookingDTO> result = jdbcTemplate.query(sql, listParams, SaleMapper.getInstance());
        return result;
    }

    @Override
    public BookingDTO getBookingDetail(String bookingCode) {
        List<BookingDTO> result;
        String sql = "SELECT Code, SelectedDate, NumberOfAdults, NumberOfChilds, Package.PackageID,"
                + "Package.DepartureTime, Package.Country, Package.City, Package.[State],"
                + "Tripper.FirstName, Tripper.LastName, Tripper.[Image], Tripper.TripperID"
                + " FROM Booking INNER JOIN Package ON Booking.PackageID = Package.PackageID"
                + " INNER JOIN Tripper ON Tripper.TripperID = Booking.TripperID"
                + " WHERE Code = ?";
        result = jdbcTemplate.query(sql, BookingMapperForDetail.getInstance(), bookingCode);
        return result.get(0);
    }

    @Override
    public int getNumberTripperOfSpecificDate(String date, int packageID) {
        List<Integer> noTripper;
        String sql = "SELECT SUM(NumberOfAdults + NumberOfChilds) AS NoTripper"
                + " FROM Booking"
                + " WHERE PackageID = ? AND SelectedDate = ?"
                + " GROUP BY PackageID";
        noTripper = jdbcTemplate.query(sql, new RowMapper<Integer>() {

            @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                return rs.getInt("NoTripper");
            }
        }, packageID, date);

        return noTripper.get(0);
    }

    @Override
    public BookingEngineData getBookingEngineData(int providerID, long currentTime) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getBookingEngineData")
                .returningResultSet("rs1", ResourcesDTOMapper.getInstance())
                .returningResultSet("rs2", EnginePackageMapper.getInstance())
                //                .returningResultSet("rs3", OfflinePackageDTOMapper.getInstance())
                //                .returningResultSet("rs4", EngineBookingDTOMapper.getInstance())
                //                .returningResultSet("rs5", OfflineEngineBookingDTOMapper.getInstance())
                //                .returningResultSet("rs6", UsedResourcesViewDTOMapperForBookingEngine.getInstance());
                .returningResultSet("rs3", EngineBookingDTOMapper.getInstance())
                .returningResultSet("rs4", OfflineBookingDTOMapperForBookingEngine.getInstance())
                .returningResultSet("rs5", UsedResourcesViewDTOMapperForBookingEngine.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("providerID", providerID).addValue("currentTime", currentTime);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        List<ResourcesDTO> resources = (List<ResourcesDTO>) record.get("rs1");
        List<EnginePackageDTO> onlinePackages = (List<EnginePackageDTO>) record.get("rs2");
//        List<OfflinePackageDTO> offlinePackages = (List<OfflinePackageDTO>) record.get("rs3");
        List<EngineBookingDTO> onlineBookings = (List<EngineBookingDTO>) record.get("rs3");
        List<OfflineBookingDTO> offlineBookings = (List<OfflineBookingDTO>) record.get("rs4");
        List<UsedResourcesViewDTO> usedResources = (List<UsedResourcesViewDTO>) record.get("rs5");
//        return new BookingEngineData(resources, onlinePackages, offlinePackages, onlineBookings, offlineBookings, usedResources);
        return new BookingEngineData(resources, onlinePackages, onlineBookings, offlineBookings, usedResources);
    }

    @Override
    public void insertOfflineEngineBooking(String bookingDate, String tripDate, String tripTime, int noPackage, int packageID, String resourceNote,
            String customerName, String customerPhone, String customerEmail, String durationType, int duration, int smallestInterval, int providerID) {

        //  construct dynamic sql for used resources
        DateTimeFormatter formatterDateAndHour = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
        String travelTimeStr = tripDate;
        if (!durationType.equals("days")) {
            travelTimeStr += " " + tripTime + ":00";
        } else {
            travelTimeStr += " 00:00:00";
        }
        DateTime travelTime = formatterDateAndHour.parseDateTime(travelTimeStr);
        DateTime endTime = new DateTime(travelTime);

        if (!durationType.equals("days")) {
            // change hours to minutes
            if (durationType.equals("hours")) {
                duration *= 60;
            }
            travelTime = travelTime.minusMinutes(duration);
            endTime = endTime.plusMinutes(duration);
        } else {
            travelTime = travelTime.minusDays(duration - 1);
            endTime = endTime.plusDays(duration + 1);
        }

        // loop each 5 minutes
        DateTimeFormatter fmtDate = DateTimeFormat.forPattern("MM/dd/YYYY");
        DateTimeFormatter fmtTime = DateTimeFormat.forPattern("HH:mm");
        String valueStr = "VALUES ";
        DateTime eachTime = new DateTime(travelTime);
        String date = fmtDate.print(eachTime);
        String time = fmtTime.print(eachTime);
        valueStr += " (@ResourceIDVar,'" + date + "','" + time + "',@NoUsedResourcesVar, @providerIDVar)";
        eachTime = eachTime.plusMinutes(smallestInterval);
        while (eachTime.isBefore(endTime)) {
            date = fmtDate.print(eachTime);
            time = fmtTime.print(eachTime);
            valueStr += ",(@ResourceIDVar,'" + date + "','" + time + "',@NoUsedResourcesVar, @providerIDVar)";
            eachTime = eachTime.plusMinutes(smallestInterval);
        }

        String insertStmt = "INSERT INTO UsedResources(ResourceID, TripDate, TripTime, NoUsedResources, ProviderID) ";
        insertStmt += valueStr;

        // Build Param Condition For Procedure
        String paramCondition = "@ResourceIDVar INT, @NoUsedResourcesVar INT, @providerIDVar INT";

        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("InsertOfflineBooking");
        SqlParameterSource in = new MapSqlParameterSource().addValue("bookingDate", bookingDate).addValue("providerID", providerID)
                .addValue("tripDate", tripDate).addValue("tripTime", tripTime).addValue("noPackage", noPackage)
                .addValue("packageID", packageID).addValue("resourceNote", resourceNote).addValue("customerName", customerName)
                .addValue("customerPhone", customerPhone).addValue("customerEmail", customerEmail)
                .addValue("InsertStatement", insertStmt).addValue("ParmDefinition", paramCondition);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void insertOfflineBooking(int providerID, int days, int hours, int minutes, long bookingTime,
            long tripTime, String dateStr, String timeStr, String customerName, String customerPhone, String email,
            List<OfflineResourceDTO> offlineResources, int smallestInterval, long resourceTime) {
        DateTimeFormatter fmtDate = DateTimeFormat.forPattern("MM/dd/YYYY");
        DateTimeFormatter fmtTime = DateTimeFormat.forPattern("HH:mm");

        //  construct dynamic sql for used resources
        DateTimeFormatter formatterDateAndHour = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
        String travelTimeStr = dateStr;
        if (days == 0) {
            travelTimeStr += " " + timeStr + ":00";
        } else {
            travelTimeStr += " 00:00:00";
        }

        // insert offline resources first
        int i = 0;
        OfflineResourceDTO offlineResource = offlineResources.get(i);
        int providerResurceID = offlineResource.getProviderResourceID();
        int resourceHours = offlineResource.getHours();
        int resourceMinutes = offlineResource.getMinutes();
        int resourceDays = offlineResource.getDays();
        int noUnits = offlineResource.getNoUnits();
        String offlineResourceValue = "VALUES ";
        offlineResourceValue += "(@offlineBookingIDVar, " + providerResurceID + ","
                + noUnits + ","
                + resourceHours + "," + resourceMinutes + ","
                + resourceDays + ")";

        String usedResourceValue = "VALUES ";
        DateTime travelTime = formatterDateAndHour.parseDateTime(travelTimeStr);
        DateTime endTime = new DateTime(travelTime);
        if (resourceDays > 0) {
            endTime = endTime.plusDays(resourceDays);
        } else {
            // change hours to minutes
            int duration = resourceHours * 60 + resourceMinutes;
            endTime = endTime.plusMinutes(duration);
        }

        // loop each 5 minutes
        DateTime eachTime = new DateTime(travelTime);
        String date = fmtDate.print(eachTime);
        String time = fmtTime.print(eachTime);
        int usedResouceMinutes = eachTime.getMinuteOfDay();

        DateTime usedResourceOnlyDate = formatterDateAndHour.parseDateTime(date + " 00:00:00");
        long usedResourceMil = usedResourceOnlyDate.getMillis();
        usedResourceValue += " (" + providerResurceID + "," + usedResourceMil + "," + usedResouceMinutes + "," + noUnits + ",'"
                + date + "','" + time + "',@bookingCodeVar,@offlineBookingIDVar)";

        eachTime = eachTime.plusMinutes(smallestInterval);
        while (eachTime.isBefore(endTime)) {
            date = fmtDate.print(eachTime);
            time = fmtTime.print(eachTime);

            usedResourceOnlyDate = formatterDateAndHour.parseDateTime(date + " 00:00:00");
            usedResourceMil = usedResourceOnlyDate.getMillis();
            usedResouceMinutes = eachTime.getMinuteOfDay();
            usedResourceValue += ",(" + providerResurceID + "," + usedResourceMil + "," + usedResouceMinutes + "," + noUnits + ",'"
                    + date + "','" + time + "',@bookingCodeVar,@offlineBookingIDVar)";
            eachTime = eachTime.plusMinutes(smallestInterval);
        }

        i++;
        int resourceLength = offlineResources.size();
        for (; i < resourceLength; i++) {
            offlineResource = offlineResources.get(i);
            providerResurceID = offlineResource.getProviderResourceID();
            resourceHours = offlineResource.getHours();
            resourceMinutes = offlineResource.getMinutes();
            resourceDays = offlineResource.getDays();
            noUnits = offlineResource.getNoUnits();
            offlineResourceValue += ",(@offlineBookingIDVar, " + providerResurceID + ","
                    + noUnits + ","
                    + resourceHours + "," + resourceMinutes + ","
                    + resourceDays + ")";

            travelTime = formatterDateAndHour.parseDateTime(travelTimeStr);
            endTime = new DateTime(travelTime);
            if (resourceDays > 0) {
                endTime = endTime.plusDays(resourceDays);
            } else {

                // change hours to minutes
                int duration = resourceHours * 60 + resourceMinutes;
                endTime = endTime.plusMinutes(duration);
            }

            // loop each 5 minutes
            eachTime = new DateTime(travelTime);
            date = fmtDate.print(eachTime);
            time = fmtTime.print(eachTime);

            usedResouceMinutes = eachTime.getMinuteOfDay();

            usedResourceOnlyDate = formatterDateAndHour.parseDateTime(date + " 00:00:00");
            usedResourceMil = usedResourceOnlyDate.getMillis();
            usedResourceValue += ",(" + providerResurceID + "," + usedResourceMil + "," + usedResouceMinutes + "," + noUnits + ",'"
                    + date + "','" + time + "',@bookingCodeVar,@offlineBookingIDVar)";

            eachTime = eachTime.plusMinutes(smallestInterval);
            while (eachTime.isBefore(endTime)) {
                date = fmtDate.print(eachTime);
                time = fmtTime.print(eachTime);

                usedResourceOnlyDate = formatterDateAndHour.parseDateTime(date + " 00:00:00");
                usedResourceMil = usedResourceOnlyDate.getMillis();
                usedResouceMinutes = eachTime.getMinuteOfDay();
                usedResourceValue += ",(" + providerResurceID + "," + usedResourceMil + "," + usedResouceMinutes + "," + noUnits + ",'"
                        + date + "','" + time + "',@bookingCodeVar,@offlineBookingIDVar)";
                eachTime = eachTime.plusMinutes(smallestInterval);
            }
        }

        String resourceInsertingStmt = "INSERT INTO OfflineResource(OfflineBookingID, ProviderResourceID, NoUnits,"
                + "Hours, Minutes,Days) ";
        resourceInsertingStmt += offlineResourceValue;
        String resourceInsertingParmDefinition = "@offlineBookingIDVar INT";

        String usedResourceInsertingStmt = "INSERT INTO UsedProviderResource(ProviderResourceID, Date, Time, NoUsedResources,"
                + "DateStr,TimeStr,BookingCode,OfflineBookingID)";
        usedResourceInsertingStmt += usedResourceValue;
        String usedResourceInsertingParmDefinition = "@bookingCodeVar NVARCHAR(10),"
                + "@offlineBookingIDVar INT";

        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("InsertNewOfflineBooking");
        SqlParameterSource in = new MapSqlParameterSource().addValue("days", days).addValue("minutes", minutes).addValue("hours", hours)
                .addValue("bookingTime", bookingTime).addValue("tripTime", tripTime).addValue("dateStr", dateStr)
                .addValue("timeStr", timeStr).addValue("customerName", customerName).addValue("customerPhone", customerPhone)
                .addValue("customerPhone", customerPhone).addValue("email", email)
                .addValue("providerID", providerID).addValue("ResourceInsertingStmt", resourceInsertingStmt)
                .addValue("ResourceInsertingParmDefinition", resourceInsertingParmDefinition)
                .addValue("UsedResourceInsertingStmt", usedResourceInsertingStmt)
                .addValue("UsedResourceInsertingParmDefinition", usedResourceInsertingParmDefinition);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void insertOnlineEngineBooking(String bookingDate, String tripDate, String tripTime, int noPackage, int packageID, String resourceNote,
            String bookingCode, String customerName, String customerPhone, String customerEmail, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("InsertOnlineBooking");
        SqlParameterSource in = new MapSqlParameterSource().addValue("bookingDate", bookingDate)
                .addValue("tripDate", tripDate).addValue("tripTime", tripTime).addValue("noPackage", noPackage)
                .addValue("packageID", packageID).addValue("resourceNote", resourceNote).addValue("providerID", providerID).addValue("customerName", customerName)
                .addValue("customerPhone", customerPhone).addValue("customerEmail", customerEmail).addValue("bookingCode", bookingCode);
        simpleJdbcCall.execute(in);
    }

    @Override
    public List<OfflinePackageDTO> addOfflinePackageAndReturnNewList(String packageName, int resourceID, int mimimumNoResources, int duration,
            String durationType, String createdPackageDate, int providerID) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("AddOfflinePackage")
                .returningResultSet("rs1", OfflinePackageDTOMapper.getInstance());
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageName", packageName).addValue("ResourceID", resourceID)
                .addValue("MinimumNoResource", mimimumNoResources).addValue("Duration", duration).addValue("DurationType", durationType)
                .addValue("createdPackageDate", createdPackageDate).addValue("providerID", providerID);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        return (List<OfflinePackageDTO>) record.get("rs1");
    }

    @Override
    public boolean isJointBooked(int packageID, String tripDate, String tripTime) {
        simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("isJointBooked");
        SqlParameterSource in = new MapSqlParameterSource().addValue("packageID", packageID)
                .addValue("tripDate", tripDate).addValue("tripTime", tripTime);
        Map<String, Object> record = simpleJdbcCall.execute(in);
        Boolean isAvailable = (Boolean) record.get("isBooked");
        return isAvailable;
    }

}
