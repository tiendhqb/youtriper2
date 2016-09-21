/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Nick
 */
public class ReviewDTO {
    private int tripperID;
    private String tripperName;
    private int packageID;
    private String review;
    private double rate;
    private String date;
    private int totalRecords;
    private String packageName;
    private String tripperImage;
    private String coverImage;
    private int professionlism;
    private int staffAttitude;
    private int convenient;
    private int satisfaction;
    private int amenityQuality;
    private int cleanliness;

    public ReviewDTO() {
    }

    public ReviewDTO(int tripperID, int packageID, String review, double rate, String date) {
        this.tripperID = tripperID;
        this.packageID = packageID;
        this.review = review;
        this.rate = rate;
        this.date = date;
    }

    public ReviewDTO(int packageID, String packageName, String coverImage, int professionlism, int staffAttitude, int convenient, int satisfaction, int amenityQuality, int cleanliness) {
        this.packageID = packageID;
        this.packageName = packageName;
        this.coverImage = coverImage;
        this.professionlism = professionlism;
        this.staffAttitude = staffAttitude;
        this.convenient = convenient;
        this.satisfaction = satisfaction;
        this.amenityQuality = amenityQuality;
        this.cleanliness = cleanliness;
    }

    public ReviewDTO(int tripperID, String tripperName, int packageID, String review, double rate, String date, int totalRecords) {
        this.tripperID = tripperID;
        this.tripperName = tripperName;
        this.packageID = packageID;
        this.review = review;
        this.rate = rate;
        this.date = date;
        this.totalRecords = totalRecords;
    }

    public ReviewDTO(int tripperID, String tripperName, int packageID, String review, double rate, String date, int totalRecords, String tripperImage) {
        this.tripperID = tripperID;
        this.tripperName = tripperName;
        this.packageID = packageID;
        this.review = review;
        this.rate = rate;
        this.date = date;
        this.totalRecords = totalRecords;
        this.packageName = packageName;
        this.tripperImage = tripperImage;
    }

    
    

    public int getTripperID() {
        return tripperID;
    }

    public void setTripperID(int tripperID) {
        this.tripperID = tripperID;
    }

    public String getTripperName() {
        return tripperName;
    }

    public void setTripperName(String tripperName) {
        this.tripperName = tripperName;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getTripperImage() {
        return tripperImage;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setTripperImage(String tripperImage) {
        this.tripperImage = tripperImage;
    }
    
    
}
