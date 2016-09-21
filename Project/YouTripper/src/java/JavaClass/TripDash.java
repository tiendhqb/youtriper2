/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

import DTO.PackageDTO;
import java.util.List;

/**
 *
 * @author DINH KHANG
 */
public class TripDash {
    private List<BookingDetailInTripDash> bookingDetailInTripDash;
    private TotalBookingInTripDash totalBookingInTripDash;
    private List<ListBookingInTripDash> listBookingInTripDash;    
    private HighestPackageInTripDash highestPackageInTripDash;
    private LowestPackageInTripDash lowestPackageInTripDash;
    private RevenueStatisticsInTrippDash revenueStatisticsInTrippDash;
    private int maxDataResource;
    private List<PackageDTO> packageList;

    public TripDash() {
    }

    public TripDash(List<BookingDetailInTripDash> bookingDetailInTripDash, TotalBookingInTripDash totalBookingInTripDash, List<ListBookingInTripDash> listBookingInTripDash, HighestPackageInTripDash highestPackageInTripDash, LowestPackageInTripDash lowestPackageInTripDash, RevenueStatisticsInTrippDash revenueStatisticsInTrippDash, int maxDataResource, List<PackageDTO> packageList) {
        this.bookingDetailInTripDash = bookingDetailInTripDash;
        this.totalBookingInTripDash = totalBookingInTripDash;
        this.listBookingInTripDash = listBookingInTripDash;
        this.highestPackageInTripDash = highestPackageInTripDash;
        this.lowestPackageInTripDash = lowestPackageInTripDash;
        this.revenueStatisticsInTrippDash = revenueStatisticsInTrippDash;
        this.maxDataResource = maxDataResource;
        this.packageList = packageList;
    }

    public List<BookingDetailInTripDash> getBookingDetailInTripDash() {
        return bookingDetailInTripDash;
    }

    public void setBookingDetailInTripDash(List<BookingDetailInTripDash> bookingDetailInTripDash) {
        this.bookingDetailInTripDash = bookingDetailInTripDash;
    }

    public TotalBookingInTripDash getTotalBookingInTripDash() {
        return totalBookingInTripDash;
    }

    public void setTotalBookingInTripDash(TotalBookingInTripDash totalBookingInTripDash) {
        this.totalBookingInTripDash = totalBookingInTripDash;
    }

    public List<ListBookingInTripDash> getListBookingInTripDash() {
        return listBookingInTripDash;
    }

    public void setListBookingInTripDash(List<ListBookingInTripDash> listBookingInTripDash) {
        this.listBookingInTripDash = listBookingInTripDash;
    }

    public HighestPackageInTripDash getHighestPackageInTripDash() {
        return highestPackageInTripDash;
    }

    public void setHighestPackageInTripDash(HighestPackageInTripDash highestPackageInTripDash) {
        this.highestPackageInTripDash = highestPackageInTripDash;
    }

    public LowestPackageInTripDash getLowestPackageInTripDash() {
        return lowestPackageInTripDash;
    }

    public void setLowestPackageInTripDash(LowestPackageInTripDash lowestPackageInTripDash) {
        this.lowestPackageInTripDash = lowestPackageInTripDash;
    }

    public int getMaxDataResource() {
        return maxDataResource;
    }

    public void setMaxDataResource(int maxDataResource) {
        this.maxDataResource = maxDataResource;
    }

    public RevenueStatisticsInTrippDash getRevenueStatisticsInTrippDash() {
        return revenueStatisticsInTrippDash;
    }

    public void setRevenueStatisticsInTrippDash(RevenueStatisticsInTrippDash revenueStatisticsInTrippDash) {
        this.revenueStatisticsInTrippDash = revenueStatisticsInTrippDash;
    }

    public List<PackageDTO> getPackageList() {
        return packageList;
    }

    public void setPackageList(List<PackageDTO> packageList) {
        this.packageList = packageList;
    }
    
}
