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
public class ProviderPayment {
    private int providerID;
    private String lastName;
    private String image;
    private double total;

    public ProviderPayment(int providerID, String lastName, String image, double total) {
        this.providerID = providerID;
        this.lastName = lastName;
        this.image = image;
        this.total = total;
    }

    public int getProviderID() {
        return providerID;
    }

    public String getLastName() {
        return lastName;
    }

    public double getTotal() {
        return total;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }    
   
    
}
