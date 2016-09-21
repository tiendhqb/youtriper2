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
public class DisabledDiscountDTO {

    private int disabledDiscountID;
    private String condition;
    private int discountPercent;
    private int providerID;
    private int packageID;

    public DisabledDiscountDTO(int disabledDiscountID, String condition, int discountPercent, int providerID) {
        this.disabledDiscountID = disabledDiscountID;
        this.condition = condition;
        this.discountPercent = discountPercent;
        this.providerID = providerID;
    }

    public DisabledDiscountDTO(int disabledDiscountID, String condition, int discountPercent) {
        this.disabledDiscountID = disabledDiscountID;
        this.condition = condition;
        this.discountPercent = discountPercent;
    }

    public DisabledDiscountDTO(int packageID, int disabledDiscountID) {
        this.packageID = packageID;
        this.disabledDiscountID = disabledDiscountID;
    }

    public int getDisabledDiscountID() {
        return disabledDiscountID;
    }

    public void setDisabledDiscountID(int disabledDiscountID) {
        this.disabledDiscountID = disabledDiscountID;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

}
