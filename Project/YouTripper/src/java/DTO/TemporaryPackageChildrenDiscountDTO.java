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
public class TemporaryPackageChildrenDiscountDTO {
    private int temporaryPackageID;
    private int childrenDiscountID;

    public TemporaryPackageChildrenDiscountDTO(int temporaryPackageID, int childrenDiscountID) {
        this.temporaryPackageID = temporaryPackageID;
        this.childrenDiscountID = childrenDiscountID;
    }
    
    public int getTemporaryPackageID() {
        return temporaryPackageID;
    }

    public void setTemporaryPackageID(int temporaryPackageID) {
        this.temporaryPackageID = temporaryPackageID;
    }

    public int getChildrenDiscountID() {
        return childrenDiscountID;
    }

    public void setChildrenDiscountID(int childrenDiscountID) {
        this.childrenDiscountID = childrenDiscountID;
    }

   
    
}
