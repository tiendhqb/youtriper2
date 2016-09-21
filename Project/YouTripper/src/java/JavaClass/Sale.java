/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

/**
 *
 * @author Nick
 */
public class Sale {

    private String bookingDate;
    private int tripperID;
    private String tripperName;
    private int packageID;
    private String packageName;
    private int status;
    private double revenue;

    public Sale() {
    }

    public Sale(String bookingDate, int tripperID, String tripperName, int packageID, String packageName, int status, double revenue) {
        this.bookingDate = bookingDate;
        this.tripperID = tripperID;
        this.tripperName = tripperName;
        this.packageID = packageID;
        this.packageName = packageName;
        this.status = status;
        this.revenue = revenue;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getTripperID() {
        return tripperID;
    }

    public void setTripperID(int tripperID) {
        this.tripperID = tripperID;
    }

    public String getTripperName() {
        return tripperName;
    }

    public void setTripperName(String tripperName) {
        this.tripperName = tripperName;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

}
