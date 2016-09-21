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
public class RemindReviewEmail {
    private String code;
    private String selectedDate;
    private String email;
    private String lastName;
    private int packageID;
    private int durationType;
    private int duration;

    public RemindReviewEmail(String code, String selectedDate, String email, String lastName, int packageID, int durationType, int duration) {
        this.code = code;
        this.selectedDate = selectedDate;
        this.email = email;
        this.lastName = lastName;
        this.packageID = packageID;
        this.durationType = durationType;
        this.duration = duration;
    }

    public String getCode() {
        return code;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPackageID() {
        return packageID;
    }

    public int getDurationType() {
        return durationType;
    }

    public int getDuration() {
        return duration;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public void setDurationType(int durationType) {
        this.durationType = durationType;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
}
