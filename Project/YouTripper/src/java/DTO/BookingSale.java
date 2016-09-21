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
public class BookingSale {
    private double balance;
    private int tripCompleted;
    private int bookingTime;

    public BookingSale(double balance, int tripCompleted, int bookingTime) {
        this.balance = balance;
        this.tripCompleted = tripCompleted;
        this.bookingTime = bookingTime;
    }

    public double getBalance() {
        return balance;
    }

    public int getTripCompleted() {
        return tripCompleted;
    }

    public int getBookingTime() {
        return bookingTime;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTripCompleted(int tripCompleted) {
        this.tripCompleted = tripCompleted;
    }

    public void setBookingTime(int bookingTime) {
        this.bookingTime = bookingTime;
    }
    
}
