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
public class PriceDTO {
    private int id;
    private int packageID;
    private String date;
    private double amountForChild;
    private double amountForAdult;

    public PriceDTO() {
    }

    public PriceDTO(int id, int packageID, String date, double amountForChild, double amountForAdult) {
        this.id = id;
        this.packageID = packageID;
        this.date = date;
        this.amountForChild = amountForChild;
        this.amountForAdult = amountForAdult;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmountForChild() {
        return amountForChild;
    }

    public void setAmountForChild(double amountForChild) {
        this.amountForChild = amountForChild;
    }

    public double getAmountForAdult() {
        return amountForAdult;
    }

    public void setAmountForAdult(double amountForAdult) {
        this.amountForAdult = amountForAdult;
    }
    
    
}
