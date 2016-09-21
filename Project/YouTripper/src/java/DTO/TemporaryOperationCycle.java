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
public class TemporaryOperationCycle {

    private int cycleID;
    private int packageID;
    private String startDate;
    private String endDate;

    public TemporaryOperationCycle() {
    }

    public TemporaryOperationCycle(int cycleID, int packageID, String startDate, String endDate) {
        this.cycleID = cycleID;
        this.packageID = packageID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TemporaryOperationCycle(int cycleID, String startDate, String endDate) {
        this.cycleID = cycleID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TemporaryOperationCycle(String startDate, String endDate) {
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
