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
public class ReportDTO {
    private int reportID;
    private String date;
    private String report;
    private String userType;
    private int tripperID;
    private int providerID;

    public ReportDTO(int reportID, String date, String report, String userType, int tripperID, int providerID) {
        this.reportID = reportID;
        this.date = date;
        this.report = report;
        this.userType = userType;
        this.tripperID = tripperID;
        this.providerID = providerID;
    }

    public int getReportID() {
        return reportID;
    }

    public String getDate() {
        return date;
    }

    public String getReport() {
        return report;
    }

    public String getUserType() {
        return userType;
    }

    public int getTripperID() {
        return tripperID;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setTripperID(int tripperID) {
        this.tripperID = tripperID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }
    
}
