/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Nick
 */
public class BookingUserList {

    private HashMap<Integer, String> packages;
    private List<DateBookingDetail> details;

    public BookingUserList() {
    }

    public BookingUserList(HashMap<Integer, String> packages, List<DateBookingDetail> details) {
        this.packages = packages;
        this.details = details;
    }

    public HashMap<Integer, String> getPackages() {
        return packages;
    }

    public void setPackages(HashMap<Integer, String> packages) {
        this.packages = packages;
    }

    public List<DateBookingDetail> getDetails() {
        return details;
    }

    public void setDetails(List<DateBookingDetail> details) {
        this.details = details;
    }

}
