/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.List;

/**
 *
 * @author DINH KHANG
 */
public class TripperDTO {
    private int tripperID;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String image;
    private String phoneNumber;
    private String address;
    private String countryName;
    private String interest;
    private String information;
    private String Language;
    private boolean active;
    private String activeDate;
    private boolean gender;
    private int countryID;
    List<ReviewDTO> reviewList;
    List<PackagesViewDTO> bucketList;
    List<PackagesViewDTO> bookingList;
    private boolean notification;
    
    public TripperDTO(int tripperID, String email, String password, String firstName, String lastName, String birthDay, String image, String phoneNumber, String address, String interest, String information, String Language, boolean active, String activeDate, boolean gender) {
        this.tripperID = tripperID;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.interest = interest;
        this.information = information;
        this.Language = Language;
        this.active = active;
        this.activeDate = activeDate;
        this.gender = gender;
    }

    public TripperDTO(int tripperID, String email, String password, String firstName, String lastName, String birthDay, String image, String phoneNumber, String address, String countryName, String interest, String information, String Language, boolean active, String activeDate, boolean gender,boolean notification) {
        this.tripperID = tripperID;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.countryName = countryName;
        this.interest = interest;
        this.information = information;
        this.Language = Language;
        this.active = active;
        this.activeDate = activeDate;
        this.gender = gender;
        this.notification = notification;
    }
//tripper view page
    public TripperDTO(int tripperID, String firstName, String lastName, String image, String address, String information,boolean active,String activeDate,String Language) {
        this.tripperID = tripperID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        this.address = address;
        this.information = information;
        this.active = active;
        this.activeDate = activeDate;
        this.Language = Language;
        
    }
    
    public int getTripperID() {
        return tripperID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getImage() {
        return image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getInterest() {
        return interest;
    }

    public String getInformation() {
        return information;
    }

    public String getLanguage() {
        return Language;
    }

    public boolean isActive() {
        return active;
    }

    public String getActiveDate() {
        return activeDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setTripperID(int tripperID) {
        this.tripperID = tripperID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }



    public String getCountryName() {
        return countryName;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public List<ReviewDTO> getReviewList() {
        return reviewList;
    }

    public List<PackagesViewDTO> getBucketList() {
        return bucketList;
    }

    public void setBucketList(List<PackagesViewDTO> bucketList) {
        this.bucketList = bucketList;
    }

    public List<PackagesViewDTO> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<PackagesViewDTO> bookingList) {
        this.bookingList = bookingList;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    public void setReviewList(List<ReviewDTO> reviewList) {
        this.reviewList = reviewList;
    }


}
