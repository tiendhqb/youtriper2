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
public class BookingStatisticsInTrippDash {
    private int noBookings;
    private long selectedDateMilliseconds;
    private String selectedDate;

    public BookingStatisticsInTrippDash(int noBookings, long selectedDateMilliseconds, String selectedDate) {
        this.noBookings = noBookings;
        this.selectedDateMilliseconds = selectedDateMilliseconds;
        this.selectedDate = selectedDate;
    }
    
    public int getNoBookings() {
        return noBookings;
    }

    public void setNoBookings(int noBookings) {
        this.noBookings = noBookings;
    }

    public long getSelectedDateMilliseconds() {
        return selectedDateMilliseconds;
    }

    public void setSelectedDateMilliseconds(long selectedDateMilliseconds) {
        this.selectedDateMilliseconds = selectedDateMilliseconds;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }
    
    
}
