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
public class BookingDetailAllDate {

    private String selectedDate;
    private int noBookings;
    private int noTrippers;

    public BookingDetailAllDate() {
    }

    public BookingDetailAllDate(String selectedDate, int noBookings, int noTrippers) {
        this.selectedDate = selectedDate;
        this.noBookings = noBookings;
        this.noTrippers = noTrippers;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public int getNoBookings() {
        return noBookings;
    }

    public void setNoBookings(int noBookings) {
        this.noBookings = noBookings;
    }

    public int getNoTrippers() {
        return noTrippers;
    }

    public void setNoTrippers(int noTrippers) {
        this.noTrippers = noTrippers;
    }

}
