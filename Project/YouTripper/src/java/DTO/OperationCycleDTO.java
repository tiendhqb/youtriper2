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
public class OperationCycleDTO {
    private int cycleID;
    private int packageID;
    private String startDate;
    private String endDate;

    public OperationCycleDTO() {
    }

    public OperationCycleDTO(int cycleID, int packageID, String startDate, String endDate) {
        this.cycleID = cycleID;
        this.packageID = packageID;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public OperationCycleDTO(int cycleID, String startDate, String endDate) {
        this.cycleID = cycleID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public OperationCycleDTO(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public int getCycleID() {
        return cycleID;
    }

    public void setCycleID(int cycleID) {
        this.cycleID = cycleID;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
}
