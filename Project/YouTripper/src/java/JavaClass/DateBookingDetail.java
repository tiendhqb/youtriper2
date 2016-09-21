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
public class DateBookingDetail {

    private int tripperID;
    private String tripperFirstName;
    private String tripperLastName;
    private String tripperImage;
    private int packageID;
    private String packageName;
    private int noTripper;
    private String bookingDate;
    private String bookingCode;

    public DateBookingDetail() {
    }

    public DateBookingDetail(int tripperID, String tripperFirstName, String tripperLastName, String tripperImage, int packageID, 
            String packageName, int noTripper, String bookingDate, String bookingCode) {
        this.tripperID = tripperID;
        this.tripperFirstName = tripperFirstName;
        this.tripperLastName = tripperLastName;
        this.tripperImage = tripperImage;
        this.packageID = packageID;
        this.packageName = packageName;
        this.noTripper = noTripper;
        this.bookingDate = bookingDate;
        this.bookingCode = bookingCode;
    }

    public int getTripperID() {
        return tripperID;
    }

    public void setTripperID(int tripperID) {
        this.tripperID = tripperID;
    }

    public String getTripperFirstName() {
        return tripperFirstName;
    }

    public void setTripperFirstName(String tripperFirstName) {
        this.tripperFirstName = tripperFirstName;
    }

    public String getTripperLastName() {
        return tripperLastName;
    }

    public void setTripperLastName(String tripperLastName) {
        this.tripperLastName = tripperLastName;
    }

    public String getTripperImage() {
        return tripperImage;
    }

    public void setTripperImage(String tripperImage) {
        this.tripperImage = tripperImage;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getNoTripper() {
        return noTripper;
    }

    public void setNoTripper(int noTripper) {
        this.noTripper = noTripper;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }
    
    

}
