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
public class BusinessTypeDTO {
    private int businessTypeID;
    private String type;

    public BusinessTypeDTO() {
    }

    public BusinessTypeDTO(int businessTypeID, String type) {
        this.businessTypeID = businessTypeID;
        this.type = type;
    }

    public int getBusinessTypeID() {
        return businessTypeID;
    }

    public void setBusinessTypeID(int businessTypeID) {
        this.businessTypeID = businessTypeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

  
}
