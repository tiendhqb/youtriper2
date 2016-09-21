/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DINH KHANG
 */
public class PackageSale {
    private int packageID;
    private String packageName;
    private int numberOfBooking;
    private int completedBooking;
    private String endDay;
    private double Revenue;
    private String paymentDue;

    public PackageSale(int packageID, String packageName, int numberOfBooking, int completedBooking, String endDay, double Revenue, String paymentDue) {
        this.packageID = packageID;
        this.packageName = packageName;
        this.numberOfBooking = numberOfBooking;
        this.completedBooking = completedBooking;
        this.endDay = endDay;
        this.Revenue = Revenue;
        this.paymentDue = paymentDue;
    }


    public int getPackageID() {
        return packageID;
    }

    public String getPackageName() {
        return packageName;
    }

    public int getNumberOfBooking() {
        return numberOfBooking;
    }

    public int getCompletedBooking() {
        return completedBooking;
    }

    public String getEndDay() {
        return endDay;
    }

    public double getRevenue() {
        return Revenue;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setNumberOfBooking(int numberOfBooking) {
        this.numberOfBooking = numberOfBooking;
    }

    public void setCompletedBooking(int completedBooking) {
        this.completedBooking = completedBooking;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public void setRevenue(double Revenue) {
        this.Revenue = Revenue;
    }

    public String getPaymentDeal() {
        return paymentDue;
    }

    public void setPaymentDeal(String paymentDeal) {
        this.paymentDue = paymentDeal;
    }
    
    
}
