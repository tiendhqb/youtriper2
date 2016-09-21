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
public class ListBookingInTripDash {
private int noTrippers;
private boolean isOffline;
private String buyerName;
private String lastName;
private String selectedDate;
private long selectedDateMilliseconds;
private String packageTitle;
private String offlineType;
private String packageType;

    public ListBookingInTripDash() {
    }

    public ListBookingInTripDash(int noTrippers, boolean isOffline, String buyerName, String lastName, String selectedDate, long selectedDateMilliseconds, String packageTitle, String offlineType, String packageType) {
        this.noTrippers = noTrippers;
        this.isOffline = isOffline;
        this.buyerName = buyerName;
        this.lastName = lastName;
        this.selectedDate = selectedDate;
        this.selectedDateMilliseconds = selectedDateMilliseconds;
        this.packageTitle = packageTitle;
        this.offlineType = offlineType;
        this.packageType = packageType;
    }

    public int getNoTrippers() {
        return noTrippers;
    }

    public void setNoTrippers(int noTrippers) {
        this.noTrippers = noTrippers;
    }

    public boolean isIsOffline() {
        return isOffline;
    }

    public void setIsOffline(boolean isOffline) {
        this.isOffline = isOffline;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public long getSelectedDateMilliseconds() {
        return selectedDateMilliseconds;
    }

    public void setSelectedDateMilliseconds(long selectedDateMilliseconds) {
        this.selectedDateMilliseconds = selectedDateMilliseconds;
    }

    public String getPackageTitle() {
        return packageTitle;
    }

    public void setPackageTitle(String packageTitle) {
        this.packageTitle = packageTitle;
    }

    public String getOfflineType() {
        return offlineType;
    }

    public void setOfflineType(String offlineType) {
        this.offlineType = offlineType;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }


}
