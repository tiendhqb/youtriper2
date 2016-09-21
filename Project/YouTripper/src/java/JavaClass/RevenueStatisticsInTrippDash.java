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
public class RevenueStatisticsInTrippDash {
    private float revenue;
    private long selectedDateMilliseconds;
    private String selectedDate;

    public RevenueStatisticsInTrippDash(float revenue, long selectedDateMilliseconds, String selectedDate) {
        this.revenue = revenue;
        this.selectedDateMilliseconds = selectedDateMilliseconds;
        this.selectedDate = selectedDate;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
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
