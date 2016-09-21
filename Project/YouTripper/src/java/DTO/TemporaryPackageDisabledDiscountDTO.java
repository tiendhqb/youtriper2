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
public class TemporaryPackageDisabledDiscountDTO {
    private int temporaryPackageID;
    private int disabledDiscountID;

    public TemporaryPackageDisabledDiscountDTO(int temporaryPackageID, int disabledDiscountID) {
        this.temporaryPackageID = temporaryPackageID;
        this.disabledDiscountID = disabledDiscountID;
    }
    
    public int getTemporaryPackageID() {
        return temporaryPackageID;
    }

    public void setTemporaryPackageID(int temporaryPackageID) {
        this.temporaryPackageID = temporaryPackageID;
    }

    public int getDisabledDiscountID() {
        return disabledDiscountID;
    }

    public void setDisabledDiscountID(int disabledDiscountID) {
        this.disabledDiscountID = disabledDiscountID;
    }
    
    
}
