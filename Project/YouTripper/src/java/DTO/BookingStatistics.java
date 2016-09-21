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
public class BookingStatistics {
    private int numberOfBooking;
    private int numberOfTripper;
    private int maxQuota;
    private int pending;
    private int completed;

    public BookingStatistics(int numberOfBooking, int numberOfTripper, int maxQuota, int pending, int completed) {
        this.numberOfBooking = numberOfBooking;
        this.numberOfTripper = numberOfTripper;
        this.maxQuota = maxQuota;
        this.pending = pending;
        this.completed = completed;
    }

    public int getNumberOfBooking() {
        return numberOfBooking;
    }

    public int getNumberOfTripper() {
        return numberOfTripper;
    }

    public int getMaxQuota() {
        return maxQuota;
    }

    public int getPending() {
        return pending;
    }

    public int getCompleted() {
        return completed;
    }

    public void setNumberOfBooking(int numberOfBooking) {
        this.numberOfBooking = numberOfBooking;
    }

    public void setNumberOfTripper(int numberOfTripper) {
        this.numberOfTripper = numberOfTripper;
    }

    public void setMaxQuota(int maxQuota) {
        this.maxQuota = maxQuota;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }
    
}
