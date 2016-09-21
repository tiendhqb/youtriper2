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
public class CertificateDTO {
    private int certificateID;
    private int providerID;
    private String image;
    private String name;
    private String providerName;
    private boolean isApproved;

    public CertificateDTO() {
    }

    public CertificateDTO(int certificateID, int providerID, String image) {
        this.certificateID = certificateID;
        this.providerID = providerID;
        this.image = image;
    }
    
   

    public CertificateDTO(int certificateID, int providerID, String image, String name, String providerName) {
        this.certificateID = certificateID;
        this.providerID = providerID;
        this.image = image;
        this.name = name;
        this.providerName = providerName;
    }
    
    public CertificateDTO(int certificateID, String image, String name) {
        this.certificateID = certificateID;
        this.image = image;
        this.name = name;
    }
    
    public CertificateDTO(int certificateID, String image, String name, boolean isApproved) {
        this.certificateID = certificateID;
        this.image = image;
        this.name = name;
        this.isApproved = isApproved;
    }

    public CertificateDTO(String image, boolean isApproved) {
        this.image = image;
        this.isApproved = isApproved;
    }
    
    public int getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(int certificateID) {
        this.certificateID = certificateID;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the providerName
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * @param providerName the providerName to set
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public boolean isIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
    
    
    
}
