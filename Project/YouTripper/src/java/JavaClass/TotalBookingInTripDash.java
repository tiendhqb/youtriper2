/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

/**
 *
 * @author DINH KHANG
 */
public class TotalBookingInTripDash {
    private int noBookedResources;
    private int noFilledQuotas;
    private int totalBookings;
    private int totalSale;

    public TotalBookingInTripDash() {
    }
    
    public TotalBookingInTripDash(int noBookedResources, int noFilledQuotas, int totalBookings, int totalSale) {
        this.noBookedResources = noBookedResources;
        this.noFilledQuotas = noFilledQuotas;
        this.totalBookings = totalBookings;
        this.totalSale = totalSale;
    }
    
    public int getNoBookedResources() {
        return noBookedResources;
    }

    public void setNoBookedResources(int noBookedResources) {
        this.noBookedResources = noBookedResources;
    }

    public int getNoFilledQuotas() {
        return noFilledQuotas;
    }

    public void setNoFilledQuotas(int noFilledQuotas) {
        this.noFilledQuotas = noFilledQuotas;
    }

    public int getTotalBookings() {
        return totalBookings;
    }

    public void setTotalBookings(int totalBookings) {
        this.totalBookings = totalBookings;
    }

    public int getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(int totalSale) {
        this.totalSale = totalSale;
    }
    
    
}
