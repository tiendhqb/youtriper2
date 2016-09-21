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
public class SuitabilityDTO {

    private int temporaryPackageID;
    private int suitabilityID;
    private String suitabilityName;

    public SuitabilityDTO() {
    }

    public SuitabilityDTO(int temporaryPackageID, int suitabilityID, String suitabilityName) {
        this.temporaryPackageID = temporaryPackageID;
        this.suitabilityID = suitabilityID;
        this.suitabilityName = suitabilityName;
    }

    public SuitabilityDTO(String suitabilityName) {
        this.suitabilityName = suitabilityName;
    }

    public int getTemporaryPackageID() {
        return temporaryPackageID;
    }

    public void setTemporaryPackageID(int temporaryPackageID) {
        this.temporaryPackageID = temporaryPackageID;
    }

    public int getSuitabilityID() {
        return suitabilityID;
    }

    public void setSuitabilityID(int suitabilityID) {
        this.suitabilityID = suitabilityID;
    }

    public String getSuitabilityName() {
        return suitabilityName;
    }

    public void setSuitabilityName(String suitabilityName) {
        this.suitabilityName = suitabilityName;
    }
    
    
}
