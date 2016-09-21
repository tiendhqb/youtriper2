/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.BookingDTO;
import DTO.OfflinePackageDTO;
import DTO.OfflineResourceDTO;
import DTO.SaleInfo;
import JavaClass.BookingEngineData;
import java.util.List;

/**
 *
 * @author DINH KHANG
 */
public interface BookingDAO {

    public List<BookingDTO> getAllBookings();

    public List<BookingDTO> getBookingByCode(int code);

    public boolean deleteBookingofCode(int code);

    public boolean insertNewBooking(BookingDTO bookingDTO);

    public boolean isBookingCodeExist(String code);

    public List<BookingDTO> getBookingListByTripperID(int tripperID);

    public List<BookingDTO> getBookingListByProviderID(int providerID);

    public List<BookingDTO> getBookingListForStatictis(int packageID);

    public SaleInfo getSaleInfo(int providerID);

    public List<BookingDTO> getBookingForTripper(int tripperID);

    public int getTripperIDByBookingCode(String bookingCode);

    public int getProviderIDByBookingCode(String bookingCode);

    public List<BookingDTO> getSales(int packageID, int providerID);

    public BookingDTO getBookingDetail(String bookingCode);

    public int getNumberTripperOfSpecificDate(String date, int packageID);

    public BookingEngineData getBookingEngineData(int providerID, long currentTime);

    public void insertOfflineEngineBooking(String bookingDate, String tripDate, String tripTime, int noPackage, int packageID, String resourceNote,
            String customerName, String customerPhone, String customerEmail, String durationType, int duration, int smallestInterval, int providerID);

    public List<OfflinePackageDTO> addOfflinePackageAndReturnNewList(String packageName, int resourceID, int mimimumNoResources, int duration,
            String durationType, String createdPackageDate, int providerID);

    public void insertOnlineEngineBooking(String bookingDate, String tripDate, String tripTime, int noPackage, int packageID, String resourceNote,
            String bookingCode, String customerName, String customerPhone, String customerEmail, int providerID);

    public boolean isJointBooked(int packageID, String tripDate, String tripTime);

    public void insertOfflineBooking(int providerID, int days, int hours, int minutes, long bookingTime, long tripTime,
            String dateStr, String timeStr, String customerName, String customerPhone, String email, List<OfflineResourceDTO> offlineResources,
            int smallestInterval, long resourceTime);
}
